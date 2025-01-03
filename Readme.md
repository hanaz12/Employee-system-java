# Employees Management System

## Overview
The **Employees Management System** is a Java-based desktop application designed to streamline employee management tasks, including attendance tracking, payroll computation, and record updates. The application uses **Java Swing** for the graphical user interface and **MySQL** for data storage, providing a secure and user-friendly solution for managing workforce data.

This project is structured into modular components to enhance code readability, maintainability, and scalability.

---

## Features

### User Interfaces
1. **Home Interface**: Serves as the main navigation hub.
2. **Admin Portal**:
    - Add, update, and delete employee records.
    - View detailed employee data.
3. **Employee Portal**:
    - Login and registration.
    - Log work hours.
    - View personal details.
    - Automatic salary calculation based on logged hours (rate: $40/hour).

### Backend Operations
- **User Authentication**:
    - Secure login and password protection.
    - New user registration.
- **Data Management**:
    - Perform CRUD (Create, Read, Update, Delete) operations on employee records.
- **Payroll Management**:
    - Log and calculate work hours.
    - Generate real-time salary updates.

---

## Project Structure
The project is divided into the following packages:

### `config`
Holds configuration utilities for customizing the GUI and ensuring consistent design:
- **`ButtonCustomizer`**: A utility class for styling buttons.
- **`Schema`**: Provides common window properties for all frames.

### `frames`
Contains the main `JFrame` classes for application windows:
- `CheckFrame`
- `ControlFrame`
- `DeleteFrame`
- `DetailsFrame`
- `HomeFrame`
- `HoursFrame`
- `IntFrame`
- `LoginFrame`
- `SignupFrame`
- `UpdateFrame`

### `models`
Manages application-wide data:
- **`Data`**: A central class to handle session data and facilitate database operations.

### `panels`
Includes `JPanel` classes, each associated with its respective `JFrame`:
- `CheckPanel`
- `ControlPanel`
- `DeletePanel`
- `DetailsPanel`
- `HomePanel`
- `HoursPanel`
- `IntPanel`
- `LoginPanel`
- `SignupPanel`
- `UpdatePanel`

### `Main`
The entry point of the application.

---

## Technical Details

### Backend
- **Database**: MySQL
- **Table**: `employee_table`
    - **Schema**:
      ```sql
      CREATE TABLE employee_table (
          id INT PRIMARY KEY,
          name VARCHAR(255),
          department VARCHAR(255),
          phone BIGINT,
          password VARCHAR(255),
          hours INT,
          salary DOUBLE
      );
      ```

- **Database Connection**:
  The database connection is established using the MySQL Connector/J library. Update the connection string in the `Data` class if needed:
  ```java
  String url = "jdbc:mysql://localhost:3306/employee";
  String username = "root";
  String password = "root";
  ```

### Design Patterns
- **MVC (Model-View-Controller)**:
    - Models: Data handling (`Data` class).
    - Views: Frames and panels.
    - Controllers: Action listeners for user interaction.
- **Separation of Concerns**:
    - Panels and frames are separated to facilitate modular design and reusability.

---

## Prerequisites

### Required Software
- **Java Development Kit (JDK)**: Version 8 or higher.
- **MySQL Server**: Version 8.0 or higher.
- **MySQL Connector/J**: Latest version for database connectivity.

### Setup MySQL
1. Install and start MySQL Server.
2. Create the `employee` database:
   ```sql
   CREATE DATABASE employee;
   ```
3. Create the `employee_table` as per the schema provided above.

### Download MySQL Connector/J
1. [Download here](https://dev.mysql.com/downloads/connector/j/).
2. Add the `.jar` file to your project:
    - If using an IDE (e.g., IntelliJ, Eclipse): Add the `.jar` as an external library.
    - If using the command line: Place the `.jar` in a `lib` folder and reference it during compilation and execution.

---

## Installation

### 1. Configure Dependencies
Ensure the MySQL Connector/J is added to your project classpath.

### 2. Compile the Application
Using an IDE:
- Import the project and configure the classpath to include MySQL Connector/J.

Using the command line:
```bash
# Navigate to the project directory
cd employees-management-system

# Compile the code
javac -cp "lib/*" src/main/*.java -d out
```

### 3. Run the Application
```bash
# Run the compiled application
java -cp "out:lib/*" main.Main
```

---

## Usage
1. Launch the application.
2. Choose between the **Admin** or **Employee** portal.
3. Perform actions such as logging in, registering, managing records, or logging hours.

---

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.