// Solution_Shape.java
// Interface for geometric shapes (solution)

/**
 * The Shape interface defines methods for calculating area, perimeter,
 * and getting the type of the shape.
 */
public interface Shape {
    /**
     * Calculates and returns the area of the shape.
     * @return area as a double
     */
    double getArea();

    /**
     * Calculates and returns the perimeter of the shape.
     * @return perimeter as a double
     */
    double getPerimeter();

    /**
     * Returns the type/name of the shape (e.g., "Circle").
     * @return type as a String
     */
    String getType();
} 