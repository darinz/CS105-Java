# Stacks and Queues in Java

This module introduces two fundamental data structures in computer science: **Stacks** and **Queues**. You will learn their principles, how to use them in Java, and explore practical applications and common pitfalls.

## Learning Objectives
- Understand the concepts of Abstract Data Types (ADT), interfaces, and implementations in Java.
- Learn the principles of Stacks (LIFO) and Queues (FIFO).
- Practice using Java's built-in `Stack` and `Queue` classes, as well as custom implementations.
- Apply stacks and queues to solve real-world and algorithmic problems.
- Recognize common mistakes and best practices when working with these data structures.

## Key Concepts

### Stacks
- **Last-In, First-Out (LIFO):** The last element added is the first to be removed.
- **Basic operations:** `push`, `pop`, `peek`, `isEmpty`, `size`.
- **Java usage:**
  - `Stack<E>` class (legacy, but useful for learning)
  - `ArrayDeque<E>` (recommended for modern Java)
- **Applications:**
  - Expression evaluation and parsing
  - Undo mechanisms
  - Backtracking algorithms
  - Call stack in programming languages

### Queues
- **First-In, First-Out (FIFO):** The first element added is the first to be removed.
- **Basic operations:** `add` (enqueue), `remove` (dequeue), `peek`, `isEmpty`, `size`.
- **Java usage:**
  - `Queue<E>` interface (cannot instantiate directly)
  - `LinkedList<E>` and `ArrayDeque<E>` as common implementations
- **Applications:**
  - Task scheduling
  - Print job management
  - Breadth-First Search (BFS) in graphs
  - Real-world lines (e.g., customer service)

## Practical Tips
- Always check if a stack or queue is empty before removing or peeking elements to avoid exceptions.
- Prefer `ArrayDeque` over `Stack` for new Java code.
- Use `LinkedList` or `ArrayDeque` for queues; avoid `PriorityQueue` unless you need sorted order.
- Iterating over a queue does not remove elements; use `remove()` to process and dequeue.

## Practice and Review
- Analyze and correct common mistakes in stack and queue manipulation.
- Implement custom stacks and queues using arrays or linked lists.
- Restore original data structure order after processing (e.g., when summing elements).

## Further Reading
- [Java Collections Framework Documentation](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html)
- [Stack (Java Platform SE 8)](https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html)
- [Queue (Java Platform SE 8)](https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html)
- [ArrayDeque (Java Platform SE 8)](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayDeque.html)

---

For detailed explanations, annotated code examples, and practice problems, see the following files:
- `01_stacks-queues.md`: Overview, theory, and summary tables
- `02_queue-manipulation.md`: Queue operations and custom implementations
- `03_stack-manipulation.md`: Stack operations and practical examples
- `04_practice-review-app.md`: Practice problems and annotated solutions 