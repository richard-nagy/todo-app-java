import static storage.TaskFileManager.loadTasksFromFile;
import static ui.UI.*;

void main() {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> tasks = new ArrayList<>();
    loadTasksFromFile("tasks.txt", tasks);
    boolean exit = false;

    while (!exit) {
        int choice = displayMenu(scanner);
        if (choice == 0) exit = true;

        else if (choice == -1) {
            IO.println("Unknown option, try again.");
            continue;
        }

        switch (choice) {
            case 1:
                addTask(tasks, scanner);
                break;
            case 2:
                getTasks(tasks);
                break;
            case 3:
                break;
            default:
                IO.println("Unknown option, try again.");
        }
    }

    IO.println("Goodbye!");
}
