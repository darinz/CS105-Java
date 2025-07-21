# Scanner for User Input

## Overview
The `Scanner` class is a powerful utility in Java for reading input from various sources including user input, files, and strings. It's defined in the `java.util` package and provides convenient methods for parsing primitive types and strings.

```java
import java.util.*;
```

## Creating a Scanner for User Input
```java
Scanner console = new Scanner(System.in);
```

**Explanation**: This creates a Scanner object that reads from the standard input stream (`System.in`), which is typically the keyboard. The `System.in` is an `InputStream` that represents the standard input.

## Scanner Methods

### Reading Primitive Types

#### `nextInt()`
Reads the next token from the user as an `int` and returns it.

```java
Scanner console = new Scanner(System.in);
System.out.print("Enter your age: ");
int age = console.nextInt();
System.out.println("You are " + age + " years old.");
```

**Important Notes**:
- Skips leading whitespace
- Throws `InputMismatchException` if the next token cannot be parsed as an int
- Does not consume the newline character after reading the int

#### `nextDouble()`
Reads the next token from the user as a `double` and returns it.

```java
Scanner console = new Scanner(System.in);
System.out.print("Enter your GPA: ");
double gpa = console.nextDouble();
System.out.println("Your GPA is: " + gpa);
```

#### `next()`
Reads the next token from the user as a `String` and returns it.

```java
Scanner console = new Scanner(System.in);
System.out.print("Enter your first name: ");
String firstName = console.next();
System.out.println("Hello, " + firstName + "!");
```

#### `nextLine()`
Reads an entire line from the user as a `String` and returns it (including the newline character).

```java
Scanner console = new Scanner(System.in);
System.out.print("Enter your full name: ");
String fullName = console.nextLine();
System.out.println("Welcome, " + fullName + "!");
```

### Checking Input Availability

#### `hasNextInt()`
Returns `true` if the next token can be read as an `int`, `false` otherwise.

```java
Scanner console = new Scanner(System.in);
System.out.print("Enter a number: ");
if (console.hasNextInt()) {
    int number = console.nextInt();
    System.out.println("You entered: " + number);
} else {
    System.out.println("That's not a valid integer!");
    console.next(); // consume the invalid input
}
```

#### `hasNextDouble()`
Returns `true` if the next token can be read as a `double`, `false` otherwise.

```java
Scanner console = new Scanner(System.in);
System.out.print("Enter a decimal number: ");
if (console.hasNextDouble()) {
    double decimal = console.nextDouble();
    System.out.println("You entered: " + decimal);
} else {
    System.out.println("That's not a valid decimal number!");
    console.next(); // consume the invalid input
}
```

#### `hasNext()`
Returns `true` if there is another token of input to be read in, `false` otherwise.

```java
Scanner console = new Scanner(System.in);
System.out.println("Enter words (type 'quit' to stop): ");
while (console.hasNext()) {
    String word = console.next();
    if (word.equals("quit")) {
        break;
    }
    System.out.println("You entered: " + word);
}
```

#### `hasNextLine()`
Returns `true` if there is another line of input to be read in, `false` otherwise.

```java
Scanner console = new Scanner(System.in);
System.out.println("Enter lines (Ctrl+D to stop): ");
while (console.hasNextLine()) {
    String line = console.nextLine();
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
Scanner console = new Scanner(System.in);
console.useDelimiter(","); // Use comma as delimiter
System.out.print("Enter comma-separated values: ");
while (console.hasNext()) {
    String token = console.next();
    System.out.println("Token: " + token.trim()); // trim() removes leading/trailing whitespace
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
import java.util.*;
import java.io.*;

// Create a File object
File file = new File("Example.txt");

// Create a Scanner to read from the file
Scanner fileScan = new Scanner(file);
```

### Complete File Reading Example
```java
import java.util.*;
import java.io.*;

public class FileReaderExample {
    public static void main(String[] args) throws FileNotFoundException {
        // Create File object
        File file = new File("data.txt");
        
        // Create Scanner for file reading
        Scanner fileScan = new Scanner(file);
        
        // Read and process each line
        while (fileScan.hasNextLine()) {
            String line = fileScan.nextLine();
            System.out.println("Read line: " + line);
        }
        
        // Always close the Scanner when done
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
public static void main(String[] args) throws FileNotFoundException {
    File file = new File("Example.txt");
    Scanner fileScan = new Scanner(file);
    // ... rest of the code
}
```

#### Option 2: Handle the exception (try-catch)
```java
public static void main(String[] args) {
    try {
        File file = new File("Example.txt");
        Scanner fileScan = new Scanner(file);
        
        while (fileScan.hasNextLine()) {
            String line = fileScan.nextLine();
            System.out.println(line);
        }
        
        fileScan.close();
    } catch (FileNotFoundException e) {
        System.out.println("Error: File not found - " + e.getMessage());
    }
}
```

**Why this happens**: Java requires you to handle checked exceptions (like `FileNotFoundException`) because they represent conditions that a reasonable application might want to catch. This is like signing a waiver and telling Java – "Hey, I hereby promise to not get mad at you when you bug out and crash my program if I give you a file that doesn't actually exist."

## Typical Processing Patterns

### Line-Processing Pattern
```java
while (scan.hasNextLine()) {
    String nextLine = scan.nextLine();
    // do something with nextLine
    System.out.println("Processing: " + nextLine);
}
```

