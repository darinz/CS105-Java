# Abstraction

Abstraction is a fundamental concept in object-oriented programming (OOP) that allows us to focus on what an object does instead of how it does it. In other words, abstraction is the separation of ideas from details, meaning that we can use something without knowing exactly how it works internally.

## Real-World Analogy

Think about driving a car. You use the steering wheel, pedals, and gear shift to control the car, but you don't need to know how the engine, transmission, or electronics work. The car's interface (steering wheel, pedals) abstracts away the complex details.

## Abstraction in Java

In Java, abstraction is achieved using **abstract classes** and **interfaces**. These allow you to define methods that must be implemented by subclasses, without specifying how they should be implemented.

### Abstract Classes

An abstract class can have both abstract methods (without a body) and concrete methods (with a body). You cannot create an instance of an abstract class directly.

```java
// Abstract class example
abstract class Animal {
    // Abstract method (no body)
    public abstract void makeSound();
    
    // Concrete method
    public void sleep() {
        System.out.println("Zzz...");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        Animal myCat = new Cat();
        myDog.makeSound(); // Output: Woof!
        myCat.makeSound(); // Output: Meow!
        myDog.sleep();     // Output: Zzz...
    }
}
```

### Interfaces

An interface is a contract that specifies what methods a class must implement. All methods in an interface are abstract by default (until Java 8, which introduced default methods).

```java
// Interface example
interface Drawable {
    void draw(); // abstract method
}

class Circle implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Square implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing a square");
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        Drawable d1 = new Circle();
        Drawable d2 = new Square();
        d1.draw(); // Output: Drawing a circle
        d2.draw(); // Output: Drawing a square
    }
}
```

## Why Use Abstraction?
- **Simplifies code:** Users of a class only need to know what it does, not how it does it.
- **Improves maintainability:** Implementation details can change without affecting code that uses the abstraction.
- **Enables polymorphism:** You can write code that works with abstract types (like `Animal` or `Drawable`) and it will work with any subclass or implementation.

## Client vs. Implementor

- **Client:** The user of an abstraction. For example, when you use the `Scanner` class, you are a client—you use its methods without knowing how they work internally.
- **Implementor:** The creator of the abstraction. When you write your own classes that implement an interface or extend an abstract class, you are the implementor—you provide the details of how the methods work.

**Example:**
- You have been the client of many objects (like `Scanner`, `ArrayList`, etc.).
- Now, you will become the implementor by creating your own classes and defining how their methods work!

