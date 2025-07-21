# Java File I/O: Comprehensive Guide

## Table of Contents
1. [Introduction to File I/O](#introduction)
2. [File Class Fundamentals](#file-class)
3. [Scanner for File Input](#scanner-input)
4. [Reading Patterns](#reading-patterns)
5. [Numeric Data Processing](#numeric-data)
6. [File Output with PrintStream](#file-output)
7. [Exception Handling](#exception-handling)
8. [Best Practices](#best-practices)
9. [Complete Example: Movie Ratings System](#complete-example)

## Introduction to File I/O {#introduction}

File Input/Output (I/O) is a fundamental concept in programming that allows your Java programs to read data from files and write data to files. This enables persistent data storage and the ability to process external data sources.

### Why File I/O Matters
- **Data Persistence**: Save program state between executions
- **Data Processing**: Read and analyze large datasets
- **Configuration**: Load settings and parameters
- **Logging**: Record program events and errors
- **Data Exchange**: Import/export data in various formats

### Key Java I/O Classes
```java
import java.io.*;  // File, PrintStream, FileNotFoundException
import java.util.*; // Scanner, InputMismatchException, NoSuchElementException
```

## File Class Fundamentals {#file-class}

The `File` class represents a file or directory path in the file system. It's the foundation for file operations in Java.

### Creating File Objects
```java
// Different ways to create File objects
// Note: Creating a File object doesn't create the actual file on disk
// It just creates a reference to a file path

// Method 1: Simple relative path (relative to current working directory)
File file1 = new File("data.txt");
// This looks for "data.txt" in the same folder as your Java program

// Method 2: Absolute path (full path from root directory)
File file2 = new File("/Users/username/data.txt");
// This specifies the exact location on the file system
// Works on Unix/Linux/Mac systems

// Method 3: Directory + filename (relative to current directory)
File file3 = new File("folder", "data.txt");
// This looks for "data.txt" inside a "folder" subdirectory

// Method 4: Using another File object as the parent directory
File folder = new File("folder");
File file4 = new File(folder, "data.txt");
// This is equivalent to Method 3 but more explicit
```

### File Properties and Methods
```java
// Create a File object (remember, this doesn't create the actual file)
File file = new File("example.txt");

// IMPORTANT: Always check if file exists before trying to read from it
// This prevents FileNotFoundException and makes your program more robust
if (file.exists()) {
    System.out.println("File exists!");
} else {
    System.out.println("File does not exist - you may need to create it first");
}

// Get file information - these methods are useful for file management
System.out.println("Name: " + file.getName());           // Just the filename: "example.txt"
System.out.println("Path: " + file.getPath());           // The path as specified: "example.txt"
System.out.println("Absolute path: " + file.getAbsolutePath()); // Full path: "/home/user/example.txt"
System.out.println("Size: " + file.length() + " bytes"); // File size in bytes
System.out.println("Can read: " + file.canRead());       // Check if program has read permission
System.out.println("Can write: " + file.canWrite());     // Check if program has write permission

// Additional useful methods:
System.out.println("Is file: " + file.isFile());         // True if it's a file (not a directory)
System.out.println("Is directory: " + file.isDirectory()); // True if it's a directory
System.out.println("Last modified: " + new Date(file.lastModified())); // When file was last changed
```

## Scanner for File Input {#scanner-input}

The `Scanner` class is the primary tool for reading text data from files. It provides methods to parse different data types and handle various input formats.

### Basic Scanner Setup
```java
// Import necessary packages for file operations and input processing
import java.io.*;    // Provides File, FileNotFoundException, PrintStream classes
import java.util.*;  // Provides Scanner, InputMismatchException classes

/**
 * Example class demonstrating basic file reading with Scanner
 * This is the foundation for all file input operations in Java
 */
public class FileReaderExample {
    public static void main(String[] args) {
        // Use try-catch block to handle potential file errors gracefully
        try {
            // Step 1: Create a File object representing the file on disk
            // This doesn't actually open the file yet - it just creates a reference
            File file = new File("data.txt");
            
            // Step 2: Create a Scanner object connected to the file
            // This is when the file actually gets opened for reading
            // Scanner will read the file as text, one token or line at a time
            Scanner scanner = new Scanner(file);
            
            // Step 3: Read and process file content here
            // (We'll add specific reading logic in the examples below)
            
            // Step 4: Always close the scanner when done!
            // This releases the file handle and frees up system resources
            // If you don't close it, the file might remain locked
            scanner.close();
            
        } catch (FileNotFoundException e) {
            // This exception occurs if the file doesn't exist or can't be accessed
            // Always provide helpful error messages to users
            System.out.println("Error: File not found - " + e.getMessage());
        }
    }
}
```

### Scanner Methods Overview

| Method | Returns | Description |
|--------|---------|-------------|
| `hasNext()` | boolean | Checks if there's another token available |
| `hasNextLine()` | boolean | Checks if there's another line available |
| `hasNextInt()` | boolean | Checks if next token is an integer |
| `hasNextDouble()` | boolean | Checks if next token is a double |
| `next()` | String | Returns next token (whitespace-delimited) |
| `nextLine()` | String | Returns next line (including whitespace) |
| `nextInt()` | int | Returns next token as integer |
| `nextDouble()` | double | Returns next token as double |
| `useDelimiter(String)` | Scanner | Sets custom delimiter pattern |

## Reading Patterns {#reading-patterns}

There are three main patterns for reading files, each suited for different data formats and processing needs.

### 1. Line-by-Line Reading
**Best for:** Text files where each line is a complete unit of data (like a record, sentence, or complete thought).

**When to use this pattern:**
- Reading configuration files
- Processing log files
- Reading CSV files where you want to process each row as a whole
- Text files where line breaks have meaning

```java
/**
 * Reads a file line by line, processing each line as a complete unit
 * This is the simplest and most straightforward reading pattern
 */
public static void readLineByLine(String filename) {
    try {
        // Step 1: Create File object and check if it exists
        File file = new File(filename);
        if (!file.exists()) {
            System.err.println("File does not exist: " + filename);
            return;
        }
        
        // Step 2: Create Scanner connected to the file
        Scanner scanner = new Scanner(file);
        
        // Step 3: Read each line until there are no more lines
        // hasNextLine() returns true if there's another line to read
        while (scanner.hasNextLine()) {
            // nextLine() reads the entire line (including spaces) and moves to next line
            String line = scanner.nextLine();
            System.out.println("Line: " + line);
            
            // Process the entire line as a unit
            // You could split it, parse it, or analyze it here
        }
        
        // Step 4: Always close the scanner to free resources
        scanner.close();
        
    } catch (FileNotFoundException e) {
        // This shouldn't happen if we checked file.exists(), but good practice
        System.err.println("File not found: " + filename);
    }
}
```

**Example file (names.txt):**
```
John Doe
Jane Smith
Bob Johnson
```

### 2. Token-by-Token Reading
**Best for:** Files with structured data where individual words/numbers are meaningful units.

**When to use this pattern:**
- Reading lists of numbers
- Processing space-separated data
- Reading individual words from text
- When you need to process each piece of data separately

**What is a "token"?**
- A token is a sequence of characters separated by whitespace (spaces, tabs, newlines)
- Examples: "hello", "42", "3.14", "world" are all tokens
- Scanner automatically skips whitespace between tokens

```java
/**
 * Reads a file token by token, processing each word/number individually
 * This pattern ignores line breaks and treats the file as a stream of tokens
 */
public static void readTokenByToken(String filename) {
    try {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        
        // Step 1: Read each token until there are no more tokens
        // hasNext() returns true if there's another token to read
        while (scanner.hasNext()) {
            // next() reads the next token and skips any whitespace
            // A token is a sequence of characters separated by whitespace
            String token = scanner.next();
            System.out.println("Token: " + token);
            
            // Process each token individually
            // You could convert to numbers, count them, etc.
        }
        
        scanner.close();
    } catch (FileNotFoundException e) {
        System.err.println("File not found: " + filename);
    }
}
```

**Example file (numbers.txt):**
```
10 20 30 40 50
60 70 80 90 100
```

### 3. Hybrid Pattern (Line-by-Line, then Token-by-Token)
**Best for:** Complex files where each line contains multiple data fields that need to be processed separately.

**When to use this pattern:**
- CSV files where you need to process each field
- Data files with multiple columns per row
- Files where line structure matters but you need individual pieces
- Processing structured records

**Why use this pattern?**
- You get the benefits of both line-by-line and token-by-token reading
- You can process each line as a unit (like a record)
- You can also break down each line into its component parts

```java
/**
 * Hybrid pattern: Read line by line, then process each line token by token
 * This is the most flexible pattern for complex data files
 */
public static void readHybridPattern(String filename) {
    try {
        File file = new File(filename);
        Scanner fileScanner = new Scanner(file);
        
        // Step 1: Read each line from the file
        while (fileScanner.hasNextLine()) {
            // Get the current line as a string
            String line = fileScanner.nextLine();
            
            // Step 2: Create a new Scanner for this specific line
            // This allows us to process the line's tokens separately
            Scanner lineScanner = new Scanner(line);
            
            // Step 3: Process each token in the current line
            while (lineScanner.hasNext()) {
                String token = lineScanner.next();
                System.out.print(token + " ");
            }
            
            // Step 4: Move to next line after processing current line
            System.out.println(); // New line after processing each line
            
            // IMPORTANT: Close the line scanner to free resources
            // Each line gets its own scanner, so we need to close each one
            lineScanner.close();
        }
        
        // Step 5: Close the main file scanner
        fileScanner.close();
        
    } catch (FileNotFoundException e) {
        System.err.println("File not found: " + filename);
    }
}
```

**Example file (student_data.txt):**
```
John Doe 85 92 78
Jane Smith 95 88 91
Bob Johnson 72 85 79
```

### Advanced Hybrid Pattern with Custom Delimiters
**What are delimiters?**
- A delimiter is a character or pattern that separates data fields
- Default delimiter: whitespace (spaces, tabs, newlines)
- Common delimiters: commas (,), tabs (\t), semicolons (;), pipes (|)

**Why use custom delimiters?**
- CSV files use commas to separate fields
- TSV files use tabs to separate fields
- Some files use other characters as separators

```java
/**
 * Advanced hybrid pattern with custom delimiter for CSV files
 * This shows how to handle comma-separated values properly
 */
public static void readCSVFile(String filename) {
    try {
        File file = new File(filename);
        Scanner fileScanner = new Scanner(file);
        
        // Step 1: Read each line from the file
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            
            // Step 2: Create a Scanner for this line with custom delimiter
            Scanner lineScanner = new Scanner(line);
            
            // KEY CONCEPT: Set custom delimiter to comma
            // This tells Scanner to treat commas as field separators instead of whitespace
            lineScanner.useDelimiter(",");
            
            // Step 3: Process each field (separated by commas)
            while (lineScanner.hasNext()) {
                // next() now returns everything up to the next comma
                String field = lineScanner.next();
                
                // trim() removes leading and trailing whitespace
                // This is important because CSV fields might have spaces around them
                field = field.trim();
                
                System.out.print("[" + field + "] ");
            }
            System.out.println(); // New line after each row
            
            lineScanner.close();
        }
        
        fileScanner.close();
    } catch (FileNotFoundException e) {
        System.err.println("File not found: " + filename);
    }
}

/**
 * Alternative method for reading TSV (Tab-Separated Values) files
 * This is very similar to CSV but uses tabs instead of commas
 */
public static void readTSVFile(String filename) {
    try {
        File file = new File(filename);
        Scanner fileScanner = new Scanner(file);
        
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            
            // Use tab as delimiter for TSV files
            lineScanner.useDelimiter("\t");
            
            while (lineScanner.hasNext()) {
                String field = lineScanner.next().trim();
                System.out.print("[" + field + "] ");
            }
            System.out.println();
            
            lineScanner.close();
        }
        
        fileScanner.close();
    } catch (FileNotFoundException e) {
        System.err.println("File not found: " + filename);
    }
}
```

**Example CSV file (students.csv):**
```
Name,Age,Grade
John Doe,20,A
Jane Smith,19,B+
Bob Johnson,21,A-
```

## Numeric Data Processing {#numeric-data}

When working with numeric data, Scanner provides specialized methods for type-safe reading.

### Reading Mixed Data Types
**Key Concept:** Scanner can read different data types from the same file or line, but you must check the data type before reading it.

**Why check data types?**
- `nextInt()` will throw `InputMismatchException` if the next token isn't a number
- `nextDouble()` will throw `InputMismatchException` if the next token isn't a decimal number
- Always use `hasNextInt()`, `hasNextDouble()`, etc. before calling the corresponding `next()` methods

```java
/**
 * Demonstrates reading mixed data types from a file
 * This is common when processing structured data files
 */
public static void readNumericData(String filename) {
    try {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            
            // Step 1: Always check if there's data before trying to read it
            if (lineScanner.hasNext()) {
                // Read the name (always a string)
                String name = lineScanner.next();
                
                // Step 2: Check if next token is an integer before reading it
                if (lineScanner.hasNextInt()) {
                    int age = lineScanner.nextInt();
                    
                    // Step 3: Check if next token is a double before reading it
                    if (lineScanner.hasNextDouble()) {
                        double score = lineScanner.nextDouble();
                        
                        // Process the complete record
                        System.out.printf("Name: %s, Age: %d, Score: %.2f%n", 
                                        name, age, score);
                    } else {
                        System.out.println("Missing or invalid score for: " + name);
                    }
                } else {
                    System.out.println("Missing or invalid age for: " + name);
                }
            }
            
            lineScanner.close();
        }
        
        scanner.close();
    } catch (FileNotFoundException e) {
        System.err.println("File not found: " + filename);
    }
}

/**
 * Alternative approach using try-catch for more robust error handling
 */
public static void readNumericDataRobust(String filename) {
    try {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            
            try {
                // Try to read all three fields
                String name = lineScanner.next();
                int age = lineScanner.nextInt();
                double score = lineScanner.nextDouble();
                
                System.out.printf("Name: %s, Age: %d, Score: %.2f%n", 
                                name, age, score);
                
            } catch (InputMismatchException e) {
                // If any field is the wrong type, skip this line
                System.out.println("Skipping invalid line: " + line);
            } catch (NoSuchElementException e) {
                // If there aren't enough fields, skip this line
                System.out.println("Skipping incomplete line: " + line);
            }
            
            lineScanner.close();
        }
        
        scanner.close();
    } catch (FileNotFoundException e) {
        System.err.println("File not found: " + filename);
    }
}
```

### Processing Numeric Data with Validation
**Key Concept:** When processing numeric data, it's important to validate the data and handle edge cases properly.

**Common validation tasks:**
- Check if data exists before processing
- Calculate statistics (sum, average, min, max)
- Handle empty files or invalid data
- Provide meaningful output even when no data is found

```java
/**
 * Processes numeric data from a file and calculates basic statistics
 * This demonstrates how to handle numeric data validation and processing
 */
public static void processNumericData(String filename) {
    try {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        
        // Initialize variables for calculating statistics
        double sum = 0.0;                    // Running total of all numbers
        int count = 0;                       // Number of valid numbers found
        double min = Double.MAX_VALUE;       // Start with largest possible value
        double max = Double.MIN_VALUE;       // Start with smallest possible value
        
        // Read each line from the file
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            
            // Process each number on the current line
            while (lineScanner.hasNextDouble()) {
                double value = lineScanner.nextDouble();
                
                // Update statistics
                sum += value;                 // Add to running total
                count++;                      // Increment count
                min = Math.min(min, value);   // Update minimum if smaller
                max = Math.max(max, value);   // Update maximum if larger
            }
            
            lineScanner.close();
        }
        
        // Step 2: Calculate and display results (only if we found data)
        if (count > 0) {
            double average = sum / count;     // Calculate average
            
            System.out.printf("Count: %d%n", count);
            System.out.printf("Sum: %.2f%n", sum);
            System.out.printf("Average: %.2f%n", average);
            System.out.printf("Min: %.2f%n", min);
            System.out.printf("Max: %.2f%n", max);
        } else {
            // Handle case where no valid numbers were found
            System.out.println("No numeric data found in the file.");
        }
        
        scanner.close();
    } catch (FileNotFoundException e) {
        System.err.println("File not found: " + filename);
    }
}

/**
 * Enhanced version with more detailed validation and error handling
 */
public static void processNumericDataEnhanced(String filename) {
    try {
        File file = new File(filename);
        
        // Check if file exists and is readable
        if (!file.exists()) {
            System.err.println("File does not exist: " + filename);
            return;
        }
        
        if (!file.canRead()) {
            System.err.println("File is not readable: " + filename);
            return;
        }
        
        Scanner scanner = new Scanner(file);
        
        double sum = 0.0;
        int count = 0;
        int invalidLines = 0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        
        int lineNumber = 0;
        while (scanner.hasNextLine()) {
            lineNumber++;
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            
            boolean lineHasValidData = false;
            while (lineScanner.hasNext()) {
                if (lineScanner.hasNextDouble()) {
                    double value = lineScanner.nextDouble();
                    sum += value;
                    count++;
                    min = Math.min(min, value);
                    max = Math.max(max, value);
                    lineHasValidData = true;
                } else {
                    // Skip invalid tokens (non-numeric data)
                    lineScanner.next();
                }
            }
            
            if (!lineHasValidData) {
                invalidLines++;
                System.out.println("Line " + lineNumber + " contains no valid numbers: " + line);
            }
            
            lineScanner.close();
        }
        
        // Display comprehensive results
        System.out.println("=== Data Processing Results ===");
        System.out.printf("Total lines processed: %d%n", lineNumber);
        System.out.printf("Lines with invalid data: %d%n", invalidLines);
        
        if (count > 0) {
            double average = sum / count;
            System.out.printf("Valid numbers found: %d%n", count);
            System.out.printf("Sum: %.2f%n", sum);
            System.out.printf("Average: %.2f%n", average);
            System.out.printf("Min: %.2f%n", min);
            System.out.printf("Max: %.2f%n", max);
        } else {
            System.out.println("No valid numeric data found.");
        }
        
        scanner.close();
    } catch (FileNotFoundException e) {
        System.err.println("File not found: " + filename);
    }
}
```

### Practice Problem Solution
Let's solve the practice problem step by step with detailed explanations:

**Code Analysis:**
```java
// Create a Scanner to read from the file "data.txt"
Scanner fileScan = new Scanner(new File("data.txt"));

// Read the file line by line
while (fileScan.hasNextLine()) {
    // Get the current line as a string
    String line = fileScan.nextLine();
    
    // Create a new Scanner to process this specific line
    Scanner lineScan = new Scanner(line);
    
    // Read the first number and use it to initialize both min and max
    // This is a common pattern: start with the first value
    double min = lineScan.nextDouble();
    double max = min;  // Initially, min and max are the same
    
    // Process all remaining numbers on this line
    while (lineScan.hasNextDouble()) {
        double nextNum = lineScan.nextDouble();
        min = Math.min(min, nextNum);  // Update min if we found a smaller number
        max = Math.max(max, nextNum);  // Update max if we found a larger number
    }
    
    // Print the results for this line
    System.out.println("Max: " + max + ", Min: " + min);
}
```

**Data file (data.txt):**
```
2.3 9.2
17 0.73
-1.5000
```

**Step-by-Step Execution Trace:**

**Line 1 Processing: "2.3 9.2"**
1. `line = "2.3 9.2"`
2. `lineScan = new Scanner("2.3 9.2")`
3. `min = lineScan.nextDouble()` → `min = 2.3`
4. `max = min` → `max = 2.3`
5. `lineScan.hasNextDouble()` → `true` (there's still "9.2" to read)
6. `nextNum = lineScan.nextDouble()` → `nextNum = 9.2`
7. `min = Math.min(2.3, 9.2)` → `min = 2.3` (no change)
8. `max = Math.max(2.3, 9.2)` → `max = 9.2`
9. `lineScan.hasNextDouble()` → `false` (no more numbers)
10. Output: `"Max: 9.2, Min: 2.3"`

**Line 2 Processing: "17 0.73"**
1. `line = "17 0.73"`
2. `lineScan = new Scanner("17 0.73")`
3. `min = lineScan.nextDouble()` → `min = 17.0`
4. `max = min` → `max = 17.0`
5. `lineScan.hasNextDouble()` → `true` (there's still "0.73" to read)
6. `nextNum = lineScan.nextDouble()` → `nextNum = 0.73`
7. `min = Math.min(17.0, 0.73)` → `min = 0.73` (found smaller number)
8. `max = Math.max(17.0, 0.73)` → `max = 17.0` (no change)
9. `lineScan.hasNextDouble()` → `false` (no more numbers)
10. Output: `"Max: 17.0, Min: 0.73"`

**Line 3 Processing: "-1.5000"**
1. `line = "-1.5000"`
2. `lineScan = new Scanner("-1.5000")`
3. `min = lineScan.nextDouble()` → `min = -1.5`
4. `max = min` → `max = -1.5`
5. `lineScan.hasNextDouble()` → `false` (only one number on this line)
6. No loop iterations (while condition is false)
7. Output: `"Max: -1.5, Min: -1.5"`

**Key Learning Points:**
- The program processes each line independently
- For each line, it finds the minimum and maximum values
- If a line has only one number, min and max are the same
- The program outputs results for each line separately

**Answer: A)** The program outputs three lines showing the min/max for each line:
```
Max: 9.2, Min: 2.3
Max: 17.0, Min: 0.73
Max: -1.5, Min: -1.5
```

## File Output with PrintStream {#file-output}

PrintStream is used for writing formatted text output to files, similar to how System.out works for console output.

### Basic PrintStream Usage
**Key Concept:** PrintStream is used for writing formatted text output to files, just like System.out writes to the console.

**Important differences from System.out:**
- System.out writes to the console (screen)
- PrintStream writes to a file
- Both use the same methods (print, println, printf)
- Always close PrintStream when done to ensure data is written

```java
import java.io.*;

/**
 * Demonstrates basic file output using PrintStream
 * This is the foundation for writing data to files
 */
public class FileWriterExample {
    public static void main(String[] args) {
        try {
            // Step 1: Create a File object for the output file
            // If the file doesn't exist, it will be created
            // If it exists, it will be overwritten (be careful!)
            File outputFile = new File("output.txt");
            
            // Step 2: Create a PrintStream connected to the file
            // This opens the file for writing
            PrintStream output = new PrintStream(outputFile);
            
            // Step 3: Write different types of data to the file
            // These methods work exactly like System.out methods
            
            output.println("Hello, World!");           // Write string with newline
            output.print("Number: ");                  // Write string without newline
            output.println(42);                        // Write number with newline
            output.printf("Pi: %.4f%n", Math.PI);      // Formatted output with newline
            output.println("Boolean: " + true);        // Write boolean with newline
            
            // Step 4: Always close the PrintStream!
            // This ensures all data is written to the file and frees resources
            output.close();
            
            System.out.println("Data written to output.txt successfully!");
            
        } catch (FileNotFoundException e) {
            // This exception occurs if the file can't be created
            // (e.g., directory doesn't exist, no write permission)
            System.err.println("Error creating file: " + e.getMessage());
        }
    }
}

/**
 * Alternative approach using try-with-resources (recommended)
 * This automatically closes the PrintStream when done
 */
public class FileWriterExample2 {
    public static void main(String[] args) {
        // Try-with-resources automatically closes the PrintStream
        try (PrintStream output = new PrintStream(new File("output2.txt"))) {
            
            // Write data to file
            output.println("This is line 1");
            output.println("This is line 2");
            output.printf("The answer is: %d%n", 42);
            
            System.out.println("Data written successfully!");
            
        } catch (FileNotFoundException e) {
            System.err.println("Error creating file: " + e.getMessage());
        }
        // PrintStream is automatically closed here, even if an exception occurs
    }
}
```

### PrintStream Methods

| Method | Description | Example |
|--------|-------------|---------|
| `print(String)` | Prints string without newline | `output.print("Hello");` |
| `println(String)` | Prints string with newline | `output.println("World");` |
| `print(int)` | Prints integer | `output.print(42);` |
| `println(int)` | Prints integer with newline | `output.println(42);` |
| `print(double)` | Prints double | `output.print(3.14);` |
| `println(double)` | Prints double with newline | `output.println(3.14);` |
| `printf(String, Object...)` | Formatted printing | `output.printf("Value: %.2f", 3.14159);` |

### Advanced File Output Examples

#### Writing Tabular Data
**Key Concept:** PrintStream's `printf` method allows you to format output with precise control over spacing and alignment.

**Format specifiers used:**
- `%s` - String
- `%d` - Integer
- `%f` - Float/Double
- `%-15s` - Left-aligned string with 15 character width
- `%10.2f` - Right-aligned float with 10 character width, 2 decimal places

```java
/**
 * Demonstrates writing formatted table data to a file
 * This is useful for creating reports, data exports, and readable output
 */
public static void writeTableData(String filename) {
    try {
        File file = new File(filename);
        PrintStream output = new PrintStream(file);
        
        // Step 1: Write table header with proper formatting
        // %-15s means: left-aligned string with 15 character width
        output.printf("%-15s %-10s %-10s%n", "Name", "Age", "Score");
        
        // Step 2: Write separator line for visual clarity
        output.println("----------------------------------------");
        
        // Step 3: Write data rows with consistent formatting
        // %-15s: left-aligned name, 15 characters wide
        // %-10d: left-aligned age, 10 characters wide
        // %-10.2f: left-aligned score, 10 characters wide, 2 decimal places
        output.printf("%-15s %-10d %-10.2f%n", "John Doe", 20, 85.5);
        output.printf("%-15s %-10d %-10.2f%n", "Jane Smith", 19, 92.3);
        output.printf("%-15s %-10d %-10.2f%n", "Bob Johnson", 21, 78.9);
        
        output.close();
        System.out.println("Table data written to " + filename);
        
    } catch (FileNotFoundException e) {
        System.err.println("Error writing file: " + e.getMessage());
    }
}

/**
 * Enhanced version that writes data from arrays or collections
 */
public static void writeTableDataFromArrays(String filename) {
    // Sample data arrays
    String[] names = {"John Doe", "Jane Smith", "Bob Johnson", "Alice Brown"};
    int[] ages = {20, 19, 21, 22};
    double[] scores = {85.5, 92.3, 78.9, 95.1};
    
    try (PrintStream output = new PrintStream(new File(filename))) {
        
        // Write header
        output.printf("%-20s %-8s %-10s %-12s%n", "Name", "Age", "Score", "Grade");
        output.println("--------------------------------------------------------");
        
        // Write data rows from arrays
        for (int i = 0; i < names.length; i++) {
            // Calculate grade based on score
            String grade = calculateGrade(scores[i]);
            
            output.printf("%-20s %-8d %-10.2f %-12s%n", 
                         names[i], ages[i], scores[i], grade);
        }
        
        System.out.println("Table data written to " + filename);
        
    } catch (FileNotFoundException e) {
        System.err.println("Error writing file: " + e.getMessage());
    }
}

/**
 * Helper method to calculate letter grade
 */
private static String calculateGrade(double score) {
    if (score >= 90) return "A";
    else if (score >= 80) return "B";
    else if (score >= 70) return "C";
    else if (score >= 60) return "D";
    else return "F";
}
```

#### Writing CSV Data
**Key Concept:** CSV (Comma-Separated Values) is a common format for data exchange between programs.

**CSV Format Rules:**
- Fields are separated by commas
- Each row is on a separate line
- No spaces around commas (unless part of the data)
- Simple and widely supported format

```java
/**
 * Demonstrates writing CSV (Comma-Separated Values) data to a file
 * CSV is a simple, universal format for data exchange
 */
public static void writeCSVData(String filename) {
    try {
        File file = new File(filename);
        PrintStream output = new PrintStream(file);
        
        // Step 1: Write CSV header (column names)
        // Each field is separated by a comma
        output.println("Name,Age,City,Salary");
        
        // Step 2: Write CSV data rows
        // Each row contains the same number of fields as the header
        output.println("John Doe,25,New York,50000");
        output.println("Jane Smith,30,Los Angeles,60000");
        output.println("Bob Johnson,35,Chicago,55000");
        
        output.close();
        System.out.println("CSV data written to " + filename);
        
    } catch (FileNotFoundException e) {
        System.err.println("Error writing file: " + e.getMessage());
    }
}

/**
 * Enhanced version that handles special cases in CSV data
 * This version properly handles fields that contain commas or quotes
 */
public static void writeCSVDataEnhanced(String filename) {
    // Sample data with potential CSV issues
    String[] names = {"John Doe", "Jane Smith", "Bob Johnson", "Alice Brown"};
    int[] ages = {25, 30, 35, 28};
    String[] cities = {"New York", "Los Angeles", "Chicago", "San Francisco"};
    double[] salaries = {50000, 60000, 55000, 65000};
    
    try (PrintStream output = new PrintStream(new File(filename))) {
        
        // Write header
        output.println("Name,Age,City,Salary");
        
        // Write data rows with proper CSV formatting
        for (int i = 0; i < names.length; i++) {
            // Format each row: name,age,city,salary
            // Note: If any field contains commas, it should be wrapped in quotes
            output.printf("%s,%d,%s,%.2f%n", 
                         names[i], ages[i], cities[i], salaries[i]);
        }
        
        System.out.println("CSV data written to " + filename);
        
    } catch (FileNotFoundException e) {
        System.err.println("Error writing file: " + e.getMessage());
    }
}

/**
 * Advanced CSV writer that handles special characters properly
 * This version quotes fields that contain commas, quotes, or newlines
 */
public static void writeCSVDataAdvanced(String filename) {
    // Sample data with special characters
    String[] names = {"John Doe", "Jane Smith", "Bob Johnson", "Alice Brown"};
    String[] titles = {"Software Engineer", "Data Analyst", "Project Manager", "UX Designer"};
    String[] locations = {"New York, NY", "Los Angeles, CA", "Chicago, IL", "San Francisco, CA"};
    
    try (PrintStream output = new PrintStream(new File(filename))) {
        
        // Write header
        output.println("Name,Title,Location");
        
        // Write data rows with proper CSV escaping
        for (int i = 0; i < names.length; i++) {
            // Quote fields that contain commas
            String quotedLocation = "\"" + locations[i] + "\"";
            output.printf("%s,%s,%s%n", names[i], titles[i], quotedLocation);
        }
        
        System.out.println("Advanced CSV data written to " + filename);
        
    } catch (FileNotFoundException e) {
        System.err.println("Error writing file: " + e.getMessage());
    }
}
```

## Exception Handling {#exception-handling}

Proper exception handling is crucial for robust file I/O operations.

### Common File I/O Exceptions

| Exception | Cause | Prevention |
|-----------|-------|------------|
| `FileNotFoundException` | File doesn't exist or can't be accessed | Check file existence, verify permissions |
| `InputMismatchException` | Expected data type doesn't match | Use hasNext*() methods to check before reading |
| `NoSuchElementException` | No more tokens to read | Check hasNext() before calling next() |
| `IOException` | General I/O error | Handle file system issues |

### Comprehensive Exception Handling
```java
public static void robustFileReading(String filename) {
    Scanner scanner = null;
    try {
        File file = new File(filename);
        
        // Check if file exists
        if (!file.exists()) {
            System.err.println("Error: File '" + filename + "' does not exist.");
            return;
        }
        
        // Check if file is readable
        if (!file.canRead()) {
            System.err.println("Error: File '" + filename + "' is not readable.");
            return;
        }
        
        scanner = new Scanner(file);
        
        while (scanner.hasNextLine()) {
            try {
                String line = scanner.nextLine();
                Scanner lineScanner = new Scanner(line);
                
                while (lineScanner.hasNext()) {
                    if (lineScanner.hasNextInt()) {
                        int value = lineScanner.nextInt();
                        System.out.println("Integer: " + value);
                    } else if (lineScanner.hasNextDouble()) {
                        double value = lineScanner.nextDouble();
                        System.out.println("Double: " + value);
                    } else {
                        String value = lineScanner.next();
                        System.out.println("String: " + value);
                    }
                }
                
                lineScanner.close();
            } catch (InputMismatchException e) {
                System.err.println("Error parsing line: " + e.getMessage());
            }
        }
        
    } catch (FileNotFoundException e) {
        System.err.println("File not found: " + e.getMessage());
    } catch (IOException e) {
        System.err.println("I/O error: " + e.getMessage());
    } finally {
        if (scanner != null) {
            scanner.close();
        }
    }
}
```

## Best Practices {#best-practices}

### 1. Always Close Resources
```java
// Good practice - use try-with-resources
try (Scanner scanner = new Scanner(new File("data.txt"));
     PrintStream output = new PrintStream(new File("output.txt"))) {
    
    // Process file
    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        output.println("Processed: " + line);
    }
    
} catch (FileNotFoundException e) {
    System.err.println("File error: " + e.getMessage());
}
```

### 2. Validate Input Data
```java
public static void validateAndProcess(String filename) {
    try (Scanner scanner = new Scanner(new File(filename))) {
        int lineNumber = 0;
        
        while (scanner.hasNextLine()) {
            lineNumber++;
            String line = scanner.nextLine();
            
            // Skip empty lines
            if (line.trim().isEmpty()) {
                continue;
            }
            
            // Skip comment lines
            if (line.trim().startsWith("#")) {
                continue;
            }
            
            // Process valid lines
            processLine(line, lineNumber);
        }
    } catch (FileNotFoundException e) {
        System.err.println("File not found: " + filename);
    }
}
```

### 3. Use Appropriate Data Structures
```java
public static void readIntoDataStructures(String filename) {
    List<String> names = new ArrayList<>();
    List<Integer> ages = new ArrayList<>();
    List<Double> scores = new ArrayList<>();
    
    try (Scanner scanner = new Scanner(new File(filename))) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            
            if (lineScanner.hasNext()) {
                names.add(lineScanner.next());
            }
            
            if (lineScanner.hasNextInt()) {
                ages.add(lineScanner.nextInt());
            }
            
            if (lineScanner.hasNextDouble()) {
                scores.add(lineScanner.nextDouble());
            }
            
            lineScanner.close();
        }
    } catch (FileNotFoundException e) {
        System.err.println("File not found: " + filename);
    }
    
    // Process the collected data
    for (int i = 0; i < names.size(); i++) {
        System.out.printf("%s: Age %d, Score %.2f%n", 
                         names.get(i), ages.get(i), scores.get(i));
    }
}
```

## Complete Example: Movie Ratings System {#complete-example}

Let's implement a complete movie ratings system that demonstrates all the concepts we've covered.

### Movie Class
**Key Concept:** This class represents a movie with its rating data. It's a simple data structure that holds the information we need to manage.

**Class Design Principles:**
- **Encapsulation**: Private fields with public getters/setters
- **Data integrity**: Methods to safely modify the data
- **String representation**: toString() method for file output

```java
/**
 * Represents a movie with its rating information
 * This class encapsulates the data structure for a single movie
 */
public class Movie {
    // Private instance variables - only accessible within this class
    private String title;           // Movie title (e.g., "Bee_Movie")
    private double averageRating;   // Average rating (e.g., 6.1)
    private int totalRatings;       // Number of ratings (e.g., 176805)
    
    /**
     * Constructor - creates a new Movie object with the given data
     * @param title The movie title
     * @param averageRating The current average rating
     * @param totalRatings The total number of ratings
     */
    public Movie(String title, double averageRating, int totalRatings) {
        this.title = title;                    // 'this' refers to the current object
        this.averageRating = averageRating;    // Assign parameter to instance variable
        this.totalRatings = totalRatings;
    }
    
    // Getter methods - provide read access to private fields
    public String getTitle() { return title; }
    public double getAverageRating() { return averageRating; }
    public int getTotalRatings() { return totalRatings; }
    
    // Setter methods - provide write access to private fields
    // These allow controlled modification of the data
    public void setAverageRating(double averageRating) { 
        this.averageRating = averageRating; 
    }
    
    public void setTotalRatings(int totalRatings) { 
        this.totalRatings = totalRatings; 
    }
    
    /**
     * Returns a string representation of the movie in TSV format
     * This format matches the input file structure for easy file I/O
     * @return Tab-separated string: "Title\tRating\tCount"
     */
    @Override
    public String toString() {
        // Format: title, tab, rating with 1 decimal place, tab, count
        return String.format("%s\t%.1f\t%d", title, averageRating, totalRatings);
    }
}
```

### Movie Ratings System Implementation
**Key Concept:** This is a complete application that demonstrates all the file I/O concepts we've learned. It reads from files, processes data, and writes back to files.

**System Architecture:**
- **Data storage**: List of Movie objects in memory
- **File I/O**: TSV format for persistence
- **User interface**: Console-based menu system
- **Data processing**: Search, add, and save operations

```java
import java.io.*;
import java.util.*;

/**
 * Complete movie ratings management system
 * Demonstrates file I/O, data structures, and user interaction
 */
public class MovieRatingsSystem {
    // Instance variables - data that belongs to this system
    private List<Movie> movies;    // Collection to store all movies in memory
    private String filename;       // Name of the file to read from/write to
    
    /**
     * Constructor - initializes the system and loads data from file
     * @param filename The TSV file containing movie data
     */
    public MovieRatingsSystem(String filename) {
        this.filename = filename;              // Store the filename for later use
        this.movies = new ArrayList<>();       // Create empty list to store movies
        loadMovies();                          // Load existing data from file
    }
    
    /**
     * Loads movie data from the TSV file into memory
     * This method demonstrates file reading with custom delimiters
     */
    public void loadMovies() {
        try (Scanner scanner = new Scanner(new File(filename))) {
            // Step 1: Skip the header line ("Title Average Total")
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            
            // Step 2: Skip the count line (just a number)
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            
            // Step 3: Read each movie data line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                
                // Create a scanner for this specific line with tab delimiter
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter("\t");  // Use tab as field separator
                
                // Step 4: Parse the three fields: title, rating, count
                if (lineScanner.hasNext()) {
                    String title = lineScanner.next();  // Read movie title
                    
                    if (lineScanner.hasNextDouble()) {
                        double rating = lineScanner.nextDouble();  // Read average rating
                        
                        if (lineScanner.hasNextInt()) {
                            int total = lineScanner.nextInt();  // Read total ratings count
                            
                            // Create Movie object and add to our collection
                            movies.add(new Movie(title, rating, total));
                        }
                    }
                }
                
                lineScanner.close();  // Close the line scanner
            }
            
            // Step 5: Report how many movies were loaded
            System.out.println("Loaded " + movies.size() + " movies from " + filename);
            
        } catch (FileNotFoundException e) {
            System.err.println("Error loading movies: " + e.getMessage());
        }
        // Scanner is automatically closed due to try-with-resources
    }
    
    /**
     * Searches for a movie by title (case-insensitive)
     * @param title The movie title to search for
     * @return The Movie object if found, null otherwise
     */
    public Movie findMovie(String title) {
        // Iterate through all movies in our collection
        for (Movie movie : movies) {
            // Compare titles ignoring case (e.g., "BEE_MOVIE" matches "bee_movie")
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;  // Found the movie!
            }
        }
        return null;  // Movie not found
    }
    
    /**
     * Adds a new rating to an existing movie and recalculates the average
     * @param title The movie title to add a rating to
     * @param newRating The new rating value to add
     */
    public void addRating(String title, double newRating) {
        // Step 1: Find the movie in our collection
        Movie movie = findMovie(title);
        
        if (movie != null) {
            // Step 2: Get current values
            int currentTotal = movie.getTotalRatings();      // Current number of ratings
            double currentAverage = movie.getAverageRating(); // Current average rating
            
            // Step 3: Calculate new average using weighted average formula
            // Formula: new_avg = (old_avg * old_count + new_rating) / (old_count + 1)
            // This avoids storing all individual ratings
            double newAverage = ((currentAverage * currentTotal) + newRating) / (currentTotal + 1);
            
            // Step 4: Update the movie's data
            movie.setAverageRating(newAverage);  // Set new average
            movie.setTotalRatings(currentTotal + 1);  // Increment count
            
            // Step 5: Confirm the update to the user
            System.out.printf("Added rating %.1f to %s. New average: %.1f%n", 
                            newRating, title, newAverage);
        } else {
            // Movie not found - inform the user
            System.out.println("Movie '" + title + "' not found.");
        }
    }
    
    /**
     * Saves all movie data back to the TSV file
     * This method demonstrates file writing with proper formatting
     */
    public void saveMovies() {
        try (PrintStream output = new PrintStream(new File(filename))) {
            // Step 1: Write the header line (column names)
            output.println("Title\tAverage\tTotal");
            
            // Step 2: Write the count line (number of movies)
            output.println(movies.size());
            
            // Step 3: Write each movie's data on a separate line
            for (Movie movie : movies) {
                // Use the movie's toString() method which formats in TSV
                output.println(movie.toString());
            }
            
            // Step 4: Confirm successful save
            System.out.println("Movies saved to " + filename);
            
        } catch (FileNotFoundException e) {
            System.err.println("Error saving movies: " + e.getMessage());
        }
        // PrintStream is automatically closed due to try-with-resources
    }
    
    // Display all movies
    public void displayMovies() {
        System.out.printf("%-40s %-10s %-10s%n", "Title", "Average", "Total");
        System.out.println("------------------------------------------------------------");
        
        for (Movie movie : movies) {
            System.out.printf("%-40s %-10.1f %-10d%n", 
                            movie.getTitle(), 
                            movie.getAverageRating(), 
                            movie.getTotalRatings());
        }
    }
    
    // Main method with interactive menu
    public static void main(String[] args) {
        MovieRatingsSystem system = new MovieRatingsSystem("small.tsv");
        Scanner userInput = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nMovie Ratings System");
            System.out.println("(F)ind movie, (A)dd rating, (S)ave, (D)isplay all, (Q)uit");
            System.out.print("Enter choice: ");
            
            String choice = userInput.nextLine().toUpperCase();
            
            switch (choice) {
                case "F":
                    System.out.print("Enter movie title: ");
                    String searchTitle = userInput.nextLine();
                    Movie found = system.findMovie(searchTitle);
                    if (found != null) {
                        System.out.printf("Found: %s - Rating: %.1f (%d ratings)%n", 
                                        found.getTitle(), found.getAverageRating(), 
                                        found.getTotalRatings());
                    } else {
                        System.out.println("Movie not found.");
                    }
                    break;
                    
                case "A":
                    System.out.print("Enter movie title: ");
                    String movieTitle = userInput.nextLine();
                    System.out.print("Enter new rating (0-10): ");
                    try {
                        double rating = Double.parseDouble(userInput.nextLine());
                        if (rating >= 0 && rating <= 10) {
                            system.addRating(movieTitle, rating);
                        } else {
                            System.out.println("Rating must be between 0 and 10.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid rating format.");
                    }
                    break;
                    
                case "S":
                    system.saveMovies();
                    break;
                    
                case "D":
                    system.displayMovies();
                    break;
                    
                case "Q":
                    System.out.println("Goodbye!");
                    userInput.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
```

### Sample Data File (small.tsv)
```
Title	Average	Total
5
Bee_Movie	6.1	176805
Barbie	6.9	455488
Oppenheimer	8.4	588723
Poor_Things	8.5	20542
Spider-Man:_Across_the_Spider-Verse	8.6	329200
```

This comprehensive guide covers all aspects of Java file I/O with practical examples, best practices, and a complete working system. The examples demonstrate proper exception handling, resource management, and data processing techniques that you'll use throughout your Java programming career.