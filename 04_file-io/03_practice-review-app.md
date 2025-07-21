# Practice, Reviews, and Applications

## File I/O Practice Problems

This section contains practice coding problems designed to reinforce your understanding of Java file I/O concepts. Each problem should take approximately 10-15 minutes to complete, with a total time of about 60 minutes for all problems.

### Problem 1: User Input Calculator (15 minutes)

**Objective:** Practice using Scanner for user input and basic input validation.

**Problem:** Create a program that asks the user for their name, age, and favorite number, then performs some calculations and displays the results.

**Requirements:**
- Use Scanner to read user input
- Handle different data types (String, int, double)
- Perform calculations and display formatted output
- Include input validation (check if age is positive)

**Sample Output:**
```
Enter your name: John Doe
Enter your age: 25
Enter your favorite number: 7.5

Hello John Doe!
In 10 years, you will be 35 years old.
Your favorite number squared is 56.25
Your age divided by your favorite number is 3.33
```

**Solution:**
```java
import java.util.Scanner;

public class UserInputCalculator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        
        // Get user name
        System.out.print("Enter your name: ");
        String name = console.nextLine();
        
        // Get and validate age
        int age = 0;
        boolean validAge = false;
        while (!validAge) {
            System.out.print("Enter your age: ");
            if (console.hasNextInt()) {
                age = console.nextInt();
                if (age > 0) {
                    validAge = true;
                } else {
                    System.out.println("Age must be positive. Please try again.");
                }
            } else {
                System.out.println("Please enter a valid integer for age.");
                console.next(); // consume invalid input
            }
        }
        
        // Get favorite number
        System.out.print("Enter your favorite number: ");
        double favoriteNumber = console.nextDouble();
        
        // Perform calculations
        int futureAge = age + 10;
        double squaredNumber = favoriteNumber * favoriteNumber;
        double ageDividedByNumber = (double) age / favoriteNumber;
        
        // Display results
        System.out.println("\nHello " + name + "!");
        System.out.println("In 10 years, you will be " + futureAge + " years old.");
        System.out.printf("Your favorite number squared is %.2f%n", squaredNumber);
        System.out.printf("Your age divided by your favorite number is %.2f%n", ageDividedByNumber);
        
        console.close();
    }
}
```

**Key Concepts:**
- Using `nextLine()` for strings that might contain spaces
- Using `hasNextInt()` for input validation
- Type casting for division to get decimal results
- Using `printf()` for formatted output

---

### Problem 2: File Statistics Analyzer (15 minutes)

**Objective:** Practice reading files line-by-line and performing data analysis.

**Problem:** Create a program that reads a file containing numbers (one per line) and calculates statistics.

**Requirements:**
- Read a file named "numbers.txt" line by line
- Calculate count, sum, average, minimum, and maximum
- Handle potential file errors gracefully
- Display results in a formatted manner

**Sample numbers.txt:**
```
42
17
89
3
156
23
```

**Sample Output:**
```
File Statistics:
Count: 6 numbers
Sum: 330
Average: 55.00
Minimum: 3
Maximum: 156
```

**Solution:**
```java
import java.io.*;
import java.util.*;

public class FileStatisticsAnalyzer {
    public static void main(String[] args) {
        try {
            File file = new File("numbers.txt");
            Scanner scanner = new Scanner(file);
            
            int count = 0;
            int sum = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            
            // Read file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                
                // Skip empty lines
                if (line.isEmpty()) {
                    continue;
                }
                
                try {
                    int number = Integer.parseInt(line);
                    count++;
                    sum += number;
                    min = Math.min(min, number);
                    max = Math.max(max, number);
                } catch (NumberFormatException e) {
                    System.out.println("Warning: Skipping invalid line: " + line);
                }
            }
            
            // Display results
            if (count > 0) {
                double average = (double) sum / count;
                System.out.println("File Statistics:");
                System.out.println("Count: " + count + " numbers");
                System.out.println("Sum: " + sum);
                System.out.printf("Average: %.2f%n", average);
                System.out.println("Minimum: " + min);
                System.out.println("Maximum: " + max);
            } else {
                System.out.println("No valid numbers found in file.");
            }
            
            scanner.close();
            
        } catch (FileNotFoundException e) {
            System.err.println("Error: File 'numbers.txt' not found.");
            System.err.println("Please create the file with one number per line.");
        }
    }
}
```

