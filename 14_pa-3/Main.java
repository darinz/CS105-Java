import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentCourseManager manager = new StudentCourseManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Enroll in Course");
            System.out.println("3. Display All Enrollments");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();
                manager.addStudent(name);
                System.out.println("Student added.");
            } else if (choice == 2) {
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();
                System.out.print("Enter course name: ");
                String course = scanner.nextLine();
                manager.enrollCourse(name, course);
                System.out.println("Course enrolled.");
            } else if (choice == 3) {
                manager.printAllEnrollments();
            } else if (choice == 4) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
} 