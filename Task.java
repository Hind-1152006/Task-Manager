// File: Task.java
public class Task {
    private int id;
    private String description;
    private boolean isDone;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.isDone = false;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markAsDone() {
        isDone = true;
    }

    @Override
    public String toString() {
        return id + ". [" + (isDone ? "X" : " ") + "] " + description;
    }
} 

// File: TaskManager.java
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public void addTask(String description) {
        Task task = new Task(nextId++, description);
        tasks.add(task);
        System.out.println("Task added.");
    }

    public void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void markTaskDone(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.markAsDone();
                System.out.println("Task marked as done.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public void deleteTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
        System.out.println("Task deleted (if it existed).");
    }
}

// File: Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true) {
            System.out.println("\n1. Add Task\n2. Show Tasks\n3. Mark Task as Done\n4. Delete Task\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String desc = scanner.nextLine();
                    taskManager.addTask(desc);
                    break;
                case 2:
                    taskManager.showTasks();
                    break;
                case 3:
                    System.out.print("Enter task ID to mark as done: ");
                    int doneId = scanner.nextInt();
                    taskManager.markTaskDone(doneId);
                    break;
                case 4:
                    System.out.print("Enter task ID to delete: ");
                    int delId = scanner.nextInt();
                    taskManager.deleteTask(delId);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
