# Object Oriented Programming (OOP)

## Procedural Programming vs. Object-Oriented Programming

**Procedural programming:**
- Programs are organized as a sequence of steps or procedures (functions) to be carried out.
- Data and behavior are often separate.
- Example: A recipe with a list of instructions to follow.
- **In Java:** Early programs with just a `main` method and static functions.

**Object-oriented programming (OOP):**
- Programs are organized as a collection of objects that interact with each other.
- Objects combine state (data) and behavior (methods).
- Example: A team of workers, each with their own tools and responsibilities, collaborating to complete a project.
- **In Java:** Most modern Java programs use OOP.

---

## Classes & Objects

- **Class:** The blueprint or template for an object.
  - 📰 Like the blueprint for a house!
  - "What does it mean to be this thing?"
- **Object:** An actual instance of a class.
  - 🏠 Like the actual house built from the blueprint!
  - "It is an example of this thing!"

**Creating an object:**
```java
// Scanner is a built-in Java class for reading input
Scanner console = new Scanner(System.in); // Scanner is the class, console is the object
// 'new' creates a new Scanner object that reads from System.in (the keyboard)
```

**Custom Example:**
```java
// Define a class named Dog
public class Dog {
    // This class is a blueprint for Dog objects
}

// Create an object (instance) of the Dog class
Dog myDog = new Dog(); // myDog is an object (instance) of the Dog class
```
*Tip: The class defines what a Dog is, but myDog is an actual Dog you can interact with in your program.*

---

## State & Behavior

Objects tie related state and behavior together.

- **State:** Defined by the object's fields or instance variables (data).
  - Example: A Dog's state could include its name, age, and breed.
- **Behavior:** Defined by the object's instance methods (actions).
  - Example: A Dog's behavior could include barking, eating, or sleeping.

**Example:**
```java
// Define a Dog class with state and behavior
public class Dog {
    // State (fields): Each Dog has its own name, age, and breed
    String name;
    int age;
    String breed;

    // Behavior (method): Each Dog can bark
    public void bark() {
        // Print a message showing which dog is barking
        System.out.println(name + " says: Woof!");
    }
}

// Create a Dog object and set its state
Dog fido = new Dog();
fido.name = "Fido";      // Set the dog's name
fido.age = 3;             // Set the dog's age
fido.breed = "Labrador"; // Set the dog's breed

// Call the bark method (behavior) on the Dog object
fido.bark(); // Output: Fido says: Woof!
```
*Note: Each Dog object has its own name, age, and breed (state), and can bark (behavior).*

---

## Syntax

Below is the general structure of a Java class with fields and methods:
```java
public class MyObject {
    // fields (or instance variables) - store the state of the object
    type1 fieldName1;
    type2 fieldName2;
    // ...
    
    // instance methods - define the behavior of the object
    public returnType methodName(...) {
        // ...
    }
}
```

**Example:**
```java
// Define a Car class
public class Car {
    String color; // State: color of the car
    int year;     // State: year the car was made

    // Behavior: drive the car
    public void drive() {
        System.out.println("The " + color + " car is driving.");
    }
}

// Create a Car object and use it
Car myCar = new Car();
myCar.color = "red";
myCar.year = 2020;
myCar.drive(); // Output: The red car is driving.
```
*Tip: Each Car object can have a different color and year, but all can drive!*

---

## Instance Variables (Fields)

- Fields are also called **instance variables**.
- Defined inside a class, but outside any method.
- Each instance (object) of the class has its own copy of the fields.
- Hence, *instance* variable: a variable tied to a specific instance of the class!

**Example:**
```java
public class Student {
    String name; // Each Student has their own name
    int id;      // Each Student has their own id
}

// Create two Student objects
Student alice = new Student();
alice.name = "Alice";
alice.id = 101;

Student bob = new Student();
bob.name = "Bob";
bob.id = 102;
// alice and bob are separate objects with their own state
```
*Tip: Changing alice's name does not affect bob's name!*

---

## Instance Methods

- Instance methods are defined in a class.
- They can access and modify the instance variables of the object they belong to.
- Calling an instance method on a particular instance of the class will have effects only on that instance.

**Example:**
```java
public class Counter {
    int count = 0; // instance variable, each Counter has its own count

    // Method to increase the count by 1
    public void increment() {
        count++; // increases this object's count
    }

    // Method to get the current count
    public int getCount() {
        return count;
    }
}

Counter c1 = new Counter(); // First counter
Counter c2 = new Counter(); // Second counter
c1.increment(); // c1's count is now 1
c1.increment(); // c1's count is now 2
c2.increment(); // c2's count is now 1
System.out.println(c1.getCount()); // 2
System.out.println(c2.getCount()); // 1
```
*Note: Each Counter object keeps track of its own count!*

---

## Tips & Common Pitfalls
- Always use the `new` keyword to create objects (except for some special cases like Strings).
- Instance variables are unique to each object; changing one object's state does not affect another's.
- Methods that do not use `static` are instance methods and can access instance variables.
- Use meaningful names for classes, fields, and methods to make your code readable.
- If you forget to initialize an object's fields, they will have default values (e.g., 0 for int, null for objects).
- Remember to use the dot (`.`) operator to access fields and methods: `object.field` or `object.method()`.

---

*Next: Learn about constructors, encapsulation, and more advanced OOP concepts!*

