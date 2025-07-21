# JUnit

## What is Unit Testing?

**Unit Test** – A unit test is a small piece of code (usually a method) that checks whether another piece of code (like a method or class) works as expected. Think of it as a way to automatically verify that your code does what you want it to do.

- **Why write unit tests?**
  - Catch bugs early, before your code is used by others or in a bigger program.
  - Make it easier to change and improve your code, since you can quickly check if you broke anything.
  - Help others (and your future self) understand what your code is supposed to do.

**Example:**
```java
// A simple method to add two numbers
// This is the code we want to test
public int add(int a, int b) {
    return a + b; // Returns the sum of a and b
}
```
A unit test would check if `add(2, 3)` really returns `5`.

---

## What is a Testing Framework?

A **Testing Framework** is a library that helps you write and run unit tests easily. Instead of writing your own code to check results, you use special tags (annotations) and methods provided by the framework. This lets you:
- Run all your tests with one click (or command)
- See which tests passed or failed, with helpful messages
- Organize your tests and get clear feedback

**Analogy:** Like a music tuner helps you check if your instrument is in tune, a testing framework helps you check if your code is correct.

---

## JUnit Basics

**JUnit** is the most popular unit testing framework for Java. It provides:
- **Annotations** to mark test methods
- **Assertion methods** to check if results are as expected

### Common JUnit Annotations
- `@Test` – Marks a method as a test method (JUnit will run this method as a test)
- `@DisplayName` – Lets you give a test a readable name (shows up in test reports)
- `@BeforeEach` – Runs before each test (for setup, like creating objects)
- `@AfterEach` – Runs after each test (for cleanup, like closing files)

### Common Assertion Methods
- `assertEquals(expected, actual)` – Checks if two values are equal
- `assertTrue(condition)` – Checks if a condition is true
- `assertFalse(condition)` – Checks if a condition is false
- `assertNotNull(object)` – Checks if an object is not null

---

## Example: Testing an ArrayList

Let's see how to write and run a simple JUnit test for Java's `ArrayList` class.

```java
import org.junit.jupiter.api.*; // Import JUnit 5 annotations
import static org.junit.jupiter.api.Assertions.*; // Import assertion methods
import java.util.*; // Import Java's List and ArrayList

// This is our test class
public class ArrayListTest {
    // This method is a unit test for adding and getting elements from an ArrayList
    @Test // This annotation tells JUnit to run this method as a test
    public void testAddAndGet() {
        // Arrange: Create a new ArrayList and add elements
        List<String> list = new ArrayList<>(); // Create an empty list of Strings
        list.add("Connor"); // Add "Connor" to the list (index 0)
        list.add("Steven"); // Add "Steven" to the list (index 1)
        list.add("Cady");   // Add "Cady" to the list (index 2)

        // Act & Assert: Check if the first element is as expected
        assertEquals("Connor", list.get(0)); // Passes if the first element is "Connor"
    }
}
```

**Explanation:**
- `@Test` tells JUnit this is a test method.
- `assertEquals("Connor", list.get(0))` checks if the first element is "Connor".
- If the test passes, you get a green check. If not, you get an error message.

---

## More Examples and Common Mistakes

### Example: Multiple Assertions
This test checks more than one value in the list.
```java
@Test // Marks this as a test method
public void testMultipleElements() {
    List<String> list = new ArrayList<>(); // Create a new list
    list.add("Colin");      // index 0
    list.add("Steven");     // index 1
    list.add("Elizabeth");  // index 2

    assertEquals("Colin", list.get(0));      // TRUE: index 0 is "Colin"
    assertEquals("Elizabeth", list.get(2));  // TRUE: index 2 is "Elizabeth"
}
```

### Example: Failing Test
This test will fail, showing how JUnit reports errors.
```java
@Test
public void testFailingCase() {
    List<String> list = new ArrayList<>();
    list.add("Colin");      // index 0
    list.add("Steven");     // index 1
    list.add("Elizabeth");  // index 2

    assertEquals("Steven", list.get(2)); // FALSE! index 2 is "Elizabeth", not "Steven"
}
```
- The test above fails because `list.get(2)` is "Elizabeth", not "Steven".
- JUnit will show a red X and a message like: `expected: <Steven> but was: <Elizabeth>`

---

## Best Practices for Writing Tests
- **Name your test methods clearly** (e.g., `testAddAndGet`) so you know what each test checks.
- **Test one thing per test method** to make it easy to find problems.
- **Use setup methods** (`@BeforeEach`) for repeated code (like creating lists).
- **Write tests for edge cases** (empty lists, nulls, etc.) to make your code robust.
- **Run your tests often!** The sooner you find bugs, the easier they are to fix.

---

## Example: Using @BeforeEach for Setup
If you need to create a new list for every test, use `@BeforeEach`:
```java
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class ArrayListTest {
    private List<String> list; // Declare the list at class level

    @BeforeEach // Runs before each test method
    public void setUp() {
        list = new ArrayList<>(); // Create a new list before each test
    }

    @Test
    public void testAdd() {
        list.add("Alice");
        assertEquals(1, list.size()); // Check that the list has 1 element
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty()); // The list should be empty at the start
    }
}
```
**Explanation:**
- `@BeforeEach` runs the `setUp` method before every test, so each test gets a fresh list.
- This avoids bugs caused by leftover data from previous tests.

---

## Running JUnit Tests
- In most IDEs (like IntelliJ or Eclipse), you can right-click a test file or method and select "Run Test".
- You can also run tests from the command line with build tools like Maven or Gradle.
- JUnit will show green checks for passing tests and red Xs for failing ones, along with helpful error messages.

---

## Summary
- JUnit makes it easy to write, organize, and run tests for your Java code.
- Use annotations to mark test methods and assertions to check results.
- Good tests help you write better, safer code!


