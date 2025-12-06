package studenttaskmanager.managers;

import studenttaskmanager.interfaces.IReportGenerator;
import studenttaskmanager.interfaces.ISubmissionManager;
import studenttaskmanager.interfaces.ITaskManager;
import studenttaskmanager.models.Submission;
import studenttaskmanager.models.Task;

import java.util.List;

public class ReportGenerator implements IReportGenerator {
    private final ISubmissionManager submissionManager;
    private final ITaskManager taskManager;

    public ReportGenerator(ISubmissionManager submissionManager, ITaskManager taskManager) {
        this.submissionManager = submissionManager;
        this.taskManager = taskManager;
    }

    @Override
    public void generateStudentReport(int studentId) {
        List<Submission> submissions = submissionManager.getSubmissionsByStudent(studentId);
        
        System.out.println("=".repeat(60));
        System.out.println("Student Report - Student ID: " + studentId);
        System.out.println("=".repeat(60));
        
        if (submissions.isEmpty()) {
            System.out.println("No submissions found for this student.");
            return;
        }
        
        System.out.printf("%-15s %-30s %-15s%n", "Task ID", "Task Title", "Grade");
        System.out.println("-".repeat(60));
        
        for (Submission submission : submissions) {
            Task task = taskManager.getTaskById(submission.getTaskId());
            if (task != null) {
                System.out.printf("%-15d %-30s %-15.2f%n", 
                    task.getId(), 
                    task.getTitle(), 
                    submission.getGrade());
            }
        }
        
        System.out.println("=".repeat(60));
    }
}
