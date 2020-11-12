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
    '지속적인 관심이 필요합니다!',
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
    '이번주도 풋살 콜~~!',
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
    '살살 합시다! 콜~~',
    10021
);



commit;


--오라클에만 있음

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
        START WITH  -- 계층이 시작될 조건을 부여하는 절
            upno IS NULL
        CONNECT BY -- 어떻게 연결이 되어있느냐? 이전과의 관계를 서술하는 절
                   -- 상위글이 원글인 경우 레벨 주기
            PRIOR bno = upno
        ORDER SIBLINGS BY   -- 계층이 같은 애들이 경우 어떻게 정렬할꺼냐?
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