# Testing Tips

## 1. Write many tests for each method
It's important to test your methods with a variety of inputs to ensure they work in all scenarios. In Java, we use JUnit to write unit tests for each method.

Below is an example of a simple method and its tests. Notice how each test checks a different scenario:

```java
// This method adds two integers and returns the result.
public int add(int a, int b) {
    return a + b;
}

// JUnit test class for the add method
import static org.junit.jupiter.api.Assertions.*; // Import assertion methods
import org.junit.jupiter.api.Test; // Import the @Test annotation

class MathUtilsTest {
    // Test adding two positive numbers
    @Test
    void testAddPositiveNumbers() {
        assertEquals(5, add(2, 3), "Adding two positive numbers");
    }
    // Test adding two negative numbers
    @Test
    void testAddNegativeNumbers() {
        assertEquals(-5, add(-2, -3), "Adding two negative numbers");
    }
    // Test adding zero
    @Test
    void testAddZero() {
        assertEquals(2, add(2, 0), "Adding zero");
    }
}
```
*Explanation:* Each `@Test` method checks a different case for the `add` method. The `assertEquals` method checks if the actual result matches the expected result. The message helps identify which test failed if something goes wrong.

---

## 2. Test that your method does what you want it to do
Write tests that check the expected output for given inputs. This helps catch bugs early.

```java
// This method reverses a string using StringBuilder.
public String reverse(String s) {
    // StringBuilder makes it easy to reverse strings in Java
    return new StringBuilder(s).reverse().toString();
}

// Test for the reverse method
@Test
void testReverse() {
    // Checks if reversing "abc" gives "cba"
    assertEquals("cba", reverse("abc"), "Reverses a string");
}
```
*Explanation:* This test ensures the `reverse` method works as intended for a typical input.

---

## 3. Test combinations of your method being used with other methods
Sometimes, methods interact. Test them together to ensure they work as expected.

```java
// Multiplies two integers
public int multiply(int a, int b) { return a * b; }

// Test combining add and multiply
@Test
void testAddAndMultiply() {
    int sum = add(2, 3); // sum = 5
    int product = multiply(sum, 4); // product = 20
    assertEquals(20, product, "Add then multiply");
}
```
*Explanation:* This test checks that the result of `add` can be used as input to `multiply`, and the combined behavior is correct.

---

## 4. Write a test method per distinct case
Each test should check a specific scenario. This makes it easier to find bugs and understand failures.

```java
// Test adding two positive numbers
@Test
void testAddPositive() { assertEquals(7, add(3, 4)); }
// Test adding a positive and a negative number
@Test
void testAddNegative() { assertEquals(-1, add(3, -4)); }
```
*Explanation:* Separate test methods make it clear which scenario is being tested and help quickly identify which case fails.

---

## 5. Test that different states of input don’t break your code (empty or null params)
Test edge cases like empty strings, null values, or extreme numbers.

```java
// Test reversing an empty string
@Test
void testReverseEmptyString() {
    assertEquals("", reverse(""), "Reverse of empty string should be empty");
}
// Test reversing null (should throw an exception)
@Test
void testReverseNull() {
    // Expects a NullPointerException when input is null
    assertThrows(NullPointerException.class, () -> reverse(null), "Reverse of null should throw");
}
```
*Explanation:* Always test how your code handles unusual or extreme inputs, such as empty or null values.

---

## 6. Test that code correctly enters all boolean checks (loops, if/else)
Make sure your tests cover all branches of your code.

```java
// Checks if a number is even
public boolean isEven(int n) {
    return n % 2 == 0;
}

// Test both branches: even and odd
@Test
void testIsEven() {
    assertTrue(isEven(4), "4 is even"); // Should be true
    assertFalse(isEven(5), "5 is not even"); // Should be false
}
```
*Explanation:* These tests ensure both the true and false branches of the `isEven` method are checked.

---

## 7. Use assertEquals(expected, actual, message) to provide a description of what case that line is testing
Adding a message helps you quickly identify which test failed and why.

```java
// Test with a descriptive message
@Test
void testAddWithMessage() {
    assertEquals(10, add(7, 3), "Adding 7 and 3 should be 10");
}
```
*Explanation:* The message in `assertEquals` is shown if the test fails, making debugging easier.

---

## 8. Testing code is just code. Use good coding practices (e.g., helper methods to reduce redundancy) to help you write code.
You can refactor your test code just like your main code. Use helper methods to avoid repeating yourself.

```java
// Helper method to test add
private void assertAdd(int a, int b, int expected) {
    assertEquals(expected, add(a, b));
}

// Use the helper in your tests
@Test
void testAddHelper() {
    assertAdd(1, 2, 3); // 1 + 2 = 3
    assertAdd(-1, -2, -3); // -1 + -2 = -3
}
```
*Explanation:* Helper methods make your tests cleaner and reduce repetition.

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
// This method divides two integers
// Note: In Java, dividing by zero throws an ArithmeticException
public int divide(int a, int b) { return a / b; }

// Test that dividing by zero throws an exception
@Test
void testDivideByZero() {
    assertThrows(ArithmeticException.class, () -> divide(5, 0), "Division by zero should throw");
}
```
*Explanation:* This test is based on the specification that dividing by zero should throw an exception in Java.

---

## Test a wide variety of different cases
Test normal, edge, and error cases.

## Think about boundary or "edge" cases in particular, where the behavior should change

```java
// Test edge cases for the add method
@Test
void testEdgeCases() {
    assertEquals(0, add(0, 0), "Adding zeros"); // Both inputs are zero
    assertEquals(Integer.MAX_VALUE, add(Integer.MAX_VALUE, 0), "Adding max int"); // Largest int
    assertEquals(Integer.MIN_VALUE, add(Integer.MIN_VALUE, 0), "Adding min int"); // Smallest int
}
```
*Explanation:* Edge cases often reveal bugs that normal cases do not. Always consider the limits of your data types and logic.


