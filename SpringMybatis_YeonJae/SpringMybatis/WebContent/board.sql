  --1.테이블 생성
 drop table upLoadtemp;
  
create table upLoadtemp(
	 b_id number(5) primary key, -- 글번호 
	 b_name varchar2(20),-- 글쓴이 
	 b_email varchar2(50),-- 글쓴이 메일 주소 
	 b_title varchar2(80),-- 글 제목 
	 b_content varchar2(3000),-- 글 내용 
	 b_pwd varchar2(12),-- 비밀번호 
	 b_date date,-- 글쓴날짜 
	 b_count number(5) default 0,-- 조회횟수 
	 b_ip varchar2(15),-- 글쓴이 아이피주소 
     b_fname varchar2(100), --파일이름
     b_fsize number  --파일용량
);




-- 2. 시퀀스 생성
 drop sequence uploadtemp;
 
 create sequence uploadtemp_bid_seq  ;
 



 
 
 