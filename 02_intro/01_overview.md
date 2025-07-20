# Introduction

## Java Fundamentals

### Java Program Structure
- **Every program needs a class**: Java is object-oriented, so all code must be inside a class
- **Runnable programs need a `main` method**: The entry point with exact signature `public static void main(String[] args)`
- **File naming**: The file name must match the class name exactly (case-sensitive)
- **Package structure**: Classes can be organized in packages for better organization

```java
// HelloWorld.java - filename must match class name
public class HelloWorld {
    // This is the entry point - JVM looks for this exact method signature
    public static void main(String[] args) {
        System.out.println("Hello world");
    }
}
```

### Understanding the Main Method
```java
public static void main(String[] args)
// public: accessible from anywhere
// static: belongs to class, not instance (no object needed)
// void: returns nothing
// main: method name (JVM requirement)
// String[] args: command line arguments array
```

## Core Java Concepts

### 1. Printing and Comments

#### Output Methods
```java
public class OutputExamples {
    public static void main(String[] args) {
        // println - prints and moves to next line
        System.out.println("Hello World");
        
        // print - prints without moving to next line
        System.out.print("Hello ");
        System.out.print("World");
        
        // printf - formatted printing
        System.out.printf("Number: %d, String: %s, Float: %.2f%n", 42, "test", 3.14159);
        
        // String concatenation
        String name = "Alice";
        int age = 25;
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
```

#### Comments
```java
// Single line comment

/*
 * Multi-line comment
 * Can span multiple lines
 */

/**
 * JavaDoc comment
 * Used for documentation
 * @param args command line arguments
 */
public class CommentExample {
    public static void main(String[] args) {
        // This is a single line comment
        System.out.println("Hello"); // Inline comment
    }
}
```

### 2. Variables, Types, and Expressions

#### Primitive Data Types
```java
public class DataTypes {
    public static void main(String[] args) {
        // Integer types
        byte smallNumber = 127;           // 8-bit, -128 to 127
        short mediumNumber = 32767;       // 16-bit, -32,768 to 32,767
        int number = 2147483647;          // 32-bit, most common
        long bigNumber = 9223372036854775807L; // 64-bit, note the 'L'
        
        // Floating point types
        float decimal = 3.14f;            // 32-bit, note the 'f'
        double preciseDecimal = 3.14159265359; // 64-bit, default for decimals
        
        // Character type
        char letter = 'A';                // 16-bit Unicode character
        
        // Boolean type
        boolean isTrue = true;            // true or false
        
        // String (reference type, not primitive)
        String text = "Hello World";
        
        // Type conversion (casting)
        int intValue = 100;
        double doubleValue = intValue;    // Implicit conversion (widening)
        
        double pi = 3.14159;
        int roundedPi = (int) pi;         // Explicit conversion (narrowing)
        
        System.out.println("Original pi: " + pi);
        System.out.println("Rounded pi: " + roundedPi);
    }
}
```

#### Variable Declaration and Initialization
```java
public class VariableExamples {
    public static void main(String[] args) {
        // Declaration
        int x;
        
        // Initialization
        x = 10;
        
        // Declaration and initialization
        int y = 20;
        
        // Multiple variables of same type
        int a = 1, b = 2, c = 3;
        
        // Constants (final keyword)
        final double PI = 3.14159;
        // PI = 3.14; // This would cause a compilation error
        
        // Type inference with var (Java 10+)
        var message = "Hello World";      // Compiler infers String
        var number = 42;                  // Compiler infers int
    }
}
```

