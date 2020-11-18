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
----------------------------------------------------------------
-- 사원의 사원번호, 사원이름, 부서번호, 부서원수를 조회하세요

--SELECT 절 내에서 사용
SELECT
    empno 사원번호, ename 사원이름, deptno 부서번호,
    (SELECT COUNT(*) FROM emp WHERE deptno = e.deptno) 부서원수
FROM
    emp e
;

--인라인뷰로 사용
SELECT
    empno, ename, deptno, cnt
FROM
    emp d,
    (
        SELECT
            deptno dno, count(*) cnt
        FROM
            emp
        GROUP BY
            deptno
    ) e
WHERE
   deptno =dno
;


SELECT
    COUNT(*) cnt
FROM
    emp
GROUP BY
    deptno
HAVING
    deptno = 30
;


-- 게시판의 글 번호, 글 제목, 작성일, 첨부파일갯수를 조회하세요
SELECT
    bno, title, bdate, NVL(cnt, 0) CNT
FROM
    board,
    (
        SELECT
            fbno, COUNT(*) cnt
        FROM   
            fileinfo
        GROUP BY
            fbno
    )
WHERE
    bno = fbno(+)
;

--------------------------------------------------------------

    
UPDATE  board
SET
    bclick = (SELECT MAX(bclick)+1 FROM board WHERE bno=10026 )
WHERE
    bno=10026;

UPDATE board
SET
    bclick = 0;
