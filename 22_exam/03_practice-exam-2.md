# Practice Exam 2


The exam is divided into six questions with the following points:

    #     Problem Area
    -----------------------------------------------
    1     Conceptual
    2     Code Tracing
    3     Debugging
    4     Collections Programming
    5     Objects Programming
    6     Stacks/Queues Programming

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
```java
Hospital h1 = new Hospital("Seattle Childrens", 200, 1200);
Hospital h2 = new Hospital("Overlake");
System.out.println(h1);
Hospital h3 = h1;
h3.expand(300, 1800);
h3 = h2;
h2 = h1;
h3.expand(500, 1500);
System.out.println(h2);
System.out.println(h3);
```

**Part A1:** How many Hospital objects are created in this snippet? Answer in box below

