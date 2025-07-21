# Reference Sheet

**Examples of Constructing Scanners and PrintStreams**

```
Scanner input = new Scanner(System.in);
Scanner file = new Scanner(new File("in.txt")); // throws FileNotFoundException
Scanner string = new Scanner("Hello, world!");
PrintStream ps = new PrintStream(new File("out.txt")); // throws FNFE
```

**Scanner Methods**

| Method                        | Description                                                      |
|-------------------------------|------------------------------------------------------------------|
| hasNext()                     | Returns true if there is another token to read                   |
| next()                        | Returns the next token as a String                               |
| hasNextInt() / hasNextDouble()| Returns true if the next token to read is an int / double        |
| nextInt() / nextDouble()      | Returns the next token as an int / double                        |
| hasNextLine()                 | Returns true if there is another line to read                    |
| nextLine()                    | Returns the next line as a String                                |

**PrintStream Methods**

| Method         | Description                                                      |
|----------------|------------------------------------------------------------------|
| print(...)     | Prints the given value to the set output location                |
| println(...)   | Prints the given value to the set output location and terminates the line |

**Examples of Constructing Various Collections**

```
List<Integer> list = new ArrayList<Integer>();
Queue<Double> queue = new LinkedList<Double>();
Stack<String> stack = new Stack<>(); // Diamond operator also permitted
Set<String> words = new HashSet<>();
Map<String, Integer> counts = new TreeMap<String, Integer>();
```

**Methods Found in ALL collections (Lists, Stacks, Queues, Sets, Maps)**

| Method             | Description                                                      |
|--------------------|------------------------------------------------------------------|
| equals(collection) | Returns true if the given other collection contains the same elements |
| isEmpty()          | Returns true if the collection has no elements                   |
| size()             | Returns the number of elements in a collection                   |
| toString()         | Returns a string representation such as "[10, -2, 43]"           |

**Methods Found in both Lists and Sets (ArrayList, LinkedList, HashSet, TreeSet)**

| Method                | Description                                                      |
|-----------------------|------------------------------------------------------------------|
| add(value)            | Adds value to collection (appends at end of list)                |
| addAll(collection)    | Adds all the values in the given collection to this one          |
| contains(value)       | Returns true if the given value is found somewhere in this collection |
| iterator()            | Returns an Iterator object to traverse the collection's elements |
| clear()               | Removes all elements of the collection                           |
| remove(value)         | Finds and removes the given value from this collection           |
| removeAll(collection) | Removes any elements found in the given collection from this one |
| retainAll(collection) | Removes any elements not found in the given collection from this one |

**List<Type> Methods**

| Method                | Description                                                      |
|-----------------------|------------------------------------------------------------------|
| add(index, value)     | Inserts given value at given index, shifting subsequent values right |
| indexOf(value)        | Returns first index where given value is found in list (-1 if not found) |
| get(index)            | Returns the value at given index                                 |
| remove(index)         | Removes/returns value at given index, shifting subsequent values left |
| set(index, value)     | Replaces value at given index with given value                   |

