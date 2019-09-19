package ezperf;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.assertThrows;

class AssertRunsWithinParallelTest extends AbstractTest {

    @Test
    void shouldPassWhenFasterOnMultipleThreads() {
        AssertRunsWithinParallel.assertRunsWithinParallel(createRunable(1000), 2000L);
    }

    @Test
    void shouldThrowWhenExceedsOnMultipleThreads() {
        String customMessage = "custom_message";
        assertThrows(
                AssertionFailedError.class,
                () -> AssertRunsWithinParallel.assertRunsWithinParallel(createRunable(2000), 1000L, 10, customMessage),
                customMessage
        );
    }

}
