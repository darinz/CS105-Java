# Java Review

## Practice : Think

What is the output of this Java program?

```java
public class Demo {
    public static void main(String[] args) {
        int[] nums = {1, 4, 4, 8, 13};
        int totalDiff = 0;
        for (int i = 1; i <= nums.length; i++) {
            totalDiff += (nums[i] - nums[i - 1]);
        }
        System.out.println("Total Diff = " + totalDiff);
    }
}
```

(A) Total Diff = 12

(B) Total Diff = 10

(C) Total Diff = 9

(D) Exception!