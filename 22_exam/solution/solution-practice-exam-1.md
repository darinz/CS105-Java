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


2. **Code Tracing:** Consider the method below.

```java
public static Set<Integer> superSecretMystery(int[][] arr) {
    Set<Integer> result = new TreeSet<>();
    for (int i = arr.length - 1; i >= 0; i--) {
        for (int j = 0; j < arr[i].length; j++) {
            result.add((j-i) * 10 + arr[i][j]);
        }
    }
    return result;
}
```

For each 2d array below, indicate the contents of the Set that superSecretMystery would return where it is passed as a parameter. Write the elements of the Set comma-separated with square brackets (for example: [1, 2, 0, 5])

| Input                | Returned Set         |
|----------------------|---------------------|
| [[3]]                | [3]                 |
| [[7],                | [-13, -3, 7]        |
|  [7],                |                     |
|  [7]]                |                     |
| [[2, 0, 4],          | [2, 10, 24]         |
|  [12, 10, 0]]        |                     |
| [[5, -5, 8, 0, 6]]   | [5, 28, 30, 46]     |


3. **Debugging:** Consider the following buggy implementation of `removeEvensInRange`. The intended behavior of this method is to take a list of integers, as well as integers start and end, and modify that list so that it removes the even numbers between indices start and end (exclusive). The method should also return the number of elements that were removed. For example, if a variable called list stores this sequence of values:

    [3, -1, 0, 2, 5, -10, 8]

Calling removeEvensInRange(list, 1, 5); should cause list to store the following sequence of values afterwards:

    [3, -1, 5, -10, 8]

Notice that the order from the original list is maintained. Assume that the given list is not empty and the inputs for start and end are valid indices of the original list.

A TA wrote a buggy implementation of this method shown below.

```java
public static int removeEvensInRange(List<Integer> list, int start, int end) {
    int count = 0;
    for (int i = start + 1; i < end; i++) {
        int num = list.get(i);
        if (num % 2 == 0) {
            count++;
            list.remove(i);
            i++;
            end--;
        }
    }
    return count;
}
```

**Part A:** There is a single bug in this program that is your task to find and fix. Identify the 1 line of code that causes the bug. Write your answer as a line number in the box to the right. For example, if you think line 13 has a bug, write 13 in the box.

**Part A Answer**

| Part A Answer |
|:-------------:|
|      8        |

**Part B:** Fix the error in the method above. Since there is only one bug, this should not take a lot of code to fix. Specifically mention which line(s) you will change and how. If you are deleting some code, make sure it's clear what parts are being removed. If you are inserting new code, make sure it is unambiguous where this new code belongs. Mention specific line number(s). Write your answer for Part B in the box below.

Should be:

    i--;


4. **Collections Programming:** Write a method called mostPopularHobby that takes in a Map with keys that are TA names and values that are sets of hobbies of that TA. For example, if a variable called m contains the following:

    {
        Atharva = [board games, comedy shows, hiking, video gaming],
        Chaafen = [Formula 1, reading, traveling, video gaming],
        Jaylyn = [hiking, traveling, video gaming],
        Shivani = [cafes, music shows]
    }

then the call mostPopularHobby(m) should return the String "video gaming" because three of the TAs enjoy this hobby while the other hobbies are less common.

If there is a tie between hobbies, you should break them alphabetically. For instance, if Shivani had an additional hobby of hiking, then the method should return "hiking" since it would be enjoyed by three TAs and comes alphabetically before "video gaming".

You may assume that the given map is not empty and that none of the inner sets are empty.

Your method should not construct any new data structures other than a single Map. It should also not modify the input map or any of the inner sets. You should use interface types and generics appropriately.

```
public static String mostPopularHobby(Map<String, Set<String>> m) {
    Map<String, Integer> counts = new TreeMap<>();

    for (String name : m.keySet()) {
        Set<String> hobbies = m.get(name);
        for (String h : hobbies) {
            if (!counts.containsKey(h)) {
                counts.put(h, 0);
            }
            counts.put(h, counts.get(h) + 1);
        }
    }

    int max = 0;
    String hobby = "";
    for (String h : counts.keySet()) {
        if (counts.get(h) > max) {
            max = counts.get(h);
            hobby = h;
        }
    }
    return hobby;
}
```

