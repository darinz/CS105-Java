# Sets (ADT)

A collection of unique values (no duplicates allowed)
that can perform the following operations efficiently:
- add
- remove
- search (contains)

• We don’t think of a set as having indices; we just add
things to the set in general and don’t worry about
order

Example of a set:
"hi"
"hola"
"hello"
"bonjour"
"konnichiwa"

---

## Sets in Java

In Java, a **Set** is a collection that cannot contain duplicate elements. It models the mathematical set abstraction and is a part of the Java Collections Framework.

- **Set** is an *interface* in Java (in `java.util`).
- It defines the basic operations for a set, such as adding, removing, and checking for the presence of elements.
- The most commonly used implementations are **HashSet** and **TreeSet**.

### HashSet
- Implements the Set interface using a *hash table*.
- **Very fast** for add, remove, and contains operations (constant time on average).
- **Order is not guaranteed**; elements are stored in an unpredictable order.
- Allows `null` elements.

### TreeSet
- Implements the Set interface using a *red-black tree* (a type of binary search tree).
- **Elements are stored in sorted order** (according to their natural ordering or a custom Comparator).
- Operations are **logarithmic time** (slower than HashSet for large sets).
- Does **not allow null** elements (throws NullPointerException).

---

## Set Methods

| Method         | Description                                                                 |
|---------------|-----------------------------------------------------------------------------|
| add(value)    | Adds the given value to the set, returns true if the value was not present  |
| contains(value)| Returns true if the given value is found in this set                        |
| remove(value) | Removes the given value from the set; returns true if the set contained it  |
| clear()       | Removes all elements from the set                                           |
| size()        | Returns the number of elements in the set                                   |
| isEmpty()     | Returns true if the set’s size is 0; false otherwise                        |
| toString()    | Returns a String representation of the set such as "[3, 42, -7, 15]"        |

---

## Java Code Examples

### Creating and Using a HashSet

// What’s happening here?
// This example shows how to create a HashSet of Strings, add elements, check for duplicates, remove elements, and print the set.

```java
import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        // Create a new HashSet of Strings
        Set<String> greetings = new HashSet<>();
        
        // Add elements to the set
        greetings.add("hi");
        greetings.add("hola");
        greetings.add("hello");
        greetings.add("bonjour");
        greetings.add("konnichiwa");
        greetings.add("hello"); // Duplicate, will not be added

        // Print the set (order is not guaranteed)
        System.out.println("Set: " + greetings);
        // Check if the set contains a specific element
        System.out.println("Contains 'hello'? " + greetings.contains("hello"));
        // Remove an element
        greetings.remove("hola");
        System.out.println("After removing 'hola': " + greetings);
        // Print the size of the set
        System.out.println("Set size: " + greetings.size());
    }
}
```

**Key Points:**
- `Set<String> greetings = new HashSet<>();` creates a set that only stores unique strings.
- Adding a duplicate (like "hello") has no effect.
- The order of elements is unpredictable in a HashSet.
- `contains()` checks for membership, `remove()` deletes an element, and `size()` gives the number of elements.

---

### Creating and Using a TreeSet

// What’s happening here?
// This example shows how to use a TreeSet to store integers in sorted order automatically.

```java
import java.util.TreeSet;
import java.util.Set;

public class TreeSetExample {
    public static void main(String[] args) {
        // Create a new TreeSet of Integers
        Set<Integer> numbers = new TreeSet<>();
        
        // Add elements to the set
        numbers.add(42);
        numbers.add(3);
        numbers.add(15);
        numbers.add(42); // Duplicate, will not be added
        numbers.add(-7);

        // Print the set (elements will be sorted)
        System.out.println("Sorted Set: " + numbers); // Output: [-7, 3, 15, 42]
    }
}
```

**Key Points:**
- `TreeSet` automatically sorts elements (here, integers from smallest to largest).
- Duplicates are ignored.
- Useful when you need a sorted collection without duplicates.

---

### Iterating Over a Set

// What’s happening here?
// This example shows two ways to loop through all elements in a set: using a for-each loop and using an iterator.

```java
Set<String> set = new HashSet<>();
set.add("apple");
set.add("banana");
set.add("cherry");

// Using enhanced for-loop (for-each)
for (String fruit : set) {
    System.out.println(fruit); // Prints each fruit in the set
}

// Using an iterator
import java.util.Iterator;
Iterator<String> it = set.iterator();
while (it.hasNext()) {
    System.out.println(it.next()); // Prints each fruit in the set
}
```

**Key Points:**
- The enhanced for-loop is the simplest way to visit every element in a set.
- An iterator gives more control (e.g., you can remove elements while iterating).
- The order of iteration is not guaranteed for HashSet.

---

## Java Set Concepts Explained

- **What is an interface?**
  - An interface in Java is like a contract: it defines what methods a class must have, but not how they work. `Set` is an interface, so classes like `HashSet` and `TreeSet` must provide the actual code for the set operations.
- **Why use a Set?**
  - Use a set when you want to store a collection of unique items and don’t care about their order (or want them sorted, in the case of `TreeSet`).
- **When to use HashSet vs. TreeSet?**
  - Use `HashSet` for fast lookups and when order doesn’t matter.
  - Use `TreeSet` when you need the elements to be sorted.
- **What happens if you add a duplicate?**
  - The set ignores it—no error, but the set doesn’t change.
- **Can you get an element by index?**
  - No! Sets don’t have indices. Use a `List` if you need to access elements by position.

---

For more details, see the [Java Set documentation](https://docs.oracle.com/javase/8/docs/api/java/util/Set.html).

