The exam is divided into six questions with the following points:

    #     Problem Area
    ---------------------------------------------
    1     Conceptual
    2     Code Tracing
    3     Debugging
    4     Collections Programming
    5     Objects Programming
    6     Stacks/Queues Programming

1. **Conceptual**: Each of these parts should be considered independent of the others.

**Part A:** (Select all that apply) Which of the following are true about Sets?

- [ ] A TreeSet stores elements in sorted order
- [ ] A HashSet preserves the insertion order of its elements
- [ ] A Set does not allow for duplicate values
- [ ] A HashSet is generally more efficient than a TreeSet

**Part B:** Consider the following method. For each of the following commented checkpoints, fill in the table for which conditions are always true (under any circumstance), only sometimes true, or never true at each comment. You can abbreviate A=always, S=sometimes and N=never.

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
        }
        // Checkpoint D
    }
    // Checkpoint E
    return result;
}
```

> An explanation for Checkpoint A's example answers
>
> list.isEmpty(): S
> true for mystery([], 3) and false for mystery([1,2,3], 4). Therefore sometimes true.
>
> num % n == 0: A
> Any number mod 1 is 0, so this is always true.
>
> result.isEmpty(): A
> result was just initialized and nothing has been added yet. Therefore it is always empty here.

|                 | Checkpoint A | Checkpoint B | Checkpoint C | Checkpoint D | Checkpoint E |
|-----------------|--------------|--------------|--------------|--------------|--------------|
| list.isEmpty()  | S            |              |              |              |              |
| num % n == 0    | A            |              |              |              |              |
| result.isEmpty()| A            |              |              |              |              |


**Part C:** (Select one option) Consider the following method. Which of the following options is the best "plain-English" explanation of what the code is doing?

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
- ( ) Returns a set of the keys of m that equal the sum of their inner sets in m
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

| Input                | Returned Set                        |
|----------------------|-------------------------------------|
| [[3]]                | ___________________________________ |
| [[7],                |                                     |
|  [7],                | ___________________________________ |
|  [7]]                |                                     |
| [[2, 0, 4],          |                                     |
|  [12, 10, 0]]        | ___________________________________ |
| [[5, -5, 8, 0, 6]]   | ___________________________________ |


3. **Debugging.** Consider the following buggy implementation of **removeEvensInRange**. The intended behavior of this method is to take a list of integers, as well as integers start and end, and modify that list so that it removes the even numbers between indices start and end (both exclusive), and return the number of elements that were removed.

For example, if a variable called list stores this sequence of values:

    [3, -1, 0, 2, 5, -10, 8]

Calling removeEvensInRange(list, 1, 5); should cause list to store the following sequence of values afterwards and the value to be returned is 2 because there were two elements that were removed (0 and 2):

    [3, -1, 5, -10, 8]

Notice that the order from the original list is maintained. Assume that the given list is not empty and the inputs for start and end are valid indices of the original list.

A TA wrote a buggy implementation of this method shown below.

    1. public static int removeEvensInRange(List<Integer> list, int start, int end) {
    2.     int count = 0;
    3.     for (int i = start + 1; i < end; i++) {
    4.         int num = list.get(i);
    5.         if (num % 2 == 0) {
    6.             count++;
    7.             list.remove(i);
    8.             i++;
    9.             end--;
   10.         }
   11.     }
   12.     return count;
   13. }
