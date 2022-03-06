package StringCalculatorTest;
import StringCalculator.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    @Test
    public void returnZeroOnEmptyCalls() {

        int sum = StringCalculator.addEmbeddedNumbers("");
        assertEquals(0, sum);
    }
}
