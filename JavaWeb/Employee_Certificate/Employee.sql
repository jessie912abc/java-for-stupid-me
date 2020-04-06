create database Employee
use Employee

create table Employee(
id int identity(1,1) primary key,
name varchar(50)
)

create table Certificate(
id int identity(1,1) primary key,
title varchar(50),
expiredDays int
)

create table Employee_Certificate(
e_id int references Employee(id),
c_id int references Certificate(id),
issueDate date,
primary key(e_id, c_id, issueDate)
)

insert into Employee(name)
values 
('Nguyen Van A'),
('Pham Van B'),
('Tran Thi C'),
('Phung Van D'),
('Ngo Thi E')

insert into Certificate (title, expiredDays)
values
('MAE', 4),
('MAD', 2),
('OOP', 5)

select * from Certificate

insert into Employee_Certificate(e_id, c_id, issueDate)
values
(3,1, '2-27-2020'),
(5, 2, '3-2-2020'),
(4,2,'3-6-2020'),
(4,3, '3-2-2020'),
(5,1, '3-4-2020'), 
(1,1, '3-1-2020'),
(1,2, '3-1-2020'),
(1,3, '3-1-2020'),
(2,2, '3-2-2020'),
(2,3, '3-1-2020'),
(3,1, '3-3-2020')


select Certificate.id, title, issueDate, DATEADD(day,expiredDays, issueDate) as expireDate
from Certificate, Employee_Certificate
where Certificate.id = Employee_Certificate.c_id
and e_id = 3