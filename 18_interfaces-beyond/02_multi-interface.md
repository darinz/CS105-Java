# Multiple Interfaces

## Classes Can Implement Multiple Interfaces

In Java, a class can implement more than one interface. This is like one person signing multiple contracts—they must fulfill all the promises in each contract!

**Why is this useful?**  
It allows a class to inherit behavior from multiple sources, even though Java does not support multiple inheritance with classes.

### Example: Implementing Multiple Interfaces

Suppose we have two interfaces:

```java
// Interface for shapes that have a perimeter and area
public interface Shape {
    double getPerimeter(); // Method to calculate the perimeter of the shape
    double getArea();      // Method to calculate the area of the shape
}

// Interface for shapes with parallel sides
public interface Parallel {
    int numParallelPairs(); // Method to return the number of pairs of parallel sides
}
```
*Explanation:*  
- `Shape` is an interface that says any class implementing it must provide methods to get the perimeter and area.
- `Parallel` is an interface for shapes that have parallel sides, requiring a method to count those pairs.

Now, a class can implement both:

```java
// Square implements both Shape and Parallel
public class Square implements Shape, Parallel {
    private double side; // Field to store the length of a side

    // Constructor to set the side length when creating a Square
    public Square(double side) {
        this.side = side;
    }

    // Implement methods from Shape
    public double getPerimeter() {
        return 4 * side; // Perimeter of a square = 4 * side
    }
    public double getArea() {
        return side * side; // Area of a square = side^2
    }

    // Implement method from Parallel
    public int numParallelPairs() {
        return 2; // A square has 2 pairs of parallel sides
    }
}
```
*Explanation:*  
- The `Square` class must provide all methods from both `Shape` and `Parallel`.
- The constructor sets the side length.
- `getPerimeter()` and `getArea()` are required by `Shape`.
- `numParallelPairs()` is required by `Parallel`.
- This is how Java allows a class to “inherit” from multiple sources.

---

## Interface Inheritance: Extending Interfaces

Just like classes, interfaces can extend other interfaces.  
If interface `A` extends interface `B`, then any class that implements `A` must also implement all methods from `B`.

### Example: Interface Inheritance

```java
// Shape interface as before
public interface Shape {
    double getPerimeter(); // Calculate perimeter
    double getArea();      // Calculate area
}

// Polygon interface extends Shape
public interface Polygon extends Shape {
    int getNumSides(); // Method to return the number of sides
}
```
*Explanation:*  
- `Polygon` extends `Shape`, so any class that implements `Polygon` must also implement all methods from `Shape`.
- This allows us to build more specific contracts on top of general ones.

Now, any class that implements `Polygon` must implement all methods from both `Polygon` and `Shape`:

```java
public class Triangle implements Polygon {
    private double sideA, sideB, sideC; // Fields for the three sides

    // Constructor to set the side lengths
    public Triangle(double a, double b, double c) {
        sideA = a; sideB = b; sideC = c;
    }

    // Implement getPerimeter from Shape
    public double getPerimeter() {
        return sideA + sideB + sideC; // Perimeter = sum of sides
    }

    // Implement getArea from Shape using Heron's formula
    public double getArea() {
        double s = getPerimeter() / 2; // Semi-perimeter
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    // Implement getNumSides from Polygon
    public int getNumSides() {
        return 3; // Triangle has 3 sides
    }
}
```
*Explanation:*  
- The `Triangle` class must implement all methods from both `Polygon` and `Shape`.
- `getPerimeter()` adds up the three sides.
- `getArea()` uses Heron's formula (a standard way to compute the area of a triangle given its sides).
- `getNumSides()` returns 3, because a triangle has three sides.

---

## Real-World Analogy

- **Multiple Interfaces:** Like a smartphone that is both a camera and a phone—it must fulfill the requirements of both contracts.
- **Interface Inheritance:** Like a “Smart Camera” contract that includes all the requirements of a “Camera” contract, plus more.

---

## Practice: Classifying Shapes

Suppose we want to model the following:

- `Square` is a `Polygon` (and a `Shape`)
- `Triangle` is a `Polygon` (and a `Shape`)
- `Circle` is a `Shape` (but **not** a `Polygon`)

### Example Code

```java
// Shape interface
public interface Shape {
    double getPerimeter(); // Calculate perimeter
    double getArea();      // Calculate area
}

// Polygon interface extends Shape
public interface Polygon extends Shape {
    int getNumSides(); // Number of sides
}

// Square implements Polygon (and thus Shape)
public class Square implements Polygon {
    private double side;
    public Square(double side) { this.side = side; }
    public double getPerimeter() { return 4 * side; }
    public double getArea() { return side * side; }
    public int getNumSides() { return 4; }
}

// Triangle implements Polygon (and thus Shape)
public class Triangle implements Polygon {
    private double a, b, c;
    public Triangle(double a, double b, double c) { this.a = a; this.b = b; this.c = c; }
    public double getPerimeter() { return a + b + c; }
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    public int getNumSides() { return 3; }
}

// Circle implements Shape only
public class Circle implements Shape {
    private double radius;
    public Circle(double radius) { this.radius = radius; }
    public double getPerimeter() { return 2 * Math.PI * radius; }
    public double getArea() { return Math.PI * radius * radius; }
}
```
*Explanation:*  
- `Square` and `Triangle` are both `Polygon`s, so they must implement all methods from both `Polygon` and `Shape`.
- `Circle` is only a `Shape`, so it does not need to implement `getNumSides()`.
- Each class provides its own logic for calculating perimeter and area, based on its shape.

---

## Summary Table

| Class    | Implements      | Must Provide Methods For         |
|----------|----------------|----------------------------------|
| Square   | Polygon, Shape | getPerimeter, getArea, getNumSides |
| Triangle | Polygon, Shape | getPerimeter, getArea, getNumSides |
| Circle   | Shape          | getPerimeter, getArea              |

---

## Key Takeaways

- **A class can implement multiple interfaces**—it must provide all required methods.
- **Interfaces can extend other interfaces**—the child interface inherits all methods from the parent.
- **Use interfaces to model “can do” relationships** (e.g., “can be drawn”, “can be compared”).
- **Use interface inheritance to build more specific contracts**.

