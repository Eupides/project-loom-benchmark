package stretz.loom.benchmark.tasks;

public interface Task {
    public TaskState execute();
    public TaskState getState();
}
