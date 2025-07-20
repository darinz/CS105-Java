# Practice, Reviews, and Applications

## Overview
This practice session covers key concepts from the Introduction to Java programming. Complete these problems to reinforce your understanding of:
- Java program structure and syntax
- Variables, data types, and expressions
- Control structures (loops and conditionals)
- Functional decomposition
- Code quality principles
- Problem-solving strategies

**Estimated Time**: 90 minutes for intermediate level students

---

## Problem 1: Temperature Converter (15 minutes)

### Problem Description
Create a Java program that converts temperatures between Celsius and Fahrenheit. The program should:
1. Display a menu with conversion options
2. Accept user input for the temperature value
3. Perform the conversion using the appropriate formula
4. Display the result with proper formatting

### Requirements
- Use proper variable naming conventions
- Include input validation (temperature should be reasonable)
- Use functional decomposition (break into methods)
- Add appropriate comments

### Formulas
- Celsius to Fahrenheit: `F = (C × 9/5) + 32`
- Fahrenheit to Celsius: `C = (F - 32) × 5/9`

### Starter Code
```java
import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        // TODO: Implement the temperature converter
    }
}
```

### Solution
```java
import java.util.Scanner;

/**
 * Temperature Converter - Converts between Celsius and Fahrenheit
 * Demonstrates functional decomposition and input validation
 */
public class TemperatureConverter {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        displayWelcome();
        runConverter();
        scanner.close();
    }
    
    /**
     * Displays welcome message and instructions
     */
    private static void displayWelcome() {
        System.out.println("=== Temperature Converter ===");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("3. Exit");
    }
    
    /**
     * Main program loop
     */
    private static void runConverter() {
        boolean continueRunning = true;
        
        while (continueRunning) {
            System.out.print("\nEnter your choice (1-3): ");
            int choice = getValidChoice();
            
            switch (choice) {
                case 1:
                    convertCelsiusToFahrenheit();
                    break;
                case 2:
                    convertFahrenheitToCelsius();
                    break;
                case 3:
                    continueRunning = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    /**
     * Gets and validates user choice
     */
    private static int getValidChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a number (1-3): ");
            scanner.next();
        }
        return scanner.nextInt();
    }
    
    /**
     * Converts Celsius to Fahrenheit
     */
    private static void convertCelsiusToFahrenheit() {
        System.out.print("Enter temperature in Celsius: ");
        double celsius = getValidTemperature();
        
        double fahrenheit = (celsius * 9.0 / 5.0) + 32;
        System.out.printf("%.1f°C = %.1f°F%n", celsius, fahrenheit);
    }
    
    /**
     * Converts Fahrenheit to Celsius
     */
    private static void convertFahrenheitToCelsius() {
        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = getValidTemperature();
        
        double celsius = (fahrenheit - 32) * 5.0 / 9.0;
        System.out.printf("%.1f°F = %.1f°C%n", fahrenheit, celsius);
    }
    
    /**
     * Gets and validates temperature input
     */
    private static double getValidTemperature() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Please enter a valid number: ");
            scanner.next();
        }
        double temp = scanner.nextDouble();
        
        // Validate reasonable temperature range
        if (temp < -273.15) { // Below absolute zero
            System.out.println("Warning: Temperature below absolute zero!");
        }
        
        return temp;
    }
}
```

### Key Learning Points
1. **Functional Decomposition**: Each method has a single responsibility
2. **Input Validation**: Checking for valid numeric input and reasonable ranges
3. **Variable Naming**: Clear, descriptive names like `celsius`, `fahrenheit`, `choice`
4. **Comments**: JavaDoc comments for methods, inline comments for complex logic
5. **User Experience**: Clear prompts and formatted output

---

## Problem 2: Number Pattern Generator (20 minutes)

### Problem Description
Create a program that generates various number patterns. The program should:
1. Display a menu of pattern options
2. Accept user input for pattern size
3. Generate and display the requested pattern
4. Use nested loops effectively

