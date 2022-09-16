package stretz.loom.benchmark;

import stretz.loom.benchmark.tasks.IoTask;

public class StrategyMain {
    public static void main (String[] args) {
        IoTask taskOne = new IoTask(100, 1);

        taskOne.execute();
    }
}
