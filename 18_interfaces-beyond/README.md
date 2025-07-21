# Interfaces and Beyond in Java

Welcome to the **Interfaces and Beyond** module! This section explores advanced Java concepts that build on your understanding of interfaces, including multiple interfaces, the Comparable interface, the Optional class, Java collections, and practical applications. Each topic is explained with clear analogies and annotated code examples to help you master these essential tools for robust Java programming.

---

## Table of Contents
- [1. Interfaces](#1-interfaces)
- [2. Multiple Interfaces](#2-multiple-interfaces)
- [3. Comparable Interface](#3-comparable-interface)
- [4. Optional Class](#4-optional-class)
- [5. Collections in Java](#5-collections-in-java)
- [6. Practice & Review App](#6-practice--review-app)

---

## 1. Interfaces (`01_interfaces.md`)
- **What is an Interface?**
  - A contract that specifies *what* methods a class must have, but not *how* they work.
  - Analogy: Like a job description—lists required tasks, but not how to do them.
- **Abstract Data Types (ADT):**
  - Describes the *idea* of a data structure (e.g., List ADT: add, remove, get, size).
- **Implementation:**
  - A class that implements an interface must provide code for all its methods.
- **Key Point:**
  - Interfaces ensure consistency and enable polymorphism in Java.

## 2. Multiple Interfaces (`02_multi-interface.md`)
- **Implementing Multiple Interfaces:**
  - A class can implement more than one interface (like signing multiple contracts).
  - Useful for inheriting behavior from multiple sources (since Java does not support multiple inheritance of classes).
- **Interface Inheritance:**
  - Interfaces can extend other interfaces, building more specific contracts on top of general ones.
- **Example:**
  - A `Square` can implement both `Shape` and `Parallel` interfaces, providing all required methods.

## 3. Comparable Interface (`03_comparable.md`)
- **Why Comparable?**
  - Needed for sorting objects (e.g., in a `TreeSet`).
  - Defines a *natural ordering* for objects.
- **How to Use:**
  - Implement the `Comparable<T>` interface and its `compareTo` method.
  - Example: Students can be sorted by ID if `compareTo` is implemented.
- **Key Point:**
  - Enables custom sorting and use of sorted collections.

## 4. Optional Class (`04_optional.md`)
- **What is Optional?**
  - A container object that may or may not contain a non-null value.
  - Helps avoid `NullPointerException` and makes code safer.
- **How to Use:**
  - Use `Optional.empty()`, `Optional.of(value)`, or `Optional.ofNullable(value)` to create Optionals.
  - Use methods like `isPresent()`, `ifPresent()`, and `orElse()` for safe access.
- **Best Practices:**
  - Use as a return type to signal that a value may be missing.
  - Avoid using for fields or parameters.

## 5. Collections in Java (`05_collections.md`)
- **Overview:**
  - Java provides powerful collection classes and interfaces for managing groups of objects.
- **Key Types:**
  - `Array`: Fixed-size, indexed collection.
  - `ArrayList`: Resizable array implementation of `List`.
  - `LinkedList`: Doubly-linked list, good for queues and deques.
  - `Stack`: LIFO structure (prefer `Deque` for new code).
  - `HashSet`: No duplicates, fast lookup.
  - `HashMap`: Key-value pairs, fast access.
- **When to Use Each:**
  - Choose based on needs for ordering, uniqueness, and performance.

## 6. Practice & Review App (`06_practice-review-app.md`)
- **Purpose:**
  - Reinforces concepts of interfaces, inheritance, and implementation through annotated examples and practice questions.
- **What You'll Do:**
  - Define and implement interfaces.
  - Work with classes that implement multiple interfaces.
  - Identify compile-time errors and understand interface requirements.

---

## Learning Objectives
By the end of this module, you should be able to:
- Understand and define Java interfaces and their purpose.
- Implement multiple interfaces in a single class.
- Use the `Comparable` interface to enable sorting of custom objects.
- Apply the `Optional` class to write safer, more expressive code.
- Choose and use the appropriate Java collection for a given problem.
- Confidently implement and use interfaces in practical Java applications.

---

If you have questions, refer to the individual markdown files for detailed explanations and annotated code examples. 