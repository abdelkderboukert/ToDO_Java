package todoapp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class TaskService {
    private final List<Task> taskList = new ArrayList<>(); 

    public void addTask(String description) {
        Task newTask = new Task(description);
        taskList.add(newTask);
        System.out.println("Added: " + description);
    }

    public void markAsCompleted(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < taskList.size()) {
            Task taskToComplete = taskList.get(taskIndex);
            taskToComplete.markAsCompleted();
            System.out.println("Completed: " + taskToComplete.getTaskDescription());
        } else {
            System.out.println("Error: Invalid task index."); 
        }
    }

    public int getTaskCount() {
        return taskList.size();
    }

    public List<Task> getPendingTasks() {
        return taskList.stream()
                .filter(task -> !task.isCompleted()) 
                .collect(Collectors.toList());
    }

    public void printAllTasks() {
        if (taskList.isEmpty()) {
            System.out.println("\nThe To-Do list is empty!");
            return;
        }
        System.out.println("\n--- ALL TASKS ---");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println(i + ". " + taskList.get(i));
        }
        System.out.println("-----------------\n");
    }
}