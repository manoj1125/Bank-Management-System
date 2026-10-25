-- 1. Create the database
CREATE DATABASE IF NOT EXISTS bankmanagementsystem;

-- 2. Select the database
USE bankmanagementsystem;

-- 3. Table for Page 1: Personal Details (SignUpOne)
CREATE TABLE IF NOT EXISTS signup (
    formno VARCHAR(20),
    name VARCHAR(50),
    father_name VARCHAR(50),
    dob VARCHAR(30),
    gender VARCHAR(15),
    email VARCHAR(50),
    marital_status VARCHAR(20),
    address VARCHAR(100),
    city VARCHAR(30),
    state VARCHAR(30),
    pincode VARCHAR(20),
    country VARCHAR(30)
);

-- 4. Table for Page 3: Account Details (SignUpThree)
CREATE TABLE IF NOT EXISTS signup3 (
    formno VARCHAR(20),
    accountType VARCHAR(50),
    cardno VARCHAR(30),
    pin VARCHAR(10),
    facility VARCHAR(100)
);

-- 5. Table for Login Credentials
CREATE TABLE IF NOT EXISTS login (
    formno VARCHAR(20),
    cardno VARCHAR(30),
    pin VARCHAR(10)
);

-- 6. Table for Transactions (Deposit, Withdrawal, Fast Cash)
CREATE TABLE IF NOT EXISTS bank (
    pin VARCHAR(10),
    date VARCHAR(50),
    mode VARCHAR(20),
    amount VARCHAR(20)
);