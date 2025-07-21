# Scanner for User Input

## Overview
The `Scanner` class is a powerful utility in Java for reading input from various sources including user input, files, and strings. It's defined in the `java.util` package and provides convenient methods for parsing primitive types and strings.

```java
// Import the Scanner class from java.util package
import java.util.*;
```

## Creating a Scanner for User Input
```java
// Create a Scanner object that reads from the keyboard (standard input)
Scanner console = new Scanner(System.in);
```

**Explanation**: This creates a Scanner object that reads from the standard input stream (`System.in`), which is typically the keyboard. The `System.in` is an `InputStream` that represents the standard input.

## Scanner Methods

### Reading Primitive Types

#### `nextInt()`
Reads the next token from the user as an `int` and returns it.

```java
// Step 1: Create a Scanner object to read from keyboard
Scanner console = new Scanner(System.in);

// Step 2: Prompt the user for input
System.out.print("Enter your age: ");

// Step 3: Read the integer input from user
int age = console.nextInt();

// Step 4: Use the input in your program
System.out.println("You are " + age + " years old.");
```

**Important Notes**:
- Skips leading whitespace (spaces, tabs, newlines)
- Throws `InputMismatchException` if the next token cannot be parsed as an int
- Does not consume the newline character after reading the int (this can cause issues!)

#### `nextDouble()`
Reads the next token from the user as a `double` and returns it.

```java
// Create Scanner for keyboard input
Scanner console = new Scanner(System.in);

// Prompt user for decimal input
System.out.print("Enter your GPA: ");

// Read the double value (can handle decimals like 3.5, 4.0, etc.)
double gpa = console.nextDouble();

// Display the result
System.out.println("Your GPA is: " + gpa);
```

#### `next()`
Reads the next token from the user as a `String` and returns it.

```java
// Create Scanner for keyboard input
Scanner console = new Scanner(System.in);

// Prompt user for a single word
System.out.print("Enter your first name: ");

// Read a single token (word) - stops at whitespace
String firstName = console.next();

// Display personalized message
System.out.println("Hello, " + firstName + "!");
```

#### `nextLine()`
Reads an entire line from the user as a `String` and returns it (including the newline character).

```java
// Create Scanner for keyboard input
Scanner console = new Scanner(System.in);

// Prompt user for full name (can contain spaces)
System.out.print("Enter your full name: ");

// Read entire line including spaces - "John Doe" would be read as one string
String fullName = console.nextLine();

// Display welcome message
System.out.println("Welcome, " + fullName + "!");
```

### Checking Input Availability

#### `hasNextInt()`
Returns `true` if the next token can be read as an `int`, `false` otherwise.

```java
// Create Scanner for keyboard input
Scanner console = new Scanner(System.in);

// Prompt user for numeric input
System.out.print("Enter a number: ");

// Check if the next input can be converted to an integer
if (console.hasNextInt()) {
    // Safe to read as int - no exception will be thrown
    int number = console.nextInt();
    System.out.println("You entered: " + number);
} else {
    // User entered something that's not a number (like "abc")
    System.out.println("That's not a valid integer!");
    // Consume the invalid input so we can continue
    console.next(); // This removes the invalid input from the buffer
}
```

#### `hasNextDouble()`
Returns `true` if the next token can be read as a `double`, `false` otherwise.

```java
// Create Scanner for keyboard input
Scanner console = new Scanner(System.in);

// Prompt user for decimal input
System.out.print("Enter a decimal number: ");

// Check if the next input can be converted to a double
if (console.hasNextDouble()) {
    // Safe to read as double - handles 3.14, 2.0, etc.
    double decimal = console.nextDouble();
    System.out.println("You entered: " + decimal);
} else {
    // User entered something that's not a decimal number
    System.out.println("That's not a valid decimal number!");
    // Remove the invalid input from the buffer
    console.next();
}
```

#### `hasNext()`
Returns `true` if there is another token of input to be read in, `false` otherwise.

