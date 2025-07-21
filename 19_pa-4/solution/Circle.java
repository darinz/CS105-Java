// Solution_Circle.java
// Represents a circle shape (solution)

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

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String getType() {
        return "Circle";
    }

    @Override
    public String toString() {
        return String.format("Circle (r=%.2f): area=%.2f, perimeter=%.2f", radius, getArea(), getPerimeter());
    }

    @Override
    public int compareTo(Shape other) {
        return Double.compare(this.getArea(), other.getArea());
    }
} 