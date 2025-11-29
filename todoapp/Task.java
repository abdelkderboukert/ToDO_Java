package todoapp;
import java.time.LocalDateTime;

public class Task {
    private final String taskDescription; 
    
    private boolean isCompleted;
    
    private final LocalDateTime creationTimestamp; 

    public Task(String taskDescription) {
        this.taskDescription = taskDescription;
        this.isCompleted = false;
        this.creationTimestamp = LocalDateTime.now();
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public LocalDateTime getCreationTimestamp() {
        return creationTimestamp;
    }

    @Override
    public String toString() {
        String status = isCompleted ? "[DONE]" : "[PENDING]";
        return status + " " + taskDescription + " (Created: " + creationTimestamp.toLocalDate() + ")";
    }
}