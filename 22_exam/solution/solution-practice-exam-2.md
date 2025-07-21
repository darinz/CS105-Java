# Practice Exam 2

The exam is divided into six questions with the following points:

    #    Problem Area
    -----------------------------------------------
    1    Conceptual
    2    Code Tracing
    3    Debugging
    4    Collections Programming
    5    Objects Programming
    6    Stacks/Queues Programming

1. **Conceptual:** Each of these parts uses the Hospital.java implementation included here.

```java
public class Hospital {
    private String name;
    private int numDoctors;
    private int maxPatients;

    public Hospital (String name, int numDoctors, int maxPatients) {
        this.name = name;
        this.numDoctors = numDoctors;
        this.maxPatients = maxPatients;
    }

    public Hospital (String name) {
        this(name, 0, 0);
    }

    public void expand (int newNumDocs, int newMaxPatients) {
        this.numDoctors = newNumDocs;
        this.maxPatients = newMaxPatients;
    }

    public double patientDoctorRatio() {
        if (this.numDoctors == 0) {
            return 0;
        }
        return (double) maxPatients / numDoctors;
    }

    public String getName() {
        return this.name;
    }

    public int getNumDoctors() {
        return this.numDoctors;
    }

    public int getMaxPatients() {
        return this.maxPatients;
    }

    public String toString() {
        return this.name + " {Num Doc: " + this.numDoctors + ", Max Pat: " + this.maxPatients + "}";
    }
}
```

**Part A:** Consider the following code snippet.
```
Hospital h1 = new Hospital("Seattle Childrens", 200, 1200);
Hospital h2 = new Hospital("Overlake");
System.out.println(h1);
Hospital h3 = h1;
h3.expand(300, 1800);
h3 = h2;
h3.expand(500, 1500);
System.out.println(h2);
System.out.println(h3);
```

**Part A1:** How many Point objects are created in this snippet? Answer in box below

2 Objects

**Part A2:** How many references to objects are created in this snippet? Answer in box below

3 references

**Part B:** What is printed to the console by the code snippet from Part A?

```
Seattle Childrens {Num Doc: 200, Max Pat: 1200}
Seattle Childrens {Num Doc: 300, Max Pat: 1800}
Overlake {Num Doc: 500, Max Pat: 1500}
```

**Part C:** (Select one option) Suppose we were to write the following method. Which of the options below would make the best summary for this new method of our Hospital.java class?

```java
public Hospital mystery(List<Hospital> list) {
    double a = 0.0;
    Hospital b;
    for (Hospital h : list) {
        double c = h.patientDoctorRatio();
        if (c >= a) {
            a = c;
            b = h;
        }
    }
    return b;
}
```

- ( ) Updates each Hospital in the list to have a higher Patient-Doctor Ratio
- ( ) Checks and returns the Hospital that is tied for the same Patient-Doctor Ratio
- (x) Calculates the Hospital in the list that has the highest Patient-Doctor Ratio
- ( ) Calculates the Hospital in the list that has the lowest Patient-Doctor Ratio

2. **Code Tracing:** Consider the method below.

    public static List<Integer> mystery(int[][] data) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < data.length; i++) {
            for (int j = data[i].length - 1; j > 0; j--) {
                result.add(data[i][j] - 1);
            }
        }
        return result;
    }

For each 2d array below, indicate in the right-hand column what values would be stored in the list returned by method mystery if the array in the left-hand column is passed as a parameter to mystery. List elements should be listed in proper order as a comma-separated bracketed list, as in [3, 18, 25].

**Input 2D Array**                     **Contents of List Returned**

[[0, 1],
 [2, 3]]                        [2]
___________________________________________________________

[[0, 1, 2],
 [3, 4, 5],
 [6, 7, 8]]                     [4, 3, 7, 6]
___________________________________________________________

[[3, 4],
 [1, 2, 3, 4],
 [],
 [5, 6]]                        [3, 2, 1, 5]
___________________________________________________________

