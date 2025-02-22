# Assignment 3: Web Login & Registration System 📝💻

## Overview 🌐

This project consists of a dynamic web application that allows users to register, log in, and perform employee registration. It is built using Eclipse, JSP, HTML, and a DAO layer for database interaction. The project also incorporates form validation to enforce rules on user input and includes **hashing and decryption** for sensitive fields like `payRoll` and `requesterTel`.

### Project Breakdown 🔧

- **PART A**: Create a dynamic web project in Eclipse with login and register forms. 📝
- **PART B**: Add input validation for fields such as username, password, and required fields. 🔒
- **PART C**: Implement DAO code and connect the web forms to a database to allow user login and employee registration. 📊
- **PART D**: Implement **hashing** for sensitive fields (`payRoll`, `requesterTel`, and `fullName`) and **decryption** for verification. 🔐

---

## Features ✨

### Part A: Login & Register Forms 🔑

In this part of the project, two forms were created using HTML/JSP pages for login and register functionality. These forms are the entry point for the users to either sign in or create a new account.

**Features**:
- Login Form 🔑
- Register Form ✍️

**Images**:
  
![Login Form](./img/login.png)  
_Screenshot of the Login form_ 👨‍💻

![Register Form](./img/register.png)  
_Screenshot of the Register form_ ✨

![Success](./img/success.png)  
_Screenshot of the Success page_ ✨

---

### Part B: Validation Rules ✅

The code was modified to enforce validation on the user input. The following rules were applied:

- **Username**: Must be exactly 5 characters. 🔠
- **Password**: Must be alphanumeric and allow only numbers, `$`, and `_` (underscore). 🔒
- **Required Fields**: All fields must be filled out. ✅
- **No Special Characters**: Special characters are not allowed in any input fields. 🚫

---

### Part C: Database Integration and DAO Code 🗃️

This part involves the creation of DAO code that allows interaction with a database for storing user details. Upon successful login, users can register as employees, and their data will be inserted into the database.

The project is set up to run with **Wildfly** or **Apache Server**. 🌍

---

### Part D: Hashing and Decryption 🔐

To ensure data security, sensitive fields like `payRoll`, `requesterTel`, and `fullName` are hashed using **MD5** before being stored in the database. The original values are displayed in the console for verification purposes.

#### Hashing Logic
- **MD5 Hashing**: The `payRoll`, `requesterTel`, and `fullName` fields are hashed using the MD5 algorithm.
- **Integer Conversion**: For `payRoll` and `requesterTel`, the first 7 characters of the MD5 hash are converted to an integer using hexadecimal conversion.

#### Decryption Logic
- Since MD5 is a one-way hash function, decryption is not possible. Instead, the original values are stored in temporary fields (`originalPayRoll`, `originalRequesterTel`, and `originalFullName`) and displayed in the console for verification.

**Example**:
```java
   // Hashing
   String hashedPayRoll = Md5Hashing.getMd5(payRoll.toString()); // MD5 hash
   Integer hashedPayRollInt = Integer.parseInt(hashedPayRoll.substring(0, 7), 16); // Convert to integer

   // Decryption (display original values)
   System.out.println("Decrypted PayRoll: " + user.getOriginalPayRoll());
```

**Console Output**:
```
   Hashed PayRoll: 136169917
   Hashed RequesterTel: 39820921
   Hashed FullName: e7a3c8c90a380589ddad950c0c74f989
   Decrypted PayRoll: 1234
   Decrypted RequesterTel: 123456789
   Decrypted FullName: Brad
```

---

## Database Schema 🗃️

The `users` table schema is as follows:

| Column Name          | Data Type     | Description                     |
|----------------------|---------------|---------------------------------|
| `username`           | VARCHAR(255)  | Unique username (5 characters)  |
| `password`           | VARCHAR(255)  | User password                   |
| `company`            | VARCHAR(255)  | Company name                    |
| `pay_roll`           | INT           | Hashed payroll value            |
| `full_name`          | VARCHAR(255)  | Hashed full name                |
| `reference_indicator`| VARCHAR(255)  | Reference indicator             |
| `job_title`          | VARCHAR(255)  | Job title                       |
| `function_field`     | VARCHAR(255)  | Function field                  |
| `sub_function`       | VARCHAR(255)  | Sub-function                    |
| `section`            | VARCHAR(255)  | Section                         |
| `location`           | VARCHAR(255)  | Location                        |
| `building`           | VARCHAR(255)  | Building                        |
| `room`               | VARCHAR(255)  | Room                            |
| `requester_tel`      | INT           | Hashed requester telephone      |

## Getting Started 🚀

To get started with this project locally, follow the steps below.

### Prerequisites 🔑

- **Eclipse IDE** for Java EE Developers 🧑‍💻
- **Apache Tomcat** server 🖥️
- **JDK 8+** ☕
- **MySQL** or any relational database 🗄️
- **JDBC** Driver for database connection ⚙️

### Setup 🔧

1. **Clone the repository:**
   ```bash
   git clone https://github.com/SUKH2022/LoginRegistrationApp
   ```

2. Import the project in Eclipse:

- Open Eclipse IDE. 👩‍💻
- Go to File > Import. 📂
- Choose General > Existing Projects into Workspace. 🛠️
- Select the project folder and finish. ✅

3. Configure Database:

- Set up a MySQL or similar database with the appropriate schema for storing user and employee data. 🗄️
- Update the database connection settings in the DAO class to reflect your local environment. ⚙️

4. Run the Application:

- Configure Apache Tomcat as your runtime in Eclipse. 🌍
- Right-click on the project and select Run on Server. ▶️

5. Access the Web Application:

Once the server is running, open a browser and go to:
    ```bash
    http://localhost:8080/LoginRegistrationApp/login.jsp
    ```
