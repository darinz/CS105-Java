import java.util.*;
// Uncomment this to read input from a file
// import java.io.*;

public class ExpressionEvaluator {
    public static void main(String[] args) {
        // TODO: Read input from file or standard input
        // Example: String expression = "3 + 4 * 2 / ( 1 - 5 )";
        // You may use Scanner or BufferedReader
    }

    // Converts infix expression to postfix (RPN)
    public static Queue<String> infixToPostfix(String expression) throws InvalidExpressionException {
        // TODO: Implement using Stack and Queue
        // Return a Queue representing the postfix expression
        return null;
    }

    // Evaluates a postfix expression
    public static int evaluatePostfix(Queue<String> postfix) throws InvalidExpressionException {
        // TODO: Implement using Stack
        return 0;
    }

    // Custom exception for invalid expressions
    public static class InvalidExpressionException extends Exception {
        public InvalidExpressionException(String message) {
            super(message);
        }
    }
} 