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

    public static void assertRunsWithinConcurrent(Runnable f, long time, int numberOfThreads, int fasterRuns, int totalRuns, String message) {
        AssertRunsWithinConcurrent.assertRunsWithinConcurrent(f, time, numberOfThreads, fasterRuns, totalRuns, message);
    }

    public static void assertRunsWithinConcurrent(Runnable f, long time, int numberOfThreads, int fasterRuns, int totalRuns) {
        AssertRunsWithinConcurrent.assertRunsWithinConcurrent(f, time, numberOfThreads, fasterRuns, totalRuns);
    }

    public static void assertRunsWithinConcurrent(Runnable f, long time, int numberOfThreads, double percentage, String message) {
        AssertRunsWithinConcurrent.assertRunsWithinConcurrent(f, time, numberOfThreads, percentage, message);
    }

    public static void assertRunsWithinConcurrent(Runnable f, long time, int numberOfThreads, double percentage) {
        AssertRunsWithinConcurrent.assertRunsWithinConcurrent(f, time, numberOfThreads, percentage);
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

    public static void assertRunsWithinConcurrent(Runnable f, long time, int numberOfThreads, String message) {
        AssertRunsWithinConcurrent.assertRunsWithinConcurrent(f, time, numberOfThreads, message);
    }

    public static void assertRunsWithinConcurrent(Runnable f, long time, int numberOfThreads) {
        AssertRunsWithinConcurrent.assertRunsWithinConcurrent(f, time, numberOfThreads);
    }

    public static void assertRunsWithinConcurrent(Runnable f, long time, String message) {
        AssertRunsWithinConcurrent.assertRunsWithinConcurrent(f, time, message);
    }

    public static void assertRunsWithinConcurrent(Runnable f, long time) {
        AssertRunsWithinConcurrent.assertRunsWithinConcurrent(f, time);
    }

}
