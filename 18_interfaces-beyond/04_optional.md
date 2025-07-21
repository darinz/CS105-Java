# Optional

Optional is a Java class introduced in Java 8 that is used to handle situations where a value may or may not be present. It acts as a container object which may or may not contain a non-null value. This helps to avoid NullPointerExceptions and makes your code more expressive and robust.

## Why Use Optional?

Traditionally, Java methods that might not return a value would return `null`. However, this can lead to `NullPointerException` if the caller forgets to check for null. `Optional` makes the absence of a value explicit and encourages better handling of such cases.

**Example without Optional:**
```java
String findUsername(int id) {
    if (id == 1) return "alice";
    return null; // Could cause NullPointerException if not checked
}
```
*In this example, if the id is not 1, the method returns null. If the caller tries to use the result without checking for null, it could crash the program.*

**Example with Optional:**
```java
Optional<String> findUsername(int id) {
    if (id == 1) return Optional.of("alice"); // Wraps the value in an Optional
    return Optional.empty(); // Returns an empty Optional if not found
}
```
*Here, the method always returns an Optional, making it clear to the caller that the result may or may not be present. This encourages safer code.*

## Declaring and Creating Optionals

- A variable that can sometimes be initialized, based on situation
- `Optional<String> keepPlaying = Optional.empty();` // An empty Optional of String
- `Optional<Integer> maxValue = Optional.of(-1);` // An Optional containing the value -1

Like a collection, Optional uses `<>` to denote the type it contains:
- e.g., `Optional<String>`, `Optional<Integer>`, `Optional<Point>`

### Creating Optionals

| Method                | Description                                      | Example                                 |
|----------------------|--------------------------------------------------|-----------------------------------------|
| `Optional.empty()`   | Creates an empty Optional object                  | `Optional<String> opt = Optional.empty();` |
| `Optional.of(value)` | Creates an Optional holding the given value       | `Optional<Integer> opt = Optional.of(42);` |
| `Optional.ofNullable(value)` | Creates an Optional that is empty if value is null, otherwise holds the value | `Optional<String> opt = Optional.ofNullable(maybeNull);` |

*Use `Optional.of()` only if you are sure the value is not null. If the value might be null, use `Optional.ofNullable()` to avoid exceptions.*

## Optional Methods

| Method         | Description                                                      | Example                                 |
|--------------- |------------------------------------------------------------------|-----------------------------------------|
| `isEmpty()`    | Returns true if there is no value stored, false otherwise        | `keepPlaying.isEmpty()`                 |
| `isPresent()`  | Returns true if there is a value stored, false otherwise         | `keepPlaying.isPresent()`               |
| `get()`        | Returns the stored object from the Optional (if present; otherwise throws a NoSuchElementException) | `keepPlaying.get()` |

**Note:** `isEmpty()`, `isPresent()`, and `get()` are called like normal instance methods (on an actual instance of Optional). 

### Example Usage
```java
Optional<String> name = Optional.of("Bob"); // Create an Optional containing "Bob"
if (name.isPresent()) { // Check if a value is present
    System.out.println("Name: " + name.get()); // Safe to call get() here
} else {
    System.out.println("No name present");
}
```
*This code checks if the Optional contains a value before calling `get()`. This prevents exceptions and makes the code safer.*

### Safer Access with ifPresent
Instead of using `isPresent()` and `get()`, you can use `ifPresent()` to execute code only if a value is present:
```java
name.ifPresent(n -> System.out.println("Name: " + n)); // Only prints if value is present
```
*The lambda expression (`n -> ...`) runs only if the Optional contains a value. This is a concise and safe way to use the value.*

### Avoiding get() Without Check
Calling `get()` on an empty Optional will throw an exception. Always check with `isPresent()` or use methods like `orElse()`:
```java
String value = name.orElse("Default Name"); // Returns the value if present, otherwise "Default Name"
System.out.println(value); // Prints "Bob" if present, otherwise "Default Name"
```
*`orElse()` provides a default value if the Optional is empty, so you never get an exception.*

## Best Practices
- Use `Optional` as a return type, not for fields or parameters. This signals to the caller that a value may be missing.
- Avoid calling `get()` without checking presence. Use `ifPresent()`, `orElse()`, or similar methods.
- Prefer methods like `orElse()`, `orElseGet()`, and `ifPresent()` for safe access.
- Do not use `Optional` for every nullable value; use it when it adds clarity.

## Common Pitfalls
- Do **not** use `Optional` for serialization or as a class field. It's meant for return values.
- Avoid wrapping collections or arrays in `Optional` (e.g., use empty collections instead).

## Student / Course Example one more time…

Let’s add two more methods to `Course.java`: 

```java
// Field in Course class
private Optional<String> evalLink = Optional.empty(); // Initially, no link is set

// Sets the evaluation link. If url is null, evalLink becomes empty.
public void setCourseEvalLink(String url) {
    this.evalLink = Optional.ofNullable(url); // Handles null safely
}

// Returns the evaluation link, if present
public Optional<String> getCourseEvalLink() {
    return evalLink;
}
```
*Here, `evalLink` is an Optional that may or may not contain a link. The setter uses `ofNullable` to handle null values safely.*

The link to the evaluations for a course doesn’t usually exist until the last few weeks of the quarter. What if a client calls `getCourseEvalLink` before one is set up? 
Optional to the rescue! 🦸🏻‍♀️

**Example usage:**
```java
Optional<String> evalLink = course.getCourseEvalLink(); // Get the Optional
// Print the link if present, otherwise print a message
System.out.println(evalLink.orElse("No evaluation link available yet."));

// Or, using ifPresent:
evalLink.ifPresent(link -> System.out.println("Eval link: " + link));
```
*These examples show how to safely access the evaluation link, only printing it if it exists, or providing a default message if it does not.*

