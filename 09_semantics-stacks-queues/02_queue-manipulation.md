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

**Note:** You cannot instantiate a `Queue` directly because it is an interface. You must use a class that implements it, such as `LinkedList` or `ArrayDeque`.

---

## Common Queue Implementations

- **LinkedList:** Most common, flexible, allows null elements.
- **ArrayDeque:** Faster for most queue operations, does not allow nulls.
- **PriorityQueue:** Orders elements according to their natural ordering or a comparator (not strictly FIFO).

---

## Basic Queue Operations in Java

### Example: Using a Queue with LinkedList

```java
import java.util.Queue;
import java.util.LinkedList;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("Alice");   // Enqueue
        queue.add("Bob");
        queue.add("Charlie");

        System.out.println(queue); // [Alice, Bob, Charlie]

        // Dequeue
        String first = queue.remove();
        System.out.println("Removed: " + first); // Alice
        System.out.println(queue); // [Bob, Charlie]

        // Peek
        String next = queue.peek();
        System.out.println("Next: " + next); // Bob
        System.out.println(queue); // [Bob, Charlie]
    }
}
```

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

You can use a for-each loop to iterate over a queue, but remember: this does **not** remove elements!

```java
for (String name : queue) {
    System.out.println(name);
}
```

---

## Custom Queue Implementation (Array-based)

Here's a simple queue implementation using an array:

```java
public class SimpleQueue<E> {
    private java.util.ArrayList<E> data = new java.util.ArrayList<>();

    // Enqueue: add to the back
    public void add(E item) {
        data.add(item);
    }
    // Dequeue: remove from the front
    public E remove() {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        return data.remove(0);
    }
    // Peek: look at the front
    public E peek() {
        if (isEmpty()) return null;
        return data.get(0);
    }
    public boolean isEmpty() {
        return data.isEmpty();
    }
    public int size() {
        return data.size();
    }
}
```

---

## Practical Scenarios for Queues

- **Print Spoolers:** Print jobs are handled in the order they arrive.
- **Task Scheduling:** Tasks are processed in the order they are received.
- **Breadth-First Search (BFS):** Graph traversal algorithms use queues to explore nodes level by level.
- **Customer Service:** People are served in the order they enter the line.

---

## Common Pitfalls and Tips

- **Removing from an empty queue:** `remove()` throws `NoSuchElementException`. Use `isEmpty()` or handle the exception.
- **Null elements:** Some implementations (like `ArrayDeque`) do not allow nulls.
- **Choosing the right implementation:** Use `LinkedList` or `ArrayDeque` for general-purpose queues. Use `PriorityQueue` only if you need sorted order.
- **Iteration does not remove:** Iterating over a queue does not dequeue elements.

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
