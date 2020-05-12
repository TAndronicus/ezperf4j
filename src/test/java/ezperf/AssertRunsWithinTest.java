package ezperf;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.assertThrows;

class AssertRunsWithinTest extends AbstractTest {

    @Test
    void shouldPassWhenTimeoutNotExceeded() {
        long expectedTime = 2000L;
        long actualTime = 1000;
        AssertRunsWithin.assertRunsWithin(createRunable(actualTime), expectedTime);
    }

    @Test
    void shouldPassWhenTimeoutNotExceededMultipleTimes() {
        AssertRunsWithin.assertRunsWithin(createRunable(1000), 2000, 5, 10);
    }

    @Test
    void shouldFailWhenTimeExceeds() {
        assertThrows(
                AssertionFailedError.class,
                () -> AssertRunsWithin.assertRunsWithin(createRunable(2000), 1000)
        );
    }

    @Test
    @Timing(800)
    void shouldPassWhenFaterThanDurationDeclared() {
        createRunable(700).run();
    }

    @Test
    void shouldFailWhenTimeExceedsMultipleTimes() {
        assertThrows(
                AssertionFailedError.class,
                () -> AssertRunsWithin.assertRunsWithin(createRunable(2000), 1000, 1, 10)
        );
    }

    @Test
    void shouldFailWhenTimeExceedsMultipleTimesWithCustomMessage() {
        final String customMessage = "custom_message";
        assertThrows(
                AssertionFailedError.class,
                () -> AssertRunsWithin.assertRunsWithin(createRunable(2000), 1000, 1, 10, customMessage),
                customMessage
        );
    }

}
