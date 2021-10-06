insert into category values(null, "경제경영");
insert into category values(null, "자기개발");
insert into category values(null, "컴퓨터/IT");
select no, name from category;
delete from category ;
alter table category auto_increment = 1;


insert into book values(null, "부자아빠 가난한아빠", 15800, 1);
insert into book values(null, "할 말은 합니다", 14400, 2);
insert into book values(null, "혼자 공부하는 파이썬", 16200, 3);
select no,title,price,category_no from book;
delete from book; -- 카테고리에서 외래키를 받음
alter table book auto_increment = 1;

insert into member values(null, "양승우", "010-1234-5678", "abc123@naver.com","1234");
insert into member values(null, "양아치", "010-1004-1004", "xyz1004@naver.com","1004");
select no, name, tel, email, password from member;
delete from member ;
alter table category auto_increment = 1;