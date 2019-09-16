package ezperf;

import org.opentest4j.AssertionFailedError;

import java.util.concurrent.CountDownLatch;

@SuppressWarnings("WeakerAccess")
public class Assertions {

    public static final String EMPTY_MESSAGE = "";
    public static final int DEFAULT_RUN_COUNT = 10;
    public static final int SINGLE_RUN = 1;
    public static final int DEFAULT_NUMBER_OF_THREADS = 10;

    public static void assertRunsWithin(Runnable f, long time, int fasterRuns, int totalRuns, String message) {
        int passedCounter = 0;
        for (int i = 0; i < totalRuns; i++) {
            long before = System.currentTimeMillis();
            f.run();
            if (System.currentTimeMillis() - before <= time) passedCounter++;
            if (passedCounter >= fasterRuns) return;
        }
        throw new AssertionFailedError(message);
    }

    public static void assertRunsWithin(Runnable f, long time, int fasterRuns, int totalRuns) {
        assertRunsWithin(f, time, fasterRuns, totalRuns, EMPTY_MESSAGE);
    }

    public static void assertRunsWithin(Runnable f, long time, double percentage, String message) {
        assertRunsWithin(f, time, (int) Math.ceil(percentage * DEFAULT_RUN_COUNT), DEFAULT_RUN_COUNT, message);
    }

    public static void assertRunsWithin(Runnable f, long time, double percentage) {
        assertRunsWithin(f, time, percentage, EMPTY_MESSAGE);
    }

    public static void assertRunsWithin(Runnable f, long time, String message) {
        assertRunsWithin(f, time, SINGLE_RUN, SINGLE_RUN, message);
    }

    public static void assertRunsWithin(Runnable f, long time) {
        assertRunsWithin(f, time, EMPTY_MESSAGE);
    }

    public static void assertRunsWithinConcurrent(Runnable f, long time, int numberOfThreads, int fasterRuns, int totalRuns, String message) throws InterruptedException {
        int passedCounter = 0;
        for (int i = 0; i < totalRuns; i++) {
            final CountDownLatch startGate = new CountDownLatch(1);
            final CountDownLatch endGate = new CountDownLatch(numberOfThreads);
            for (int j = 0; j < numberOfThreads; j++) {
                Thread t = new Thread(() -> {
                    try {
                        startGate.await();
                        f.run();
                        endGate.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                t.start();
            }
            long before = System.currentTimeMillis();
            startGate.countDown();
            endGate.await();
            if (System.currentTimeMillis() - before <= time) passedCounter++;
            if (passedCounter >= fasterRuns) return;
        }
        throw new AssertionFailedError(message);
    }

    public static void assertRunsWithinConcurrent(Runnable f, long time, int numberOfThreads, int fasterRuns, int totalRuns) throws InterruptedException {
        assertRunsWithinConcurrent(f, time, numberOfThreads, fasterRuns, totalRuns, EMPTY_MESSAGE);
    }

    public static void assertRunsWithinConcurrent(Runnable f, long time, int numberOfThreads, double percentage, String message) throws InterruptedException {
        assertRunsWithinConcurrent(f, time, numberOfThreads, (int) Math.ceil(percentage * DEFAULT_RUN_COUNT), DEFAULT_RUN_COUNT, message);
    }

    public static void assertRunsWithinConcurrent(Runnable f, long time, int numberOfThreads, double percentage) throws InterruptedException {
        assertRunsWithinConcurrent(f, time, numberOfThreads, percentage, EMPTY_MESSAGE);
    }

    public static void assertRunsWithinConcurrent(Runnable f, long time, int fasterRuns, int totalRuns, String message) throws InterruptedException {
        assertRunsWithinConcurrent(f, time, DEFAULT_NUMBER_OF_THREADS, fasterRuns, totalRuns, message);
    }

    public static void assertRunsWithinConcurrent(Runnable f, long time, int fasterRuns, int totalRuns) throws InterruptedException {
        assertRunsWithinConcurrent(f, time, fasterRuns, totalRuns, EMPTY_MESSAGE);
    }

    public static void assertRunsWithinConcurrent(Runnable f, long time, double percentage, String message) throws InterruptedException {
        assertRunsWithinConcurrent(f, time, DEFAULT_NUMBER_OF_THREADS, (int) Math.ceil(percentage * DEFAULT_RUN_COUNT), DEFAULT_RUN_COUNT, message);
    }

    public static void assertRunsWithinConcurrent(Runnable f, long time, double percentage) throws InterruptedException {
        assertRunsWithinConcurrent(f, time, percentage, EMPTY_MESSAGE);
    }

    public static void assertRunsWithinConcurrent(Runnable f, long time, int numberOfThreads, String message) throws InterruptedException {
        assertRunsWithinConcurrent(f, time, numberOfThreads, SINGLE_RUN, SINGLE_RUN, message);
    }

    public static void assertRunsWithinConcurrent(Runnable f, long time, int numberOfThreads) throws InterruptedException {
        assertRunsWithinConcurrent(f, time, numberOfThreads, EMPTY_MESSAGE);
    }

    public static void assertRunsWithinConcurrent(Runnable f, long time, String message) throws InterruptedException {
        assertRunsWithinConcurrent(f, time, DEFAULT_NUMBER_OF_THREADS, SINGLE_RUN, SINGLE_RUN, message);
    }

    public static void assertRunsWithinConcurrent(Runnable f, long time) throws InterruptedException {
        assertRunsWithinConcurrent(f, time, EMPTY_MESSAGE);
    }

}
