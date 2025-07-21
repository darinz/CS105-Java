# Java OOP Practice, Review, and Applications

Welcome! This guide will help you master Java’s Object-Oriented Programming (OOP) concepts through clear explanations, annotated code, and hands-on practice problems with detailed solutions. Each section builds on the last, so you can follow along step by step.

---

## 1. Reference Variables and Object Assignment

**Concept:**  
In Java, variables that refer to objects (like `Point p`) are *references*, not the objects themselves. Assigning one reference to another does not copy the object, but makes both references point to the same object in memory.

**Example:**
```java
Point p = new Point();
p.x = 3;
p.y = 10;

Point p2 = p; // p2 now refers to the same object as p
p2.y = 100;   // changes the y value of the object both p and p2 refer to

p = new Point(); // p now refers to a new object; p2 still refers to the old one
p.y = -99;       // changes the y value of the new object only
```

**Explanation:**  
- After `Point p2 = p;`, both `p` and `p2` refer to the same `Point` object.
- Changing `p2.y` also changes `p.y` because they are the same object.
- When you do `p = new Point();`, `p` now refers to a new object, but `p2` still refers to the original object.

**Practice Problem:**  
What are the values of `p` and `p2` after the code above?

| Choice | p (x, y)   | p2 (x, y)   |
|--------|------------|-------------|
| A      | (3, 10)    | (3, 10)     |
| B      | (3, -99)   | (3, 100)    |
| C      | (0, -99)   | (3, 100)    |
| D      | (3, -99)   | (0, 100)    |
| E      | (0, -99)   | (3, 10)     |

**Solution:**  
- `p` refers to a new Point (0, -99), `p2` still refers to the original (3, 100).  
- **Correct answer: C**

---

## 2. Instance Methods and the `this` Keyword

**Concept:**  
Instance methods operate on the data (fields) of a specific object. The `this` keyword refers to the current object.

**Example:**
```java
public class Point {
    public int x, y;
    public double distanceFrom(Point otherPoint) {
        double xTerm = Math.pow(otherPoint.x - this.x, 2);
        double yTerm = Math.pow(otherPoint.y - this.y, 2);
        return Math.sqrt(xTerm + yTerm);
    }
}
```

**Practice Problem:**  
Which of the following is the correct implementation for a method that computes the distance from the current point to another point?

A)
```java
public double distanceFrom() {
    double xTerm = Math.pow(x - x, 2);
    double yTerm = Math.pow(y - y, 2);
    return Math.sqrt(xTerm + yTerm);
}
```
B)
```java
public static double distanceFrom(Point otherPoint) {
    double xTerm = Math.pow(otherPoint.x - x, 2);
    double yTerm = Math.pow(otherPoint.y - y, 2);
    return Math.sqrt(xTerm + yTerm);
}
```
C)
```java
public double distanceFrom(Point otherPoint) {
    double xTerm = Math.pow(otherPoint.x - x, 2);
    double yTerm = Math.pow(otherPoint.y - y, 2);
    return Math.sqrt(xTerm + yTerm);
}
```
D)
```java
public double distanceFrom(int otherX, int otherY) {
    double xTerm = Math.pow(otherX - x, 2);
    double yTerm = Math.pow(otherY - y, 2);
    return Math.sqrt(xTerm + yTerm);
}
```

**Solution:**  
- **C** is correct. It’s an instance method, takes another Point, and uses the correct formula.

---

## 3. Constructors

**Concept:**  
A constructor is a special method used to initialize new objects.

**Example:**
```java
public class Student {
    private int studentNumber;
    private String name;
    public Student(int studentNumber, String name) {
        this.studentNumber = studentNumber;
        this.name = name;
    }
}
```

---

## 4. Encapsulation: Getters and Setters

**Concept:**  
Encapsulation means keeping fields private and providing public methods to access or modify them.

**Example:**
```java
public class Student {
    private int studentNumber;
    private String name;
    public String getName() { return name; }
    public int getStudentNumber() { return studentNumber; }
    public void setName(String newName) { this.name = newName; }
}
```

---

## 5. Overriding `toString` and `equals`

**Concept:**  
- `toString()` provides a string representation of the object.
- `equals(Object other)` checks if two objects are "equal" in a meaningful way.

