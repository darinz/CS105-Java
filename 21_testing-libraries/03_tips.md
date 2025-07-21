# Testing Tips

## 1. Write many tests for each method
It's important to test your methods with a variety of inputs to ensure they work in all scenarios. In Java, we use JUnit to write unit tests for each method.

```java
// Example: Testing a simple add method
public int add(int a, int b) {
    return a + b;
}

// JUnit test class
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MathUtilsTest {
    @Test
    void testAddPositiveNumbers() {
        assertEquals(5, add(2, 3), "Adding two positive numbers");
    }
    @Test
    void testAddNegativeNumbers() {
        assertEquals(-5, add(-2, -3), "Adding two negative numbers");
    }
    @Test
    void testAddZero() {
        assertEquals(2, add(2, 0), "Adding zero");
    }
}
```

## 2. Test that your method does what you want it to do
Write tests that check the expected output for given inputs. This helps catch bugs early.

```java
// Example: Testing a string reversal method
public String reverse(String s) {
    return new StringBuilder(s).reverse().toString();
}

@Test
void testReverse() {
    assertEquals("cba", reverse("abc"), "Reverses a string");
}
```

## 3. Test combinations of your method being used with other methods
Sometimes, methods interact. Test them together to ensure they work as expected.

```java
// Example: Combining add and multiply methods
public int multiply(int a, int b) { return a * b; }

@Test
void testAddAndMultiply() {
    int sum = add(2, 3); // 5
    int product = multiply(sum, 4); // 20
    assertEquals(20, product, "Add then multiply");
}
```

## 4. Write a test method per distinct case
Each test should check a specific scenario. This makes it easier to find bugs and understand failures.

```java
@Test
void testAddPositive() { assertEquals(7, add(3, 4)); }
@Test
void testAddNegative() { assertEquals(-1, add(3, -4)); }
```

## 5. Test that different states of input don’t break your code (empty or null params)
Test edge cases like empty strings, null values, or extreme numbers.

```java
@Test
void testReverseEmptyString() {
    assertEquals("", reverse(""), "Reverse of empty string should be empty");
}
@Test
void testReverseNull() {
    assertThrows(NullPointerException.class, () -> reverse(null), "Reverse of null should throw");
}
```

## 6. Test that code correctly enters all boolean checks (loops, if/else)
Make sure your tests cover all branches of your code.

```java
public boolean isEven(int n) {
    return n % 2 == 0;
}

@Test
void testIsEven() {
    assertTrue(isEven(4), "4 is even");
    assertFalse(isEven(5), "5 is not even");
}
```

## 7. Use assertEquals(expected, actual, message) to provide a description of what case that line is testing
Adding a message helps you quickly identify which test failed and why.

```java
@Test
void testAddWithMessage() {
    assertEquals(10, add(7, 3), "Adding 7 and 3 should be 10");
}
```

## 8. Testing code is just code. Use good coding practices (e.g., helper methods to reduce redundancy) to help you write code.
You can refactor your test code just like your main code. Use helper methods to avoid repeating yourself.

```java
private void assertAdd(int a, int b, int expected) {
    assertEquals(expected, add(a, b));
}

@Test
void testAddHelper() {
    assertAdd(1, 2, 3);
    assertAdd(-1, -2, -3);
}
```

It can take time, but if you do it well, developing your solution can be a breeze!

---

# How Many Test Cases Is Enough?

## In general, more diverse tests → more confidence!
Test with a variety of inputs, including normal, boundary, and invalid cases.

## Try to think adversarially and try to break your own code with tests
Imagine how a user might misuse your code and write tests for those cases.

## Specification Testing (based on the spec) vs. Clear-box Testing (based on how you know your implementation works)
- **Specification Testing:** Write tests based on the requirements, even before you write the code (Test Driven Development).
- **Clear-box Testing:** Write tests based on your knowledge of the code's structure, after implementation.

```java
// Specification test: Based on requirements
double divide(int a, int b) { return a / b; }
@Test
void testDivideByZero() {
    assertThrows(ArithmeticException.class, () -> divide(5, 0), "Division by zero should throw");
}
```

## Test a wide variety of different cases
Test normal, edge, and error cases.

## Think about boundary or "edge" cases in particular, where the behavior should change

```java
@Test
void testEdgeCases() {
    assertEquals(0, add(0, 0), "Adding zeros");
    assertEquals(Integer.MAX_VALUE, add(Integer.MAX_VALUE, 0), "Adding max int");
    assertEquals(Integer.MIN_VALUE, add(Integer.MIN_VALUE, 0), "Adding min int");
}
```


