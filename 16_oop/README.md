# Object-Oriented Programming (OOP) in Java

Welcome to the OOP module! This section introduces the core concepts of object-oriented programming in Java, with annotated examples and clear explanations for beginners.

---

## Table of Contents
1. [What is OOP?](#what-is-oop)
2. [Classes & Objects](#classes--objects)
3. [State & Behavior](#state--behavior)
4. [Instance Variables (Fields)](#instance-variables-fields)
5. [Instance Methods vs. Static Methods](#instance-methods-vs-static-methods)
6. [Abstraction](#abstraction)
7. [Encapsulation](#encapsulation)
8. [Constructors](#constructors)
9. [The `this` Keyword](#the-this-keyword)
10. [Overriding `equals()` and `hashCode()`](#overriding-equals-and-hashcode)

---

## What is OOP?
- **Procedural programming** organizes code as a sequence of steps (functions), separating data and behavior.
- **Object-oriented programming (OOP)** organizes code as a collection of objects that combine state (data) and behavior (methods).
- OOP is the foundation of modern Java programs.

---

## Classes & Objects
- **Class:** Blueprint or template for an object (e.g., `Dog` class).
- **Object:** An instance of a class (e.g., `myDog` is a `Dog`).

```java
public class Dog {
    // Blueprint for Dog objects
}
Dog myDog = new Dog(); // myDog is an object (instance) of Dog
```

---

## State & Behavior
- **State:** The data an object holds (fields/instance variables).
- **Behavior:** The actions an object can perform (methods).

```java
public class Dog {
    String name;
    int age;
    String breed;
    public void bark() {
        System.out.println(name + " says: Woof!");
    }
}
Dog fido = new Dog();
fido.name = "Fido";
fido.age = 3;
fido.breed = "Labrador";
fido.bark(); // Output: Fido says: Woof!
```

---

## Instance Variables (Fields)
- Fields are defined inside a class but outside any method.
- Each object has its own copy of the fields.

```java
public class Student {
    String name;
    int id;
}
Student alice = new Student();
alice.name = "Alice";
alice.id = 101;
Student bob = new Student();
bob.name = "Bob";
bob.id = 102;
```

---

## Instance Methods vs. Static Methods
- **Instance methods** operate on a specific object and can access its fields.
- **Static methods** belong to the class and cannot access instance fields directly.

```java
public class Point {
    int x, y;
    public int distanceFromX(int otherX) {
        return Math.abs(x - otherX);
    }
    public static int diff(int xx, int yy) {
        return xx - yy;
    }
}
Point p = new Point();
p.x = 5;
System.out.println(p.distanceFromX(10)); // 5
System.out.println(Point.diff(10, 3));   // 7
```

### Overriding `toString()`
- Provides a custom string representation for objects.

```java
@Override
public String toString() {
    return "Point(" + x + ", " + y + ")";
}
```

---

## Abstraction
- **Abstraction** lets you focus on what an object does, not how it does it.
- Achieved using **abstract classes** and **interfaces**.

### Abstract Class Example
```java
abstract class Animal {
    public abstract void makeSound();
    public void sleep() { System.out.println("Zzz..."); }
}
class Dog extends Animal {
    @Override public void makeSound() { System.out.println("Woof!"); }
}
```

### Interface Example
```java
interface Drawable { void draw(); }
class Circle implements Drawable {
    @Override public void draw() { System.out.println("Drawing a circle"); }
}
```

---

## Encapsulation
- **Encapsulation** hides internal details and exposes only what is necessary.
- Use `private` fields and provide public **accessors** (getters) and **mutators** (setters).

```java
public class Point {
    private int x, y;
    public int getX() { return x; }
    public void setX(int newX) { x = newX; }
}
```

- Encapsulation protects data and allows validation:
```java
public void setX(int newX) {
    if (newX >= 0) x = newX;
    else System.out.println("x must be non-negative");
}
```

---

## Constructors
- Special methods to initialize new objects.
- If you write any constructor, Java does **not** provide a default one.
- You can **overload** constructors (multiple with different parameters).

```java
public class Point {
    int x, y;
    public Point() { x = 0; y = 0; }
    public Point(int x, int y) { this.x = x; this.y = y; }
}
Point p1 = new Point();      // (0, 0)
Point p2 = new Point(5, 10); // (5, 10)
```

---

## The `this` Keyword
- Refers to the current object.
- Used to distinguish fields from parameters, enable constructor chaining, and support method chaining.

```java
public class Point {
    private int x, y;
    public Point(int x, int y) { this.x = x; this.y = y; }
}
```

- `this()` can call another constructor in the same class:
```java
public class Rectangle {
    private int width, height;
    public Rectangle() { this(1, 1); }
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
```

---

## Overriding `equals()` and `hashCode()`
- Use `equals()` to compare object values, not references.
- Always override `hashCode()` when you override `equals()`.

```java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Point other = (Point) obj;
    return this.x == other.x && this.y == other.y;
}
@Override
public int hashCode() {
    return Objects.hash(x, y);
}
```

---

## Summary Table
| Concept         | What it Means                                    |
|----------------|--------------------------------------------------|
| Class          | Blueprint for objects                            |
| Object         | Instance of a class                              |
| Field          | Variable storing object state                    |
| Method         | Function defining object behavior                |
| Constructor    | Initializes new objects                          |
| Encapsulation  | Hiding details, exposing only what's necessary   |
| Abstraction    | Focusing on what, not how                        |
| `this`         | Refers to the current object                     |
| `equals()`     | Compares object values                           |
| `hashCode()`   | Used in hash-based collections                   |

---

## Further Reading
- [Java Documentation: Object-Oriented Programming Concepts](https://docs.oracle.com/javase/tutorial/java/concepts/)
- [Effective Java by Joshua Bloch]

---

*This module is designed to help you understand and apply OOP principles in Java. Each lesson includes annotated code and explanations to make learning easy and practical!* 