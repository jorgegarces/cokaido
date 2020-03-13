CREATE TABLE products IF NOT EXISTS(
    id INT NOT NULL,
    name VARCHAR(250) NOT NULL,
    price DECIMAL NOT NULL
    );

INSERT INTO  products (id, name, price) VALUES
    (10002, 'The Hobbit', 5.00),
    (10001, 'Lord of the Rings', 10.00),
    (20001, 'Game of Thrones', 9.00),
    (20110, 'Breaking Bad', 7.00);