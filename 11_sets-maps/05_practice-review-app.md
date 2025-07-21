# Practice, Reviews, and Applications

Practice Problem:
Write a program that, given a Scanner over a large
text file (e.g., Moby Dick or the complete works of
William Shakespeare), counts the number of unique
words in the text.

---
**Java Concept: Using a Set to Count Unique Words**

A `Set` in Java is a collection that does not allow duplicate elements. This makes it perfect for counting unique words, because adding a word that already exists in the set does nothing.

**Example:**
```java
import java.util.*;
import java.io.*;

public class UniqueWordCounter {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a Set to store unique words
        Set<String> uniqueWords = new HashSet<>();
        // Scanner to read from a file (replace "input.txt" with your file)
        Scanner scanner = new Scanner(new File("input.txt"));

        // Read each word from the file
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase(); // Convert to lowercase for case-insensitive comparison
            uniqueWords.add(word); // Add word to the set
        }

        // The size of the set is the number of unique words
        System.out.println("Number of unique words: " + uniqueWords.size());
    }
}
```
*Comments:*
- `HashSet` is used for fast insertion and lookup.
- Converting to lowercase ensures "Word" and "word" are treated the same.
- No need to check for duplicates; the set handles it.

---

Choosing a Data Structure: Tradeoffs
• You got a bit of practice with this in your quiz sections on
Tuesday!
Queue
- Solving the same problem with an ArrayList, a Stack, and a
• Things to consider:
- Functionality
- If you need duplicates or indexing, Sets are not for you!
- Efficiency
- Different data structures are “good at” different things!

---
**Java Concept: Data Structure Tradeoffs**

- **ArrayList**: Good for fast access by index, allows duplicates, but slow to check if an item exists.
- **Stack**: Last-In-First-Out (LIFO) structure, useful for undo features or parsing.
- **Queue**: First-In-First-Out (FIFO) structure, useful for processing items in order.
- **Set**: No duplicates, fast existence checks, but no indexing.

*Tip: Always choose the data structure that matches your needs for speed, memory, and functionality!*

---

Practice

What output is produced by this code?

Set<Integer> nums = new
TreeSet<>();
nums.add(3);
nums.add(9);
nums.add(3);
nums.add(-2);
nums.add(0);

for (int n : nums) {
    System.out.print(n + " ");
}

A. -2 0 3 9

B. 3 9 3 -2 0

C. 9 3 0 -2

D. -2 0 3 3 9

E. ConcurrentModificationException

---
**Java Concept: TreeSet and Set Behavior**

A `TreeSet` stores elements in sorted (ascending) order and does not allow duplicates.

**Example:**
```java
Set<Integer> nums = new TreeSet<>();
nums.add(3);
nums.add(9);
nums.add(3); // Duplicate, will be ignored
nums.add(-2);
nums.add(0);

for (int n : nums) {
    System.out.print(n + " ");
}
// Output: -2 0 3 9
```
*Comments:*
- `TreeSet` automatically sorts the numbers.
- Duplicates (like the second `3`) are ignored.
- The output is always in sorted order.

---

Practice

Select the method calls required to modify the given map m as follows:

Assume m’s contents are
	98030="Kent"
	98178="Seattle"
	98166="Burien"
	98041="Bothell"

We want to modify m so that its contents are 
	98030="Kent"
	98178="Tukwila"
	98166="Burien"
	98041="Bothell"
	98101="Seattle"
	98126="Seattle"

A. m.put(98178, "Tukwila");

B. m.remove(98178);

C. m.put(98126, "Seattle");

D. m.get(98178, "Seattle");

E. m.put(98101, "Seattle");

---
**Java Concept: Map Operations**

A `Map` stores key-value pairs. The most common implementation is `HashMap`.
- `put(key, value)` adds or updates a key-value pair.
- `remove(key)` deletes a key-value pair.
- `get(key)` retrieves the value for a key.

**Example:**
```java
Map<Integer, String> m = new HashMap<>();
m.put(98030, "Kent");
m.put(98178, "Seattle");
m.put(98166, "Burien");
m.put(98041, "Bothell");

// Update value for 98178
m.put(98178, "Tukwila");
// Add new entries
m.put(98101, "Seattle");
m.put(98126, "Seattle");

System.out.println(m);
```
*Comments:*
- `put` updates if the key exists, adds if it doesn't.
- `remove` deletes a key-value pair.
- `get` retrieves a value (but does not add or update).

---

Practice:

joinRosters

Write a method joinRosters that combines a Map from student name to quiz section, and a Map from TA name to quiz section and prints all pairs of students/TAs. 

For example, if studentSections stores the following map: 
{Alan=AC, Jerry=AB, Yueying=AA, Sharon=AB, Steven=AB, Zewditu=BA}

And taSections stores the following map
{Ayush=BA, Marcus=AA, Aishah=AB, Chaafen=AC}

AC: Alan - Chaafen  
AB: Jerry - Aishah AB: Sharon - Aishah AB: Steven - Aishah AA: Yueying – Marcus BA: Zewditu – Ayush

---
**Java Concept: Combining Two Maps by Value**

You can combine information from two maps by matching values (e.g., quiz section) and printing all pairs.

**Example:**
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
*Comments:*
- Use nested loops to compare each student with each TA.
- Match on the section value.

---

mostFrequentStart

Write a method called mostFrequentStart that takes a Set of words and does the following steps: 
Organizes words into “word families” based on which letter they start with
Selects the largest “word family” as defined as the family with the most words in it
Returns the starting letter of the largest word family (and if time, should update the Set of words to only have words from the selected family). 

For example, if the Set words stored the values
["hello", "goodbye", "library", "literary", "little", "repel"]

The word families produced would be 
'h' -> 1 word ("hello")
'g' -> 1 word ("goodbye")
'l' -> 3 words ("library", "literary", "little")
'r' -> 1 word ("repel")

Since 'l' has the largest word family, we return 'l' and modify the Set to only contain Strings starting with 'l'. 

---
**Java Concept: Grouping Words by Starting Letter and Finding the Largest Group**

To group words by their starting letter, use a `Map<Character, List<String>>`. To find the largest group, track the size of each list.

**Example:**
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
*Comments:*
- `putIfAbsent` ensures a list exists for each starting letter.
- `retainAll` keeps only the words from the largest family in the set.
- This approach is efficient and easy to understand for grouping and filtering. 