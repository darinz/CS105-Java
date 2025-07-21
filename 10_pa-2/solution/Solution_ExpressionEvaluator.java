import java.util.*;
import java.io.*;

public class Solution_ExpressionEvaluator {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            if (args.length > 0) {
                scanner = new Scanner(new File(args[0]));
            } else {
                scanner = new Scanner(System.in);
            }
            while (scanner.hasNextLine()) {
                String expression = scanner.nextLine().trim();
                if (expression.isEmpty()) continue;
                try {
                    Queue<String> postfix = infixToPostfix(expression);
                    System.out.println("Input: " + expression);
                    System.out.print("Postfix: ");
                    for (String token : postfix) {
                        System.out.print(token + " ");
                    }
                    System.out.println();
                    int result = evaluatePostfix(new LinkedList<>(postfix));
                    System.out.println("Result: " + result);
                } catch (InvalidExpressionException e) {
                    System.out.println("Input: " + expression);
                    System.out.println("Error: " + e.getMessage());
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } finally {
            if (scanner != null) scanner.close();
        }
    }

    // Converts infix expression to postfix (RPN)
    public static Queue<String> infixToPostfix(String expression) throws InvalidExpressionException {
        Stack<String> stack = new Stack<>();
        Queue<String> output = new LinkedList<>();
        String[] tokens = expression.split("\\s+");
        for (String token : tokens) {
            if (isInteger(token)) {
                output.add(token);
            } else if (isOperator(token)) {
                while (!stack.isEmpty() && isOperator(stack.peek()) &&
                        ((isLeftAssociative(token) && precedence(token) <= precedence(stack.peek())) ||
                        (!isLeftAssociative(token) && precedence(token) < precedence(stack.peek())))) {
                    output.add(stack.pop());
                }
                stack.push(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                boolean foundLeftParen = false;
                while (!stack.isEmpty()) {
                    String top = stack.pop();
                    if (top.equals("(")) {
                        foundLeftParen = true;
                        break;
                    } else {
                        output.add(top);
                    }
                }
                if (!foundLeftParen) {
                    throw new InvalidExpressionException("Mismatched parentheses");
                }
            } else {
                throw new InvalidExpressionException("Invalid token: " + token);
            }
        }
        while (!stack.isEmpty()) {
            String top = stack.pop();
            if (top.equals("(") || top.equals(")")) {
                throw new InvalidExpressionException("Mismatched parentheses");
            }
            output.add(top);
        }
        return output;
    }

    // Evaluates a postfix expression
    public static int evaluatePostfix(Queue<String> postfix) throws InvalidExpressionException {
        Stack<Integer> stack = new Stack<>();
        while (!postfix.isEmpty()) {
            String token = postfix.poll();
            if (isInteger(token)) {
                stack.push(Integer.parseInt(token));
            } else if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new InvalidExpressionException("Insufficient operands for operator: " + token);
                }
                int b = stack.pop();
                int a = stack.pop();
                int result = 0;
                switch (token) {
                    case "+": result = a + b; break;
                    case "-": result = a - b; break;
                    case "*": result = a * b; break;
                    case "/":
                        if (b == 0) throw new InvalidExpressionException("Division by zero");
                        result = a / b; break;
                    default:
                        throw new InvalidExpressionException("Unknown operator: " + token);
                }
                stack.push(result);
            } else {
                throw new InvalidExpressionException("Invalid token in postfix: " + token);
            }
        }
        if (stack.size() != 1) {
            throw new InvalidExpressionException("Invalid postfix expression");
        }
        return stack.pop();
    }

    // Helper methods
    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private static int precedence(String op) {
        switch (op) {
            case "+": case "-": return 1;
            case "*": case "/": return 2;
            default: return 0;
        }
    }

    private static boolean isLeftAssociative(String op) {
        // All operators in this assignment are left-associative
        return true;
    }

    // Custom exception for invalid expressions
    public static class InvalidExpressionException extends Exception {
        public InvalidExpressionException(String message) {
            super(message);
        }
    }
} 