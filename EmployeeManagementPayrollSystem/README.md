# Employee Management & Payroll System

## Features
- Dashboard with employee count
- Employee CRUD (create, list, edit, delete)
- Monthly payroll generation (basic salary + allowance - deduction)
- Payroll history and deletion
- Spring Boot, Thymeleaf, Spring Data JPA, MySQL

## Requirements
Java 21, Maven, MySQL 8+, IDE (optional).

## Setup
1. Create database:
```sql
CREATE DATABASE employee_payroll_db;
```
2. Edit `src/main/resources/application.properties` and set `spring.datasource.password` to your MySQL password.
3. From project root, run:
```bash
mvn clean install
mvn spring-boot:run
```
4. Open http://localhost:8080

## Pages
- `/` dashboard
- `/employees` employee list
- `/employees/add` add employee
- `/payroll` generate and view payroll

## Payroll calculation
Net salary = Basic salary + allowance - deduction.
