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
File file1 = new File("data.txt");                    // Relative path
File file2 = new File("/Users/username/data.txt");    // Absolute path
File file3 = new File("folder", "data.txt");          // Directory + filename
File file4 = new File(new File("folder"), "data.txt"); // File + filename
```

### File Properties and Methods
```java
File file = new File("example.txt");

// Check if file exists
if (file.exists()) {
    System.out.println("File exists!");
}

// Get file information
System.out.println("Name: " + file.getName());
System.out.println("Path: " + file.getPath());
System.out.println("Absolute path: " + file.getAbsolutePath());
System.out.println("Size: " + file.length() + " bytes");
System.out.println("Can read: " + file.canRead());
System.out.println("Can write: " + file.canWrite());
```

## Scanner for File Input {#scanner-input}

The `Scanner` class is the primary tool for reading text data from files. It provides methods to parse different data types and handle various input formats.

### Basic Scanner Setup
```java
import java.io.*;
import java.util.*;

public class FileReaderExample {
    public static void main(String[] args) {
        try {
            File file = new File("data.txt");
            Scanner scanner = new Scanner(file);
            
            // Read and process file content here
            
            scanner.close(); // Always close the scanner!
        } catch (FileNotFoundException e) {
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
Best for: Text files where each line is a complete unit of data.

```java
public static void readLineByLine(String filename) {
    try {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println("Line: " + line);
            // Process the entire line as a unit
        }
        
        scanner.close();
    } catch (FileNotFoundException e) {
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
Best for: Files with structured data where tokens are meaningful units.

```java
public static void readTokenByToken(String filename) {
    try {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        
        while (scanner.hasNext()) {
            String token = scanner.next();
            System.out.println("Token: " + token);
            // Process each token individually
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
Best for: Complex files where each line contains multiple data fields.

```java
public static void readHybridPattern(String filename) {
    try {
        File file = new File(filename);
        Scanner fileScanner = new Scanner(file);
        
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            
            // Process each token in the current line
            while (lineScanner.hasNext()) {
                String token = lineScanner.next();
                System.out.print(token + " ");
            }
            System.out.println(); // New line after processing each line
            
            lineScanner.close(); // Close the line scanner
        }
        
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
```java
public static void readCSVFile(String filename) {
    try {
        File file = new File(filename);
        Scanner fileScanner = new Scanner(file);
        
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter(","); // Use comma as delimiter
            
            while (lineScanner.hasNext()) {
                String field = lineScanner.next().trim(); // Remove whitespace
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
```java
public static void readNumericData(String filename) {
    try {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            
            // Read different data types from the same line
            if (lineScanner.hasNext()) {
                String name = lineScanner.next();
                
                if (lineScanner.hasNextInt()) {
                    int age = lineScanner.nextInt();
                    
                    if (lineScanner.hasNextDouble()) {
                        double score = lineScanner.nextDouble();
                        System.out.printf("Name: %s, Age: %d, Score: %.2f%n", 
                                        name, age, score);
                    }
                }
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
```java
public static void processNumericData(String filename) {
    try {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        
        double sum = 0.0;
        int count = 0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            
            while (lineScanner.hasNextDouble()) {
                double value = lineScanner.nextDouble();
                sum += value;
                count++;
                min = Math.min(min, value);
                max = Math.max(max, value);
            }
            
            lineScanner.close();
        }
        
        if (count > 0) {
            double average = sum / count;
            System.out.printf("Count: %d%n", count);
            System.out.printf("Sum: %.2f%n", sum);
            System.out.printf("Average: %.2f%n", average);
            System.out.printf("Min: %.2f%n", min);
            System.out.printf("Max: %.2f%n", max);
        }
        
        scanner.close();
    } catch (FileNotFoundException e) {
        System.err.println("File not found: " + filename);
    }
}
```

### Practice Problem Solution
Let's solve the practice problem step by step:

**Code Analysis:**
```java
Scanner fileScan = new Scanner(new File("data.txt"));
while (fileScan.hasNextLine()) {
    String line = fileScan.nextLine();
    Scanner lineScan = new Scanner(line);
    double min = lineScan.nextDouble();
    double max = min;
    while (lineScan.hasNextDouble()) {
        double nextNum = lineScan.nextDouble();
        min = Math.min(min, nextNum);
        max = Math.max(max, nextNum);
    }
    System.out.println("Max: " + max + ", Min: " + min);
}
```

**Data file (data.txt):**
```
2.3 9.2
17 0.73
-1.5000
```

**Execution Trace:**
1. **Line 1**: "2.3 9.2"
   - min = 2.3, max = 2.3
   - nextNum = 9.2 → min = 2.3, max = 9.2
   - Output: "Max: 9.2, Min: 2.3"

2. **Line 2**: "17 0.73"
   - min = 17.0, max = 17.0
   - nextNum = 0.73 → min = 0.73, max = 17.0
   - Output: "Max: 17.0, Min: 0.73"

3. **Line 3**: "-1.5000"
   - min = -1.5, max = -1.5 (only one number)
   - Output: "Max: -1.5, Min: -1.5"

**Answer: A)** The program outputs three lines showing the min/max for each line.

## File Output with PrintStream {#file-output}

PrintStream is used for writing formatted text output to files, similar to how System.out works for console output.

### Basic PrintStream Usage
```java
import java.io.*;

public class FileWriterExample {
    public static void main(String[] args) {
        try {
            File outputFile = new File("output.txt");
            PrintStream output = new PrintStream(outputFile);
            
            // Write different data types
            output.println("Hello, World!");
            output.print("Number: ");
            output.println(42);
            output.printf("Pi: %.4f%n", Math.PI);
            output.println("Boolean: " + true);
            
            output.close(); // Always close the PrintStream!
            
            System.out.println("Data written to output.txt successfully!");
        } catch (FileNotFoundException e) {
            System.err.println("Error creating file: " + e.getMessage());
        }
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
```java
public static void writeTableData(String filename) {
    try {
        File file = new File(filename);
        PrintStream output = new PrintStream(file);
        
        // Write header
        output.printf("%-15s %-10s %-10s%n", "Name", "Age", "Score");
        output.println("----------------------------------------");
        
        // Write data rows
        output.printf("%-15s %-10d %-10.2f%n", "John Doe", 20, 85.5);
        output.printf("%-15s %-10d %-10.2f%n", "Jane Smith", 19, 92.3);
        output.printf("%-15s %-10d %-10.2f%n", "Bob Johnson", 21, 78.9);
        
        output.close();
        System.out.println("Table data written to " + filename);
    } catch (FileNotFoundException e) {
        System.err.println("Error writing file: " + e.getMessage());
    }
}
```

#### Writing CSV Data
```java
public static void writeCSVData(String filename) {
    try {
        File file = new File(filename);
        PrintStream output = new PrintStream(file);
        
        // Write CSV header
        output.println("Name,Age,City,Salary");
        
        // Write CSV data
        output.println("John Doe,25,New York,50000");
        output.println("Jane Smith,30,Los Angeles,60000");
        output.println("Bob Johnson,35,Chicago,55000");
        
        output.close();
        System.out.println("CSV data written to " + filename);
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
```java
public class Movie {
    private String title;
    private double averageRating;
    private int totalRatings;
    
    public Movie(String title, double averageRating, int totalRatings) {
        this.title = title;
        this.averageRating = averageRating;
        this.totalRatings = totalRatings;
    }
    
    // Getters and setters
    public String getTitle() { return title; }
    public double getAverageRating() { return averageRating; }
    public int getTotalRatings() { return totalRatings; }
    
    public void setAverageRating(double averageRating) { 
        this.averageRating = averageRating; 
    }
    
    public void setTotalRatings(int totalRatings) { 
        this.totalRatings = totalRatings; 
    }
    
    @Override
    public String toString() {
        return String.format("%s\t%.1f\t%d", title, averageRating, totalRatings);
    }
}
```

### Movie Ratings System Implementation
```java
import java.io.*;
import java.util.*;

public class MovieRatingsSystem {
    private List<Movie> movies;
    private String filename;
    
    public MovieRatingsSystem(String filename) {
        this.filename = filename;
        this.movies = new ArrayList<>();
        loadMovies();
    }
    
    // Load movies from TSV file
    public void loadMovies() {
        try (Scanner scanner = new Scanner(new File(filename))) {
            // Skip header line
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            
            // Skip count line
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter("\t");
                
                if (lineScanner.hasNext()) {
                    String title = lineScanner.next();
                    
                    if (lineScanner.hasNextDouble()) {
                        double rating = lineScanner.nextDouble();
                        
                        if (lineScanner.hasNextInt()) {
                            int total = lineScanner.nextInt();
                            movies.add(new Movie(title, rating, total));
                        }
                    }
                }
                
                lineScanner.close();
            }
            
            System.out.println("Loaded " + movies.size() + " movies from " + filename);
            
        } catch (FileNotFoundException e) {
            System.err.println("Error loading movies: " + e.getMessage());
        }
    }
    
    // Find movie by title
    public Movie findMovie(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null;
    }
    
    // Add a new rating to a movie
    public void addRating(String title, double newRating) {
        Movie movie = findMovie(title);
        if (movie != null) {
            int currentTotal = movie.getTotalRatings();
            double currentAverage = movie.getAverageRating();
            
            // Calculate new average
            double newAverage = ((currentAverage * currentTotal) + newRating) / (currentTotal + 1);
            
            movie.setAverageRating(newAverage);
            movie.setTotalRatings(currentTotal + 1);
            
            System.out.printf("Added rating %.1f to %s. New average: %.1f%n", 
                            newRating, title, newAverage);
        } else {
            System.out.println("Movie '" + title + "' not found.");
        }
    }
    
    // Save movies to file
    public void saveMovies() {
        try (PrintStream output = new PrintStream(new File(filename))) {
            // Write header
            output.println("Title\tAverage\tTotal");
            output.println(movies.size());
            
            // Write movie data
            for (Movie movie : movies) {
                output.println(movie.toString());
            }
            
            System.out.println("Movies saved to " + filename);
            
        } catch (FileNotFoundException e) {
            System.err.println("Error saving movies: " + e.getMessage());
        }
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