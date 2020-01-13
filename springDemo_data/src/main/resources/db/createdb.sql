drop user if exists 'springdemouser'@'localhost';

create user 'springdemouser'@'localhost' identified by 'spring_Demo1';

drop database if exists springDemoDB;

create database springDemoDB;

use springDemoDB;

grant all privileges on springDemoDB.* to 'springdemouser'@'localhost';

flush privileges;