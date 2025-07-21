# For-Each Loop in Java

The **for-each loop** (also known as the enhanced for loop) is a concise and readable way to iterate over elements in collections and arrays in Java. It is especially useful when you want to access each element in a collection without needing to know their index or position.

## Syntax

The for-each loop lets you process each element in a collection or array without using an index.

```java
for (Type element : collection) { // 'Type' is the type of elements, 'element' is a variable name, 'collection' is what you are looping through
    // Use element
}
```

- `Type` is the type of elements in the collection (e.g., `String`, `Integer`).
- `element` is a variable that will take on the value of each item in the collection, one at a time.
- `collection` is any object that implements the `Iterable` interface (e.g., `Set`, `List`, etc.) or an array.

## Example: Iterating Over a Set

Here’s how you can use a for-each loop to print every word in a `Set`:

```java
Set<String> words = new HashSet<>(); // Create a new HashSet to store unique words
words.add("apple");   // Add the word "apple" to the set
words.add("banana");  // Add the word "banana" to the set
words.add("cherry");  // Add the word "cherry" to the set

for (String s : words) {            // For each String 's' in the set 'words'
    System.out.println(s);          // Print the current word
}
```
**Explanation:**
- The for-each loop automatically goes through each element in the set, assigning it to `s` one at a time.
- You don’t need to worry about indexes or the order (sets are unordered).

## Example: Iterating Over a List

Lists are ordered collections. Here’s how to print each number in a list:

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5); // Create a list of integers
for (int num : numbers) {                             // For each integer 'num' in the list 'numbers'
    System.out.println(num);                          // Print the current number
}
```
**Explanation:**
- The loop visits each number in the list, in order, and prints it.
- This is much simpler than using a traditional for loop with an index.

## Example: Iterating Over a Map

Maps store key-value pairs. To loop through both keys and values, use `entrySet()`:

```java
Map<String, Integer> ages = new HashMap<>();      // Create a map to store names and ages
ages.put("Alice", 30);                          // Add key "Alice" with value 30
ages.put("Bob", 25);                            // Add key "Bob" with value 25

for (Map.Entry<String, Integer> entry : ages.entrySet()) { // For each entry (key-value pair) in the map
    System.out.println(entry.getKey() + ": " + entry.getValue()); // Print the key and value
}
```
**Explanation:**
- `entrySet()` returns a set of all key-value pairs in the map.
- Each `entry` has a key (`getKey()`) and a value (`getValue()`).

## For-Each Loop is Read-Only

**Important:** You cannot modify the structure of a collection (e.g., add or remove elements) while iterating over it with a for-each loop. Doing so will cause a `ConcurrentModificationException`.

### Example of Problematic Code

```java
for (String s : words) {           // For each word in the set
    if (s.startsWith("a")) {      // If the word starts with 'a'
        words.remove(s);           // Trying to remove it here will cause an error!
    }
}
```
**Explanation:**
- Removing elements from the collection directly inside a for-each loop is not allowed and will throw an exception.

### Why Does This Happen?
- The for-each loop uses an iterator behind the scenes.
- If you modify the collection directly (not through the iterator), the iterator detects this and throws an exception to prevent unpredictable behavior.

### How to Remove Elements Safely
If you need to remove elements while iterating, use an explicit iterator:

```java
Iterator<String> it = words.iterator();      // Get an iterator for the set
while (it.hasNext()) {                      // While there are more elements
    String s = it.next();                   // Get the next element
    if (s.startsWith("a")) {               // If it starts with 'a'
        it.remove();                        // Remove it safely using the iterator
    }
}
```
**Explanation:**
- The iterator’s `remove()` method safely removes elements during iteration.
- This avoids the `ConcurrentModificationException`.

## Best Practices
- Use for-each loops for simple iteration when you do not need to modify the collection.
- Use an explicit iterator if you need to add or remove elements during iteration.
- For-each loops work with any class that implements `Iterable`, including most Java collections and arrays.

## Common Pitfalls
- Trying to modify the collection inside a for-each loop (removing/adding elements) will cause a `ConcurrentModificationException`.
- If you need the index of elements (e.g., in a `List`), use a traditional for loop instead:

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
for (int i = 0; i < names.size(); i++) { // Use index 'i' to access elements
    System.out.println(i + ": " + names.get(i));
}
```

---

The for-each loop is a powerful tool for clean and readable code, but remember its limitations regarding modification during iteration! With these annotations and explanations, you should find it easier to understand and use for-each loops in your own Java programs.

