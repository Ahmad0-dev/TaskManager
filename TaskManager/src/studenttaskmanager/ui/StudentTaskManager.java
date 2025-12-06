package studenttaskmanager.ui;

import studenttaskmanager.interfaces.IStudentManager;
import studenttaskmanager.interfaces.ITaskManager;
import studenttaskmanager.interfaces.ISubmissionManager;
import studenttaskmanager.interfaces.IReportGenerator;
import studenttaskmanager.managers.StudentManager;
import studenttaskmanager.managers.TaskManager;
import studenttaskmanager.managers.SubmissionManager;
import studenttaskmanager.managers.ReportGenerator;

public class StudentTaskManager {

    public static void main(String[] args) {
        IStudentManager studentManager = new StudentManager();
        ITaskManager taskManager = new TaskManager();
        ISubmissionManager submissionManager = new SubmissionManager();
        IReportGenerator reportGenerator = new ReportGenerator(submissionManager, taskManager);

        Menu menu = new Menu(studentManager, taskManager, submissionManager, reportGenerator);
        menu.start();
    }
}
