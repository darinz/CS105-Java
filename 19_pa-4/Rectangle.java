// Rectangle.java
// Represents a rectangle shape

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

    // TODO: Implement getArea()
    @Override
    public double getArea() {
        // Formula: width * height
        return 0; // Replace with actual implementation
    }

    // TODO: Implement getPerimeter()
    @Override
    public double getPerimeter() {
        // Formula: 2 * (width + height)
        return 0; // Replace with actual implementation
    }

    // TODO: Implement getType()
    @Override
    public String getType() {
        return "Rectangle";
    }

    // TODO: Override toString() to display type, area, and perimeter
    @Override
    public String toString() {
        return "Rectangle (w=" + width + ", h=" + height + ")";
    }

    // TODO: Implement compareTo for sorting by area
    @Override
    public int compareTo(Shape other) {
        return Double.compare(this.getArea(), other.getArea());
    }
} 