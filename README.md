# demo-dao-jdbc 💻🗃️

This project was developed as part of the Java Object-Oriented Programming (OOP) course, taught by Nelio Alves on Udemy. Its main goal is to demonstrate, in practice, how to implement the DAO (Data Access Object) pattern using JDBC for accessing relational databases in Java applications.

## 📄 Description

The **demo-dao-jdbc** project is a sample application that showcases essential concepts of OOP in Java, along with the application of the DAO pattern to separate data access logic from business logic. It uses JDBC to perform CRUD operations (Create, Read, Update, Delete) on a relational database, promoting best practices in code organization and maintainability.

This project is ideal for anyone looking to consolidate their knowledge about:

- 👨‍💻 Object-Oriented Programming in Java
- 🗄️ Integrating with databases using JDBC
- 📚 DAO pattern implementation
- 📝 Performing CRUD operations with JDBC
- 🏗️ Structuring Java projects in an organized way

## 🚀 Features

- Register, query, update, and remove records from the database
- Clear separation between the data access (DAO) and business layers
- Practical examples of using JDBC in Java

## 🛠️ Technologies used

- Java
- JDBC (Java Database Connectivity)
- Relational Database (MySQL, PostgreSQL, or any compatible database)
- Your preferred IDE (Eclipse, IntelliJ, VSCode, etc.)

## 🏁 How to run the project

1. Clone this repository:
   ```bash
   git clone https://github.com/xguimiranda/demo-dao-jdbc.git
   ```
2. Import the project into your favorite Java IDE.
3. Configure database access in the configuration file (URL, user, and password).
4. Run the application.

> **Note:** Make sure your database is created and configured correctly according to the course instructions.

## 🗂️ Database Structure (MySQL)

Below is the SQL code used to create and populate the database in MySQL Workbench:

```sql
CREATE TABLE department (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Name varchar(60) DEFAULT NULL,
  PRIMARY KEY (Id)
);

CREATE TABLE seller (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Name varchar(60) NOT NULL,
  Email varchar(100) NOT NULL,
  BirthDate datetime NOT NULL,
  BaseSalary double NOT NULL,
  DepartmentId int(11) NOT NULL,
  PRIMARY KEY (Id),
  FOREIGN KEY (DepartmentId) REFERENCES department (id)
);

INSERT INTO department (Name) VALUES 
  ('Computers'),
  ('Electronics'),
  ('Fashion'),
  ('Books');

INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES 
  ('Bob Brown','bob@gmail.com','1998-04-21 00:00:00',1000,1),
  ('Maria Green','maria@gmail.com','1979-12-31 00:00:00',3500,2),
  ('Alex Grey','alex@gmail.com','1988-01-15 00:00:00',2200,1),
  ('Martha Red','martha@gmail.com','1993-11-30 00:00:00',3000,4),
  ('Donald Blue','donald@gmail.com','2000-01-09 00:00:00',4000,3),
  ('Alex Pink','bob@gmail.com','1997-03-04 00:00:00',3000,2);
```

## 👏 Credits

This project was developed following the [Java COMPLETO 2023 Programação Orientada a Objetos + Projetos](https://www.udemy.com/course/java-curso-completo/) course by Nelio Alves on Udemy.

---

Feel free to use this project as a basis for your studies or future developments! 🚀
