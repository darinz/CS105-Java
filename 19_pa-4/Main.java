// Main.java
// Driver program for Shape Drawing and Sorting assignment
// Assumes all files are in the default package (no import needed for Shape, Circle, Rectangle, Triangle)

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        // TODO: Create an ArrayList of Shape
        ArrayList<Shape> shapes = new ArrayList<>();

        // TODO: Add at least two of each shape (Circle, Rectangle, Triangle) with different dimensions
        // Example:
        // shapes.add(new Circle(2.0));
        // shapes.add(new Rectangle(3.0, 4.0));
        // shapes.add(new Triangle(3.0, 4.0, 5.0));

        // TODO: Print all shapes (use polymorphism and toString())
        System.out.println("Shapes before sorting:");
        for (Shape s : shapes) {
            System.out.println(s);
        }

        // TODO: Sort shapes by area (ascending)
        Collections.sort(shapes);

        // TODO: Print all shapes after sorting
        System.out.println("\nShapes after sorting by area:");
        for (Shape s : shapes) {
            System.out.println(s);
        }
    }
} 