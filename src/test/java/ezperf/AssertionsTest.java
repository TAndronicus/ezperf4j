package ezperf;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static ezperf.Assertions.assertRunsWithin;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AssertionsTest {

    private Runnable createRunable(long time) {
        return () -> {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }

    @Test
    void shouldPassWhenTimeoutNotExceeded() {
        assertRunsWithin(createRunable(1000), 2000);
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
