# ScholarBase – Student Records Software

A Java application that stores student records in a SQL database. It supports registering, viewing, searching, updating, and deleting students, and it is built with a layered architecture so the code stays organized and easy to maintain.

## Features

- Register a new student
- View all students
- Search for a student by ID
- Update a student's details
- Delete a student record

## Tech Stack

- **Language:** Java version 17
- **Database:** MySQL
- **Database access:** JDBC
- **Build tool:** Maven
- **IDE:** IntelliJ IDEA

## Project Structure

The code is split into layers, and each layer has one job:

| Layer | Purpose |
|-------|---------|
| **Model** | Classes that represent the data, such as `Student` |
| **DAO** (Data Access Object) | Talks to the database using SQL |
| **Service** | Holds the application logic between the user and the DAO |
| **Main / UI** | Takes user input and shows output or updates the database accordingly |

## Key Concepts Used

- Object-oriented programming (encapsulation, separation of concerns)
- Parameterized SQL queries (`PreparedStatement`) to keep queries safe and clean
- Exception handling for database errors
- Automatic closing of JDBC resources with try-with-resources
- 
## Author
TANIYA K 
