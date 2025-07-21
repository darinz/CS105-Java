# Encapsulation

## Abstraction

Abstraction is the separation of ideas from details, meaning that we can use something without knowing exactly how it works. 

For example, you were able to use the `Scanner` class to read input without understanding how it works internally! This allows you to focus on what you want to do, not how it is done.

---

## Client vs. Implementor

- **Client:** Someone who uses a class or object.
- **Implementor:** Someone who writes the class or object.

We have been the clients of many objects! Now we will become the implementors of our own objects!

---

## Encapsulation

Objects encapsulate state (data) and expose behavior (methods). 

**Encapsulation** is the practice of hiding the internal details (fields, implementation) of an object from its clients. This means that users of the object interact with it only through its public methods, not by directly accessing its fields.

- Encapsulation provides **abstraction**: users don't need to know how something works to use it.
- Encapsulation gives the implementor flexibility: you can change the internal details without affecting users.

### Why is Encapsulation Important?
- Prevents external code from putting the object into an invalid state.
- Makes code easier to maintain and change.
- Allows you to control how important data is accessed or modified.

---

## The `private` Keyword

The `private` keyword is an **access modifier** (like `public`).

- Fields declared `private` cannot be accessed by any code outside of the class.
- We always want to encapsulate our objects’ fields by declaring them `private`.

**Example:**
```java
public class Point {
    // These fields are private: only accessible inside the Point class
    private int x; // x coordinate of the point
    private int y; // y coordinate of the point
}
```
**Explanation:**
- `private int x;` and `private int y;` mean that only code inside the `Point` class can access or change these variables. Code outside the class cannot directly see or modify them. This protects the data from accidental or unwanted changes.

If you try to access `x` or `y` from outside the class, you will get a compiler error!

---

## Accessors and Mutators

Declaring fields as `private` removes all access from the user. If we want to give some access back, we can define **instance methods**:
- **Accessors** ("getters"): methods that return the value of a field
- **Mutators** ("setters"): methods that change the value of a field

### Example: Accessors and Mutators
```java
public class Point {
    private int x; // x coordinate (hidden from outside)
    private int y; // y coordinate (hidden from outside)

    // Accessor (getter) for x
    public int getX() {
        // Returns the value of x
        return x;
    }

    // Mutator (setter) for x
    public void setX(int newX) {
        // Sets the value of x to newX
        x = newX;
    }

    // Accessor (getter) for y
    public int getY() {
        // Returns the value of y
        return y;
    }

    // Mutator (setter) for y
    public void setY(int newY) {
        // Sets the value of y to newY
        y = newY;
    }

    // Mutator to set both x and y at once
    public void setLocation(int newX, int newY) {
        // Sets both x and y to new values
        x = newX;
        y = newY;
    }
}
```
**Explanation:**
- `getX()` and `getY()` allow code outside the class to read the values of `x` and `y`.
- `setX(int newX)` and `setY(int newY)` allow code outside the class to change the values of `x` and `y`.
- The actual fields `x` and `y` are still private, so you control exactly how they are accessed or changed.

---

## Why Use Accessors and Mutators?

While users can still access and modify our Point’s fields with the instance methods we defined, **we have control of how they do so**. For example:

- We can add validation to only accept positive coordinate values:

```java
public void setX(int newX) {
    // Only allow non-negative values for x
    if (newX >= 0) {
        x = newX;
    } else {
        System.out.println("x must be non-negative");
    }
}
```
**Explanation:**
- This setter checks if the new value is valid before changing `x`. If not, it prints a warning and does not change the value. This keeps the object in a valid state.

- We can change our internal implementation (e.g., use polar coordinates instead of x/y) without changing the public interface. This means code using our class does not need to change, even if we change how we store the data inside.

---

## Summary
- Encapsulation is about hiding details and exposing only what is necessary.
- Use `private` fields and provide public accessors/mutators to control access.
- This makes your code safer, more flexible, and easier to maintain.
- Adding comments and explanations to your code helps others (and your future self) understand how and why it works!

