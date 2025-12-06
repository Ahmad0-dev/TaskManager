package studenttaskmanager.models;

import java.time.LocalDate;

public class Submission {
    private int studentId;
    private int taskId;
    private LocalDate submissionDate;
    private double grade;
    //constructor created
    public Submission(int studentId, int taskId, LocalDate submissionDate) {

        public Submission(int studentId, int taskId, LocalDate submissionDate) {
    this.studentId = studentId;
    this.taskId = taskId;
    this.submissionDate = submissionDate;
    this.grade = 0.0; // default initial grade
}

    }

    public boolean isLate(LocalDate dueDate) {
        return submissionDate.isAfter(dueDate);
    }

    public void setGrade(double grade) { this.grade = grade; }

    // TODO: Add getters, setters, and toString method
}