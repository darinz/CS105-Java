# Stacks and Queues

Some collections are constrained, only use optimized (but limited) operations
- Stack: retrieves elements in reverse order as added
- Queue: retrieves elements in same order as added

Why optimize? Think dedicated tool instead of a Swiss Army knife 

## Abstract Data Types (ADT), Interfaces, and Implementations in Java

**Abstract Data Type (ADT):**
A specification of a collection of data and the operations that can be performed on it. Describes what a collection does, not how it does it (not implementation!). Think of it as an ✨idea ✨ of a data type.

- **Example:** The idea of a Stack: you can push, pop, and peek, but you don't care how it's done internally.

**Interface:**
A Java construct that lets programmers specify what methods a class should have. For example, the `List` interface in Java. Interfaces define the *what*, not the *how*.

- **Example:**
```java
// This is a simple interface for a Stack in Java.
// It describes what methods a Stack should have, but not how they work.
public interface Stack<E> {
    void push(E item);    // Add an item to the top
    E pop();              // Remove and return the top item
    E peek();             // Return (but don't remove) the top item
    boolean isEmpty();    // Check if the stack is empty
    int size();           // Get the number of items in the stack
}
```
*Tip: The <E> means this Stack can hold any type of object (like String, Integer, etc.).*

**Implementation:**
Concrete code that meets the specified interface. For example, the `ArrayList` and `LinkedList` classes that implement the `List` interface. Implementations provide the *how*.

- **Example:**
```java
// This class implements the Stack interface using an array (ArrayList) to store elements.
public class ArrayStack<E> implements Stack<E> {
    // ... actual code for storing and managing elements ...
}
```

**Generics:**
Java collections use generics (the `<E>` or `<T>` syntax) to allow you to specify the type of elements stored, providing type safety and flexibility.

---

## Stacks

A **Stack** is a collection based on the principle of adding elements and retrieving them in the opposite order.
- **Last-In, First-Out ("LIFO")**
- Elements are stored in order of insertion.
- We do not think of them as having indexes.
- Client can only add/remove/examine the last element added (the "top")

### Basic Stack Operations
- `push`: Add an element to the top
- `pop`: Remove the top element
- `peek`: Examine the top element

### Java's Stack Class
Java provides a built-in `Stack` class (in `java.util`), but it's considered somewhat outdated. More commonly, you use `Deque` (double-ended queue) for stack operations. However, for learning, `Stack` is fine.

#### Example: Using Java's Stack
```java
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        // Create a new Stack that holds Strings
        Stack<String> s = new Stack<>();
        s.push("a"); // Add "a" to the stack. Stack: [a]
        s.push("b"); // Add "b" to the stack. Stack: [a, b]
        s.push("c"); // Add "c" to the stack. Stack: [a, b, c]

        // Remove and print the top element ("c")
        System.out.println(s.pop()); // Output: c (removes top)
        // Look at the top element without removing it ("b")
        System.out.println(s.peek()); // Output: b (top remains)
        // Print the number of elements in the stack
        System.out.println(s.size()); // Output: 2
        // Check if the stack is empty
        System.out.println(s.isEmpty()); // Output: false
    }
}
```
*Explanation: Each operation changes or inspects the stack. Notice how pop removes the most recently added item (LIFO).* 

#### Common Pitfalls
- Calling `pop()` or `peek()` on an empty stack throws `EmptyStackException`.
- Stack is not synchronized for multi-threaded use (unless you use `Collections.synchronizedList`).

#### Custom Stack Implementation (Array-based)
```java
// This is a simple custom stack using an ArrayList for storage.
public class MyStack<E> {
    // Use an ArrayList to store stack elements
    private java.util.ArrayList<E> data = new java.util.ArrayList<>();

    // Add an item to the top of the stack
    public void push(E item) {
        data.add(item);
    }
    // Remove and return the top item
    public E pop() {
        if (isEmpty()) throw new java.util.EmptyStackException(); // Check for empty
        return data.remove(data.size() - 1); // Remove last item
    }
    // Return (but don't remove) the top item
    public E peek() {
        if (isEmpty()) throw new java.util.EmptyStackException(); // Check for empty
        return data.get(data.size() - 1); // Get last item
    }
    // Check if the stack is empty
    public boolean isEmpty() {
        return data.isEmpty();
    }
    // Get the number of items in the stack
    public int size() {
        return data.size();
    }
}
```
*Tip: This stack grows as needed because ArrayList resizes automatically! Always check for empty before popping or peeking.*

---

## Stacks in Computer Science

- **Programming languages and compilers:**
    - Method calls are placed onto a stack (call ↔ push, return ↔ pop)
    - Compilers use stacks to evaluate expressions
