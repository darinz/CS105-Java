/*
 * MiniProjectSolution.java
 *
 * Sample solution: This app is a simple to-do list manager. It allows the user to add tasks, remove tasks by number, and display all current tasks. Tasks are stored in an ArrayList.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class MiniProjectSolution {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\nTo-Do List Menu:");
            System.out.println("1. Add task");
            System.out.println("2. Remove task");
            System.out.println("3. Display tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    System.out.print("Enter new task: ");
                    String task = scanner.nextLine();
                    tasks.add(task);
                    System.out.println("Task added.");
                    break;
                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to remove.");
                        break;
                    }
                    System.out.print("Enter task number to remove: ");
                    int num = scanner.nextInt();
                    scanner.nextLine();
                    if (num > 0 && num <= tasks.size()) {
                        System.out.println("Removed: " + tasks.remove(num - 1));
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;
                case 3:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks in the list.");
                    } else {
                        System.out.println("Current tasks:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
} 