package studenttaskmanager.managers;

import studenttaskmanager.interfaces.ITaskManager;
import studenttaskmanager.models.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskManager implements ITaskManager {
    private List<Task> tasks = new ArrayList<>();

    @Override
    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null; // If not found
    }

    @Override
    public List<Task> listAllTasks() {
        return new ArrayList<>(tasks); // Return a copy to protect the original list
    }
}

