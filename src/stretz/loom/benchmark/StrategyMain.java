package stretz.loom.benchmark;

import stretz.loom.benchmark.tasks.CPUTask;
import stretz.loom.benchmark.tasks.IoTask;
import stretz.loom.benchmark.tasks.cpu.CalculationStrategy;
import stretz.loom.benchmark.tasks.cpu.SimpleCalculation;

public class StrategyMain {
    public static void main (String[] args) {
        IoTask taskOne = new IoTask(100, 1);
        taskOne.execute();

        CalculationStrategy strat = new SimpleCalculation(1000, Integer.MAX_VALUE, 10);
        CPUTask taskTwo = new CPUTask(strat, 10000000);
        taskTwo.execute();
    }
}
