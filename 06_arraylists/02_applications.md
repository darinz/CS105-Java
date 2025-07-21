# ArrayList Applications

## Introduction to ArrayList in Java

An `ArrayList` in Java is a resizable array, part of the `java.util` package. Unlike regular arrays, `ArrayList` can grow or shrink in size dynamically, making it very useful for managing collections of data where the number of elements can change.

**Example:**
```java
import java.util.ArrayList;

ArrayList<String> bakeries = new ArrayList<>();
bakeries.add("Sweet Treats");
bakeries.add("Bread & Butter");
System.out.println(bakeries); // Output: [Sweet Treats, Bread & Butter]
```

---

## Functional Decomposition

Functional decomposition is the process of breaking down a complex problem into smaller, manageable functions or methods. In Java, this means writing separate methods for each operation your program needs to perform. This makes your code easier to read, test, and maintain.

**Example:**
```java
public static void addBakery(ArrayList<String> bakeries, String name) {
    bakeries.add(name);
}
```

---

## User Interaction (UI) Loop

A UI loop allows the user to interact with the program repeatedly until they choose to exit. In Java, this is often done using a `while` loop and a `Scanner` for input.

**Example:**
```java
import java.util.Scanner;

Scanner scanner = new Scanner(System.in);
boolean running = true;
while (running) {
    System.out.println("1. Add bakery\n2. Exit");
    int choice = scanner.nextInt();
    scanner.nextLine(); // consume newline
    if (choice == 1) {
        System.out.print("Enter bakery name: ");
        String name = scanner.nextLine();
        addBakery(bakeries, name);
    } else if (choice == 2) {
        running = false;
    }
}
```

---

## Practice with ArrayList Methods

Some useful `ArrayList` methods:
- `add(element)`: Adds an element to the end.
- `add(index, element)`: Inserts at a specific position.
- `remove(index)`: Removes element at index.
- `get(index)`: Retrieves element at index.
- `set(index, element)`: Replaces element at index.
- `size()`: Returns the number of elements.

**Example:**
```java
bakeries.add(1, "Cake Corner"); // Insert at index 1
bakeries.remove(0); // Remove first bakery
String topBakery = bakeries.get(0); // Get first bakery
```

---

# Bakery Favorites: Operations (with Java Examples)

### 1. Load a list of favorites from a file
```java
import java.io.*;
public static ArrayList<String> loadFromFile(String filename) throws IOException {
    ArrayList<String> list = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    String line;
    while ((line = reader.readLine()) != null) {
        list.add(line);
    }
    reader.close();
    return list;
}
```

### 2. Compare the stored list to another list from a file
```java
public static void compareLists(ArrayList<String> list1, ArrayList<String> list2) {
    for (String bakery : list1) {
        if (list2.contains(bakery)) {
            System.out.println(bakery + " is in both lists.");
        }
    }
}
```

### 3. Report the top n favorites
```java
public static void printTopN(ArrayList<String> list, int n) {
    for (int i = 0; i < n && i < list.size(); i++) {
        System.out.println((i+1) + ". " + list.get(i));
    }
}
```

### 4. Move a specific favorite down in the list
```java
public static void moveDown(ArrayList<String> list, int index) {
    if (index < list.size() - 1) {
        String temp = list.get(index);
        list.set(index, list.get(index + 1));
        list.set(index + 1, temp);
    }
}
```

### 5. Add a list of favorites from a file at a specified location
```java
public static void addFromFileAt(ArrayList<String> list, String filename, int index) throws IOException {
    ArrayList<String> newItems = loadFromFile(filename);
    list.addAll(index, newItems);
}
```

### 6. Save the current list to a file
```java
public static void saveToFile(ArrayList<String> list, String filename) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
    for (String bakery : list) {
        writer.write(bakery);
        writer.newLine();
    }
    writer.close();
}
```

---

# Bakery Favorites: Development Strategy

1. **Set up the main scaffold code**: Create the main class and `main` method.
2. **Menu loop**: Implement a loop to show options and get user input.
3. **Develop each operation, one at a time**: Write and test each method separately.

**Scaffold Example:**
```java
public class BakeryFavorites {
    public static void main(String[] args) throws IOException {
        ArrayList<String> favorites = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        // Menu loop and operations go here
    }
}
```

---

By breaking down the program into small, testable methods and using `ArrayList` effectively, you can build a flexible and user-friendly application!
