package ezperf;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static ezperf.AssertRunsWithin.assertRunsWithin;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AssertRunsWithinTest extends AbstractTest {

    @Test
    void shouldPassWhenTimeoutNotExceeded() {
        long expectedTime = 2000L;
        long actualTime = 1000;
        assertRunsWithin(createRunable(actualTime), expectedTime);
    }

    @Test
    void shouldPassWhenTimeoutNotExceededMultipleTimes() {
        assertRunsWithin(createRunable(1000), 2000, 5, 10);
    }

    @Test
    void shouldFailWhenTimeExceeds() {
        assertThrows(
                AssertionFailedError.class,
                () -> assertRunsWithin(createRunable(2000), 1000)
        );
    }

    @Test
    void shouldFailWhenTimeExceedsMultipleTimes() {
        assertThrows(
                AssertionFailedError.class,
                () -> assertRunsWithin(createRunable(2000), 1000, 1, 10)
        );
    }

    @Test
    void shouldFailWhenTimeExceedsMultipleTimesWithCustomMessage() {
        final String customMessage = "custom_message";
        assertThrows(
                AssertionFailedError.class,
                () -> assertRunsWithin(createRunable(2000), 1000, 1, 10, customMessage),
                customMessage
        );
    }

}
