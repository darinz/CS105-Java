# Practice Exam 1 Solution


## 1. **Conceptual**: Each of these parts should be considered independent of the others.

**Part A**: (Select all that apply) Which of the following are true about Sets?

- [x] A TreeSet stores elements in sorted order
- [ ] A HashSet preserves the insertion order of its elements
- [x] A Set does not allow for duplicate values
- [x] A HashSet is generally more efficient than a TreeSet

**Part B**: Consider the following method. For each of the following commented checkpoints, fill in the table for which conditions are always true (under any circumstance), only sometimes true, or never true at each comment. You can abbreviate **A**=always, **S**=sometimes and **N**=never.

```java
public Set<Integer> mystery1(List<Integer> list, int num) {
    Set<Integer> result = new TreeSet<>();
    int n = 1;
    // Checkpoint A
    if (list.isEmpty()) {
        throw new IllegalArgumentException();
    }
    // Checkpoint B
    for (int i = 0; i < list.size(); i++) {
        n = list.get(i);
        // Checkpoint C
        if (n != 0 && num % n == 0) {
            list.remove(i);
            i--;
            result.add(n);
            // Checkpoint D
        }
    }
    // Checkpoint E
    return result;
}
```

|                      | Checkpoint A | Checkpoint B | Checkpoint C | Checkpoint D | Checkpoint E |
|----------------------|:------------:|:------------:|:------------:|:------------:|:------------:|
| list.isEmpty()       |      S       |      N       |      N       |      S       |      S       |
| num % n == 0         |      A       |      A       |      S       |      A       |      S       |
| result.isEmpty()     |      A       |      A       |      S       |      N       |      S       |

An explanation for Checkpoint A's example answers

list.isEmpty(): S
true for mystery([], 3) and false for mystery([1,2,3], 4). Therefore sometimes true.

num % n == 0: A
Any number mod 1 is 0, so this is always true.

result.isEmpty(): A
result was just initialized and nothing has been added yet. Therefore it is always empty here.


**Part C**: (Select one option) Consider the following method. Which of the following options is the best "plain-English" explanation of what the code is doing?

```java
public static Set<Integer> mystery2(Map<Integer, Set<Integer>> m) {
    Set<Integer> result = new HashSet<>();
    for (int num : m.keySet()) {
        Set<Integer> val = m.get(num);
        int sum = 0;
        for (int num2 : val) {
            sum += num2;
        }
        if (sum == num) {
            result.add(num);
        }
    }
    return result;
}
```

- ( ) Returns a set containing a subset of the keys of m
- ( ) Returns a set containing the sums of the inner sets in m
- ([x]) Returns a set of the keys of m that equal the sum of their inner sets in m
- ( ) Uses a for-each loop to look at each key from m to sum the numbers in the inner sets, adding the key to a set if the sum equals the associated key

