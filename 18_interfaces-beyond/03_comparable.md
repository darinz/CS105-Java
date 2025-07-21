# Comparable

Recall the Student / Course Example

Course stored a field 
    private List<Student> roster;

Why not use a Set to store the students?…

Seems like a great idea (no duplicates, not worried about keeping a specific order or indexing into it) but … Java reasons:
- **HashSet** won’t work because of lack of `hashCode()` and `equals()` implementation
    - In Java, `HashSet` uses the `hashCode()` and `equals()` methods to determine if two objects are the same. If you don't override these methods in your class, the default implementation from `Object` is used, which checks for reference equality (i.e., whether they are the exact same object in memory), not logical equality (e.g., two students with the same ID).
    - **Example:**
      ```java
      class Student {
          String name;
          int id;
          // No hashCode() or equals() overridden!
      }
      HashSet<Student> set = new HashSet<>();
      set.add(new Student("Alice", 1));
      set.add(new Student("Alice", 1)); // This will be added as a separate object!
      System.out.println(set.size()); // Output: 2
      ```
    - **Solution:** Override `equals()` and `hashCode()` in your class.
      ```java
      class Student {
          String name;
          int id;
          @Override
          public boolean equals(Object o) {
              if (this == o) return true;
              if (o == null || getClass() != o.getClass()) return false;
              Student student = (Student) o;
              return id == student.id;
          }
          @Override
          public int hashCode() {
              return Objects.hash(id);
          }
      }
      ```
- **TreeSet** won’t work because… what does it mean to “sort” Students? 
    - `TreeSet` requires its elements to be *sortable*. It uses the `Comparable` interface (or a `Comparator`) to determine the order of elements.
    - If you try to add objects to a `TreeSet` that don't implement `Comparable` (or you don't provide a `Comparator`), you'll get a runtime error.
    - **Example:**
      ```java
      class Student {
          String name;
          int id;
      }
      TreeSet<Student> set = new TreeSet<>();
      set.add(new Student("Alice", 1)); // Throws ClassCastException!
      ```
    - **Solution:** Implement `Comparable<Student>` in your class.
      ```java
      class Student implements Comparable<Student> {
          String name;
          int id;
          @Override
          public int compareTo(Student other) {
              return Integer.compare(this.id, other.id); // Sort by id
          }
      }
      TreeSet<Student> set = new TreeSet<>();
      set.add(new Student("Alice", 1));
      set.add(new Student("Bob", 2));
      // Now works! Students are sorted by id.
      ```

---

## The Comparable Interface

`TreeSet` uses an interface called `Comparable<E>` to know how to sort its elements!

**Comparable** is a generic interface with one required method:

```java
public int compareTo(E other)
```

- **Purpose:** Defines the *natural ordering* of objects of a class.
- **Return value:**
  - `< 0` if `this` is “less than” `other`
  - `0` if `this` is equal to `other`
  - `> 0` if `this` is “greater than” `other`

**Example: Sorting Students by Name**

```java
class Student implements Comparable<Student> {
    String name;
    int id;
    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name); // Alphabetical order
    }
}
```

**Best Practices:**
- The `compareTo` method should be consistent with `equals` (if `compareTo` returns 0, `equals` should return true).
- Avoid returning subtraction of fields (e.g., `return this.id - other.id;`) for `int` fields, as it can cause integer overflow. Use `Integer.compare(this.id, other.id)` instead.
- If you want a different order (e.g., descending), reverse the comparison: `return other.id - this.id;` or use `Integer.compare(other.id, this.id)`.

**Using TreeSet with Comparable:**

```java
TreeSet<Student> students = new TreeSet<>();
students.add(new Student("Alice", 2));
students.add(new Student("Bob", 1));
for (Student s : students) {
    System.out.println(s.name + " " + s.id);
}
// Output will be sorted by name or id, depending on compareTo implementation
```

**Summary:**
- Use `HashSet` for fast lookups, but you must override `equals` and `hashCode`.
- Use `TreeSet` for sorted sets, but you must implement `Comparable` (or provide a `Comparator`).
- Always document your `compareTo` logic so others know how your objects are ordered!

