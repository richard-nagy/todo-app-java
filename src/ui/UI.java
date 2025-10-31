package ui;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    static public int getIntFromUser(Scanner scanner, int maxNumber) {
        String input = scanner.nextLine();

        try {
            int inputNumber = Integer.parseInt(input);

            if (inputNumber < 0 || inputNumber > maxNumber) {
                throw new NumberFormatException("Invalid Number");
            }

            return inputNumber;
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
        IO.println("[3] Delete task");

        IO.print("\nEnter choice: ");
        return getIntFromUser(scanner, 3);
    }

    static public void addTask(ArrayList<String> tasks, Scanner scanner) {
        IO.print("Enter task: ");
        tasks.add(scanner.nextLine());
    }

    static public void getTasks(ArrayList<String> tasks) {
        IO.println("\nTasks:");
        for (String task : tasks) IO.println("- " + task);
    }

    static public void deleteTask(ArrayList<String> tasks, Scanner scanner) {
        IO.println("\nTasks:");

        for (int i = 0; i < tasks.size(); i++) {
            String item = tasks.get(i);
            IO.println("[" + (i + 1) + "]: " + item);
        }

        IO.println("\nEnter number of task to delete:");

        boolean exit = false;

        while (!exit) {
            int removeIndex = getIntFromUser(scanner, tasks.size()) - 1;

            if (removeIndex > -1 && removeIndex < tasks.size()) {
                tasks.remove(removeIndex);
                exit = true;
            } else {
                IO.println("Invalid input, try again.");
            }
        }
    }
}
