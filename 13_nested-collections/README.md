# Nested Collections in Java

Nested collections are collections that contain other collections as their elements or values. In Java, this allows you to model complex relationships and groupings in your data, such as a map from course names to sets of students, or a map from genres to lists of books.

---

## Why Use Nested Collections?
- **Group related data:** E.g., students in each course section.
- **Model real-world relationships:** E.g., recipes and their ingredients, or a library and its books by genre.
- **Flexible data structures:** You can mix and match types, such as `Map<String, Set<String>>` or `Map<String, Map<String, Double>>`.

---

## Common Patterns
- `Map<String, Set<String>>`: Section to set of students
- `Map<String, List<String>>`: Genre to list of books
- `Map<String, Map<String, Double>>`: Course to (student to grade)

---

## Example: Map from Course Name to Set of Students
```java
Map<String, Set<String>> courses = new HashMap<>();
courses.put("CSE 123", new HashSet<>()); // Add course
courses.get("CSE 123").add("Nathan");   // Add student
```
- The value in the map is a reference to a collection. Modifying the set via the reference updates the map.
- You do not need to put the set back into the map after modifying it.

---

## Example: Map of Maps for Grades
```java
Map<String, Map<String, Double>> courseGrades = new HashMap<>();
courseGrades.put("CSE 123", new HashMap<>());
courseGrades.get("CSE 123").put("Nathan", 95.0);
```
- This pattern allows you to store grades for each student in each course.

---

## Tips and Gotchas
- Always check if a key exists before calling `get()` to avoid `NullPointerException`.
- Use `containsKey()` or `computeIfAbsent()` for safe access and initialization.
- Remember: collections are referenced by their variable, so changes via one reference affect all references to the same object.

---

## Practice Problems & Applications

### 1. Map Mutation and Reference Behavior
- **Concept:** Reference semantics in nested collections.
- **Example:**
    ```java
    Map<String, Set<Integer>> map = new HashMap<>();
    map.put("KeyA", new HashSet<>(Arrays.asList(1, 2)));
    Set<Integer> nums = map.get("KeyA");
    nums.add(7);
    map.put("KeyB", nums);
    map.get("KeyA").add(8);
    map.get("KeyB").add(9);
    System.out.println(map);
    ```
- **Key Point:** `KeyA` and `KeyB` can end up sharing the same set object!

### 2. Social Network - Friends List
- **Concept:** Map of lists, avoiding duplicates.
- **Example:**
    ```java
    public static void addFriend(Map<String, List<String>> friends, String user1, String user2) {
        friends.computeIfAbsent(user1, k -> new ArrayList<>());
        friends.computeIfAbsent(user2, k -> new ArrayList<>());
        if (!friends.get(user1).contains(user2)) friends.get(user1).add(user2);
        if (!friends.get(user2).contains(user1)) friends.get(user2).add(user1);
    }
    ```
- **Key Point:** Use `computeIfAbsent` and `contains` to avoid duplicates and ensure symmetry.

### 3. Student Courses Map
- **Concept:** Map from student to list of courses.
- **Example:**
    ```java
    public static void addCourse(Map<String, List<String>> studentCourses, String student, String course) {
        studentCourses.computeIfAbsent(student, k -> new ArrayList<>()).add(course);
    }
    ```
- **Key Point:** `computeIfAbsent` is concise and safe for initializing nested collections.

### 4. Unique Words in Sentences
- **Concept:** Collecting unique items from nested lists.
- **Example:**
    ```java
    public static Set<String> getUniqueWords(List<List<String>> sentences) {
        Set<String> uniqueWords = new HashSet<>();
        for (List<String> sentence : sentences) {
            uniqueWords.addAll(sentence);
        }
        return uniqueWords;
    }
    ```
- **Key Point:** Use a `Set` to collect unique values from nested lists.

### 5. Invert a Map of Lists
- **Concept:** Map inversion for fast lookup.
- **Example:**
    ```java
    public static Map<String, String> invertMap(Map<String, List<String>> categoryItems) {
        Map<String, String> itemCategory = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : categoryItems.entrySet()) {
            String category = entry.getKey();
            for (String item : entry.getValue()) {
                itemCategory.put(item, category);
            }
        }
        return itemCategory;
    }
    ```
- **Key Point:** Nested loops let you invert the mapping.

### 6. Count Occurrences in Nested Lists
- **Concept:** Counting with maps and nested iteration.
- **Example:**
    ```java
    public static Map<Integer, Integer> countOccurrences(List<List<Integer>> groups) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (List<Integer> group : groups) {
            for (Integer num : group) {
                counts.put(num, counts.getOrDefault(num, 0) + 1);
            }
        }
        return counts;
    }
    ```
- **Key Point:** `getOrDefault` simplifies counting logic.

### 7. Remove Duplicates from Nested Lists
- **Concept:** Using sets to remove duplicates from lists.
- **Example:**
    ```java
    public static List<Set<Integer>> removeDuplicates(List<List<Integer>> groups) {
        List<Set<Integer>> result = new ArrayList<>();
        for (List<Integer> group : groups) {
            result.add(new HashSet<>(group));
        }
        return result;
    }
    ```
- **Key Point:** Convert lists to sets to remove duplicates easily.

---

## Summary
- Nested collections are powerful for modeling complex data.
- Always be mindful of reference semantics—modifying a collection via one reference affects all references to it.
- Use utility methods like `computeIfAbsent` and `getOrDefault` for safer, cleaner code.
- Practice with the examples above to master nested collections in Java! 