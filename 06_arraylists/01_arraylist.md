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
import java.util.ArrayList; // Import the ArrayList class

// Create an ArrayList to store Strings
ArrayList<String> words = new ArrayList<String>(); // The type in <> must match the type of elements you want to store
words.add("hello"); // Adds "hello" to the end of the list
words.add("world"); // Adds "world" to the end of the list
System.out.println(words); // Output: [hello, world]

// Create an ArrayList to store Integers
ArrayList<Integer> numbers = new ArrayList<Integer>(); // Use Integer, not int
numbers.add(42); // Adds 42 to the list
numbers.add(7); // Adds 7 to the list
System.out.println(numbers); // Output: [42, 7]
```
**Notes:**
- The type inside the angle brackets `< >` is called a "generic type parameter". It ensures all elements are of the same type.
- You cannot use primitive types (like `int`, `double`) directly in an ArrayList. Use their wrapper classes (`Integer`, `Double`, etc.).

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
int[] arr = new int[3]; // Array of size 3
arr[0] = 10; // Set first element
arr[1] = 20; // Set second element
arr[2] = 30; // Set third element
// arr[3] = 40; // ERROR: ArrayIndexOutOfBoundsException

// ArrayList
ArrayList<Integer> list = new ArrayList<Integer>(); // Start with empty list
list.add(10); // Add 10
list.add(20); // Add 20
list.add(30); // Add 30
list.add(40); // Add 40 (no error, list grows automatically)
```
**Key Point:** Arrays have a fixed size, but ArrayLists can grow as needed.

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
ArrayList<Integer> list = new ArrayList<Integer>(); // Create an empty list
list.add(4);    // [4]
list.add(8);    // [4, 8]
list.add(16);   // [4, 8, 16]
list.add(23);   // [4, 8, 16, 23]
list.add(42);   // [4, 8, 16, 23, 42]
System.out.println(list); // [4, 8, 16, 23, 42]
System.out.println(list.size()); // 5

list.add(2, 15); // Insert 15 at index 2 (shifts later elements right)
// Now: [4, 8, 15, 16, 23, 42]
System.out.println(list);
System.out.println(list.size()); // 6

int value = list.get(3); // Get element at index 3 (16)
System.out.println(value); // 16

boolean has42 = list.contains(42); // true
int idx = list.indexOf(15); // 2
int removed = list.remove(1); // Removes 8 at index 1, returns 8
System.out.println(list); // [4, 15, 16, 23, 42]
```
**Tip:** Indexing starts at 0. Adding at an index shifts later elements right.

---

## Practice: Method Description

**Question:**
What is the best “plain English” description of this method?

```java
public static void method(ArrayList<Double> list) {
    for (int i = 0; i < list.size(); i++) { // Loop from 0 to last index
        System.out.println(" " + i + ") " + list.get(i)); // Print index and value
    }
}
```
**Explanation:**
- This method prints each element of the list, one per line, with its index in parentheses.
- The loop uses `i < list.size()` so it covers all valid indices.
- `list.get(i)` fetches the element at index `i`.

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
    ArrayList<String> lines = new ArrayList<>(); // Create empty list
    while (scanner.hasNextLine()) { // While there are more lines
        lines.add(scanner.nextLine()); // Add each line to the list
    }
    return lines; // Return the filled list
}
```
**Explanation:**
- The method reads every line from the Scanner and stores it in an ArrayList.
- Useful for reading all lines from a file into a list for further processing.

---

## Practice: moveRight

**Task:**
Write a method called `moveRight` that accepts an `ArrayList<Integer> list` and an `int n` and moves the element at index `n` one space to the right in the list.

### Example
```java
ArrayList<Integer> list = new ArrayList<>(Arrays.asList(8, 4, 13, -7));
moveRight(list, 2); // Move element at index 2 (13) to the right
System.out.println(list); // Output: [8, 4, -7, 13]
```

