package ezperf;

class AssertRunsWithinConcurrent {

    private static final int DEFAULT_RUN_COUNT = 10;
    private static final int SINGLE_RUN = 1;
    private static final int DEFAULT_NUMBER_OF_THREADS = 10;

    static void assertRunsWithinConcurrent(Runnable f, int numberOfThreads, long time, int fasterRuns, int totalRuns, String message) {
        AssertionUtils.assertRunsWithinConcurrent(f, time, numberOfThreads, fasterRuns, totalRuns, message);
    }

    static void assertRunsWithinConcurrent(Runnable f, int numberOfThreads, long time, int fasterRuns, int totalRuns) {
        AssertionUtils.assertRunsWithinConcurrent(f, time, numberOfThreads, fasterRuns, totalRuns);
    }
    
    static void assertRunsWithinConcurrent(Runnable f, int numberOfThreads, long time, double percentage, String message) {
        assertRunsWithinConcurrent(f, numberOfThreads, time, (int) Math.ceil(percentage * DEFAULT_RUN_COUNT), DEFAULT_RUN_COUNT, message);
    }

    static void assertRunsWithinConcurrent(Runnable f, int numberOfThreads, long time, double percentage) {
        assertRunsWithinConcurrent(f, numberOfThreads, time, (int) Math.ceil(percentage * DEFAULT_RUN_COUNT), DEFAULT_RUN_COUNT);
    }

    static void assertRunsWithinConcurrent(Runnable f, int numberOfThreads, long time, String message) {
        AssertRunsWithinConcurrent.assertRunsWithinConcurrent(f, numberOfThreads, time, SINGLE_RUN, SINGLE_RUN, message);
    }

    static void assertRunsWithinConcurrent(Runnable f, int numberOfThreads, long time) {
        AssertRunsWithinConcurrent.assertRunsWithinConcurrent(f, numberOfThreads, time, SINGLE_RUN, SINGLE_RUN);
    }

    static void assertRunsWithinConcurrent(Runnable f, long time, int fasterRuns, int totalRuns, String message) {
        AssertionUtils.assertRunsWithinConcurrent(f, time, DEFAULT_NUMBER_OF_THREADS, fasterRuns, totalRuns, message);
    }

    static void assertRunsWithinConcurrent(Runnable f, long time, int fasterRuns, int totalRuns) {
        AssertionUtils.assertRunsWithinConcurrent(f, time, DEFAULT_NUMBER_OF_THREADS, fasterRuns, totalRuns);
    }

    static void assertRunsWithinConcurrent(Runnable f, long time, double percentage, String message) {
        assertRunsWithinConcurrent(f, DEFAULT_NUMBER_OF_THREADS, time, (int) Math.ceil(percentage * DEFAULT_RUN_COUNT), DEFAULT_RUN_COUNT, message);
    }

    static void assertRunsWithinConcurrent(Runnable f, long time, double percentage) {
        assertRunsWithinConcurrent(f, DEFAULT_NUMBER_OF_THREADS, time, (int) Math.ceil(percentage * DEFAULT_RUN_COUNT), DEFAULT_RUN_COUNT);
    }

    static void assertRunsWithinConcurrent(Runnable f, long time, String message) {
        AssertRunsWithinConcurrent.assertRunsWithinConcurrent(f, DEFAULT_NUMBER_OF_THREADS, time, SINGLE_RUN, SINGLE_RUN, message);
    }

    static void assertRunsWithinConcurrent(Runnable f, long time) {
        AssertRunsWithinConcurrent.assertRunsWithinConcurrent(f, DEFAULT_NUMBER_OF_THREADS, time, SINGLE_RUN, SINGLE_RUN);
    }
    
}
