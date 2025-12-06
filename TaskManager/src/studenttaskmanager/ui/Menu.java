package studenttaskmanager.ui;

import studenttaskmanager.interfaces.IStudentManager;
import studenttaskmanager.interfaces.ITaskManager;
import studenttaskmanager.interfaces.ISubmissionManager;
import studenttaskmanager.interfaces.IReportGenerator;
import studenttaskmanager.models.Student;
import studenttaskmanager.models.Task;
import studenttaskmanager.models.Submission;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    private final IStudentManager studentManager;
    private final ITaskManager taskManager;
    private final ISubmissionManager submissionManager;
    private final IReportGenerator reportGenerator;
    private final Scanner scanner = new Scanner(System.in);

    public Menu(IStudentManager sm, ITaskManager tm, ISubmissionManager subm, IReportGenerator rg) {
        this.studentManager = sm;
        this.taskManager = tm;
        this.submissionManager = subm;
        this.reportGenerator = rg;
    }

    public void start() {
        int choice = -1;
        while (choice != 0) {
            printMenu();
            try {
                System.out.print("Choose: ");
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
                continue;
            }
            switch (choice) {
                case 1: addStudent(); break;
                case 2: listStudents(); break;
                case 3: addTask(); break;
                case 4: listTasks(); break;
                case 5: submitTask(); break;
                case 6: gradeSubmission(); break;
                case 7: generateReport(); break;
                case 0: System.out.println("Goodbye!"); break;
                default: System.out.println("Unknown choice.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n--- Student Task Manager ---");
        System.out.println("1. Add Student");
        System.out.println("2. List Students");
        System.out.println("3. Add Task");
        System.out.println("4. List Tasks");
        System.out.println("5. Submit Task");
        System.out.println("6. Grade Submission");
        System.out.println("7. Generate Student Report");
        System.out.println("0. Exit");
    }

    private void addStudent() {
        try {
            System.out.print("Student ID: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Name: ");
            String name = scanner.nextLine().trim();
            System.out.print("Email: ");
            String email = scanner.nextLine().trim();
            studentManager.addStudent(new Student(id, name, email));
            System.out.println("Student added.");
        } catch (Exception e) {
            System.out.println("Failed to add student: " + e.getMessage());
        }
    }

    private void listStudents() {
        System.out.println("\nStudents:");
        studentManager.listAllStudents().forEach(System.out::println);
    }

    private void addTask() {
        try {
            System.out.print("Task ID: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Title: ");
            String title = scanner.nextLine().trim();
            System.out.print("Description: ");
            String desc = scanner.nextLine().trim();
            System.out.print("Due date (YYYY-MM-DD): ");
            java.time.LocalDate due = java.time.LocalDate.parse(scanner.nextLine().trim());
            taskManager.addTask(new Task(id, title, desc, due));
            System.out.println("Task added.");
        } catch (Exception e) {
            System.out.println("Failed to add task: " + e.getMessage());
        }
    }

    private void listTasks() {
        System.out.println("\nTasks:");
        taskManager.listAllTasks().forEach(System.out::println);
    }

    private void submitTask() {
        try {
            System.out.print("Student ID: ");
            int studentId = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Task ID: ");
            int taskId = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Submission date (YYYY-MM-DD): ");
            LocalDate date = LocalDate.parse(scanner.nextLine().trim());
            submissionManager.submitTask(new Submission(studentId, taskId, date));
            System.out.println("Submission recorded.");
        } catch (Exception e) {
            System.out.println("Failed to submit task: " + e.getMessage());
        }
    }

    private void gradeSubmission() {
        try {
            System.out.print("Student ID: ");
            int studentId = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Task ID: ");
            int taskId = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Grade (0-100): ");
            double grade = Double.parseDouble(scanner.nextLine().trim());
            submissionManager.gradeSubmission(studentId, taskId, grade);
            System.out.println("Grade saved.");
        } catch (Exception e) {
            System.out.println("Failed to grade submission: " + e.getMessage());
        }
    }

    private void generateReport() {
        try {
            System.out.print("Student ID for report: ");
            int studentId = Integer.parseInt(scanner.nextLine().trim());
            reportGenerator.generateStudentReport(studentId);
        } catch (Exception e) {
            System.out.println("Failed to generate report: " + e.getMessage());
        }
    }
}
