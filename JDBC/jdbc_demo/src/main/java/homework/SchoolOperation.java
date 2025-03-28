package homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SchoolOperation {

    String URL = "jdbc:postgresql://localhost:5432/demo";
    String USER = "postgres";
    String PASSWORD = "pankaj123";
    Scanner scanner = new Scanner(System.in); // Scanner object for user input

    public static void main(String[] args) {
        SchoolOperation schoolOperation = new SchoolOperation();
        schoolOperation.runMenu(); // Start the menu-driven program
    }

    // Method to display the menu and handle user input
    public void runMenu() {
        while (true) {
            System.out.println("\n--- School Management System ---");
            System.out.println("1. Create Student");
            System.out.println("2. Read All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    createStudentFromInput();
                    break;
                case 2:
                    readStudents();
                    break;
                case 3:
                    updateStudentFromInput();
                    break;
                case 4:
                    deleteStudentFromInput();
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to take input from the user and create a student
    public void createStudentFromInput() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student fees: ");
        double fees = scanner.nextDouble();

        System.out.print("Enter student phone number: ");
        long phn = scanner.nextLong();
        scanner.nextLine(); // Consume the newline character

        createStudent(name, fees, phn);
    }

    // Method to create a new student
    public void createStudent(String name, double fees, Long phn) {
        String sql = "INSERT INTO student (name, fees, phn) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setDouble(2, fees);
            pstmt.setLong(3, phn);
            pstmt.executeUpdate();
            System.out.println("Student created successfully!");

        } catch (SQLException e) {
            System.out.println("Error creating student: " + e.getMessage());
        }
    }

    // Method to read all students
    public void readStudents() {
        String sql = "SELECT * FROM student";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("\nList of Students:");
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                double fees = rs.getDouble("fees");
                long phn = rs.getLong("phn");

                System.out.println("ID: " + id + ", Name: " + name + ", Fees: " + fees + ", Phone: " + phn);
            }

        } catch (SQLException e) {
            System.out.println("Error reading students: " + e.getMessage());
        }
    }

    // Method to take input from the user and update a student
    public void updateStudentFromInput() {
        System.out.print("Enter student ID to update: ");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new fees: ");
        double fees = scanner.nextDouble();

        System.out.print("Enter new phone number: ");
        long phn = scanner.nextLong();
        scanner.nextLine(); // Consume the newline character

        updateStudent(id, name, fees, phn);
    }

    // Method to update a student's details
    public void updateStudent(long id, String name, double fees, Long phn) {
        String sql = "UPDATE student SET name = ?, fees = ?, phn = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setDouble(2, fees);
            pstmt.setLong(3, phn);
            pstmt.setLong(4, id);

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("No student found with ID: " + id);
            }

        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    // Method to take input from the user and delete a student
    public void deleteStudentFromInput() {
        System.out.print("Enter student ID to delete: ");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume the newline character

        deleteStudent(id);
    }

    // Method to delete a student
    public void deleteStudent(long id) {
        String sql = "DELETE FROM student WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("No student found with ID: " + id);
            }

        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }
    
}