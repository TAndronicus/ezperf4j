package ezperf;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.assertThrows;

class AssertRunsWithinConcurrentTest extends AbstractTest {

    @Test
    void shouldPassWhenFasterOnMultipleThreads() {
        AssertRunsWithinConcurrent.assertRunsWithinConcurrent(createRunable(1000), 2000L);
    }

    @Test
    void shouldThrowWhenExceedsOnMultipleThreads() {
        String customMessage = "custom_message";
        assertThrows(
                AssertionFailedError.class,
                () -> AssertRunsWithinConcurrent.assertRunsWithinConcurrent(createRunable(2000), 1000L, 10, customMessage),
                customMessage
        );
    }

}