**Example:**
```java
@Override
public String toString() {
    return name + " (" + studentNumber + ")";
}
@Override
public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null || getClass() != other.getClass()) return false;
    Student student = (Student) other;
    return studentNumber == student.studentNumber;
}
```

---

## 6. Immutability: Why No `setStudentNumber`?

**Concept:**  
A student's number is a unique identifier and should not change after the object is created. This is an example of *immutability* for certain fields.

---

## 7. Course Class: Managing Collections of Objects

**Concept:**  
A class can have fields that are arrays or collections of other objects.

**Example:**
```java
public class Course {
    private int sln;
    private String courseCode;
    private int credits;
    private ArrayList<Student> roster;
    public Course(int sln, String courseCode, int credits) {
        this.sln = sln;
        this.courseCode = courseCode;
        this.credits = credits;
        this.roster = new ArrayList<>();
    }
    public Course(int sln, String courseCode, int credits, Student[] enrollment) {
        this.sln = sln;
        this.courseCode = courseCode;
        this.credits = credits;
        this.roster = new ArrayList<>(Arrays.asList(enrollment));
    }
    public void updateRoster(Student[] students) {
        this.roster = new ArrayList<>(Arrays.asList(students));
    }
    public void addStudent(Student s) {
        if (!roster.contains(s)) roster.add(s);
    }
    public void dropStudent(Student s) {
        roster.remove(s);
    }
    public boolean checkStudentEnrolled(Student s) {
        return roster.contains(s);
    }
    public int getSLN() { return sln; }
    public String getCourseCode() { return courseCode; }
    public int getCredits() { return credits; }
    public Student[] getRoster() { return roster.toArray(new Student[0]); }
}
```

---

## Practice: Student Class Design and Equality

**Objective:** Practice designing a class with encapsulation, constructors, and equality logic.

**Problem:**  
Write a `Student` class that you can construct with a student number and name. Implement:
- `getName()`, `getStudentNumber()`, `setName(String)`, `toString()`, and `equals(Object)` (students are equal if their numbers are equal).
- Why shouldn’t you include a `setStudentNumber` method?

**Solution:**  
See the code and explanation above.  
- The student number is a unique identifier. Allowing it to change could break the system's integrity.

---

## Practice: Course Roster Management

**Objective:** Practice designing a class that manages a collection of objects and enforces business rules.

**Problem:**  
Write a `Course` class for a university system. Each course has an SLN, course code, credits, and a roster of students. Implement:
- Constructors (with and without initial roster)
- `addStudent`, `dropStudent`, `updateRoster`, `checkStudentEnrolled`, and getters

**Solution:**  
See the code and explanation above.  
- The roster is managed as an `ArrayList` for flexibility.
- Methods ensure no duplicate students and safe roster updates.

---

## Practice: Code Analysis – Constructor and Encapsulation

**Objective:** Analyze and improve code for best OOP practices.

**Problem:**  
Given:
```java
public class Person {
    public String name;
    public int age;
    public Person(String n, int a) {
        name = n;
        age = a;
    }
}
```
1. What are the drawbacks of making fields public?
2. Rewrite the class to use private fields and provide appropriate getters and setters.
3. Why might you want to avoid a `setAge` method that allows negative ages?

**Solution:**  
1. No control over how fields are set or accessed; breaks encapsulation; cannot enforce invariants.
2. Use private fields and validate in setters:
```java
public class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        setAge(age);
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) {
        if (age >= 0) this.age = age;
        else throw new IllegalArgumentException("Age cannot be negative");
    }
}
```
3. Negative ages are not realistic and can cause logic errors; validation in the setter prevents invalid state.

---

## Summary

- Java OOP is about designing classes that encapsulate state and behavior.
- Use constructors to initialize objects, getters/setters for encapsulation, and override `toString`/`equals` for usability.
- Reference variables point to objects, not copies.
- Collections (like `ArrayList`) let you manage groups of objects.
- Practice writing, analyzing, and improving classes to master these concepts!

---

If you work through these explanations and problems, you’ll have a strong foundation in Java OOP. Practice writing your own classes and methods, and always think about encapsulation, immutability, and clear design!