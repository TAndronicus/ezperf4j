package ezperf;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AssertRunsWithinParallelTimeoutTest extends AbstractTest {

    @Test
    void shouldPassAndLastNoMoreThanTimeout() {
        long before = System.currentTimeMillis();
        AssertRunsWithinParallelTimeout.assertRunsWithinParallelTimeout(createRunable(100), 200, 10);
        assertTrue(System.currentTimeMillis() - before < 200);
    }

    @Test
    void shouldFailAndLastLessThanSequentialExecution() {
        String customMessage = "custom_message";
        long before = System.currentTimeMillis();
        assertThrows(
                AssertionFailedError.class,
                () -> AssertRunsWithinParallelTimeout.assertRunsWithinParallelTimeout(createRunable(3000), 200, 2, customMessage),
                customMessage);
        assertTrue(System.currentTimeMillis() - before < 3000);
    }

}
