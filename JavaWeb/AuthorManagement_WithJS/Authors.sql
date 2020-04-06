create database Authors
go
use Authors
go 
create table Article(
id int primary key,
title nvarchar(50),
publishedDate date,
)
create table Author(
id int identity(1,1) primary key,
name nvarchar(50),
aid int references Article(id)
)