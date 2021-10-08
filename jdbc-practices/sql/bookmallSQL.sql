-- 초기화
delete from order_book;
delete from order_ ;
alter table order_ auto_increment = 1;
delete from cart;
delete from member ;
alter table member auto_increment = 1;
delete from book; -- 카테고리에서 외래키를 받음
alter table book auto_increment = 1;
delete from category;
alter table category auto_increment = 1;









insert into member values(null, "양승우", "010-1234-5678", "abc123@naver.com","1234");
insert into member values(null, "양아치", "010-1004-1004", "xyz1004@naver.com","1004");
select no, name, tel, email, password from member;
-- delete from member;
-- alter table member auto_increment = 1;

insert into category values(null, "경제경영");
insert into category values(null, "자기개발");
insert into category values(null, "컴퓨터/IT");
select no, name from category;
-- delete from category;
-- alter table category auto_increment = 1;


insert into book values(null, "부자아빠 가난한아빠", 15800, 1);
insert into book values(null, "할 말은 합니다", 14400, 2);
insert into book values(null, "혼자 공부하는 파이썬", 16200, 3);
select no,title,price,category_no from book;
-- delete from book; -- 카테고리에서 외래키를 받음
-- alter table book auto_increment = 1;

insert into cart values(5,1,1); -- 수량, 책_넘버, 회원_넘버
insert into cart values(3,3,2);
select count, book_no, member_no from cart;
-- delete from cart;

insert into order_ values(null,1234, 50000, "동서대학교", 1);
select no, order_num, payprice, shipaddress, member_no from order_;
-- delete from order_ ;
-- alter table order_ auto_increment = 1;


insert into order_book values(3, 2, 1); -- 수량3권 2번책인 1번주문리스트
insert into order_book values(5, 3, 1);
select count, book_no, order_no from order_book;
-- delete from order_book;