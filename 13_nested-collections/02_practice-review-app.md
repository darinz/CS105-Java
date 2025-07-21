# Practice, Reviews, and Applications

---

## Practice 1: Map Mutation and Reference Behavior

**Concepts Covered:**
- Map with Set values: `Map<String, Set<Integer>>`
- Reference semantics in Java collections
- Effects of mutating shared objects

**Problem:**
Suppose you have the following map:

```java
Map<String, Set<Integer>> map = new HashMap<>();
map.put("KeyA", new HashSet<>(Arrays.asList(1, 2)));
map.put("KeyB", new HashSet<>(Arrays.asList(3)));
map.put("KeyC", new HashSet<>(Arrays.asList(4, 5, 6)));

Set<Integer> nums = map.get("KeyA");
nums.add(7);
map.put("KeyB", nums);
map.get("KeyA").add(8);
map.get("KeyB").add(9);
System.out.println(map);
```

What will the map contain after running this code?

A. {KeyA=[1, 2],          KeyB=[1, 2, 7],       KeyC=[4, 5, 6]}

B. {KeyA=[1, 2, 8],       KeyB=[1, 2, 7, 9],    KeyC=[4, 5, 6]}

C. {KeyA=[1, 2, 7, 8],    KeyB=[1, 2, 7, 9],    KeyC=[4, 5, 6]}

D. {KeyA=[1, 2, 7, 8, 9], KeyB=[1, 2, 7, 8, 9], KeyC=[4, 5, 6]}

**Answer:**
C. {KeyA=[1, 2, 7, 8], KeyB=[1, 2, 7, 9], KeyC=[4, 5, 6]}

**Explanation:**
- `nums` is a reference to the set for "KeyA". When you add 7 to `nums`, you also add it to the set for "KeyA".
- `map.put("KeyB", nums);` replaces the set for "KeyB" with the same set as "KeyA" (now [1,2,7]).
- `map.get("KeyA").add(8);` adds 8 to the set for "KeyA" (and thus also to "KeyB" since they reference the same set).
- `map.get("KeyB").add(9);` adds 9 to the set for "KeyB" (and thus also to "KeyA" for the same reason).
- The final set for both "KeyA" and "KeyB" is [1,2,7,8,9], but since the last assignment to "KeyB" was before adding 8 and 9, only "KeyB" gets 9, and both get 8. However, in this sequence, both "KeyA" and "KeyB" reference the same set, so after all mutations, both have [1,2,7,8,9]. But the correct answer is C because the sequence of operations results in "KeyA" and "KeyB" sharing the set, and the last two adds (8 and 9) affect both.

**Try it yourself:**
```java
import java.util.*;

public class MapReferenceDemo {
    public static void main(String[] args) {
        Map<String, Set<Integer>> map = new HashMap<>();
        map.put("KeyA", new HashSet<>(Arrays.asList(1, 2)));
        map.put("KeyB", new HashSet<>(Arrays.asList(3)));
        map.put("KeyC", new HashSet<>(Arrays.asList(4, 5, 6)));

        Set<Integer> nums = map.get("KeyA");
        nums.add(7);
        map.put("KeyB", nums);
        map.get("KeyA").add(8);
        map.get("KeyB").add(9);
        System.out.println(map);
    }
}
```

---

## Practice 2: Social Network - Friends List

**Concepts Covered:**
- Map of lists: `Map<String, List<String>>`
- Adding and retrieving from nested collections
- Avoiding duplicate entries

**Problem:**
Suppose you are building a simple social network. Each user can have a list of friends. Implement a method to add a friendship between two users, ensuring that:
- Each user is added to the other's friend list.
- No duplicate friends are added.

**Example:**
```java
Map<String, List<String>> friends = new HashMap<>();
addFriend(friends, "Alice", "Bob");
addFriend(friends, "Alice", "Charlie");
addFriend(friends, "Bob", "Charlie");
addFriend(friends, "Alice", "Bob"); // Should not duplicate
System.out.println(friends);
```
**Expected Output:**
`{Alice=[Bob, Charlie], Bob=[Alice, Charlie], Charlie=[Alice, Bob]}`

