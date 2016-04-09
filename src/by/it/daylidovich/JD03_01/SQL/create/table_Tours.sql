create table tours(
ID int AUTO_INCREMENT,
FK_country int(3) NOT NULL,
FK_type_tour int(1) NOT NULL,
FK_transport int(1) NOT NULL,
FK_type_hotel int(1) NOT NULL,
FK_food_complex int(1) NOT NULL,
Cost int NOT NULL,
Discount int NOT NULL,
primary key(ID)
);