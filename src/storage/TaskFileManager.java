package storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskFileManager {
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

    static public void loadTasksFromFile(String fileName, ArrayList<String> list) {
        ArrayList<String> lines = readFile(fileName);

        for (String line : lines) {
            if (!line.isEmpty() && !line.matches("^\\s*$")) {
                list.add(line);
            }
        }
    }
}
