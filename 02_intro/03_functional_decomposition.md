# Functional Decomposition

Functional decomposition is the process of breaking down a complex problem or system into smaller, more manageable parts that are easier to conceive, understand, program, and maintain. This is a fundamental principle in software engineering and is essential for writing clean, maintainable Java code.

## What is Functional Decomposition?

Think of functional decomposition like organizing a complex task into a series of smaller, focused steps. Each step has a clear purpose and can be understood independently, making the overall solution much easier to comprehend and implement.

## Real-World Example: Baking Cookies

Let's start with a familiar example to illustrate the concept:

**Problem**: "Bake chocolate chip cookies"

**Decomposed into steps**:

1. **Prepare Wet Ingredients**
   - Mix butter and sugar until creamy
   - Beat in eggs and vanilla extract

2. **Prepare Dry Ingredients**
   - Mix flour, baking soda, and chocolate chips
   - Combine wet and dry ingredients

3. **Shape and Place**
   - Make cookie-sized balls of dough
   - Place evenly on baking sheet

4. **Bake and Finish**
   - Bake at 350°F for 10-12 minutes
   - Let cool on wire rack

Each step is focused, testable, and can be done independently. This same principle applies to programming.

## Java Implementation: Minesweeper Game

Let's see how functional decomposition works in a Java program. Here's how we might structure a Minesweeper game:

