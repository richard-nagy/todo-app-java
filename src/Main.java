void main() {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> tasks = new ArrayList<>();
    boolean exit = false;

    while (!exit) {
        IO.println("\nMenu:");
        IO.println("[0] Exit");
        IO.println("[1] Add task");
        IO.println("[2] View tasks");

        IO.print("Enter choice: ");
        String input = scanner.nextLine();
        int choice;

        try {
            choice = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            IO.println("Invalid input, try again.");
            continue;
        }

        if (choice == 0) exit = true;

        switch (choice) {
            case 1:
                IO.print("Enter task: ");
                tasks.add(scanner.nextLine());
                break;
            case 2:
                IO.println("Tasks:");
                for (String task : tasks) IO.println("- " + task);
                break;
            default:
                IO.println("Unknown option, try again.");
        }
    }

    IO.println("Goodbye!");
}
