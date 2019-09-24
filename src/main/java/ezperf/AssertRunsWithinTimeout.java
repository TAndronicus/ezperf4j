package ezperf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Supplier;

class AssertRunsWithinTimeout {

    private static final int DEFAULT_RUN_COUNT = 10;
    private static final int SINGLE_RUN = 1;

    static void assertRunsWithinTimeout(Runnable f, long timeout, int fasterRuns, int totalRuns, Supplier<String> messageSupplier) {
        runAsyncWithTimeout(f, timeout, fasterRuns, totalRuns, Executors.newSingleThreadExecutor(), () -> AssertionUtils.fail(messageSupplier));
    }

    static void assertRunsWithinTimeout(Runnable f, long timeout, int fasterRuns, int totalRuns, String message) {
        runAsyncWithTimeout(f, timeout, fasterRuns, totalRuns, Executors.newSingleThreadExecutor(), () -> AssertionUtils.fail(message));
    }

    static void assertRunsWithinTimeout(Runnable f, long timeout, int fasterRuns, int totalRuns) {
        runAsyncWithTimeout(f, timeout, fasterRuns, totalRuns, Executors.newSingleThreadExecutor(), AssertionUtils::fail);
    }

    static void assertRunsWithinTimeout(Runnable f, long timeout, double percentage, int totalRuns, Supplier<String> messageSupplier) {
        assertRunsWithinTimeout(f, timeout, (int) Math.ceil(totalRuns * percentage), totalRuns, messageSupplier);
    }

    static void assertRunsWithinTimeout(Runnable f, long timeout, double percentage, int totalRuns, String message) {
        assertRunsWithinTimeout(f, timeout, (int) Math.ceil(totalRuns * percentage), totalRuns, message);
    }

    static void assertRunsWithinTimeout(Runnable f, long timeout, double percentage, int totalRuns) {
        assertRunsWithinTimeout(f, timeout, (int) Math.ceil(totalRuns * percentage), totalRuns);
    }

    static void assertRunsWithinTimeout(Runnable f, long timeout, double percentage, Supplier<String> messageSupplier) {
        assertRunsWithinTimeout(f, timeout, (int) Math.ceil(DEFAULT_RUN_COUNT * percentage), DEFAULT_RUN_COUNT, messageSupplier);
    }

    static void assertRunsWithinTimeout(Runnable f, long timeout, double percentage, String message) {
        assertRunsWithinTimeout(f, timeout, (int) Math.ceil(DEFAULT_RUN_COUNT * percentage), DEFAULT_RUN_COUNT, message);
    }

    static void assertRunsWithinTimeout(Runnable f, long timeout, double percentage) {
        assertRunsWithinTimeout(f, timeout, (int) Math.ceil(DEFAULT_RUN_COUNT * percentage), DEFAULT_RUN_COUNT);
    }

    static void assertRunsWithinTimeout(Runnable f, long timeout, Supplier<String> messageSupplier) {
        assertRunsWithinTimeout(f, timeout, SINGLE_RUN, SINGLE_RUN, messageSupplier);
    }

    static void assertRunsWithinTimeout(Runnable f, long timeout, String message) {
        assertRunsWithinTimeout(f, timeout, SINGLE_RUN, SINGLE_RUN, message);
    }

    static void assertRunsWithinTimeout(Runnable f, long timeout) {
        assertRunsWithinTimeout(f, timeout, SINGLE_RUN, SINGLE_RUN);
    }

    static void runAsyncWithTimeout(Runnable f, long timeout, int fasterRuns, int totalRuns, Executor executor, Runnable fail) {
        int failedCount = 0;
        for (int i = 0; i < totalRuns; i++) {
            CompletableFuture task = CompletableFuture.runAsync(f, executor);
            try {
                task.get(timeout, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | ExecutionException e) {
                AssertionUtils.abort(e);
            } catch (TimeoutException e) {
                if (++failedCount > totalRuns - fasterRuns) fail.run();
            }
        }
    }

}
