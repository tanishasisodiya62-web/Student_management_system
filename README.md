# Student Management System

A simple **Java-based Student Management System** connected with a **MySQL database using JDBC**.

This project allows users to manage student records through a menu-driven console application.

## Features

* Add student records
* View all students
* Search student by ID
* Update student marks
* Delete student records
* Exit the application

## Technologies Used

* **Java**
* **JDBC (Java Database Connectivity)**
* **MySQL**
* **MySQL Connector/J**

## Database

The project uses a MySQL database named:

```text
studentdb
```

The student table contains:

| Column  | Description   |
| ------- | ------------- |
| `id`    | Student ID    |
| `name`  | Student Name  |
| `marks` | Student Marks |

## How It Works

The application provides a menu with different options:

```text
==== Student Management System ====
1. Add Students
2. View Students
3. Search Student
4. Update Marks
5. Delete Student
6. Exit
```

Users can select an option and perform the required operation on the student database.

## JDBC Operations Used

* `INSERT` — Add student
* `SELECT` — View and search students
* `UPDATE` — Update marks
* `DELETE` — Delete student

`PreparedStatement` is used to execute SQL queries.

## Setup

1. Install **Java JDK**.
2. Install **MySQL**.
3. Create a database named `studentdb`.
4. Create a `student` table with `id`, `name`, and `marks` columns.
5. Add the MySQL Connector/J library to the project.
6. Update the database username and password in the Java code.
7. Run the Java program.

## Learning Outcomes

Through this project, I practiced:

* Java programming
* JDBC database connectivity
* SQL queries
* CRUD operations
* `PreparedStatement`
* `ResultSet`
* Exception handling
* Console-based application development

## Author

**Tanisha Sisodiya**
