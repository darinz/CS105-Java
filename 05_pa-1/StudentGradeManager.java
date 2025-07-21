import java.io.*;
import java.util.*;

/**
 * Programming Assignment 1: Student Grade Manager
 * 
 * This program demonstrates File I/O concepts by:
 * 1. Reading student data from files
 * 2. Processing and calculating grades
 * 3. Generating formatted reports
 * 
 * @author CS105 Student
 * @version 1.0
 */
public class StudentGradeManager {
    
    // Constants for grade calculations
    // Uncomment these to use them
    // private static final double ASSIGNMENT_WEIGHT = 0.40;
    // private static final double MIDTERM_WEIGHT = 0.25;
    // private static final double FINAL_WEIGHT = 0.35;
    
    /**
     * Main method - orchestrates the entire grade management process
     */
    public static void main(String[] args) {
        System.out.println("=== Student Grade Manager ===");
        System.out.println("Reading student data and processing grades...\n");
        
        try {
            // Part 1: Read and validate student data
            List<Student> students = readStudentData("students.txt");
            System.out.println("Successfully read " + students.size() + " student records.\n");
            
            // Part 2: Read and process grades
            Map<String, GradeRecord> grades = readGradeData("grades.txt");
            System.out.println("Successfully read " + grades.size() + " grade records.\n");
            
            // Part 3: Calculate final grades and generate reports
            List<StudentReport> reports = calculateFinalGrades(students, grades);
            generateReports(reports);
            
            System.out.println("Grade processing completed successfully!");
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: Required input file not found - " + e.getMessage());
            System.out.println("Please ensure students.txt and grades.txt are in the same directory.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    /**
     * Part 1: Student Data Reader
     * Reads student information from a text file and validates the data.
     * 
     * File format: ID,Name,Email (one student per line)
     * Example: 1001,John Doe,john.doe@email.com
     * 
     * @param filename The name of the file containing student data
     * @return List of Student objects
     * @throws FileNotFoundException if the file cannot be found
     */
    public static List<Student> readStudentData(String filename) throws FileNotFoundException {
        List<Student> students = new ArrayList<>();
        
        // TODO: Implement this method
        // 1. Create a File object for the given filename
        // 2. Create a Scanner to read from the file
        // 3. Read the file line by line
        // 4. For each line, split by comma and create a Student object
        // 5. Validate that each line has exactly 3 parts (ID, Name, Email)
        // 6. Add valid students to the list
        // 7. Handle any exceptions and provide meaningful error messages
        // 8. Don't forget to close the Scanner!
        
        System.out.println("Reading student data from " + filename + "...");
        
        // Your implementation goes here
        
        return students;
    }
    
    /**
     * Part 2: Grade Calculator
     * Reads grade data from a file and processes student scores.
     * 
     * File format: ID,AssignmentScore,MidtermScore,FinalScore (one student per line)
     * Example: 1001,85.5,78.0,82.5
     * 
     * @param filename The name of the file containing grade data
     * @return Map of student ID to GradeRecord objects
     * @throws FileNotFoundException if the file cannot be found
     */
    public static Map<String, GradeRecord> readGradeData(String filename) throws FileNotFoundException {
        Map<String, GradeRecord> grades = new HashMap<>();
        
        // TODO: Implement this method
        // 1. Create a File object for the given filename
        // 2. Create a Scanner to read from the file
        // 3. Read the file line by line
        // 4. For each line, split by comma and create a GradeRecord object
        // 5. Validate that each line has exactly 4 parts (ID, Assignment, Midterm, Final)
        // 6. Validate that all scores are between 0 and 100
        // 7. Add valid grade records to the map using student ID as key
        // 8. Handle any exceptions and provide meaningful error messages
        // 9. Don't forget to close the Scanner!
        
        System.out.println("Reading grade data from " + filename + "...");
        
        // Your implementation goes here
        
        return grades;
    }
    
    /**
     * Part 3: Report Generator
     * Calculates final grades and creates student reports.
     * 
     * @param students List of all students
     * @param grades Map of student grades
     * @return List of StudentReport objects
     */
    public static List<StudentReport> calculateFinalGrades(List<Student> students, Map<String, GradeRecord> grades) {
        List<StudentReport> reports = new ArrayList<>();
        
        // TODO: Implement this method
        // 1. Iterate through each student
        // 2. Find the corresponding grade record for each student
        // 3. Calculate the final grade using the weights defined in constants
        // 4. Determine the letter grade based on the final score
        // 5. Create a StudentReport object for each student
        // 6. Handle cases where a student might not have grade data
        // 7. Add all reports to the list
        
        System.out.println("Calculating final grades...");
        
        // Your implementation goes here
        
        return reports;
    }
    
    /**
     * Generates formatted reports and saves them to output files.
     * 
     * @param reports List of student reports to process
     */
    public static void generateReports(List<StudentReport> reports) {
        // TODO: Implement this method
        // 1. Create a summary report showing class statistics
        // 2. Create individual student reports
        // 3. Save reports to output files using PrintStream
        // 4. Format output nicely with headers and proper spacing
        // 5. Include error handling for file writing operations
        
        System.out.println("Generating reports...");
        
        // TODO: Generate summary report
        // - Calculate class average, highest score, lowest score
        // - Count students by letter grade
        // - Save to "class_summary.txt"
        
        // TODO: Generate individual reports
        // - Create a separate file for each student
        // - Include all student information and grades
        // - Save to "student_[ID]_report.txt"
        
        // TODO: Generate grade distribution
        // - Show how many students got each letter grade
        // - Save to "grade_distribution.txt"
        
        System.out.println("Reports generated successfully!");
    }
    
    /**
     * Helper method to determine letter grade based on numerical score
     * 
     * @param score Numerical score (0-100)
     * @return Letter grade (A, B, C, D, or F)
     */
    public static String getLetterGrade(double score) {
        if (score >= 90.0) return "A";
        else if (score >= 80.0) return "B";
        else if (score >= 70.0) return "C";
        else if (score >= 60.0) return "D";
        else return "F";
    }
}

/**
 * Student class to represent student information
 */
class Student {
    private String id;
    private String name;
    private String email;
    
    public Student(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    
    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    
    @Override
    public String toString() {
        return "Student{id='" + id + "', name='" + name + "', email='" + email + "'}";
    }
}

/**
 * GradeRecord class to represent student grades
 */
class GradeRecord {
    private String studentId;
    private double assignmentScore;
    private double midtermScore;
    private double finalScore;
    
    public GradeRecord(String studentId, double assignmentScore, double midtermScore, double finalScore) {
        this.studentId = studentId;
        this.assignmentScore = assignmentScore;
        this.midtermScore = midtermScore;
        this.finalScore = finalScore;
    }
    
    // Getters
    public String getStudentId() { return studentId; }
    public double getAssignmentScore() { return assignmentScore; }
    public double getMidtermScore() { return midtermScore; }
    public double getFinalScore() { return finalScore; }
    
    @Override
    public String toString() {
        return "GradeRecord{studentId='" + studentId + 
               "', assignment=" + assignmentScore + 
               ", midterm=" + midtermScore + 
               ", final=" + finalScore + "}";
    }
}

/**
 * StudentReport class to represent final student reports
 */
class StudentReport {
    private Student student;
    private GradeRecord grades;
    private double finalScore;
    private String letterGrade;
    
    public StudentReport(Student student, GradeRecord grades, double finalScore, String letterGrade) {
        this.student = student;
        this.grades = grades;
        this.finalScore = finalScore;
        this.letterGrade = letterGrade;
    }
    
    // Getters
    public Student getStudent() { return student; }
    public GradeRecord getGrades() { return grades; }
    public double getFinalScore() { return finalScore; }
    public String getLetterGrade() { return letterGrade; }
    
    @Override
    public String toString() {
        return "StudentReport{student=" + student.getName() + 
               ", finalScore=" + finalScore + 
               ", letterGrade='" + letterGrade + "'}";
    }
} 