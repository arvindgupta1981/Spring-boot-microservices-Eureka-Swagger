create database resume;
use resume;
create table resume(
id int primary key auto_increment,
candidate_id int,
education varchar(200));

insert into resume (candidate_id, education) values(1, 'MCA');
insert into resume (candidate_id, education) values(2, 'BA');
