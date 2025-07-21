# Practice, Reviews, and Applications

## Java Stacks and Queues: Concepts and Examples

### What is a Stack?
A **Stack** is a linear data structure that follows the Last-In-First-Out (LIFO) principle. The last element added is the first one to be removed. In Java, you can use the `Stack` class from `java.util`:

```java
import java.util.Stack;

Stack<Integer> stack = new Stack<>();
stack.push(1); // Add 1 to the top
stack.push(2); // Add 2 to the top
int top = stack.pop(); // Removes and returns 2
```

### What is a Queue?
A **Queue** is a linear data structure that follows the First-In-First-Out (FIFO) principle. The first element added is the first one to be removed. In Java, you can use `Queue` with `LinkedList`:

```java
import java.util.Queue;
import java.util.LinkedList;

Queue<Integer> queue = new LinkedList<>();
queue.add(1); // Add 1 to the back
queue.add(2); // Add 2 to the back
int front = queue.remove(); // Removes and returns 1
```

---

## Practice: Analyzing Stack Code

### What does this method return?

```java
// numbers: bottom [1, 2, 3, 4, 5] top
public static int sum(Stack<Integer> numbers) {
   int total = 0;
   for (int i = 0; i < numbers.size(); i++) {
      int number = numbers.pop();
      total += number;
      numbers.push(number);
   }
   return total;
}
```

#### Explanation:
- The method tries to sum the elements by popping and pushing them back.
- However, `numbers.size()` changes as you pop elements, and pushing immediately after popping just puts the same element back on top, causing an infinite loop or a stack corruption.
- **Correct way:** To sum a stack without losing its contents, use an auxiliary structure (like another stack or a queue) to temporarily hold elements.

#### Correct Example:
```java
public static int sum(Stack<Integer> numbers) {
    Stack<Integer> temp = new Stack<>();
    int total = 0;
    while (!numbers.isEmpty()) {
        int num = numbers.pop();
        total += num;
        temp.push(num);
    }
    // Restore original stack
    while (!temp.isEmpty()) {
        numbers.push(temp.pop());
    }
    return total;
}
```

---

### Practice: Using a Queue as Auxiliary Storage

```java
// numbers: bottom [1, 2, 3, 4, 5] top
public static int sum(Stack<Integer> numbers) {
   Queue<Integer> q = new LinkedList<>(); 
   int total = 0;
   for (int i = 0; i < numbers.size(); i++) {
      int number = numbers.pop();
      total += number;
      q.add(number);
   }
   return total;
}
```

#### Explanation:
- This code also has a problem: `numbers.size()` changes as you pop elements, so the loop may not process all elements as expected.
- Also, the original stack is emptied and not restored.
- **Correct way:** Use the queue to temporarily hold elements, then restore the stack.

#### Correct Example:
```java
public static int sum(Stack<Integer> numbers) {
    Queue<Integer> q = new LinkedList<>();
    int total = 0;
    while (!numbers.isEmpty()) {
        int num = numbers.pop();
        total += num;
        q.add(num);
    }
    // Restore stack (order will be reversed, so use another stack)
    Stack<Integer> temp = new Stack<>();
    while (!q.isEmpty()) {
        temp.push(q.remove());
    }
    while (!temp.isEmpty()) {
        numbers.push(temp.pop());
    }
    return total;
}
```

---

## Problem Solving with Stacks & Queues

Stacks and queues are simple, but solving problems with them can be tricky because you often have to use only their basic operations (`push`, `pop`, `add`, `remove`).

### Common Problem-Solving Strategies
- **Analogy:** Relate the problem to one you’ve solved before.
- **Brainstorming:** Outline steps before coding.
- **Solve Sub-Problems:** Break the problem into smaller parts.
- **Debugging:** Test your solution on sample and edge cases.
- **Iterative Development:** Start with a simpler version and build up.

---

## Common Stack & Queue Patterns

### Stack to Queue and Queue to Stack

