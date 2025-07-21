// Solution_Triangle.java
// Represents a triangle shape (solution)

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

    @Override
    public double getArea() {
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public String getType() {
        return "Triangle";
    }

    @Override
    public String toString() {
        return String.format("Triangle (a=%.2f, b=%.2f, c=%.2f): area=%.2f, perimeter=%.2f", a, b, c, getArea(), getPerimeter());
    }

    @Override
    public int compareTo(Shape other) {
        return Double.compare(this.getArea(), other.getArea());
    }
} 