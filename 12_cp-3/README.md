# Mini Checkpoint Project: Unique Words Analyzer

## Overview

In this project, you will build a Java program that analyzes a text file to find:
- All unique words (case-insensitive)
- The frequency of each word
- The most common word(s)
- The number of words that appear only once

You will use Java’s Set and Map collections to accomplish these tasks.

---

## Requirements

1. **Read a text file** (e.g., `sample.txt`) containing several lines of text.
2. **Extract words** from the file (ignore punctuation, treat words case-insensitively).
3. **Store all unique words** in a `Set<String>`.
4. **Count the frequency** of each word using a `Map<String, Integer>`.
5. **Display:**
   - The total number of unique words.
   - The 5 most common words and their counts.
   - The number of words that appear only once.
   - (Optional) Any other interesting statistics you discover!

---

## Example Output

```
Total unique words: 123
Top 5 most common words:
the: 15
and: 12
to: 10
of: 9
a: 8
Words that appear only once: 54
```

---

## Hints

- Use `HashSet` for unique words.
- Use `HashMap` for word counts.
- Use `Scanner` or `BufferedReader` to read the file.
- Use `String.replaceAll("[^a-zA-Z]", "")` to remove punctuation.
- Convert words to lowercase for case-insensitive comparison.
- To find the top 5, sort the map entries by value.

---

## Stretch Ideas (if you finish early)

- Allow the user to specify the file name.
- Ignore common "stop words" (like "the", "and", "of").
- Output results to a new file.
- Visualize word frequencies with a simple text-based histogram.

---

## Submission

- Submit your Java source file(s) and a sample input file.
- Include comments explaining your code and your approach.
