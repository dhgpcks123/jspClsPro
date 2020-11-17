INSERT INTO
    fileinfo(fno, fbno, oriname, savename, dir, len)
VALUES(
    (SELECT NVL(MAX(fno)+1, 1000001) FROM fileinfo),
    ?, ?, ?, '/img/upload/', ?
);

--서브질의로 뽑기
SELECT
    max(bno)
FROM
    board
WHERE
    bmno = (
                SELECT mno FROM member WHERE id = 'dhgpcks'
            )
;

SELECT
    max(bno)
FROM
    board, member
WHERE
    bmno = mno
    AND id = 'dhgpcks'
;

    -->

INSERT INTO
    fileinfo(fno, fbno, dir, oriname, savename, len)
VALUES(
    (SELECT NVL(MAX(fno)+1, 1000001) FROM fileinfo),
    (
        SELECT
            max(bno)
        FROM
            board, member
        WHERE
            bmno = mno
            AND id = ?
    ), '/img/upload/', ?, ?, ?
);

commit;


SELECT
    id, bno, title, body, bdate, bclick, oriname, savename, dir
FROM
    board, fileinfo, member
WHERE
    fbno(+)=bno
    AND bno= 10021
    AND bmno = mno
;


SELECT
    id, bno, title, body, bdate, bclick, oriname, savename, dir 
FROM
    (SELECT
        id, bno, title, body, bdate, bclick
    FROM
        member, board
    WHERE
        bmno = mno
        AND bno = 10031), fileinfo
WHERE
    fbno=bno
;
