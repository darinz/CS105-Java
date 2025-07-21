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
Below is a simple interface for a `Container`. Notice that the interface only declares the methods, not how they work.
```java
// This is a simple interface for a Container
public interface Container {
    void fill();   // Method to fill the container (no implementation here)
    void empty();  // Method to empty the container (no implementation here)
}
```
*Explanation:* The `Container` interface says that any class which implements it must have `fill()` and `empty()` methods. It does not say how these methods should work—just that they must exist.

---

## Implementation
An **implementation** is the concrete code that fulfills the interface's contract. A class that implements an interface must provide code for all its methods.

**Analogy:**
- If the interface is a job description, the implementation is the employee actually doing the work.

**Java Example:**
Here, `WaterBottle` is a class that implements the `Container` interface. It provides specific code for the `fill()` and `empty()` methods.
```java
// Implementation of Container: WaterBottle
public class WaterBottle implements Container {
    public void fill() {
        // This is the actual code that fills the water bottle
        System.out.println("Filling the water bottle.");
    }
    public void empty() {
        // This is the actual code that empties the water bottle
        System.out.println("Emptying the water bottle.");
    }
}
```
*Explanation:* The `WaterBottle` class is now guaranteed to have both `fill()` and `empty()` methods, because it implements the `Container` interface. The code inside these methods can be anything that makes sense for a water bottle.

---

## Interfaces as Contracts
Interfaces serve as a sort of “contract”—in order for a class to implement an interface, it must fulfill the contract requirements (i.e., implement all the methods).

**Java Example:**
Here, both `Dog` and `Cat` classes implement the `Animal` interface, so they must each have a `makeSound()` method.
```java
public interface Animal {
    void makeSound(); // Any animal must be able to make a sound
}

public class Dog implements Animal {
    public void makeSound() {
        // Dog's version of making a sound
        System.out.println("Woof!");
    }
}

public class Cat implements Animal {
    public void makeSound() {
        // Cat's version of making a sound
        System.out.println("Meow!");
    }
}
```
*Explanation:* The `Animal` interface defines a contract: all animals must be able to make a sound. Each class (Dog, Cat) provides its own version of that sound.

---

## Lists in Java
One ADT we’ve talked a lot about in this course is a list.

Within Java, there exists a `List` interface—its contract includes methods like:
- `add`, `clear`, `contains`, `get`, `isEmpty`, `size`

There’s also an `ArrayList` class (implementation):
- To get the certificate, it must include all these methods (and any others the List interface specifies)

**Java Example:**
This example shows how you can use the `List` interface and the `ArrayList` implementation together.
```java
import java.util.List;      // Import the List interface
import java.util.ArrayList; // Import the ArrayList class

List<String> names = new ArrayList<>(); // List interface, ArrayList implementation
names.add("Alice");   // Add an element to the list
names.add("Bob");     // Add another element
System.out.println(names.get(0)); // Output: Alice (get the first element)
```
*Explanation:* You can declare your variable as a `List` (the interface), but use an `ArrayList` (the implementation) to actually store the data. This makes your code flexible!

---

## Interfaces vs. Implementation
Interfaces require certain methods, but they do not say anything about *how* those methods should be implemented—that’s up to the class!

- `List` is an interface
- `ArrayList` is a class that implements the List interface
- `LinkedList` is a class that implements the List interface

**Java Example:**
This example shows how you can use a different implementation (`LinkedList`) with the same interface (`List`).
```java
import java.util.List;
import java.util.LinkedList;

List<String> queue = new LinkedList<>(); // List interface, LinkedList implementation
queue.add("First");   // Add an element
queue.add("Second");  // Add another element
System.out.println(queue.get(1)); // Output: Second (get the second element)
```
*Explanation:* The code works the same way, even though the underlying implementation is different. This is the power of interfaces!

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
Here’s how you can use the interface to write more flexible code:
```java
public static void fill(Container c) {
    c.fill(); // Calls the fill method of any Container
}

WaterBottle bottle = new WaterBottle(); // Create a WaterBottle
Mug mug = new Mug();                   // Create a Mug (assume Mug implements Container)
fill(bottle); // Works
fill(mug);    // Also works
```
*Explanation:* The `fill` method can now work with any object that implements the `Container` interface, not just WaterBottles. This makes your code more reusable and flexible.

---

## Flexibility with Collections
You can also use interfaces to write methods that work with many different types of collections.
```java
public static void method(Set<String> s) { /* ... */ }
```
This method can accept either a:
- HashSet<String>
- TreeSet<String>
- Or any other class that implements Set and whose element type is String!

**Java Example:**
This example shows a method that prints all elements of any Set of Strings:
```java
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public static void printSet(Set<String> s) {
    for (String item : s) {
        System.out.println(item); // Print each item in the set
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
*Explanation:* The `printSet` method works with any kind of Set, because it uses the Set interface. This is another example of flexibility!

---

## Abstraction
Interfaces also support **abstraction**—the separation of ideas from details. You can write code that works with the *idea* of a thing, not its specific details.

**Java Example:**
This method works for any class that implements `Container`, regardless of how `fill()` and `empty()` are implemented.
```java
public void processContainer(Container c) {
    c.fill();        // Fill the container (could be a WaterBottle, Mug, etc.)
    // ... do more work ...
    c.empty();       // Empty the container
}
```
*Explanation:* The `processContainer` method doesn't care what kind of container it is working with. As long as the object implements the `Container` interface, it will work!

