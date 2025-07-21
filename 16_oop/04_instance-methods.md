# Instance Methods in Java

In Java, **methods** are blocks of code that perform a specific task. When you define a method inside a class, it can either be an **instance method** or a **static method**. Understanding the difference is crucial for writing effective Java programs.

---

## What is an Instance Method?

An **instance method** is a method that belongs to an object (an instance of a class). It can access and modify the fields (variables) of the object it belongs to. To call an instance method, you need to create an object of the class first.

**Key Points:**
- Instance methods can access instance variables (fields) and other instance methods directly.
- They are called on objects, not on the class itself.
- They do **not** use the `static` keyword.

### Example: Instance Method

Let's break down the code step by step:

```java
public class Point {
    int x; // Field: x-coordinate of the point
    int y; // Field: y-coordinate of the point

    // Instance method: calculates distance from this point's x to another x
    public int distanceFromX(int otherX) {
        // 'x' refers to the field of the current object
        // 'otherX' is a parameter passed to the method
        return Math.abs(x - otherX); // returns the absolute difference
    }
}

// Usage:
Point p = new Point(); // Create a new Point object
p.x = 5;               // Set the x field to 5
int d = p.distanceFromX(10); // Calls the instance method on object 'p'
System.out.println(d); // Output: 5
```

**Explanation:**
- `distanceFromX` is an instance method because it uses the field `x` of the object.
- You must create an object (`p`) to call this method.
- The method calculates the distance from the object's `x` value to another value.

---

## What is a Static Method?

A **static method** belongs to the class itself, not to any specific object. You can call a static method without creating an object of the class. Static methods **cannot** access instance variables or instance methods directly—they can only access other static members.

**Key Points:**
- Declared with the `static` keyword.
- Called on the class, not on an object.
- Cannot access instance variables or instance methods directly.

### Example: Static Method

Let's annotate the code for clarity:

```java
public class Point {
    int x; // Field: x-coordinate
    int y; // Field: y-coordinate

    // Static method: calculates the difference between two numbers
    public static int diff(int xx, int yy) {
        // 'xx' and 'yy' are parameters; no use of 'x' or 'y' fields
        return xx - yy;
    }
}

// Usage:
int result = Point.diff(10, 3); // Calls the static method on the class, not an object
System.out.println(result); // Output: 7
```

**Explanation:**
- `diff` is a static method because it does not use any instance fields.
- You call it using the class name (`Point.diff(...)`), not an object.
- Static methods are often used for utility or helper functions.

---

## The `toString()` Method

Every class in Java inherits a method called `toString()` from the `Object` class. The `toString()` method returns a string representation of the object. By default, it returns a string that includes the class name and a hash code, but you can **override** it to provide more meaningful information.

**Why override `toString()`?**
- Makes debugging easier by providing readable output when printing objects.
- Used automatically when you concatenate an object with a string or print it.

### Example: Overriding `toString()`

Let's see how to override and use `toString()`:

```java
public class Point {
    int x; // Field: x-coordinate
    int y; // Field: y-coordinate

    // Override toString to provide a custom string representation
    @Override
    public String toString() {
        // Returns a string like "Point(3, 4)"
        return "Point(" + x + ", " + y + ")";
    }
}

// Usage:
Point p = new Point(); // Create a new Point object
p.x = 3;
p.y = 4;
System.out.println(p); // Output: Point(3, 4)
// The toString() method is called automatically by System.out.println
```

**Explanation:**
- The `@Override` annotation tells Java you are replacing the inherited `toString()` method.
- The method returns a string that describes the object in a human-readable way.
- When you print the object, Java uses your `toString()` method automatically.

**Note:** The `toString()` method is automatically called whenever an object is treated like a string, such as in `System.out.println(p);` or string concatenation.

---

## Why Not Just Write a `print()` Method?

While you *could* write a `print()` method that prints the object's details, overriding `toString()` is the standard Java way. It integrates with Java's printing and string handling, making your classes easier to use and debug.

**Example:**
```java
public void print() {
    System.out.println(this.toString()); // Calls the toString method
}
```
But using `toString()` is more flexible, as it works with all Java printing and string operations.

---

## Summary Table

| Feature         | Instance Method         | Static Method           |
|-----------------|------------------------|------------------------|
| Belongs to      | Object (instance)      | Class                  |
| Accesses fields | Yes                    | No (unless static)     |
| Uses 'static'?  | No                     | Yes                    |
| Call syntax     | `object.method()`      | `Class.method()`       |

---

**Tip:** Use instance methods when you need to work with object data. Use static methods for utility or helper functions that don't depend on object state. 
