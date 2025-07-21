# equals() method

The `equals()` method in Java is used to compare two objects for *equality*. But what does equality mean? By default, it means both references point to the exact same object in memory (reference equality). However, in many cases, we want to check if two objects have the same *values* (value equality).

## Why is `equals()` important?
- Used by many Java library methods, such as `contains`, `remove`, and `indexOf` in collections like `ArrayList`, `HashSet`, and `HashMap`.
- Determines how objects are compared for equality in your code.

## Default Implementation
Every class in Java inherits a default `equals()` method from the `Object` class:

```java
public boolean equals(Object obj) {
    return (this == obj);
}
```
- This checks if both references point to the same object (reference equality).
- Not useful if you want to compare the *contents* of two objects.

## Overriding `equals()` for Value Equality
If you want to compare objects based on their values (fields), you need to override `equals()` in your class.

### Example: Comparing Points
Suppose we have a `Point` class:

```java
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Overriding equals() for value equality
    @Override
    public boolean equals(Object obj) {
        // Check if the same reference
        if (this == obj) return true;
        // Check if obj is null or not the same class
        if (obj == null || getClass() != obj.getClass()) return false;
        // Cast and compare fields
        Point other = (Point) obj;
        return this.x == other.x && this.y == other.y;
    }
}
```

**Explanation:**
- `this == obj`: Checks if both references are the same.
- `obj == null || getClass() != obj.getClass()`: Ensures `obj` is not null and is the same class.
- Casts `obj` to `Point` and compares the fields.

### Using `instanceof` (Alternative)
You can also use `instanceof` for more flexible type checking:

```java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof Point)) return false;
    Point other = (Point) obj;
    return this.x == other.x && this.y == other.y;
}
```

## Common Pitfalls
- **Forgetting to override `hashCode()`**: If you override `equals()`, you *must* also override `hashCode()`. Otherwise, your objects may not work correctly in hash-based collections like `HashSet` or `HashMap`.
- **Not checking for null**: Always check if the parameter is `null` before casting.
- **Using `==` for objects**: Use `equals()` for object value comparison, not `==`.

## Example: hashCode() Implementation
```java
@Override
public int hashCode() {
    return Objects.hash(x, y);
}
```
- Use `Objects.hash()` (Java 7+) for convenience and correctness.

## Summary Table
| Comparison Type      | Method         | Checks for           |
|---------------------|----------------|----------------------|
| Reference Equality  | `==`           | Same object in memory|
| Value Equality      | `equals()`     | Same field values    |

## Key Takeaways
- Use `equals()` to compare object values, not references.
- Always override `hashCode()` when you override `equals()`.
- Follow best practices to avoid bugs in collections and comparisons.

---
**Further Reading:**
- [Java Documentation: Object.equals()](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#equals-java.lang.Object-)
- [Effective Java, Item 10: Obey the general contract when overriding equals()](https://www.oreilly.com/library/view/effective-java-3rd/9780134686097/)