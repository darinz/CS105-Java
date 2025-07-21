# ArrayList

## What is an ArrayList?

An **ArrayList** in Java is a resizable array-like data structure that is part of the `java.util` package. Unlike regular arrays, which have a fixed size, ArrayLists can grow or shrink dynamically as you add or remove elements. This makes them very useful when you don't know in advance how many items you'll need to store.

### Key Features
- **Dynamic Sizing:** Automatically resizes as elements are added or removed.
- **Zero-based Indexing:** The first element is at index 0, just like arrays.
- **Type Safety:** All elements must be of the same type, specified using Java Generics.
- **Object Storage:** ArrayLists can only store objects, not primitive types. For primitives, use wrapper classes (e.g., `Integer` for `int`, `Double` for `double`).

### Declaring and Using an ArrayList
```java
import java.util.ArrayList;

// Create an ArrayList to store Strings
ArrayList<String> words = new ArrayList<String>();
words.add("hello");
words.add("world");
System.out.println(words); // Output: [hello, world]

// Create an ArrayList to store Integers
ArrayList<Integer> numbers = new ArrayList<Integer>();
numbers.add(42);
numbers.add(7);
System.out.println(numbers); // Output: [42, 7]
```

---

## Array vs. ArrayList

| Feature         | Array                | ArrayList                |
|----------------|----------------------|--------------------------|
| Size           | Fixed                | Dynamic (resizable)      |
| Syntax         | `int[] arr = ...;`   | `ArrayList<Integer> ...` |
| Primitives     | Yes                  | No (use wrappers)        |
| Methods        | None (except length) | Many built-in methods    |

**Example:**
```java
// Array
int[] arr = new int[3];
arr[0] = 10;
arr[1] = 20;
arr[2] = 30;

// ArrayList
ArrayList<Integer> list = new ArrayList<Integer>();
list.add(10);
list.add(20);
list.add(30);
```

---

## Common ArrayList Methods (with Examples)

| Method                        | Description                                      | Example Usage                                  |
|-------------------------------|--------------------------------------------------|-------------------------------------------------|
| `add(element)`                | Adds element to the end                          | `list.add(5);`                                  |
| `add(index, element)`         | Inserts element at specified index               | `list.add(2, 15);`                              |
| `size()`                      | Returns number of elements                       | `int n = list.size();`                          |
| `contains(element)`           | Checks if element exists                         | `list.contains(42);`                            |
| `get(index)`                  | Gets element at index                            | `int x = list.get(0);`                          |
| `remove(index)`               | Removes and returns element at index             | `int y = list.remove(1);`                       |
| `indexOf(element)`            | Returns index of element, or -1 if not found     | `int idx = list.indexOf(15);`                   |
| `set(index, element)`         | Replaces element at index, returns old value     | `int old = list.set(0, 99);`                    |

### Example:
```java
ArrayList<Integer> list = new ArrayList<Integer>();
list.add(4);
list.add(8);
list.add(16);
list.add(23);
list.add(42);
System.out.println(list); // [4, 8, 16, 23, 42]
System.out.println(list.size()); // 5

list.add(2, 15); // Insert 15 at index 2
System.out.println(list); // [4, 8, 15, 16, 23, 42]
System.out.println(list.size()); // 6
```

---

## Practice: Method Description

**Question:**
What is the best “plain English” description of this method?

```java
public static void method(ArrayList<Double> list) {
    for (int i = 0; i < list.size(); i++) {
        System.out.println(" " + i + ") " + list.get(i));
    }
}
```

**Answer:**
B) Prints out the list from front to back, with elements numbered 0, 1, 2, …

---

## Practice: loadFromFile

**Task:**
Write a method called `loadFromFile` that accepts a `Scanner` as a parameter and returns a new `ArrayList<String>` where each element is a line from the Scanner.

### Example Usage
Suppose the file contains:
```
apple
banana
carrot
```
Then `loadFromFile(scanner)` returns `["apple", "banana", "carrot"]`.

