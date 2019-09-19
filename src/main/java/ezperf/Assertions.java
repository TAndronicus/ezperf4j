package ezperf;

@SuppressWarnings({"WeakerAccess", "unused"})
public class Assertions {

    public static void assertRunsWithin(Runnable f, long time, int fasterRuns, int totalRuns, String message) {
        AssertRunsWithin.assertRunsWithin(f, time, fasterRuns, totalRuns, message);
    }

    public static void assertRunsWithin(Runnable f, long time, int fasterRuns, int totalRuns) {
        AssertRunsWithin.assertRunsWithin(f, time, fasterRuns, totalRuns);
    }

    public static void assertRunsWithin(Runnable f, long time, double percentage, String message) {
        AssertRunsWithin.assertRunsWithin(f, time, percentage, message);
    }

    public static void assertRunsWithin(Runnable f, long time, double percentage) {
        AssertRunsWithin.assertRunsWithin(f, time, percentage);
    }

    public static void assertRunsWithin(Runnable f, long time, String message) {
        AssertRunsWithin.assertRunsWithin(f, time, message);
    }

    public static void assertRunsWithin(Runnable f, long time) {
        AssertRunsWithin.assertRunsWithin(f, time);
    }

    public static void assertRunsWithinParallel(Runnable f, long time, int numberOfThreads, int fasterRuns, int totalRuns, String message) {
        AssertRunsWithinParallel.assertRunsWithinParallel(f, time, numberOfThreads, fasterRuns, totalRuns, message);
    }

    public static void assertRunsWithinParallel(Runnable f, long time, int numberOfThreads, int fasterRuns, int totalRuns) {
        AssertRunsWithinParallel.assertRunsWithinParallel(f, time, numberOfThreads, fasterRuns, totalRuns);
    }

    public static void assertRunsWithinParallel(Runnable f, long time, int numberOfThreads, double percentage, String message) {
        AssertRunsWithinParallel.assertRunsWithinParallel(f, time, numberOfThreads, percentage, message);
    }

    public static void assertRunsWithinParallel(Runnable f, long time, int numberOfThreads, double percentage) {
        AssertRunsWithinParallel.assertRunsWithinParallel(f, time, numberOfThreads, percentage);
    }

    public static void assertRunsWithinParallel(Runnable f, long time, int fasterRuns, int totalRuns, String message) {
        AssertRunsWithinParallel.assertRunsWithinParallel(f, time, fasterRuns, totalRuns, message);
    }

    public static void assertRunsWithinParallel(Runnable f, long time, int fasterRuns, int totalRuns) {
        AssertRunsWithinParallel.assertRunsWithinParallel(f, time, fasterRuns, totalRuns);
    }

    public static void assertRunsWithinParallel(Runnable f, long time, double percentage, String message) {
        AssertRunsWithinParallel.assertRunsWithinParallel(f, time, percentage, message);
    }

    public static void assertRunsWithinParallel(Runnable f, long time, double percentage) {
        AssertRunsWithinParallel.assertRunsWithinParallel(f, time, percentage);
    }

    public static void assertRunsWithinParallel(Runnable f, long time, int numberOfThreads, String message) {
        AssertRunsWithinParallel.assertRunsWithinParallel(f, time, numberOfThreads, message);
    }

    public static void assertRunsWithinParallel(Runnable f, long time, int numberOfThreads) {
        AssertRunsWithinParallel.assertRunsWithinParallel(f, time, numberOfThreads);
    }

    public static void assertRunsWithinParallel(Runnable f, long time, String message) {
        AssertRunsWithinParallel.assertRunsWithinParallel(f, time, message);
    }

    public static void assertRunsWithinParallel(Runnable f, long time) {
        AssertRunsWithinParallel.assertRunsWithinParallel(f, time);
    }

    public static void assertRunsWithinTimeout(Runnable f, long timeout, int fasterRuns, int totalRuns, String message) {
        AssertRunsWithinTimeout.assertRunsWithinTimeout(f, timeout, fasterRuns, totalRuns, message);
    }

    public static void assertRunsWithinTimeout(Runnable f, long timeout, int fasterRuns, int totalRuns) {
        AssertRunsWithinTimeout.assertRunsWithinTimeout(f, timeout, fasterRuns, totalRuns);
    }

    public static void assertRunsWithinTimeout(Runnable f, long timeout, double percentage, String message) {
        AssertRunsWithinTimeout.assertRunsWithinTimeout(f, timeout, percentage, message);
    }

    public static void assertRunsWithinTimeout(Runnable f, long timeout, double percentage) {
        AssertRunsWithinTimeout.assertRunsWithinTimeout(f, timeout, percentage);
    }

    public static void assertRunsWithinTimeout(Runnable f, long timeout, String message) {
        AssertRunsWithinTimeout.assertRunsWithinTimeout(f, timeout, message);
    }

    public static void assertRunsWithinTimeout(Runnable f, long timeout) {
        AssertRunsWithinTimeout.assertRunsWithinTimeout(f, timeout);
    }

    public static void assertRunsWithinConcurrent(Runnable f, int numberOfThreads, long time, int fasterRuns, int totalRuns, String message) {
        AssertRunsWithinConcurrent.assertRunsWithinConcurrent(f, numberOfThreads, time, fasterRuns, totalRuns, message);
    }

    public static void assertRunsWithinConcurrent(Runnable f, int numberOfThreads, long time, int fasterRuns, int totalRuns) {
        AssertRunsWithinConcurrent.assertRunsWithinConcurrent(f, numberOfThreads, time, fasterRuns, totalRuns);
    }

