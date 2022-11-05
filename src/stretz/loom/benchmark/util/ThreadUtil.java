package stretz.loom.benchmark.util;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadUtil {
    /**
     * Shuts down the ThreadPoolExecutor
     * @TODO needs to be adjusted for own use
     * @param pool executor
     */
    public static void shutdownAndAwaitTermination(ThreadPoolExecutor pool) {
        pool.shutdown();

        try {
            if(!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                pool.shutdownNow();

                if(!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                    System.err.println("Pool did not Terminate");
                }
            }
        } catch (InterruptedException e) {
            pool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