```java
// Import necessary Java libraries
import java.util.Random;  // For generating random mine positions
import java.util.Scanner; // For reading user input

/**
 * Minesweeper Game - A complete implementation demonstrating functional decomposition
 * 
 * This class shows how a complex game can be broken down into smaller, focused methods.
 * Each method has a single responsibility and can be understood independently.
 */
public class Minesweeper {
    // Instance variables (fields) - store the game state
    private int[][] board;        // 2D array: -1 = mine, 0-8 = number of adjacent mines
    private boolean[][] revealed; // 2D array: tracks which squares have been revealed
    private int rows, cols, mines; // Game configuration
    
    /**
     * Main method - Entry point of the program
     * This is where execution begins when you run the program
     */
    public static void main(String[] args) {
        // Create a new game instance and start playing
        Minesweeper game = new Minesweeper();
        game.play();
    }
    
    /**
     * Main game loop - orchestrates the entire game flow
     * This method shows the high-level structure of the game
     */
    public void play() {
        introduceGame();  // Step 1: Welcome the player
        setupGame();      // Step 2: Initialize the game board
        playGame();       // Step 3: Main game loop
        endGame();        // Step 4: Clean up and say goodbye
    }
    
    /**
     * Introduces the game to the player
     * This method has a single, clear purpose: inform the user
     */
    private void introduceGame() {
        System.out.println("Welcome to Minesweeper!");
        System.out.println("Find all the mines without detonating them.");
        System.out.println("Numbers indicate how many mines are adjacent to that square.");
        System.out.println("Enter row and column numbers to reveal squares.");
    }
    
    /**
     * Sets up the initial game state
     * This method coordinates the setup process by calling other focused methods
     */
    private void setupGame() {
        initializeBoard();  // Create empty board
        placeMines();       // Add mines randomly
        calculateNumbers(); // Calculate numbers for non-mine squares
    }
    
    /**
     * Creates the initial game board with default values
     * All squares start as 0 (no adjacent mines) and unrevealed
     */
    private void initializeBoard() {
        // Set game dimensions and difficulty
        rows = 8;   // 8 rows
        cols = 8;   // 8 columns  
        mines = 10; // 10 mines (medium difficulty)
        
        // Create 2D arrays to store game state
        board = new int[rows][cols];        // Stores mine positions and numbers
        revealed = new boolean[rows][cols]; // Tracks revealed squares
        
        // Note: Java automatically initializes int arrays to 0 and boolean arrays to false
        // So we don't need to explicitly set initial values
    }
    
    /**
     * Randomly places mines on the board
     * Uses a Random object to generate random positions
     */
    private void placeMines() {
        Random random = new Random();  // Create random number generator
        int minesPlaced = 0;           // Counter to track how many mines we've placed
        
        // Keep placing mines until we have the desired number
        while (minesPlaced < mines) {
            // Generate random row and column positions
            int row = random.nextInt(rows);  // Random number from 0 to rows-1
            int col = random.nextInt(cols);  // Random number from 0 to cols-1
            
            // Check if this position doesn't already have a mine
            if (board[row][col] != -1) {  // -1 represents a mine
                board[row][col] = -1;     // Place the mine
                minesPlaced++;            // Increment our counter
            }
            // If position already has a mine, loop continues and tries again
        }
    }
    
    /**
     * Calculates the number of adjacent mines for each non-mine square
     * This is what creates the numbers you see in Minesweeper
     */
    private void calculateNumbers() {
        // Loop through every position on the board
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // Only calculate for non-mine squares
                if (board[row][col] != -1) {
                    // Count adjacent mines and store the result
                    board[row][col] = countAdjacentMines(row, col);
                }
            }
        }
    }
    
    /**
     * Counts how many mines are adjacent to a given position
     * 
     * @param row The row position to check
     * @param col The column position to check
     * @return The number of adjacent mines (0-8)
     */
    private int countAdjacentMines(int row, int col) {
        int count = 0;  // Initialize counter
        
        // Check all 8 adjacent positions (including diagonals)
        // We use nested loops to check row-1, row, row+1 and col-1, col, col+1
        for (int dr = -1; dr <= 1; dr++) {      // dr = delta row (-1, 0, 1)
            for (int dc = -1; dc <= 1; dc++) {  // dc = delta column (-1, 0, 1)
                // Calculate the adjacent position
                int newRow = row + dr;
                int newCol = col + dc;
                
                // Check if the position is valid and contains a mine
                if (isValidPosition(newRow, newCol) && board[newRow][newCol] == -1) {
                    count++;  // Found an adjacent mine
                }
            }
        }
        return count;
    }
    
    /**
     * Checks if a given position is within the bounds of the board
     * This prevents ArrayIndexOutOfBoundsException when checking adjacent positions
     * 
     * @param row The row to check
     * @param col The column to check
     * @return true if position is valid, false otherwise
     */
    private boolean isValidPosition(int row, int col) {
        // Check if row and column are within valid ranges
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
    
    /**
     * Main game loop - handles player input and game progression
     * This method manages the core gameplay until the game ends
     */
    private void playGame() {
        Scanner scanner = new Scanner(System.in);  // Create input reader
        boolean gameOver = false;                   // Game state flag
        
        // Continue until the game ends (win or lose)
        while (!gameOver) {
            displayBoard();  // Show current board state
            
            // Get player input
            System.out.print("Enter row and column (e.g., 3 4): ");
            int row = scanner.nextInt();  // Read row number
            int col = scanner.nextInt();  // Read column number
            
            // Check if player hit a mine
            if (board[row][col] == -1) {
                gameOver = true;  // Game over - player lost
                System.out.println("BOOM! You hit a mine!");
            } else {
                // Player didn't hit a mine - reveal the square
                revealSquare(row, col);
                
                // Check if player has won (all non-mine squares revealed)
                if (checkWin()) {
                    gameOver = true;  // Game over - player won
                    System.out.println("Congratulations! You won!");
                }
            }
        }
        scanner.close();  // Clean up resources
    }
    
    /**
     * Reveals a square and recursively reveals adjacent squares if needed
     * This implements the "flood fill" behavior of Minesweeper
     * 
     * @param row The row to reveal
     * @param col The column to reveal
     */
    private void revealSquare(int row, int col) {
        // Base case: if position is invalid or already revealed, do nothing
        if (!isValidPosition(row, col) || revealed[row][col]) {
            return;  // Exit method early
        }
        
        // Mark this square as revealed
        revealed[row][col] = true;
        
        // If this is an empty square (no adjacent mines), reveal adjacent squares
        if (board[row][col] == 0) {
            // Recursively reveal all 8 adjacent squares
            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    revealSquare(row + dr, col + dc);
                }
            }
        }
        // If square has a number, don't reveal adjacent squares (player must choose)
    }
    
    /**
     * Displays the current state of the game board
     * Shows revealed squares with numbers or empty spaces, hidden squares as dots
     */
    private void displayBoard() {
        // Print column headers
        System.out.println("  0 1 2 3 4 5 6 7");
        
        // Loop through each row
        for (int row = 0; row < rows; row++) {
            System.out.print(row + " ");  // Print row number
            
            // Loop through each column in this row
            for (int col = 0; col < cols; col++) {
                if (revealed[row][col]) {
                    // Square is revealed - show its contents
                    if (board[row][col] == -1) {
                        System.out.print("* ");  // Mine (shouldn't happen in normal play)
                    } else if (board[row][col] == 0) {
                        System.out.print("  ");  // Empty square (no adjacent mines)
                    } else {
                        System.out.print(board[row][col] + " ");  // Number of adjacent mines
                    }
                } else {
                    // Square is hidden - show as dot
                    System.out.print(". ");
                }
            }
            System.out.println();  // Move to next line after each row
        }
    }
    
    /**
     * Checks if the player has won the game
     * Player wins when all non-mine squares have been revealed
     * 
     * @return true if player has won, false otherwise
     */
    private boolean checkWin() {
        // Check every position on the board
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // If there's a non-mine square that hasn't been revealed, game isn't won yet
                if (board[row][col] != -1 && !revealed[row][col]) {
                    return false;  // Found an unrevealed non-mine square
                }
            }
        }
        return true;  // All non-mine squares have been revealed
    }
    
    /**
     * Handles game cleanup and farewell message
     * This method is called when the game ends
     */
    private void endGame() {
        System.out.println("Thanks for playing!");
    }
}
```

