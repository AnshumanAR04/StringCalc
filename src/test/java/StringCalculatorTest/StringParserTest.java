package StringCalculatorTest;
import StringCalculator.StringParser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StringParserTest {
    StringParser stringParser = new StringParser();
    @Test
    public void returnNullForEmptyString() {
        // Test 1: for empty string the getListOfNumbers method should return null
        stringParser.setNumberString("");
        List<String> resultList = stringParser.getListOfNumbers();
        assertNull(resultList);

    }
    @Test
    public void returnSingleNumber() {
        // Test 2: for string having 1 number the getListOfNumbers method should return the number in list
        String numberString = "15";
        stringParser.setNumberString(numberString);
        List<String> resultList = stringParser.getListOfNumbers();
        List<String> expectedList = new ArrayList<>();
        expectedList.add("15");
        assertEquals(expectedList,resultList);
    }
    @Test
    public void returnListForMultipleNumbers() {
        // Test 3: for string having multiple numbers the getListOfNumbers method should return the numbers in list
        String numberString = "15,2,11";
        stringParser.setNumberString(numberString);
        List<String> resultList = stringParser.getListOfNumbers();
        List<String> expectedList = new ArrayList<>();
        expectedList.add("15");
        expectedList.add("2");
        expectedList.add("11");
        assertEquals(expectedList,resultList);
    }

    @Test
    public void returnListForStringWithNewLine() {
        // Test 4: for string having multiple numbers with line break the getListOfNumbers method should return the numbers in list
        String numberString = "15,2\n11,22";
        stringParser.setNumberString(numberString);
        List<String> resultList = stringParser.getListOfNumbers();
        List<String> expectedList = new ArrayList<>();
        expectedList.add("15");
        expectedList.add("2");
        expectedList.add("11");
        expectedList.add("22");
        assertEquals(expectedList,resultList);
    }
    @Test
    public  void returnListForStrWithCustDelimeter() {
        // Test 5: for string having multiple numbers with custom delimeter the getListOfNumbers method should return the numbers in list
        String numberString = "//;\n1;2;3;4";
        stringParser.setNumberString(numberString);
        List<String> resultList = stringParser.getListOfNumbers();
        List<String> expectedList = new ArrayList<>();
        expectedList.add("1");
        expectedList.add("2");
        expectedList.add("3");
        expectedList.add("4");
        assertEquals(expectedList,resultList);
    }
    @Test
    public  void returnListForStrWithNewLineAndCustDelimeter() {
        // Test 6: for string having multiple numbers with custom delimeter and new line the getListOfNumbers method should return the numbers in list
        String numberString = "//;\n1;2;3\n4";
        stringParser.setNumberString(numberString);
        List<String> resultList = stringParser.getListOfNumbers();
        List<String> expectedList = new ArrayList<>();
        expectedList.add("1");
        expectedList.add("2");
        expectedList.add("3");
        expectedList.add("4");
        assertEquals(expectedList,resultList);

    }
    @Test
    public  void returnListForNegativeNumbers() {
        // Test 7: for string having negative numbers with custom delimeter and new line the getListOfNumbers method should return the numbers in list
        String numberString = "//;\n1;2;-3\n-4";
        stringParser.setNumberString(numberString);
        List<String> resultList = stringParser.getListOfNumbers();
        List<String> expectedList = new ArrayList<>();
        expectedList.add("1");
        expectedList.add("2");
        expectedList.add("-3");
        expectedList.add("-4");
        assertEquals(expectedList,resultList);

    }
    @Test
    public void setNumberString() {
        String numberString = "//;\n1;2;-3\n-4";
        stringParser.setNumberString(numberString);
        assertEquals(numberString,stringParser.getNumberString());
    }
    @Test
    public void setDelimeter() {
        String delimeter = "[,\n]";
        stringParser.setDelimeter(delimeter);
        assertEquals(delimeter,stringParser.getDelimeter());
    }
    @Test
    public void checkDelimeterParsing() {
        String numberString = "//;\n1;2;-3\n-4";
        String delimeter = "[;\n]";
        stringParser.setNumberString(numberString);
        stringParser.parseDelimeter();
        assertEquals(delimeter,stringParser.getDelimeter());
    }
    @Test
    public void checkChangeDelimeterRequested() {
        String numberString = "//;\n1;2;-3\n-4";
        assertTrue(stringParser.isChangeDelimeterPassed(numberString));

    }
    @Test
    public void checkChangeDelimeterNotRequested() {
        String numberString = "15,2\n11,22";
        assertFalse(stringParser.isChangeDelimeterPassed(numberString));

    }

}
