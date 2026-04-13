


#  Library Management System (Java)

A **Java-based Library Management System** built to efficiently manage books, users, and transactions.  
This is a **console-based application** developed using **Core Java (OOP concepts)** with **JDBC** for database connectivity and **MySQL** as the backend database.

---

##  Project Description

The Library Management System allows librarians or administrators to manage book records, track issued and returned books, and maintain user details with minimal manual effort.  
The system is designed using an object-oriented approach with modular DAO (Data Access Object) classes to ensure clean database operations and maintainable code.

---

##  Features

###  Book Management
- Add, update, and delete book records  
- View all available books  
- Search books by title or author  

###  User Management
- Register and manage user information  
- View user list and details  

###  Transaction Management
- Issue books to users and track status  
- Return books and update availability  
- Manage basic transaction history  

---

##  Technologies Used

- **Java (Core Java, OOP Concepts)**  
- **JDBC (Java Database Connectivity)**  
- **MySQL Database**

---

##  Project Structure

```
LibraryManagementSystem/
│
├── Main.java               # Entry point of the application
├── DBConnection.java       # Handles MySQL database connection
├── BookDAO.java            # Book data access and management
├── UserDAO.java            # User data access and management
├── TransactionDAO.java     # Issue/return transaction handling
└── README.md               # Project documentation
```

---

##  Setup Instructions

Follow these steps to configure and run the project:

1. **Install Java (JDK 8 or above)**  
   Make sure Java is installed and environment variables are properly configured.

2. **Install MySQL**  
   Create a database named `library`.

3. **Set Up Database Tables**  
   Create tables for books, users, and transactions in the `library` database.  
   (Refer to your own schema or use sample data for testing.)

4. **Add MySQL Connector JAR**  
   Download the JDBC driver from [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)  
   Place the JAR file inside your project directory.

5. **Compile the Project**
   ```bash
   javac -cp ".;mysql-connector-j-9.1.0.jar" *.java
   ```
   *(Use `:` instead of `;` on Linux/Mac.)*

6. **Run the Application**
   ```bash
   java -cp ".;mysql-connector-j-9.1.0.jar" LibraryManagement
   ```

---


