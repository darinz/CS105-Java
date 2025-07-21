# Iterators

An **iterator** in Java is an object that enables you to traverse (visit) the elements of a collection (like an `ArrayList`, `HashSet`, etc.) one at a time, without exposing the underlying structure of the collection. Iterators are part of the Java Collections Framework and provide a standard way to loop through collections.

## How to Get an Iterator

Iterators are returned by the `iterator()` method, which is available on all classes that implement the `Collection` interface (such as `ArrayList`, `HashSet`, etc.).

```java
import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        // Get an iterator for the list
        Iterator<String> it = list.iterator();

        // Traverse the list using the iterator
        while (it.hasNext()) {
            String fruit = it.next();
            System.out.println(fruit);
        }
    }
}
```

## Iterator Methods

| Method      | Description                                                        |
|-------------|--------------------------------------------------------------------|
| `hasNext()` | Returns `true` if there are more elements for the iterator to return |
| `next()`    | Returns the next element in the iteration                          |
| `remove()`  | Removes the element that was last returned by `next()`             |

## Why Use Iterators?

- **Uniformity:** Iterators provide a consistent way to traverse different types of collections.
- **Encapsulation:** You don't need to know how the collection is implemented.
- **Safe Removal:** Iterators allow you to safely remove elements from a collection while iterating.

## Removing Elements Safely

**Important:** You must use the iterator’s `remove()` method to remove elements from the collection while iterating. If you try to remove elements directly from the collection (e.g., using `list.remove()`), you will get a `ConcurrentModificationException`.

### Example: Safe Removal

```java
import java.util.ArrayList;
import java.util.Iterator;

public class RemoveWithIterator {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        Iterator<Integer> it = numbers.iterator();
        while (it.hasNext()) {
            int num = it.next();
            if (num % 2 == 0) {
                // Safe removal using iterator
                it.remove();
            }
        }
        System.out.println(numbers); // Output: [1, 3]
    }
}
```

### Example: Unsafe Removal (Causes Exception)

```java
import java.util.ArrayList;

public class RemoveDirectly {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        for (Integer num : numbers) {
            if (num % 2 == 0) {
                // This will throw ConcurrentModificationException!
                numbers.remove(num);
            }
        }
    }
}
```

**Explanation:**
- When you remove elements directly from the collection while using a for-each loop (which uses an iterator internally), the iterator detects that the collection has been modified unexpectedly and throws a `ConcurrentModificationException`.
- Always use the iterator’s `remove()` method when you need to remove elements during iteration.

## Summary
- Use iterators to traverse collections in Java.
- Use `hasNext()` and `next()` to loop through elements.
- Use the iterator’s `remove()` method to safely remove elements during iteration.
- Avoid modifying the collection directly while iterating to prevent `ConcurrentModificationException`.