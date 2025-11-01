package storage;

import data.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskFileManager {
    static private Boolean emptyCheck(String text) {
        return !text.isEmpty() && !text.matches("^\\s*$");
    }

    static public ArrayList<String> readFile(String fileName) {
        File file = new File(fileName);
        ArrayList<String> lines = new ArrayList<>();

        try (Scanner myReader = new Scanner(file)) {
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            IO.println("An error occurred: " + e);
        }

        return lines;
    }

    static public void writeFile(String fileName, ArrayList<String> list) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (String item : list) {
                if (emptyCheck(item)) {
                    writer.write(item + System.lineSeparator());
                }
            }
        } catch (IOException e) {
            IO.println("An error occurred: " + e);
        }
    }

    static public void loadTasksFromFile(String fileName, ArrayList<Task> tasks) {
        ArrayList<String> lines = readFile(fileName);

        for (String line : lines) {
            if (emptyCheck(line)) {
                if (line.startsWith("[x]")) {
                    tasks.add(new Task(line, true));
                    return;
                }

                tasks.add(new Task(line));
            }
        }
    }
}
