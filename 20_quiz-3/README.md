# Quiz 3

**Instructions:**  
You have 45 minutes to complete this quiz. Answer all three questions. Write your code clearly and include comments where appropriate.

---

### Question 1: Nested Collections

**Topic:** Nested Collections (e.g., ArrayList of HashMaps, etc.)

**Problem:**  
Suppose you are given a list of students, where each student has a list of their test scores. Write a method that takes a `HashMap<String, ArrayList<Integer>>` as input, where the key is the student's name and the value is a list of their test scores. The method should return the name of the student with the highest average score.

**Signature:**  
```java
public static String getTopStudent(HashMap<String, ArrayList<Integer>> studentScores)
```

---

### Question 2: Object-Oriented Programming (OOP)

**Topic:** OOP (Classes, Constructors, Encapsulation)

**Problem:**  
Design a simple `Book` class for a library system. Each book has a title, an author, and a number of pages.  
- Write the class with private fields, a constructor, and getter methods for each field.
- Add a method `isLongBook()` that returns `true` if the book has more than 300 pages.

**Signature:**  
```java
public class Book {
    // fields, constructor, getters, and isLongBook() method
}
```

---

### Question 3: Interfaces

**Topic:** Interfaces

**Problem:**  
Define an interface called `Shape` with a method `double getArea()`. Then, implement a class `Rectangle` that implements the `Shape` interface. The `Rectangle` class should have fields for width and height, a constructor, and implement the `getArea()` method.

**Signatures:**  
```java
public interface Shape {
    double getArea();
}

public class Rectangle implements Shape {
    // fields, constructor, and getArea() implementation
}
```

---
