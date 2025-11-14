package singleton;

import task.Task;

import java.util.ArrayList;
import java.util.List;

public enum TasksList {

    //Singleton
    INSTANCE;

    private List<Task> tasks;
    //initiate the array
    TasksList() {
        tasks = new ArrayList<>();
    }
    //add task
    public void add(Task task) {
        tasks.add(task);
    }
    //list tasks
    public String list() {
        StringBuilder stringBuilder = new StringBuilder();
        tasks.forEach(task -> stringBuilder.append(task)); // i think here task should implement toString
        return stringBuilder.toString();
    }
}
