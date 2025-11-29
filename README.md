<!-- ## 📌 Clean Code To-Do App (Java CLI)

This is a simple Command-Line Interface (CLI) To-Do application built in Java, demonstrating a basic object-oriented design and clean code principles.

---

### 🚀 Features

The application allows users to manage their daily tasks with the following features:

- **Add** new tasks.
- **Mark** existing tasks as completed.
- **View** all tasks with their status.
- **View** only pending (incomplete) tasks.
- **Exit** the application gracefully.

---

### 💻 Getting Started

#### Prerequisites

- **Java Development Kit (JDK) 11 or higher** installed on your system.
- A Java IDE (like IntelliJ IDEA, Eclipse) or a text editor with a terminal.

#### Running the Application

1.  **Clone the Repository:**
    ```bash
    git clone https://github.com/abdelkderboukert/ToDO_Java.git
    cd ToDO_Java
    ```
2.  **Compile the Code:**
    If you're using a standard Java project structure (like Maven or Gradle), your IDE will handle this.
    For a manual compile from the source directory (`todoapp/` contains all `.java` files):
    ```bash
    # Assuming you are in the directory containing the 'todoapp' folder
    javac todoapp/*.java
    ```
3.  **Run the Main Class:**
    The application's entry point is the `TodoCLI` class.
    ```bash
    java todoapp.TodoCLI
    ```

---

### 📝 Usage

Once the application is running, you'll be greeted by the main menu.

#### Main Menu

The application continuously loops, prompting you to select a command.

| Command  | Description                               |
| :------: | :---------------------------------------- |
|  **1**   | Add a new task to the list.               |
|  **2**   | Mark a task as completed using its index. |
|  **3**   | View all tasks (completed and pending).   |
|  **4**   | View only the pending tasks.              |
| **exit** | Shut down the application.                |

<br>

#### 1\. Add a New Task

Enter `1` and press **Enter**, then input the description for your new task.

#### 3\. View All Tasks

Entering `3` will display all tasks currently in the system, along with their creation date and status (`[DONE]` or `[PENDING]`). Note the **index** (the number on the left, starting from 0) as this is used to complete a task.

#### 2\. Mark Task as Completed

Enter `2` and press **Enter**. The application will first list all tasks (similar to option `3`) and then prompt you for the **index** of the task you want to complete.

- **Example:** To mark the first task as done, you would enter `0`.

---

### 🛠️ Project Structure

The project is divided into three core classes, following the **Single Responsibility Principle**:

| Class                  | Responsibility                                                                                                                  |
| :--------------------- | :------------------------------------------------------------------------------------------------------------------------------ |
| **`Task.java`**        | Represents a single to-do item. Handles its own state (description, completion status, timestamp).                              |
| **`TaskService.java`** | Manages the collection of `Task` objects (the `taskList`). Contains business logic for adding, completing, and filtering tasks. |
| **`TodoCLI.java`**     | The main entry point (`main` method). Handles all User Interface (UI) and input/output logic via the command line.              |

---

### 💡 Clean Code & OOP Principles

This project was developed with a focus on:

- **Encapsulation:** The `Task` object protects its data using `private` fields and provides controlled access via `public` getter methods (`getTaskDescription()`, `isCompleted()`).
- **Separation of Concerns:** The application logic is clearly separated: `TodoCLI` handles I/O, and `TaskService` handles data management.
- **Intention-Revealing Names:** Variables and methods have names that clearly indicate their purpose (e.g., `startApplicationLoop`, `executeUserCommand`, `isCompleted`).
- **Immutability:** The `taskDescription` and `creationTimestamp` fields in `Task` are marked as `final` for thread safety and stability. -->

## 📌 Clean Code To-Do App (Java CLI)

This is a simple Command-Line Interface (CLI) To-Do application built in Java, demonstrating a basic object-oriented design and clean code principles.

---

### 🚀 Features

The application allows users to manage their daily tasks with the following features:

- **Add** new tasks.
- **Mark** existing tasks as completed.
- **View** all tasks with their status.
- **View** only pending (incomplete) tasks.
- **Exit** the application gracefully.

---

### 💻 Getting Started

#### Prerequisites

- **Java Development Kit (JDK) 11 or higher** installed on your system.
- A Java IDE (like IntelliJ IDEA, Eclipse) or a text editor with a terminal.

#### Running the Application

1.  **Clone the Repository:**
    ```bash
    git clone https://github.com/abdelkderboukert/ToDO_Java.git
    cd ToDo_Java
    ```
2.  **Compile the Code:**
    If you're using a standard Java project structure (like Maven or Gradle), your IDE will handle this.
    For a manual compile from the source directory (`todoapp/` contains all `.java` files):
    ```bash
    # Assuming you are in the directory containing the 'todoapp' folder
    javac todoapp/*.java
    ```
3.  **Run the Main Class:**
    The application's entry point is the `TodoCLI` class.
    ```bash
    java todoapp.TodoCLI
    ```

---

### 📝 Usage

Once the application is running, you'll be greeted by the main menu.

#### Main Menu

The application continuously loops, prompting you to select a command.

| Command  | Description                               |
| :------: | :---------------------------------------- |
|  **1**   | Add a new task to the list.               |
|  **2**   | Mark a task as completed using its index. |
|  **3**   | View all tasks (completed and pending).   |
|  **4**   | View only the pending tasks.              |
| **exit** | Shut down the application.                |

<br>

#### 1\. Add a New Task

Enter `1` and press **Enter**, then input the description for your new task.

#### 3\. View All Tasks

Entering `3` will display all tasks currently in the system, along with their creation date and status (`[DONE]` or `[PENDING]`). Note the **index** (the number on the left, starting from 0) as this is used to complete a task.

#### 2\. Mark Task as Completed

Enter `2` and press **Enter**. The application will first list all tasks (similar to option `3`) and then prompt you for the **index** of the task you want to complete.

- **Example:** To mark the first task as done, you would enter `0`.

---

### 🛠️ Project Structure

The project is divided into three core classes, following the **Single Responsibility Principle**:

| Class                  | Responsibility                                                                                                                  |
| :--------------------- | :------------------------------------------------------------------------------------------------------------------------------ |
| **`Task.java`**        | Represents a single to-do item. Handles its own state (description, completion status, timestamp).                              |
| **`TaskService.java`** | Manages the collection of `Task` objects (the `taskList`). Contains business logic for adding, completing, and filtering tasks. |
| **`TodoCLI.java`**     | The main entry point (`main` method). Handles all User Interface (UI) and input/output logic via the command line.              |

### Class Implementations

#### `Task.java`

This class represents the data model for a single to-do item.

```java
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
```

#### `TaskService.java`

This class handles all business logic and persistence (in-memory list) for managing tasks.

```java
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
```

#### `TodoCLI.java`

This is the main application class, managing user input and the application loop.

```java
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
```

---

### 💡 Clean Code & OOP Principles

This project was developed with a focus on:

- **Encapsulation:** The `Task` object protects its data using `private` fields and provides controlled access via `public` getter methods (`getTaskDescription()`, `isCompleted()`).
- **Separation of Concerns:** The application logic is clearly separated: `TodoCLI` handles I/O, and `TaskService` handles data management.
- **Intention-Revealing Names:** Variables and methods have names that clearly indicate their purpose (e.g., `startApplicationLoop`, `executeUserCommand`, `isCompleted`).
- **Immutability:** The `taskDescription` and `creationTimestamp` fields in `Task` are marked as `final` for thread safety and stability.

✨ AI-Assisted Documentation Notice
This README.md file, including its structure, descriptions, and analysis of the code, was generated with the help of an AI assistant (Gemini).