### Pattern Options
1. **Right Triangle**: Numbers increasing by 1
   ```
   1
   1 2
   1 2 3
   1 2 3 4
   ```

2. **Pyramid**: Numbers centered
   ```
      1
     1 2
    1 2 3
   1 2 3 4
   ```

3. **Number Square**: Filled square pattern
   ```
   1 1 1 1
   2 2 2 2
   3 3 3 3
   4 4 4 4
   ```

### Requirements
- Use nested for loops
- Implement proper spacing for pyramid pattern
- Validate input (size should be 1-10)
- Use functional decomposition

### Solution
```java
import java.util.Scanner;

/**
 * Number Pattern Generator - Creates various number patterns
 * Demonstrates nested loops and functional decomposition
 */
public class NumberPatternGenerator {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        displayMenu();
        runPatternGenerator();
        scanner.close();
    }
    
    /**
     * Displays the pattern menu
     */
    private static void displayMenu() {
        System.out.println("=== Number Pattern Generator ===");
        System.out.println("1. Right Triangle");
        System.out.println("2. Pyramid");
        System.out.println("3. Number Square");
        System.out.println("4. Exit");
    }
    
    /**
     * Main program loop
     */
    private static void runPatternGenerator() {
        boolean continueRunning = true;
        
        while (continueRunning) {
            System.out.print("\nEnter your choice (1-4): ");
            int choice = getValidChoice();
            
            if (choice == 4) {
                continueRunning = false;
                System.out.println("Goodbye!");
                continue;
            }
            
            System.out.print("Enter pattern size (1-10): ");
            int size = getValidSize();
            
            switch (choice) {
                case 1:
                    generateRightTriangle(size);
                    break;
                case 2:
                    generatePyramid(size);
                    break;
                case 3:
                    generateNumberSquare(size);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    /**
     * Gets and validates user choice
     */
    private static int getValidChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a number (1-4): ");
            scanner.next();
        }
        return scanner.nextInt();
    }
    
    /**
     * Gets and validates pattern size
     */
    private static int getValidSize() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number: ");
            scanner.next();
        }
        int size = scanner.nextInt();
        
        while (size < 1 || size > 10) {
            System.out.print("Size must be between 1 and 10. Try again: ");
            size = scanner.nextInt();
        }
        
        return size;
    }
    
    /**
     * Generates a right triangle pattern
     */
    private static void generateRightTriangle(int size) {
        System.out.println("Right Triangle Pattern:");
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println(); // Move to next line
        }
    }
    
    /**
     * Generates a pyramid pattern
     */
    private static void generatePyramid(int size) {
        System.out.println("Pyramid Pattern:");
        for (int row = 1; row <= size; row++) {
            // Print leading spaces
            for (int space = 1; space <= size - row; space++) {
                System.out.print(" ");
            }
            
            // Print numbers
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
    
    /**
     * Generates a number square pattern
     */
    private static void generateNumberSquare(int size) {
        System.out.println("Number Square Pattern:");
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size; col++) {
                System.out.print(row + " ");
            }
            System.out.println();
        }
    }
}
```

### Key Learning Points
1. **Nested Loops**: Understanding how to control both row and column iteration
2. **Pattern Recognition**: Breaking down complex patterns into simple loop structures
3. **Spacing Logic**: Using spaces to create visual alignment
4. **Input Validation**: Ensuring reasonable input ranges
5. **Code Organization**: Each pattern in its own method for clarity

---

## Problem 3: Array Operations Calculator (25 minutes)

### Problem Description
Create a program that performs various operations on arrays. The program should:
1. Generate a random array of integers
2. Provide a menu of array operations
3. Implement each operation correctly
4. Handle edge cases (empty arrays, single elements)

### Array Operations
1. **Find Maximum**: Find the largest value in the array
2. **Find Minimum**: Find the smallest value in the array
3. **Calculate Average**: Compute the arithmetic mean
4. **Count Even Numbers**: Count how many even numbers are in the array
5. **Reverse Array**: Create a reversed copy of the array
6. **Find Duplicates**: Find and display duplicate values

