# Constructors

Constructors are special methods in Java that are called when we first create a new instance (object) of a class. Their main job is to initialize the object's fields (variables) with values, either default or provided by the user.

## Why Do We Need Constructors?

When you create an object, you often want to set up its initial state. Constructors let you do this automatically, so every object starts out correctly set up.

```java
// Example: Creating a Point object
Point p = new Point();
```

## The Default Constructor

If you **don’t write any constructors** in your class, Java automatically provides a default constructor. This constructor takes no parameters and sets each field to its default value (e.g., 0 for numbers, false for booleans, null for objects).

```java
public class Point {
    int x; // default 0
    int y; // default 0
    // No constructor written, so Java provides:
    // public Point() { }
}

Point p = new Point(); // x and y are both 0
```

## Writing Your Own Constructor

You can write your own constructor to set the fields to specific values when the object is created.

**Constructor Syntax:**

```java
public class Point {
    int x;
    int y;

    // This is a constructor
    public Point(int initialX, int initialY) {
        x = initialX;
        y = initialY;
    }
}

Point p = new Point(3, 4); // x = 3, y = 4
```

## Important: If You Write Any Constructor

If you write **any** constructor (even one that takes parameters), Java will **not** provide a default constructor for you. If you still want a no-argument constructor, you must write it yourself.

```java
public class Point {
    int x;
    int y;

    // Parameterized constructor
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // No-argument constructor (must write it yourself)
    public Point() {
        x = 0;
        y = 0;
    }
}
```

## Common Mistake: Shadowing Field Names

If you use the same parameter names as your field names, you need to use `this` to refer to the fields of the object:

```java
public class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x; // 'this.x' is the field, 'x' is the parameter
        this.y = y;
    }
}
```

If you forget `this.`, you will just assign the parameter to itself, and the field will not be set!

## Constructor Overloading

You can have multiple constructors in a class, as long as they have different parameter lists. This is called **constructor overloading**.

```java
public class Point {
    int x;
    int y;

    // No-argument constructor
    public Point() {
        x = 0;
        y = 0;
    }

    // Constructor with two parameters
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

Point p1 = new Point();      // x = 0, y = 0
Point p2 = new Point(5, 10); // x = 5, y = 10
```

## Summary
- Constructors initialize new objects.
- If you write any constructor, Java does **not** provide a default one.
- Use `this` to distinguish between fields and parameters with the same name.
- You can overload constructors to provide different ways to create objects.