**Complete Example**:
```java
import java.util.*;
import java.io.*;

public class LineProcessor {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("lines.txt");
        Scanner scan = new Scanner(file);
        
        int lineCount = 0;
        while (scan.hasNextLine()) {
            String nextLine = scan.nextLine();
            lineCount++;
            System.out.println("Line " + lineCount + ": " + nextLine);
        }
        
        System.out.println("Total lines processed: " + lineCount);
        scan.close();
    }
}
```

### Token-Processing Pattern
```java
while (scan.hasNextInt()) {  // or hasNextDouble(), hasNext(), etc.
    int nextToken = scan.nextInt();  // or nextDouble(), next(), etc.
    // do something with nextToken
    System.out.println("Processing token: " + nextToken);
}
```

**Complete Example**:
```java
import java.util.*;
import java.io.*;

public class TokenProcessor {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("numbers.txt");
        Scanner scan = new Scanner(file);
        
        int sum = 0;
        int count = 0;
        
        while (scan.hasNextInt()) {
            int nextToken = scan.nextInt();
            sum += nextToken;
            count++;
            System.out.println("Read number: " + nextToken);
        }
        
        if (count > 0) {
            double average = (double) sum / count;
            System.out.println("Sum: " + sum);
            System.out.println("Average: " + average);
        }
        
        scan.close();
    }
}
```

## Practice Question

**What is the output of this Java program?**

```java
import java.util.*; 
import java.io.*;

public class Demo {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("Example.txt");
        Scanner fileScan = new Scanner(f);
        while (fileScan.hasNextLine()) {
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
while (fileScan.hasNextLine()) {
    String line = fileScan.nextLine();
    Scanner lineScan = new Scanner(line);
    while (lineScan.hasNextInt()) {  // or hasNextDouble(), hasNext(), etc.
        int nextToken = lineScan.nextInt();  // or nextDouble(), next(), etc.
        // do something with nextToken
        System.out.println("Token from line: " + nextToken);
    }
    lineScan.close(); // Important: close the line scanner
}
```

### Complete Hybrid Example
```java
import java.util.*;
import java.io.*;

public class HybridProcessor {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("mixed_data.txt");
        Scanner fileScan = new Scanner(file);
        
        int lineNumber = 0;
        while (fileScan.hasNextLine()) {
            lineNumber++;
            String line = fileScan.nextLine();
            System.out.println("Processing line " + lineNumber + ": " + line);
            
            // Create a new Scanner for this line
            Scanner lineScan = new Scanner(line);
            
            // Process tokens in this line
            int tokenCount = 0;
            while (lineScan.hasNext()) {
                String token = lineScan.next();
                tokenCount++;
                System.out.println("  Token " + tokenCount + ": " + token);
            }
            
            System.out.println("  Total tokens in line " + lineNumber + ": " + tokenCount);
            lineScan.close();
        }
        
        fileScan.close();
    }
}
```

### Advanced Example: Processing CSV-like Data
```java
import java.util.*;
import java.io.*;

public class CSVProcessor {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("students.csv");
        Scanner fileScan = new Scanner(file);
        
        while (fileScan.hasNextLine()) {
            String line = fileScan.nextLine();
            Scanner lineScan = new Scanner(line);
            lineScan.useDelimiter(","); // Use comma as delimiter
            
            if (lineScan.hasNext()) {
                String name = lineScan.next().trim();
                if (lineScan.hasNextInt()) {
                    int age = lineScan.nextInt();
                    if (lineScan.hasNextDouble()) {
                        double gpa = lineScan.nextDouble();
                        System.out.println("Student: " + name + ", Age: " + age + ", GPA: " + gpa);
                    }
                }
            }
            
            lineScan.close();
        }
        
        fileScan.close();
    }
}
```

## Best Practices

### 1. Always Close Scanners
```java
Scanner scan = new Scanner(System.in);
try {
    // Use the scanner
    String input = scan.nextLine();
    System.out.println("You entered: " + input);
} finally {
    scan.close(); // Always close to free resources
}
```

### 2. Handle Input Validation
```java
Scanner console = new Scanner(System.in);
System.out.print("Enter a positive integer: ");

while (!console.hasNextInt() || console.nextInt() <= 0) {
    if (!console.hasNextInt()) {
        System.out.println("That's not a number! Try again: ");
        console.next(); // consume invalid input
    } else {
        int num = console.nextInt();
        if (num <= 0) {
            System.out.println("Please enter a positive number! Try again: ");
        }
    }
}

int validNumber = console.nextInt();
System.out.println("Valid number: " + validNumber);
```

### 3. Use Try-with-Resources (Java 7+)
```java
import java.util.*;
import java.io.*;

public class ModernFileReader {
    public static void main(String[] args) {
        // Try-with-resources automatically closes the Scanner
        try (Scanner fileScan = new Scanner(new File("data.txt"))) {
            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
```

### 4. Handle Mixed Input Types
```java
Scanner console = new Scanner(System.in);
System.out.print("Enter your name and age: ");

String name = console.next();
int age = console.nextInt();

// Clear the buffer if you plan to read a line next
console.nextLine(); // Consume the newline

System.out.print("Enter your address: ");
String address = console.nextLine();

System.out.println("Name: " + name + ", Age: " + age + ", Address: " + address);
```

This comprehensive guide covers all the essential Scanner concepts with practical examples and best practices for effective Java input/output operations.
