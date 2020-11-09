CREATE TABLE reboard(
    bno NUMBER(5)
        CONSTRAINT REBD_NO_PK PRIMARY KEY,
    b_mno NUMBER(4)
        CONSTRAINT REBD_MNO_FK REFERENCES member(mno)
        CONSTRAINT REBD_MNO_NN NOT NULL,
    body VARCHAR2(500 CHAR)
        CONSTRAINT REBD_BD_NN NOT NULL,
    upno NUMBER(5),
    wdate DATE DEFAULT sysdate
        CONSTRAINT REBD_DATE_NN NOT NULL,
    isshow CHAR(1) DEFAULT 'Y'
        CONSTRAINT REBD_SHOW_NN NOT NULL
        CONSTRAINT REBD_SHOW_CK CHECK(isshow IN('Y', 'N'))
);


-- 댓글 게시판을 

