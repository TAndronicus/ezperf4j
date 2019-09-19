package ezperf;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AssertionUtilsTest extends AbstractTest {

    @Test
    void shouldPass() {
        AssertionUtils.assertRunsWithinConcurrent(createRunable(1000), 2000, 1, 1, 1);
    }

    @Test
    void shouldFailAndWait() {
        final long duration = 2000;
        final long before = System.currentTimeMillis();
        assertThrows(
                AssertionFailedError.class,
                () -> AssertionUtils.assertRunsWithinConcurrent(createRunable(duration), 1000, 1, 1, 1)
        );
        assertTrue(System.currentTimeMillis() - before > duration);
    }

    @Test
    void shouldFailAndTimeout() {
        final long duration = 2000;
        final long before = System.currentTimeMillis();
        assertThrows(
                AssertionFailedError.class,
                () -> AssertionUtils.assertRunsWithinTimeoutConcurrent(createRunable(duration), 1000, 1, 1, 1)
        );
        assertTrue(System.currentTimeMillis() - before < duration);
    }

}
