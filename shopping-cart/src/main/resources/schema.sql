CREATE TABLE IF NOT EXISTS baskets (
    userId INT NOT NULL,
    date VARCHAR(250) NOT NULL
    );

CREATE TABLE IF NOT EXISTS line_items (
    userId INT NOT NULL,
    productId INT NOT NULL,
    quantity INT NOT NULL
    );

CREATE TABLE IF NOT EXISTS products (
    id INT NOT NULL,
    name VARCHAR(250) NOT NULL,
    price DECIMAL NOT NULL
    );

