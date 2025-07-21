// Solution_Main.java
// Driver program for Shape Drawing and Sorting assignment (solution)

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();

        // Add at least two of each shape
        shapes.add(new Circle(2.0));
        shapes.add(new Circle(3.5));
        shapes.add(new Rectangle(3.0, 4.0));
        shapes.add(new Rectangle(5.0, 2.0));
        shapes.add(new Triangle(3.0, 4.0, 5.0));
        shapes.add(new Triangle(6.0, 8.0, 10.0));

        // Print all shapes before sorting
        System.out.println("Shapes before sorting:");
        for (Shape s : shapes) {
            System.out.println(s);
        }

        // Sort shapes by area (ascending)
        Collections.sort(shapes);

        // Print all shapes after sorting
        System.out.println("\nShapes after sorting by area:");
        for (Shape s : shapes) {
            System.out.println(s);
        }
    }
} 