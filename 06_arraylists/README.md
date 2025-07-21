# ArrayLists in Java

## Overview
An **ArrayList** in Java is a resizable, array-like data structure from the `java.util` package. Unlike regular arrays, ArrayLists can dynamically grow or shrink as elements are added or removed, making them ideal for situations where the number of items is not known in advance.

## Key Features
- **Dynamic Sizing:** Automatically resizes as elements are added or removed.
- **Zero-based Indexing:** The first element is at index 0.
- **Type Safety:** Uses Java Generics to ensure all elements are of the same type.
- **Object Storage:** Stores objects (use wrapper classes for primitives, e.g., `Integer` for `int`).

### Array vs. ArrayList
| Feature         | Array                | ArrayList                |
|----------------|----------------------|--------------------------|
| Size           | Fixed                | Dynamic (resizable)      |
| Primitives     | Yes                  | No (use wrappers)        |
| Methods        | Few                  | Many built-in methods    |

## Common ArrayList Methods
- `add(element)`: Adds to the end
- `add(index, element)`: Inserts at index
- `remove(index)`: Removes at index
- `get(index)`: Retrieves element
- `set(index, element)`: Replaces element
- `size()`: Number of elements
- `contains(element)`: Checks for existence
- `indexOf(element)`: Finds index of element

## Practical Applications
ArrayLists are used in many real-world scenarios, such as:
- Managing dynamic lists (e.g., a list of bakery names)
- Reading and writing lists from/to files
- Comparing and merging lists
- Implementing menu-driven programs for user interaction

### Example: Menu-Driven List Manager
A typical application involves a menu loop allowing users to add, remove, and print elements in an ArrayList, with options to load from or save to files, compare lists, and more.

## Development Strategy
1. **Set up main class and method**
2. **Implement a menu loop for user interaction**
3. **Develop and test each operation as a separate method**

## Practice Problems
1. **Remove All Occurrences**: Write a method to remove all occurrences of a target value from an ArrayList.
2. **Unique Elements**: Return a new ArrayList containing only unique elements from the original list.
3. **Insert After Every Occurrence**: Insert a value immediately after every occurrence of a target value.
4. **Menu-Driven List Manager**: Build a program to add, remove, and print elements interactively.

Each problem helps reinforce understanding of ArrayList operations and Java programming fundamentals.

---

For detailed explanations, annotated code examples, and more practice, see the individual module files:
- `01_arraylist.md`: Concepts and syntax
- `02_applications.md`: Real-world applications and file I/O
- `03_practice-review-app.md`: Practice problems and solutions 