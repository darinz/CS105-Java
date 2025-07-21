# Quiz 1 Solutions

---

## 1. Functional Decomposition

**Sample Decomposition:**
- `int computeSumOfEvens(int start, int end)`: Computes and returns the sum of all even numbers between `start` and `end` (inclusive).
- `void printSum(int sum)`: Prints the sum.

**Descriptions:**
- `computeSumOfEvens` does the calculation.
- `printSum` handles output.

**Sample Code:**
```java
public static int computeSumOfEvens(int start, int end) {
    int sum = 0;
    for (int i = start; i <= end; i++) {
        if (i % 2 == 0) {
            sum += i;
        }
    }
    return sum;
}

public static void printSum(int sum) {
    System.out.println("Sum of even numbers: " + sum);
}
```

---

## 2. File I/O

**Sample Solution (using Scanner):**
```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public static void printErrorLines() throws FileNotFoundException {
    Scanner scanner = new Scanner(new File("data.txt"));
    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if (line.contains("ERROR")) {
            System.out.println(line);
        }
    }
    scanner.close();
}
```

**Or using BufferedReader:**
```java
import java.io.*;

public static void printErrorLines() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
    String line;
    while ((line = reader.readLine()) != null) {
        if (line.contains("ERROR")) {
            System.out.println(line);
        }
    }
    reader.close();
}
```

---

## 3. ArrayLists

**Sample Solution:**
```java
import java.util.ArrayList;

public static ArrayList<Integer> filterGreaterThanTen(ArrayList<Integer> list) {
    ArrayList<Integer> result = new ArrayList<>();
    for (int num : list) {
        if (num > 10) {
            result.add(num);
        }
    }
    return result;
}
``` 