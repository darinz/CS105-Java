# For-Each Loop in Java

The **for-each loop** (also known as the enhanced for loop) is a concise and readable way to iterate over elements in collections and arrays in Java. It is especially useful when you want to access each element in a collection without needing to know their index or position.

## Syntax

```java
for (Type element : collection) {
    // Use element
}
```

- `Type` is the type of elements in the collection (e.g., `String`, `Integer`).
- `element` is a variable that will take on the value of each item in the collection, one at a time.
- `collection` is any object that implements the `Iterable` interface (e.g., `Set`, `List`, etc.) or an array.

## Example: Iterating Over a Set

```java
Set<String> words = new HashSet<>();
words.add("apple");
words.add("banana");
words.add("cherry");

for (String s : words) {
    System.out.println(s);
}
```

## Example: Iterating Over a List

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
for (int num : numbers) {
    System.out.println(num);
}
```

## Example: Iterating Over a Map

To iterate over a `Map`, you can use the `entrySet()` method:

```java
Map<String, Integer> ages = new HashMap<>();
ages.put("Alice", 30);
ages.put("Bob", 25);

for (Map.Entry<String, Integer> entry : ages.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

## For-Each Loop is Read-Only

**Important:** You cannot modify the structure of a collection (e.g., add or remove elements) while iterating over it with a for-each loop. Doing so will cause a `ConcurrentModificationException`.

### Example of Problematic Code

```java
for (String s : words) {
    if (s.startsWith("a")) {
        words.remove(s); // This will throw ConcurrentModificationException!
    }
}
```

### Why Does This Happen?
- The for-each loop uses an iterator behind the scenes.
- If you modify the collection directly (not through the iterator), the iterator detects this and throws an exception to prevent unpredictable behavior.

### How to Remove Elements Safely
If you need to remove elements while iterating, use an explicit iterator:

```java
Iterator<String> it = words.iterator();
while (it.hasNext()) {
    String s = it.next();
    if (s.startsWith("a")) {
        it.remove(); // Safe removal
    }
}
```

## Best Practices
- Use for-each loops for simple iteration when you do not need to modify the collection.
- Use an explicit iterator if you need to add or remove elements during iteration.
- For-each loops work with any class that implements `Iterable`, including most Java collections and arrays.

## Common Pitfalls
- Trying to modify the collection inside a for-each loop (removing/adding elements) will cause a `ConcurrentModificationException`.
- If you need the index of elements (e.g., in a `List`), use a traditional for loop instead.

---

The for-each loop is a powerful tool for clean and readable code, but remember its limitations regarding modification during iteration!

