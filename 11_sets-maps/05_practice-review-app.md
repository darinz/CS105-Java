# Practice, Reviews, and Applications

---
## Practice Problem 1: Counting Unique Words

**Problem Statement:**
Write a program that, given a Scanner over a large text file (e.g., Moby Dick or the complete works of William Shakespeare), counts the number of unique words in the text.

**How to Approach:**
1. Read each word from the file using a Scanner.
2. Store each word in a Set (like HashSet) to automatically filter out duplicates.
3. After reading all words, the size of the Set is the number of unique words.

**Step-by-Step Solution:**
```java
import java.util.*;
import java.io.*;

public class UniqueWordCounter {
    public static void main(String[] args) throws FileNotFoundException {
        // 1. Create a Set to store unique words
        Set<String> uniqueWords = new HashSet<>();
        // 2. Create a Scanner to read from a file
        Scanner scanner = new Scanner(new File("input.txt"));

        // 3. Read each word, convert to lowercase, and add to the set
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            uniqueWords.add(word);
        }

        // 4. Output the number of unique words
        System.out.println("Number of unique words: " + uniqueWords.size());
    }
}
```
**Explanation:**
- Using a Set ensures each word is only counted once.
- Converting to lowercase treats "Word" and "word" as the same.
- The final size of the Set gives the answer.

---
## Practice Problem 2: Set Output and TreeSet Behavior

**Problem Statement:**
What output is produced by this code?
```java
Set<Integer> nums = new TreeSet<>();
nums.add(3);
nums.add(9);
nums.add(3);
nums.add(-2);
nums.add(0);

for (int n : nums) {
    System.out.print(n + " ");
}
```
A. -2 0 3 9
B. 3 9 3 -2 0
C. 9 3 0 -2
D. -2 0 3 3 9
E. ConcurrentModificationException

**How to Approach:**
1. Remember that a Set does not allow duplicates.
2. TreeSet stores elements in sorted order.
3. The for-each loop prints elements in the order stored by the TreeSet.

**Explanation:**
- The duplicate `3` is ignored.
- The numbers are sorted: -2, 0, 3, 9.
- The output is: `-2 0 3 9` (Answer A).

---
## Practice Problem 3: Modifying a Map

**Problem Statement:**
Select the method calls required to modify the given map `m` as follows:

Assume m’s contents are:
- 98030="Kent"
- 98178="Seattle"
- 98166="Burien"
- 98041="Bothell"

We want to modify m so that its contents are:
- 98030="Kent"
- 98178="Tukwila"
- 98166="Burien"
- 98041="Bothell"
- 98101="Seattle"
- 98126="Seattle"

A. m.put(98178, "Tukwila");
B. m.remove(98178);
C. m.put(98126, "Seattle");
D. m.get(98178, "Seattle");
E. m.put(98101, "Seattle");

**How to Approach:**
1. Use `put` to add or update entries in a map.
2. `remove` deletes an entry, but we want to update, not remove.
3. `get` only retrieves a value, not add or update.

**Solution:**
- Use A, C, and E.
- A updates 98178 to "Tukwila".
- C and E add new entries for 98126 and 98101 with value "Seattle".

**Explanation:**
- `put` updates if the key exists, adds if it doesn't.
- `remove` would delete, which is not needed here.
- `get` does not modify the map.

---
## Practice Problem 4: joinRosters

**Problem Statement:**
Write a method `joinRosters` that combines a Map from student name to quiz section, and a Map from TA name to quiz section, and prints all pairs of students/TAs in the same section.

**How to Approach:**
1. For each student, find their section.
2. For each TA, check if their section matches the student's section.
3. Print all matching pairs.

**Step-by-Step Solution:**
```java
Map<String, String> studentSections = new HashMap<>();
studentSections.put("Alan", "AC");
studentSections.put("Jerry", "AB");
// ... add more students

Map<String, String> taSections = new HashMap<>();
taSections.put("Ayush", "BA");
taSections.put("Marcus", "AA");
// ... add more TAs

for (Map.Entry<String, String> student : studentSections.entrySet()) {
    for (Map.Entry<String, String> ta : taSections.entrySet()) {
        // If student and TA are in the same section, print the pair
        if (student.getValue().equals(ta.getValue())) {
            System.out.println(student.getValue() + ": " + student.getKey() + " - " + ta.getKey());
        }
    }
}
```
**Explanation:**
- Nested loops compare each student with each TA.
- If their sections match, print the pair.
- This prints all student-TA pairs for each section.

---
## Practice Problem 5: mostFrequentStart

**Problem Statement:**
Write a method called `mostFrequentStart` that takes a Set of words and does the following:
1. Organizes words into “word families” based on their starting letter.
2. Selects the largest “word family” (the family with the most words).
3. Returns the starting letter of the largest word family.
4. (Optional) Updates the Set to only have words from the selected family.

**How to Approach:**
1. Use a Map to group words by their starting letter.
2. Track which group is largest.
3. Return the starting letter of the largest group.
4. Optionally, filter the Set to only keep words from that group.

**Step-by-Step Solution:**
```java
Set<String> words = new HashSet<>(Arrays.asList("hello", "goodbye", "library", "literary", "little", "repel"));
Map<Character, List<String>> families = new HashMap<>();

// Group words by starting letter
for (String word : words) {
    char start = word.charAt(0); // Get the first letter
    families.putIfAbsent(start, new ArrayList<>()); // Create a new list if needed
    families.get(start).add(word); // Add the word to the correct list
}

// Find the largest family
char maxChar = 0;
int maxSize = 0;
for (Map.Entry<Character, List<String>> entry : families.entrySet()) {
    if (entry.getValue().size() > maxSize) {
        maxChar = entry.getKey();
        maxSize = entry.getValue().size();
    }
}

System.out.println("Largest word family starts with: " + maxChar);

// (Optional) Keep only words from the largest family
words.retainAll(families.get(maxChar));
System.out.println("Words in the largest family: " + words);
```
**Explanation:**
- The Map groups words by their first letter.
- The largest group is found by comparing sizes.
- The Set is optionally filtered to only keep words from the largest group.
- This approach is efficient and easy to understand for grouping and filtering.

--- 