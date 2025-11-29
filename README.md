That's a great idea\! Clear documentation with visual examples is essential for a GitHub `README`.

Here's a well-structured `README.md` content suggestion for your To-Do App, focusing on clarity, structure, and providing visual aids where necessary.

---

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
    git clone [Your Repository URL]
    cd todo-app-repository-name
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
- **Immutability:** The `taskDescription` and `creationTimestamp` fields in `Task` are marked as `final` for thread safety and stability.
