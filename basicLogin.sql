
SELECT TOP (1000) [id]
      ,[username]
      ,[password]
  FROM [ltweb].[dbo].[Users]

  drop table Users

use ltweb
go

create table Users (
	id integer primary key identity(1,1),
	username nvarchar(50) not null unique,
	password nvarchar(50) not null,
	email nvarchar(50),
	images nvarchar(MAX),
	fullname nvarchar(100)
);

insert into Users(username, password, email,images, fullname) values 
('quocanh','123', 'quocanh@gmail.com', null, 'quocanh' ),
('Ang','123', null, null, 'quocem');