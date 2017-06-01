select * from user_tables;
select * from student;
select * from students_archive;
select * from smms_USER;
select * from smms_ARCHIVE;
select * from COURSE;
select * from COURSE_ARCHIVE;
select * from grade;
select * from grade_archive;
select * from grade;

 
update grade set score=60 where gid=1
alter table grade_archive rename column grade to score;
alter table grade_archive modify score int;
select * from student where sno =5;
--学生信息表
create table student(
  sno NUMBER(38)  primary key,    --学号  主键
  clname VARCHAR2(38)  NOT NULL,      ---班级名称
  sname varchar2(16) not null,  --姓名sno
  ssex varchar2(4) not null,     --性别
  bornDate date,    --出生日期
  tel varchar2(13),      --电话
  address varchar2(20),     --家庭住址
  ru_date date   --入学时间
)
alter table student modify  bornDate date null;
alter table students_archive modify  bornDate date null;

--学生归档信息表
create table students_archive(
  sno NUMBER(38)  primary key,    --学号  主键
  clname VARCHAR2(38)  NOT NULL,      ---班级名称
  sname varchar2(16) not null,  --姓名sno
  ssex varchar2(4) not null,     --性别
  bornDate date not null,    --出生日期
  tel varchar2(13),      --电话
  address varchar2(20),     --家庭住址
  ru_date date   --入学时间
)
create  sequence seq_sno increment by 1 start with 1;
--delete from student where bornDate is null;/；
select sno,clname,sname,ssex,bornDate,tel,address,ru_date from student;
select * from student;
insert into student values(seq_sno.nextval,'网络1401','张梦','女',to_date('1996/09/13','yyyy/mm/dd'),12548965387,'湖南省益阳市',to_date('2014/9/12','yyyy/mm/dd'));
 insert into student values(seq_sno.nextval,'计科1401','蒋小刀','女',to_date('1997/09/01','yyyy/mm/dd'),12548965387,'湖南省衡阳市',to_date('2014/9/12','yyyy/mm/dd'));
insert into student values(seq_sno.nextval,'网络1403','陆丹','女',to_date('1997/09/13','yyyy/mm/dd'),12548965387,'浙江省衢州市',to_date('2014/9/12','yyyy/mm/dd'));
insert into student values(seq_sno.nextval,'网络1401','郑淑','女',to_date('1995/09/02','yyyy/mm/dd'),12548965387,'湖南省郴州市',to_date('2014/9/12','yyyy/mm/dd'));
insert into student values(seq_sno.nextval,'网络1401','张颖颖','女',to_date('1996/09/13','yyyy/mm/dd'),12548965387,'宁夏省中宁市',to_date('2014/9/12','yyyy/mm/dd'));
insert into student values(seq_sno.nextval,'网络1401','张三','男',to_date('1996/09/13','yyyy/mm/dd'),12548965387,'湖南省衡阳市',to_date('2014/9/12','yyyy/mm/dd'));
insert into student values(seq_sno.nextval,'网络1401','李四','男',to_date('1996/09/13','yyyy/mm/dd'),12548965387,'湖南省衡阳市',to_date('2014/9/12','yyyy/mm/dd'));
insert into student values(seq_sno.nextval,'网络1401','张颖颖','女',to_date('1996/09/13','yyyy/mm/dd'),12548965387,'宁夏省中宁市',to_date('2014/9/12','yyyy/mm/dd'));
insert into student values(seq_sno.nextval,'网络1401','张三','男',to_date('1996/09/13','yyyy/mm/dd'),12548965387,'湖南省衡阳市',to_date('2014/9/12','yyyy/mm/dd'));
insert into student values(seq_sno.nextval,'网络1401','李四','男',to_date('1996/09/13','yyyy/mm/dd'),12548965387,'湖南省衡阳市',to_date('2014/9/12','yyyy/mm/dd'));

 insert into student values(seq_sno.nextval,'网络1401','陆久','女',to_date('1996/09/13','yyyy/mm/dd'),12548965387,'宁夏省中宁市',to_date('2014/9/12','yyyy/mm/dd'));
insert into student values(seq_sno.nextval,'网络1401','陈七','男',to_date('1996/09/13','yyyy/mm/dd'),12548965387,'湖南省衡阳市',to_date('2014/9/12','yyyy/mm/dd'));
insert into student values(seq_sno.nextval,'网络1401','赵六','男',to_date('1996/09/13','yyyy/mm/dd'),12548965387,'湖南省衡阳市',to_date('2014/9/12','yyyy/mm/dd'));

 
 
