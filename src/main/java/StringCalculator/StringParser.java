package StringCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringParser {
    // private instance to enable singleton behaviour for the class
    private static StringParser stringParserObj = new StringParser();
    // the class has a private constructor so that it cannot be instantiated outside the class
    private StringParser() {}
    //get instance method to return the static instance of the class
    public static StringParser getInstance() {
        return stringParserObj;
    }
    // extracts and returns list of numbers based on the delimeter
    public List<String> getListOfNumbers(String numberString, String delimeter) {
        List<String> numberList = new ArrayList<String>();
        String [] numbers = numberString.split(",");
        numberList = Arrays.asList(numbers);
        return numberList;
    }
    // extracts and returns the delimeter from the number String
    public String getDelimeter(String numberString) {
        String delimeter = ",";
        return delimeter;
    }
}
