import java.util.*;

/**
 * Sample solution for the StudentCourseManager class.
 * Demonstrates the use of nested collections (Map<String, List<String>>).
 */
public class Solution_StudentCourseManager {
    // Map to store student names and their list of courses
    private Map<String, List<String>> studentCourses;

    public Solution_StudentCourseManager() {
        // Initialize the map
        studentCourses = new HashMap<>();
    }

    // Adds a new student to the system
    public void addStudent(String studentName) {
        // Only add if the student is not already present
        if (!studentCourses.containsKey(studentName)) {
            studentCourses.put(studentName, new ArrayList<>());
        }
    }

    // Enrolls a student in a course
    public void enrollCourse(String studentName, String courseName) {
        // Add the student if not already present
        addStudent(studentName);
        List<String> courses = studentCourses.get(studentName);
        // Only add the course if not already enrolled
        if (!courses.contains(courseName)) {
            courses.add(courseName);
        }
    }

    // Returns the list of courses for a student
    public List<String> getCourses(String studentName) {
        // Return a copy to prevent external modification
        if (studentCourses.containsKey(studentName)) {
            return new ArrayList<>(studentCourses.get(studentName));
        } else {
            return new ArrayList<>();
        }
    }

    // Prints all students and their courses
    public void printAllEnrollments() {
        for (String student : studentCourses.keySet()) {
            System.out.println(student + ": " + studentCourses.get(student));
        }
    }
} 