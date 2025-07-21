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


**Part A2:** How many **references to objects** are created in this snippet?
Answer in box below

__________________________________________________________

**Part B:** What is printed to the console by the code snippet from Part A?

__________________________________________________________

**Part C:** (Select one option) Suppose we were to write the following method. Which of the options below would make the best summary for this new method of our Hospital.java class?

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

( ) Updates each Hospital in the list to have a higher Patient-Doctor Ratio

( ) Checks and returns the Hospital that is tied for the same Patient-Doctor Ratio

( ) Calculates the Hospital in the list that has the highest Patient-Doctor Ratio

( ) Calculates the Hospital in the list that has the lowest Patient-Doctor Ratio


3. **Debugging:** Consider the following buggy implementation of **rotateLeftAndNegateEvens**. The intended behavior of this method is to take a list of integers and integer steps and modify that list so that the numbers are rotated left by the specified number of steps. Additionally, after the rotation, if the number is even and it moves from the front to the back, then it should be negated.

For example, if a variable called list stores this sequence of values and `int steps = 2`:

    [1, 2, 3, 4, 5, 6]

We want to rotate the numbers within this list to the left by two steps. Additionally, we want to negate the even numbers that move from the front to the back. If the method gets is passed a negative value for steps or if the list is empty, then the method should throw an IllegalArgumentException(). So, our expected output is:

    [3, 4, 5, 6, 1, -2]

Notice that 2 became -2 because it moved from the front to the back.

A TA wrote a buggy implementation of this method shown below. HINT: There are **2** bugs.

    1. public static void rotateLeftAndNegateEvens(List<Integer> list, int steps) {
    2.     if (steps < 0 || list.length() == 0) {
    3.         throw new IllegalArgumentException();
    4.     }
    5.     for (int i = 0; i < steps; i++) {
    6.         int valFirst = list.remove(i);
    7.         if (valFirst % 2 == 0) {
    8.             list.add(valFirst * -1);
    9.         } else {
   10.             list.add(valFirst);
   11.         }
   12.     }
   13. }

Your task is to fix this implementation so that it behaves as described above. If you are making significant changes to the structure of the method, it may be helpful to write your whole solution from scratch. However, if you are only making minor edits to the code that you can clearly explain, you can also write out just the edits below. If writing edits, specifically mention which line(s) you will change and write out the code you would replace them with. You will need to write correct code on the lines you change/add. If you are deleting some code, make sure it’s clear what parts are being removed. If you are inserting new code, make sure it is unambiguous where this new code belongs. Mention specific line number(s).


4. **Collections Programming:** Write a method called **studentsTaught** that takes a map indicating each student’s enrollment history and an instructor’s name and returns a set indicating all students that the given instructor has taught.

The input map will have keys that are names of students (strings) and corresponding values which are maps representing the classes the student has taken. The value map maps the course code (integers) to the name of the instructor (strings) they took the class with. For example, if a variable called m stored the following map in the format described above:

    {Colton={163=Kevin},
     Darel={416=Hunter, 373=Kevin, 143=Kevin},
     Ben={373=Kevin, 143=Stuart},
     Atharva={121=Miya, 122=Hunter, 123=Brett}}

Then a call to studentsTaught(m, "Kevin") should return a Set with the following elements:

    [Ben, Colton, Darel]

A call to studentsTaught(m, "Elba") should return an empty Set, since none of the students in m took a course with her.

Notice that some instructors teach multiple courses and the same course may be taught by different instructors (in different quarters, for example).

The set you return should be sorted alphabetically. You may assume that the given map and none of its contents are null.

Your method should construct the new set to return but should otherwise not construct any new data structures. Your method should not modify the given Map. You should use interface types and generics appropriately.


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

**Input 2D Array** | **Contents of List Returned**
-------------------|------------------------------

[[0, 1],
 [2, 3]]           | ____________________________________________

[[0, 1, 2],
 [3, 4, 5],
 [6, 7, 8]]        | ____________________________________________

[[3, 4],
 [1, 2, 3, 4],
 [],
 [5, 6]]           | ____________________________________________

