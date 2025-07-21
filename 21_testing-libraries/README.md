# Java Testing Libraries & Best Practices

Welcome to the **Testing Libraries** module! This section will help you understand why testing is essential in software development, how to use JUnit (the most popular Java testing framework), and how to write effective tests for your Java code.

---

## Why is Testing Important?
- **Software always has bugs**—even experienced developers make mistakes.
- **Testing** helps catch these mistakes early, making your code safer, more reliable, and easier to maintain.
- Real-world bugs can have serious consequences (see the Horizon scandal for an example).

> *"Testing is how we fight back!"*

---

## Types of Testing (Java Focus)
- **Unit Testing:** Test individual methods/classes in isolation (most common, done with JUnit).
- **Integration Testing:** Test how different parts of your system work together.
- **System Testing:** Test the complete application as a whole.
- **Regression Testing:** Ensure new changes don’t break existing features.

---

## JUnit: The Java Testing Framework
- **JUnit** is the standard for writing and running unit tests in Java.
- **Annotations** like `@Test` mark test methods.
- **Assertions** like `assertEquals(expected, actual)` check if results are as expected.

### Example: Simple Unit Test
```java
import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        int result = calc.add(2, 3);
        assertEquals(5, result); // Fails if add() is buggy
    }
}
```

- `@Test` marks a test method.
- `assertEquals` checks if the result matches what you expect.

---

## Best Practices & Tips
- **Write many tests** for each method, covering normal, edge, and error cases.
- **Test one thing per test method** for clarity.
- **Use setup methods** (`@BeforeEach`) to avoid repeated code.
- **Test edge cases:** empty, null, max/min values, etc.
- **Cover all branches:** if/else, loops, etc.
- **Use descriptive messages** in assertions to make failures easy to understand.
- **Refactor test code**—use helper methods to reduce repetition.
- **Test adversarially:** try to break your own code!
- **Compare doubles with a tolerance** (delta), not `==`.

---

## Example: Card & BattleManager Classes
- Practice writing tests for classes like `Card` (valid/invalid values, `toString`, `equals`) and `BattleManager` (game over, deck splitting, winner logic).
- See `04_practice-review-app.md` for annotated code and test ideas.

---

## Floating Point Numbers in Tests
- Never use `==` to compare doubles; use a small tolerance (delta) instead:
```java
assertEquals(expected, actual, 1e-9); // Passes if difference < 1e-9
```

---

## Where to Learn More
- **01_testing.md:** Why testing matters, types of tests, and a simple JUnit example.
- **02_junit.md:** JUnit basics, annotations, assertions, and more examples.
- **03_tips.md:** Practical tips and best practices for writing great tests.
- **04_practice-review-app.md:** Practice exercises, annotated code, and challenge problems.

---

## Summary
- Testing is essential for reliable Java software.
- JUnit makes writing and running tests easy.
- Good tests make your code safer, easier to change, and more robust.

> *"Testing code is just code—use good practices and always strive to break (and fix) your own code!"* 