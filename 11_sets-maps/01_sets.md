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
```java
import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<String> greetings = new HashSet<>();
        greetings.add("hi");
        greetings.add("hola");
        greetings.add("hello");
        greetings.add("bonjour");
        greetings.add("konnichiwa");
        greetings.add("hello"); // Duplicate, will not be added

        System.out.println("Set: " + greetings); // Order is not guaranteed
        System.out.println("Contains 'hello'? " + greetings.contains("hello"));
        greetings.remove("hola");
        System.out.println("After removing 'hola': " + greetings);
        System.out.println("Set size: " + greetings.size());
    }
}
```

### Creating and Using a TreeSet
```java
import java.util.TreeSet;
import java.util.Set;

public class TreeSetExample {
    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<>();
        numbers.add(42);
        numbers.add(3);
        numbers.add(15);
        numbers.add(42); // Duplicate, will not be added
        numbers.add(-7);

        System.out.println("Sorted Set: " + numbers); // Output will be sorted
    }
}
```

### Iterating Over a Set
```java
Set<String> set = new HashSet<>();
set.add("apple");
set.add("banana");
set.add("cherry");

// Using enhanced for-loop
for (String fruit : set) {
    System.out.println(fruit);
}

// Using an iterator
import java.util.Iterator;
Iterator<String> it = set.iterator();
while (it.hasNext()) {
    System.out.println(it.next());
}
```

---

## Common Pitfalls and Best Practices

- **No Duplicates:** Adding a duplicate element to a set has no effect.
- **No Indexing:** Sets do not support get(int index) or similar methods; use a List if you need indexed access.
- **Order:**
  - HashSet: No order guaranteed.
  - TreeSet: Sorted order.
  - If you need insertion order, use `LinkedHashSet`.
- **Null Elements:** HashSet allows one null element; TreeSet does not allow nulls.
- **Performance:** Prefer HashSet for fast lookups and when order does not matter. Use TreeSet when you need sorted elements.
- **Custom Objects:** If you use custom objects in a set, make sure to override `equals()` and `hashCode()` methods for correct behavior.

---

For more details, see the [Java Set documentation](https://docs.oracle.com/javase/8/docs/api/java/util/Set.html).

