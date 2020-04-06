create database Users

use Users

create table Users(
username varchar(20) primary key,
password varchar(20)
)

create table Groups(
gid varchar(5) primary key,
gname varchar(20)
)

create table Features(
fid int primary key,
url varchar(10),
isRequired bit
)

create table User_Group(
username varchar(20) references Users(username),
gid varchar(5) references Groups(gid),
primary key(username, gid)
)

create table Group_Feature(
gid varchar(5) references Groups(gid),
fid int references Features(fid)
primary key (gid, fid)
)

insert into Users values
('a','a'),
('b','b'),
('c','c')

insert into Groups values 
('g1','Group 1'),
('g2','Group 2'),
('g3','Group 3')

insert into Features values
(1,'list',0),
(2,'insert',1),
(3,'delete',1),
(4,'edit',1)

insert into User_Group values
('a','g1'),
('b','g2'),
('b','g3'),
('c','g3')

insert into Group_Feature values
('g1','2'),
('g2','2'),
('g2','3'),
('g3','4')