#### Operators and Expressions
```java
public class Operators {
    public static void main(String[] args) {
        // Arithmetic operators
        int a = 10, b = 3;
        System.out.println("Addition: " + (a + b));        // 13
        System.out.println("Subtraction: " + (a - b));     // 7
        System.out.println("Multiplication: " + (a * b));  // 30
        System.out.println("Division: " + (a / b));        // 3 (integer division)
        System.out.println("Modulus: " + (a % b));         // 1
        
        // Floating point division
        double result = (double) a / b;
        System.out.println("Floating point division: " + result); // 3.333...
        
        // Increment/Decrement
        int x = 5;
        System.out.println("x: " + x);           // 5
        System.out.println("x++: " + x++);       // 5 (post-increment)
        System.out.println("x: " + x);           // 6
        System.out.println("++x: " + ++x);       // 7 (pre-increment)
        
        // Assignment operators
        int y = 10;
        y += 5;  // Same as y = y + 5
        y -= 3;  // Same as y = y - 3
        y *= 2;  // Same as y = y * 2
        y /= 4;  // Same as y = y / 4
        System.out.println("y: " + y);           // 6
        
        // Comparison operators
        System.out.println("5 == 5: " + (5 == 5));     // true
        System.out.println("5 != 3: " + (5 != 3));     // true
        System.out.println("5 > 3: " + (5 > 3));       // true
        System.out.println("5 < 10: " + (5 < 10));     // true
        System.out.println("5 >= 5: " + (5 >= 5));     // true
        System.out.println("5 <= 3: " + (5 <= 3));     // false
        
        // Logical operators
        boolean p = true, q = false;
        System.out.println("p && q: " + (p && q));      // false (AND)
        System.out.println("p || q: " + (p || q));      // true (OR)
        System.out.println("!p: " + (!p));              // false (NOT)
    }
}
```

### 3. Conditionals (if/else if/else)

#### Basic If Statements
```java
public class Conditionals {
    public static void main(String[] args) {
        int age = 18;
        
        // Simple if statement
        if (age >= 18) {
            System.out.println("You are an adult");
        }
        
        // If-else statement
        if (age >= 18) {
            System.out.println("You can vote");
        } else {
            System.out.println("You cannot vote yet");
        }
        
        // If-else if-else chain
        int score = 85;
        if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 80) {
            System.out.println("Grade: B");
        } else if (score >= 70) {
            System.out.println("Grade: C");
        } else if (score >= 60) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }
        
        // Nested if statements
        boolean isStudent = true;
        if (age >= 18) {
            if (isStudent) {
                System.out.println("Adult student");
            } else {
                System.out.println("Adult non-student");
            }
        } else {
            System.out.println("Minor");
        }
        
        // Ternary operator (shorthand if-else)
        String status = (age >= 18) ? "Adult" : "Minor";
        System.out.println("Status: " + status);
        
        // Switch statement (Java 7+)
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            default:
                System.out.println("Weekend");
        }
        
        // Switch expression (Java 14+)
        String dayName = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            default -> "Weekend";
        };
        System.out.println("Day: " + dayName);
    }
}
```

### 4. Loops (for and while)

#### For Loops
```java
public class Loops {
    public static void main(String[] args) {
        // Traditional for loop
        System.out.println("Counting from 1 to 5:");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Counting backwards
        System.out.println("Counting backwards from 5 to 1:");
        for (int i = 5; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // For loop with step
        System.out.println("Even numbers from 0 to 10:");
        for (int i = 0; i <= 10; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // For-each loop (enhanced for loop)
        String[] fruits = {"Apple", "Banana", "Orange", "Grape"};
        System.out.println("Fruits:");
        for (String fruit : fruits) {
            System.out.println("- " + fruit);
        }
        
        // Nested for loops
        System.out.println("Multiplication table (1-5):");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.printf("%2d ", i * j);
            }
            System.out.println();
        }
    }
}
```

#### While and Do-While Loops
```java
public class WhileLoops {
    public static void main(String[] args) {
        // While loop
        System.out.println("While loop - counting to 5:");
        int count = 1;
        while (count <= 5) {
            System.out.print(count + " ");
            count++;
        }
        System.out.println();
        
        // Do-while loop (executes at least once)
        System.out.println("Do-while loop:");
        int number = 1;
        do {
            System.out.print(number + " ");
            number++;
        } while (number <= 5);
        System.out.println();
        
        // Loop with break statement
        System.out.println("Loop with break:");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) {
                break; // Exit the loop
            }
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Loop with continue statement
        System.out.println("Loop with continue (skip even numbers):");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue; // Skip to next iteration
            }
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Infinite loop with break
        System.out.println("Infinite loop example:");
        int counter = 0;
        while (true) {
            counter++;
            if (counter > 5) {
                break;
            }
            System.out.print(counter + " ");
        }
        System.out.println();
    }
}
```

