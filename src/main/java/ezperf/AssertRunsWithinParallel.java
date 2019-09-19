package ezperf;

import java.util.concurrent.CountDownLatch;

class AssertRunsWithinParallel {

    private static final int DEFAULT_RUN_COUNT = 10;
    private static final int SINGLE_RUN = 1;
    private static final int DEFAULT_NUMBER_OF_THREADS = 10;

    static void assertRunsWithinParallel(Runnable f, long time, int numberOfThreads, int fasterRuns, int totalRuns, String message) {
        try {
            if (runInLoopParallel(f, time, numberOfThreads, fasterRuns, totalRuns)) return;
            AssertionUtils.fail(message);
        } catch (InterruptedException e) {
            AssertionUtils.abort(e);
        }
    }

    static void assertRunsWithinParallel(Runnable f, long time, int numberOfThreads, int fasterRuns, int totalRuns) {
        try {
            if (runInLoopParallel(f, time, numberOfThreads, fasterRuns, totalRuns)) return;
            AssertionUtils.fail();
        } catch (InterruptedException e) {
            AssertionUtils.abort(e);
        }
    }

    static void assertRunsWithinParallel(Runnable f, long time, int numberOfThreads, double percentage, String message) {
        assertRunsWithinParallel(f, time, numberOfThreads, (int) Math.ceil(percentage * DEFAULT_RUN_COUNT), DEFAULT_RUN_COUNT, message);
    }

    static void assertRunsWithinParallel(Runnable f, long time, int numberOfThreads, double percentage) {
        assertRunsWithinParallel(f, time, numberOfThreads, (int) Math.ceil(percentage * DEFAULT_RUN_COUNT), DEFAULT_RUN_COUNT);
    }

    static void assertRunsWithinParallel(Runnable f, long time, int fasterRuns, int totalRuns, String message) {
        assertRunsWithinParallel(f, time, DEFAULT_NUMBER_OF_THREADS, fasterRuns, totalRuns, message);
    }

    static void assertRunsWithinParallel(Runnable f, long time, int fasterRuns, int totalRuns) {
        assertRunsWithinParallel(f, time, DEFAULT_NUMBER_OF_THREADS, fasterRuns, totalRuns);
    }

    static void assertRunsWithinParallel(Runnable f, long time, double percentage, String message) {
        assertRunsWithinParallel(f, time, DEFAULT_NUMBER_OF_THREADS, (int) Math.ceil(percentage * DEFAULT_RUN_COUNT), DEFAULT_RUN_COUNT, message);
    }

    static void assertRunsWithinParallel(Runnable f, long time, double percentage) {
        assertRunsWithinParallel(f, time, DEFAULT_NUMBER_OF_THREADS, (int) Math.ceil(percentage * DEFAULT_RUN_COUNT), DEFAULT_RUN_COUNT);
    }

    static void assertRunsWithinParallel(Runnable f, long time, int numberOfThreads, String message) {
        assertRunsWithinParallel(f, time, numberOfThreads, SINGLE_RUN, SINGLE_RUN, message);
    }

    static void assertRunsWithinParallel(Runnable f, long time, int numberOfThreads) {
        assertRunsWithinParallel(f, time, numberOfThreads, SINGLE_RUN, SINGLE_RUN);
    }

    static void assertRunsWithinParallel(Runnable f, long time, String message) {
        assertRunsWithinParallel(f, time, DEFAULT_NUMBER_OF_THREADS, SINGLE_RUN, SINGLE_RUN, message);
    }

    static void assertRunsWithinParallel(Runnable f, long time) {
        assertRunsWithinParallel(f, time, DEFAULT_NUMBER_OF_THREADS, SINGLE_RUN, SINGLE_RUN);
    }

    private static boolean runInLoopParallel(Runnable f, long time, int numberOfThreads, int fasterRuns, int totalRuns) throws InterruptedException {
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
                        AssertionUtils.abort(e);
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
