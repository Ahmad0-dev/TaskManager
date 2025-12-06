package studenttaskmanager.interfaces;

import studenttaskmanager.models.Submission;
import java.util.List;

public interface ISubmissionManager {
    void submitTask(Submission submission);
    List<Submission> getSubmissionsByStudent(int studentId);
    void gradeSubmission(int studentId, int taskId, double grade);
}
