package StringCalculatorTest;
import StringCalculator.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    @Test
    public void returnZeroOnEmptyCalls() {
        // Test 1: for empty string the addEmbeddedNumbers method should return zero
        int sum = StringCalculator.addEmbeddedNumbers("");
        assertEquals(0, sum);
    }
    @Test
    public void returnNumberForSingleDigitNumber() {
        // Test 2: for string having 1 single digit number the addEmbeddedNumbers method should return the number
        int sum = StringCalculator.addEmbeddedNumbers("5");
        assertEquals(5, sum);
    }
    public void returnNumberForMultipleDigitNumber() {
        // Test 3: for string having 1 multiple digit number the addEmbeddedNumbers method should return the number
        int sum = StringCalculator.addEmbeddedNumbers("15");
        assertEquals(15, sum);
    }
}
