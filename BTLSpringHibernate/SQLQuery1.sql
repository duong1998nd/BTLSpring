create database DTM;
go
use DTM;
create table Categories(
	CatId int not null primary key identity,
	CatName nvarchar(100) not null,
	created_at datetime default CURRENT_TIMESTAMP,
	update_at datetime,
	delete_at datetime
)
go
create table Products(
	ProId int not null primary key identity,
	ProName nvarchar(120) not null,
	Description nvarchar(200),
	Quantity int not null,
	Price float not null,
	Sale_Price float,
	Brand nvarchar(120) not null,
	Status bit,
	CatId int foreign key references Categories(CatId),
	created_at datetime default CURRENT_TIMESTAMP,
	update_at datetime,
	delete_at datetime
)
go
create table Carousel(
	Id int not null primary key,
	Name nvarchar(120),
	Image varchar(100)
)
select * from Products;
select * from Categories;

