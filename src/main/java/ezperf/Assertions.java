package ezperf;

/**
 * {@code Assertions} provides a collection of utility assertions for performance testing purposes.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Assertions {

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds at least {@code fasterRuns} times out of {@code totalRuns}.
     * If not, {@code AssertionFailedError} with supplied {@code message} is thrown.
     *
     * @param f          - method under test
     * @param time       - expected running time of {@code f}
     * @param fasterRuns - minimal number of iterations, where {@code f} runs faster than {@code time}
     * @param totalRuns  - maximal number of iterations
     * @param message    - exception message
     */
    public static void assertRunsWithin(Runnable f, long time, int fasterRuns, int totalRuns, String message) {
        AssertRunsWithin.assertRunsWithin(f, time, fasterRuns, totalRuns, message);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds at least {@code fasterRuns} times out of {@code totalRuns}.
     * If not, {@code AssertionFailedError} is thrown.
     *
     * @param f          - method under test
     * @param time       - expected running time of {@code f}
     * @param fasterRuns - minimal number of iterations, where {@code f} runs faster than {@code time}
     * @param totalRuns  - maximal number of iterations
     */
    public static void assertRunsWithin(Runnable f, long time, int fasterRuns, int totalRuns) {
        AssertRunsWithin.assertRunsWithin(f, time, fasterRuns, totalRuns);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds in at least {@code percentage} of total runs (default = 10).
     * If not, {@code AssertionFailedError} with supplied {@code message} is thrown.
     *
     * @param f          - method under test
     * @param time       - expected running time of {@code f}
     * @param percentage - percentage of total runs (default = 10) that are expected to run faster than {@code time}
     * @param message    - exception message
     */
    public static void assertRunsWithin(Runnable f, long time, double percentage, String message) {
        AssertRunsWithin.assertRunsWithin(f, time, percentage, message);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds in at least {@code percentage} of total runs (default = 10).
     * If not, {@code AssertionFailedError} is thrown.
     *
     * @param f          - method under test
     * @param time       - expected running time of {@code f}
     * @param percentage - percentage of total runs (default = 10) that are expected to run faster than {@code time}
     */
    public static void assertRunsWithin(Runnable f, long time, double percentage) {
        AssertRunsWithin.assertRunsWithin(f, time, percentage);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds.
     * If not, {@code AssertionFailedError} with supplied {@code message} is thrown.
     *
     * @param f       - method under test
     * @param time    - expected running time of {@code f}
     * @param message - exception message
     */
    public static void assertRunsWithin(Runnable f, long time, String message) {
        AssertRunsWithin.assertRunsWithin(f, time, message);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds.
     * If not, {@code AssertionFailedError} is thrown.
     *
     * @param f    - method under test
     * @param time - expected running time of {@code f}
     */
    public static void assertRunsWithin(Runnable f, long time) {
        AssertRunsWithin.assertRunsWithin(f, time);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds in at least {@code percentage} out of {@code numberOfThreads} threads (default = 10).
     * If not, {@code AssertionFailedError} with supplied {@code message} is thrown.
     *
     * @param f               - method under test
     * @param time            - expected running time of {@code f}
     * @param numberOfThreads - total number of threads running {@code f} simultaneously (default = 10)
     * @param percentage      - percentage of threads (default = 10) that are expected to compute {@code f} faster than {@code time}
     * @param message         - exception message
     */
    public static void assertRunsWithinParallel(Runnable f, long time, int numberOfThreads, double percentage, String message) {
        AssertRunsWithinParallel.assertRunsWithinParallel(f, time, numberOfThreads, percentage, message);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds in at least {@code percentage} out of {@code numberOfThreads} threads (default = 10).
     * If not, {@code AssertionFailedError} is thrown.
     *
     * @param f               - method under test
     * @param time            - expected running time of {@code f}
     * @param numberOfThreads - total number of threads running {@code f} simultaneously (default = 10)
     * @param percentage      - percentage of threads (default = 10) that are expected to compute {@code f} faster than {@code time}
     */
    public static void assertRunsWithinParallel(Runnable f, long time, int numberOfThreads, double percentage) {
        AssertRunsWithinParallel.assertRunsWithinParallel(f, time, numberOfThreads, percentage);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds in at least {@code fasterRuns} out of {@code numberOfThreads} threads (default = 10).
     * If not, {@code AssertionFailedError} with supplied {@code message} is thrown.
     *
     * @param f               - method under test
     * @param time            - expected running time of {@code f}
     * @param numberOfThreads - total number of threads running {@code f} simultaneously (default = 10)
     * @param fasterRuns      - minimal number of threads out of {@code numberOfThreads} that are expected to compute {@code f} faster than {@code time} milliseconds (default = {@code numberOfThreads})
     * @param message         - exception message
     */
    public static void assertRunsWithinParallel(Runnable f, long time, int numberOfThreads, int fasterRuns, String message) {
        AssertRunsWithinParallel.assertRunsWithinParallel(f, time, numberOfThreads, fasterRuns, message);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds in at least {@code fasterRuns} out of {@code numberOfThreads} threads (default = 10).
     * If not, {@code AssertionFailedError} is thrown.
     *
     * @param f               - method under test
     * @param time            - expected running time of {@code f}
     * @param numberOfThreads - total number of threads running {@code f} simultaneously (default = 10)
     * @param fasterRuns      - minimal number of threads out of {@code numberOfThreads} that are expected to compute {@code f} faster than {@code time} milliseconds (default = {@code numberOfThreads})
     */
    public static void assertRunsWithinParallel(Runnable f, long time, int numberOfThreads, int fasterRuns) {
        AssertRunsWithinParallel.assertRunsWithinParallel(f, time, numberOfThreads, fasterRuns);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds in at least {@code percentage} out of {@code numberOfThreads} threads (default = 10).
     * If not, {@code AssertionFailedError} with supplied {@code message} is thrown.
     *
     * @param f          - method under test
     * @param time       - expected running time of {@code f}
     * @param percentage - percentage of threads that are expected to compute {@code f} faster than {@code time} (default = 1)
     * @param message    - exception message
     */
    public static void assertRunsWithinParallel(Runnable f, long time, double percentage, String message) {
        AssertRunsWithinParallel.assertRunsWithinParallel(f, time, percentage, message);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds in at least {@code percentage} out of {@code numberOfThreads} threads (default = 10).
     * If not, {@code AssertionFailedError} is thrown.
     *
     * @param f          - method under test
     * @param time       - expected running time of {@code f}
     * @param percentage - percentage of threads that are expected to compute {@code f} faster than {@code time} (default = 1)
     */
    public static void assertRunsWithinParallel(Runnable f, long time, double percentage) {
        AssertRunsWithinParallel.assertRunsWithinParallel(f, time, percentage);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds on {@code numberOfThreads} threads (default = 10).
     * If not, {@code AssertionFailedError} with supplied {@code message} is thrown.
     *
     * @param f               - method under test
     * @param time            - expected running time of {@code f}
     * @param numberOfThreads - total number of threads running {@code f} simultaneously (default = 10)
     * @param message         - exception message
     */
    public static void assertRunsWithinParallel(Runnable f, long time, int numberOfThreads, String message) {
        AssertRunsWithinParallel.assertRunsWithinParallel(f, time, numberOfThreads, message);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds on {@code numberOfThreads} threads (default = 10).
     * If not, {@code AssertionFailedError} is thrown.
     *
     * @param f               - method under test
     * @param time            - expected running time of {@code f}
     * @param numberOfThreads - total number of threads running {@code f} simultaneously (default = 10)
     */
    public static void assertRunsWithinParallel(Runnable f, long time, int numberOfThreads) {
        AssertRunsWithinParallel.assertRunsWithinParallel(f, time, numberOfThreads);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds on {@code numberOfThreads} threads (default = 10).
     * If not, {@code AssertionFailedError} with supplied {@code message} is thrown.
     *
     * @param f       - method under test
     * @param time    - expected running time of {@code f}
     * @param message - exception message
     */
    public static void assertRunsWithinParallel(Runnable f, long time, String message) {
        AssertRunsWithinParallel.assertRunsWithinParallel(f, time, message);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds on {@code numberOfThreads} threads (default = 10).
     * If not, {@code AssertionFailedError} is thrown.
     *
     * @param f    - method under test
     * @param time - expected running time of {@code f}
     */
    public static void assertRunsWithinParallel(Runnable f, long time) {
        AssertRunsWithinParallel.assertRunsWithinParallel(f, time);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds at least {@code fasterRuns} times out of {@code totalRuns}.
     * If {@code f} runs longer than {@code timeout}, it's interrupted.
     * If threshold is exceeded, {@code AssertionFailedError} with supplied {@code message} is thrown.
     *
     * @param f          - method under test
     * @param timeout    - expected running time of {@code f}
     * @param fasterRuns - minimal number of iterations, where {@code f} runs faster than {@code} time
     * @param totalRuns  - maximal number of iterations
     * @param message    - exception message
     */
    public static void assertRunsWithinTimeout(Runnable f, long timeout, int fasterRuns, int totalRuns, String message) {
        AssertRunsWithinTimeout.assertRunsWithinTimeout(f, timeout, fasterRuns, totalRuns, message);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds at least {@code fasterRuns} times out of {@code totalRuns}.
     * If {@code f} runs longer than {@code timeout}, it's interrupted.
     * If threshold is exceeded, {@code AssertionFailedError} is thrown.
     *
     * @param f          - method under test
     * @param timeout    - expected running time of {@code f}
     * @param fasterRuns - minimal number of iterations, where {@code f} runs faster than {@code} time
     * @param totalRuns  - maximal number of iterations
     */
    public static void assertRunsWithinTimeout(Runnable f, long timeout, int fasterRuns, int totalRuns) {
        AssertRunsWithinTimeout.assertRunsWithinTimeout(f, timeout, fasterRuns, totalRuns);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds in at least {@code percentage} out of {@code totalRuns}.
     * If {@code f} runs longer than {@code timeout}, it's interrupted.
     * If threshold is exceeded, {@code AssertionFailedError} with supplied {@code message} is thrown.
     *
     * @param f          - method under test
     * @param timeout    - expected running time of {@code f}
     * @param percentage - minimal percentage of runs that are expected to run in time no longer than {@code timeout} (default = 1)
     * @param message    - exception message
     */
    public static void assertRunsWithinTimeout(Runnable f, long timeout, double percentage, String message) {
        AssertRunsWithinTimeout.assertRunsWithinTimeout(f, timeout, percentage, message);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds in at least {@code percentage} out of {@code totalRuns}.
     * If {@code f} runs longer than {@code timeout}, it's interrupted.
     * If threshold is exceeded, {@code AssertionFailedError} is thrown.
     *
     * @param f          - method under test
     * @param timeout    - expected running time of {@code f}
     * @param percentage - minimal percentage of runs that are expected to run in time no longer than {@code timeout} (default = 1)
     */
    public static void assertRunsWithinTimeout(Runnable f, long timeout, double percentage) {
        AssertRunsWithinTimeout.assertRunsWithinTimeout(f, timeout, percentage);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds in at least {@code percentage} out of {@code totalRuns}.
     * If {@code f} runs longer than {@code timeout}, it's interrupted.
     * If threshold is exceeded, {@code AssertionFailedError} with supplied {@code message} is thrown.
     *
     * @param f       - method under test
     * @param timeout - expected running time of {@code f}
     * @param message - exception message
     */
    public static void assertRunsWithinTimeout(Runnable f, long timeout, String message) {
        AssertRunsWithinTimeout.assertRunsWithinTimeout(f, timeout, message);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds in at least {@code percentage} out of {@code totalRuns}.
     * If {@code f} runs longer than {@code timeout}, it's interrupted.
     * If threshold is exceeded, {@code AssertionFailedError} is thrown.
     *
     * @param f       - method under test
     * @param timeout - expected running time of {@code f}
     */
    public static void assertRunsWithinTimeout(Runnable f, long timeout) {
        AssertRunsWithinTimeout.assertRunsWithinTimeout(f, timeout);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds in at least {@code percentage} out of {@code numberOfThreads} threads (default = 10).
     * If {@code f} runs longer than {@code timeout} on any of the threads, it's interrupted.
     * If threshold is exceeded, {@code AssertionFailedError} with supplied {@code message} is thrown.
     *
     * @param f               - method under test
     * @param timeout         - expected running time of {@code f}
     * @param numberOfThreads - total number of threads running {@code f} simultaneously (default = 10)
     * @param percentage      - percentage of threads (default = 1) that are expected to compute {@code f} faster than {@code timeout}
     * @param message         - exception message
     */
    public static void assertRunsWithinParallelTimeout(Runnable f, long timeout, int numberOfThreads, double percentage, String message) {
        AssertRunsWithinParallelTimeout.assertRunsWithinParallelTimeout(f, timeout, numberOfThreads, percentage, message);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds in at least {@code percentage} out of {@code numberOfThreads} threads (default = 10).
     * If {@code f} runs longer than {@code timeout} on any of the threads, it's interrupted.
     * If threshold is exceeded, {@code AssertionFailedError} is thrown.
     *
     * @param f               - method under test
     * @param timeout         - expected running time of {@code f}
     * @param numberOfThreads - total number of threads running {@code f} simultaneously (default = 10)
     * @param percentage      - percentage of threads (default = 1) that are expected to compute {@code f} faster than {@code timeout}
     */
    public static void assertRunsWithinParallelTimeout(Runnable f, long timeout, int numberOfThreads, double percentage) {
        AssertRunsWithinParallelTimeout.assertRunsWithinParallelTimeout(f, timeout, numberOfThreads, percentage);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds at least {@code fasterRuns} out of {@code numberOfThreads} threads (default = 10).
     * If {@code f} runs longer than {@code timeout} on any of the threads, it's interrupted.
     * If threshold is exceeded, {@code AssertionFailedError} with supplied {@code message} is thrown.
     *
     * @param f               - method under test
     * @param timeout         - expected running time of {@code f}
     * @param numberOfThreads - total number of threads running {@code f} simultaneously (default = 10)
     * @param fasterRuns      - number of threads (default = {@code numberOfThreads}) that are expected to compute {@code f} faster than {@code timeout}
     * @param message         - exception message
     */
    public static void assertRunsWithinParallelTimeout(Runnable f, long timeout, int numberOfThreads, int fasterRuns, String message) {
        AssertRunsWithinParallelTimeout.assertRunsWithinParallelTimeout(f, timeout, numberOfThreads, fasterRuns, message);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds at least {@code fasterRuns} out of {@code numberOfThreads} threads (default = 10).
     * If {@code f} runs longer than {@code timeout} on any of the threads, it's interrupted.
     * If threshold is exceeded, {@code AssertionFailedError} is thrown.
     *
     * @param f               - method under test
     * @param timeout         - expected running time of {@code f}
     * @param numberOfThreads - total number of threads running {@code f} simultaneously (default = 10)
     * @param fasterRuns      - number of threads (default = {@code numberOfThreads} that are expected to compute {@code f} faster than {@code timeout}
     */
    public static void assertRunsWithinParallelTimeout(Runnable f, long timeout, int numberOfThreads, int fasterRuns) {
        AssertRunsWithinParallelTimeout.assertRunsWithinParallelTimeout(f, timeout, numberOfThreads, fasterRuns);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds in at least {@code percentage} out of {@code numberOfThreads} threads (default = 10).
     * If {@code f} runs longer than {@code timeout} on any of the threads, it's interrupted.
     * If threshold is exceeded, {@code AssertionFailedError} with supplied {@code message} is thrown.
     *
     * @param f               - method under test
     * @param timeout         - expected running time of {@code f}
     * @param percentage      - percentage of threads (default = 1) that are expected to compute {@code f} faster than {@code timeout}
     * @param message         - exception message
     */
    public static void assertRunsWithinParallelTimeout(Runnable f, long timeout, double percentage, String message) {
        AssertRunsWithinParallelTimeout.assertRunsWithinParallelTimeout(f, timeout, percentage, message);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds in at least {@code percentage} out of {@code numberOfThreads} threads (default = 10).
     * If {@code f} runs longer than {@code timeout} on any of the threads, it's interrupted.
     * If threshold is exceeded, {@code AssertionFailedError} is thrown.
     *
     * @param f               - method under test
     * @param timeout         - expected running time of {@code f}
     * @param percentage      - percentage of threads (default = 1) that are expected to compute {@code f} faster than {@code timeout}
     */
    public static void assertRunsWithinParallelTimeout(Runnable f, long timeout, double percentage) {
        AssertRunsWithinParallelTimeout.assertRunsWithinParallelTimeout(f, timeout, percentage);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds on {@code numberOfThreads} threads (default = 10).
     * If {@code f} runs longer than {@code timeout} on any of the threads, it's interrupted.
     * If threshold is exceeded, {@code AssertionFailedError} with supplied {@code message} is thrown.
     *
     * @param f               - method under test
     * @param timeout         - expected running time of {@code f}
     * @param numberOfThreads - total number of threads running {@code f} simultaneously (default = 10)
     * @param message         - exception message
     */
    public static void assertRunsWithinParallelTimeout(Runnable f, long timeout, int numberOfThreads, String message) {
        AssertRunsWithinParallelTimeout.assertRunsWithinParallelTimeout(f, timeout, numberOfThreads, message);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds on {@code numberOfThreads} threads (default = 10).
     * If {@code f} runs longer than {@code timeout} on any of the threads, it's interrupted.
     * If threshold is exceeded, {@code AssertionFailedError} is thrown.
     *
     * @param f               - method under test
     * @param timeout         - expected running time of {@code f}
     * @param numberOfThreads - total number of threads running {@code f} simultaneously (default = 10)
     */
    public static void assertRunsWithinParallelTimeout(Runnable f, long timeout, int numberOfThreads) {
        AssertRunsWithinParallelTimeout.assertRunsWithinParallelTimeout(f, timeout, numberOfThreads);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds on {@code numberOfThreads} threads (default = 10).
     * If {@code f} runs longer than {@code timeout} on any of the threads, it's interrupted.
     * If threshold is exceeded, {@code AssertionFailedError} with supplied {@code message} is thrown.
     *
     * @param f               - method under test
     * @param timeout         - expected running time of {@code f}
     * @param message         - exception message
     */
    public static void assertRunsWithinParallelTimeout(Runnable f, long timeout, String message) {
        AssertRunsWithinParallelTimeout.assertRunsWithinParallelTimeout(f, timeout, message);
    }

    /**
     * Asserts, that given {@code Runnable} runs within given {@code time} in milliseconds on {@code numberOfThreads} threads (default = 10).
     * If {@code f} runs longer than {@code timeout} on any of the threads, it's interrupted.
     * If threshold is exceeded, {@code AssertionFailedError} is thrown.
     *
     * @param f               - method under test
     * @param timeout         - expected running time of {@code f}
     */
    public static void assertRunsWithinParallelTimeout(Runnable f, long timeout) {
        AssertRunsWithinParallelTimeout.assertRunsWithinParallelTimeout(f, timeout);
    }

}
