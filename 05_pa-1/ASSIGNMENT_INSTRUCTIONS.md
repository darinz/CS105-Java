# Programming Assignment 1: Detailed Instructions

## Assignment Overview
You will implement a Student Grade Manager system that demonstrates mastery of Java File I/O concepts. The assignment is divided into three parts, each building upon the previous one.

## Part 1: Student Data Reader (30 minutes)

### Objective
Implement the `readStudentData()` method to read student information from a text file and validate the data.

### Requirements
1. **File Reading**: Use Scanner to read from the `students.txt` file
2. **Data Parsing**: Split each line by comma to extract ID, Name, and Email
3. **Validation**: Ensure each line has exactly 3 parts
4. **Object Creation**: Create Student objects for valid data
5. **Error Handling**: Provide meaningful error messages for invalid lines
6. **Resource Management**: Properly close the Scanner

### File Format
```
ID,Name,Email
1001,John Smith,john.smith@email.com
1002,Sarah Johnson,sarah.johnson@email.com
```

### Implementation Hints
- Use `File` class to create a file object
- Use `Scanner` constructor that takes a `File` object
- Use `nextLine()` to read each line
- Use `split(",")` to separate fields
- Check `parts.length == 3` for validation
- Use try-catch for `FileNotFoundException`

### Expected Output
```
Reading student data from students.txt...
Successfully read 10 student records.
```

## Part 2: Grade Calculator (30 minutes)

### Objective
Implement the `readGradeData()` method to read grade information from a file and validate the scores.

### Requirements
1. **File Reading**: Use Scanner to read from the `grades.txt` file
2. **Data Parsing**: Split each line by comma to extract ID and three scores
3. **Score Validation**: Ensure all scores are between 0 and 100
4. **Object Creation**: Create GradeRecord objects for valid data
5. **Data Structure**: Store grades in a Map using student ID as key
6. **Error Handling**: Handle invalid scores and malformed lines
7. **Resource Management**: Properly close the Scanner

### File Format
```
ID,AssignmentScore,MidtermScore,FinalScore
1001,85.5,78.0,82.5
1002,92.0,88.5,90.0
```

### Implementation Hints
- Use `Double.parseDouble()` to convert strings to doubles
- Validate scores: `score >= 0 && score <= 100`
- Use `HashMap<String, GradeRecord>` to store grades
- Handle `NumberFormatException` for invalid numbers

### Expected Output
```
Reading grade data from grades.txt...
Successfully read 10 grade records.
```

## Part 3: Report Generator (30 minutes)

### Objective
Implement the `calculateFinalGrades()` and `generateReports()` methods to process data and create output files.

### Requirements for `calculateFinalGrades()`
1. **Data Matching**: Match students with their grade records
2. **Grade Calculation**: Use weighted formula:
   - Final Grade = (Assignment × 0.40) + (Midterm × 0.25) + (Final × 0.35)
3. **Letter Grade**: Determine letter grade using `getLetterGrade()` method
4. **Object Creation**: Create StudentReport objects
5. **Missing Data**: Handle students without grade records

### Requirements for `generateReports()`
1. **Summary Report**: Create `class_summary.txt` with:
   - Total students, class average, highest/lowest scores
   - Grade distribution (count and percentage for each letter grade)
2. **Individual Reports**: Create separate files for each student
3. **File Output**: Use PrintStream to write formatted output
4. **Error Handling**: Handle file writing exceptions
5. **Formatting**: Create professional-looking reports with headers and spacing

### Implementation Hints
- Use `PrintStream` constructor that takes a `File` object
- Use `printf()` for formatted output
- Calculate statistics using loops through the reports list
- Use `String.format()` for consistent formatting
- Handle `IOException` for file writing operations

### Expected Output Files
1. `class_summary.txt` - Overall class statistics
2. `student_[ID]_report.txt` - Individual student reports
3. `grade_distribution.txt` - Grade distribution table

## Testing Your Implementation

### Step 1: Compile and Run
```bash
javac StudentGradeManager.java
java StudentGradeManager
```

### Step 2: Verify Output
- Check console output matches expected format
- Verify all output files are created
- Compare your output with `expected_output.txt`

### Step 3: Test Edge Cases
- Try with missing input files
- Test with malformed data in input files
- Verify error messages are helpful

## Grading Rubric

### Functionality (60%)
- **Part 1 (20%)**: Student data reading works correctly
- **Part 2 (20%)**: Grade data reading and validation works
- **Part 3 (20%)**: Report generation produces correct output

### Code Quality (25%)
- **Structure**: Well-organized, readable code
- **Comments**: Clear documentation and inline comments
- **Naming**: Descriptive variable and method names
- **Consistency**: Consistent coding style

### Error Handling (15%)
- **File Errors**: Proper handling of missing files
- **Data Validation**: Appropriate validation of input data
- **User Feedback**: Clear error messages for users

## Common Pitfalls to Avoid

1. **Forgetting to close Scanners**: Always close file resources
2. **Not handling exceptions**: Use try-catch blocks appropriately
3. **Poor data validation**: Check for null values and invalid formats
4. **Incorrect file paths**: Use relative paths for input files
5. **Formatting issues**: Use proper spacing and alignment in reports

## Getting Help

If you encounter issues:
1. Check the console for error messages
2. Verify input files are in the correct location
3. Test each part incrementally
4. Use debug print statements to trace execution
5. Review the course materials on File I/O concepts

## Submission Checklist

- [ ] All three parts implemented and working
- [ ] Code compiles without errors
- [ ] Program runs successfully with provided test files
- [ ] All output files generated correctly
- [ ] Error handling implemented properly
- [ ] Code is well-commented and readable
- [ ] All files submitted (Java source, input files, output files)

Good luck with your assignment! 