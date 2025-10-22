static public int getIntFromUser(Scanner scanner) {
    String input = scanner.nextLine();

    try {
        return Integer.parseInt(input);
    } catch (NumberFormatException e) {
        IO.println("Invalid input, try again.");
        return -1;
    }
}

static public int displayMenu(Scanner scanner) {
    IO.println("\nMenu:");
    IO.println("[0] Exit");
    IO.println("[1] Add task");
    IO.println("[2] View tasks");

    IO.print("Enter choice: ");
    return getIntFromUser(scanner);
}

static public void addTask(ArrayList<String> tasks, Scanner scanner) {
    IO.print("Enter task: ");
    tasks.add(scanner.nextLine());
}

static public void getTasks(ArrayList<String> tasks) {
    IO.println("Tasks:");
    for (String task : tasks) IO.println("- " + task);
}

void main() {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> tasks = new ArrayList<>();
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
            default:
                IO.println("Unknown option, try again.");
        }
    }

    IO.println("Goodbye!");
}
