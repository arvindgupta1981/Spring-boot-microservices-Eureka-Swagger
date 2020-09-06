create database candidate;
use candidate;
create table candidate (
id int primary key auto_increment,
name varchar(200));
insert into candidate(name) values('Arvind');
insert into candidate(name) values('Kamal');
insert into candidate(name) values('Muskan');
