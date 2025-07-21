# Practice, Reviews, and Applications

- More practice, reviews, applications
- Preparation for practice reivew quizes and exams

---

## Problem 1: Remove All Occurrences

Write a method called `removeAllOccurrences` that takes an `ArrayList<String>` and a `String target`, and removes all occurrences of `target` from the list. The method should return the number of elements removed.

**Example:**
```java
ArrayList<String> words = new ArrayList<>(Arrays.asList("apple", "banana", "apple", "carrot", "apple"));
int removed = removeAllOccurrences(words, "apple");
System.out.println(words); // Output: [banana, carrot]
System.out.println(removed); // Output: 3
```

**Solution:**
```java
public static int removeAllOccurrences(ArrayList<String> list, String target) {
    int count = 0;
    for (int i = list.size() - 1; i >= 0; i--) {
        if (list.get(i).equals(target)) {
            list.remove(i);
            count++;
        }
    }
    return count;
}
```
**Explanation:**
- Looping backwards avoids skipping elements after removal.
- Each time `target` is found, it is removed and the count is incremented.
- The method returns the total number of elements removed.

---

## Problem 2: Unique Elements

Write a method `uniqueElements` that takes an `ArrayList<Integer>` and returns a new `ArrayList<Integer>` containing only the unique elements from the original list, in the order they first appear.

**Example:**
```java
ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(2, 3, 2, 4, 3, 5));
ArrayList<Integer> unique = uniqueElements(nums);
System.out.println(unique); // Output: [2, 3, 4, 5]
```

**Solution:**
```java
public static ArrayList<Integer> uniqueElements(ArrayList<Integer> list) {
    ArrayList<Integer> result = new ArrayList<>();
    for (Integer num : list) {
        if (!result.contains(num)) {
            result.add(num);
        }
    }
    return result;
}
```
**Explanation:**
- For each element, check if it is already in the result list.
- If not, add it. This preserves the order of first appearance.

---

## Problem 3: Insert After Every Occurrence

Write a method `insertAfterEvery` that takes an `ArrayList<String> list`, a `String target`, and a `String toInsert`. Insert `toInsert` immediately after every occurrence of `target` in the list.

**Example:**
```java
ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "b", "a", "c"));
insertAfterEvery(list, "a", "z");
System.out.println(list); // Output: [a, z, b, a, z, c]
```

**Solution:**
```java
public static void insertAfterEvery(ArrayList<String> list, String target, String toInsert) {
    for (int i = 0; i < list.size(); i++) {
        if (list.get(i).equals(target)) {
            list.add(i + 1, toInsert);
            i++; // Skip over the inserted element
        }
    }
}
```
**Explanation:**
- When `target` is found, insert `toInsert` right after it.
- Increment `i` to skip the newly inserted element and avoid infinite loops.

---

## Problem 4: Menu-Driven List Manager

Write a simple menu-driven program that allows the user to add, remove, and print elements in an `ArrayList<String>`. The menu should repeat until the user chooses to exit.

**Example Menu:**
```
1. Add element
2. Remove element by value
3. Print list
4. Exit
```

**Solution:**
```java
import java.util.*;

public static void listManager() {
    ArrayList<String> list = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    boolean running = true;
    while (running) {
        System.out.println("1. Add element");
        System.out.println("2. Remove element by value");
        System.out.println("3. Print list");
        System.out.println("4. Exit");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        if (choice == 1) {
            System.out.print("Enter value to add: ");
            String value = scanner.nextLine();
            list.add(value);
        } else if (choice == 2) {
            System.out.print("Enter value to remove: ");
            String value = scanner.nextLine();
            list.remove(value);
        } else if (choice == 3) {
            System.out.println(list);
        } else if (choice == 4) {
            running = false;
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
```
**Explanation:**
- Uses a loop to repeatedly show the menu and process user input.
- Allows adding, removing, and printing elements interactively.

---

## Problem 5: Move Minimum to Front

Write a method `moveMinToFront` that takes an `ArrayList<Integer>` and moves the smallest element to the front of the list. If there are multiple occurrences, only move the first one found.

**Example:**
```java
ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(5, 3, 8, 2, 7));
moveMinToFront(nums);
System.out.println(nums); // Output: [2, 5, 3, 8, 7]
```

**Solution:**
```java
public static void moveMinToFront(ArrayList<Integer> list) {
    if (list.isEmpty()) return;
    int min = list.get(0);
    int minIndex = 0;
    for (int i = 1; i < list.size(); i++) {
        if (list.get(i) < min) {
            min = list.get(i);
            minIndex = i;
        }
    }
    if (minIndex != 0) {
        list.remove(minIndex);
        list.add(0, min);
    }
}
```
**Explanation:**
- Finds the minimum value and its index.
- Removes it from its current position and inserts it at the front.
- If the minimum is already at the front, nothing changes.
