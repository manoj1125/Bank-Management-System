# 🏦 Banking & ATM Management System

A desktop-based Banking and ATM Management application built using **Java (Swing & AWT)** for the graphical user interface and **MySQL** for backend data management via **JDBC**. This application simulates a fully functional ATM machine and a bank account registration workflow.

---

## 🚀 Key Features

* **User Registration (Multi-Step Form):**
  * **Page 1 (`SignUpOne`):** Collects personal details (Name, Father's Name, Date of Birth, Gender, Marital Status, Address, etc.).
  * **Page 3 (`SignUpThree`):** Account type selection (Savings, Current, Fixed Deposit, Recurring Deposit) with auto-generated 16-digit Card Numbers and 4-digit PINs. Additional service checkboxes (Internet Banking, Mobile Banking, Cheque Book, etc.).
* **Secure Login (`Login.java`):** Authenticates users against stored database records using their Card Number and PIN.
* **ATM Transactions:**
  * **Deposit (`Deposit.java`):** Allows users to deposit custom amounts into their accounts with timestamped logging.
  * **Fast Cash (`FastCash.java`):** Quick withdrawal options (Rs 100, 500, 1000, 2000, 5000, 10000) with real-time balance validation.
  * **Mini Statement (`MiniStatement.java`):** Displays masked card details, a chronological list of recent transactions, and total current balance.

---

## 🛠️ Tech Stack

* **Programming Language:** Java
* **UI Frameworks:** Java Swing, AWT
* **Database:** MySQL
* **Connectivity:** JDBC (MySQL Connector/J)

---

## 🗄️ Database Setup

To set up the MySQL database for this project:

1. Open your MySQL client (e.g., **MySQL Workbench** or MySQL Command Line).
2. Run the provided **`database.sql`** script to automatically create the database (`bankmanagementsystem`) and required tables (`signup`, `signup3`, `login`, and `bank`).
3. Update your database credentials in **`Conn.java`**:
   ```java
   c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "your_password");
