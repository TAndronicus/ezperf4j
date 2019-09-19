package ezperf;

import org.opentest4j.AssertionFailedError;
import org.opentest4j.TestAbortedException;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class AssertionUtils {

    private static final String EMPTY_MESSAGE = "";
    private static final String RETHROW_MESSAGE = "Exception occurred during testing";

    static void fail(String message) {
        throw new AssertionFailedError(message);
    }

    static void fail() {
        fail(EMPTY_MESSAGE);
    }

    static void abort(Throwable t) {
        throw new TestAbortedException(RETHROW_MESSAGE, t);
    }

    static void runAsyncWithTimeout(Runnable f, long timeout, int fasterRuns, int totalRuns, String message) {
        runAsyncWithTimeout(f, timeout, fasterRuns, totalRuns, Executors.newSingleThreadExecutor(), () -> fail(message));
    }

    static void runAsyncWithTimeout(Runnable f, long timeout, int fasterRuns, int totalRuns) {
        runAsyncWithTimeout(f, timeout, fasterRuns, totalRuns, Executors.newSingleThreadExecutor(), AssertionUtils::fail);
    }

    static void runAsyncWithTimeout(Runnable f, long timeout, int fasterRuns, int totalRuns, Executor executor, Runnable fail) {
        int failedCount = 0;
        for (int i = 0; i < totalRuns; i++) {
            CompletableFuture task = CompletableFuture.runAsync(f, executor);
            try {
                task.get(timeout, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | ExecutionException e) {
                abort(e);
            } catch (TimeoutException e) {
                if (++failedCount > totalRuns - fasterRuns) fail.run();
            }
        }
    }

    static void assertRunsWithinConcurrent(Runnable f, long time, int numberOfThreads, int fasterRuns, int totalRuns, String message) {
        runAsyncWithoutTimeout(f, time, fasterRuns, totalRuns, Executors.newFixedThreadPool(numberOfThreads), () -> fail(message));
    }

    static void assertRunsWithinConcurrent(Runnable f, long time, int numberOfThreads, int fasterRuns, int totalRuns) {
        runAsyncWithoutTimeout(f, time, fasterRuns, totalRuns, Executors.newFixedThreadPool(numberOfThreads), AssertionUtils::fail);
    }

    static void runAsyncWithoutTimeout(Runnable f, long time, int fasterRuns, int totalRuns, Executor executor, Runnable fail) {
        int passed = 0;
        for (int i = 0; i < totalRuns; i++) {
            CompletableFuture task = CompletableFuture.runAsync(f, executor);
            long before = System.currentTimeMillis();
            try {
                task.get();
            } catch (InterruptedException | ExecutionException e) {
                abort(e);
            }
            if (System.currentTimeMillis() - before <= time) passed++;
            if (passed >= fasterRuns) return;
        }
        fail.run();
    }

    static void assertRunsWithinTimeoutConcurrent(Runnable f, long timeout, int numberOfThreads, int fasterRuns, int totalRuns, String message) {
        runAsyncWithoutTimeout(f, timeout, fasterRuns, totalRuns, Executors.newFixedThreadPool(numberOfThreads), () -> fail(message));
    }

    static void assertRunsWithinTimeoutConcurrent(Runnable f, long timeout, int numberOfThreads, int fasterRuns, int totalRuns) {
        runAsyncWithoutTimeout(f, timeout, fasterRuns, totalRuns, Executors.newFixedThreadPool(numberOfThreads), AssertionUtils::fail);
    }

}
