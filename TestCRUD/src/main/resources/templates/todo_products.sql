INSERT INTO products (name, cost)
VALUES
    ('Milk', 2.99),
    ('Potato', 1.49),
    ('Tomato', 0.99),
    ('Bread', 1.99),
    ('Eggs', 3.49);

select * from products;

update products set name = 'Oranje juice' where id = 6;

UPDATE products SET name = 'TestUpdate',cost = 22.25 WHERE id = 6;

delete from products where cost >= 0.0;


create table record_package
(
    record_package_id bigserial not null
    constraint record_package_pk primary key,
    name varchar(256) not null
);

create table record (
    record_id bigserial not null
    constraint record_pk primary key,
    record_package_id bigint not null,
    data varchar(256) not null
);

alter table record
    add foreign key (record_package_id) references record_package;