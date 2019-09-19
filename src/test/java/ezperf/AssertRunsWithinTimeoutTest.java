package ezperf;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.*;

class AssertRunsWithinTimeoutTest extends AbstractTest {


    @Test
    void shouldPassWhenFaster() {
        AssertRunsWithinTimeout.assertRunsWithinTimeout(createRunable(1000L), 2000L);
    }
    @Test
    void shouldFailWithTimeout() {
        final long duration = 2000L;
        final String customMessage = "custom_message";
        long before = System.currentTimeMillis();
        assertThrows(
                AssertionFailedError.class,
                () -> AssertRunsWithinTimeout.assertRunsWithinTimeout(createRunable(duration), 1000L, customMessage),
                customMessage
        );
        assertTrue(duration > System.currentTimeMillis() - before);
    }

}
