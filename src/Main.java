import data.Task;

import static storage.TaskFileManager.loadTasksFromFile;
import static storage.TaskFileManager.writeFile;
import static ui.UI.*;

void main() {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Task> tasks = new ArrayList<>();
    loadTasksFromFile("tasks.txt", tasks);
    ArrayList<Task> filteredTasks = tasks;
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
                addTask(filteredTasks, scanner);
                break;
            case 2:
                printTasks(filteredTasks);
                break;
            case 3:
                deleteTask(filteredTasks, scanner);
                break;
            case 4:
                toggleTask(filteredTasks, scanner);
                break;
            case 5:
                String filterText = searchTasks(scanner);
                filteredTasks = tasks.stream().filter(t -> (t.getDescription()).contains(filterText)).collect(Collectors.toCollection(ArrayList::new));
                break;
            default:
                IO.println("Unknown option, try again.");
        }
    }

    writeFile("tasks.txt", tasks.stream().map(Task::getString).collect(Collectors.toCollection(ArrayList::new)));
    IO.println("Goodbye!");
}
