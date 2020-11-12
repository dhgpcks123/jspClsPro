INSERT INTO
    reboard(bno, b_mno, body, upno)
VALUES(
    ( SELECT NVL(MAX(bno)+1, 10001) FROM reboard ),
    (
        SELECT
            mno
        FROM   
            member
        WHERE
            id='euns'
    ),
    '�������� ������ �ʿ��մϴ�!',
    10003
);

INSERT INTO
    reboard(bno, b_mno, body, upno)
VALUES(
    ( SELECT NVL(MAX(bno)+1, 10001) FROM reboard ),
    (
        SELECT
            mno
        FROM   
            member
        WHERE
            id='jiwoo'
    ),
    '�̹��ֵ� ǲ�� ��~~!',
    10002
);

INSERT INTO
    reboard(bno, b_mno, body, upno)
VALUES(
    ( SELECT NVL(MAX(bno)+1, 10001) FROM reboard ),
    (
        SELECT
            mno
        FROM   
            member
        WHERE
            id='sun'
    ),
    '��� �սô�! ��~~',
    10021
);



commit;


--����Ŭ���� ����

SELECT
    *
FROM
    (SELECT
        rownum rno, r.*
    FROM
        (SELECT
            bno, b_mno mno, id, ano, afile sname, body, wdate, upno, (level -1) step
        FROM
            reboard r, member m, avatar a
        WHERE
            r.isshow= 'Y'
            AND b_mno = mno
            AND avt = ano
        START WITH  -- ������ ���۵� ������ �ο��ϴ� ��
            upno IS NULL
        CONNECT BY -- ��� ������ �Ǿ��ִ���? �������� ���踦 �����ϴ� ��
                   -- �������� ������ ��� ���� �ֱ�
            PRIOR bno = upno
        ORDER SIBLINGS BY   -- ������ ���� �ֵ��� ��� ��� �����Ҳ���?
            wdate DESC) r)
WHERE
    rno BETWEEN 1 AND 3
;


SELECT
    id
FROM
    reboard, member
WHERE
    reboard.bno = member.mno
;


SELECT
    *
FROM
    emp
;


SELECT
    e.ename, e.deptno, e.sal, e.job, e.mgr, level
FROM
    emp01 e, emp01 d
WHERE
    e.mgr = d.empno
START WITH
    d.mgr IS NULL
CONNECT BY
    PRIOR e.empno = d.mgr
ORDER SIBLINGS BY
    e.hiredate
;