## Benefits of Functional Decomposition

### 1. **Readability**
Each method has a single, clear purpose. When you read `play()`, you immediately understand the high-level flow without getting lost in implementation details.

### 2. **Maintainability**
If you need to change how mines are placed, you only modify `placeMines()`. Other parts remain unaffected, reducing the risk of introducing bugs.

### 3. **Testability**
You can test each method independently:
```java
// Example unit test for the countAdjacentMines method
@Test
public void testCountAdjacentMines() {
    Minesweeper game = new Minesweeper();
    
    // Set up a specific board configuration for testing
    game.board = new int[][] {
        {-1, 0, 0},  // Mine in top-left
        { 0, 0, 0},  // Empty middle row
        { 0, 0, 0}   // Empty bottom row
    };
    
    // Test that the square next to the mine returns 1
    int adjacentMines = game.countAdjacentMines(0, 1);
    assertEquals(1, adjacentMines);
}
```

### 4. **Reusability**
Methods like `isValidPosition()` can be reused throughout the class, eliminating code duplication.

## When to Decompose

### Good Candidates for Decomposition:

1. **Methods longer than 10-15 lines** - Long methods are hard to understand and maintain
2. **Methods with multiple responsibilities** - Each method should do one thing well
3. **Repeated code patterns** - Extract common functionality into reusable methods
4. **Complex conditional logic** - Break complex conditions into well-named boolean methods

### Example: Refactoring a Long Method

**Before (Poor):**
```java
/**
 * This method does too many things - it's hard to understand and test
 */
public void processStudentData() {
    // 50 lines of mixed responsibilities:
    // - Reading files
    // - Parsing data  
    // - Performing calculations
    // - Formatting output
    // - Writing to database
    // - Sending notifications
}
```

**After (Good):**
```java
/**
 * Main orchestrator method - easy to understand the overall process
 */
public void processStudentData() {
    List<Student> students = readStudentData();           // Step 1: Read data
    List<Student> processedStudents = calculateGrades(students);  // Step 2: Process
    generateReport(processedStudents);                    // Step 3: Output results
}

/**
 * Handles all file reading operations
 */
private List<Student> readStudentData() {
    // Focused on file reading only
}

/**
 * Handles all grade calculation logic
 */
private List<Student> calculateGrades(List<Student> students) {
    // Focused on calculations only
}

/**
 * Handles all report generation and output
 */
private void generateReport(List<Student> students) {
    // Focused on output only
}
```

## Avoiding Trivial Methods

### ❌ Bad Examples:

```java
// Too trivial - just a wrapper around existing functionality
public static void printMessage(String message) {
    System.out.println(message);  // No added value
}

// No meaningful abstraction - just returns the sum
public static int add(int a, int b) {
    return a + b;  // Java already has the + operator
}

// Unnecessary complexity for a simple operation
public static String getFirstName(String fullName) {
    return fullName.split(" ")[0];  // Could be done inline
}
```

### ✅ Good Examples:

```java
/**
 * Rounds a number to a specified number of decimal places
 * This method encapsulates the rounding logic and makes it reusable
 * 
 * @param num The number to round
 * @param places Number of decimal places to round to
 * @return The rounded number
 */
public static double roundToDecimalPlaces(double num, int places) {
    double multiplier = Math.pow(10, places);  // Calculate multiplier (e.g., 100 for 2 places)
    return Math.round(num * multiplier) / multiplier;  // Round and scale back
}

/**
 * Validates email format using regex pattern
 * This method encapsulates complex validation logic
 * 
 * @param email The email address to validate
 * @return true if email is valid, false otherwise
 */
public static boolean isValidEmail(String email) {
    // Handle null and empty cases
    if (email == null || email.isEmpty()) {
        return false;
    }
    
    // Complex regex pattern for email validation
    String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    return email.matches(emailRegex);
}

/**
 * Formats currency based on currency code
 * This method handles locale-specific formatting
 * 
 * @param amount The amount to format
 * @param currencyCode The currency code (e.g., "USD", "EUR")
 * @return Formatted currency string
 */
public static String formatCurrency(double amount, String currencyCode) {
    Locale locale = getLocaleForCurrency(currencyCode);  // Get appropriate locale
    NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);  // Create formatter
    return formatter.format(amount);  // Format the amount
}
```

## Rule of Thumb: The Two-Step Test

A method should perform **at least two meaningful steps** or handle **one complex operation** that would be difficult to understand if written inline.

### Questions to Ask Yourself:

