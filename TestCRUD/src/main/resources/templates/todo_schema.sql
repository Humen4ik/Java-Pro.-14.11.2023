CREATE TABLE IF NOT EXISTS orders (
    id SERIAL PRIMARY KEY,
    date DATE,
    cost NUMERIC
);

create table if not exists products (
    id serial primary key,
    name VARCHAR(50),
    cost NUMERIC
);

create table if not exists orders_products (
    order_id int references orders(id),
    product_id int references products(id),
    quantity int,
    primary key (order_id, product_id)
);