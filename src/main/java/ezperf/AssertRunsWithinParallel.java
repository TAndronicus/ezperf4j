package ezperf;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.function.Supplier;

class AssertRunsWithinParallel {

    private static final int DEFAULT_NUMBER_OF_THREADS = 10;

    static void assertRunsWithinParallel(Runnable f, long time, int numberOfThreads, int fasterRuns, Supplier<String> messageSupplier) {
        try {
            if (runInLoopParallel(f, time, numberOfThreads, fasterRuns)) return;
            AssertionUtils.fail(messageSupplier);
        } catch (InterruptedException e) {
            AssertionUtils.abort(e);
        }
    }

    static void assertRunsWithinParallel(Runnable f, long time, int numberOfThreads, int fasterRuns, String message) {
        try {
            if (runInLoopParallel(f, time, numberOfThreads, fasterRuns)) return;
            AssertionUtils.fail(message);
        } catch (InterruptedException e) {
            AssertionUtils.abort(e);
        }
    }

    static void assertRunsWithinParallel(Runnable f, long time, int numberOfThreads, int fasterRuns) {
        try {
            if (runInLoopParallel(f, time, numberOfThreads, fasterRuns)) return;
            AssertionUtils.fail();
        } catch (InterruptedException e) {
            AssertionUtils.abort(e);
        }
    }

    static void assertRunsWithinParallel(Runnable f, long time, int numberOfThreads, double percentage, Supplier<String> messageSupplier) {
        assertRunsWithinParallel(f, time, numberOfThreads, (int) Math.ceil(percentage * numberOfThreads), messageSupplier);
    }

    static void assertRunsWithinParallel(Runnable f, long time, int numberOfThreads, double percentage, String message) {
        assertRunsWithinParallel(f, time, numberOfThreads, (int) Math.ceil(percentage * numberOfThreads), message);
    }

    static void assertRunsWithinParallel(Runnable f, long time, int numberOfThreads, double percentage) {
        assertRunsWithinParallel(f, time, numberOfThreads, (int) Math.ceil(percentage * numberOfThreads));
    }

    static void assertRunsWithinParallel(Runnable f, long time, double percentage, Supplier<String> messageSupplier) {
        assertRunsWithinParallel(f, time, DEFAULT_NUMBER_OF_THREADS, (int) Math.ceil(percentage * DEFAULT_NUMBER_OF_THREADS), messageSupplier);
    }

    static void assertRunsWithinParallel(Runnable f, long time, double percentage, String message) {
        assertRunsWithinParallel(f, time, DEFAULT_NUMBER_OF_THREADS, (int) Math.ceil(percentage * DEFAULT_NUMBER_OF_THREADS), message);
    }

    static void assertRunsWithinParallel(Runnable f, long time, double percentage) {
        assertRunsWithinParallel(f, time, DEFAULT_NUMBER_OF_THREADS, (int) Math.ceil(percentage * DEFAULT_NUMBER_OF_THREADS));
    }

    static void assertRunsWithinParallel(Runnable f, long time, int numberOfThreads, Supplier<String> messageSupplier) {
        assertRunsWithinParallel(f, time, numberOfThreads, numberOfThreads, messageSupplier);
    }

    static void assertRunsWithinParallel(Runnable f, long time, int numberOfThreads, String message) {
        assertRunsWithinParallel(f, time, numberOfThreads, numberOfThreads, message);
    }

    static void assertRunsWithinParallel(Runnable f, long time, int numberOfThreads) {
        assertRunsWithinParallel(f, time, numberOfThreads, numberOfThreads);
    }

    static void assertRunsWithinParallel(Runnable f, long time, Supplier<String> messageSupplier) {
        assertRunsWithinParallel(f, time, DEFAULT_NUMBER_OF_THREADS, DEFAULT_NUMBER_OF_THREADS, messageSupplier);
    }

    static void assertRunsWithinParallel(Runnable f, long time, String message) {
        assertRunsWithinParallel(f, time, DEFAULT_NUMBER_OF_THREADS, DEFAULT_NUMBER_OF_THREADS, message);
    }

    static void assertRunsWithinParallel(Runnable f, long time) {
        assertRunsWithinParallel(f, time, DEFAULT_NUMBER_OF_THREADS, DEFAULT_NUMBER_OF_THREADS);
    }

    private static boolean runInLoopParallel(Runnable f, long time, int numberOfThreads, int numberOfFaster) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(numberOfThreads);
        final BlockingQueue<Long> runTimes = new ArrayBlockingQueue<>(numberOfThreads);
        for (int j = 0; j < numberOfThreads; j++) {
            Thread t = new Thread(() -> {
                try {
                    startGate.await();
                    f.run();
                    runTimes.add(System.currentTimeMillis());
                    endGate.countDown();
                } catch (InterruptedException e) {
                    AssertionUtils.abort(e);
                }
            });
            t.start();
        }
        final long before = System.currentTimeMillis();
        startGate.countDown();
        endGate.await();
        long fasterCount = runTimes.stream()
                .map(i -> i - before)
                .filter(diff -> diff <= time)
                .count();
        return fasterCount >= numberOfFaster;
    }

}