---课程表
create table course(
  cno int primary key,   --课程号
  cname varchar2(10) not null,  --课程名
  usid number(38) references smms_user(usid)  --教师编号
)
drop sequence seq_cno;
create  sequence seq_cno increment by 1 start with 1001;
insert into course values(seq_cno.nextval,'Java',46);
insert into course values(seq_cno.nextval,'软件工程',47);
insert into course values(seq_cno.nextval,'网络管理',49);
insert into course values(seq_cno.nextval,'数据结构',51);

--查询所有课程对应的老师
select cno,cname,SMMS_USER.uname
from COURSE,SMMS_USER
where COURSE.USID=SMMS_USER.USID

--学生成绩表
drop table grade;
create table grade(
   gid int primary key,
   sno int not null,
   cno int not null,
   grade NUMBER(38)
)

create table grade_archive(
   gid int primary key,
   sno int not null,
   cno int not null,
   grade NUMBER(38)
)

create  sequence seq_gid increment by 1 start with 1;

insert into grade values(seq_gid.nextval,'3','1001',94);
insert into grade values(seq_gid.nextval,'3','1001',94);
insert into grade values(seq_gid.nextval,'3','1001',94);
insert into grade values(seq_gid.nextval,'3','1001',94);
insert into grade values(seq_gid.nextval,'3','1001',94);

select * from grade;

--查询所有学生的所有成绩
select s.sname,c.cname,grade
from student s,course c,grade g
where s.sno=g.sno and c.cno=g.cno;
select *from SMMS_USER;
drop table smms_user;
 create table smms_user(   --teacher表
    usid number(38) primary key,
    uname varchar2(20) not null,
    upwd varchar2(20) not null,
    sex char(2) check(sex in('男','女')),
    tel number(20) not null,
    user_drop char(8) check (user_drop in ('General','System'))  
)
 select * from SMMS_USER;
 insert into smms_user values(seq_usid.nextval,'admin','admin','男',1234556,'System');
insert into smms_user values(seq_usid.nextval,'刘其昌','a','男',111111,'General');
insert into smms_user values(seq_usid.nextval,'冯本慧','a','男',156456,'General');
insert into smms_user values(seq_usid.nextval,'彭代文','a','男',414864896,'General');
insert into smms_user values(seq_usid.nextval,'陈利平','a','女',156464564,'General');
insert into smms_user values(seq_usid.nextval,'高金华','a','男',156464564,'General');
insert into smms_user values(seq_usid.nextval,'李四','a','男',156464564,'General');
insert into smms_user values(seq_usid.nextval,'王五','a','男',156464564,'General');
insert into smms_user values(seq_usid.nextval,'赵六','a','男',156464564,'General');
insert into smms_user values(seq_usid.nextval,'陈七','a','男',156464564,'General');
insert into smms_user values(seq_usid.nextval,'李八','a','男',156464564,'General');
insert into smms_user values(seq_usid.nextval,'孙九','a','男',156464564,'General');

insert into smms_user values(seq_usid.nextval,'张三','a','男',158985738,'General');

 create table smms_archive(  --教师归档表  
    usid number(38) not null ,
    uname varchar2(20) not null,
    upwd varchar2(20) not null,
    sex char(2) check(sex in('男','女')),
    tel number(20) not null,
    user_drop char(8) check (user_drop in ('General','System'))  
)

alter table grade add constraint FK_ID foreign key(sno) references student(sno);
alter table grade add constraint FK_cno foreign key(cno) references course(cno);
alter table course add constraint FK_tname foreign key(usid) references smms_user(usid);  --将course中的老师姓名和smms_user中的uname关联起来







select * from smms_archive;

create  sequence seq_usid increment by 1 start with 1;
 
drop sequence seq_usid;


delete  smms_user where usid = 45;
select usid,,uname,upwd from(select n.*,rownum rn from (select * from smms_user order by 5) n where rownum<20) where rn>1
 
 
select * from(select n.*,rownum rn from (select * from NEWS order by 1) n where rownum<45) where rn>1;

 



 
 
create table news_archive as select * from NEWS where 1 != 1; 
create table student_archive(  --学生归档表
 NID  NUMBER(38) primary key,
 NTID  NUMBER(38)  NOT NULL,
 NTITLE  VARCHAR2(200) NOT NULL,
 NAUTHOR  VARCHAR2(50) NOT NULL,
 NCREATEDATE   DATE,
 NPICPATH  VARCHAR2(1000),
 NCONTENT  LONG NOT NULL,
 NMODIFYDATE  DATE default sysdate,
 NSUMMARY  VARCHAR2(500) NOT NULL 
)
 
 

select * from NEWS_USER where user_drop='General';

select * from news_user where usid = 50;

