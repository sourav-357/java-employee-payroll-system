# Payroll System (Java, OOP-Based)

## Overview

A console-based Payroll Management System implemented in Java.
The project demonstrates core Object-Oriented Programming principles including **abstraction, inheritance, polymorphism**, and basic system design.

The application allows users to:

* Add full-time and part-time employees
* Automatically generate unique employee IDs
* Remove employees
* Display employee details and computed salaries

---

## Features

* **Auto-generated Unique IDs**

  * Eliminates duplicate ID issues
  * No manual input required

* **Employee Types**

  * Full-Time Employee (fixed monthly salary)
  * Part-Time Employee (hourly wage model)

* **Efficient Data Storage**

  * Uses `HashMap<Integer, Employee>` for O(1) operations

* **Menu-Driven CLI**

  * Simple and interactive console interface

* **Dynamic Salary Calculation**

  * Uses polymorphism via `calculateSalary()`

---

## Tech Stack

* Language: Java
* Concepts:

  * OOP (Abstraction, Inheritance, Polymorphism)
  * Collections Framework (`HashMap`)
  * CLI-based interaction (`Scanner`)

---

## Project Structure

```
.
├── Main.java
├── Employee (abstract class)
├── FullTimeEmployee
├── PartTimeEmployee
└── PayRollSystem
```

---

## How It Works

### Employee Hierarchy

* `Employee` → Abstract base class
* `FullTimeEmployee` → Fixed salary
* `PartTimeEmployee` → Hourly-based salary

### ID Generation

* Implemented using a static counter inside `Employee`
* Ensures uniqueness across all employee types

### Data Storage

* Employees stored in `HashMap`
* Key → Employee ID
* Value → Employee object

---

## Sample Menu

```
1. Add Full-Time Employee
2. Add Part-Time Employee
3. Remove Employee
4. Display Employees
5. Exit
```

---

## How to Run

1. Compile:

```
javac Main.java
```

2. Run:

```
java Main
```

---

## Example Output

```
Employee added successfully. ID = 1
Employee added successfully. ID = 2

Employee 1 [ID: 1, Name: John, Salary: 50000.0]
Employee 2 [ID: 2, Name: Alex, Salary: 2000.0]
```

---

## Design Decisions

* **System-generated IDs** → avoids collision and user errors
* **HashMap over ArrayList** → faster lookup and deletion
* **Polymorphism for salary calculation** → scalable for new employee types

---

## Limitations

* No persistent storage (data lost after program exit)
* No input validation (can be extended)
* CLI-based (no GUI)

---

## Possible Enhancements

* Add search and update functionality
* Persist data using file or database
* Introduce more employee types (Contract, Intern)
* Add validation and exception handling
* Convert into REST API (Spring Boot)

---

## Learning Outcomes

* Practical use of OOP concepts
* Designing extensible class hierarchies
* Using Java Collections effectively
* Building menu-driven applications

---

## Author

Sourav Kumar
