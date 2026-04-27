# Corporate Talent Hub - Java User Story

## Overview
This project evolves a basic employee console app into a dynamic, collection-based system.
It compares legacy Java 8/11 approaches with modern Java 21 features while preserving existing behavior.

## Tech Stack
- Java 21
- Maven project structure
- Package: `com.corporate.talenthub`

## Implemented Features

### 1) Dynamic Storage (Legacy to Better Design)
- Replaced static/fixed handling with dynamic collections.
- `ArrayList<Empleado>` for ordered employee storage.
- `HashMap<String, Empleado>` for fast lookup/removal by ID.
- Core operations:
	- add employee
	- list employees
	- remove employee by ID

### 2) Factory Methods (Java 9/11)
- Immutable catalogs in `CatalogosEstaticos`:
	- `List.of(...)` for technologies
	- `Map.of(...)` for branches
- Includes comments explaining immutability and why it is safer than mutable structures.

### 3) Legacy vs Modern Sequenced Access
- Legacy style:
	- first element with `get(0)`
	- last element with `get(size() - 1)`
- Java 21 style:
	- `getFirst()`
	- `getLast()`
	- `reversed()`
- Includes comparative comments about readability and error prevention.

### 4) Filtering and Reporting
- `removeIf(...)` implemented to filter employees by minimum salary.
- Payroll report includes:
	- total employees
	- average annual salary

### 5) Interactive Menu
Main flow in `MenuPrincipal` includes:
1. Register employee
2. List employees
3. Remove employee
4. Process quarterly performance
5. Filter by minimum salary
6. Payroll report
0. Exit

## Validation Rules
- Input is captured with `Scanner.nextLine()` and manually parsed.
- Validation methods use `while (true)` + `try/catch` and return only when valid.
- Invalid input does not crash the program.

## Run the Project
From project root:

```bash
javac -d out $(find src/main/java -name "*.java")
java -cp out com.corporate.talenthub.Main
```

## MVC + JDBC Version (Refactor)
New packages were added with clean separation using MVC:
- `com.riwi.talent.model`
- `com.riwi.talent.controller`
- `com.riwi.talent.view`
- `com.riwi.talent.util`

Run the JDBC-based version:

```bash
javac -d out $(find src/main/java -name "*.java")
DB_URL=jdbc:postgresql://localhost:5432/talenthub \
DB_USER=postgres \
DB_PASSWORD=postgres \
java -cp out com.riwi.talent.Main
```

If environment variables are not configured, default values are used from `DatabaseConnection`.

## Java Version Requirement
This code uses Java 21 APIs (`getFirst`, `getLast`, `reversed`), so run with JDK 21.
