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
