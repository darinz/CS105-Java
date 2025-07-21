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
    private int x;
    private int y;
}
```

If you try to access `x` or `y` from outside the class, you will get a compiler error!

---

## Accessors and Mutators

Declaring fields as `private` removes all access from the user. If we want to give some access back, we can define **instance methods**:
- **Accessors** ("getters"): methods that return the value of a field
- **Mutators** ("setters"): methods that change the value of a field

### Example: Accessors and Mutators
```java
public class Point {
    private int x;
    private int y;

    // Accessor (getter) for x
    public int getX() {
        return x;
    }

    // Mutator (setter) for x
    public void setX(int newX) {
        x = newX;
    }

    // Accessor (getter) for y
    public int getY() {
        return y;
    }

    // Mutator (setter) for y
    public void setY(int newY) {
        y = newY;
    }

    // Mutator to set both x and y
    public void setLocation(int newX, int newY) {
        x = newX;
        y = newY;
    }
}
```

---

## Why Use Accessors and Mutators?

While users can still access and modify our Point’s fields with the instance methods we defined, **we have control of how they do so**. For example:

- We can add validation to only accept positive coordinate values:

```java
public void setX(int newX) {
    if (newX >= 0) {
        x = newX;
    } else {
        System.out.println("x must be non-negative");
    }
}
```

- We can change our internal implementation (e.g., use polar coordinates instead of x/y) without changing the public interface.

---

## Summary
- Encapsulation is about hiding details and exposing only what is necessary.
- Use `private` fields and provide public accessors/mutators to control access.
- This makes your code safer, more flexible, and easier to maintain.

