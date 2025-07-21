# Practice, Reviews, and Applications

## Practice: Bugs You’ve Experienced

Can you think of a bug(s) you’ve experienced or heard of that have had serious effects? 

If you can’t, can you think of any absurd bugs you’ve seen?

---

## Example: Card Class

Each card has a suit (♠️♣️♦️❤️) and a value (e.g., 2, 3, 10, J, Q, K)
- **Note:** value represented as an `int` (e.g., Jack = 11, Queen = 12, King = 13, Ace = 14)

For example, for the Queen of Hearts card:
- The suit is hearts ❤️
- The value is Queen (represented as 12)

Below is a sample implementation of a `Card` class in Java. Each part of the code is annotated to help you understand its purpose:

```java
/**
 * Represents a playing card with a suit and value.
 */
public class Card {
    // The value of the card: 2-14 (where 11=Jack, 12=Queen, 13=King, 14=Ace)
    private int value;
    // The suit of the card: "Spades", "Clubs", "Diamonds", "Hearts"
    private String suit;

    /**
     * Constructs a Card with the given value and suit.
     * Throws IllegalArgumentException if value or suit is invalid.
     */
    public Card(int value, String suit) {
        // Check if the value is within the valid range
        if (value < 2 || value > 14) {
            throw new IllegalArgumentException("Invalid card value: " + value);
        }
        // Check if the suit is one of the four valid options
        if (!suit.equals("Spades") && !suit.equals("Clubs") && !suit.equals("Diamonds") && !suit.equals("Hearts")) {
            throw new IllegalArgumentException("Invalid suit: " + suit);
        }
        this.value = value;
        this.suit = suit;
    }

    // Returns the suit of the card
    public String getSuit() {
        return suit;
    }

    // Returns the value of the card
    public int getValue() {
        return value;
    }

    /**
     * Returns a string representation of the card, e.g., "Q of Hearts"
     */
    @Override
    public String toString() {
        String valueStr;
        switch (value) {
            case 11: valueStr = "J"; break; // Jack
            case 12: valueStr = "Q"; break; // Queen
            case 13: valueStr = "K"; break; // King
            case 14: valueStr = "A"; break; // Ace
            default: valueStr = String.valueOf(value); // Number cards
        }
        return valueStr + " of " + suit;
    }

    /**
     * Checks if this card is equal to another card (same value and suit)
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true; // Same object
        if (!(other instanceof Card)) return false; // Not a Card
        Card c = (Card) other;
        return this.value == c.value && this.suit.equals(c.suit);
    }
}
```

**Explanation:**
- The constructor checks for valid values and suits, throwing an exception if invalid.
- The `toString()` method converts the card's value to a readable string (e.g., 12 becomes "Q").
- The `equals()` method allows you to compare two cards for equality.

---

## Example: BattleManager Class

The `BattleManager` class manages the logic for a simple card game (like "War") between two players. Here is a simplified version with annotations:

```java
import java.util.LinkedList;
import java.util.Queue;

/**
 * Manages the card battle game between two players.
 */
public class BattleManager {
    // Each player's deck is represented as a queue (FIFO)
    private Queue<Card> player1Deck;
    private Queue<Card> player2Deck;

    /**
     * Default constructor: would initialize and deal cards
     */
    public BattleManager() {
        // Initialize and deal cards
        // ... (deck creation and shuffling logic goes here)
    }

    /**
     * Constructor that accepts two pre-made decks
     */
    public BattleManager(Queue<Card> deck1, Queue<Card> deck2) {
        this.player1Deck = deck1;
        this.player2Deck = deck2;
    }

    /**
     * Deals cards to both players (not implemented here)
     */
    public void deal() {
        // Split a shuffled deck between two players
        // ...
    }

    /**
     * Returns true if the game is over (one player has all the cards)
     */
    public boolean gameOver() {
        return player1Deck.isEmpty() || player2Deck.isEmpty();
    }

    /**
     * Returns the number of cards left for player 1
     */
    public int getPlayer1DeckSize() {
        return player1Deck.size();
    }

    /**
     * Returns the number of cards left for player 2
     */
    public int getPlayer2DeckSize() {
        return player2Deck.size();
    }

    /**
     * Main game loop: plays rounds until the game is over
     */
    public void play() {
        while (!gameOver()) {
            Card c1 = player1Deck.poll(); // Player 1 plays top card
            Card c2 = player2Deck.poll(); // Player 2 plays top card
            // Compare cards, handle battles, update decks
            // ... (game logic goes here)
        }
        // Announce winner
    }
}
```

**Explanation:**
- Each player's deck is a `Queue`, which allows cards to be drawn from the front and added to the back.
- The `play()` method would contain the main game logic, including handling ties ("battles").
- The class is designed to be extendable for more complex rules.

---

## Practice: Test Cases

**What test cases can you test for the Card class?**
- Creating a valid card (e.g., `new Card(12, "Hearts")`)
- Creating a card with invalid value (should throw exception)
- Creating a card with invalid suit (should throw exception)
- Checking `toString()` output (does it match expected string?)
- Checking `equals()` for same and different cards

**What about the BattleManager class?**
- Game ends when one player has all cards
- Decks are split evenly at start
- Winner is determined correctly
- Handles "battle" (tie) situations
- Handles multiple consecutive battles

---

## Challenge: Floating Point Numbers

Another name for doubles are floating point numbers. Floating point numbers are nice, but imprecise. Computers can only store a certain amount of precision (can’t store 0.3333333333 repeating forever). Finite precision can lead to slightly incorrect calculations with floating point numbers.

**Take-away:** Essentially can never rely on `==` for doubles. Instead, must define some notion of how far away they can be to be tolerated as the same.

Below is an example that demonstrates why comparing doubles with `==` can be problematic, and how to do it correctly:

```java
public class DoubleComparison {
    public static void main(String[] args) {
        double a = 0.1 + 0.2; // This is not exactly 0.3 due to floating point math
        double b = 0.3;
        System.out.println(a == b); // false! Due to floating point imprecision
        // Correct way: check if the difference is very small (within a tolerance)
        System.out.println(Math.abs(a - b) < 1e-9); // true
    }
}
```

**Explanation:**
- `a == b` is `false` because of how computers store decimal numbers.
- The correct way is to check if the numbers are "close enough" using a small tolerance (like `1e-9`).

### JUnit: assertEquals for Doubles

JUnit provides a way to compare doubles with a "delta" (tolerance):

```java
import static org.junit.Assert.assertEquals;

// ... inside a test method:
double expected = 0.3;
double actual = 0.1 + 0.2;
// The third argument is the allowed difference (delta) between expected and actual
assertEquals(expected, actual, 1e-9); // Passes if difference is less than 1e-9
```

**Explanation:**
- `assertEquals(expected, actual, delta)` passes if `expected` and `actual` are within `delta` of each other.
- This is the recommended way to compare floating point numbers in tests.
