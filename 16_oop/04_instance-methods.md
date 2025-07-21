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

```java
public class Point {
    int x;
    int y;

    // Instance method: calculates distance from this point's x to another x
    public int distanceFromX(int otherX) {
        return Math.abs(x - otherX); // accesses the instance variable 'x'
    }
}

// Usage:
Point p = new Point();
p.x = 5;
int d = p.distanceFromX(10); // Calls the instance method on object 'p'
System.out.println(d); // Output: 5
```

---

## What is a Static Method?

A **static method** belongs to the class itself, not to any specific object. You can call a static method without creating an object of the class. Static methods **cannot** access instance variables or instance methods directly—they can only access other static members.

**Key Points:**
- Declared with the `static` keyword.
- Called on the class, not on an object.
- Cannot access instance variables or instance methods directly.

### Example: Static Method

```java
public class Point {
    int x;
    int y;

    // Static method: calculates the difference between two numbers
    public static int diff(int xx, int yy) {
        return xx - yy;
    }
}

// Usage:
int result = Point.diff(10, 3); // Calls the static method on the class
System.out.println(result); // Output: 7
```

---

## The `toString()` Method

Every class in Java inherits a method called `toString()` from the `Object` class. The `toString()` method returns a string representation of the object. By default, it returns a string that includes the class name and a hash code, but you can **override** it to provide more meaningful information.

**Why override `toString()`?**
- Makes debugging easier by providing readable output when printing objects.
- Used automatically when you concatenate an object with a string or print it.

### Example: Overriding `toString()`

```java
public class Point {
    int x;
    int y;

    // Override toString to provide a custom string representation
    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }
}

// Usage:
Point p = new Point();
p.x = 3;
p.y = 4;
System.out.println(p); // Output: Point(3, 4)
```

**Note:** The `toString()` method is automatically called whenever an object is treated like a string, such as in `System.out.println(p);` or string concatenation.

---

## Why Not Just Write a `print()` Method?

While you *could* write a `print()` method that prints the object's details, overriding `toString()` is the standard Java way. It integrates with Java's printing and string handling, making your classes easier to use and debug.

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