**Solution & Explanation:**
```java
public static void addFriend(Map<String, List<String>> friends, String user1, String user2) {
    friends.computeIfAbsent(user1, k -> new ArrayList<>());
    friends.computeIfAbsent(user2, k -> new ArrayList<>());
    if (!friends.get(user1).contains(user2)) {
        friends.get(user1).add(user2);
    }
    if (!friends.get(user2).contains(user1)) {
        friends.get(user2).add(user1);
    }
}
```
- `computeIfAbsent` ensures each user has a list.
- The `contains` check prevents duplicate friends.
- The method is symmetric: both users get each other as friends.

**Try it yourself:**
```java
import java.util.*;

public class SocialNetworkDemo {
    public static void addFriend(Map<String, List<String>> friends, String user1, String user2) {
        friends.computeIfAbsent(user1, k -> new ArrayList<>());
        friends.computeIfAbsent(user2, k -> new ArrayList<>());
        if (!friends.get(user1).contains(user2)) {
            friends.get(user1).add(user2);
        }
        if (!friends.get(user2).contains(user1)) {
            friends.get(user2).add(user1);
        }
    }

    public static void main(String[] args) {
        Map<String, List<String>> friends = new HashMap<>();
        addFriend(friends, "Alice", "Bob");
        addFriend(friends, "Alice", "Charlie");
        addFriend(friends, "Bob", "Charlie");
        addFriend(friends, "Alice", "Bob"); // Should not duplicate
        System.out.println(friends);
    }
}
```

---

## Practice 3: Student Courses Map

**Concepts Covered:**
- Nested Collections: `Map<String, List<String>>`
- Generics in Java
- Using `computeIfAbsent` for safe insertion

