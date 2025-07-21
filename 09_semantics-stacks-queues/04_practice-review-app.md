# Practice, Reviews, and Applications

## Java Stacks and Queues: Concepts and Examples

### What is a Stack?
A **Stack** is a linear data structure that follows the Last-In-First-Out (LIFO) principle. The last element added is the first one to be removed. In Java, you can use the `Stack` class from `java.util`.

Below is a simple example of how to use a stack in Java. Each line is annotated to explain what it does:

```java
import java.util.Stack; // Import the Stack class

Stack<Integer> stack = new Stack<>(); // Create a new stack of integers
stack.push(1); // Add 1 to the top of the stack
stack.push(2); // Add 2 to the top of the stack
int top = stack.pop(); // Removes and returns the top element (2)
```

- `push(value)`: Adds a value to the top of the stack.
- `pop()`: Removes and returns the value at the top of the stack.
- `peek()`: Returns the value at the top without removing it.
- `isEmpty()`: Checks if the stack is empty.

### What is a Queue?
A **Queue** is a linear data structure that follows the First-In-First-Out (FIFO) principle. The first element added is the first one to be removed. In Java, you can use `Queue` with `LinkedList`.

Here’s how you can use a queue in Java:

```java
import java.util.Queue; // Import the Queue interface
import java.util.LinkedList; // Import the LinkedList class

Queue<Integer> queue = new LinkedList<>(); // Create a new queue of integers
queue.add(1); // Add 1 to the back of the queue
queue.add(2); // Add 2 to the back of the queue
int front = queue.remove(); // Removes and returns the front element (1)
```

- `add(value)`: Adds a value to the back of the queue.
- `remove()`: Removes and returns the value at the front of the queue.
- `peek()`: Returns the value at the front without removing it.
- `isEmpty()`: Checks if the queue is empty.

---

## Practice: Analyzing Stack Code

### What does this method return?

This method tries to sum all the elements in a stack, but it has a logical error. Let's annotate and explain:

```java
// numbers: bottom [1, 2, 3, 4, 5] top
public static int sum(Stack<Integer> numbers) {
   int total = 0;
   for (int i = 0; i < numbers.size(); i++) { // Loop over the stack size
      int number = numbers.pop(); // Remove the top element
      total += number; // Add it to the total
      numbers.push(number); // Put it back on top
   }
   return total;
}
```

**Explanation:**
- This code will not work as intended. Popping and pushing the same element repeatedly just keeps the same element on top, and the stack size changes as you pop elements. This can cause an infinite loop or incorrect results.

#### Correct way to sum a stack (with annotations):

```java
public static int sum(Stack<Integer> numbers) {
    Stack<Integer> temp = new Stack<>(); // Temporary stack to hold elements
    int total = 0;
    while (!numbers.isEmpty()) { // While the stack is not empty
        int num = numbers.pop(); // Pop the top element
        total += num; // Add it to the total
        temp.push(num); // Push it onto the temporary stack
    }
    // Restore the original stack
    while (!temp.isEmpty()) {
        numbers.push(temp.pop()); // Move elements back to the original stack
    }
    return total; // Return the sum
}
```

- This method sums all elements and restores the original stack order.

---

### Practice: Using a Queue as Auxiliary Storage

This method also tries to sum a stack, but uses a queue as a helper. Let's annotate and explain:

```java
// numbers: bottom [1, 2, 3, 4, 5] top
public static int sum(Stack<Integer> numbers) {
   Queue<Integer> q = new LinkedList<>(); // Create a queue for temporary storage
   int total = 0;
   for (int i = 0; i < numbers.size(); i++) { // Loop over the stack size
      int number = numbers.pop(); // Remove the top element
      total += number; // Add it to the total
      q.add(number); // Add it to the queue
   }
   return total;
}
```

**Explanation:**
- This code also has issues: the stack size changes as you pop elements, so not all elements may be processed. The original stack is not restored.

#### Correct way to sum a stack using a queue (with annotations):

```java
public static int sum(Stack<Integer> numbers) {
    Queue<Integer> q = new LinkedList<>(); // Temporary queue
    int total = 0;
    while (!numbers.isEmpty()) {
        int num = numbers.pop(); // Pop from stack
        total += num; // Add to total
        q.add(num); // Add to queue
    }
    // Restore stack order using another stack
    Stack<Integer> temp = new Stack<>();
    while (!q.isEmpty()) {
        temp.push(q.remove()); // Move from queue to temp stack
    }
    while (!temp.isEmpty()) {
        numbers.push(temp.pop()); // Restore original stack
    }
    return total;
}
```

