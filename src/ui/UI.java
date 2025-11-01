package ui;

import data.Task;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

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
        ArrayList<String> options = new ArrayList<>();
        options.add("(0) Exit");
        options.add("(1) Add task");
        options.add("(2) View tasks");
        options.add("(3) Delete task");
        options.add("(4) Toggle task");
        options.add("(5) Search tasks");
        options.add("(6) Filter tasks");

        IO.println("\nMenu:");
        for (String option : options) {
            IO.println(option);
        }

        IO.print("\nEnter choice: ");
        return getIntFromUser(scanner, options.size());
    }

    static public void addTask(ArrayList<Task> tasks, Scanner scanner) {
        IO.print("Enter task: ");
        tasks.add(new Task(scanner.nextLine()));
    }

    static public void printTasks(ArrayList<Task> tasks) {
        IO.println("\nTasks:");

        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            IO.println("(" + (i + 1) + ") " + task.getString());
        }
    }

    static public void deleteTask(ArrayList<Task> tasks, Scanner scanner) {
        printTasks(tasks);

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

    static public void toggleTask(ArrayList<Task> tasks, Scanner scanner) {
        printTasks(tasks);

        IO.println("\nEnter number of task to toggle:");

        boolean exit = false;

        while (!exit) {
            int toggleIndex = getIntFromUser(scanner, tasks.size()) - 1;

            if (toggleIndex > -1 && toggleIndex < tasks.size()) {
                tasks.get(toggleIndex).toggleDone();
                exit = true;
            } else {
                IO.println("Invalid input, try again.");
            }
        }
    }

    static public void printFilteredTasks(ArrayList<Task> tasks, Predicate<Task> filter) {
        tasks.stream().filter(filter).forEach(t -> IO.println(t.getString()));
    }

    static public void searchTasks(ArrayList<Task> tasks, Scanner scanner) {
        String filterText = scanner.nextLine();
        IO.println("\nFound tasks:");
        printFilteredTasks(tasks, t -> t.getDescription().toLowerCase().contains(filterText));
    }

    static public void filterTasks(ArrayList<Task> tasks, Scanner scanner) {
        boolean exit = false;

        IO.println("Options:");
        IO.println("(1) Done");
        IO.println("(2) Undone");
        IO.println("\nPick filter option:");

        while (!exit) {
            int optionFromUser = getIntFromUser(scanner, 2);

            if (optionFromUser == 1) {
                printFilteredTasks(tasks, t -> t.getIsDone() == true);
                exit = true;
                continue;
            } else if (optionFromUser == 2) {
                printFilteredTasks(tasks, t -> t.getIsDone() == false);
                exit = true;
                continue;
            }

            IO.println("Invalid input, try again.");
        }
    }
}
