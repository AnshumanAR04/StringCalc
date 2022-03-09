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
    @Test
    public void returnNumberForMultipleDigitNumber() {
        // Test 3: for string having 1 multiple digit number the addEmbeddedNumbers method should return the number
        int sum = StringCalculator.addEmbeddedNumbers("15");
        assertEquals(15, sum);
    }
    @Test
    public void returnSumForMultipleNumbers() {
        // Test 4: for string having multiple numbers the addEmbeddedNumbers method should return the sum
        int sum = StringCalculator.addEmbeddedNumbers("15,5,67,88");
        assertEquals(175, sum);
    }
    @Test
    public void returnSumForMultipleNumbersWithNewLine() {
        // Test 5: for string having multiple numbers with new line "\n" the addEmbeddedNumbers method should return the sum
        int sum = StringCalculator.addEmbeddedNumbers("15,5\n67,88");
        assertEquals(175, sum);
    }
    @Test
    public  void returnSumForMultipleNumbersWithCustomDelimeter() {
        // Test 6: for string having multiple numbers with custom delimeter the addEmbeddedNumbers method should return the sum
        int sum = StringCalculator.addEmbeddedNumbers("//;\n1;2;3;4");
        assertEquals(10, sum);
    }
    @Test
    public  void returnSumforNewLineAndCustomDelimeter() {
        // Test 7: for string having multiple numbers with custom delimeter and new line the addEmbeddedNumbers method should return the sum
        int sum = StringCalculator.addEmbeddedNumbers("//;\n1;2;3\n4");
        assertEquals(10, sum);
    }
    
}
