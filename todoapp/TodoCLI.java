package todoapp;
// import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TodoCLI {
    private final TaskService taskService;
    // Use an intention-revealing name for the input reader.
    private final Scanner scanner; 

    public TodoCLI() {
        this.taskService = new TaskService();
        this.scanner = new Scanner(System.in); 
    }

    public void startApplicationLoop() {
        System.out.println("Welcome to the Clean Code To-Do App!");

        boolean isRunning = true; 
        
        while (isRunning) {
            displayMenu();
            String userChoice = scanner.nextLine().trim(); 

            isRunning = executeUserCommand(userChoice); 
        }
        System.out.println("Application shutdown. Goodbye!");
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1: Add a new task");
        System.out.println("2: Mark task as completed");
        System.out.println("3: View all tasks");
        System.out.println("4: View pending tasks");
        System.out.println("exit: Exit the application");
        System.out.print("Enter your choice: ");
    }

    private boolean executeUserCommand(String choice) {
        switch (choice.toLowerCase()) {
            case "1":
                addNewTask();
                break;
            case "2":
                completeTask();
                break;
            case "3":
                taskService.printAllTasks();
                break;
            case "4":
                printPendingTasks();
                break;
            case "exit":
                return false;
            default:
                System.out.println("Invalid command. Please try again.");
        }
        return true;
    }

    private void addNewTask() {
        System.out.print("Enter task description: ");
        String taskDescriptionInput = scanner.nextLine().trim(); 
        if (!taskDescriptionInput.isEmpty()) {
            taskService.addTask(taskDescriptionInput);
        } else {
            System.out.println("Task description cannot be empty. Task not added.");
        }
    }

    private void completeTask() {
        taskService.printAllTasks();
        
        if (taskService.getTaskCount() == 0) {
            return;
        }

        System.out.print("Enter the **index** of the task to complete: ");
        try {
            int taskIndexToComplete = Integer.parseInt(scanner.nextLine().trim());
            taskService.markAsCompleted(taskIndexToComplete);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid index number.");
        }
    }

    private void printPendingTasks() {
        List<Task> pendingTasks = taskService.getPendingTasks();
        
        System.out.println("\n--- PENDING TASKS ---");
        if (pendingTasks.isEmpty()) {
            System.out.println("All tasks are completed! Great job.");
        } else {
            for (Task pendingTask : pendingTasks) { 
                System.out.println(pendingTask);
            }
        }
        System.out.println("---------------------\n");
    }

    public static void main(String[] args) {
        TodoCLI application = new TodoCLI();
        application.startApplicationLoop();
    }
}