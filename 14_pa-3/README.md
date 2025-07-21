# Programming Assignment 3: Student Course Enrollment System

## Overview

In this assignment, you will implement a simple Student Course Enrollment System using nested collections in Java. You will use a `Map` to associate each student with a list of courses they are enrolled in. This assignment will help you practice working with nested collections such as `Map<String, List<String>>`.

## Objectives

- Practice using nested collections (`Map` and `List`) in Java.
- Implement methods to add students, enroll them in courses, and display enrollments.
- Apply concepts of iteration, collection manipulation, and basic input/output.

## Requirements

1. **StudentCourseManager.java**  
   Implement a class with the following methods:
   - `void addStudent(String studentName)`: Adds a new student.
   - `void enrollCourse(String studentName, String courseName)`: Enrolls a student in a course.
   - `List<String> getCourses(String studentName)`: Returns the list of courses for a student.
   - `void printAllEnrollments()`: Prints all students and their courses.

2. **Main.java**  
   - Provides a simple menu-driven interface to:
     - Add a student
     - Enroll a student in a course
     - Display all enrollments
     - Exit

3. **Starter Files**  
   - `StudentCourseManager.java` and `Main.java` are provided as starter code. Complete the TODOs in `StudentCourseManager.java`.

4. **Sample Output**
   ```
   1. Add Student
   2. Enroll in Course
   3. Display All Enrollments
   4. Exit
   Enter choice: 1
   Enter student name: Alice
   Student added.

   Enter choice: 2
   Enter student name: Alice
   Enter course name: Math
   Course enrolled.

   Enter choice: 3
   Alice: [Math]
   ```

## Instructions

- Implement the missing logic in `StudentCourseManager.java`.
- Use the menu in `Main.java` to test your implementation.
- You may add additional helper methods if needed.
- Submit both `.java` files when finished.

## Tips

- Use the provided comments and method stubs as guidance.
- Test your code with multiple students and courses.
- Focus on correct use of nested collections.

---

**Estimated time to complete:** 90 minutes