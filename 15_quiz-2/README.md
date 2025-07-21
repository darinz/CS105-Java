# Quiz 2

## Quiz 2: Coding Problems with Annotations

**Instructions:**
- This quiz consists of 5 questions, one from each topic: Reference Semantics, Stacks, Queues, Sets, and Maps.
- You have 45 minutes to complete the quiz.
- Write your answers clearly. You may use Java syntax or pseudocode if you are unsure of exact syntax.

---

### 1. Reference Semantics

**Question:**
Consider the following Java code:

```java
int[] a = {1, 2, 3};
int[] b = a;
b[0] = 10;
System.out.println(a[0]);
```

**a)** What value is printed?
**b)** Briefly explain why.

> **Annotation:**
> - In Java, arrays are reference types. Assigning `b = a` means both `a` and `b` refer to the same array in memory. Changing `b[0]` also changes `a[0]`.

---

### 2. Stacks

**Question:**
Write a Java method that takes a `Stack<Integer>` as input and returns the sum of all elements in the stack, leaving the stack unchanged after the operation.

> **Annotation:**
> - Remember, popping elements from a stack removes them. To leave the stack unchanged, you can use a temporary stack to hold elements as you sum them, then push them back.

---

### 3. Queues

**Question:**
Suppose you have a `Queue<String>` containing the elements `"A"`, `"B"`, `"C"` (in that order, front to back).
Write the sequence of operations (using `add`, `remove`, and `peek`) needed to remove `"B"` from the queue, so that the queue contains `"A"` and `"C"` in the correct order.

> **Annotation:**
> - Queues are FIFO (First-In, First-Out). You cannot directly remove an element from the middle. Think about using a loop and a temporary queue to filter out `"B"`.

---

### 4. Sets

**Question:**
Write a Java code snippet that creates a `HashSet<String>`, adds the strings `"apple"`, `"banana"`, `"apple"`, and `"cherry"` to it, and then prints the size of the set.
What value is printed, and why?

> **Annotation:**
> - Sets do not allow duplicate elements. Adding `"apple"` twice only keeps one copy. The size will reflect the number of unique elements.

---

### 5. Maps

**Question:**
Given the following code:

```java
Map<String, Integer> scores = new HashMap<>();
scores.put("Alice", 90);
scores.put("Bob", 85);
scores.put("Alice", 95);
System.out.println(scores.get("Alice"));
```

**a)** What value is printed?
**b)** Briefly explain what happens when you put a value for a key that already exists in a map.

> **Annotation:**
> - In a map, if you put a value for a key that already exists, the old value is replaced by the new one. Only the latest value for each key is stored.
