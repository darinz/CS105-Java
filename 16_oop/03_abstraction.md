# Abstraction

Abstraction is a fundamental concept in object-oriented programming (OOP) that allows us to focus on what an object does instead of how it does it. In other words, abstraction is the separation of ideas from details, meaning that we can use something without knowing exactly how it works internally.

## Real-World Analogy

Think about driving a car. You use the steering wheel, pedals, and gear shift to control the car, but you don't need to know how the engine, transmission, or electronics work. The car's interface (steering wheel, pedals) abstracts away the complex details.

## Abstraction in Java

In Java, abstraction is achieved using **abstract classes** and **interfaces**. These allow you to define methods that must be implemented by subclasses, without specifying how they should be implemented.

---

### Abstract Classes

An **abstract class** is a class that cannot be instantiated (you can't create objects directly from it). It can have both abstract methods (methods without a body) and concrete methods (methods with a body).

#### Example with Annotations:

```java
// This is an abstract class. It represents a general concept of an Animal.
abstract class Animal {
    // Abstract method: subclasses must provide their own implementation.
    public abstract void makeSound();
    
    // Concrete method: all animals can sleep, and this provides a default implementation.
    public void sleep() {
        System.out.println("Zzz...");
    }
}

// Dog is a specific type of Animal. It must implement makeSound().
class Dog extends Animal {
    @Override // This annotation means we are providing the required method from Animal.
    public void makeSound() {
        System.out.println("Woof!"); // Dog's version of making a sound.
    }
}

// Cat is another specific type of Animal.
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!"); // Cat's version of making a sound.
    }
}

// Main class to test our abstraction.
public class Main {
    public static void main(String[] args) {
        // We use the abstract type Animal to refer to Dog and Cat objects.
        Animal myDog = new Dog();
        Animal myCat = new Cat();
        myDog.makeSound(); // Output: Woof!
        myCat.makeSound(); // Output: Meow!
        myDog.sleep();     // Output: Zzz... (inherited from Animal)
    }
}
```

**Explanation:**
- `Animal` is abstract: you can't create `new Animal()`, but you can create `Dog` or `Cat`.
- `makeSound()` is abstract: every subclass must say how it makes a sound.
- `sleep()` is concrete: all animals sleep the same way, so it's shared.
- This lets us write code that works with any kind of `Animal`!

---

### Interfaces

An **interface** is like a contract: it says what methods a class must have, but not how they work. Classes "sign the contract" by using `implements` and providing the method bodies.

#### Example with Annotations:

```java
// This interface says that anything Drawable must have a draw() method.
interface Drawable {
    void draw(); // No body here! Classes must provide it.
}

// Circle "signs the contract" and must implement draw().
class Circle implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

// Square also implements Drawable.
class Square implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing a square");
    }
}

// Main class to test our interface.
public class Main {
    public static void main(String[] args) {
        Drawable d1 = new Circle(); // We can use the interface type!
        Drawable d2 = new Square();
        d1.draw(); // Output: Drawing a circle
        d2.draw(); // Output: Drawing a square
    }
}
```

**Explanation:**
- `Drawable` is an interface: it only says what must be done, not how.
- `Circle` and `Square` both implement `Drawable` and provide their own `draw()` method.
- We can use the `Drawable` type to refer to any object that implements it, making our code flexible and reusable.

---

## Why Use Abstraction?
- **Simplifies code:** Users of a class only need to know what it does, not how it does it.
- **Improves maintainability:** Implementation details can change without affecting code that uses the abstraction.
- **Enables polymorphism:** You can write code that works with abstract types (like `Animal` or `Drawable`) and it will work with any subclass or implementation.

---

## Client vs. Implementor

- **Client:** The user of an abstraction. For example, when you use the `Scanner` class, you are a client—you use its methods without knowing how they work internally.
- **Implementor:** The creator of the abstraction. When you write your own classes that implement an interface or extend an abstract class, you are the implementor—you provide the details of how the methods work.

**Example:**
- You have been the client of many objects (like `Scanner`, `ArrayList`, etc.).
- Now, you will become the implementor by creating your own classes and defining how their methods work!

---

**Summary:**
- Abstraction lets you use things without knowing the details.
- In Java, use abstract classes and interfaces to create abstractions.
- This makes your code easier to use, maintain, and extend!

