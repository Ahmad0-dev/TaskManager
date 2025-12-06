package studenttaskmanager.interfaces;

import studenttaskmanager.models.Task;
import java.util.List;

public interface ITaskManager {
    void addTask(Task task);
    Task findTaskById(int id);
    List<Task> listAllTasks();
}
