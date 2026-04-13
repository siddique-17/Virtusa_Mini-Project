
# Virtusa Mini projects

This repository contains three mini-projects developed using **Python**, **SQL**, and **Java**.  
Each project demonstrates distinct programming concepts — from file handling and data visualization to database design and full-stack logic.

---

## 1. Smart Expense Tracker (Python)

A **command-line expense management tool** built with **Python**, allowing users to record, view, and analyze expenses efficiently.

###  Key Features
- Add and view expenses  
- Generate monthly summaries  
- Category-wise expense analysis with charts (using Matplotlib)  
- Data stored in CSV for persistence  

###  Technologies
- Python (CSV, datetime, collections, matplotlib)

###  Run
```bash
python SmartExpenseTracker.py
```

---

## 2. Retail Store Database (SQL)

A **relational database project** simulating a retail store’s sales and customer data management system.  
It includes tables for customers, products, orders, and order items with referential integrity.

###  Key Highlights
- Structured database schema using primary & foreign keys  
- Example data for customers, products, and transactions  
- Analytical capabilities: product performance, customer spending, revenue trends  
- Perfect for SQL query practice and data insights  

###  Technologies
- SQL (Oracle/MySQL compatible)
- Relational Database Design

---

## 3. Library Management System (Java)

A **console-based Java application** for managing library operations such as books, users, and transactions.  
Implements **OOP concepts** and **JDBC** for database connectivity with **MySQL**.

###  Core Features
- Add, search, and manage books  
- Register users and issue/return books  
- Track transactions and update availability  
- Modular DAO structure for maintainability  

###  Technologies
- Java (Core Java, OOP, JDBC)
- MySQL Database

###  Setup
1. Install JDK 8+ and MySQL  
2. Create a `library` database and configure connection  
3. Compile and run:
   ```bash
   javac -cp ".;mysql-connector-j-9.1.0.jar" *.java
   java -cp ".;mysql-connector-j-9.1.0.jar" Librarymangement
   ```

---

## Summary

| Project | Language | Concept Focus | Storage/DB |
|----------|------------|----------------|-------------|
| Smart Expense Tracker | Python | File Handling, Visualization | CSV |
| Retail Store Database | SQL | Relational Schema, Queries | RDBMS |
| Library Management System | Java | OOP, JDBC, DAO Pattern | MySQL |

