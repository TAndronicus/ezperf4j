package ezperf;

import org.opentest4j.AssertionFailedError;

class AssertionUtils {

    private static final String EMPTY_MESSAGE = "";
    private static final String RETHROW_MESSAGE = "Exception occurred during testing";

    static void fail(String message) {
        throw new AssertionFailedError(message);
    }

    static void fail() {
        fail(EMPTY_MESSAGE);
    }

    static void fail(Throwable t) {
        throw new AssertionFailedError(RETHROW_MESSAGE, t);
    }
}
