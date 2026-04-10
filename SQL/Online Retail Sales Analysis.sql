CREATE TABLE Customers (
    customer_id INT PRIMARY KEY,
    name VARCHAR(100),
    city VARCHAR(100)
);

CREATE TABLE Products (
    product_id INT PRIMARY KEY,
    name VARCHAR(100),
    category VARCHAR(100),
    price DECIMAL(10,2)
);

CREATE TABLE Orders (
    order_id INT PRIMARY KEY,
    customer_id INT,
    order_date DATE,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);

CREATE TABLE Order_Items (
    order_id INT,
    product_id INT,
    quantity INT,
    PRIMARY KEY (order_id, product_id),
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
);

INSERT INTO Customers VALUES
(1, 'Arun', 'Chennai'),
(2, 'Meena', 'Mumbai'),
(3, 'Ravi', 'Delhi'),
(4, 'Divya', 'Bangalore');

INSERT INTO Products VALUES
(101, 'Laptop', 'Electronics', 50000),
(102, 'Mobile', 'Electronics', 20000),
(103, 'Shoes', 'Fashion', 3000),
(104, 'Watch', 'Accessories', 5000);

INSERT ALL
    INTO Orders VALUES (1001, 1, TO_DATE('2024-01-10','YYYY-MM-DD'))
    INTO Orders VALUES (1002, 2, TO_DATE('2024-02-15','YYYY-MM-DD'))
    INTO Orders VALUES (1003, 1, TO_DATE('2024-02-20','YYYY-MM-DD'))
    INTO Orders VALUES (1004, 3, TO_DATE('2024-03-05','YYYY-MM-DD'))
SELECT * FROM dual;

INSERT INTO Order_Items VALUES
(1001, 101, 1),
(1001, 103, 2),
(1002, 102, 1),
(1003, 104, 3),
(1004, 103, 1);

SELECT p.name, SUM(oi.quantity) AS total_sold
FROM Order_Items oi
JOIN Products p ON oi.product_id = p.product_id
GROUP BY p.name
ORDER BY total_sold DESC;

SELECT c.name,
       SUM(p.price * oi.quantity) AS total_spent
FROM Customers c
JOIN Orders o ON c.customer_id = o.customer_id
JOIN Order_Items oi ON o.order_id = oi.order_id
JOIN Products p ON oi.product_id = p.product_id
GROUP BY c.name
ORDER BY total_spent DESC;

SELECT EXTRACT(MONTH FROM o.order_date) AS month,
       SUM(p.price * oi.quantity) AS revenue
FROM Orders o
JOIN Order_Items oi ON o.order_id = oi.order_id
JOIN Products p ON oi.product_id = p.product_id
GROUP BY EXTRACT(MONTH FROM o.order_date)
ORDER BY month;

SELECT p.category,
       SUM(p.price * oi.quantity) AS total_sales
FROM Products p
JOIN Order_Items oi ON p.product_id = oi.product_id
GROUP BY p.category;

SELECT c.customer_id, c.name
FROM Customers c
LEFT JOIN Orders o ON c.customer_id = o.customer_id
WHERE o.order_id IS NULL;