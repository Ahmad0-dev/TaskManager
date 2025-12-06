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

    // TODO: Implement generateStudentReport that prints tasks and grades per student
}