### Requirements
- Use proper array indexing (0-based)
- Handle edge cases gracefully
- Use functional decomposition
- Implement efficient algorithms

### Solution
```java
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

/**
 * Array Operations Calculator - Performs various operations on arrays
 * Demonstrates array manipulation and algorithm implementation
 */
public class ArrayOperationsCalculator {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static int[] numbers;
    
    public static void main(String[] args) {
        generateArray();
        runArrayOperations();
        scanner.close();
    }
    
    /**
     * Generates a random array of integers
     */
    private static void generateArray() {
        System.out.print("Enter array size (5-20): ");
        int size = getValidSize();
        
        numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(100) + 1; // Random numbers 1-100
        }
        
        System.out.println("Generated array: " + Arrays.toString(numbers));
    }
    
    /**
     * Gets and validates array size
     */
    private static int getValidSize() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number: ");
            scanner.next();
        }
        int size = scanner.nextInt();
        
        while (size < 5 || size > 20) {
            System.out.print("Size must be between 5 and 20. Try again: ");
            size = scanner.nextInt();
        }
        
        return size;
    }
    
    /**
     * Main program loop for array operations
     */
    private static void runArrayOperations() {
        boolean continueRunning = true;
        
        while (continueRunning) {
            displayMenu();
            System.out.print("Enter your choice (1-7): ");
            int choice = getValidChoice();
            
            switch (choice) {
                case 1:
                    findMaximum();
                    break;
                case 2:
                    findMinimum();
                    break;
                case 3:
                    calculateAverage();
                    break;
                case 4:
                    countEvenNumbers();
                    break;
                case 5:
                    reverseArray();
                    break;
                case 6:
                    findDuplicates();
                    break;
                case 7:
                    continueRunning = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    /**
     * Displays the operations menu
     */
    private static void displayMenu() {
        System.out.println("\n=== Array Operations ===");
        System.out.println("1. Find Maximum");
        System.out.println("2. Find Minimum");
        System.out.println("3. Calculate Average");
        System.out.println("4. Count Even Numbers");
        System.out.println("5. Reverse Array");
        System.out.println("6. Find Duplicates");
        System.out.println("7. Exit");
    }
    
    /**
     * Gets and validates user choice
     */
    private static int getValidChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a number (1-7): ");
            scanner.next();
        }
        return scanner.nextInt();
    }
    
    /**
     * Finds the maximum value in the array
     */
    private static void findMaximum() {
        if (numbers.length == 0) {
            System.out.println("Array is empty!");
            return;
        }
        
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        System.out.println("Maximum value: " + max);
    }
    
    /**
     * Finds the minimum value in the array
     */
    private static void findMinimum() {
        if (numbers.length == 0) {
            System.out.println("Array is empty!");
            return;
        }
        
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        System.out.println("Minimum value: " + min);
    }
    
    /**
     * Calculates the average of all values in the array
     */
    private static void calculateAverage() {
        if (numbers.length == 0) {
            System.out.println("Array is empty!");
            return;
        }
        
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        
        double average = (double) sum / numbers.length;
        System.out.printf("Average: %.2f%n", average);
    }
    
    /**
     * Counts the number of even values in the array
     */
    private static void countEvenNumbers() {
        int evenCount = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                evenCount++;
            }
        }
        System.out.println("Even numbers count: " + evenCount);
    }
    
    /**
     * Creates and displays a reversed copy of the array
     */
    private static void reverseArray() {
        int[] reversed = new int[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            reversed[i] = numbers[numbers.length - 1 - i];
        }
        
        System.out.println("Reversed array: " + Arrays.toString(reversed));
    }
    
    /**
     * Finds and displays duplicate values in the array
     */
    private static void findDuplicates() {
        System.out.print("Duplicate values: ");
        boolean foundDuplicates = false;
        
        for (int i = 0; i < numbers.length; i++) {
            boolean isDuplicate = false;
            
            // Check if this value appears earlier in the array
            for (int j = 0; j < i; j++) {
                if (numbers[i] == numbers[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            
            // If it's a duplicate, check if we've already reported it
            if (isDuplicate) {
                boolean alreadyReported = false;
                for (int k = 0; k < i; k++) {
                    if (numbers[i] == numbers[k]) {
                        alreadyReported = true;
                        break;
                    }
                }
                
                if (!alreadyReported) {
                    System.out.print(numbers[i] + " ");
                    foundDuplicates = true;
                }
            }
        }
        
        if (!foundDuplicates) {
            System.out.print("None");
        }
        System.out.println();
    }
}
```

