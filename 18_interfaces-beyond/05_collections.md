# Collections in Java

Java provides a rich set of collection classes and interfaces to store, manage, and manipulate groups of objects efficiently. Collections are fundamental to most Java programs, enabling flexible data structures beyond simple arrays. Below, we explore the most important collection types, their interfaces, and provide annotated code examples for each.

---

## 1. Array

An array is a fixed-size, indexed collection of elements of the same type.

```java
// Declare an array of 5 integers
int[] numbers = new int[5]; // Array of 5 integers, all initialized to 0
numbers[0] = 10;            // Set the first element to 10
numbers[1] = 20;            // Set the second element to 20
System.out.println(numbers[0]); // Output: 10 (accessing by index)
```

- **Pros:** Fast access by index, simple.
- **Cons:** Fixed size, cannot grow or shrink dynamically.
- **Note:** Arrays are basic and efficient, but lack flexibility for dynamic data.

---

## 2. ArrayList

`ArrayList` is a resizable array implementation of the `List` interface.

```java
import java.util.ArrayList;

ArrayList<String> names = new ArrayList<>(); // Create an empty ArrayList of Strings
names.add("Alice"); // Add "Alice" to the list
names.add("Bob");   // Add "Bob" to the list
System.out.println(names.get(1)); // Output: Bob (get element at index 1)
```

- **Pros:** Dynamic size, fast random access.
- **Cons:** Slower insertions/deletions in the middle.
- **Note:** Use when you need a list that can grow or shrink.

---

## 3. LinkedList

`LinkedList` implements both `List` and `Deque` interfaces. It stores elements as a doubly-linked list.

```java
import java.util.LinkedList;

LinkedList<String> queue = new LinkedList<>(); // Create an empty LinkedList of Strings
queue.add("First");      // Add to the end (default)
queue.add("Second");     // Add another to the end
queue.addFirst("Zero");  // Add to the front
System.out.println(queue); // Output: [Zero, First, Second]
```

- **Pros:** Fast insertions/deletions at both ends.
- **Cons:** Slower random access compared to ArrayList.
- **Note:** Good for queues, deques, or when you need frequent insertions/removals.

---

## 4. Stack

`Stack` is a legacy class that represents a last-in, first-out (LIFO) stack of objects.

```java
import java.util.Stack;

Stack<Integer> stack = new Stack<>(); // Create an empty stack of Integers
stack.push(10); // Push 10 onto the stack
stack.push(20); // Push 20 onto the stack
System.out.println(stack.pop()); // Output: 20 (removes and returns the top element)
```

- **Pros:** Simple LIFO operations.
- **Cons:** Legacy class; prefer `Deque` for new code.
- **Note:** Use for undo features, parsing, or any LIFO structure.

---

## 5. HashSet & HashMap

### HashSet
A `HashSet` is a collection that contains no duplicate elements and is backed by a hash table.

```java
import java.util.HashSet;

HashSet<String> set = new HashSet<>(); // Create an empty HashSet of Strings
set.add("apple");  // Add "apple" to the set
set.add("banana"); // Add "banana" to the set
set.add("apple");  // Duplicate, will not be added
System.out.println(set); // Output: [banana, apple] (order not guaranteed)
```

- **Pros:** Fast lookup, no duplicates.
- **Cons:** No ordering of elements.
- **Note:** Use when you need a unique collection of items.

### HashMap
A `HashMap` stores key-value pairs and allows fast lookup by key.

```java
import java.util.HashMap;

HashMap<String, Integer> map = new HashMap<>(); // Create an empty HashMap
map.put("Alice", 90); // Add key "Alice" with value 90
map.put("Bob", 85);   // Add key "Bob" with value 85
System.out.println(map.get("Alice")); // Output: 90 (get value by key)
```

- **Pros:** Fast lookup, insertion, and deletion.
- **Cons:** No ordering of elements.
- **Note:** Use for dictionaries, caches, or any key-value mapping.

---

## 6. TreeSet & TreeMap

### TreeSet
A `TreeSet` is a sorted set based on a red-black tree.

```java
import java.util.TreeSet;

TreeSet<Integer> numbers = new TreeSet<>(); // Create an empty TreeSet of Integers
numbers.add(5); // Add 5
numbers.add(1); // Add 1
numbers.add(3); // Add 3
System.out.println(numbers); // Output: [1, 3, 5] (sorted order)
```

- **Pros:** Sorted order, no duplicates.
- **Cons:** Slower than hash-based collections.
- **Note:** Use when you need a sorted, unique collection.

### TreeMap
A `TreeMap` is a map that maintains its keys in sorted order.

```java
import java.util.TreeMap;

TreeMap<String, Integer> scores = new TreeMap<>(); // Create an empty TreeMap
scores.put("Charlie", 70); // Add key "Charlie" with value 70
scores.put("Alice", 95);   // Add key "Alice" with value 95
System.out.println(scores); // Output: {Alice=95, Charlie=70} (sorted by key)
```

- **Pros:** Sorted order, useful for range queries.
- **Cons:** Slower than hash-based collections.
- **Note:** Use when you need a sorted map.

---

## 7. Set, Queue, List (Interfaces)

### Set
A `Set` is a collection that does not allow duplicate elements. Implemented by `HashSet`, `TreeSet`, etc.

### Queue
A `Queue` is a collection for holding elements prior to processing, typically in FIFO order. Implemented by `LinkedList`, `PriorityQueue`, etc.

### List
A `List` is an ordered collection (sequence) that may contain duplicates. Implemented by `ArrayList`, `LinkedList`, etc.

```java
// Example: Using List interface
import java.util.List;
import java.util.ArrayList;

List<String> fruits = new ArrayList<>(); // Create a List of Strings
fruits.add("Apple");  // Add "Apple"
fruits.add("Banana"); // Add "Banana"
System.out.println(fruits); // Output: [Apple, Banana]
```

- **Note:** Interfaces allow you to write flexible code that can use any implementation.

---

## 8. Comparable

The `Comparable` interface allows objects to be compared for sorting.

```java
// Student class implements Comparable to allow sorting by grade
class Student implements Comparable<Student> {
    String name;
    int grade;
    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
    // compareTo defines natural ordering (by grade)
    public int compareTo(Student other) {
        return this.grade - other.grade; // Positive if this > other
    }
}

// Usage:
import java.util.*;
List<Student> students = new ArrayList<>();
students.add(new Student("Alice", 90));
students.add(new Student("Bob", 85));
Collections.sort(students); // Sorts by grade (ascending)
```

- **Note:** Implementing `Comparable` lets you use `Collections.sort()` and sorted collections like `TreeSet`.

---

## Summary

- **Arrays** are fixed-size, basic containers.
- **ArrayList** and **LinkedList** are dynamic lists.
- **Stack** and **Queue** provide LIFO and FIFO structures.
- **HashSet/TreeSet** and **HashMap/TreeMap** are for sets and maps, with different ordering and performance.
- **Interfaces** like `List`, `Set`, `Queue` provide abstraction for different collection types.
- **Comparable** allows custom sorting.

Java Collections Framework is powerful and flexible. Choose the right collection based on your needs for performance, ordering, and uniqueness.