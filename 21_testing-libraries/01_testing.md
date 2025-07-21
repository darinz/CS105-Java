# Importance of Testing

Imagine using your favorite app, only to have it crash or give you the wrong answer. Frustrating, right? This happens because software—no matter who writes it—is never perfect on the first try. Every developer, from beginner to expert, makes mistakes (called "bugs").

As software becomes a bigger part of our lives—powering everything from phones to hospitals—the impact of these bugs grows. A small error in code can lead to big problems, from minor annoyances to serious consequences.

Testing is how we fight back! By checking our code with tests, we can catch mistakes early, fix them, and make sure our programs work the way we expect. This makes our software safer, more reliable, and more enjoyable for everyone.

---

Fun Aside – what was the first computer bug?

1947 Harvard “computers” find moth trapped in the Mark II

---

Real-World Example:

“The Horizon scandal, described as ‘the most widespread miscarriage of justice in UK history’, resulted in more than 700 post office operators being prosecuted between 1999 and 2015 for theft, fraud and false accounting because of faulty accounting software installed in the late 1990s… Some spent time in prison, and the scandal has been linked to four suicides.”

Source: The Guardian

---

## Why is Testing Important in Java?

Java is widely used for building everything from small apps to large enterprise systems. Even a small bug can cause major issues, especially as codebases grow. Testing helps us:

- Catch bugs early (before users do!)
- Ensure our code works as expected
- Make it safer to change or add features
- Build confidence in our software

## Types of Testing (with Java Focus)

- **Unit Testing**: Testing individual methods or classes in isolation. Most common in Java using frameworks like JUnit.
- **Integration Testing**: Testing how different parts of the system work together.
- **System Testing**: Testing the complete application as a whole.
- **Regression Testing**: Making sure new changes don't break existing functionality.

## Example: A Simple Java Bug

Let's say we have a method to add two numbers:

```java
// Example of a buggy method
public class Calculator {
    // This method is supposed to add two numbers
    public int add(int a, int b) {
        return a - b; // Oops! Bug: should be a + b
    }
}
```

Without testing, this bug might go unnoticed!

## Writing a Unit Test in Java (with JUnit)

JUnit is the most popular testing framework for Java. Here's how we can write a test to catch the above bug:

```java
import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
    @Test // This annotation tells JUnit this is a test method
    public void testAdd() {
        Calculator calc = new Calculator();
        int result = calc.add(2, 3);
        // We expect 2 + 3 = 5
        assertEquals(5, result); // This will fail if the method is buggy
    }
}
```

### Explanation:
- `@Test` marks the method as a test.
- `assertEquals(expected, actual)` checks if the result is what we expect.
- If the test fails, JUnit will show an error, helping us catch the bug early.

## Summary
- Testing is essential for reliable Java software.
- Unit tests (using JUnit) help catch bugs in individual methods.
- Good tests make code safer to change and easier to maintain.

*Next: See 02_junit.md for more on JUnit and how to run tests in Java!*