### Key Learning Points
1. **Array Indexing**: Proper 0-based indexing and bounds checking
2. **Algorithm Efficiency**: Understanding time complexity of different approaches
3. **Edge Case Handling**: Dealing with empty arrays and single elements
4. **Array Manipulation**: Creating copies, reversing, and searching arrays
5. **Data Type Conversion**: Using casting for accurate calculations

---

## Problem 4: Simple Calculator with Error Handling (20 minutes)

### Problem Description
Create a calculator that performs basic arithmetic operations with comprehensive error handling. The program should:
1. Accept two numbers and an operation
2. Perform the calculation safely
3. Handle various error conditions
4. Provide clear error messages

### Operations
- Addition (+)
- Subtraction (-)
- Multiplication (*)
- Division (/)
- Modulo (%)

### Error Conditions to Handle
- Division by zero
- Invalid numeric input
- Invalid operation selection
- Overflow conditions

### Requirements
- Use try-catch blocks for exception handling
- Validate all inputs
- Provide user-friendly error messages
- Use functional decomposition

### Solution
```java
import java.util.Scanner;

/**
 * Simple Calculator with Error Handling
 * Demonstrates exception handling and input validation
 */
public class SimpleCalculator {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        displayWelcome();
        runCalculator();
        scanner.close();
    }
    
    /**
     * Displays welcome message and instructions
     */
    private static void displayWelcome() {
        System.out.println("=== Simple Calculator ===");
        System.out.println("Operations: +, -, *, /, %");
        System.out.println("Enter 'quit' to exit");
    }
    
    /**
     * Main calculator loop
     */
    private static void runCalculator() {
        boolean continueRunning = true;
        
        while (continueRunning) {
            try {
                System.out.print("\nEnter first number: ");
                String input = scanner.nextLine().trim();
                
                if (input.equalsIgnoreCase("quit")) {
                    continueRunning = false;
                    System.out.println("Goodbye!");
                    continue;
                }
                
                double firstNumber = parseNumber(input);
                
                System.out.print("Enter operation (+, -, *, /, %): ");
                String operation = scanner.nextLine().trim();
                
                if (!isValidOperation(operation)) {
                    System.out.println("Error: Invalid operation. Please use +, -, *, /, or %");
                    continue;
                }
                
                System.out.print("Enter second number: ");
                input = scanner.nextLine().trim();
                double secondNumber = parseNumber(input);
                
                double result = performCalculation(firstNumber, operation, secondNumber);
                displayResult(firstNumber, operation, secondNumber, result);
                
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number");
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }
    
    /**
     * Parses a string to a double with validation
     */
    private static double parseNumber(String input) throws NumberFormatException {
        if (input.isEmpty()) {
            throw new NumberFormatException("Empty input");
        }
        
        double number = Double.parseDouble(input);
        
        // Check for overflow
        if (Double.isInfinite(number) || Double.isNaN(number)) {
            throw new NumberFormatException("Number is too large or invalid");
        }
        
        return number;
    }
    
    /**
     * Validates if the operation is supported
     */
    private static boolean isValidOperation(String operation) {
        return operation.equals("+") || operation.equals("-") || 
               operation.equals("*") || operation.equals("/") || 
               operation.equals("%");
    }
    
    /**
     * Performs the calculation with error checking
     */
    private static double performCalculation(double first, String operation, double second) 
            throws ArithmeticException {
        
        switch (operation) {
            case "+":
                return add(first, second);
            case "-":
                return subtract(first, second);
            case "*":
                return multiply(first, second);
            case "/":
                return divide(first, second);
            case "%":
                return modulo(first, second);
            default:
                throw new ArithmeticException("Invalid operation");
        }
    }
    
    /**
     * Addition operation
     */
    private static double add(double a, double b) {
        double result = a + b;
        if (Double.isInfinite(result)) {
            throw new ArithmeticException("Result is too large (overflow)");
        }
        return result;
    }
    
    /**
     * Subtraction operation
     */
    private static double subtract(double a, double b) {
        double result = a - b;
        if (Double.isInfinite(result)) {
            throw new ArithmeticException("Result is too large (overflow)");
        }
        return result;
    }
    
    /**
     * Multiplication operation
     */
    private static double multiply(double a, double b) {
        double result = a * b;
        if (Double.isInfinite(result)) {
            throw new ArithmeticException("Result is too large (overflow)");
        }
        return result;
    }
    
    /**
     * Division operation with zero check
     */
    private static double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        
        double result = a / b;
        if (Double.isInfinite(result)) {
            throw new ArithmeticException("Result is too large (overflow)");
        }
        return result;
    }
    
    /**
     * Modulo operation with zero check
     */
    private static double modulo(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Modulo by zero is not allowed");
        }
        
        double result = a % b;
        if (Double.isInfinite(result)) {
            throw new ArithmeticException("Result is too large (overflow)");
        }
        return result;
    }
    
    /**
     * Displays the calculation result
     */
    private static void displayResult(double first, String operation, double second, double result) {
        System.out.printf("%.2f %s %.2f = %.2f%n", first, operation, second, result);
    }
}
```

