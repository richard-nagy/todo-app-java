package ui;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
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
}
