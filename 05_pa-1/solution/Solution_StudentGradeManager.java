import java.io.*;
import java.util.*;

/**
 * Programming Assignment 1: Student Grade Manager - SOLUTION
 * 
 * This program demonstrates File I/O concepts by:
 * 1. Reading student data from files
 * 2. Processing and calculating grades
 * 3. Generating formatted reports
 * 
 * @author CS105 Instructor
 * @version 1.0
 */
public class Solution_StudentGradeManager {
    
    // Constants for grade calculations
    private static final double ASSIGNMENT_WEIGHT = 0.40;
    private static final double MIDTERM_WEIGHT = 0.25;
    private static final double FINAL_WEIGHT = 0.35;
    
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
        
        System.out.println("Reading student data from " + filename + "...");
        
        // Create File object and Scanner
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        
        try {
            // Read file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                
                // Skip empty lines
                if (line.isEmpty()) {
                    continue;
                }
                
                // Split line by comma
                String[] parts = line.split(",");
                
                // Validate that we have exactly 3 parts
                if (parts.length != 3) {
                    System.out.println("Warning: Invalid line format - " + line);
                    continue;
                }
                
                // Extract and validate data
                String id = parts[0].trim();
                String name = parts[1].trim();
                String email = parts[2].trim();
                
                // Basic validation
                if (id.isEmpty() || name.isEmpty() || email.isEmpty()) {
                    System.out.println("Warning: Empty fields in line - " + line);
                    continue;
                }
                
                // Create Student object and add to list
                Student student = new Student(id, name, email);
                students.add(student);
            }
        } finally {
            // Always close the scanner
            scanner.close();
        }
        
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
        
        System.out.println("Reading grade data from " + filename + "...");
        
        // Create File object and Scanner
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        
        try {
            // Read file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                
                // Skip empty lines
                if (line.isEmpty()) {
                    continue;
                }
                
                // Split line by comma
                String[] parts = line.split(",");
                
                // Validate that we have exactly 4 parts
                if (parts.length != 4) {
                    System.out.println("Warning: Invalid grade line format - " + line);
                    continue;
                }
                
                try {
                    // Extract and parse data
                    String id = parts[0].trim();
                    double assignmentScore = Double.parseDouble(parts[1].trim());
                    double midtermScore = Double.parseDouble(parts[2].trim());
                    double finalScore = Double.parseDouble(parts[3].trim());
                    
                    // Validate scores are within valid range
                    if (assignmentScore < 0 || assignmentScore > 100 ||
                        midtermScore < 0 || midtermScore > 100 ||
                        finalScore < 0 || finalScore > 100) {
                        System.out.println("Warning: Invalid score range in line - " + line);
                        continue;
                    }
                    
                    // Create GradeRecord object and add to map
                    GradeRecord gradeRecord = new GradeRecord(id, assignmentScore, midtermScore, finalScore);
                    grades.put(id, gradeRecord);
                    
                } catch (NumberFormatException e) {
                    System.out.println("Warning: Invalid number format in line - " + line);
                    continue;
                }
            }
        } finally {
            // Always close the scanner
            scanner.close();
        }
        
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
        
        System.out.println("Calculating final grades...");
        
        // Process each student
        for (Student student : students) {
            String studentId = student.getId();
            GradeRecord gradeRecord = grades.get(studentId);
            
            if (gradeRecord == null) {
                System.out.println("Warning: No grade data found for student " + student.getName() + " (ID: " + studentId + ")");
                continue;
            }
            
            // Calculate final grade using weighted formula
            double finalScore = (gradeRecord.getAssignmentScore() * ASSIGNMENT_WEIGHT) +
                               (gradeRecord.getMidtermScore() * MIDTERM_WEIGHT) +
                               (gradeRecord.getFinalScore() * FINAL_WEIGHT);
            
            // Determine letter grade
            String letterGrade = getLetterGrade(finalScore);
            
            // Create StudentReport object
            StudentReport report = new StudentReport(student, gradeRecord, finalScore, letterGrade);
            reports.add(report);
        }
        
        return reports;
    }
    
    /**
     * Generates formatted reports and saves them to output files.
     * 
     * @param reports List of student reports to process
     */
    public static void generateReports(List<StudentReport> reports) {
        System.out.println("Generating reports...");
        
        try {
            // Generate class summary report
            generateClassSummary(reports);
            
            // Generate individual student reports
            generateIndividualReports(reports);
            
            // Generate grade distribution report
            generateGradeDistribution(reports);
            
        } catch (IOException e) {
            System.out.println("Error writing reports: " + e.getMessage());
        }
    }
    
    /**
     * Generates a class summary report with statistics.
     */
    private static void generateClassSummary(List<StudentReport> reports) throws IOException {
        File summaryFile = new File("class_summary.txt");
        PrintStream summaryOut = new PrintStream(summaryFile);
        
        try {
            // Calculate statistics
            int totalStudents = reports.size();
            double totalScore = 0;
            double highestScore = Double.MIN_VALUE;
            double lowestScore = Double.MAX_VALUE;
            String highestStudent = "";
            String lowestStudent = "";
            
            Map<String, Integer> gradeCounts = new HashMap<>();
            gradeCounts.put("A", 0);
            gradeCounts.put("B", 0);
            gradeCounts.put("C", 0);
            gradeCounts.put("D", 0);
            gradeCounts.put("F", 0);
            
            for (StudentReport report : reports) {
                double score = report.getFinalScore();
                totalScore += score;
                
                if (score > highestScore) {
                    highestScore = score;
                    highestStudent = report.getStudent().getName();
                }
                
                if (score < lowestScore) {
                    lowestScore = score;
                    lowestStudent = report.getStudent().getName();
                }
                
                String letterGrade = report.getLetterGrade();
                gradeCounts.put(letterGrade, gradeCounts.get(letterGrade) + 1);
            }
            
            double classAverage = totalStudents > 0 ? totalScore / totalStudents : 0;
            
            // Write summary report
            summaryOut.println("==========================================");
            summaryOut.println("CLASS SUMMARY REPORT");
            summaryOut.println("==========================================");
            summaryOut.printf("Total Students: %d%n", totalStudents);
            summaryOut.printf("Class Average: %.2f%n", classAverage);
            summaryOut.printf("Highest Score: %.2f (%s - %s)%n", 
                            highestScore, highestStudent, getLetterGrade(highestScore));
            summaryOut.printf("Lowest Score: %.2f (%s - %s)%n", 
                            lowestScore, lowestStudent, getLetterGrade(lowestScore));
            summaryOut.println();
            summaryOut.println("Grade Distribution:");
            summaryOut.printf("A: %d students (%.1f%%)%n", 
                            gradeCounts.get("A"), (double)gradeCounts.get("A")/totalStudents*100);
            summaryOut.printf("B: %d students (%.1f%%)%n", 
                            gradeCounts.get("B"), (double)gradeCounts.get("B")/totalStudents*100);
            summaryOut.printf("C: %d students (%.1f%%)%n", 
                            gradeCounts.get("C"), (double)gradeCounts.get("C")/totalStudents*100);
            summaryOut.printf("D: %d students (%.1f%%)%n", 
                            gradeCounts.get("D"), (double)gradeCounts.get("D")/totalStudents*100);
            summaryOut.printf("F: %d students (%.1f%%)%n", 
                            gradeCounts.get("F"), (double)gradeCounts.get("F")/totalStudents*100);
            
        } finally {
            summaryOut.close();
        }
    }
    
    /**
     * Generates individual student reports.
     */
    private static void generateIndividualReports(List<StudentReport> reports) throws IOException {
        for (StudentReport report : reports) {
            String filename = "student_" + report.getStudent().getId() + "_report.txt";
            File reportFile = new File(filename);
            PrintStream reportOut = new PrintStream(reportFile);
            
            try {
                Student student = report.getStudent();
                GradeRecord grades = report.getGrades();
                
                reportOut.println("STUDENT REPORT - " + student.getName() + " (ID: " + student.getId() + ")");
                reportOut.println("Email: " + student.getEmail());
                reportOut.printf("Assignment Score: %.1f%n", grades.getAssignmentScore());
                reportOut.printf("Midterm Score: %.1f%n", grades.getMidtermScore());
                reportOut.printf("Final Score: %.1f%n", grades.getFinalScore());
                reportOut.printf("Final Grade: %.2f (%s)%n", report.getFinalScore(), report.getLetterGrade());
                
            } finally {
                reportOut.close();
            }
        }
    }
    
    /**
     * Generates a grade distribution report.
     */
    private static void generateGradeDistribution(List<StudentReport> reports) throws IOException {
        File distributionFile = new File("grade_distribution.txt");
        PrintStream distributionOut = new PrintStream(distributionFile);
        
        try {
            // Count grades
            Map<String, Integer> gradeCounts = new HashMap<>();
            gradeCounts.put("A", 0);
            gradeCounts.put("B", 0);
            gradeCounts.put("C", 0);
            gradeCounts.put("D", 0);
            gradeCounts.put("F", 0);
            
            for (StudentReport report : reports) {
                String letterGrade = report.getLetterGrade();
                gradeCounts.put(letterGrade, gradeCounts.get(letterGrade) + 1);
            }
            
            int totalStudents = reports.size();
            
            // Write distribution report
            distributionOut.println("==========================================");
            distributionOut.println("GRADE DISTRIBUTION REPORT");
            distributionOut.println("==========================================");
            distributionOut.println("Letter Grade | Count | Percentage");
            distributionOut.println("-------------|-------|------------");
            distributionOut.printf("%-12s | %5d | %9.1f%%%n", "A", gradeCounts.get("A"), 
                                 (double)gradeCounts.get("A")/totalStudents*100);
            distributionOut.printf("%-12s | %5d | %9.1f%%%n", "B", gradeCounts.get("B"), 
                                 (double)gradeCounts.get("B")/totalStudents*100);
            distributionOut.printf("%-12s | %5d | %9.1f%%%n", "C", gradeCounts.get("C"), 
                                 (double)gradeCounts.get("C")/totalStudents*100);
            distributionOut.printf("%-12s | %5d | %9.1f%%%n", "D", gradeCounts.get("D"), 
                                 (double)gradeCounts.get("D")/totalStudents*100);
            distributionOut.printf("%-12s | %5d | %9.1f%%%n", "F", gradeCounts.get("F"), 
                                 (double)gradeCounts.get("F")/totalStudents*100);
            distributionOut.println("-------------|-------|------------");
            distributionOut.printf("%-12s | %5d | %9.1f%%%n", "Total", totalStudents, 100.0);
            
        } finally {
            distributionOut.close();
        }
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