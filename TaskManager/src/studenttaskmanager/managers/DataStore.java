package studenttaskmanager.managers;

import studenttaskmanager.models.Student;
import studenttaskmanager.models.Task;
import studenttaskmanager.models.Submission;
import java.util.ArrayList;
import java.util.List;

public class DataStore {
    public List<Student> students = new ArrayList<>();
    public List<Task> tasks = new ArrayList<>();
    public List<Submission> submissions = new ArrayList<>();
}
