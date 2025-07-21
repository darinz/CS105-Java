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

3. **Debugging:** Consider the following buggy implementation of **rotateLeftAndNegateEvens**. The intended behavior of this method is to take a list of integers and integer steps and modify that list so that the numbers are rotated left by the specified number of steps. Additionally, after the rotation, if the number is even and it moves from the front to the back, then it should be negated.

For example, if a variable called list stores this sequence of values and `int steps = 2`:

    [1, 2, 3, 4, 5, 6]

We want to rotate the numbers within this list to the left by two steps. Additionally, we want to negate the even numbers that move from the front to the back. If the method gets is passed a negative value for steps or if the list is empty, then the method should throw an IllegalArgumentException(). So, our expected output is:

    [3, 4, 5, 6, 1, -2]

Notice that 2 became -2 because it moved from the front to the back.

A TA wrote a buggy implementation of this method shown below. HINT: There are 2 bugs.

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

```
There are two bugs. Firstly, ArrayLists don’t have a method .length(). They have a method .size() instead (Line 2). Secondly, on Line 6, we don’t want to remove at index i, instead always from the start (index = 0).
```

4. **Collections Programming:** Write a method called **studentsTaught** that takes a map indicating each student’s enrollment history and an instructor’s name and returns a set indicating all students that the given instructor has taught.

The input map will have keys that are names of students (strings) and corresponding values which are maps representing the classes the student has taken. The value map maps the course code (integers) to the name of the instructor (strings) they took the class with. For example, if a variable called m stored the following map in the format described above:

    {Colton={163=Kevin},
     Darel={416=Hunter, 373=Kevin, 143=Kevin},
     Ben={373=Kevin, 143=Stuart},
     Atharva={121=Miya, 122=Hunter, 123=Brett}}

Then a call to studentsTaught(m, "Kevin") would return a Set with the following elements:

    [Ben, Colton, Darel]

A call to studentsTaught(m, "Elba") should return an empty Set, since none of the students in m took a course with her.

Notice that some instructors teach multiple courses and the same course may be taught by different instructors (in different quarters, for example).

The set you return should be sorted alphabetically. You may assume that the given map and none of its contents are null.

Your method should construct the new set to return but should otherwise not construct any other new data structures. Your method should not modify the given Map. You should use interface types and generics appropriately.

```java
public static Set<String> studentsTaught(
        Map<String, Map<Integer, String>> studentToCourse,
        String instructor) {
    Set<String> names = new TreeSet<>();
    for (String student : studentToCourse.keySet()) {
        Map<Integer, String> courses = studentToCourse.get(student);
        for (int course : courses.keySet()) {
            String instr = courses.get(course);
            if (instr.equals(instructor)) {
                names.add(student);
            }
        }
    }
    return names;
}
```

5. **Objects Programming:** Consider the following interface Restaurant. For this problem, you are to write a class called FastFoodRestaurant, which implements the Restaurant. The FastFoodRestaurant class should have two constructors. The first constructor should take a String name and the associated cuisine would be “N/A”. The second constructor should take two parameters (String name and String cuisine).

public interface Restaurant {
    // Returns the name of the Restaurant
    public String getName();

    // Returns the cuisine of the Restaurant (For example: Thai or Indian)
    public String getCuisine();

    // Returns a list of items on the menu
    public List<String> getMenu();

    // Adds a food item to the menu. If the food item is already present, then there is no
    // change.
    public void addFoodItem(String foodName);

    // Removes a food item from the menu.
    // Throws an IllegalArgumentException if the food item does not exist.
    public void removeFoodItem(String foodName);

    // Returns the number of food items on the menu
    public int getNumFoodItems();

    // Makes a reservation at the particular restaurant. If a restaurant doesn’t take
    // reservations (ex. Fast Food restaurants), then it returns “No reservation needed!”.
    // If a restaurant accepts reservations, it returns “Success” or “Failure”.
    public String makeReservation(String time);

    // Returns true if this restaurant has more items than the other restaurant
    // otherwise false
    public boolean hasMoreOptions(Restaurant other);
}

For example, if the following lines were executed using the FastFoodRestaurant class...
    Restaurant r1 = new FastFoodRestaurant("McDonalds");
    r1.addFoodItem("Butter Paneer");
    r1.addFoodItem("Cheeseburger");
    r1.removeFoodItem("Butter Paneer");
    Restaurant r2 = new FastFoodRestaurant("Chipotle", "Mexican");
    r2.addFoodItem("Tacos");
    r2.addFoodItem("PadThai");
    r2.addFoodItem("Burrito");
    r2.addFoodItem("Burrito");
    r2.removeFoodItem("PadThai");

Then, the following methods would return...
    r1.getName()            // McDonalds
    r1.getCuisine()         // N/A
    r1.getMenu()            // [Cheeseburger]
    r1.getNumFoodItems()    // 1
    r2.getName()            // Chipotle
    r2.getCuisine()         // Mexican
    r2.getMenu()            // [Tacos, Burrito] -> order does not matter
    r2.getNumFoodItems()    // 2
    r1.hasMoreOptions(r2)   // false
    r1.makeReservation("8:00 pm") // No reservation needed!

Your FastFoodRestaurant class should implement the Restaurant Interface. Your FastFoodRestaurant class should have private fields and should implement the above-outlined public methods. **Write your solution on the next page.**

**Solution:**

import java.util.*;

public class FastFoodRestaurant implements Restaurant {
    private String name;
    private String cuisine;
    private Set<String> menu;

    public FastFoodRestaurant(String name, String cuisine) {
        this.name = name;
        this.cuisine = cuisine;
        this.menu = new HashSet<>();
    }

    public FastFoodRestaurant(String name) {
        this(name, "N/A");
    }

    public String getName() {
        return this.name;
    }

    public String getCuisine() {
        return this.cuisine;
    }

    public List<String> getMenu() {
        return new ArrayList<>(this.menu);
    }

    public void addFoodItem(String foodName) {
        this.menu.add(foodName);
    }

    public void removeFoodItem(String foodName) {
        if (!this.menu.contains(foodName)) {
            throw new IllegalArgumentException();
        }
        this.menu.remove(foodName);
    }

    public int getNumFoodItems() {
        return this.menu.size();
    }

    public boolean hasMoreOptions(Restaurant other) {
        if (this.getNumFoodItems() > other.getNumFoodItems()) {
            return true;
        }
        return false;
    }

    public String makeReservation(String time) {
        return "No reservation needed!";
    }
}

