# Quiz 2: Sample Solutions

## 1. Reference Semantics
**a)** The value printed is `10`.

**b)** Explanation: Both `a` and `b` refer to the same array in memory. When you change `b[0]`, you are also changing `a[0]`, so `a[0]` becomes `10`.

---

## 2. Stacks
**Sample Solution:**
```java
public int sumStack(Stack<Integer> stack) {
    Stack<Integer> temp = new Stack<>();
    int sum = 0;
    // Pop elements, sum them, and push to temp
    while (!stack.isEmpty()) {
        int val = stack.pop();
        sum += val;
        temp.push(val);
    }
    // Restore original stack
    while (!temp.isEmpty()) {
        stack.push(temp.pop());
    }
    return sum;
}
```
> **Explanation:**
> - We use a temporary stack to hold the elements as we sum them, then restore the original stack order.

---

## 3. Queues
**Sample Solution:**
```java
Queue<String> queue = new LinkedList<>();
queue.add("A");
queue.add("B");
queue.add("C");

Queue<String> temp = new LinkedList<>();
while (!queue.isEmpty()) {
    String s = queue.remove();
    if (!s.equals("B")) {
        temp.add(s);
    }
}
// Now temp has "A" and "C" in order
// If you want to put them back in the original queue:
queue = temp;
```
> **Explanation:**
> - We transfer all elements except "B" to a temporary queue, effectively removing "B" while preserving order.

---

## 4. Sets
**Sample Solution:**
```java
Set<String> set = new HashSet<>();
set.add("apple");
set.add("banana");
set.add("apple");
set.add("cherry");
System.out.println(set.size()); // Output: 3
```
**Explanation:**
- The set contains only unique elements: "apple", "banana", and "cherry". Adding "apple" twice has no effect, so the size is 3.

---

## 5. Maps
**a)** The value printed is `95`.

**b)** Explanation: When you put a value for a key that already exists ("Alice"), the old value (`90`) is replaced by the new value (`95`). Only the latest value for each key is stored in the map. 