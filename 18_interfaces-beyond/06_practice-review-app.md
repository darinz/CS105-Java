# Practice, Reviews, and Applications

## Understanding Java Interfaces and Inheritance

In Java, **interfaces** are abstract types that specify a set of methods that implementing classes must provide. Interfaces can extend other interfaces, allowing for a form of multiple inheritance (of type, not implementation). Let's break down the concepts and see annotated examples.

---

### Defining Interfaces

```java
// Interface A declares a single method a().
// Any class that implements A must provide a concrete implementation for a().
public interface A {
    void a(); // All interface methods are implicitly public and abstract
}

// Interface B extends A, so it inherits method a() from A and adds its own method b().
// Any class that implements B must implement both a() and b().
public interface B extends A {
    void b(); // New method specific to B
}

// Interface C is independent and declares its own method c().
public interface C {
    void c(); // Method specific to C
}

// Interface D extends A, so it inherits a() and adds two new methods: d() and e().
public interface D extends A {
    void d(); // Method specific to D
    void e(); // Another method specific to D
}
```

**Key Points:**
- Interfaces can extend other interfaces, inheriting their method signatures.
- A class implementing an interface must provide concrete implementations for all its methods (including inherited ones).
- Interfaces cannot have instance fields (only static final constants).

---

### Implementing Interfaces in Classes

```java
// Class One implements interface A, so it must provide an implementation for a().
public class One implements A {
    @Override // Annotation to indicate this method implements a method from an interface
    public void a() {
        System.out.println("One.a()"); // Print a message to show this method is called
    }
}

// Class Two implements both B and D.
// Since B extends A and D extends A, Two must implement all methods from A, B, and D: a(), b(), d(), and e().
public class Two implements B, D {
    @Override
    public void a() { System.out.println("Two.a()"); }
    @Override
    public void b() { System.out.println("Two.b()"); }
    @Override
    public void d() { System.out.println("Two.d()"); }
    @Override
    public void e() { System.out.println("Two.e()"); }
}

// Class Three implements B and C.
// It must implement all methods from B (which includes a() from A) and c() from C.
public class Three implements B, C {
    @Override
    public void a() { System.out.println("Three.a()"); }
    @Override
    public void b() { System.out.println("Three.b()"); }
    @Override
    public void c() { System.out.println("Three.c()"); }
}
```

**Key Points:**
- The `@Override` annotation is optional but recommended; it helps catch errors if the method signature does not match the interface.
- A class can implement multiple interfaces, separated by commas.
- The class must implement all methods from all interfaces it declares.

---

## Practice: Which Statements Cause Errors?

Select all of the following statements that would cause a **compile-time error**. For each, we explain why.

### Code Statements

A)
```java
B w = new Two(); // Two implements B, so this is allowed
w.b();           // b() is declared in B, so this is valid
```
**Explanation:** This is valid. `Two` implements `B`, so you can assign a `Two` object to a `B` reference and call `b()`.

---

B)
```java
B x = new Two(); // Two implements B, so this is allowed
x.e();           // ERROR: e() is not declared in B, so this line causes a compile-time error
```
**Explanation:** This causes a compile-time error. The reference type is `B`, which does **not** declare method `e()`. Even though `Two` implements `e()`, you cannot call it through a `B` reference. You would need to cast to `D`:

```java
((D)x).e(); // This works if x is actually a Two
```

---

C)
```java
D y = new Three(); // ERROR: Three does not implement D, so this assignment is invalid
y.b();             // Even if it did, b() is not declared in D
```
**Explanation:** This causes a compile-time error. `Three` does **not** implement `D`, so you cannot assign a `Three` object to a `D` reference.

---

D)
```java
C z = new Three(); // Three implements C, so this is allowed
z.c();             // c() is declared in C, so this is valid
```
**Explanation:** This is valid. `Three` implements `C`, so you can assign a `Three` object to a `C` reference and call `c()`.

---

## Summary Table

| Statement | Error? | Reason |
|-----------|--------|--------|
| A         | No     | Valid: `Two` implements `B` |
| B         | Yes    | `e()` not in `B` interface |
| C         | Yes    | `Three` does not implement `D` |
| D         | No     | Valid: `Three` implements `C` |

---

## Key Takeaways
- **Interface references** can only call methods declared in the interface type, even if the object implements more methods.
- **Multiple interfaces** can be implemented by a class, but you must implement all required methods.
- **Extending interfaces** allows for building more complex types from simpler ones.
- **Casting** may be required to access methods from other interfaces if the reference type does not declare them.
- The `@Override` annotation helps ensure you are correctly implementing interface methods.

---

Feel free to experiment with these examples in your own Java environment to deepen your understanding! If you have questions about any part, ask for more details or examples.