#### Example: Reverse a Stack using a Queue
```java
public static void reverseStack(Stack<Integer> stack) {
    Queue<Integer> queue = new LinkedList<>();
    while (!stack.isEmpty()) {
        queue.add(stack.pop());
    }
    while (!queue.isEmpty()) {
        stack.push(queue.remove());
    }
}
```

### Cycling a Queue
Inspect each element by removing and adding it back:
```java
public static void printQueue(Queue<Integer> queue) {
    int size = queue.size();
    for (int i = 0; i < size; i++) {
        int val = queue.remove();
        System.out.println(val);
        queue.add(val); // put it back
    }
}
```

---

## Metacognition in Programming

Metacognition means thinking about your own thinking. In programming, it helps you debug, design, and learn more effectively.

- **While debugging:** Explain to yourself why you’re making a change.
- **Before running code:** Predict what you expect to see.
- **When stuck:** Take a break or try a new approach.
- **When designing:** Consider tradeoffs and alternatives.
- **When studying:** Relate new topics to what you already know.

---

## copyStack

**Problem:**
Write a method `copyStack` that takes a stack `s` of integers and returns a new stack with the same values in the same order. You may use one queue as auxiliary storage. The original stack must be restored.

### Step-by-Step Solution
1. Pop all elements from the stack into a queue (this reverses the order).
2. Remove all elements from the queue and push them back onto the stack (restores original order).
3. Pop all elements from the stack again, push onto the new stack, and also enqueue them to the queue.
4. Finally, restore the original stack from the queue.

### Java Code Example
```java
public static Stack<Integer> copyStack(Stack<Integer> s) {
    Queue<Integer> q = new LinkedList<>();
    Stack<Integer> copy = new Stack<>();
    // Step 1: Move all to queue
    while (!s.isEmpty()) {
        q.add(s.pop());
    }
    // Step 2: Move back to stack (restores original order)
    while (!q.isEmpty()) {
        s.push(q.remove());
    }
    // Step 3: Copy to new stack and queue
    while (!s.isEmpty()) {
        int val = s.pop();
        copy.push(val);
        q.add(val);
    }
    // Step 4: Restore original stack
    while (!q.isEmpty()) {
        s.push(q.remove());
    }
    return copy;
}
```

---

## Exceptions in Java

Exceptions are used to signal errors or unexpected conditions. Throwing an exception stops normal execution and transfers control to the nearest catch block.

### Example: Throwing an Exception
```java
if (input < 0) {
    throw new IllegalArgumentException("Input must be non-negative");
}
```

### Why Use Exceptions?
- **Fail fast:** Stop execution as soon as something goes wrong.
- **Cleaner code:** No need for lots of if-else checks.
- **Custom messages:** Help users and developers understand what went wrong.

---

## spliceStack

**Problem:**
Write a method `spliceStack` that takes a stack of integers `s`, a start position `i`, and an ending position `j`, and removes a sequence of elements from `s` starting at the i’th element from the bottom up to (but not including) the j’th element from the bottom, returning these values in a new stack. The order of elements in both stacks should be preserved.

### Step-by-Step Solution
1. Use a queue to temporarily hold elements as you pop them off the stack.
2. As you process, identify elements in the range `[i, j)` and push them onto the new stack.
3. Restore the original stack from the queue.

### Java Code Example
```java
public static Stack<Integer> spliceStack(Stack<Integer> s, int i, int j) {
    Queue<Integer> q = new LinkedList<>();
    Stack<Integer> result = new Stack<>();
    int size = s.size();
    // Step 1: Move all to queue (bottom to top)
    while (!s.isEmpty()) {
        q.add(s.pop());
    }
    // Step 2: Move back to stack, splicing as needed
    for (int idx = 0; idx < size; idx++) {
        int val = q.remove();
        if (idx >= i && idx < j) {
            result.push(val); // Splice out
        } else {
            s.push(val); // Keep in original
        }
    }
    // Step 3: Restore order of original stack
    while (!s.isEmpty()) {
        q.add(s.pop());
    }
    while (!q.isEmpty()) {
        s.push(q.remove());
    }
    return result;
}
```

---

Feel free to experiment with these examples and modify them to deepen your understanding of stacks and queues in Java!
