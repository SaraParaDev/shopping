DROP TABLE IF EXISTS wish;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS items_categories;

CREATE TABLE users(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(250) NOT NULL,
password VARCHAR(250) NOT NULL,
email VARCHAR(250) NOT NULL

);

INSERT INTO users (name, password, email) VALUES
('Sara', 'password1', 'sara@gmail.com'),
('Nisha', 'password2', 'nisha@gmail.com');

CREATE TABLE items_categories (
id INT AUTO_INCREMENT PRIMARY KEY,
description VARCHAR(250) NOT NULL);

INSERT INTO items_categories (description) VALUES
('clothing'),
('beauty'),
('home');

CREATE TABLE items (
id INT AUTO_INCREMENT PRIMARY KEY,
description VARCHAR(250) NOT NULL,
price DOUBLE NOT NULL,
category_id INT,
foreign key(category_id) references items_categories(id)

);

INSERT INTO items (description, price, category_id)
 VALUES
 ('t-shirts', '200',1),
 ('pants', '700',1),
 ('eyeshadow', '500', 2),
 ('mascara', '400', 2),
 ('rugs', '100', 3),
 ('kettle', '300', 3);

 CREATE TABLE wish (
 id INT AUTO_INCREMENT PRIMARY KEY,
 user_id INT,
 item_id INT,
 foreign key (user_id) references users(id),
 foreign key (item_id) references items(id)
 );

 INSERT INTO wish (user_id, item_id) VALUES
 (1,2),
 (2,1),
 (2,3),
 (1,4);

 CREATE TABLE orders (
 id INT AUTO_INCREMENT PRIMARY KEY,
 user_id INT,
 item_id INT,
 foreign key (user_id) references users(id),
 foreign key (item_id) references items(id),
 quantity INT NOT NULL,
 date_created DATE NOT NULL,
 user_rating INT NOT NULL
 );

 INSERT INTO orders (user_id, item_id, quantity, date_created, user_rating) VALUES
 (1,2,3, '2021-08-02', 4),
 (2,1,2, '2021-08-03', 5),
 (2,3,1, '2021-08-04', 3),
 (2,1,1, '2021-08-04', 2),
 (2,4,1, '2021-08-04', 5),
 (1,4,4, '2021-08-05', 4),
 (1,6,1, '2021-08-04', 3),
 (1,5,1, '2021-08-04', 3);


