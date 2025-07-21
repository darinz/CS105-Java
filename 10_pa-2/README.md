# Programming Assignment 2

## Stack & Queue Expression Evaluator

**Overview:**  
In this assignment, you will implement a simple arithmetic expression evaluator using Stacks and Queues. You will also practice exception handling for invalid expressions.

**Objectives:**
- Practice using Stack and Queue data structures in Java
- Implement exception handling for invalid input
- Apply course concepts in a practical context

**Task:**
1. Implement a class `ExpressionEvaluator` with the following features:
   - Reads an arithmetic expression in infix notation (e.g., `3 + 4 * 2 / ( 1 - 5 )`)
   - Converts the infix expression to postfix (Reverse Polish Notation) using a Stack and a Queue
   - Evaluates the postfix expression using a Stack
   - Handles invalid expressions using custom exceptions

2. Starter code is provided in `ExpressionEvaluator.java`.

3. You may use Java’s built-in `Stack` and `LinkedList` (as a Queue).

**Requirements:**
- Your program should read an expression from standard input or a file.
- Output the postfix expression and the result.
- Handle invalid expressions gracefully (e.g., mismatched parentheses, invalid tokens).

**Example:**
```
Input: 3 + 4 * 2 / ( 1 - 5 )
Output:
Postfix: 3 4 2 * 1 5 - / +
Result: 1
```

**Files Provided:**
- `ExpressionEvaluator.java` (starter code)
- `sample_input.txt` (example input)
- `expected_output.txt` (example output)

**Submission:**
- Submit your completed `ExpressionEvaluator.java`.