### 5. Strings

#### String Basics
```java
public class StringBasics {
    public static void main(String[] args) {
        // String creation
        String str1 = "Hello World";
        String str2 = new String("Hello World");
        
        // String concatenation
        String firstName = "John";
        String lastName = "Doe";
        String fullName = firstName + " " + lastName;
        System.out.println("Full name: " + fullName);
        
        // String methods
        String text = "  Hello World  ";
        System.out.println("Original: '" + text + "'");
        System.out.println("Length: " + text.length());
        System.out.println("Trimmed: '" + text.trim() + "'");
        System.out.println("Uppercase: " + text.toUpperCase());
        System.out.println("Lowercase: " + text.toLowerCase());
        System.out.println("Substring(0,5): " + text.substring(0, 5));
        System.out.println("Contains 'World': " + text.contains("World"));
        System.out.println("Starts with 'Hello': " + text.startsWith("Hello"));
        System.out.println("Ends with 'World': " + text.endsWith("World"));
        
        // String comparison
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        
        System.out.println("s1 == s2: " + (s1 == s2));           // true (same reference)
        System.out.println("s1 == s3: " + (s1 == s3));           // false (different references)
        System.out.println("s1.equals(s3): " + s1.equals(s3));   // true (same content)
        
        // String formatting
        String name = "Alice";
        int age = 25;
        double height = 1.75;
        
        String formatted = String.format("Name: %s, Age: %d, Height: %.2f", name, age, height);
        System.out.println(formatted);
        
        // StringBuilder for efficient string manipulation
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");
        sb.append("!");
        String result = sb.toString();
        System.out.println("StringBuilder result: " + result);
    }
}
```

### 6. Methods

#### Method Basics
```java
public class Methods {
    public static void main(String[] args) {
        // Calling methods
        sayHello();
        sayHelloTo("Alice");
        
        int sum = add(5, 3);
        System.out.println("Sum: " + sum);
        
        double area = calculateCircleArea(5.0);
        System.out.println("Circle area: " + area);
        
        // Method overloading
        System.out.println("Add ints: " + add(5, 3));
        System.out.println("Add doubles: " + add(5.5, 3.2));
        System.out.println("Add three ints: " + add(1, 2, 3));
        
        // Recursive method
        int factorial = factorial(5);
        System.out.println("5! = " + factorial);
        
        // Method with array parameter
        int[] numbers = {1, 2, 3, 4, 5};
        int arraySum = sumArray(numbers);
        System.out.println("Array sum: " + arraySum);
        
        // Method returning array
        int[] doubled = doubleArray(numbers);
        System.out.print("Doubled array: ");
        for (int num : doubled) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    // Method with no parameters and no return value
    public static void sayHello() {
        System.out.println("Hello!");
    }
    
    // Method with parameter and no return value
    public static void sayHelloTo(String name) {
        System.out.println("Hello, " + name + "!");
    }
    
    // Method with parameters and return value
    public static int add(int a, int b) {
        return a + b;
    }
    
    // Method overloading - same name, different parameters
    public static double add(double a, double b) {
        return a + b;
    }
    
    public static int add(int a, int b, int c) {
        return a + b + c;
    }
    
    // Method with complex logic
    public static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }
    
    // Recursive method
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    
    // Method with array parameter
    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
    
    // Method returning array
    public static int[] doubleArray(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i] * 2;
        }
        return result;
    }
}
```

### 7. Arrays & 2D Arrays

