drop table member;
create table member(
	no int(11) not null auto_increment,
	email varchar(200) not null,
	password varchar(64) not null,
	name varchar(100) not null,
	deparment varchar(100),
	primary key(no)
);
desc member;
alter table member add juminbunho char(13) not null after email;
desc member;
alter table member drop juminbunho;
desc member;
alter table member add join_date datetime not null;
desc member;
alter table member change deparment department varchar(100) not null;
desc member;
alter table member add self_intro text;
desc member;


-- insert
insert
  into member 
values(null, 'kickscar@gmail.com', password('1234'), '안대혁', '개발팀', now(), null);
select * from member;

insert
  into member(no, email, password, department, name, join_date) 
values(null, 'kickscar3@gmail.com', password('1234'), '개발팀3', '안대혁3', now());
select * from member;

-- update
 update member
    set email='kicks@gmail.com', password=password('5678')
  where no = 3;
select * from member;
  
-- delete
delete
  from member
 where no = 4; 
select * from member;

-- transaction
select @@AUTOCOMMIT;
set autocommit=0;

insert
  into member(no, email, password, department, name, join_date) 
values(null, 'kickscar5@gmail.com', password('1234'), '개발팀5', '안대혁5', now());
select * from member;