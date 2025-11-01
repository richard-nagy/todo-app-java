package data;

public class Task {
    String description;
    Boolean isDone = false;

    public Task(String description, Boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    public Task(String description) {
        this.description = description;
    }

    public void toggleDone() {
        isDone = !isDone;
    }

    public String getString() {
        return "[" + (isDone ? "x" : " ") + "] " + description;
    }
}
