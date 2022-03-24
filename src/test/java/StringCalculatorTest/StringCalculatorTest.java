package StringCalculatorTest;

import StringCalculator.StringCalculator;
import StringCalculator.StringParser;

import StringCalculator.NegativeNumberException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {
    private StringParser stringParser = new StringParser();
    private StringCalculator stringCalculator= new StringCalculator(stringParser);

    @Test
    public void returnZeroOnEmptyCalls() throws NegativeNumberException {
        // Test 1: for empty string the addEmbeddedNumbers method should return zero
        int sum = 0;
        sum = stringCalculator.add("");
        assertEquals(0, sum);
    }

    @Test
    public void returnNumberForSingleDigitNumber() {
        // Test 2: for string having 1 single digit number the addEmbeddedNumbers method should return the number
        int sum = 0;
        sum = stringCalculator.add("5");
        assertEquals(5, sum);
    }

    @Test
    public void returnNumberForMultipleDigitNumber() {
        // Test 3: for string having 1 multiple digit number the addEmbeddedNumbers method should return the number
        int sum = 0;
        sum = stringCalculator.add("15");
        assertEquals(15, sum);
    }

    @Test
    public void returnSumForMultipleNumbers() {
        // Test 4: for string having multiple numbers the addEmbeddedNumbers method should return the sum
        int sum = 0;
        sum = stringCalculator.add("15,5,67,88");
        assertEquals(175, sum);
    }

    @Test
    public void returnSumForMultipleNumbersWithNewLine() {
        // Test 5: for string having multiple numbers with new line "\n" the addEmbeddedNumbers method should return the sum
        int sum = 0;
        sum = stringCalculator.add("15,5\n67,88");
        assertEquals(175, sum);
    }

    @Test
    public void returnSumForMultipleNumbersWithCustomDelimeter() {
        // Test 6: for string having multiple numbers with custom delimeter the addEmbeddedNumbers method should return the sum
        int sum = 0;
        sum = stringCalculator.add("//;\n1;2;3;4");
        assertEquals(10, sum);
    }

    @Test
    public void returnSumForNewLineAndCustomDelimeter() {
        // Test 7: for string having multiple numbers with custom delimeter and new line the addEmbeddedNumbers method should return the sum
        int sum = 0;
        sum = stringCalculator.add("//;\n1;2;3\n4");
        assertEquals(10, sum);
    }

    @Test
    public void throwExceptionForNegativeNumbers() {
        // Test 8: for string having negative numbers the negativeNumberException should be raised
        Exception exception = assertThrows(NegativeNumberException.class, () -> {
            int sum = stringCalculator.add("//;\n1;2;-3\n-4");
        });

        String expectedMessage = "negatives not allowed";
        String actualMessage = exception.getMessage();
        System.out.println(actualMessage);
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @InjectMocks
    StringCalculator stringCalculatorMock;

    @Test
    public void testAddMethodWithoutParser() {
        //Test 9 :
        int sum = 0;
        List<String> numberList = new ArrayList<String>();
        numberList.add("1");
        numberList.add("2");
        numberList.add("3");
        numberList.add("4");

        StringParser stringParser = Mockito.mock(StringParser.class);


        stringCalculatorMock = new StringCalculator(stringParser);
        Mockito.when(stringParser.getListOfNumbers("//;\n1;2;3\n4")).thenReturn(numberList);

        sum = stringCalculatorMock.add("//;\n1;2;3\n4");
        Mockito.verify(stringParser.getListOfNumbers("//;\n1;2;3\n4"));
        assertEquals(10, sum);
    }

}
