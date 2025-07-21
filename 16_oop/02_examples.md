# OOP Examples

## Representing a Coordinate Point

How would we do this given what we knew? 

Maybe `int x`, `int y`? 

Maybe `int[]`? 

### Problems with Simple Approaches

#### Using two separate variables:
```java
int x;
int y;
// Two separate variables for coordinates
// Problem: Easy to mix up which is x and which is y
```
- **Problem:** Easy to mix up `x` and `y`. These are just two random integers, so it's easy to make mistakes, like swapping their values or forgetting which is which.

#### Using an array:
```java
int[] point = new int[2];
point[0] = 5; // x coordinate
point[1] = 7; // y coordinate
// Problem: You have to remember which index is x and which is y
// Not self-explanatory, and easy to make mistakes
```
- **Problem:** Not really what an array is for. You have to "trust" that index 0 is always `x` and index 1 is always `y`. This is error-prone and not self-explanatory.

### The OOP Way: Make a Class!

Instead of using primitive types or arrays, we can define a class to represent a point:

```java
// A class to represent a 2D point
public class Point {
    // Fields (instance variables) to store the coordinates
    private int x; // x coordinate
    private int y; // y coordinate

    // Constructor to initialize the point
    public Point(int x, int y) {
        this.x = x; // 'this.x' refers to the field, 'x' is the parameter
        this.y = y; // 'this.y' refers to the field, 'y' is the parameter
    }

    // Instance method to move the point by dx and dy
    public void move(int dx, int dy) {
        this.x += dx; // Add dx to x
        this.y += dy; // Add dy to y
    }

    // Instance method to display the point
    public void print() {
        System.out.println("(" + x + ", " + y + ")"); // Print coordinates in (x, y) format
    }
}

// Explanation:
// - The class groups data (x, y) and behavior (move, print) together.
// - The fields are private, so only methods inside the class can access them directly (encapsulation).
// - The constructor sets up the initial state of the object.
// - Methods like move and print operate on the specific instance (object) of Point.
```

- **Benefits:**
  - The data (`x` and `y`) and the behavior (methods like `move` and `print`) are grouped together.
  - It's clear what a `Point` is and what you can do with it.
  - Less chance of mixing up values or making mistakes.

## Instance Methods

- **Instance methods** are defined in a class and operate on the data (fields) of a particular object (instance) of that class.
- Calling an instance method on a particular instance of the class will have effects **only on that instance**.

### Example: Using the Point class

```java
public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(2, 3);    // Create a new Point at (2, 3)
        Point p2 = new Point(5, 7);    // Create another Point at (5, 7)

        p1.move(1, 1);    // Move p1 by (1, 1) → now at (3, 4)
        p2.move(-2, 0);   // Move p2 by (-2, 0) → now at (3, 7)

        p1.print();       // Output: (3, 4)
        p2.print();       // Output: (3, 7)
    }
}

// Explanation:
// - We create two separate Point objects, p1 and p2.
// - Each object has its own x and y values.
// - Calling move on p1 only changes p1's coordinates, not p2's.
// - Each object keeps track of its own state.
// - This is the power of OOP: objects manage their own data and behavior.
```