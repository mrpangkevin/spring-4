--CREATE DATABASE gradesystem;

USE gradesystem;

CREATE TABLE student
(
sid  INT(12) PRIMARY KEY auto_increment,
sname VARCHAR(20),
gender VARCHAR(12)
);


CREATE TABLE course
(
cid INT(12) PRIMARY KEY auto_increment,
cname VARCHAR(20)
);

CREATE TABLE mark
(
mid INT(12) PRIMARY KEY auto_increment,
sid INT(12),
cid INT(12),
score INT(12),
FOREIGN KEY(sid) references student(sid),
FOREIGN KEY(cid) references course(cid)
);



insert into student (sid, sname,gender)  values(1, 'Tom', 'male'), (2, 'Jack','male'), (3,'Rose','female');

insert into course (cid, cname)  values(1, 'math'), (2, 'physics'), (3,'chemistry');

insert into mark (mid,sid,cid, score)  values(1, 1,1,80),(2,2,1,85),(3,3,1,90),(4,1,2,60),(5,2,2,90),(6,3,2,75),(7,1,3,95),(8,2,3,75),(9,3,3,85);