    public static void assertRunsWithinConcurrent(Runnable f, int numberOfThreads, long time, double percentage, String message) {
        AssertRunsWithinConcurrent.assertRunsWithinConcurrent(f, numberOfThreads, time, percentage, message);
    }

    public static void assertRunsWithinConcurrent(Runnable f, int numberOfThreads, long time, double percentage) {
        AssertRunsWithinConcurrent.assertRunsWithinConcurrent(f, numberOfThreads, time, percentage);
    }

    public static void assertRunsWithinConcurrent(Runnable f, int numberOfThreads, long time, String message) {
        AssertRunsWithinConcurrent.assertRunsWithinConcurrent(f, numberOfThreads, time, message);
    }

    public static void assertRunsWithinConcurrent(Runnable f, int numberOfThreads, long time) {
        AssertRunsWithinConcurrent.assertRunsWithinConcurrent(f, numberOfThreads, time);
    }

    public static void assertRunsWithinConcurrent(Runnable f, long time, int fasterRuns, int totalRuns, String message) {
        AssertRunsWithinConcurrent.assertRunsWithinConcurrent(f, time, fasterRuns, totalRuns, message);
    }

    public static void assertRunsWithinConcurrent(Runnable f, long time, int fasterRuns, int totalRuns) {
        AssertRunsWithinConcurrent.assertRunsWithinConcurrent(f, time, fasterRuns, totalRuns);
    }

    public static void assertRunsWithinConcurrent(Runnable f, long time, double percentage, String message) {
        AssertRunsWithinConcurrent.assertRunsWithinConcurrent(f, time, percentage, message);
    }

    public static void assertRunsWithinConcurrent(Runnable f, long time, double percentage) {
        AssertRunsWithinConcurrent.assertRunsWithinConcurrent(f, time, percentage);
    }

    public static void assertRunsWithinConcurrent(Runnable f, long time, String message) {
        AssertRunsWithinConcurrent.assertRunsWithinConcurrent(f, time, message);
    }

    public static void assertRunsWithinConcurrent(Runnable f, long time) {
        AssertRunsWithinConcurrent.assertRunsWithinConcurrent(f, time);
    }

    public static void assertRunsWithinTimeoutConcurrent(Runnable f, int numberOfThreads, long timeout, int fasterRuns, int totalRuns, String message) {
        AssertRunsWithinTimeoutConcurrent.assertRunsWithinTimeoutConcurrent(f, numberOfThreads, timeout, fasterRuns, totalRuns, message);
    }

    public static void assertRunsWithinTimeoutConcurrent(Runnable f, int numberOfThreads, long timeout, int fasterRuns, int totalRuns) {
        AssertRunsWithinTimeoutConcurrent.assertRunsWithinTimeoutConcurrent(f, numberOfThreads, timeout, fasterRuns, totalRuns);
    }

    public static void assertRunsWithinTimeoutConcurrent(Runnable f, int numberOfThreads, long timeout, double percentage, String message) {
        AssertRunsWithinTimeoutConcurrent.assertRunsWithinTimeoutConcurrent(f, numberOfThreads, timeout, percentage, message);
    }

    public static void assertRunsWithinTimeoutConcurrent(Runnable f, int numberOfThreads, long timeout, double percentage) {
        AssertRunsWithinTimeoutConcurrent.assertRunsWithinTimeoutConcurrent(f, numberOfThreads, timeout, percentage);
    }

    public static void assertRunsWithinTimeoutConcurrent(Runnable f, int numberOfThreads, long timeout, String message) {
        AssertRunsWithinTimeoutConcurrent.assertRunsWithinTimeoutConcurrent(f, numberOfThreads, timeout, message);
    }

    public static void assertRunsWithinTimeoutConcurrent(Runnable f, int numberOfThreads, long timeout) {
        AssertRunsWithinTimeoutConcurrent.assertRunsWithinTimeoutConcurrent(f, numberOfThreads, timeout);
    }

    public static void assertRunsWithinTimeoutConcurrent(Runnable f, long timeout, int fasterRuns, int totalRuns, String message) {
        AssertRunsWithinTimeoutConcurrent.assertRunsWithinTimeoutConcurrent(f, timeout, fasterRuns, totalRuns, message);
    }

    public static void assertRunsWithinTimeoutConcurrent(Runnable f, long timeout, int fasterRuns, int totalRuns) {
        AssertRunsWithinTimeoutConcurrent.assertRunsWithinTimeoutConcurrent(f, timeout, fasterRuns, totalRuns);
    }

    public static void assertRunsWithinTimeoutConcurrent(Runnable f, long timeout, double percentage, String message) {
        AssertRunsWithinTimeoutConcurrent.assertRunsWithinTimeoutConcurrent(f, timeout, percentage, message);
    }

    public static void assertRunsWithinTimeoutConcurrent(Runnable f, long timeout, double percentage) {
        AssertRunsWithinTimeoutConcurrent.assertRunsWithinTimeoutConcurrent(f, timeout, percentage);
    }

    public static void assertRunsWithinTimeoutConcurrent(Runnable f, long timeout, String message) {
        AssertRunsWithinTimeoutConcurrent.assertRunsWithinTimeoutConcurrent(f, timeout, message);
    }

    public static void assertRunsWithinTimeoutConcurrent(Runnable f, long timeout) {
        AssertRunsWithinTimeoutConcurrent.assertRunsWithinTimeoutConcurrent(f, timeout);
    }

}
