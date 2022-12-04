package stretz.loom.benchmark.task.loom;

import stretz.loom.benchmark.task.Task;
import stretz.loom.benchmark.task.TaskState;

public class LoomIoTask implements Task {
    private TaskState state = TaskState.NOT_STARTED;
    @Override
    public TaskState execute() {
        return this.state;
    }

    @Override
    public TaskState getState() {
        return this.state;
    }
}
