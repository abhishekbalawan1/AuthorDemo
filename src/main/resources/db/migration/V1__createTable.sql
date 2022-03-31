create table author
(
id int,
name varchar(20),
address varchar(20),
age int,
PRIMARY KEY (id)
);

create table book
(
id int,
book_name varchar(20),
author_id int,
PRIMARY KEY (id),
FOREIGN KEY (author_id) REFERENCES author(id)
);