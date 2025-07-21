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
public interface Stack<E> {
    void push(E item);
    E pop();
    E peek();
    boolean isEmpty();
    int size();
}
```

**Implementation:**
Concrete code that meets the specified interface. For example, the `ArrayList` and `LinkedList` classes that implement the `List` interface. Implementations provide the *how*.

- **Example:**
```java
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
        Stack<String> s = new Stack<>();
        s.push("a"); // Stack: [a]
        s.push("b"); // Stack: [a, b]
        s.push("c"); // Stack: [a, b, c]

        System.out.println(s.pop()); // Output: c (removes top)
        System.out.println(s.peek()); // Output: b (top remains)
        System.out.println(s.size()); // Output: 2
        System.out.println(s.isEmpty()); // Output: false
    }
}
```

#### Common Pitfalls
- Calling `pop()` or `peek()` on an empty stack throws `EmptyStackException`.
- Stack is not synchronized for multi-threaded use (unless you use `Collections.synchronizedList`).

#### Custom Stack Implementation (Array-based)
```java
public class MyStack<E> {
    private java.util.ArrayList<E> data = new java.util.ArrayList<>();

    public void push(E item) {
        data.add(item);
    }
    public E pop() {
        if (isEmpty()) throw new java.util.EmptyStackException();
        return data.remove(data.size() - 1);
    }
    public E peek() {
        if (isEmpty()) throw new java.util.EmptyStackException();
        return data.get(data.size() - 1);
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
        Queue<Integer> q = new LinkedList<>();
        q.add(42);   // Queue: [42]
        q.add(-3);   // Queue: [42, -3]
        q.add(17);   // Queue: [42, -3, 17]

        System.out.println(q.remove()); // Output: 42 (removes front)
        System.out.println(q.peek());   // Output: -3 (front remains)
        System.out.println(q.size());   // Output: 2
        System.out.println(q.isEmpty()); // Output: false
    }
}
```

#### Important Notes
- When constructing a queue, you must use a new `LinkedList` object instead of a new `Queue` object. `Queue` is an interface and cannot be instantiated directly.
- `remove()` throws a `NoSuchElementException` if the queue is empty.
- `peek()` returns `null` if the queue is empty.

#### Custom Queue Implementation (Array-based)
```java
public class MyQueue<E> {
    private java.util.LinkedList<E> data = new java.util.LinkedList<>();

    public void add(E item) {
        data.addLast(item);
    }
    public E remove() {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        return data.removeFirst();
    }
    public E peek() {
        return data.peekFirst(); // returns null if empty
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