1. **Does adding this method make my code easier to understand?**
2. **Would someone reading this code benefit from the abstraction?**
3. **Is this method doing something that could be reused elsewhere?**
4. **Does this method have a clear, single responsibility?**

## Advanced Decomposition Patterns

### 1. **Extract Method for Complex Conditions**

```java
// Before - complex condition is hard to read and understand
if (age >= 18 && hasValidLicense && insuranceStatus.equals("ACTIVE") && 
    !hasRecentViolations && creditScore > 650) {
    approveLoan();
}

// After - condition is now self-documenting
if (isEligibleForLoan(age, hasValidLicense, insuranceStatus, hasRecentViolations, creditScore)) {
    approveLoan();
}

/**
 * Determines if a person is eligible for a loan based on multiple criteria
 * This method makes the loan approval logic clear and testable
 * 
 * @param age The applicant's age
 * @param hasValidLicense Whether they have a valid driver's license
 * @param insuranceStatus Their current insurance status
 * @param hasRecentViolations Whether they have recent traffic violations
 * @param creditScore Their credit score
 * @return true if eligible for loan, false otherwise
 */
private boolean isEligibleForLoan(int age, boolean hasValidLicense, String insuranceStatus, 
                                 boolean hasRecentViolations, int creditScore) {
    return age >= 18 &&                    // Must be adult
           hasValidLicense &&              // Must have valid license
           insuranceStatus.equals("ACTIVE") &&  // Must have active insurance
           !hasRecentViolations &&         // No recent violations
           creditScore > 650;              // Good credit score required
}
```

### 2. **Extract Method for Repeated Code**

```java
// Before - validation logic is duplicated in multiple methods
public void addStudent(String name, int age, String email) {
    if (name == null || name.trim().isEmpty()) {
        throw new IllegalArgumentException("Name cannot be empty");
    }
    if (age < 0 || age > 120) {
        throw new IllegalArgumentException("Invalid age");
    }
    if (email == null || !email.contains("@")) {
        throw new IllegalArgumentException("Invalid email");
    }
    // Add student logic here...
}

public void updateStudent(String name, int age, String email) {
    if (name == null || name.trim().isEmpty()) {
        throw new IllegalArgumentException("Name cannot be empty");
    }
    if (age < 0 || age > 120) {
        throw new IllegalArgumentException("Invalid age");
    }
    if (email == null || !email.contains("@")) {
        throw new IllegalArgumentException("Invalid email");
    }
    // Update student logic here...
}

// After - validation logic is extracted into a reusable method
public void addStudent(String name, int age, String email) {
    validateStudentData(name, age, email);  // Single line of validation
    // Add student logic here...
}

public void updateStudent(String name, int age, String email) {
    validateStudentData(name, age, email);  // Single line of validation
    // Update student logic here...
}

/**
 * Validates student data and throws exceptions for invalid data
 * This method eliminates code duplication and centralizes validation logic
 * 
 * @param name The student's name
 * @param age The student's age
 * @param email The student's email
 * @throws IllegalArgumentException if any data is invalid
 */
private void validateStudentData(String name, int age, String email) {
    // Validate name
    if (name == null || name.trim().isEmpty()) {
        throw new IllegalArgumentException("Name cannot be empty");
    }
    
    // Validate age
    if (age < 0 || age > 120) {
        throw new IllegalArgumentException("Invalid age");
    }
    
    // Validate email (basic check)
    if (email == null || !email.contains("@")) {
        throw new IllegalArgumentException("Invalid email");
    }
}
```

## Best Practices Summary

1. **Keep methods focused and single-purpose** - Each method should do one thing well
2. **Use descriptive method names that explain what they do** - Names should be verbs or verb phrases
3. **Aim for methods that are 10-15 lines or less** - Long methods are hard to understand
4. **Extract complex conditions into well-named boolean methods** - Makes code self-documenting
5. **Don't create methods that are just simple wrappers** - Avoid trivial abstractions
6. **Consider reusability when decomposing** - Methods should be useful in multiple contexts
7. **Test each method independently when possible** - Makes debugging easier
8. **Add comments and documentation** - Explain complex logic and method purposes
9. **Use consistent naming conventions** - Follow Java naming standards
10. **Consider the reader** - Write code that's easy for others to understand

## Conclusion

Functional decomposition is a powerful technique that transforms complex, hard-to-understand code into clear, maintainable, and testable components. By breaking down problems into smaller, focused pieces, you create code that is easier to write, debug, and modify. 

**Key Takeaway**: When in doubt, ask yourself: "Does this method make my code easier to understand?" If the answer is yes, it's probably a good decomposition. If the answer is no, you might be over-engineering.

Remember: The goal is not to create the most methods possible, but to create the right methods that make your code more understandable and maintainable. Good decomposition strikes a balance between breaking down complexity and avoiding unnecessary abstraction.