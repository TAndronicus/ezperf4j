package ezperf;

class AssertRunsWithinTimeoutConcurrent {

    private static final int DEFAULT_RUN_COUNT = 10;
    private static final int SINGLE_RUN = 1;
    private static final int DEFAULT_NUMBER_OF_THREADS = 10;

    static void assertRunsWithinTimeoutConcurrent(Runnable f, int numberOfThreads, long timeout, int fasterRuns, int totalRuns, String message) {
        AssertionUtils.assertRunsWithinTimeoutConcurrent(f, timeout, numberOfThreads, fasterRuns, totalRuns, message);
    }

    static void assertRunsWithinTimeoutConcurrent(Runnable f, int numberOfThreads, long timeout, int fasterRuns, int totalRuns) {
        AssertionUtils.assertRunsWithinTimeoutConcurrent(f, timeout, numberOfThreads, fasterRuns, totalRuns);
    }
    
    static void assertRunsWithinTimeoutConcurrent(Runnable f, int numberOfThreads, long timeout, double percentage, String message) {
        assertRunsWithinTimeoutConcurrent(f, numberOfThreads, timeout, (int) Math.ceil(percentage * DEFAULT_RUN_COUNT), DEFAULT_RUN_COUNT, message);
    }

    static void assertRunsWithinTimeoutConcurrent(Runnable f, int numberOfThreads, long timeout, double percentage) {
        assertRunsWithinTimeoutConcurrent(f, numberOfThreads, timeout, (int) Math.ceil(percentage * DEFAULT_RUN_COUNT), DEFAULT_RUN_COUNT);
    }

    static void assertRunsWithinTimeoutConcurrent(Runnable f, int numberOfThreads, long timeout, String message) {
        AssertRunsWithinTimeoutConcurrent.assertRunsWithinTimeoutConcurrent(f, numberOfThreads, timeout, SINGLE_RUN, SINGLE_RUN, message);
    }

    static void assertRunsWithinTimeoutConcurrent(Runnable f, int numberOfThreads, long timeout) {
        AssertRunsWithinTimeoutConcurrent.assertRunsWithinTimeoutConcurrent(f, numberOfThreads, timeout, SINGLE_RUN, SINGLE_RUN);
    }

    static void assertRunsWithinTimeoutConcurrent(Runnable f, long timeout, int fasterRuns, int totalRuns, String message) {
        AssertionUtils.assertRunsWithinTimeoutConcurrent(f, timeout, DEFAULT_NUMBER_OF_THREADS, fasterRuns, totalRuns, message);
    }

    static void assertRunsWithinTimeoutConcurrent(Runnable f, long timeout, int fasterRuns, int totalRuns) {
        AssertionUtils.assertRunsWithinTimeoutConcurrent(f, timeout, DEFAULT_NUMBER_OF_THREADS, fasterRuns, totalRuns);
    }

    static void assertRunsWithinTimeoutConcurrent(Runnable f, long timeout, double percentage, String message) {
        assertRunsWithinTimeoutConcurrent(f, DEFAULT_NUMBER_OF_THREADS, timeout, (int) Math.ceil(percentage * DEFAULT_RUN_COUNT), DEFAULT_RUN_COUNT, message);
    }

    static void assertRunsWithinTimeoutConcurrent(Runnable f, long timeout, double percentage) {
        assertRunsWithinTimeoutConcurrent(f, DEFAULT_NUMBER_OF_THREADS, timeout, (int) Math.ceil(percentage * DEFAULT_RUN_COUNT), DEFAULT_RUN_COUNT);
    }

    static void assertRunsWithinTimeoutConcurrent(Runnable f, long timeout, String message) {
        AssertRunsWithinTimeoutConcurrent.assertRunsWithinTimeoutConcurrent(f, DEFAULT_NUMBER_OF_THREADS, timeout, SINGLE_RUN, SINGLE_RUN, message);
    }

    static void assertRunsWithinTimeoutConcurrent(Runnable f, long timeout) {
        AssertRunsWithinTimeoutConcurrent.assertRunsWithinTimeoutConcurrent(f, DEFAULT_NUMBER_OF_THREADS, timeout, SINGLE_RUN, SINGLE_RUN);
    }
    
}
