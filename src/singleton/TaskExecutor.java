package singleton;

import task.*;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum TaskExecutor {

    //Singleton
    INSTANCE;


    // path to the task package
    public static final String TASKS_PACKAGE = "task.";

    public String run(String parameters) {
        String taskName, input = "";
        //should be taskname&input 
        List<String> list = Arrays.stream(parameters.split("&")).collect(Collectors.toList());

        long start = System.currentTimeMillis();
        if (list.size() != 2) {
            taskName = "TaskIncorrectParams";
        } else {
            taskName = list.get(0);
            input = list.get(1);
        }
        //create task handle no found tasks here
        Task task = createTask(taskName);
        task.setInput(input);
        task.execute();

        TasksList.INSTANCE.add(task);
        long end = System.currentTimeMillis();
        String executedTime = new DecimalFormat("#0.00").format((end - start) / 1000d) + "s";
        task.setExecutedTime(executedTime);

        return task.getResult();
    }
    //create task
    private Task createTask(String className) {
        Task task = null;
        try {
            // tasks here should have the exact same name as defined in the task package
            task = (Task)Class.forName(TASKS_PACKAGE + className).newInstance();
        } catch (Exception e) {
            try {
                task = (Task)Class.forName(TASKS_PACKAGE + "TaskNotFound").newInstance();
            } catch (Exception e1) {
                // i dont think this is ever executed unless the className provided contains some malformed shit
                e1.printStackTrace();
            }
        }
        return task;
    }
}
