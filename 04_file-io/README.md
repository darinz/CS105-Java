# File Input/Output (I/O) in Java

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![CS105](https://img.shields.io/badge/CS105-File%20I%2FO-007ACC?style=for-the-badge&logo=java&logoColor=white)](https://github.com/your-org/CS105-Java)
[![Status](https://img.shields.io/badge/Status-Complete-brightgreen?style=for-the-badge)](https://github.com/your-org/CS105-Java)

Welcome to the File Input/Output module of CS105 Java Programming! This section covers essential concepts for reading data from files and writing data to files, as well as handling user input through the console.

## Module Overview

File I/O is a fundamental concept that enables your Java programs to interact with external data sources, persist information between program executions, and process large datasets. This module provides comprehensive coverage of both console input and file operations.

## Learning Materials

### 1. [Scanner for User Input](./01_scanner.md) - Console Input Fundamentals
**Learning Objectives:**
- Master the `Scanner` class for reading user input
- Understand different input methods for various data types
- Learn input validation and error handling techniques
- Practice reading strings, integers, and floating-point numbers

**Key Concepts:**
- `Scanner` class setup and configuration
- Input methods: `next()`, `nextLine()`, `nextInt()`, `nextDouble()`
- Input validation with `hasNextInt()`, `hasNextDouble()`
- Handling the newline character issue
- Exception handling for invalid input

**Essential Methods:**
```java
Scanner console = new Scanner(System.in);
String name = console.nextLine();      // Read full line
int age = console.nextInt();           // Read integer
double gpa = console.nextDouble();     // Read decimal
String word = console.next();          // Read single word
```

### 2. [File I/O Operations](./02_file-io.md) - File Reading and Writing
**Learning Objectives:**
- Understand the `File` class and file system operations
- Master reading data from text files using `Scanner`
- Learn file output operations with `PrintStream`
- Implement robust error handling for file operations
- Process different data formats and patterns

**Key Concepts:**
- File object creation and path management
- Reading files line-by-line and token-by-token
- Processing numeric data from files
- Writing data to files with proper formatting
- Exception handling for file operations
- Best practices for file I/O

**Core File Operations:**
```java
// Reading from files
File file = new File("data.txt");
Scanner fileScanner = new Scanner(file);
while (fileScanner.hasNextLine()) {
    String line = fileScanner.nextLine();
    // Process the line
}

// Writing to files
PrintStream output = new PrintStream(new File("output.txt"));
output.println("Data to write");
```

### 3. [Practice, Reviews, and Applications](./03_practice-review-app.md) - Hands-on Practice
**Learning Objectives:**
- Apply file I/O concepts through practical programming problems
- Build complete applications that read from and write to files
- Practice data processing and analysis techniques
- Reinforce understanding through hands-on coding exercises

**Practice Problems:**
- **User Input Calculator**: Console input with validation
- **File Statistics Analyzer**: Reading and analyzing numeric data
- **Student Grade Manager**: Processing structured file data
- **Data Transformation Tool**: Converting between file formats
- **Log File Processor**: Analyzing text-based log files

## Learning Outcomes

By the end of this module, you will be able to:

- **Read user input** from the console using `Scanner` with proper validation
- **Create and manipulate** `File` objects for file system operations
- **Read data from text files** using various `Scanner` methods
- **Write data to files** using `PrintStream` with proper formatting
- **Handle file I/O exceptions** gracefully with try-catch blocks
- **Process different data formats** including numbers, text, and structured data
- **Build complete applications** that interact with files and user input
- **Implement data analysis** programs that read from files and generate reports
- **Apply best practices** for file I/O operations and error handling

## Prerequisites

Before starting this module, you should be comfortable with:
- Basic Java syntax and program structure
- Variables, data types, and expressions
- Control structures (loops and conditionals)
- Method creation and calling
- Basic exception handling concepts

## Getting Started

1. **Review the Scanner fundamentals** in [01_scanner.md](./01_scanner.md)
2. **Learn file operations** in [02_file-io.md](./02_file-io.md)
3. **Practice with hands-on problems** in [03_practice-review-app.md](./03_practice-review-app.md)

## Key Import Statements

```java
import java.io.*;    // File, PrintStream, FileNotFoundException
import java.util.*;  // Scanner, InputMismatchException, NoSuchElementException
```

## Common Patterns

### Reading User Input
```java
Scanner console = new Scanner(System.in);
System.out.print("Enter your name: ");
String name = console.nextLine();
```

### Reading from Files
```java
File file = new File("data.txt");
Scanner fileScanner = new Scanner(file);
while (fileScanner.hasNextLine()) {
    String line = fileScanner.nextLine();
    // Process each line
}
fileScanner.close();
```

### Writing to Files
```java
PrintStream output = new PrintStream(new File("output.txt"));
output.println("Hello, World!");
output.close();
```

### Exception Handling
```java
try {
    File file = new File("data.txt");
    Scanner scanner = new Scanner(file);
    // File operations here
    scanner.close();
} catch (FileNotFoundException e) {
    System.out.println("File not found: " + e.getMessage());
}
```

## Next Steps

After completing this module, you'll be ready to:
- Work with more complex data structures (ArrayLists, Maps)
- Implement object-oriented programming concepts
- Build larger applications that require persistent data storage
- Process and analyze real-world datasets

## Additional Resources

- [Java File I/O Documentation](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/package-summary.html)
- [Scanner Class Documentation](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Scanner.html)
- [File Class Documentation](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/File.html)

---

**Estimated Time to Complete:** 4-6 hours  
**Difficulty Level:** Intermediate  
**Prerequisites:** Basic Java programming concepts 