#### One-Dimensional Arrays
```java
public class Arrays {
    public static void main(String[] args) {
        // Array declaration and initialization
        int[] numbers = {1, 2, 3, 4, 5};
        
        // Array declaration with size
        int[] scores = new int[5];
        scores[0] = 85;
        scores[1] = 92;
        scores[2] = 78;
        scores[3] = 96;
        scores[4] = 88;
        
        // Accessing array elements
        System.out.println("First number: " + numbers[0]);
        System.out.println("Last number: " + numbers[numbers.length - 1]);
        
        // Iterating through arrays
        System.out.println("Numbers array:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        
        // Enhanced for loop
        System.out.println("Scores array:");
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();
        
        // Finding maximum value
        int max = numbers[0];
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        System.out.println("Maximum value: " + max);
        
        // Array methods
        System.out.println("Array length: " + numbers.length);
        
        // Copying arrays
        int[] copy = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            copy[i] = numbers[i];
        }
        
        // Using System.arraycopy
        int[] copy2 = new int[numbers.length];
        System.arraycopy(numbers, 0, copy2, 0, numbers.length);
    }
}
```

#### Two-Dimensional Arrays
```java
public class TwoDArrays {
    public static void main(String[] args) {
        // 2D array declaration and initialization
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        // 2D array with specified size
        int[][] grid = new int[3][4];
        
        // Filling the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = i + j;
            }
        }
        
        // Printing 2D array
        System.out.println("Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("Grid:");
        for (int[] row : grid) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        
        // Finding sum of all elements
        int sum = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                sum += element;
            }
        }
        System.out.println("Sum of matrix: " + sum);
        
        // Transposing a matrix
        int[][] transpose = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        
        System.out.println("Transposed matrix:");
        for (int[] row : transpose) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        
        // Jagged arrays (arrays with different row lengths)
        int[][] jagged = {
            {1, 2, 3, 4},
            {5, 6},
            {7, 8, 9}
        };
        
        System.out.println("Jagged array:");
        for (int i = 0; i < jagged.length; i++) {
            for (int j = 0; j < jagged[i].length; j++) {
                System.out.print(jagged[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

## Best Practices and Common Pitfalls

### Code Style and Conventions
```java
public class BestPractices {
    // Use meaningful variable names
    int numberOfStudents = 25;  // Good
    int n = 25;                 // Bad
    
    // Use constants for magic numbers
    public static final int MAX_SIZE = 100;
    
    // Proper indentation and spacing
    public static void wellFormattedMethod() {
        if (condition) {
            // Do something
        } else {
            // Do something else
        }
    }
    
    // Use braces even for single statements
    if (condition) {
        doSomething();
    }
    
    // Comment your code
    /**
     * Calculates the factorial of a number
     * @param n the number to calculate factorial for
     * @return the factorial of n
     */
    public static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
}
```

### Common Mistakes to Avoid
```java
public class CommonMistakes {
    public static void main(String[] args) {
        // 1. Array index out of bounds
        int[] arr = {1, 2, 3};
        // System.out.println(arr[3]); // This will cause ArrayIndexOutOfBoundsException
        
        // 2. String comparison with == instead of .equals()
        String s1 = "hello";
        String s2 = new String("hello");
        // if (s1 == s2) // Wrong! Use s1.equals(s2)
        
        // 3. Forgetting to initialize variables
        int x;
        // System.out.println(x); // This will cause compilation error
        
        // 4. Infinite loops
        // for (int i = 0; i < 10; i--) // This will run forever
        
        // 5. Not handling null values
        String str = null;
        // System.out.println(str.length()); // This will cause NullPointerException
        if (str != null) {
            System.out.println(str.length());
        }
    }
}
```

## Summary

This comprehensive overview covers the essential Java concepts you'll need for programming:

1. **Program Structure**: Classes, main method, and file organization
2. **Output and Comments**: Different ways to print and document code
3. **Variables and Types**: Primitive types, declarations, and type conversion
4. **Operators**: Arithmetic, comparison, logical, and assignment operators
5. **Conditionals**: If statements, switch statements, and ternary operators
6. **Loops**: For, while, do-while loops with break and continue
7. **Strings**: Creation, manipulation, and comparison
8. **Methods**: Definition, parameters, return values, and overloading
9. **Arrays**: One-dimensional and two-dimensional arrays
10. **Best Practices**: Code style, conventions, and common pitfalls

Practice these concepts with small programs to reinforce your understanding. Each concept builds upon the previous ones, so make sure you're comfortable with each section before moving on.
