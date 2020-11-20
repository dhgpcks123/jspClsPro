CREATE TABLE member(
    mno NUMBER(4)
        CONSTRAINT MEMB_MNO_PK PRIMARY KEY,
    id VARCHAR2(10 CHAR)
        CONSTRAINT MEMB_ID_NN NOT NULL,
    pw VARCHAR2(18 CHAR)
        CONSTRAINT MEMB_PW_NN NOT NULL,
    name VARCHAR2(10 CHAR)
        CONSTRAINT MEMB_NAME_NN NOT NULL,
    mail VARCHAR2(50 CHAR)
        CONSTRAINT MEMB_MAIL_NN NOT NULL,
    gen CHAR(1)
        CONSTRAINT MEMB_GEN_NN NOT NULL
        CONSTRAINT MEMB_GEN_CK CHECK (gen in('M', 'F')),
    avt  NUMBER(2)
        CONSTRAINT MEMB_AVT_NN NOT NULL,
    joindate DATE default sysdate
        CONSTRAINT MEMB_DATE_NN NOT NULL,
    isshow CHAR(1) default 'Y'
        CONSTRAINT MEMB_SHOW_NN NOT NULL
        CONSTRAINT MEMB_SHOW_CK CHECK(isshow IN('Y', 'N'))
);


CREATE TABLE avatar(
    ano NUMBER(2)
        CONSTRAINT AVAT_NO_PK PRIMARY KEY,
    aname VARCHAR2(30 CHAR)
        CONSTRAINT AVAT_NAME_NN NOT NULL,
    afile VARCHAR2(50 CHAR)
         CONSTRAINT AVAT_FILE_NN NOT NULL,
   dir VARCHAR2(50 CHAR)
        CONSTRAINT AVAT_DIR_NN NOT NULL,
    len NUMBER default 0
        CONSTRAINT AVAT_LEN_NN NOT NULL,
    gen CHAR(1)
        CONSTRAINT AVAT_GEN_NN NOT NULL
        CONSTRAINT AVAT_GEN_CK CHECK(gen IN('M', 'F'))        
);