create table users (
id_user int (10) AUTO_INCREMENT,
name varchar(20) NOT NULL,
surname varchar(25) NOT NULL,
email varchar(50) NOT NULL,
login varchar(20) NOT NULL,
password varchar(15) NOT NULL,
role int(2) NOT NULL,
PRIMARY KEY (id_user),
FOREIGN KEY (role)
);