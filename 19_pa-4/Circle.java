// Circle.java
// Represents a circle shape

/**
 * Circle class implements the Shape interface.
 * Represents a circle with a given radius.
 */
public class Circle implements Shape, Comparable<Shape> {
    private double radius; // Radius of the circle

    /**
     * Constructor to initialize the radius.
     * @param radius the radius of the circle
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    // TODO: Implement getArea()
    @Override
    public double getArea() {
        // Formula: π * r^2
        return 0; // Replace with actual implementation
    }

    // TODO: Implement getPerimeter()
    @Override
    public double getPerimeter() {
        // Formula: 2 * π * r
        return 0; // Replace with actual implementation
    }

    // TODO: Implement getType()
    @Override
    public String getType() {
        return "Circle";
    }

    // TODO: Override toString() to display type, area, and perimeter
    @Override
    public String toString() {
        return "Circle (r=" + radius + ")";
    }

    // TODO: Implement compareTo for sorting by area
    @Override
    public int compareTo(Shape other) {
        return Double.compare(this.getArea(), other.getArea());
    }
} 