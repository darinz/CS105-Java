# Practice, Reviews, and Applications

## Understanding Java Interfaces and Inheritance

In Java, **interfaces** are abstract types that specify a set of methods that implementing classes must provide. Interfaces can extend other interfaces, allowing for a form of multiple inheritance (of type, not implementation). Let's break down the concepts and see annotated examples.

### Defining Interfaces

```java
// Interface A declares a single method a()
public interface A {
    void a(); // All interface methods are implicitly public and abstract
}

// Interface B extends A, so it inherits method a() and adds method b()
public interface B extends A {
    void b();
}

// Interface C is independent and declares method c()
public interface C {
    void c();
}

// Interface D extends A, so it inherits method a() and adds methods d() and e()
public interface D extends A {
    void d();
    void e();
}
```

### Implementing Interfaces in Classes

```java
// Class One implements A, so it must provide an implementation for a()
public class One implements A {
    public void a() {
        System.out.println("One.a()");
    }
}

// Class Two implements both B and D, so it must implement a(), b(), d(), and e()
public class Two implements B, D {
    public void a() { System.out.println("Two.a()"); }
    public void b() { System.out.println("Two.b()"); }
    public void d() { System.out.println("Two.d()"); }
    public void e() { System.out.println("Two.e()"); }
}

// Class Three implements B and C, so it must implement a(), b(), and c()
public class Three implements B, C {
    public void a() { System.out.println("Three.a()"); }
    public void b() { System.out.println("Three.b()"); }
    public void c() { System.out.println("Three.c()"); }
}
```

---

## Practice: Which Statements Cause Errors?

Select all of the following statements that would cause a **compile-time error**. For each, we explain why.

### Code Statements

A)
```java
B w = new Two();
w.b(); // OK: Two implements B, so b() is available
```
**Explanation:** This is valid. `Two` implements `B`, so you can assign a `Two` object to a `B` reference and call `b()`.

---

B)
```java
B x = new Two();
x.e(); // ERROR: e() is not declared in B
```
**Explanation:** This causes a compile-time error. The reference type is `B`, which does **not** declare method `e()`. Even though `Two` implements `e()`, you cannot call it through a `B` reference. You would need to cast to `D`:

```java
((D)x).e(); // This works if x is actually a Two
```

---

C)
```java
D y = new Three();
y.b(); // ERROR: Three does not implement D
```
**Explanation:** This causes a compile-time error. `Three` does **not** implement `D`, so you cannot assign a `Three` object to a `D` reference.

---

D)
```java
C z = new Three();
z.c(); // OK: Three implements C
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
- **Interface references** can only call methods declared in the interface type.
- **Multiple interfaces** can be implemented by a class, but you must implement all required methods.
- **Extending interfaces** allows for building more complex types from simpler ones.
- **Casting** may be required to access methods from other interfaces if the reference type does not declare them.

---

Feel free to experiment with these examples in your own Java environment to deepen your understanding!