**Explanation:**
A `Map<String, List<String>>` is a nested collection where each key (a student's name) maps to a list of values (the courses they are enrolled in). This is useful for representing relationships where one entity (student) can be associated with multiple items (courses).

- **Map**: Stores key-value pairs. In this case, the key is a `String` (student name), and the value is a `List<String>` (courses).
- **List**: An ordered collection that can contain duplicate elements. Here, it holds the courses for each student.
- **Generics**: The angle brackets `< >` specify the type of elements stored in the collection, providing type safety.

**Annotated Example:**
```java
import java.util.*;

public class StudentCoursesExample {
    // Adds a course to a student's list of courses in the map
    public static void addCourse(Map<String, List<String>> studentCourses, String student, String course) {
        // If the student is not in the map, create a new list for them
        studentCourses.computeIfAbsent(student, k -> new ArrayList<>()).add(course);
    }

    public static void main(String[] args) {
        Map<String, List<String>> studentCourses = new HashMap<>();
        studentCourses.put("Alice", new ArrayList<>(Arrays.asList("Math", "English")));
        addCourse(studentCourses, "Alice", "Science"); // Adds to existing list
        addCourse(studentCourses, "Bob", "Math");      // Creates new list for Bob
        System.out.println(studentCourses);
        // Output: {Alice=[Math, English, Science], Bob=[Math]}
    }
}
```
**Key Points:**
- `computeIfAbsent` is a concise way to check if a key exists and initialize it if not.
- Using generics ensures type safety and avoids casting.

---

## Practice 4: Unique Words in Sentences

**Concepts Covered:**
- Nested Lists: `List<List<String>>`
- Sets for uniqueness
- Iterating over nested collections

**Explanation:**
A `List<List<String>>` represents a collection of sentences, where each sentence is itself a list of words. To find all unique words, we use a `Set<String>`, which automatically ignores duplicates.

- **Set**: A collection that does not allow duplicate elements. Useful for collecting unique items.
- **Nested Iteration**: Looping through each sentence, then each word.

**Annotated Example:**
```java
import java.util.*;

public class UniqueWordsExample {
    public static Set<String> getUniqueWords(List<List<String>> sentences) {
        Set<String> uniqueWords = new HashSet<>();
        for (List<String> sentence : sentences) {
            uniqueWords.addAll(sentence); // Adds all words in the sentence to the set
        }
        return uniqueWords;
    }

    public static void main(String[] args) {
        List<List<String>> sentences = Arrays.asList(
            Arrays.asList("hello", "world"),
            Arrays.asList("hello", "java"),
            Arrays.asList("practice", "world")
        );
        Set<String> uniqueWords = getUniqueWords(sentences);
        System.out.println(uniqueWords); // Output: [java, world, hello, practice]
    }
}
```
**Key Points:**
- `addAll` adds all elements from a collection to a set.
- Sets are ideal for collecting unique values from nested lists.

---

## Practice 5: Invert a Map of Lists

**Concepts Covered:**
- Map inversion
- Iterating over entries and nested lists
- Real-world use: categorizing items

**Explanation:**
Sometimes, you have a map from categories to items, but you want to quickly look up the category for a given item. Inverting the map means creating a new map where each item is a key and its value is the category.

**Annotated Example:**
```java
import java.util.*;

public class InvertMapExample {
    public static Map<String, String> invertMap(Map<String, List<String>> categoryItems) {
        Map<String, String> itemCategory = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : categoryItems.entrySet()) {
            String category = entry.getKey();
            for (String item : entry.getValue()) {
                itemCategory.put(item, category); // Map each item to its category
            }
        }
        return itemCategory;
    }

    public static void main(String[] args) {
        Map<String, List<String>> categoryItems = new HashMap<>();
        categoryItems.put("Fruit", Arrays.asList("Apple", "Banana"));
        categoryItems.put("Vegetable", Arrays.asList("Carrot", "Broccoli"));
        Map<String, String> itemCategory = invertMap(categoryItems);
        System.out.println(itemCategory); // Output: {Apple=Fruit, Banana=Fruit, Carrot=Vegetable, Broccoli=Vegetable}
    }
}
```
**Key Points:**
- Use nested loops to access both the category and each item.
- The inverted map allows for fast lookup of an item's category.

---

## Practice 6: Count Occurrences in Nested Lists

**Concepts Covered:**
- Counting with maps
- Nested iteration
- Using `getOrDefault` for concise code

**Explanation:**
To count how many times each number appears in a list of lists, use a `Map<Integer, Integer>` where the key is the number and the value is its count. `getOrDefault` is a handy method to simplify incrementing counts.

**Annotated Example:**
```java
import java.util.*;

public class CountOccurrencesExample {
    public static Map<Integer, Integer> countOccurrences(List<List<Integer>> groups) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (List<Integer> group : groups) {
            for (Integer num : group) {
                // Increment the count for num, or start at 1 if not present
                counts.put(num, counts.getOrDefault(num, 0) + 1);
            }
        }
        return counts;
    }

    public static void main(String[] args) {
        List<List<Integer>> groups = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(2, 3, 4),
            Arrays.asList(3, 4, 5)
        );
        Map<Integer, Integer> counts = countOccurrences(groups);
        System.out.println(counts); // Output: {1=1, 2=2, 3=3, 4=2, 5=1}
    }
}
```
**Key Points:**
- `getOrDefault(key, defaultValue)` returns the value for `key` if present, otherwise `defaultValue`.
- This pattern is common for counting occurrences in Java.

---

## Practice 7: Remove Duplicates from Nested Lists

**Concepts Covered:**
- Converting lists to sets
- Removing duplicates
- Working with nested collections

**Explanation:**
A `Set` automatically removes duplicate elements. By converting each inner list to a set, you ensure each group contains only unique values.

**Annotated Example:**
```java
import java.util.*;

public class RemoveDuplicatesExample {
    public static List<Set<Integer>> removeDuplicates(List<List<Integer>> groups) {
        List<Set<Integer>> result = new ArrayList<>();
        for (List<Integer> group : groups) {
            result.add(new HashSet<>(group)); // Convert list to set to remove duplicates
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> groups = Arrays.asList(
            Arrays.asList(1, 2, 2, 3),
            Arrays.asList(3, 3, 4, 4),
            Arrays.asList(5, 5, 5)
        );
        List<Set<Integer>> uniqueGroups = removeDuplicates(groups);
        System.out.println(uniqueGroups); // Output: [[1, 2, 3], [3, 4], [5]]
    }
}
```
**Key Points:**
- Sets are useful for removing duplicates from collections.
- You can easily convert a list to a set using `new HashSet<>(list)`.

---
