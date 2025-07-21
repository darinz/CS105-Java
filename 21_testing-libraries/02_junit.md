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
public int add(int a, int b) {
    return a + b;
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
- `@Test` – Marks a method as a test method
- `@DisplayName` – Lets you give a test a readable name
- `@BeforeEach` – Runs before each test (for setup)
- `@AfterEach` – Runs after each test (for cleanup)

### Common Assertion Methods
- `assertEquals(expected, actual)` – Checks if two values are equal
- `assertTrue(condition)` – Checks if a condition is true
- `assertFalse(condition)` – Checks if a condition is false
- `assertNotNull(object)` – Checks if an object is not null

---

## Example: Testing an ArrayList

Let's see how to write and run a simple JUnit test for Java's `ArrayList` class.

```java
import org.junit.jupiter.api.*; // JUnit 5 annotations
import static org.junit.jupiter.api.Assertions.*; // Assertion methods
import java.util.*;

public class ArrayListTest {
    // This method is a unit test
    @Test
    public void testAddAndGet() {
        // Arrange: Create a new ArrayList and add elements
        List<String> list = new ArrayList<>();
        list.add("Connor");
        list.add("Steven");
        list.add("Cady");

        // Act & Assert: Check if the first element is as expected
        assertEquals("Connor", list.get(0)); // Passes if true
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
```java
@Test
public void testMultipleElements() {
    List<String> list = new ArrayList<>();
    list.add("Colin");
    list.add("Steven");
    list.add("Elizabeth");

    assertEquals("Colin", list.get(0));      // TRUE
    assertEquals("Elizabeth", list.get(2));  // TRUE
}
```

### Example: Failing Test
```java
@Test
public void testFailingCase() {
    List<String> list = new ArrayList<>();
    list.add("Colin");
    list.add("Steven");
    list.add("Elizabeth");

    assertEquals("Steven", list.get(2)); // FALSE! This will fail
}
```
- The test above fails because `list.get(2)` is "Elizabeth", not "Steven".
- JUnit will show a red X and a message like: `expected: <Steven> but was: <Elizabeth>`

---

## Best Practices for Writing Tests
- **Name your test methods clearly** (e.g., `testAddAndGet`)
- **Test one thing per test method**
- **Use setup methods** (`@BeforeEach`) for repeated code
- **Write tests for edge cases** (empty lists, nulls, etc.)
- **Run your tests often!**

---

## Running JUnit Tests
- In most IDEs (like IntelliJ or Eclipse), you can right-click a test file or method and select "Run Test".
- You can also run tests from the command line with build tools like Maven or Gradle.

---

## Summary
- JUnit makes it easy to write, organize, and run tests for your Java code.
- Use annotations to mark test methods and assertions to check results.
- Good tests help you write better, safer code!


