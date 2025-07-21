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
Map<String, String> capitals = new HashMap<>(); // Create a new HashMap to store country-capital pairs
capitals.put("France", "Paris");   // Add a key-value pair: key is "France", value is "Paris"
capitals.put("Spain", "Madrid");   // Add another pair
capitals.put("Japan", "Tokyo");    // And another

System.out.println(capitals.get("Spain")); // Output: Madrid (get the value for key "Spain")

// Using TreeMap (keys sorted alphabetically)
Map<String, String> sortedCapitals = new TreeMap<>(); // Create a TreeMap (keys will be sorted)
sortedCapitals.putAll(capitals); // Copy all entries from capitals
System.out.println(sortedCapitals); // Output: {France=Paris, Japan=Tokyo, Spain=Madrid}
// Notice the keys are sorted alphabetically
```

**Explanation:**
- `HashMap` is fast but does not guarantee any order of keys.
- `TreeMap` keeps keys sorted (e.g., alphabetically for Strings).
- `put(key, value)` adds or updates a mapping.
- `get(key)` retrieves the value for a key (or null if not found).

---

### Example: Mapping Favorite Artists to Songs

```java
import java.util.Map;
import java.util.TreeMap;

public class FavoriteSongs {
    public static void main(String[] args) {
        // Create a TreeMap to map artist names to their favorite songs
        Map<String, String> favArtistToSong = new TreeMap<>();
        favArtistToSong.put("Stromae", "Ma Meilleure Ennemie"); // Add artist-song pair
        favArtistToSong.put("Aitana", "Segundo Intento");
        favArtistToSong.put("Laufey", "Promise");

        // Getting a value for a key
        String song = favArtistToSong.get("Aitana"); // Retrieve the song for "Aitana"
        System.out.println("Aitana's song: " + song); // Output: Aitana's song: Segundo Intento

        // Iterating over keys
        for (String artist : favArtistToSong.keySet()) { // Loop through all artists (keys)
            // For each artist, print their favorite song
            System.out.println(artist + "'s favorite song: " + favArtistToSong.get(artist));
        }
    }
}
```

**Explanation:**
- `TreeMap` sorts artists alphabetically.
- `put` adds entries; `get` retrieves a value for a key.
- `keySet()` returns all keys (artists), which you can loop over.

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
Map<String, Integer> scores = new HashMap<>(); // Create a map of names to scores
scores.put("Alice", 90); // Add Alice's score
scores.put("Bob", 85);   // Add Bob's score

if (scores.containsKey("Alice")) { // Check if Alice is in the map
    System.out.println("Alice's score: " + scores.get("Alice")); // Print Alice's score
}

scores.remove("Bob"); // Removes Bob's entry from the map
System.out.println(scores); // Output: {Alice=90}
```

**Explanation:**
- `containsKey(key)` checks if a key exists before accessing it.
- `remove(key)` deletes a key-value pair.
- Printing the map shows all current entries.

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
System.out.println("HashMap: " + hashMap); // Order not guaranteed, e.g., {a=1, b=2, c=3} or any order

Map<String, Integer> treeMap = new TreeMap<>();
treeMap.putAll(hashMap); // Copy all entries from hashMap
System.out.println("TreeMap: " + treeMap); // Keys sorted: {a=1, b=2, c=3}
```

**Explanation:**
- `HashMap` is generally faster but does not sort keys.
- `TreeMap` sorts keys, which is useful if you need ordered output.
- Both implement the `Map` interface, so you can switch between them easily.

---

## Best Practices
- Use `HashMap` for general-purpose mapping when order is not important.
- Use `TreeMap` when you need keys to be sorted.
- Always check for `null` when using `get(key)` if the key might not exist.
- Prefer iterating with `entrySet()` for efficiency when you need both keys and values:

```java
for (Map.Entry<String, Integer> entry : hashMap.entrySet()) { // entrySet() gives key-value pairs
    System.out.println(entry.getKey() + ": " + entry.getValue()); // Print key and value
}
```

**Explanation:**
- `entrySet()` is more efficient than calling `get()` inside a loop over `keySet()`.
- Each `Map.Entry` object holds a key and its corresponding value.

---

*For more advanced usage, see also: `LinkedHashMap` (maintains insertion order), `ConcurrentHashMap` (thread-safe), and custom key types (must implement `equals` and `hashCode`).*