```java
// Create Scanner for keyboard input
Scanner console = new Scanner(System.in);

// Prompt user for multiple words
System.out.println("Enter words (type 'quit' to stop): ");

// Keep reading tokens until user types 'quit' or no more input
while (console.hasNext()) {
    // Read the next word/token
    String word = console.next();
    
    // Check if user wants to quit
    if (word.equals("quit")) {
        break; // Exit the loop
    }
    
    // Process the word
    System.out.println("You entered: " + word);
}
```

#### `hasNextLine()`
Returns `true` if there is another line of input to be read in, `false` otherwise.

```java
// Create Scanner for keyboard input
Scanner console = new Scanner(System.in);

// Prompt user for multiple lines
System.out.println("Enter lines (Ctrl+D on Unix/Mac or Ctrl+Z on Windows to stop): ");

// Keep reading lines until no more input (Ctrl+D/Ctrl+Z)
while (console.hasNextLine()) {
    // Read the entire line including spaces
    String line = console.nextLine();
    
    // Process the line
    System.out.println("You entered: " + line);
}
```

## Token vs. Line-based Scanning

### Understanding Tokens
Tokens are units of input (as defined by the Scanner) that are separated by whitespace (spaces, tabs, new lines). The Scanner uses whitespace as the default delimiter.

**Example Input**:
```
The quick,	brown fox
Jumped       over	the
Lazy dog.
```

**Token Analysis**:
- Line 1: "The", "quick,", "brown", "fox" (4 tokens)
- Line 2: "Jumped", "over", "the" (3 tokens)
- Line 3: "Lazy", "dog." (2 tokens)
- **Total**: 9 tokens

### Custom Delimiters
You can change the delimiter pattern using `useDelimiter()`:

```java
// Create Scanner for keyboard input
Scanner console = new Scanner(System.in);

// Change the delimiter from whitespace to comma
console.useDelimiter(","); // Now commas separate tokens instead of spaces

// Prompt user for comma-separated values
System.out.print("Enter comma-separated values: ");

// Read tokens separated by commas
while (console.hasNext()) {
    // Read the next token (separated by comma)
    String token = console.next();
    
    // trim() removes leading/trailing whitespace from the token
    System.out.println("Token: " + token.trim());
}
```

## Practice Question

**How many tokens are in the following line?**

```
"Hello world !" my-name is Burt
```

**Answer**: C) Six

**Explanation**:
1. "Hello world !" (quoted string as one token)
2. my-name
3. is
4. Burt

Wait, let me recount carefully:
1. "Hello world !" (quoted string as one token)
2. my-name
3. is
4. Burt

Actually, the answer should be **4 tokens**, not 6. The quoted string "Hello world !" is treated as a single token.

## Scanner for File I/O

### Basic File Reading Setup
```java
// Import required packages
import java.util.*;  // For Scanner class
import java.io.*;    // For File class and FileNotFoundException

// Create a File object representing the file on disk
File file = new File("Example.txt");

// Create a Scanner to read from the file (like reading from keyboard, but from file)
Scanner fileScan = new Scanner(file);
```

### Complete File Reading Example
```java
// Import required packages
import java.util.*;  // Scanner class
import java.io.*;    // File class and FileNotFoundException

public class FileReaderExample {
    public static void main(String[] args) throws FileNotFoundException {
        // Step 1: Create File object - represents the file "data.txt" on disk
        File file = new File("data.txt");
        
        // Step 2: Create Scanner for file reading - reads from file instead of keyboard
        Scanner fileScan = new Scanner(file);
        
        // Step 3: Read and process each line in the file
        while (fileScan.hasNextLine()) {
            // Read one line from the file
            String line = fileScan.nextLine();
            
            // Process the line (in this case, just print it)
            System.out.println("Read line: " + line);
        }
        
        // Step 4: Always close the Scanner when done to free system resources
        fileScan.close();
    }
}
```

## Checked Exceptions

### Understanding FileNotFoundException
If you try to compile a program working with file scanners, you may encounter this error message:
```
error: unreported exception FileNotFoundException; must be caught or declared to be thrown
```

### Solutions

#### Option 1: Declare the exception (throws clause)
```java
// Add "throws FileNotFoundException" to method signature
// This tells Java: "I know this might fail, but I'm not handling it here"
public static void main(String[] args) throws FileNotFoundException {
    // Create File object
    File file = new File("Example.txt");
    
    // Create Scanner - this line might throw FileNotFoundException
    Scanner fileScan = new Scanner(file);
    
    // ... rest of the code
}
```

