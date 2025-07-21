# Queue Manipulation

A **Queue** is a linear data structure that follows the **First-In, First-Out (FIFO)** principle. This means that the first element added to the queue will be the first one to be removed. Queues are widely used in computer science for managing tasks, resources, and data streams in the order they arrive.

---

## Key Concepts

- **FIFO Order:** Elements are processed in the order they were added.
- **Enqueue:** Adding an element to the back (tail) of the queue.
- **Dequeue:** Removing an element from the front (head) of the queue.
- **Peek:** Viewing the front element without removing it.

---

## The Queue Interface in Java

Java provides the `Queue` interface in the `java.util` package. It defines the basic operations for a queue:

```java
public interface Queue<E> {
    boolean add(E e);      // Inserts the specified element into this queue
    E remove();            // Retrieves and removes the head of this queue
    E peek();              // Retrieves, but does not remove, the head of this queue
    boolean isEmpty();     // Checks if the queue is empty
    int size();            // Returns the number of elements in the queue
    // ... other methods ...
}
```

**Note:**
- `E` is a generic type, meaning the queue can hold any type of object (like `String`, `Integer`, etc.).
- You cannot instantiate a `Queue` directly because it is an interface. You must use a class that implements it, such as `LinkedList` or `ArrayDeque`.

---

## Common Queue Implementations

- **LinkedList:** Most common, flexible, allows null elements.
- **ArrayDeque:** Faster for most queue operations, does not allow nulls.
- **PriorityQueue:** Orders elements according to their natural ordering or a comparator (not strictly FIFO).

---

## Basic Queue Operations in Java

### Example: Using a Queue with LinkedList

Below is a simple example showing how to use a queue in Java. Each step is annotated to explain what is happening:

```java
import java.util.Queue;        // Import the Queue interface
import java.util.LinkedList;   // Import the LinkedList class (implements Queue)

public class QueueDemo {
    public static void main(String[] args) {
        // Create a new Queue that holds Strings, implemented by LinkedList
        Queue<String> queue = new LinkedList<>();
        
        // Enqueue: Add elements to the back of the queue
        queue.add("Alice");   // Queue: [Alice]
        queue.add("Bob");     // Queue: [Alice, Bob]
        queue.add("Charlie"); // Queue: [Alice, Bob, Charlie]

        System.out.println(queue); // Prints the whole queue

        // Dequeue: Remove and return the front element
        String first = queue.remove(); // Removes "Alice"
        System.out.println("Removed: " + first); // Output: Removed: Alice
        System.out.println(queue); // Queue is now: [Bob, Charlie]

        // Peek: Look at the front element without removing it
        String next = queue.peek(); // Looks at "Bob"
        System.out.println("Next: " + next); // Output: Next: Bob
        System.out.println(queue); // Queue remains: [Bob, Charlie]
    }
}
```

**Explanation:**
- `add()` puts an element at the back of the queue.
- `remove()` takes the element from the front (FIFO order).
- `peek()` looks at the front element but does not remove it.
- Printing the queue shows its current state after each operation.

**Output:**
```
[Alice, Bob, Charlie]
Removed: Alice
[Bob, Charlie]
Next: Bob
[Bob, Charlie]
```

---

## Iterating Over a Queue

You can use a for-each loop to go through all elements in a queue. This does **not** remove elements from the queue:

```java
for (String name : queue) { // For each element in the queue
    System.out.println(name); // Print the element
}
```

**Note:** The queue remains unchanged after iteration.

---

## Custom Queue Implementation (Array-based)

Here is a simple custom queue class using an `ArrayList` for storage. Each method is annotated to explain its purpose:

```java
public class SimpleQueue<E> {
    // Use an ArrayList to store queue elements
    private java.util.ArrayList<E> data = new java.util.ArrayList<>();

    // Enqueue: add to the back of the queue
    public void add(E item) {
        data.add(item); // Add item at the end
    }
    // Dequeue: remove from the front of the queue
    public E remove() {
        if (isEmpty()) throw new java.util.NoSuchElementException(); // Check for empty
        return data.remove(0); // Remove and return the first item
    }
    // Peek: look at the front item without removing it
    public E peek() {
        if (isEmpty()) return null; // Return null if empty
        return data.get(0); // Get the first item
    }
    // Check if the queue is empty
    public boolean isEmpty() {
        return data.isEmpty();
    }
    // Get the number of items in the queue
    public int size() {
        return data.size();
    }
}
```

**Explanation:**
- `add(E item)`: Adds an item to the end of the queue.
- `remove()`: Removes and returns the item at the front. Throws an exception if the queue is empty.
- `peek()`: Returns the item at the front without removing it, or `null` if the queue is empty.
- `isEmpty()`: Checks if the queue has no elements.
- `size()`: Returns the number of elements in the queue.

---

## Practical Scenarios for Queues

- **Print Spoolers:** Print jobs are handled in the order they arrive (first job in, first job out).
- **Task Scheduling:** Tasks are processed in the order they are received.
- **Breadth-First Search (BFS):** Graph traversal algorithms use queues to explore nodes level by level.
- **Customer Service:** People are served in the order they enter the line.

---

## Common Pitfalls and Tips

- **Removing from an empty queue:** `remove()` throws `NoSuchElementException`. Always check `isEmpty()` before removing, or handle the exception.
- **Null elements:** Some implementations (like `ArrayDeque`) do not allow nulls. Avoid adding `null` to queues unless you know the implementation supports it.
- **Choosing the right implementation:** Use `LinkedList` or `ArrayDeque` for general-purpose queues. Use `PriorityQueue` only if you need sorted order.
- **Iteration does not remove:** Iterating over a queue does not dequeue elements. Use `remove()` if you want to process and remove each item.

---

## Summary Table: Queue Operations

| Operation | Description                | Java Method |
|-----------|----------------------------|-------------|
| Enqueue   | Add to back                | add         |
| Dequeue   | Remove from front          | remove      |
| Peek      | Examine front (no remove)  | peek        |
| Empty?    | Check if queue is empty    | isEmpty     |
| Size      | Number of elements         | size        |

---

## Further Reading
- [Java Queue Interface Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html)
- [LinkedList (Java SE 8)](https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html)
- [ArrayDeque (Java SE 8)](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayDeque.html)