### Key Learning Points
1. **Exception Handling**: Using try-catch blocks to handle errors gracefully
2. **Input Validation**: Checking for valid numbers and operations
3. **Arithmetic Safety**: Preventing division by zero and overflow
4. **User Experience**: Clear error messages and graceful error recovery
5. **Method Organization**: Each operation in its own method for clarity

---

## Problem 5: Word Counter and Analyzer (10 minutes)

### Problem Description
Create a program that analyzes text input. The program should:
1. Accept a sentence or paragraph from the user
2. Count words, characters, and sentences
3. Find the longest and shortest words
4. Calculate average word length

### Requirements
- Use String methods effectively
- Handle edge cases (empty input, single words)
- Use arrays or collections appropriately
- Implement proper text parsing

### Solution
```java
import java.util.Scanner;

/**
 * Word Counter and Analyzer - Analyzes text input
 * Demonstrates String manipulation and text processing
 */
public class WordAnalyzer {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        displayWelcome();
        analyzeText();
        scanner.close();
    }
    
    /**
     * Displays welcome message
     */
    private static void displayWelcome() {
        System.out.println("=== Word Counter and Analyzer ===");
        System.out.println("Enter text to analyze (press Enter twice to finish):");
    }
    
    /**
     * Main text analysis method
     */
    private static void analyzeText() {
        StringBuilder textBuilder = new StringBuilder();
        String line;
        
        // Read multiple lines of text
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            textBuilder.append(line).append(" ");
        }
        
        String text = textBuilder.toString().trim();
        
        if (text.isEmpty()) {
            System.out.println("No text provided for analysis.");
            return;
        }
        
        performAnalysis(text);
    }
    
    /**
     * Performs comprehensive text analysis
     */
    private static void performAnalysis(String text) {
        System.out.println("\n=== Analysis Results ===");
        
        // Basic counts
        int characterCount = countCharacters(text);
        int wordCount = countWords(text);
        int sentenceCount = countSentences(text);
        
        System.out.println("Characters (including spaces): " + characterCount);
        System.out.println("Characters (excluding spaces): " + countCharactersNoSpaces(text));
        System.out.println("Words: " + wordCount);
        System.out.println("Sentences: " + sentenceCount);
        
        // Word analysis
        if (wordCount > 0) {
            String[] words = extractWords(text);
            String longestWord = findLongestWord(words);
            String shortestWord = findShortestWord(words);
            double averageLength = calculateAverageWordLength(words);
            
            System.out.println("Longest word: \"" + longestWord + "\" (" + longestWord.length() + " characters)");
            System.out.println("Shortest word: \"" + shortestWord + "\" (" + shortestWord.length() + " characters)");
            System.out.printf("Average word length: %.1f characters%n", averageLength);
        }
    }
    
    /**
     * Counts total characters including spaces
     */
    private static int countCharacters(String text) {
        return text.length();
    }
    
    /**
     * Counts characters excluding spaces
     */
    private static int countCharactersNoSpaces(String text) {
        return text.replaceAll("\\s", "").length();
    }
    
    /**
     * Counts words in the text
     */
    private static int countWords(String text) {
        if (text.trim().isEmpty()) {
            return 0;
        }
        
        String[] words = text.trim().split("\\s+");
        return words.length;
    }
    
    /**
     * Counts sentences in the text
     */
    private static int countSentences(String text) {
        if (text.trim().isEmpty()) {
            return 0;
        }
        
        // Split by sentence endings: ., !, ?
        String[] sentences = text.split("[.!?]+");
        
        // Filter out empty sentences
        int count = 0;
        for (String sentence : sentences) {
            if (!sentence.trim().isEmpty()) {
                count++;
            }
        }
        
        return count;
    }
    
    /**
     * Extracts words from text
     */
    private static String[] extractWords(String text) {
        return text.trim().split("\\s+");
    }
    
    /**
     * Finds the longest word in the array
     */
    private static String findLongestWord(String[] words) {
        if (words.length == 0) {
            return "";
        }
        
        String longest = words[0];
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }
    
    /**
     * Finds the shortest word in the array
     */
    private static String findShortestWord(String[] words) {
        if (words.length == 0) {
            return "";
        }
        
        String shortest = words[0];
        for (String word : words) {
            if (word.length() < shortest.length()) {
                shortest = word;
            }
        }
        return shortest;
    }
    
    /**
     * Calculates average word length
     */
    private static double calculateAverageWordLength(String[] words) {
        if (words.length == 0) {
            return 0.0;
        }
        
        int totalLength = 0;
        for (String word : words) {
            totalLength += word.length();
        }
        
        return (double) totalLength / words.length;
    }
}
```

