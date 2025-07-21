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
Scanner console = new Scanner(System.in); // Scanner is the class, console is the object
```

**Custom Example:**
```java
public class Dog {
    // This class is a blueprint for Dog objects
}

Dog myDog = new Dog(); // myDog is an object (instance) of the Dog class
```

---

## State & Behavior

Objects tie related state and behavior together.

- **State:** Defined by the object's fields or instance variables (data).
  - Example: A Dog's state could include its name, age, and breed.
- **Behavior:** Defined by the object's instance methods (actions).
  - Example: A Dog's behavior could include barking, eating, or sleeping.

**Example:**
```java
public class Dog {
    // State (fields)
    String name;
    int age;
    String breed;

    // Behavior (methods)
    public void bark() {
        System.out.println(name + " says: Woof!");
    }
}

Dog fido = new Dog();
fido.name = "Fido";
fido.age = 3;
fido.breed = "Labrador";
fido.bark(); // Output: Fido says: Woof!
```
*Note: Each Dog object has its own name, age, and breed (state), and can bark (behavior).*

---

## Syntax

```java
public class MyObject {
    // fields (or instance variables)
    type1 fieldName1;
    type2 fieldName2;
    // ...
    
    // instance methods
    public returnType methodName(...) {
        // ...
    }
}
```

**Example:**
```java
public class Car {
    String color;
    int year;

    public void drive() {
        System.out.println("The " + color + " car is driving.");
    }
}
```

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

Student alice = new Student();
alice.name = "Alice";
alice.id = 101;

Student bob = new Student();
bob.name = "Bob";
bob.id = 102;
```

---

## Instance Methods

- Instance methods are defined in a class.
- They can access and modify the instance variables of the object they belong to.
- Calling an instance method on a particular instance of the class will have effects only on that instance.

**Example:**
```java
public class Counter {
    int count = 0; // instance variable

    public void increment() {
        count++; // increases this object's count
    }

    public int getCount() {
        return count;
    }
}

Counter c1 = new Counter();
Counter c2 = new Counter();
c1.increment();
c1.increment();
c2.increment();
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

---

*Next: Learn about constructors, encapsulation, and more advanced OOP concepts!*

