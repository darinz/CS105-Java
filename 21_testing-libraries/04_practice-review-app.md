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

### Card Class in Java

```java
/**
 * Represents a playing card with a suit and value.
 */
public class Card {
    private int value; // 2-14 (where 11=Jack, 12=Queen, 13=King, 14=Ace)
    private String suit; // "Spades", "Clubs", "Diamonds", "Hearts"

    /**
     * Constructs a Card with the given value and suit.
     * Throws IllegalArgumentException if value or suit is invalid.
     */
    public Card(int value, String suit) {
        if (value < 2 || value > 14) {
            throw new IllegalArgumentException("Invalid card value: " + value);
        }
        if (!suit.equals("Spades") && !suit.equals("Clubs") && !suit.equals("Diamonds") && !suit.equals("Hearts")) {
            throw new IllegalArgumentException("Invalid suit: " + suit);
        }
        this.value = value;
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        String valueStr;
        switch (value) {
            case 11: valueStr = "J"; break;
            case 12: valueStr = "Q"; break;
            case 13: valueStr = "K"; break;
            case 14: valueStr = "A"; break;
            default: valueStr = String.valueOf(value);
        }
        return valueStr + " of " + suit;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Card)) return false;
        Card c = (Card) other;
        return this.value == c.value && this.suit.equals(c.suit);
    }
}
```

---

## Example: BattleManager Class

- Assumes two players
- **Setup:** 52-card deck is split between the two players evenly
- **Each round:**
  - Each player flips their top card
  - The player with the higher value card takes both cards
  - **Aces are considered "high"** – they beat all other values
  - If the cards have the same value, "battle":
    - Each player places 3 cards face down, then flips a new card, and the player with the higher value card takes all cards
    - (If this is another battle, repeat previous process)
- **Goal:** one player has all 52 cards 

### BattleManager Class in Java (Simplified)

```java
import java.util.LinkedList;
import java.util.Queue;

/**
 * Manages the card battle game between two players.
 */
public class BattleManager {
    private Queue<Card> player1Deck;
    private Queue<Card> player2Deck;

    public BattleManager() {
        // Initialize and deal cards
        // ... (deck creation and shuffling logic)
    }

    public BattleManager(Queue<Card> deck1, Queue<Card> deck2) {
        this.player1Deck = deck1;
        this.player2Deck = deck2;
    }

    public void deal() {
        // Split a shuffled deck between two players
        // ...
    }

    public boolean gameOver() {
        return player1Deck.isEmpty() || player2Deck.isEmpty();
    }

    public int getPlayer1DeckSize() {
        return player1Deck.size();
    }

    public int getPlayer2DeckSize() {
        return player2Deck.size();
    }

    public void play() {
        // Main game loop
        while (!gameOver()) {
            Card c1 = player1Deck.poll();
            Card c2 = player2Deck.poll();
            // Compare cards, handle battles, update decks
            // ...
        }
        // Announce winner
    }
}
```

---

## Practice: Test Cases

**What test cases can you test for the Card class?**
- Creating a valid card (e.g., new Card(12, "Hearts"))
- Creating a card with invalid value (should throw exception)
- Creating a card with invalid suit (should throw exception)
- Checking `toString()` output
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

### Example: Comparing Doubles in Java

```java
public class DoubleComparison {
    public static void main(String[] args) {
        double a = 0.1 + 0.2;
        double b = 0.3;
        System.out.println(a == b); // false! Due to floating point imprecision
        // Correct way:
        System.out.println(Math.abs(a - b) < 1e-9); // true
    }
}
```

### JUnit: assertEquals for Doubles

JUnit provides a way to compare doubles with a "delta" (tolerance):

```java
import static org.junit.Assert.assertEquals;

// ... inside a test method:
double expected = 0.3;
double actual = 0.1 + 0.2;
assertEquals(expected, actual, 1e-9); // Passes if difference is less than 1e-9
```
