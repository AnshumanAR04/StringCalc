package StringCalculatorTest;

import StringCalculator.NegativeNumberException;
import StringCalculator.StringCalculator;
import StringCalculator.StringParser;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class StringCalculatorTest {


    private final StringParser mock = mock(StringParser.class);

    @InjectMocks StringCalculator stringCalculator = new StringCalculator(mock);
    @Test
    public void returnZeroOnEmptyCalls() throws NegativeNumberException {
        // Test 1: for empty string the addEmbeddedNumbers method should return zero

        int sum = stringCalculator.add("");
        assertEquals(0, sum);
    }
    @Test
    public void returnSumForStringOfNumbers() throws NegativeNumberException{
        // Test 2: for string of numbers the add method should return the number
        final List<String> list = new ArrayList<>();
        list.add("5");
        list.add("15");
        Mockito.doNothing().when(mock).setNumberString("5,15");
        Mockito.when(mock.getListOfNumbers()).thenReturn(list);
        int sum = stringCalculator.add("5,15");

        Mockito.verify(mock).setNumberString("5,15");
        Mockito.verify(mock).getListOfNumbers();
        assertEquals(20, sum);
    }

    @Test
    public  void throwExceptionForNegativeNumbers() {
        // Test 3: for string having negative numbers the negativeNumberException should be raised

        final List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("-3");
        list.add("-4");
        Mockito.doNothing().when(mock).setNumberString("//;\n1;2;-3\n-4");
        Mockito.when(mock.getListOfNumbers()).thenReturn(list);
        Exception exception = assertThrows(NegativeNumberException.class, () -> stringCalculator.add("//;\n1;2;-3\n-4"));
        Mockito.verify(mock).setNumberString("//;\n1;2;-3\n-4");
        Mockito.verify(mock).getListOfNumbers();

        String expectedMessage = "negatives not allowed";
        String actualMessage = exception.getMessage();
        System.out.println(actualMessage);
        assertTrue(actualMessage.contains(expectedMessage));
    }

}
