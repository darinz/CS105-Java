# Interfaces

## Abstract Data Type (ADT)
An **Abstract Data Type (ADT)** is a description of the *idea* of a data structure: what operations are available and how those operations should behave, without specifying how they are implemented. Think of it as a *blueprint* or a *recipe* for a data structure.

**Analogy:**
- Imagine a remote control. The ADT describes what buttons (operations) it should have (e.g., power, volume up/down), but not how the remote is built inside.

**Example (List ADT):**
- Operations: add, remove, get, size, isEmpty, etc.
- Behavior: add should insert an item, get should retrieve an item at a position, etc.

---

## Interface
A **Java interface** is a construct that lets programmers specify *what methods a class should have*—it defines the contract, but not the implementation.

**Analogy:**
- An interface is like a job description: it lists the tasks (methods) an employee (class) must perform, but not how they do them.

**Java Example:**
```java
// This is a simple interface for a Container
public interface Container {
    void fill(); // Method to fill the container
    void empty(); // Method to empty the container
}
```

---

## Implementation
An **implementation** is the concrete code that fulfills the interface's contract. A class that implements an interface must provide code for all its methods.

**Analogy:**
- If the interface is a job description, the implementation is the employee actually doing the work.

**Java Example:**
```java
// Implementation of Container: WaterBottle
public class WaterBottle implements Container {
    public void fill() {
        System.out.println("Filling the water bottle.");
    }
    public void empty() {
        System.out.println("Emptying the water bottle.");
    }
}
```

---

## Interfaces as Contracts
Interfaces serve as a sort of “contract”—in order for a class to implement an interface, it must fulfill the contract requirements (i.e., implement all the methods).

**Java Example:**
```java
public interface Animal {
    void makeSound();
}

public class Dog implements Animal {
    public void makeSound() {
        System.out.println("Woof!");
    }
}

public class Cat implements Animal {
    public void makeSound() {
        System.out.println("Meow!");
    }
}
```

---

## Lists in Java
One ADT we’ve talked a lot about in this course is a list.

Within Java, there exists a `List` interface—its contract includes methods like:
- `add`, `clear`, `contains`, `get`, `isEmpty`, `size`

There’s also an `ArrayList` class (implementation):
- To get the certificate, it must include all these methods (and any others the List interface specifies)

**Java Example:**
```java
import java.util.List;
import java.util.ArrayList;

List<String> names = new ArrayList<>(); // List interface, ArrayList implementation
names.add("Alice");
names.add("Bob");
System.out.println(names.get(0)); // Output: Alice
```

---

## Interfaces vs. Implementation
Interfaces require certain methods, but they do not say anything about *how* those methods should be implemented—that’s up to the class!

- `List` is an interface
- `ArrayList` is a class that implements the List interface
- `LinkedList` is a class that implements the List interface

**Java Example:**
```java
import java.util.List;
import java.util.LinkedList;

List<String> queue = new LinkedList<>(); // List interface, LinkedList implementation
queue.add("First");
queue.add("Second");
System.out.println(queue.get(1)); // Output: Second
```

---

## Why interfaces? Flexibility!

Suppose you have:
```java
public static void fill(WaterBottle w) { /* ... */ }
```
This method only accepts a WaterBottle!

But with interfaces:
```java
public static void fill(Container c) { /* ... */ }
```
This method can accept either a:
- WaterBottle
- Mug
- Tub
- Or any other class that implements Container!

**Java Example:**
```java
public static void fill(Container c) {
    c.fill(); // Calls the fill method of any Container
}

WaterBottle bottle = new WaterBottle();
Mug mug = new Mug();
fill(bottle); // Works
fill(mug);    // Also works
```

---

## Flexibility with Collections
```java
public static void method(Set<String> s) { /* ... */ }
```
This method can accept either a:
- HashSet<String>
- TreeSet<String>
- Or any other class that implements Set and whose element type is String!

**Java Example:**
```java
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public static void printSet(Set<String> s) {
    for (String item : s) {
        System.out.println(item);
    }
}

Set<String> hashSet = new HashSet<>();
hashSet.add("apple");
hashSet.add("banana");

Set<String> treeSet = new TreeSet<>();
treeSet.add("carrot");
treeSet.add("beet");

printSet(hashSet); // Works
printSet(treeSet); // Also works
```

---

## Abstraction
Interfaces also support **abstraction**—the separation of ideas from details. You can write code that works with the *idea* of a thing, not its specific details.

**Java Example:**
```java
public void processContainer(Container c) {
    c.fill();
    // ... do more work ...
    c.empty();
}
```
This code works for any class that implements Container, regardless of how fill() and empty() are implemented!