#### Option 2: Handle the exception (try-catch)
```java
public static void main(String[] args) {
    // Wrap file operations in try-catch block
    try {
        // Create File object
        File file = new File("Example.txt");
        
        // Create Scanner - might throw FileNotFoundException
        Scanner fileScan = new Scanner(file);
        
        // Read all lines from file
        while (fileScan.hasNextLine()) {
            String line = fileScan.nextLine();
            System.out.println(line);
        }
        
        // Close the scanner
        fileScan.close();
        
    } catch (FileNotFoundException e) {
        // This block runs if the file doesn't exist
        System.out.println("Error: File not found - " + e.getMessage());
        // e.getMessage() returns a description of what went wrong
    }
}
```

**Why this happens**: Java requires you to handle checked exceptions (like `FileNotFoundException`) because they represent conditions that a reasonable application might want to catch. This is like signing a waiver and telling Java – "Hey, I hereby promise to not get mad at you when you bug out and crash my program if I give you a file that doesn't actually exist."

## Typical Processing Patterns

### Line-Processing Pattern
```java
// Standard pattern for reading a file line by line
while (scan.hasNextLine()) {
    // Read the next line from the file
    String nextLine = scan.nextLine();
    
    // Process the line (do something with it)
    System.out.println("Processing: " + nextLine);
}
```

**Complete Example**:
```java
// Import required packages
import java.util.*;  // Scanner
import java.io.*;    // File, FileNotFoundException

public class LineProcessor {
    public static void main(String[] args) throws FileNotFoundException {
        // Step 1: Set up file and scanner
        File file = new File("lines.txt");
        Scanner scan = new Scanner(file);
        
        // Step 2: Initialize counter for tracking lines
        int lineCount = 0;
        
        // Step 3: Process each line in the file
        while (scan.hasNextLine()) {
            // Read one line at a time
            String nextLine = scan.nextLine();
            
            // Increment line counter
            lineCount++;
            
            // Display line number and content
            System.out.println("Line " + lineCount + ": " + nextLine);
        }
        
        // Step 4: Display summary
        System.out.println("Total lines processed: " + lineCount);
        
        // Step 5: Clean up resources
        scan.close();
    }
}
```

### Token-Processing Pattern
```java
// Standard pattern for reading specific data types from a file
while (scan.hasNextInt()) {  // Check if next token is an integer
    // Read the integer token
    int nextToken = scan.nextInt();
    
    // Process the integer
    System.out.println("Processing token: " + nextToken);
}
```

**Complete Example**:
```java
// Import required packages
import java.util.*;  // Scanner
import java.io.*;    // File, FileNotFoundException

public class TokenProcessor {
    public static void main(String[] args) throws FileNotFoundException {
        // Step 1: Set up file and scanner
        File file = new File("numbers.txt");
        Scanner scan = new Scanner(file);
        
        // Step 2: Initialize variables for calculations
        int sum = 0;      // Running total of all numbers
        int count = 0;    // Number of integers read
        
        // Step 3: Read and process each integer in the file
        while (scan.hasNextInt()) {
            // Read the next integer
            int nextToken = scan.nextInt();
            
            // Add to running sum
            sum += nextToken;
            
            // Increment counter
            count++;
            
            // Display what we read
            System.out.println("Read number: " + nextToken);
        }
        
        // Step 4: Calculate and display statistics
        if (count > 0) {
            // Calculate average (cast to double for decimal result)
            double average = (double) sum / count;
            
            // Display results
            System.out.println("Sum: " + sum);
            System.out.println("Average: " + average);
        }
        
        // Step 5: Clean up resources
        scan.close();
    }
}
```

## Practice Question

**What is the output of this Java program?**

