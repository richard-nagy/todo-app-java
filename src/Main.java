import data.Task;

import static storage.TaskFileManager.loadTasksFromFile;
import static storage.TaskFileManager.writeFile;
import static ui.UI.*;

void main() {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Task> tasks = new ArrayList<>();
    loadTasksFromFile("tasks.txt", tasks);
    boolean exit = false;

    IO.println("\nFound tasks:");

    while (!exit) {
        int choice = displayMenu(scanner);
        if (choice == -1) {
            IO.println("Unknown option, try again.");
            continue;
        }

        switch (choice) {
            case 0:
                exit = true;
                break;
            case 1:
                addTask(tasks, scanner);
                break;
            case 2:
                printTasks(tasks);
                break;
            case 3:
                deleteTask(tasks, scanner);
                break;
            case 4:
                toggleTask(tasks, scanner);
                break;
            case 5:
                searchTasks(tasks, scanner);
                break;
            case 6:
                filterTasks(tasks, scanner);
                break;
            default:
                IO.println("Unknown option, try again.");
        }
    }

    writeFile("tasks.txt", tasks.stream().map(Task::getString).collect(Collectors.toCollection(ArrayList::new)));
    IO.println("Goodbye!");
}
