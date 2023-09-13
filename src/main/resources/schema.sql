create schema homework;

create table homework.CUSTOMERS (
    id int primary key auto_increment,
    name varchar(255) not null,
    surname varchar(255) not null,
    age int not null,
    phone_number int not null
);

create table homework.ORDERS (
    id int primary key auto_increment,
    date varchar(255) not null,
    customer_id int not null,
    product_name varchar(255) not null,
    amount int not null,
    FOREIGN KEY (customer_id) references homework.CUSTOMERS(id)
);