### Key Learning Points
1. **String Methods**: Using `split()`, `trim()`, `replaceAll()`, and `length()`
2. **Text Processing**: Parsing and analyzing text content
3. **Array Operations**: Working with arrays of strings
4. **Edge Case Handling**: Dealing with empty input and single words
5. **Regular Expressions**: Using regex patterns for text splitting

---

## Summary and Review

### Concepts Reinforced
1. **Java Fundamentals**: Program structure, variables, data types, control structures
2. **Functional Decomposition**: Breaking complex problems into manageable methods
3. **Code Quality**: Proper naming, comments, and organization
4. **Error Handling**: Input validation and exception handling
5. **Algorithm Design**: Efficient problem-solving strategies

### Common Patterns
- **Menu-driven programs**: Using switch statements and loops
- **Input validation**: Checking for valid user input
- **Array manipulation**: Iterating, searching, and modifying arrays
- **String processing**: Parsing and analyzing text
- **Mathematical operations**: Calculations with proper error handling

### Best Practices Demonstrated
- **Descriptive variable names**: `celsius`, `fahrenheit`, `wordCount`
- **Method organization**: Each method has a single responsibility
- **Error handling**: Graceful handling of invalid input
- **User experience**: Clear prompts and formatted output
- **Code comments**: Explaining complex logic and method purposes

### Next Steps
After completing these problems, you should be comfortable with:
- Writing complete Java programs from scratch
- Implementing functional decomposition
- Handling user input safely
- Working with arrays and strings
- Applying code quality principles

Practice these concepts regularly to build confidence and improve your programming skills!