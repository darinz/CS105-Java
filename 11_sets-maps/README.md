# Sets and Maps in Java

This module introduces two fundamental data structures in Java: **Sets** and **Maps**. You will learn their core concepts, how to use them in Java, and best practices for iteration and modification. This folder contains annotated guides and practice problems to help you master these topics.

---

## What You'll Learn

- **Sets (01_sets.md):**
  - What a set is: a collection of unique values (no duplicates, no indices).
  - Java's `Set` interface and its main implementations: `HashSet` (fast, unordered) and `TreeSet` (sorted, slower).
  - Common set operations: `add`, `remove`, `contains`, `size`, etc.
  - Example code for creating and using sets.
  - When and why to use sets in your programs.

- **For-Each Loops (02_for-each.md):**
  - How to use the enhanced for loop to iterate over collections and arrays.
  - Syntax and examples for sets, lists, and maps.
  - Limitations: why you can't modify a collection while using a for-each loop.
  - Best practices and common pitfalls.

- **Iterators (03_iterators.md):**
  - What an iterator is and why it's useful.
  - How to obtain and use an iterator to traverse collections.
  - How to safely remove elements during iteration (avoiding `ConcurrentModificationException`).
  - Example code and explanations.

- **Maps (04_map.md):**
  - What a map is: a structure that associates unique keys to values (like a dictionary).
  - Java's `Map` interface and its main implementations: `HashMap` (fast, unordered) and `TreeMap` (sorted by key).
  - Common map operations: `put`, `get`, `remove`, `containsKey`, `keySet`, `values`, etc.
  - Example code for creating and using maps.
  - When and why to use maps in your programs.

- **Practice, Reviews, and Applications (05_practice-review-app.md):**
  - Practice problems to reinforce your understanding of sets and maps.
  - Real-world applications, code analysis, and review questions.
  - Step-by-step solutions with annotated explanations.

---

## How to Use This Folder

1. **Start with `01_sets.md`** to understand the basics of sets in Java.
2. **Read `02_for-each.md`** to learn how to iterate over collections using the enhanced for loop.
3. **Explore `03_iterators.md`** for deeper control over iteration and safe modification of collections.
4. **Study `04_map.md`** to learn about maps, their operations, and use cases.
5. **Test your knowledge with `05_practice-review-app.md`**, which contains practice problems and solutions.

Each file is annotated with explanations and code comments to make concepts easy to understand, especially for beginners.

---

## Key Takeaways

- **Sets** are for storing unique items; use `HashSet` for speed, `TreeSet` for sorted order.
- **Maps** associate keys to values; use `HashMap` for speed, `TreeMap` for sorted keys.
- **For-each loops** are great for simple iteration, but don't modify the collection inside them.
- **Iterators** give you more control and let you safely remove elements during iteration.
- Practice problems help solidify your understanding and prepare you for real-world coding.

---

Happy learning! For more details, see the individual markdown files in this folder. 