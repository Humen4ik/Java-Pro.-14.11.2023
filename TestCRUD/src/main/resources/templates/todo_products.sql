INSERT INTO products (id, name, cost)
VALUES
    (1, 'Milk', 2.99),
    (2, 'Potato', 1.49),
    (3, 'Tomato', 0.99),
    (4, 'Bread', 1.99),
    (5, 'Eggs', 3.49);

select * from products;

update products set name = 'Oranje juice' where id = 6;

UPDATE products SET name = 'TestUpdate',cost = 22.25 WHERE id = 6;