**Key Concepts:**
- Line-by-line reading pattern
- Exception handling for file operations
- Input validation and error handling
- Using `Integer.parseInt()` for string-to-int conversion
- Initializing min/max with extreme values

---

### Problem 3: CSV Data Processor (15 minutes)

**Objective:** Practice reading structured data files with custom delimiters.

**Problem:** Create a program that reads a CSV file containing student information and displays a summary.

**Requirements:**
- Read a CSV file with student data (name, grade, age)
- Use custom delimiter (comma)
- Calculate class statistics
- Handle missing or invalid data gracefully

**Sample students.csv:**
```
John Smith,85,18
Jane Doe,92,17
Bob Johnson,78,19
Alice Brown,95,18
Charlie Wilson,88,17
```

**Sample Output:**
```
Student Summary:
Total students: 5
Average grade: 87.6
Average age: 17.8
Highest grade: 95 (Alice Brown)
Lowest grade: 78 (Bob Johnson)
```

**Solution:**
```java
import java.io.*;
import java.util.*;

public class CSVDataProcessor {
    public static void main(String[] args) {
        try {
            File file = new File("students.csv");
            Scanner fileScanner = new Scanner(file);
            
            int totalStudents = 0;
            double totalGrade = 0;
            double totalAge = 0;
            String highestStudent = "";
            int highestGrade = 0;
            String lowestStudent = "";
            int lowestGrade = 100;
            
            // Read each line
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                
                if (line.isEmpty()) {
                    continue;
                }
                
                // Create scanner for this line with comma delimiter
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter(",");
                
                try {
                    // Read student data
                    String name = lineScanner.next().trim();
                    int grade = Integer.parseInt(lineScanner.next().trim());
                    int age = Integer.parseInt(lineScanner.next().trim());
                    
                    // Update statistics
                    totalStudents++;
                    totalGrade += grade;
                    totalAge += age;
                    
                    // Track highest and lowest grades
                    if (grade > highestGrade) {
                        highestGrade = grade;
                        highestStudent = name;
                    }
                    if (grade < lowestGrade) {
                        lowestGrade = grade;
                        lowestStudent = name;
                    }
                    
                } catch (NumberFormatException e) {
                    System.out.println("Warning: Invalid data in line: " + line);
                } catch (NoSuchElementException e) {
                    System.out.println("Warning: Incomplete data in line: " + line);
                }
                
                lineScanner.close();
            }
            
            // Display results
            if (totalStudents > 0) {
                double avgGrade = totalGrade / totalStudents;
                double avgAge = totalAge / totalStudents;
                
                System.out.println("Student Summary:");
                System.out.println("Total students: " + totalStudents);
                System.out.printf("Average grade: %.1f%n", avgGrade);
                System.out.printf("Average age: %.1f%n", avgAge);
                System.out.println("Highest grade: " + highestGrade + " (" + highestStudent + ")");
                System.out.println("Lowest grade: " + lowestGrade + " (" + lowestStudent + ")");
            } else {
                System.out.println("No valid student data found.");
            }
            
            fileScanner.close();
            
        } catch (FileNotFoundException e) {
            System.err.println("Error: File 'students.csv' not found.");
        }
    }
}
```

**Key Concepts:**
- Hybrid reading pattern (line-by-line, then token-by-token)
- Custom delimiter with `useDelimiter(",")`
- Handling multiple exceptions
- Tracking multiple statistics simultaneously
- Proper resource management with nested scanners

---

### Problem 4: File Output Generator (15 minutes)

**Objective:** Practice writing data to files using PrintStream.

