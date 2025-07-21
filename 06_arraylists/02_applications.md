# ArrayList Applications

## Introduction to ArrayList in Java

An `ArrayList` in Java is a resizable array, part of the `java.util` package. Unlike regular arrays, `ArrayList` can grow or shrink in size dynamically, making it very useful for managing collections of data where the number of elements can change.

**Example:**
```java
import java.util.ArrayList; // Import the ArrayList class

ArrayList<String> bakeries = new ArrayList<>(); // Create an empty ArrayList to store bakery names
bakeries.add("Sweet Treats"); // Add a bakery to the list
bakeries.add("Bread & Butter"); // Add another bakery
System.out.println(bakeries); // Output the list: [Sweet Treats, Bread & Butter]
```
*In this example, we create an ArrayList of Strings, add two bakery names, and print the list. ArrayLists automatically resize as you add or remove items.*

---

## Functional Decomposition

Functional decomposition is the process of breaking down a complex problem into smaller, manageable functions or methods. In Java, this means writing separate methods for each operation your program needs to perform. This makes your code easier to read, test, and maintain.

**Example:**
```java
// This method adds a bakery name to the list of bakeries
public static void addBakery(ArrayList<String> bakeries, String name) {
    bakeries.add(name); // Use the add method to insert the new bakery
}
```
*Here, the `addBakery` method takes an ArrayList and a String, and adds the String to the list. This is an example of breaking a task into a small, reusable function.*

---

## User Interaction (UI) Loop

A UI loop allows the user to interact with the program repeatedly until they choose to exit. In Java, this is often done using a `while` loop and a `Scanner` for input.

**Example:**
```java
import java.util.Scanner; // Import Scanner for user input

Scanner scanner = new Scanner(System.in); // Create a Scanner object
boolean running = true; // Control variable for the loop
while (running) { // Loop until the user chooses to exit
    System.out.println("1. Add bakery\n2. Exit"); // Show menu options
    int choice = scanner.nextInt(); // Read user choice (number)
    scanner.nextLine(); // Consume the leftover newline character
    if (choice == 1) {
        System.out.print("Enter bakery name: ");
        String name = scanner.nextLine(); // Read the bakery name
        addBakery(bakeries, name); // Add the bakery to the list
    } else if (choice == 2) {
        running = false; // Exit the loop
    }
}
```
*This code shows a simple menu, reads the user's choice, and performs actions based on the input. The loop continues until the user selects 'Exit'.*

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
bakeries.add(1, "Cake Corner"); // Insert "Cake Corner" at index 1
bakeries.remove(0); // Remove the first bakery (index 0)
String topBakery = bakeries.get(0); // Get the first bakery in the list
```
*These methods let you insert, remove, and access elements in the ArrayList. Indexing starts at 0 (the first element).* 

---

# Bakery Favorites: Operations (with Java Examples)

Below are the main operations for the Bakery Favorites program, each with annotated code examples.

### 1. Load a list of favorites from a file
```java
import java.io.*; // Import classes for file reading

// Reads bakery names from a file and returns them as an ArrayList
public static ArrayList<String> loadFromFile(String filename) throws IOException {
    ArrayList<String> list = new ArrayList<>(); // Create an empty list
    BufferedReader reader = new BufferedReader(new FileReader(filename)); // Open the file
    String line;
    while ((line = reader.readLine()) != null) { // Read each line until end of file
        list.add(line); // Add each line (bakery name) to the list
    }
    reader.close(); // Close the file
    return list; // Return the list of bakeries
}
```
*This method reads each line from a file and adds it to an ArrayList. Each line is assumed to be a bakery name.*

### 2. Compare the stored list to another list from a file
```java
// Prints bakeries that are present in both lists
public static void compareLists(ArrayList<String> list1, ArrayList<String> list2) {
    for (String bakery : list1) { // Go through each bakery in the first list
        if (list2.contains(bakery)) { // Check if it's also in the second list
            System.out.println(bakery + " is in both lists."); // Print if found in both
        }
    }
}
```
*This method compares two lists and prints out the bakeries that appear in both.*

### 3. Report the top n favorites
```java
// Prints the top n bakeries from the list
public static void printTopN(ArrayList<String> list, int n) {
    for (int i = 0; i < n && i < list.size(); i++) { // Loop up to n or the list size
        System.out.println((i+1) + ". " + list.get(i)); // Print the bakery with its rank
    }
}
```
*This method prints the first n bakeries in the list, or all if there are fewer than n.*

### 4. Move a specific favorite down in the list
```java
// Moves the bakery at the given index down by one position
public static void moveDown(ArrayList<String> list, int index) {
    if (index < list.size() - 1) { // Make sure it's not the last item
        String temp = list.get(index); // Store the bakery to move
        list.set(index, list.get(index + 1)); // Move the next bakery up
        list.set(index + 1, temp); // Place the stored bakery down one spot
    }
}
```
*This method swaps a bakery with the one below it, moving it down in the list.*

### 5. Add a list of favorites from a file at a specified location
```java
// Inserts bakeries from a file into the list at the given index
public static void addFromFileAt(ArrayList<String> list, String filename, int index) throws IOException {
    ArrayList<String> newItems = loadFromFile(filename); // Load new bakeries from file
    list.addAll(index, newItems); // Insert them at the specified index
}
```
*This method loads bakery names from a file and inserts them into the main list at a specific position.*

### 6. Save the current list to a file
```java
import java.io.*; // Import classes for file writing

// Writes all bakery names from the list to a file
public static void saveToFile(ArrayList<String> list, String filename) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(filename)); // Open the file for writing
    for (String bakery : list) { // Go through each bakery
        writer.write(bakery); // Write the bakery name
        writer.newLine(); // Move to the next line
    }
    writer.close(); // Close the file
}
```
*This method writes each bakery name from the list to a new line in the specified file.*

---

# Bakery Favorites: Development Strategy

1. **Set up the main scaffold code**: Create the main class and `main` method.
2. **Menu loop**: Implement a loop to show options and get user input.
3. **Develop each operation, one at a time**: Write and test each method separately.

**Scaffold Example:**
```java
import java.util.*; // Import all utility classes
import java.io.*;   // Import all IO classes

public class BakeryFavorites {
    public static void main(String[] args) throws IOException {
        ArrayList<String> favorites = new ArrayList<>(); // List to store favorite bakeries
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        // Menu loop and operations go here
    }
}
```
*This is the basic structure of the program. You will add the menu loop and call the methods above to build the full application.*

---

By breaking down the program into small, testable methods and using `ArrayList` effectively, you can build a flexible and user-friendly application! Each code example above is annotated to help you understand what each part does. If you have questions about any concept or code, feel free to ask!*
