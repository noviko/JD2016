create table tours(
ID int AUTO_INCREMENT,
FK_country varchar(20) NOT NULL,
FK_type_tour varchar(15) NOT NULL,
FK_transport varchar(15) NOT NULL,
FK_type_hotel varchar(15) NOT NULL,
FK_food_complex varchar(25) NOT NULL,
Cost int NOT NULL,
Discount int NOT NULL,
primary key(ID)
);