- **Operating Systems:**
    - Call stacks → memory stack for processes’ data
- **Matching up related pairs of things:**
    - Find out whether a string is a palindrome
    - Examine a file to see if its braces `{}` match
    - Convert "infix" expressions to pre/postfix
- **Sophisticated algorithms:**
    - Searching through a maze with "backtracking”
    - Many programs use an "undo stack" of previous operations

---

## Queues

A **Queue** retrieves elements in the order they were added.
- **First-In, First-Out ("FIFO")**
- Elements are stored in order of insertion but don't have indexes.
- Client can only add to the end of the queue, and can only examine/remove the front of the queue.

### Basic Queue Operations
- `add` (enqueue): Add an element to the back.
- `remove` (dequeue): Remove the front element.
- `peek`: Examine the front element.

### Java's Queue Interface
Java provides the `Queue` interface (in `java.util`). The most common implementation is `LinkedList`.

#### Example: Using Java's Queue
```java
import java.util.Queue;
import java.util.LinkedList;

public class QueueExample {
    public static void main(String[] args) {
        // Create a new Queue that holds Integers, implemented by LinkedList
        Queue<Integer> q = new LinkedList<>();
        q.add(42);   // Add 42 to the queue. Queue: [42]
        q.add(-3);   // Add -3 to the queue. Queue: [42, -3]
        q.add(17);   // Add 17 to the queue. Queue: [42, -3, 17]

        // Remove and print the front element (42)
        System.out.println(q.remove()); // Output: 42 (removes front)
        // Look at the front element without removing it (-3)
        System.out.println(q.peek());   // Output: -3 (front remains)
        // Print the number of elements in the queue
        System.out.println(q.size());   // Output: 2
        // Check if the queue is empty
        System.out.println(q.isEmpty()); // Output: false
    }
}
```
*Explanation: Queues process items in the order they arrive (FIFO). Remove always takes from the front, add always puts at the back.*

#### Important Notes
- When constructing a queue, you must use a new `LinkedList` object instead of a new `Queue` object. `Queue` is an interface and cannot be instantiated directly.
- `remove()` throws a `NoSuchElementException` if the queue is empty.
- `peek()` returns `null` if the queue is empty.

#### Custom Queue Implementation (Array-based)
```java
// This is a simple custom queue using a LinkedList for storage.
public class MyQueue<E> {
    // Use a LinkedList to store queue elements
    private java.util.LinkedList<E> data = new java.util.LinkedList<>();

    // Add an item to the back of the queue
    public void add(E item) {
        data.addLast(item);
    }
    // Remove and return the front item
    public E remove() {
        if (isEmpty()) throw new java.util.NoSuchElementException(); // Check for empty
        return data.removeFirst(); // Remove first item
    }
    // Return (but don't remove) the front item
    public E peek() {
        return data.peekFirst(); // returns null if empty
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
*Tip: LinkedList makes it easy to add/remove from both ends. Always check for empty before removing!*

---

## Queues in Computer Science

- **Operating systems:**
    - Queue of print jobs to send to the printer
    - Queue of programs / processes to be run
    - Queue of network data packets to send
- **Computer Architecture:**
    - Miss status/handling register (MSHR) queue
    - Instruction fetch queue
    - Issue queue
    - Instruction pipeline in general!
- **Programming:**
    - Modeling a line of customers or clients 
    - Storing a queue of computations to be performed in order
- **Real world examples:**
    - People on an escalator or waiting in a line
    - Cars at a gas station (or on an assembly line)

---

## Practical Tips and Common Pitfalls

- **Stack:**
    - Don't use `pop()` or `peek()` on an empty stack; always check `isEmpty()` first or handle the exception.
    - For modern Java, consider using `ArrayDeque` for stack operations (faster, no legacy methods).
- **Queue:**
    - Don't use `remove()` on an empty queue; check `isEmpty()` or handle the exception.
    - `peek()` is safe; it returns `null` if the queue is empty.
    - Use `LinkedList` or `ArrayDeque` for queues; avoid `PriorityQueue` unless you want sorted order.

---

## Summary Table: Stack vs Queue in Java

| Operation | Stack (LIFO) | Queue (FIFO) |
|-----------|--------------|--------------|
| Add       | push         | add          |
| Remove    | pop          | remove       |
| Examine   | peek         | peek         |
| Empty?    | isEmpty      | isEmpty      |
| Size      | size         | size         |

---

## Further Reading
- [Java Collections Framework Documentation](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html)
- [Stack (Java Platform SE 8)](https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html)
- [Queue (Java Platform SE 8)](https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html)
- [ArrayDeque (Java Platform SE 8)](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayDeque.html)
