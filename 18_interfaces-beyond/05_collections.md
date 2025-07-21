# Collections in Java

Java provides a rich set of collection classes and interfaces to store, manage, and manipulate groups of objects efficiently. Collections are fundamental to most Java programs, enabling flexible data structures beyond simple arrays. Below, we explore the most important collection types, their interfaces, and provide annotated code examples for each.

---

## 1. Array

An array is a fixed-size, indexed collection of elements of the same type.

```java
// Example: Creating and using an array
int[] numbers = new int[5]; // Array of 5 integers
numbers[0] = 10;
numbers[1] = 20;
System.out.println(numbers[0]); // Output: 10
```

- **Pros:** Fast access by index, simple.
- **Cons:** Fixed size, cannot grow or shrink dynamically.

---

## 2. ArrayList

`ArrayList` is a resizable array implementation of the `List` interface.

```java
import java.util.ArrayList;

ArrayList<String> names = new ArrayList<>();
names.add("Alice");
names.add("Bob");
System.out.println(names.get(1)); // Output: Bob
```

- **Pros:** Dynamic size, fast random access.
- **Cons:** Slower insertions/deletions in the middle.

---

## 3. LinkedList

`LinkedList` implements both `List` and `Deque` interfaces. It stores elements as a doubly-linked list.

```java
import java.util.LinkedList;

LinkedList<String> queue = new LinkedList<>();
queue.add("First");
queue.add("Second");
queue.addFirst("Zero"); // Add to the front
System.out.println(queue); // Output: [Zero, First, Second]
```

- **Pros:** Fast insertions/deletions at both ends.
- **Cons:** Slower random access compared to ArrayList.

---

## 4. Stack

`Stack` is a legacy class that represents a last-in, first-out (LIFO) stack of objects.

```java
import java.util.Stack;

Stack<Integer> stack = new Stack<>();
stack.push(10);
stack.push(20);
System.out.println(stack.pop()); // Output: 20
```

- **Pros:** Simple LIFO operations.
- **Cons:** Legacy class; prefer `Deque` for new code.

---

## 5. HashSet & HashMap

### HashSet
A `HashSet` is a collection that contains no duplicate elements and is backed by a hash table.

```java
import java.util.HashSet;

HashSet<String> set = new HashSet<>();
set.add("apple");
set.add("banana");
set.add("apple"); // Duplicate, will not be added
System.out.println(set); // Output: [banana, apple]
```

### HashMap
A `HashMap` stores key-value pairs and allows fast lookup by key.

```java
import java.util.HashMap;

HashMap<String, Integer> map = new HashMap<>();
map.put("Alice", 90);
map.put("Bob", 85);
System.out.println(map.get("Alice")); // Output: 90
```

- **Pros:** Fast lookup, insertion, and deletion.
- **Cons:** No ordering of elements.

---

## 6. TreeSet & TreeMap

### TreeSet
A `TreeSet` is a sorted set based on a red-black tree.

```java
import java.util.TreeSet;

TreeSet<Integer> numbers = new TreeSet<>();
numbers.add(5);
numbers.add(1);
numbers.add(3);
System.out.println(numbers); // Output: [1, 3, 5]
```

### TreeMap
A `TreeMap` is a map that maintains its keys in sorted order.

```java
import java.util.TreeMap;

TreeMap<String, Integer> scores = new TreeMap<>();
scores.put("Charlie", 70);
scores.put("Alice", 95);
System.out.println(scores); // Output: {Alice=95, Charlie=70}
```

- **Pros:** Sorted order, useful for range queries.
- **Cons:** Slower than hash-based collections.

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

List<String> fruits = new ArrayList<>();
fruits.add("Apple");
fruits.add("Banana");
System.out.println(fruits); // Output: [Apple, Banana]
```

---

## 8. Comparable

The `Comparable` interface allows objects to be compared for sorting.

```java
class Student implements Comparable<Student> {
    String name;
    int grade;
    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
    // Compare students by grade
    public int compareTo(Student other) {
        return this.grade - other.grade;
    }
}

// Usage:
import java.util.*;
List<Student> students = new ArrayList<>();
students.add(new Student("Alice", 90));
students.add(new Student("Bob", 85));
Collections.sort(students); // Sorts by grade
```

---

## Summary

- **Arrays** are fixed-size, basic containers.
- **ArrayList** and **LinkedList** are dynamic lists.
- **Stack** and **Queue** provide LIFO and FIFO structures.
- **HashSet/TreeSet** and **HashMap/TreeMap** are for sets and maps, with different ordering and performance.
- **Interfaces** like `List`, `Set`, `Queue` provide abstraction for different collection types.
- **Comparable** allows custom sorting.

Java Collections Framework is powerful and flexible. Choose the right collection based on your needs for performance, ordering, and uniqueness.