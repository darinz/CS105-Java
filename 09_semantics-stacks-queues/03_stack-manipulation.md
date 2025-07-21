# Stack Manipulation

Stacks are a fundamental data structure in computer science, following the Last-In-First-Out (LIFO) principle. In Java, stacks are commonly used for tasks such as parsing expressions, backtracking algorithms, undo mechanisms, and more.

## What is a Stack?
A stack is a collection where elements are added and removed from only one end, called the "top" of the stack. The most recently added element is the first to be removed.

**Analogy:** Think of a stack of plates. You add (push) new plates to the top, and you also remove (pop) plates from the top. You can't remove a plate from the middle or the bottom without first removing the ones above it.

## Java's Stack Class
Java provides a built-in `Stack` class in the `java.util` package. It extends `Vector` and provides standard stack operations:

- `push(E item)`: Adds an item to the top of the stack.
- `pop()`: Removes and returns the item at the top of the stack.
- `peek()`: Returns the item at the top without removing it.
- `isEmpty()`: Checks if the stack is empty.
- `search(Object o)`: Returns the 1-based position from the top of the stack, or -1 if not found.

### Importing Stack
```java
import java.util.Stack; // Import the Stack class from java.util
```

## Basic Stack Operations in Java

### 1. Creating a Stack
```java
Stack<Integer> stack = new Stack<>(); // Creates an empty stack that holds Integer values
```
**Explanation:**
- `Stack<Integer>`: The stack will store integers.
- `new Stack<>()`: Creates a new, empty stack.

### 2. Pushing Elements
```java
stack.push(10); // Add 10 to the top of the stack
stack.push(20); // Add 20 to the top
stack.push(30); // Add 30 to the top
System.out.println(stack); // Output: [10, 20, 30]
```
**Explanation:**
- Each `push` adds a new element to the top.
- The stack now looks like: bottom [10, 20, 30] top

### 3. Popping Elements
```java
int top = stack.pop(); // Removes and returns the top element (30)
System.out.println(top); // Output: 30
System.out.println(stack); // Output: [10, 20]
```
**Explanation:**
- `pop()` removes the most recently added element (top of the stack).
- After popping, the stack is [10, 20].

### 4. Peeking at the Top Element
```java
int peeked = stack.peek(); // Returns the top element (20) without removing it
System.out.println(peeked); // Output: 20
System.out.println(stack); // Output: [10, 20]
```
**Explanation:**
- `peek()` lets you see what's on top without changing the stack.

### 5. Checking if the Stack is Empty
```java
System.out.println(stack.isEmpty()); // Output: false (stack has elements)
stack.pop(); // Removes 20
stack.pop(); // Removes 10
System.out.println(stack.isEmpty()); // Output: true (stack is now empty)
```
**Explanation:**
- `isEmpty()` returns `true` if there are no elements in the stack.

### 6. Searching for an Element
```java
stack.push(100); // Stack: [100]
stack.push(200); // Stack: [100, 200]
stack.push(300); // Stack: [100, 200, 300]
System.out.println(stack.search(200)); // Output: 2 (200 is the 2nd from the top)
System.out.println(stack.search(400)); // Output: -1 (400 is not in the stack)
```
**Explanation:**
- `search(200)` returns 2 because 200 is the second element from the top (top is 1).
- If the element is not found, `search` returns -1.

## Example: Reversing a String Using a Stack
```java
import java.util.Stack;

public class ReverseString {
    // Method to reverse a string using a stack
    public static String reverse(String input) {
        Stack<Character> stack = new Stack<>(); // Create a stack for characters
        // Push each character of the string onto the stack
        for (char c : input.toCharArray()) {
            stack.push(c); // Add character to the top
        }
        StringBuilder reversed = new StringBuilder();
        // Pop characters from the stack to build the reversed string
        while (!stack.isEmpty()) {
            reversed.append(stack.pop()); // Remove from top and append
        }
        return reversed.toString(); // Return the reversed string
    }

    public static void main(String[] args) {
        String original = "hello";
        String reversed = reverse(original); // Call the reverse method
        System.out.println(reversed); // Output: olleh
    }
}
```
**Explanation:**
- Each character is pushed onto the stack, so the last character ends up on top.
- Popping characters gives them back in reverse order.
- This is a classic use of stacks for reversing data.

## Best Practices and Notes
- The `Stack` class is considered legacy. For new code, consider using `Deque` (e.g., `ArrayDeque`) for stack operations, as it is more efficient.
- Always check if the stack is empty before calling `pop()` or `peek()` to avoid `EmptyStackException`.
- Stacks are useful for problems involving recursion, undo/redo, parsing, and more.

## Using Deque as a Stack (Recommended)
```java
import java.util.ArrayDeque;
import java.util.Deque;

Deque<Integer> stack = new ArrayDeque<>(); // Create a stack using ArrayDeque
stack.push(1); // Add 1 to the top
stack.push(2); // Add 2 to the top
System.out.println(stack.pop()); // Output: 2 (removes and returns the top)
```
**Explanation:**
- `Deque` (double-ended queue) can be used as a stack with `push` and `pop` methods.
- `ArrayDeque` is faster and more modern than `Stack` for most use cases.

---

By understanding and practicing stack manipulation in Java, you can solve a wide range of algorithmic problems efficiently. Remember to use comments and break down each operation to make your code easy to read and maintain!