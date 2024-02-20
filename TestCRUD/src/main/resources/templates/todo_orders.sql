INSERT INTO orders (date, cost)
VALUES
    (CURRENT_DATE - (FLOOR(RANDOM() * 30) || ' days')::INTERVAL, RANDOM() * 1000), -- Випадкова дата за останні 30 днів, випадкова вартість до 1000
    (CURRENT_DATE - (FLOOR(RANDOM() * 30) || ' days')::INTERVAL, RANDOM() * 1000),
    (CURRENT_DATE - (FLOOR(RANDOM() * 30) || ' days')::INTERVAL, RANDOM() * 1000);

select * from orders;

delete from orders where cost = 0.0;
