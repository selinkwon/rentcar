create database test;
use test;

CREATE table users(
user_code int primary key auto_increment,
`name` varchar(20) not null,
contact varchar(20) not null,
join_date timestamp default current_timestamp
);

ALTER TABLE users AUTO_INCREMENT=1001;
ALTER TABLE users ADD id varchar(20) AFTER `name`;
ALTER TABLE users DROP password;
ALTER TABLE users ADD `password` varchar(20) AFTER id;


CREATE table board(
content_num int auto_increment primary key,
user_code int not null,
`name` varchar(20),
content varchar(100) not null,
title varchar(20) not null,
add_date timestamp default current_timestamp,
`date` timestamp default current_timestamp,
foreign key(user_code) references users(user_code) 
);

ALTER TABLE board AUTO_INCREMENT=1;


CREATE table booking(
car_code int not null,
total_price varchar(20) not null,
user_code int not null,
hour_rate int not null,
base_rate int not null,
`time` int not null,
`date` timestamp default current_timestamp,
place char(2) not null,
reserv_code int auto_increment primary key,
foreign key(car_code) references car(car_code),
foreign key(user_code) references users(user_code)
);

ALTER TABLE booking AUTO_INCREMENT=2001;

CREATE table place(
place_cod char(2) primary key,
place_name varchar(20) not null
);


CREATE table car(
car_code int auto_increment primary key,
price int not null,
`name` varchar(20) not null,
`date` timestamp default current_timestamp
);

ALTER TABLE car AUTO_INCREMENT=10001;


CREATE table employee(
employee_code int primary key auto_increment,
`name` varchar(20),
`date` timestamp default current_timestamp
);

ALTER TABLE employee AUTO_INCREMENT=1;

