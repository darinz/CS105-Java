# Stack Manipulation

Stacks are a fundamental data structure in computer science, following the Last-In-First-Out (LIFO) principle. In Java, stacks are commonly used for tasks such as parsing expressions, backtracking algorithms, undo mechanisms, and more.

## What is a Stack?
A stack is a collection where elements are added and removed from only one end, called the "top" of the stack. The most recently added element is the first to be removed.

## Java's Stack Class
Java provides a built-in `Stack` class in the `java.util` package. It extends `Vector` and provides standard stack operations:

- `push(E item)`: Adds an item to the top of the stack.
- `pop()`: Removes and returns the item at the top of the stack.
- `peek()`: Returns the item at the top without removing it.
- `isEmpty()`: Checks if the stack is empty.
- `search(Object o)`: Returns the 1-based position from the top of the stack, or -1 if not found.

### Importing Stack
```java
import java.util.Stack;
```

## Basic Stack Operations in Java

### 1. Creating a Stack
```java
Stack<Integer> stack = new Stack<>();
```

### 2. Pushing Elements
```java
stack.push(10);
stack.push(20);
stack.push(30);
System.out.println(stack); // Output: [10, 20, 30]
```

### 3. Popping Elements
```java
int top = stack.pop(); // Removes 30
System.out.println(top); // Output: 30
System.out.println(stack); // Output: [10, 20]
```

### 4. Peeking at the Top Element
```java
int peeked = stack.peek(); // Does not remove
System.out.println(peeked); // Output: 20
System.out.println(stack); // Output: [10, 20]
```

### 5. Checking if the Stack is Empty
```java
System.out.println(stack.isEmpty()); // Output: false
stack.pop();
stack.pop();
System.out.println(stack.isEmpty()); // Output: true
```

### 6. Searching for an Element
```java
stack.push(100);
stack.push(200);
stack.push(300);
System.out.println(stack.search(200)); // Output: 2 (1-based from top)
System.out.println(stack.search(400)); // Output: -1 (not found)
```

## Example: Reversing a String Using a Stack
```java
import java.util.Stack;

public class ReverseString {
    public static String reverse(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        String original = "hello";
        String reversed = reverse(original);
        System.out.println(reversed); // Output: olleh
    }
}
```

## Best Practices and Notes
- The `Stack` class is considered legacy. For new code, consider using `Deque` (e.g., `ArrayDeque`) for stack operations, as it is more efficient.
- Always check if the stack is empty before calling `pop()` or `peek()` to avoid `EmptyStackException`.
- Stacks are useful for problems involving recursion, undo/redo, parsing, and more.

## Using Deque as a Stack (Recommended)
```java
import java.util.ArrayDeque;
import java.util.Deque;

Deque<Integer> stack = new ArrayDeque<>();
stack.push(1);
stack.push(2);
System.out.println(stack.pop()); // Output: 2
```

---

By understanding and practicing stack manipulation in Java, you can solve a wide range of algorithmic problems efficiently.