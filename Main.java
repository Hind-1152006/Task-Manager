
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