- This method sums all elements and restores the original stack order using a queue and a temporary stack.

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

This method reverses a stack by moving its elements to a queue and then back to the stack. Each step is annotated:

```java
public static void reverseStack(Stack<Integer> stack) {
    Queue<Integer> queue = new LinkedList<>(); // Create a queue
    while (!stack.isEmpty()) {
        queue.add(stack.pop()); // Pop from stack and add to queue
    }
    while (!queue.isEmpty()) {
        stack.push(queue.remove()); // Remove from queue and push back to stack
    }
}
```

- After this method, the stack will have its elements in reverse order.

### Cycling a Queue

This method prints each element in a queue without changing its order:

```java
public static void printQueue(Queue<Integer> queue) {
    int size = queue.size(); // Get the original size
    for (int i = 0; i < size; i++) {
        int val = queue.remove(); // Remove from front
        System.out.println(val); // Print the value
        queue.add(val); // Add it back to the end
    }
}
```

- This technique is useful for inspecting all elements in a queue while keeping their order unchanged.

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

### Java Code Example (with annotations)

```java
public static Stack<Integer> copyStack(Stack<Integer> s) {
    Queue<Integer> q = new LinkedList<>(); // Temporary queue
    Stack<Integer> copy = new Stack<>(); // Stack to hold the copy
    // Step 1: Move all to queue (reverses order)
    while (!s.isEmpty()) {
        q.add(s.pop()); // Pop from stack, add to queue
    }
    // Step 2: Move back to stack (restores original order)
    while (!q.isEmpty()) {
        s.push(q.remove()); // Remove from queue, push to stack
    }
    // Step 3: Copy to new stack and queue
    while (!s.isEmpty()) {
        int val = s.pop(); // Pop from stack
        copy.push(val); // Push to copy stack
        q.add(val); // Add to queue
    }
    // Step 4: Restore original stack
    while (!q.isEmpty()) {
        s.push(q.remove()); // Restore original stack
    }
    return copy; // Return the copy
}
```

- This method creates a new stack with the same elements in the same order, and restores the original stack.

---

## Exceptions in Java

Exceptions are used to signal errors or unexpected conditions. Throwing an exception stops normal execution and transfers control to the nearest catch block.

### Example: Throwing an Exception (with annotation)

```java
if (input < 0) { // Check for invalid input
    throw new IllegalArgumentException("Input must be non-negative"); // Throw an exception with a message
}
```

- Use exceptions to handle invalid input or unexpected situations in your code.
- This helps your program "fail fast" and makes debugging easier.

---

## spliceStack

**Problem:**
Write a method `spliceStack` that takes a stack of integers `s`, a start position `i`, and an ending position `j`, and removes a sequence of elements from `s` starting at the i’th element from the bottom up to (but not including) the j’th element from the bottom, returning these values in a new stack. The order of elements in both stacks should be preserved.

### Step-by-Step Solution
1. Use a queue to temporarily hold elements as you pop them off the stack.
2. As you process, identify elements in the range `[i, j)` and push them onto the new stack.
3. Restore the original stack from the queue.

### Java Code Example (with annotations)

```java
public static Stack<Integer> spliceStack(Stack<Integer> s, int i, int j) {
    Queue<Integer> q = new LinkedList<>(); // Temporary queue
    Stack<Integer> result = new Stack<>(); // Stack to hold spliced elements
    int size = s.size(); // Get the original size
    // Step 1: Move all to queue (bottom to top)
    while (!s.isEmpty()) {
        q.add(s.pop()); // Pop from stack, add to queue
    }
    // Step 2: Move back to stack, splicing as needed
    for (int idx = 0; idx < size; idx++) {
        int val = q.remove(); // Remove from queue
        if (idx >= i && idx < j) {
            result.push(val); // If in range, add to result stack
        } else {
            s.push(val); // Otherwise, restore to original stack
        }
    }
    // Step 3: Restore order of original stack
    while (!s.isEmpty()) {
        q.add(s.pop()); // Pop from stack, add to queue
    }
    while (!q.isEmpty()) {
        s.push(q.remove()); // Restore original stack
    }
    return result; // Return the spliced stack
}
```

- This method removes a range of elements from the stack and returns them in a new stack, while preserving the order of both stacks.

---

Feel free to experiment with these examples and modify them to deepen your understanding of stacks and queues in Java!
