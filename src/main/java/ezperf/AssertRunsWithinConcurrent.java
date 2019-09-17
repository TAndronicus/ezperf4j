package ezperf;

import java.util.concurrent.CountDownLatch;

class AssertRunsWithinConcurrent {

    private static final int DEFAULT_RUN_COUNT = 10;
    private static final int SINGLE_RUN = 1;
    private static final int DEFAULT_NUMBER_OF_THREADS = 10;

    static void assertRunsWithinConcurrent(Runnable f, long time, int numberOfThreads, int fasterRuns, int totalRuns, String message) {
        try {
            if (runInLoopConcurrent(f, time, numberOfThreads, fasterRuns, totalRuns)) return;
            AssertionUtils.fail(message);
        } catch (InterruptedException e) {
            AssertionUtils.fail(e);
        }
    }

    static void assertRunsWithinConcurrent(Runnable f, long time, int numberOfThreads, int fasterRuns, int totalRuns) {
        try {
            if (runInLoopConcurrent(f, time, numberOfThreads, fasterRuns, totalRuns)) return;
            AssertionUtils.fail();
        } catch (InterruptedException e) {
            AssertionUtils.fail(e);
        }
    }

    static void assertRunsWithinConcurrent(Runnable f, long time, int numberOfThreads, double percentage, String message) {
        assertRunsWithinConcurrent(f, time, numberOfThreads, (int) Math.ceil(percentage * DEFAULT_RUN_COUNT), DEFAULT_RUN_COUNT, message);
    }

    static void assertRunsWithinConcurrent(Runnable f, long time, int numberOfThreads, double percentage) {
        assertRunsWithinConcurrent(f, time, numberOfThreads, (int) Math.ceil(percentage * DEFAULT_RUN_COUNT), DEFAULT_RUN_COUNT);
    }

    static void assertRunsWithinConcurrent(Runnable f, long time, int fasterRuns, int totalRuns, String message) {
        assertRunsWithinConcurrent(f, time, DEFAULT_NUMBER_OF_THREADS, fasterRuns, totalRuns, message);
    }

    static void assertRunsWithinConcurrent(Runnable f, long time, int fasterRuns, int totalRuns) {
        assertRunsWithinConcurrent(f, time, DEFAULT_NUMBER_OF_THREADS, fasterRuns, totalRuns);
    }

    static void assertRunsWithinConcurrent(Runnable f, long time, double percentage, String message) {
        assertRunsWithinConcurrent(f, time, DEFAULT_NUMBER_OF_THREADS, (int) Math.ceil(percentage * DEFAULT_RUN_COUNT), DEFAULT_RUN_COUNT, message);
    }

    static void assertRunsWithinConcurrent(Runnable f, long time, double percentage) {
        assertRunsWithinConcurrent(f, time, DEFAULT_NUMBER_OF_THREADS, (int) Math.ceil(percentage * DEFAULT_RUN_COUNT), DEFAULT_RUN_COUNT);
    }

    static void assertRunsWithinConcurrent(Runnable f, long time, int numberOfThreads, String message) {
        assertRunsWithinConcurrent(f, time, numberOfThreads, SINGLE_RUN, SINGLE_RUN, message);
    }

    static void assertRunsWithinConcurrent(Runnable f, long time, int numberOfThreads) {
        assertRunsWithinConcurrent(f, time, numberOfThreads, SINGLE_RUN, SINGLE_RUN);
    }

    static void assertRunsWithinConcurrent(Runnable f, long time, String message) {
        assertRunsWithinConcurrent(f, time, DEFAULT_NUMBER_OF_THREADS, SINGLE_RUN, SINGLE_RUN, message);
    }

    static void assertRunsWithinConcurrent(Runnable f, long time) {
        assertRunsWithinConcurrent(f, time, DEFAULT_NUMBER_OF_THREADS, SINGLE_RUN, SINGLE_RUN);
    }

    private static boolean runInLoopConcurrent(Runnable f, long time, int numberOfThreads, int fasterRuns, int totalRuns) throws InterruptedException {
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
                        AssertionUtils.fail(e);
                    }
                });
                t.start();
            }
            long before = System.currentTimeMillis();
            startGate.countDown();
            endGate.await();
            if (System.currentTimeMillis() - before <= time) passedCounter++;
            if (passedCounter >= fasterRuns) return true;
        }
        return false;
    }

}
