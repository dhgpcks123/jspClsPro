SELECT
    *
FROM
    surveyquest
WHERE
    upno is null;


SELECT
    *
FROM
    surveyquest q,
    (SELECT
        upno
    FROM
        surveyquest
    GROUP BY
        upno
    ORDER BY
        upno) j
WHERE
    q.upno = j.upno
;


SELECT
    sqno, sqbody, upno, decode(upno, null, 0, 1) lvl, nvl(upno, sqno) qgroup
FROM
    surveyquest
ORDER BY
    qgroup, lvl, sqno
;


INSERT INTO
    surveyAnswer
VALUES(
    (SELECT NVL(MAX(sano) +1, 10001) FROM surveyanswer),
    (SELECT mno FROM member WHERE id = 'jinwoo' ),
    10003, sysdate
);


-- 보기별 응답수 조회

SELECT
    sa_qno qno, count(*) cnt
FROM
    surveyInfo, surveyAnswer, surveyquest
WHERE
    -- join
    sno = sino
    AND sqno(+) = sa_qno
    AND sno = 1001
GROUP BY
    sa_qno
;