```java
// Import required packages
import java.util.*;  // Scanner
import java.io.*;    // File, FileNotFoundException

public class Demo {
    public static void main(String[] args) throws FileNotFoundException {
        // Create File object
        File f = new File("Example.txt");
        
        // Create Scanner to read from the file
        Scanner fileScan = new Scanner(f);
        
        // Read each line and print with comma separator
        while (fileScan.hasNextLine()) {
            // Read line and immediately print it with ", " appended
            System.out.print(fileScan.nextLine() + ", ");
        }
    }
}
```

Assuming the file "Example.txt" contains:
```
One
Two
Three
```

**Answer**: A) One, Two, Three,

**Explanation**: 
- `nextLine()` reads each line including the newline character
- The program prints each line followed by ", "
- Since there's no newline after "Three", the output appears on one line
- The result is: "One, Two, Three,"

## File I/O Examples: Hybrid Pattern

### Processing Lines and Tokens Together
```java
// Advanced pattern: Read file line by line, then process tokens within each line
while (fileScan.hasNextLine()) {
    // Step 1: Read one line from the file
    String line = fileScan.nextLine();
    
    // Step 2: Create a new Scanner to process tokens within this line
    Scanner lineScan = new Scanner(line);
    
    // Step 3: Process each token in the line
    while (lineScan.hasNextInt()) {  // Check if next token is an integer
        // Read the integer token from this line
        int nextToken = lineScan.nextInt();
        
        // Process the token
        System.out.println("Token from line: " + nextToken);
    }
    
    // Step 4: Important - close the line scanner to free resources
    lineScan.close();
}
```

### Complete Hybrid Example
```java
// Import required packages
import java.util.*;  // Scanner
import java.io.*;    // File, FileNotFoundException

public class HybridProcessor {
    public static void main(String[] args) throws FileNotFoundException {
        // Step 1: Set up file and main scanner
        File file = new File("mixed_data.txt");
        Scanner fileScan = new Scanner(file);
        
        // Step 2: Initialize line counter
        int lineNumber = 0;
        
        // Step 3: Process each line in the file
        while (fileScan.hasNextLine()) {
            // Increment line counter
            lineNumber++;
            
            // Read the current line
            String line = fileScan.nextLine();
            
            // Display which line we're processing
            System.out.println("Processing line " + lineNumber + ": " + line);
            
            // Step 4: Create a new Scanner for this specific line
            Scanner lineScan = new Scanner(line);
            
            // Step 5: Process tokens in this line
            int tokenCount = 0;
            while (lineScan.hasNext()) {
                // Read each token in the line
                String token = lineScan.next();
                
                // Increment token counter
                tokenCount++;
                
                // Display the token
                System.out.println("  Token " + tokenCount + ": " + token);
            }
            
            // Step 6: Display summary for this line
            System.out.println("  Total tokens in line " + lineNumber + ": " + tokenCount);
            
            // Step 7: Close the line scanner (important!)
            lineScan.close();
        }
        
        // Step 8: Close the main file scanner
        fileScan.close();
    }
}
```

### Advanced Example: Processing CSV-like Data
```java
// Import required packages
import java.util.*;  // Scanner
import java.io.*;    // File, FileNotFoundException

public class CSVProcessor {
    public static void main(String[] args) throws FileNotFoundException {
        // Step 1: Set up file and scanner
        File file = new File("students.csv");
        Scanner fileScan = new Scanner(file);
        
        // Step 2: Process each line (each line represents one student)
        while (fileScan.hasNextLine()) {
            // Read one student's data line
            String line = fileScan.nextLine();
            
            // Step 3: Create scanner for this line with comma delimiter
            Scanner lineScan = new Scanner(line);
            lineScan.useDelimiter(","); // Use comma to separate fields
            
            // Step 4: Extract student information
            if (lineScan.hasNext()) {
                // Read student name (first field)
                String name = lineScan.next().trim(); // trim() removes extra spaces
                
                if (lineScan.hasNextInt()) {
                    // Read student age (second field)
                    int age = lineScan.nextInt();
                    
                    if (lineScan.hasNextDouble()) {
                        // Read student GPA (third field)
                        double gpa = lineScan.nextDouble();
                        
                        // Display formatted student information
                        System.out.println("Student: " + name + ", Age: " + age + ", GPA: " + gpa);
                    }
                }
            }
            
            // Step 5: Close the line scanner
            lineScan.close();
        }
        
        // Step 6: Close the file scanner
        fileScan.close();
    }
}
```

