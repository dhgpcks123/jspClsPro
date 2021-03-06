CREATE TABLE surveyInfo(
    sno NUMBER(4)
        CONSTRAINT SRVINF_NO_PK PRIMARY KEY,
    sbody VARCHAR2(500 CHAR)
        CONSTRAINT SRVINF_BODY_NN NOT NULL,
    sstart DATE
        CONSTRAINT SRVINF_START_NN NOT NULL,
    send DATE
        CONSTRAINT SRVINF_END_NN NOT NULL
);

CREATE TABLE surveyQuest(
    sqno NUMBER(5)
        CONSTRAINT SRVQST_NO_PK PRIMARY KEY,
    sqbody VARCHAR2(100 CHAR)
        CONSTRAINT SRVQST_BODY_NN NOT NULL,
    sino NUMBER(4)
        CONSTRAINT SRVQST_SINO_FK REFERENCES surveyinfo(sno)
        CONSTRAINT SRVQST_SINO_NN NOT NULL,
    upno NUMBER(5)
);

CREATE TABLE surveyAnswer(
    sano NUMBER(6)
        CONSTRAINT SRVANS_NO_PK PRIMARY KEY,
    sa_mno NUMBER(4)
        CONSTRAINT SRVANS_MNO_FK REFERENCES member(mno)
        CONSTRAINT SRVANS_MNO_NN NOT NULL,
    sa_qno NUMBER(5)
        CONSTRAINT SRVANS_QNO_FK REFERENCES surveyQuest(sqno)
        CONSTRAINT SRVANS_QNO_NN NOT NULL,
    sdate DATE DEFAULT SYSDATE
        CONSTRAINT SRVANS_DATE_NN NOT NULL
);


INSERT INTO
    surveyInfo
VALUES(
    (SELECT NVL(MAX(sno)+1, 1001) FROM surveyInfo),
    '2020년 11월 class2 아이돌 선호도 조사',
    TO_DATE('2020/11/12', 'YYYY/MM/DD'),
    TO_DATE('2020/11/13', 'YYYY/MM/DD')    
-- 12일 0시에서 13일 0시까지    
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(sqno)+1, 10001) FROM surveyQuest),
    '당신이 좋아하는 가수는?',
    1001, NULL
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(sqno)+1, 10001) FROM surveyQuest),
    '제시',
    1001, 10001
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(sqno)+1, 10001) FROM surveyQuest),
    '제시카',
    1001, 10001
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(sqno)+1, 10001) FROM surveyQuest),
    '안지영',
    1001, 10001
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(sqno)+1, 10001) FROM surveyQuest),
    '우지윤',
    1001, 10001
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(sqno)+1, 10001) FROM surveyQuest),
    '헨니',
    1001, 10001
);



INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(sqno)+1, 10001) FROM surveyQuest),
    '당신이 좋아하는 아이돌 걸그룹은?',
    1001, NULL
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(sqno)+1, 10001) FROM surveyQuest),
    '블랙핑크',
    1001, 10007
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(sqno)+1, 10001) FROM surveyQuest),
    '소녀시대',
    1001, 10007
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(sqno)+1, 10001) FROM surveyQuest),
    '여자친구',
    1001, 10007
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(sqno)+1, 10001) FROM surveyQuest),
    '우주소녀',
    1001, 10007
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(sqno)+1, 10001) FROM surveyQuest),
    '아이즈원',
    1001, 10007
);


INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(sqno)+1, 10001) FROM surveyQuest),
    '당신이 아이돌 그룹은 (남녀 구분안함)?',
    1001, NULL
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(sqno)+1, 10001) FROM surveyQuest),
    'BTS',
    1001, 10013
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(sqno)+1, 10001) FROM surveyQuest),
    '엠블랙',
    1001, 10013
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(sqno)+1, 10001) FROM surveyQuest),
    'Apink',
    1001, 10013
);

INSERT INTO
    surveyQuest
VALUES(
    (SELECT NVL(MAX(sqno)+1, 10001) FROM surveyQuest),
    '로켓펀치',
    1001, 10013
);


commit;


-- 현재 진행중인 설문조회
SELECT
    sno, sbody,
    (
        SELECT
            count(*)
        FROM
            surveyQuest, surveyAnswer, member
        WHERE
            sino = sno
            AND sqno = sa_qno
            AND mno = sa_mno
            AND id = 'jiwoo'
    ) cnt
FROM
    surveyInfo
WHERE
    sysdate BETWEEN sstart AND send
;


-- 알고있는 설문번호에 설문참여 했는지 여부 조희 질의명령
SELECT
    count(*) cnt
FROM
    surveyQuest, surveyAnswer, member
WHERE
    sino = 1001
    AND sqno = sa_qno
    AND mno = sa_mno
    AND id = 'jiwoo'
;

SELECT * FROM surveyquest
start with
    upno is null
connect by
    prior sqno = upno
order siblings by
    sqno;


commit;


SELECT
    sqbody AS qbody, upno, sbody, (level-1) step
FROM
    surveyQuest, surveyInfo
WHERE
    sino = 1001
    AND sino=sno
START WITH
    UPNO IS NULL
CONNECT BY
    PRIOR sqno=upno
ORDER SIBLINGS BY
    SQNO
;

