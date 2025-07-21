# Nested Collections

In Java, collections like `List`, `Set`, and `Map` can themselves hold other collections as their elements or values. This is called **nested collections**. It's a powerful way to represent complex relationships in data.

## Why Use Nested Collections?

- **Grouping related data:** For example, you might want to keep track of which students are in each course section.
- **Modeling real-world relationships:** Like recipes and their ingredients, or a library and its books by genre.
- **Flexible data structures:** You can mix and match types, e.g., a `Map<String, Set<String>>` or even a `Map<String, Map<String, Double>>`.

### Common Examples
- **Mapping:** Section ➔ Set of students in that section
- **Mapping:** Recipe ➔ Set of ingredients in that recipe
- **Mapping:** Course ➔ Map of student ➔ grade
- **Mapping:** Department ➔ List of courses

---

## Example: Map from Course Name to Set of Students

Suppose we want to keep track of which students are enrolled in each course. We can use a `Map<String, Set<String>>`:

```java
import java.util.*;

public class NestedCollectionsExample {
    public static void main(String[] args) {
        // Create a Map where the key is the course name, and the value is a Set of student names
        Map<String, Set<String>> courses = new HashMap<>();

        // Add a new course with an empty set of students
        courses.put("CSE 123", new HashSet<>()); // Now, "CSE 123" maps to an empty set

        // Add a student to the set for "CSE 123"
        courses.get("CSE 123").add("Nathan"); // The set now contains "Nathan"

        // You can get the set and store it in a variable
        Set<String> cse123 = courses.get("CSE 123");
        cse123.add("Joe"); // Now the set contains "Nathan" and "Joe"

        // Print all students in CSE 123
        System.out.println("Students in CSE 123: " + courses.get("CSE 123"));
    }
}
```

### Key Points
- The **value** inside the Map is a reference to a data structure (like a Set or List).
- When you retrieve the set with `courses.get("CSE 123")`, you get a reference to the actual set stored in the map. Changes to this set are reflected in the map.
- If you want to add a student to a course, you don't need to put the set back into the map—just modify the set directly.

---

## Updating Nested Collections

Because the value in the map is a reference, you can update the collection directly:

```java
courses.get("CSE 123").add("Alex"); // Adds Alex to the set for CSE 123
```

If you want to add a new course, you must first create a new set:

```java
courses.put("CSE 124", new HashSet<>()); // Add new course
courses.get("CSE 124").add("Maria");   // Add Maria to CSE 124
```

---

## More Complex Example: Map of Maps

Suppose you want to store grades for each student in each course:

```java
Map<String, Map<String, Double>> courseGrades = new HashMap<>();

// Add a course
courseGrades.put("CSE 123", new HashMap<>());

// Add a student's grade
courseGrades.get("CSE 123").put("Nathan", 95.0);
courseGrades.get("CSE 123").put("Joe", 88.5);

// Access a student's grade
Double nathanGrade = courseGrades.get("CSE 123").get("Nathan");
System.out.println("Nathan's grade: " + nathanGrade);
```

---

## Tips and Gotchas
- Always check if the key exists before calling `get()` to avoid `NullPointerException`.
- You can use `containsKey()` to check if a course or student exists.
- When working with nested collections, be careful about modifying the same collection from multiple places (references!).

---

## Practice

Let's walk through a complete, annotated example for the practice problem:

### Problem
Create a `Map<String, List<String>>` to represent a library where each genre maps to a list of book titles. Add some genres and books, then print out all books in a given genre.

### Annotated Java Example

```java
import java.util.*;

public class LibraryExample {
    public static void main(String[] args) {
        // Create a Map where the key is the genre (e.g., "Fantasy"),
        // and the value is a List of book titles in that genre.
        Map<String, List<String>> library = new HashMap<>();

        // Add some genres with empty lists
        library.put("Fantasy", new ArrayList<>()); // "Fantasy" genre with no books yet
        library.put("Science Fiction", new ArrayList<>()); // "Science Fiction" genre
        library.put("Mystery", new ArrayList<>()); // "Mystery" genre

        // Add books to the genres
        library.get("Fantasy").add("The Hobbit");
        library.get("Fantasy").add("Harry Potter and the Sorcerer's Stone");
        library.get("Science Fiction").add("Dune");
        library.get("Science Fiction").add("Ender's Game");
        library.get("Mystery").add("The Hound of the Baskervilles");

        // Print all books in a given genre
        String genreToPrint = "Fantasy";
        System.out.println("Books in the genre '" + genreToPrint + "':");
        for (String book : library.get(genreToPrint)) {
            System.out.println("- " + book);
        }

        // Print all genres and their books
        System.out.println("\nAll genres and their books:");
        for (String genre : library.keySet()) {
            System.out.println(genre + ": " + library.get(genre));
        }
    }
}
```

#### Explanation
- **Map<String, List<String>> library**: The key is the genre name, and the value is a list of book titles.
- **library.put("Fantasy", new ArrayList<>())**: Adds a new genre with an empty list of books.
- **library.get("Fantasy").add("The Hobbit")**: Adds a book to the list for the "Fantasy" genre.
- **Printing books**: You can loop through the list for a genre, or print all genres and their books.

#### Key Concepts
- The value in the map is a reference to a list, so you can add books directly to it.
- Always make sure the genre exists in the map before calling `get()`.
- This pattern is useful for grouping items by category.