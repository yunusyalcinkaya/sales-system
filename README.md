# sales-system
This project is a sales system built with a microservices architecture.

## catalog-service

run "docker-compose.yml" file:

- docker compose -p sales-system-compose up -d

Sample product insert scripts:

- INSERT INTO products (id, name, code, price)
VALUES (gen_random_uuid(), 'Laptop', 'LAP-12345', 1299.99);

- INSERT INTO products (id, name, code, price)
VALUES (gen_random_uuid(), 'Smartphone', 'SMT-98765', 799.49);

- INSERT INTO products (id, name, code, price)
VALUES (gen_random_uuid(), 'Headphones', 'HP-56789', 199.99);

- INSERT INTO products (id, name, code, price)
VALUES (gen_random_uuid(), 'Wireless Mouse', 'WM-11122', 29.99);

- INSERT INTO products (id, name, code, price)
VALUES (gen_random_uuid(), 'Gaming Keyboard', 'GK-22334', 149.99);

- INSERT INTO products (id, name, code, price)
VALUES (gen_random_uuid(), '4K Monitor', 'MON-33445', 399.00);