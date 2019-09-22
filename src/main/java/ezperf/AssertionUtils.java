package ezperf;

import org.opentest4j.AssertionFailedError;
import org.opentest4j.TestAbortedException;

class AssertionUtils {

    private static final String RETHROW_MESSAGE = "Exception occurred during testing";

    static void fail(String message) {
        throw new AssertionFailedError(message);
    }

    static void fail() {
        throw new AssertionFailedError();
    }

    static void abort(Throwable t) {
        throw new TestAbortedException(RETHROW_MESSAGE, t);
    }

}
