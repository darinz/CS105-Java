# Map ADT

A **Map** is a data structure that associates (maps) *unique keys* to *values*. This is useful when you want to look up a value based on a key, like a dictionary or a phone book.

- **Keys**: Must be unique (no duplicates). Can be any object type (e.g., String, Integer, custom objects), but must implement `equals()` and `hashCode()` properly for correct behavior.
- **Values**: Can be any type. Values can be duplicated.

## Common Map Operations

| Operation         | Description                                                      |
|------------------|------------------------------------------------------------------|
| `put(key, value)`| Associates the specified value with the specified key.            |
| `get(key)`       | Returns the value to which the specified key is mapped, or null.  |
| `remove(key)`    | Removes the mapping for the specified key if present.             |
| `containsKey(key)`| Returns true if the map contains a mapping for the key.          |
| `clear()`        | Removes all mappings from the map.                                |
| `size()`         | Returns the number of key-value mappings.                         |
| `isEmpty()`      | Returns true if the map contains no key-value mappings.           |
| `keySet()`       | Returns a Set view of the keys.                                   |
| `values()`       | Returns a Collection view of the values.                          |

*Java's Map is similar to Python's `dict`.*

---

## Programming with Maps in Java

Java provides the `Map` interface and several implementations. The two most common are:
- **HashMap**: Fast, does not maintain order.
- **TreeMap**: Maintains keys in sorted order (according to their natural ordering or a custom comparator).

### Declaring and Using a Map

```java
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

// Using HashMap (no order guaranteed)
Map<String, String> capitals = new HashMap<>();
capitals.put("France", "Paris");
capitals.put("Spain", "Madrid");
capitals.put("Japan", "Tokyo");

System.out.println(capitals.get("Spain")); // Output: Madrid

// Using TreeMap (keys sorted alphabetically)
Map<String, String> sortedCapitals = new TreeMap<>();
sortedCapitals.putAll(capitals);
System.out.println(sortedCapitals); // Output: {France=Paris, Japan=Tokyo, Spain=Madrid}
```

### Example: Mapping Favorite Artists to Songs

```java
import java.util.Map;
import java.util.TreeMap;

public class FavoriteSongs {
    public static void main(String[] args) {
        Map<String, String> favArtistToSong = new TreeMap<>();
        favArtistToSong.put("Stromae", "Ma Meilleure Ennemie");
        favArtistToSong.put("Aitana", "Segundo Intento");
        favArtistToSong.put("Laufey", "Promise");

        // Getting a value for a key
        String song = favArtistToSong.get("Aitana");
        System.out.println("Aitana's song: " + song);

        // Iterating over keys
        for (String artist : favArtistToSong.keySet()) {
            System.out.println(artist + "'s favorite song: " + favArtistToSong.get(artist));
        }
    }
}
```

---

## Key Methods Explained

- **put(key, value)**: Adds or updates the value for the given key. If the key already exists, its value is replaced.
- **get(key)**: Returns the value for the key, or `null` if the key is not present.
- **containsKey(key)**: Checks if the map contains the specified key.
- **remove(key)**: Removes the key and its value from the map.
- **keySet()**: Returns a set of all keys, useful for iteration.
- **values()**: Returns a collection of all values.

### Example: Checking and Removing

```java
Map<String, Integer> scores = new HashMap<>();
scores.put("Alice", 90);
scores.put("Bob", 85);

if (scores.containsKey("Alice")) {
    System.out.println("Alice's score: " + scores.get("Alice"));
}

scores.remove("Bob"); // Removes Bob's entry
System.out.println(scores);
```

---

## HashMap vs TreeMap

| Feature         | HashMap                        | TreeMap                        |
|-----------------|--------------------------------|-------------------------------|
| Order           | No order (random)              | Keys sorted (natural order)    |
| Performance     | Fastest (O(1) for most ops)    | Slower (O(log n) for ops)     |
| Null keys/values| Allows one null key, many null values | No null keys (but allows null values) |
| Use case        | When order doesn't matter       | When sorted keys are needed    |

### Example: HashMap vs TreeMap

```java
Map<String, Integer> hashMap = new HashMap<>();
hashMap.put("b", 2);
hashMap.put("a", 1);
hashMap.put("c", 3);
System.out.println("HashMap: " + hashMap); // Order not guaranteed

Map<String, Integer> treeMap = new TreeMap<>();
treeMap.putAll(hashMap);
System.out.println("TreeMap: " + treeMap); // Keys sorted: {a=1, b=2, c=3}
```

---

## Best Practices
- Use `HashMap` for general-purpose mapping when order is not important.
- Use `TreeMap` when you need keys to be sorted.
- Always check for `null` when using `get(key)` if the key might not exist.
- Prefer iterating with `entrySet()` for efficiency when you need both keys and values:

```java
for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

---

*For more advanced usage, see also: `LinkedHashMap` (maintains insertion order), `ConcurrentHashMap` (thread-safe), and custom key types (must implement `equals` and `hashCode`).*

