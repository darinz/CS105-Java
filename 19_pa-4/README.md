# PA-4: Shape Drawing and Sorting

## Objectives
- Practice defining and implementing Java interfaces
- Apply polymorphism and interface-based design
- Use Comparable or Comparator for sorting objects
- Work with Java Collections (ArrayList)

## Background
In this assignment, you will design a simple shape system using interfaces. You will implement several shape classes, each with its own properties and methods, and demonstrate sorting and polymorphic behavior.

## Instructions

### 1. Define the `Shape` Interface
- The interface should declare:
  - `double getArea();` // Returns the area of the shape
  - `double getPerimeter();` // Returns the perimeter of the shape
  - `String getType();` // Returns the type of the shape (e.g., "Circle")

### 2. Implement Shape Classes
- Create the following classes that implement `Shape`:
  - `Circle` (with a `double radius`)
  - `Rectangle` (with `double width`, `double height`)
  - `Triangle` (with `double a, b, c` for side lengths)
- Each class should:
  - Implement all methods from `Shape`
  - Have a constructor to initialize its fields
  - Override `toString()` to display its type, area, and perimeter

### 3. Make Shapes Comparable
- Implement `Comparable<Shape>` in your shape classes (or use a separate `Comparator<Shape>`) to allow sorting by area (ascending).

### 4. Main Program
- In `Main.java`, do the following:
  - Create an `ArrayList<Shape>`
  - Add at least two of each shape (with different dimensions)
  - Print all shapes (using polymorphism)
  - Sort the shapes by area and print them again

### 5. (Optional) Bonus
- Allow sorting by perimeter using a Comparator
- Add user input to create shapes (not required for full credit)

## Starter Files
- `Shape.java` (interface)
- `Circle.java`, `Rectangle.java`, `Triangle.java` (skeletons)
- `Main.java` (driver)

## Submission
- Submit all `.java` files
- Ensure your code is well-commented and easy to read

## Example Output
```
Shapes before sorting:
Circle (r=2.0): area=12.57, perimeter=12.57
Rectangle (w=3.0, h=4.0): area=12.00, perimeter=14.00
Triangle (a=3.0, b=4.0, c=5.0): area=6.00, perimeter=12.00
...
Shapes after sorting by area:
Triangle (a=3.0, b=4.0, c=5.0): area=6.00, perimeter=12.00
Rectangle (w=3.0, h=4.0): area=12.00, perimeter=14.00
Circle (r=2.0): area=12.57, perimeter=12.57
...
```
