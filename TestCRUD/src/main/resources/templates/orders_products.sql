insert into orders_products (order_id, product_id, quantity)
VALUES
(1, 2, 3),
(1, 3, 2),
(1, 4, 1);

select * from orders;
select * from products;
select * from orders_products;