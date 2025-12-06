package studenttaskmanager.models;

import java.time.LocalDate;

public class Submission {
    private int studentId;
    private int taskId;
    private LocalDate submissionDate;
    private double grade;

    // Constructor
    public Submission(int studentId, int taskId, LocalDate submissionDate) {
        this.studentId = studentId;
        this.taskId = taskId;
        this.submissionDate = submissionDate;
        this.grade = 0.0; // default initial grade
    }

    // Getters
    public int getStudentId() {
        return studentId;
    }

    public int getTaskId() {
        return taskId;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public double getGrade() {
        return grade;
    }

    // Setters
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    // Check if submission is late
    public boolean isLate(LocalDate dueDate) {
        return submissionDate.isAfter(dueDate);
    }

    // toString method
    @Override
    public String toString() {
        return "Submission{" +
                "studentId=" + studentId +
                ", taskId=" + taskId +
                ", submissionDate=" + submissionDate +
                ", grade=" + grade +
                '}';
    }
}
