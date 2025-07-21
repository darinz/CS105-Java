// Triangle.java
// Represents a triangle shape

/**
 * Triangle class implements the Shape interface.
 * Represents a triangle with three sides.
 */
public class Triangle implements Shape, Comparable<Shape> {
    private double a, b, c; // Side lengths of the triangle

    /**
     * Constructor to initialize the sides.
     * @param a length of side a
     * @param b length of side b
     * @param c length of side c
     */
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // TODO: Implement getArea() using Heron's formula
    @Override
    public double getArea() {
        // Heron's formula: sqrt(s*(s-a)*(s-b)*(s-c)), where s = (a+b+c)/2
        return 0; // Replace with actual implementation
    }

    // TODO: Implement getPerimeter()
    @Override
    public double getPerimeter() {
        // Formula: a + b + c
        return 0; // Replace with actual implementation
    }

    // TODO: Implement getType()
    @Override
    public String getType() {
        return "Triangle";
    }

    // TODO: Override toString() to display type, area, and perimeter
    @Override
    public String toString() {
        return "Triangle (a=" + a + ", b=" + b + ", c=" + c + ")";
    }

    // TODO: Implement compareTo for sorting by area
    @Override
    public int compareTo(Shape other) {
        return Double.compare(this.getArea(), other.getArea());
    }
} 