## Best Practices

### 1. Always Close Scanners
```java
// Create scanner for keyboard input
Scanner scan = new Scanner(System.in);

// Use try-finally to ensure scanner is always closed
try {
    // Use the scanner
    System.out.print("Enter your name: ");
    String input = scan.nextLine();
    System.out.println("You entered: " + input);
} finally {
    // This block always runs, even if an exception occurs
    scan.close(); // Always close to free system resources
}
```

### 2. Handle Input Validation
```java
// Create scanner for keyboard input
Scanner console = new Scanner(System.in);

// Prompt user for positive integer
System.out.print("Enter a positive integer: ");

// Keep asking until we get valid input
while (!console.hasNextInt() || console.nextInt() <= 0) {
    if (!console.hasNextInt()) {
        // User entered something that's not a number
        System.out.println("That's not a number! Try again: ");
        console.next(); // consume the invalid input
    } else {
        // User entered a number, but it's not positive
        int num = console.nextInt();
        if (num <= 0) {
            System.out.println("Please enter a positive number! Try again: ");
        }
    }
}

// At this point, we know the next input is a valid positive integer
int validNumber = console.nextInt();
System.out.println("Valid number: " + validNumber);
```

### 3. Use Try-with-Resources (Java 7+)
```java
// Import required packages
import java.util.*;  // Scanner
import java.io.*;    // File, FileNotFoundException

public class ModernFileReader {
    public static void main(String[] args) {
        // Try-with-resources automatically closes the Scanner when done
        // This is the modern, recommended way to handle resources
        try (Scanner fileScan = new Scanner(new File("data.txt"))) {
            // Read and process each line
            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine();
                System.out.println(line);
            }
            // No need to call fileScan.close() - it's automatic!
        } catch (FileNotFoundException e) {
            // Handle the case where file doesn't exist
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
```

### 4. Handle Mixed Input Types
```java
// Create scanner for keyboard input
Scanner console = new Scanner(System.in);

// Prompt for name and age
System.out.print("Enter your name and age: ");

// Read name (single word)
String name = console.next();

// Read age (integer)
int age = console.nextInt();

// IMPORTANT: Clear the buffer if you plan to read a line next
// nextInt() doesn't consume the newline character, so we need to clear it
console.nextLine(); // Consume the leftover newline

// Now we can safely read a line that might contain spaces
System.out.print("Enter your address: ");
String address = console.nextLine();

// Display all the information
System.out.println("Name: " + name + ", Age: " + age + ", Address: " + address);
```

## Common Pitfalls and Solutions

### Pitfall 1: nextInt() followed by nextLine()
```java
// PROBLEMATIC CODE - This will skip the address input!
Scanner console = new Scanner(System.in);
System.out.print("Enter age: ");
int age = console.nextInt();        // Reads "25" but leaves "\n" in buffer
System.out.print("Enter address: ");
String address = console.nextLine(); // Reads the leftover "\n" and returns empty string!

// SOLUTION: Clear the buffer
Scanner console = new Scanner(System.in);
System.out.print("Enter age: ");
int age = console.nextInt();
console.nextLine(); // Clear the buffer
System.out.print("Enter address: ");
String address = console.nextLine(); // Now works correctly
```

### Pitfall 2: Not checking input before reading
```java
// PROBLEMATIC CODE - This will crash if user enters "abc" instead of a number
Scanner console = new Scanner(System.in);
System.out.print("Enter a number: ");
int number = console.nextInt(); // Throws InputMismatchException if input is "abc"

// SOLUTION: Always check before reading
Scanner console = new Scanner(System.in);
System.out.print("Enter a number: ");
if (console.hasNextInt()) {
    int number = console.nextInt(); // Safe to read
} else {
    System.out.println("That's not a number!");
    console.next(); // Clear invalid input
}
```

This comprehensive guide covers all the essential Scanner concepts with practical examples, detailed annotations, and best practices for effective Java input/output operations. Each code example includes inline comments explaining what each line does, making it easier for students to understand and learn the concepts.
