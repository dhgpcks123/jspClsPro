INSERT INTO
    fileinfo(fno, fbno, oriname, savename, dir, len)
VALUES(
    (SELECT NVL(MAX(fno)+1, 1000001) FROM fileinfo),
    ?, ?, ?, '/img/upload/', ?
);

--�������Ƿ� �̱�
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
-- ����� �����ȣ, ����̸�, �μ���ȣ, �μ������� ��ȸ�ϼ���

--SELECT �� ������ ���
SELECT
    empno �����ȣ, ename ����̸�, deptno �μ���ȣ,
    (SELECT COUNT(*) FROM emp WHERE deptno = e.deptno) �μ�����
FROM
    emp e
;

--�ζ��κ�� ���
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


-- �Խ����� �� ��ȣ, �� ����, �ۼ���, ÷�����ϰ����� ��ȸ�ϼ���
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
