package stretz.loom.benchmark.tasks;

import stretz.loom.benchmark.tasks.cpu.CPURunner;
import stretz.loom.benchmark.tasks.cpu.CalculationStrategy;
import stretz.loom.benchmark.tasks.cpu.CalculatorFactory;
import stretz.loom.benchmark.util.ThreadUtil;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CPUTask implements Task {
    private TaskState state = TaskState.NOT_STARTED;
    private CalculationStrategy strategy;
    private final int maxThreads;

    public CPUTask(CalculationStrategy strategy, int maxThreads) {
        this.strategy = strategy;
        this.maxThreads = maxThreads;
    }
    @Override
    public TaskState execute() {
        this.state = TaskState.ACTIVE;

        ThreadPoolExecutor calculatorExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        for (int i = 0; i < maxThreads; i++) {
            CPURunner runner = new CPURunner(CalculatorFactory.getNewCalculator(this.strategy));
            calculatorExecutor.execute(runner);
        }

        ThreadUtil.shutdownAndAwaitTermination(calculatorExecutor);
        this.state = TaskState.DONE;
        System.out.println("calculator done");

        return this.state;
    }

    @Override
    public TaskState getState() {
        return state;
    }
}
