package ezperf;

import java.util.function.Supplier;

import static ezperf.AssertionUtils.fail;

class AssertRunsWithin {

    private static final int DEFAULT_RUN_COUNT = 10;
    private static final int SINGLE_RUN = 1;

    static void assertRunsWithin(Runnable f, long time, int fasterRuns, int totalRuns, Supplier<String> messageSupplier) {
        if (runInLoop(f, time, fasterRuns, totalRuns)) return;
        fail(messageSupplier);
    }

    static void assertRunsWithin(Runnable f, long time, int fasterRuns, int totalRuns, String message) {
        if (runInLoop(f, time, fasterRuns, totalRuns)) return;
        fail(message);
    }

    static void assertRunsWithin(Runnable f, long time, int fasterRuns, int totalRuns) {
        if (runInLoop(f, time, fasterRuns, totalRuns)) return;
        fail();
    }

    static void assertRunsWithin(Runnable f, long time, double percentage, int totalRuns, Supplier<String> messageSupplier) {
        assertRunsWithin(f, time, (int) Math.ceil(percentage * totalRuns), totalRuns, messageSupplier);
    }

    static void assertRunsWithin(Runnable f, long time, double percentage, int totalRuns, String message) {
        assertRunsWithin(f, time, (int) Math.ceil(percentage * totalRuns), totalRuns, message);
    }

    static void assertRunsWithin(Runnable f, long time, double percentage, int totalRuns) {
        assertRunsWithin(f, time, (int) Math.ceil(percentage * totalRuns), totalRuns);
    }

    static void assertRunsWithin(Runnable f, long time, double percentage, Supplier<String> messageSupplier) {
        assertRunsWithin(f, time, (int) Math.ceil(percentage * DEFAULT_RUN_COUNT), DEFAULT_RUN_COUNT, messageSupplier);
    }

    static void assertRunsWithin(Runnable f, long time, double percentage, String message) {
        assertRunsWithin(f, time, (int) Math.ceil(percentage * DEFAULT_RUN_COUNT), DEFAULT_RUN_COUNT, message);
    }

    static void assertRunsWithin(Runnable f, long time, double percentage) {
        assertRunsWithin(f, time, (int) Math.ceil(percentage * DEFAULT_RUN_COUNT), DEFAULT_RUN_COUNT);
    }

    static void assertRunsWithin(Runnable f, long time, Supplier<String> messageSupplier) {
        assertRunsWithin(f, time, SINGLE_RUN, SINGLE_RUN, messageSupplier);
    }

    static void assertRunsWithin(Runnable f, long time, String message) {
        assertRunsWithin(f, time, SINGLE_RUN, SINGLE_RUN, message);
    }

    static void assertRunsWithin(Runnable f, long time) {
        assertRunsWithin(f, time, SINGLE_RUN, SINGLE_RUN);
    }

    private static boolean runInLoop(Runnable f, long time, int fasterRuns, int totalRuns) {
        int passedCounter = 0;
        for (int i = 0; i < totalRuns; i++) {
            if (runAndMeasure(f) <= time) passedCounter++;
            if (passedCounter >= fasterRuns) return true;
        }
        return false;
    }

    private static long runAndMeasure(Runnable f) {
        long before = System.currentTimeMillis();
        f.run();
        return System.currentTimeMillis() - before;
    }

}
