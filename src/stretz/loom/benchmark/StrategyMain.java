package stretz.loom.benchmark;

import stretz.loom.benchmark.task.normal.CPUTask;
import stretz.loom.benchmark.task.normal.IoTask;
import stretz.loom.benchmark.strategy.cpu.CalculationStrategy;
import stretz.loom.benchmark.strategy.cpu.SimpleCalculation;

public class StrategyMain {
    public static void main (String[] args) {
        IoTask taskOne = new IoTask(100);
        taskOne.execute();

        CalculationStrategy strat = new SimpleCalculation(1000, Integer.MAX_VALUE, 10);
        CPUTask taskTwo = new CPUTask(strat, 10000000);
        taskTwo.execute();
    }
}
