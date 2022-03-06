package StringCalculatorTest;
import StringCalculator.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    @Test
    public void returnZeroOnEmptuCalls() {

        int ans = StringCalculator.add("");
        assertEquals(0, ans);
    }
}
