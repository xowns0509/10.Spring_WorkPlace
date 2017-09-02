
CREATE TABLE sp_bbs(
num NUMBER CONSTRAINT sp_bbs_num_pk PRIMARY key,
sub VARCHAR2(50),
writer VARCHAR2(34),
pwd VARCHAR2(10),
cont CLOB,
reip VARCHAR2(34),
hit NUMBER(3),
regdate date);
CREATE SEQUENCE sp_bbs_seq
INCREMENT BY 1
START WITH 1;

CREATE TABLE sp_bbscomm(
num NUMBER CONSTRAINT sp_bbscomm_num_pk PRIMARY key,
kcode number(5) NOT NULL,
cnt number(5) NOT NULL,
writer VARCHAR2(34),
comm VARCHAR2(400),
reip VARCHAR2(34),
regdate DATE,
CONSTRAINT bbscomm_kcode_fk FOREIGN KEY(kcode) REFERENCES sp_bbs(num));

CREATE SEQUENCE sp_bbscomm_seq
INCREMENT BY 1
START WITH 1;