### Java Implementation
```java
import java.util.ArrayList;
import java.util.Scanner;

public static ArrayList<String> loadFromFile(Scanner scanner) {
    ArrayList<String> lines = new ArrayList<>();
    while (scanner.hasNextLine()) {
        lines.add(scanner.nextLine());
    }
    return lines;
}
```

---

## Practice: moveRight

**Task:**
Write a method called `moveRight` that accepts an `ArrayList<Integer> list` and an `int n` and moves the element at index `n` one space to the right in the list.

### Example
```java
ArrayList<Integer> list = new ArrayList<>(Arrays.asList(8, 4, 13, -7));
moveRight(list, 2);
System.out.println(list); // Output: [8, 4, -7, 13]
```

### Java Implementation
```java
import java.util.ArrayList;

public static void moveRight(ArrayList<Integer> list, int n) {
    // Check for valid index
    if (n < 0 || n >= list.size() - 1) {
        System.out.println("Index out of bounds or cannot move last element right.");
        return;
    }
    int element = list.remove(n);
    list.add(n + 1, element);
}
```

### Edge Cases
- If `n` is negative or `n` is the last index, the method does nothing and prints a warning.
- If the list is empty, nothing happens.

---

## Practice: compareToList

**Task:**
Write a method called `compareToList` that accepts two `ArrayList<Integer>`s and prints the locations of common elements in each list.

### Example
```java
ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(5, 6, 7, 8));
ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(7, 5, 9, 0, 2));
compareToList(list1, list2);
// Output:
// - 5 (list1 at 0, list2 at 1)
// - 7 (list1 at 2, list2 at 0)
```

### Java Implementation
```java
import java.util.ArrayList;

public static void compareToList(ArrayList<Integer> list1, ArrayList<Integer> list2) {
    for (int i = 0; i < list1.size(); i++) {
        int value = list1.get(i);
        int j = list2.indexOf(value);
        if (j != -1) {
            System.out.println("- " + value + " (list1 at " + i + ", list2 at " + j + ")");
        }
    }
}
```

---

## Practice: topN

**Task:**
Write a method called `topN` that accepts an `ArrayList<Character> list` and an `int n` and returns a new `ArrayList<Character>` containing the first `n` elements of `list`.

### Example
```java
ArrayList<Character> list = new ArrayList<>(Arrays.asList('m', 'a', 't', 'i', 'l', 'd', 'a'));
ArrayList<Character> result = topN(list, 4);
System.out.println(result); // Output: [m, a, t, i]
```

### Java Implementation
```java
import java.util.ArrayList;

public static ArrayList<Character> topN(ArrayList<Character> list, int n) {
    ArrayList<Character> result = new ArrayList<>();
    for (int i = 0; i < n && i < list.size(); i++) {
        result.add(list.get(i));
    }
    return result;
}
```

---

## Practice: addAll

**Task:**
Write a method called `addAll` that accepts two `ArrayList<Character>`s (`list1`, `list2`) and an integer `location`, and inserts all elements from `list2` into `list1` at the specified location.

### Example
```java
ArrayList<Character> list1 = new ArrayList<>(Arrays.asList('a', 'b', 'c'));
ArrayList<Character> list2 = new ArrayList<>(Arrays.asList('x', 'y'));
addAll(list1, list2, 1);
System.out.println(list1); // Output: [a, x, y, b, c]
```

### Java Implementation
```java
import java.util.ArrayList;

public static void addAll(ArrayList<Character> list1, ArrayList<Character> list2, int location) {
    if (location < 0 || location > list1.size()) {
        System.out.println("Invalid location");
        return;
    }
    list1.addAll(location, list2);
}
```

---

## Tips and Best Practices
- Always check for edge cases (e.g., invalid indices, empty lists).
- Use wrapper classes for primitives in ArrayLists.
- Use enhanced for-loops for simple traversals when you don't need the index.
- Prefer `ArrayList` over arrays when you need dynamic sizing or lots of insertions/removals.

---

For more details, see the [Java ArrayList documentation](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html).
