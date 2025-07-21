// Solution_Rectangle.java
// Represents a rectangle shape (solution)

/**
 * Rectangle class implements the Shape interface.
 * Represents a rectangle with width and height.
 */
public class Rectangle implements Shape, Comparable<Shape> {
    private double width;  // Width of the rectangle
    private double height; // Height of the rectangle

    /**
     * Constructor to initialize width and height.
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     */
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String getType() {
        return "Rectangle";
    }

    @Override
    public String toString() {
        return String.format("Rectangle (w=%.2f, h=%.2f): area=%.2f, perimeter=%.2f", width, height, getArea(), getPerimeter());
    }

    @Override
    public int compareTo(Shape other) {
        return Double.compare(this.getArea(), other.getArea());
    }
} 