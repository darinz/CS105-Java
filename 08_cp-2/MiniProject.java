/*
 * MiniProject.java
 *
 * This app is a simple to-do list manager. It lets the user add tasks, remove tasks, and view all current tasks. All tasks are stored in an ArrayList.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class MiniProject {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nTo-Do List Menu:");
            System.out.println("1. Add task");
            System.out.println("2. Remove task");
            System.out.println("3. Display tasks");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            if (choice == 1) {
                System.out.print("Enter task: ");
                String task = scanner.nextLine();
                tasks.add(task);
                System.out.println("Task added.");
            } else if (choice == 2) {
                System.out.print("Enter task number to remove: ");
                int num = scanner.nextInt();
                scanner.nextLine();
                if (num > 0 && num <= tasks.size()) {
                    tasks.remove(num - 1);
                    System.out.println("Task removed.");
                } else {
                    System.out.println("Invalid task number.");
                }
            } else if (choice == 3) {
                System.out.println("Current tasks:");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i + 1) + ". " + tasks.get(i));
                }
            } else if (choice == 4) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
} 