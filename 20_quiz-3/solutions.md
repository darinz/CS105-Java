# Quiz 3 - Sample Solutions

---

## Question 1: Nested Collections

```java
import java.util.HashMap;
import java.util.ArrayList;

public class Solution {
    /**
     * Returns the name of the student with the highest average score.
     */
    public static String getTopStudent(HashMap<String, ArrayList<Integer>> studentScores) {
        String topStudent = null;
        double highestAvg = -1;
        for (String student : studentScores.keySet()) {
            ArrayList<Integer> scores = studentScores.get(student);
            double sum = 0;
            for (int score : scores) {
                sum += score;
            }
            double avg = scores.size() > 0 ? sum / scores.size() : 0;
            if (avg > highestAvg) {
                highestAvg = avg;
                topStudent = student;
            }
        }
        return topStudent;
    }
}
```

---

## Question 2: Object-Oriented Programming (OOP)

```java
/**
 * Represents a book in a library system.
 */
public class Book {
    private String title;
    private String author;
    private int pages;

    // Constructor
    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Getter for author
    public String getAuthor() {
        return author;
    }

    // Getter for pages
    public int getPages() {
        return pages;
    }

    // Returns true if the book has more than 300 pages
    public boolean isLongBook() {
        return pages > 300;
    }
}
```

---

## Question 3: Interfaces

```java
/**
 * Shape interface with getArea method.
 */
public interface Shape {
    double getArea();
}

/**
 * Rectangle class implementing Shape interface.
 */
public class Rectangle implements Shape {
    private double width;
    private double height;

    // Constructor
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Implementation of getArea
    @Override
    public double getArea() {
        return width * height;
    }
}
``` 