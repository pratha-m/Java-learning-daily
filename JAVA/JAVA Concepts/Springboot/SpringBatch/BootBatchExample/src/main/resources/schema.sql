CREATE TABLE IF NOT EXISTS products
(
    product_id varchar(200) primary key,
    title varchar(200),
    description varchar(200),
    price varchar(10),
    discount varchar(50),
    discounted_price varchar(10)
);