### Java Implementation
```java
import java.util.ArrayList;

public static void moveRight(ArrayList<Integer> list, int n) {
    // Check for valid index: can't move last element right or use negative index
    if (n < 0 || n >= list.size() - 1) {
        System.out.println("Index out of bounds or cannot move last element right.");
        return;
    }
    int element = list.remove(n); // Remove element at index n
    list.add(n + 1, element);     // Insert it back at index n+1
}
```
**Explanation:**
- Removes the element at index `n` and reinserts it one position to the right.
- If `n` is the last index or negative, nothing happens (with a warning).
- This is a common pattern for moving elements in a list.

**Edge Cases:**
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
    for (int i = 0; i < list1.size(); i++) { // Loop through list1
        int value = list1.get(i); // Get value from list1
        int j = list2.indexOf(value); // Find index of value in list2
        if (j != -1) { // If found in list2
            System.out.println("- " + value + " (list1 at " + i + ", list2 at " + j + ")");
        }
    }
}
```
**Explanation:**
- For each element in `list1`, checks if it exists in `list2`.
- If found, prints the value and its indices in both lists.
- Uses `indexOf` to find the first occurrence in `list2`.

**Note:** If a value appears multiple times in either list, only the first match in `list2` is reported.

---

## Practice: topN

**Task:**
Write a method called `topN` that accepts an `ArrayList<Character> list` and an `int n` and returns a new `ArrayList<Character>` containing the first `n` elements of `list`.

### Example
```java
ArrayList<Character> list = new ArrayList<>(Arrays.asList('m', 'a', 't', 'i', 'l', 'd', 'a'));
ArrayList<Character> result = topN(list, 4); // Get first 4 elements
System.out.println(result); // Output: [m, a, t, i]
```

### Java Implementation
```java
import java.util.ArrayList;

public static ArrayList<Character> topN(ArrayList<Character> list, int n) {
    ArrayList<Character> result = new ArrayList<>(); // New list for result
    for (int i = 0; i < n && i < list.size(); i++) { // Only up to n or list size
        result.add(list.get(i)); // Add element to result
    }
    return result;
}
```
**Explanation:**
- Copies the first `n` elements from `list` into a new ArrayList.
- If `n` is greater than the list size, it just copies all elements.

---

## Practice: addAll

**Task:**
Write a method called `addAll` that accepts two `ArrayList<Character>`s (`list1`, `list2`) and an integer `location`, and inserts all elements from `list2` into `list1` at the specified location.

### Example
```java
ArrayList<Character> list1 = new ArrayList<>(Arrays.asList('a', 'b', 'c'));
ArrayList<Character> list2 = new ArrayList<>(Arrays.asList('x', 'y'));
addAll(list1, list2, 1); // Insert list2 at index 1
System.out.println(list1); // Output: [a, x, y, b, c]
```

### Java Implementation
```java
import java.util.ArrayList;

public static void addAll(ArrayList<Character> list1, ArrayList<Character> list2, int location) {
    // Check for valid location (0 to list1.size())
    if (location < 0 || location > list1.size()) {
        System.out.println("Invalid location");
        return;
    }
    list1.addAll(location, list2); // Insert all elements from list2 at location
}
```
**Explanation:**
- Uses the built-in `addAll` method to insert all elements from `list2` into `list1` at the specified index.
- If the location is invalid (negative or too large), prints a warning and does nothing.

---

## Tips and Best Practices
- **Always check for edge cases:** For example, invalid indices, empty lists, or null values.
- **Use wrapper classes for primitives:** ArrayLists can't store primitives directly.
- **Use enhanced for-loops** for simple traversals when you don't need the index:
  ```java
  for (String word : words) {
      System.out.println(word);
  }
  ```
- **Prefer `ArrayList` over arrays** when you need dynamic sizing or lots of insertions/removals.
- **Remember indexing starts at 0!**
- **Be careful with remove/add in loops:** Modifying a list while looping over it can cause bugs.

---

For more details, see the [Java ArrayList documentation](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html).
