package ezperf;

class AssertRunsWithinTimeout {

    private static final int DEFAULT_RUN_COUNT = 10;
    private static final int SINGLE_RUN = 1;

    static void assertRunsWithinTimeout(Runnable f, long timeout, int fasterRuns, int totalRuns, String message) {
        AssertionUtils.runAsyncWithTimeout(f, timeout, fasterRuns, totalRuns, message);
    }

    static void assertRunsWithinTimeout(Runnable f, long timeout, int fasterRuns, int totalRuns) {
        AssertionUtils.runAsyncWithTimeout(f, timeout, fasterRuns, totalRuns);
    }

    static void assertRunsWithinTimeout(Runnable f, long timeout, double percentage, String message) {
        assertRunsWithinTimeout(f, timeout, (int) Math.ceil(DEFAULT_RUN_COUNT * percentage), DEFAULT_RUN_COUNT, message);
    }

    static void assertRunsWithinTimeout(Runnable f, long timeout, double percentage) {
        assertRunsWithinTimeout(f, timeout, (int) Math.ceil(DEFAULT_RUN_COUNT * percentage), DEFAULT_RUN_COUNT);
    }

    static void assertRunsWithinTimeout(Runnable f, long timeout, String message) {
        assertRunsWithinTimeout(f, timeout, SINGLE_RUN, SINGLE_RUN, message);
    }

    static void assertRunsWithinTimeout(Runnable f, long timeout) {
        assertRunsWithinTimeout(f, timeout, SINGLE_RUN, SINGLE_RUN);
    }

}