**Problem:** Create a program that generates a report file with formatted data.

**Requirements:**
- Read data from user input or generate sample data
- Write formatted output to a file
- Include different data types and formatting
- Create a professional-looking report

**Sample Output (written to report.txt):**
```
=== STUDENT GRADE REPORT ===
Generated on: 2024-01-15

Student Name          Grade    Status
----------------------------------------
John Smith            85       PASS
Jane Doe              92       PASS
Bob Johnson           78       PASS
Alice Brown           95       PASS
Charlie Wilson        88       PASS

Class Statistics:
Total Students: 5
Average Grade: 87.6
Passing Rate: 100.0%
```

**Solution:**
```java
import java.io.*;
import java.util.*;

public class FileOutputGenerator {
    public static void main(String[] args) {
        // Sample student data
        String[] names = {"John Smith", "Jane Doe", "Bob Johnson", "Alice Brown", "Charlie Wilson"};
        int[] grades = {85, 92, 78, 95, 88};
        
        try {
            File reportFile = new File("report.txt");
            PrintStream output = new PrintStream(reportFile);
            
            // Write header
            output.println("=== STUDENT GRADE REPORT ===");
            output.println("Generated on: " + java.time.LocalDate.now());
            output.println();
            
            // Write table header
            output.printf("%-20s %-8s %-10s%n", "Student Name", "Grade", "Status");
            output.println("----------------------------------------");
            
            // Write student data
            int totalStudents = names.length;
            double totalGrade = 0;
            int passingStudents = 0;
            
            for (int i = 0; i < names.length; i++) {
                String status = grades[i] >= 70 ? "PASS" : "FAIL";
                if (grades[i] >= 70) {
                    passingStudents++;
                }
                
                output.printf("%-20s %-8d %-10s%n", names[i], grades[i], status);
                totalGrade += grades[i];
            }
            
            // Write statistics
            output.println();
            output.println("Class Statistics:");
            output.println("Total Students: " + totalStudents);
            output.printf("Average Grade: %.1f%n", totalGrade / totalStudents);
            output.printf("Passing Rate: %.1f%%%n", (double) passingStudents / totalStudents * 100);
            
            output.close();
            System.out.println("Report generated successfully in 'report.txt'");
            
        } catch (FileNotFoundException e) {
            System.err.println("Error: Could not create report file.");
        }
    }
}
```

**Key Concepts:**
- Using PrintStream for file output
- Formatted output with `printf()`
- String formatting with width specifiers
- Calculating and displaying statistics
- Professional report formatting

---

## Review Questions

**1. Scanner Methods:**
- What's the difference between `next()` and `nextLine()`?
- When would you use `hasNextInt()` before `nextInt()`?
- What happens if you call `nextInt()` when the next token isn't a number?

**2. File Reading Patterns:**
- When would you use line-by-line reading vs. token-by-token reading?
- What is the hybrid pattern and when is it useful?
- How do you handle custom delimiters in CSV files?

**3. Exception Handling:**
- What exceptions should you handle when reading files?
- How do you provide meaningful error messages to users?
- Why is it important to close file resources?

**4. File Output:**
- What's the difference between `print()` and `println()`?
- How do you format numbers and strings in output?
- Why should you always close PrintStream objects?

## Exam Preparation Tips

1. **Practice File Operations:** Create small test files and practice reading/writing them
2. **Understand Patterns:** Know when to use each reading pattern
3. **Error Handling:** Always include try-catch blocks for file operations
4. **Resource Management:** Remember to close scanners and print streams
5. **Input Validation:** Check data types before parsing
6. **Formatting:** Practice using printf() for formatted output

## Additional Practice Ideas

1. Create a program that reads a text file and counts word frequencies
2. Build a simple grade book that reads student data from a file and writes reports
3. Create a data converter that reads one file format and writes to another
4. Build a log file analyzer that processes system logs
5. Create a configuration file reader that loads program settings

Remember: The key to mastering file I/O is practice! Try implementing these problems and experiment with different file formats and data structures.