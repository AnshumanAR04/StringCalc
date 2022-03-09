package StringCalculatorTest;
import StringCalculator.StringCalculator;
import StringCalculator.NegativeNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {
    @Test
    public void returnZeroOnEmptyCalls() {
        // Test 1: for empty string the addEmbeddedNumbers method should return zero
        int sum = 0;
        try {
            sum = StringCalculator.add("");
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }
        assertEquals(0, sum);
    }
    @Test
    public void returnNumberForSingleDigitNumber() {
        // Test 2: for string having 1 single digit number the addEmbeddedNumbers method should return the number
        int sum = 0;
        try {
            sum = StringCalculator.add("5");
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }
        assertEquals(5, sum);
    }
    @Test
    public void returnNumberForMultipleDigitNumber() {
        // Test 3: for string having 1 multiple digit number the addEmbeddedNumbers method should return the number
        int sum = 0;
        try {
            sum = StringCalculator.add("15");
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }
        assertEquals(15, sum);
    }
    @Test
    public void returnSumForMultipleNumbers() {
        // Test 4: for string having multiple numbers the addEmbeddedNumbers method should return the sum
        int sum = 0;
        try {
            sum = StringCalculator.add("15,5,67,88");
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }
        assertEquals(175, sum);
    }
    @Test
    public void returnSumForMultipleNumbersWithNewLine() {
        // Test 5: for string having multiple numbers with new line "\n" the addEmbeddedNumbers method should return the sum
        int sum = 0;
        try {
            sum = StringCalculator.add("15,5\n67,88");
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }
        assertEquals(175, sum);
    }
    @Test
    public  void returnSumForMultipleNumbersWithCustomDelimeter() {
        // Test 6: for string having multiple numbers with custom delimeter the addEmbeddedNumbers method should return the sum
        int sum = 0;
        try {
            sum = StringCalculator.add("//;\n1;2;3;4");
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }
        assertEquals(10, sum);
    }
    @Test
    public  void returnSumforNewLineAndCustomDelimeter() {
        // Test 7: for string having multiple numbers with custom delimeter and new line the addEmbeddedNumbers method should return the sum
        int sum = 0;
        try {
            sum = StringCalculator.add("//;\n1;2;3\n4");
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }
        assertEquals(10, sum);
    }
    @Test
    public  void throwExceptionForNegativeNumbers() {
        // Test 7: for string having multiple numbers with custom delimeter and new line the addEmbeddedNumbers method should return the sum
        Exception exception = assertThrows(NegativeNumberException.class, () -> {
            int sum = StringCalculator.add("//;\n1;2;-3\n-4");
        });

        String expectedMessage = "negatives not allowed";
        String actualMessage = exception.getMessage();
        System.out.println(actualMessage);
        assertTrue(actualMessage.contains(expectedMessage));
    }

}
