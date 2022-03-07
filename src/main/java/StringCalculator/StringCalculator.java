package StringCalculator;

import java.util.List;

public class StringCalculator {
    // add numbers present in the list
    public static int addNumbers(List<String> numberList) {
        int sum = 0;
        for (String number: numberList) {
            //convert the String to Integer
            sum += Integer.parseInt(number);
        }
        return sum;
    }
    public static int addEmbeddedNumbers(String numberString) {
        if(numberString.length() == 0)
            return 0;
        //get instance of parser class
        StringParser stringParserObj = StringParser.getInstance();
        //Parse the String for the delimeter
        stringParserObj.parseDelimeter(numberString);
        //get list of numbers from the number string
        List<String> numberList = stringParserObj.getListOfNumbers();
        int sum = addNumbers(numberList);
        return sum;
    }

}
