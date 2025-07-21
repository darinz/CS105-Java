import java.util.*;

public class StudentCourseManager {
    // Map to store student names and their list of courses
    private Map<String, List<String>> studentCourses;

    public StudentCourseManager() {
        // Initialize the map
        studentCourses = new HashMap<>();
    }

    // Adds a new student to the system
    public void addStudent(String studentName) {
        // TODO: Add student if not already present
    }

    // Enrolls a student in a course
    public void enrollCourse(String studentName, String courseName) {
        // TODO: Add course to the student's list
    }

    // Returns the list of courses for a student
    public List<String> getCourses(String studentName) {
        // TODO: Return the list of courses, or an empty list if student not found
        return null;
    }

    // Prints all students and their courses
    public void printAllEnrollments() {
        // TODO: Iterate over the map and print each student and their courses
    }
} 