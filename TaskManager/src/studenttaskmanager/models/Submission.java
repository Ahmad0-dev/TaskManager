package studenttaskmanager.models;

import java.time.LocalDate;

public class Submission {
    private int studentId;
    private int taskId;
    private LocalDate submissionDate;
    private double grade;

    public Submission(int studentId, int taskId, LocalDate submissionDate) {
        // TODO: Implement constructor
    }

    public boolean isLate(LocalDate dueDate) {
        return submissionDate.isAfter(dueDate);
    }

    public void setGrade(double grade) { this.grade = grade; }

    // TODO: Add getters, setters, and toString method
}