package ezperf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

class AssertRunsWithinParallelTimeout {

    private static final int DEFAULT_NUMBER_OF_THREADS = 10;

    static void assertRunsWithinParallelTimeout(Runnable f, long time, int numberOfThreads, int fasterRuns, String message) {
        if (runInLoopParallelTimeout(f, time, numberOfThreads, fasterRuns)) return;
        AssertionUtils.fail(message);
    }

    static void assertRunsWithinParallelTimeout(Runnable f, long time, int numberOfThreads, int fasterRuns) {
        if (runInLoopParallelTimeout(f, time, numberOfThreads, fasterRuns)) return;
        AssertionUtils.fail();
    }

    static void assertRunsWithinParallelTimeout(Runnable f, long time, int numberOfThreads, double percentage, String message) {
        assertRunsWithinParallelTimeout(f, time, numberOfThreads, (int) Math.ceil(percentage * numberOfThreads), message);
    }

    static void assertRunsWithinParallelTimeout(Runnable f, long time, int numberOfThreads, double percentage) {
        assertRunsWithinParallelTimeout(f, time, numberOfThreads, (int) Math.ceil(percentage * numberOfThreads));
    }

    static void assertRunsWithinParallelTimeout(Runnable f, long time, double percentage, String message) {
        assertRunsWithinParallelTimeout(f, time, DEFAULT_NUMBER_OF_THREADS, (int) Math.ceil(percentage * DEFAULT_NUMBER_OF_THREADS), message);
    }

    static void assertRunsWithinParallelTimeout(Runnable f, long time, double percentage) {
        assertRunsWithinParallelTimeout(f, time, DEFAULT_NUMBER_OF_THREADS, (int) Math.ceil(percentage * DEFAULT_NUMBER_OF_THREADS));
    }

    static void assertRunsWithinParallelTimeout(Runnable f, long time, int numberOfThreads, String message) {
        assertRunsWithinParallelTimeout(f, time, numberOfThreads, numberOfThreads, message);
    }

    static void assertRunsWithinParallelTimeout(Runnable f, long time, int numberOfThreads) {
        assertRunsWithinParallelTimeout(f, time, numberOfThreads, numberOfThreads);
    }

    static void assertRunsWithinParallelTimeout(Runnable f, long time, String message) {
        assertRunsWithinParallelTimeout(f, time, DEFAULT_NUMBER_OF_THREADS, DEFAULT_NUMBER_OF_THREADS, message);
    }

    static void assertRunsWithinParallelTimeout(Runnable f, long time) {
        assertRunsWithinParallelTimeout(f, time, DEFAULT_NUMBER_OF_THREADS, DEFAULT_NUMBER_OF_THREADS);
    }

    private static boolean runInLoopParallelTimeout(Runnable f, long time, int numberOfThreads, int numberOfFaster) {
        AtomicInteger fasterRuns = new AtomicInteger();
        CountDownLatch blocker = new CountDownLatch(1);
        Executor executor = Executors.newFixedThreadPool(numberOfThreads);
        CompletableFuture[] completableFutures = new CompletableFuture[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            CompletableFuture completableFuture = CompletableFuture.runAsync(() -> {
                try {
                    blocker.await();
                } catch (InterruptedException e) {
                    AssertionUtils.abort(e);
                }
                long before = System.currentTimeMillis();
                f.run();
                if (System.currentTimeMillis() - before <= time) fasterRuns.incrementAndGet();
            }, executor);
            completableFutures[i] = completableFuture;
        }
        blocker.countDown();
        try {
            CompletableFuture.allOf(completableFutures).get(time, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | TimeoutException ignored) {
        } catch (ExecutionException e) {
            AssertionUtils.abort(e);
        }
        return fasterRuns.get() >= numberOfFaster;
    }

}
