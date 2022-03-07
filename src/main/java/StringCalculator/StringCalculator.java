package StringCalculator;

import java.util.List;

public class StringCalculator {
    public static int addNumbers(List<String> numberList) {
        int sum = 0;
        for (String number: numberList) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
    public static int addEmbeddedNumbers(String numberString) {
        StringParser stringParserObj = StringParser.getInstance();

        String delimeter = stringParserObj.getDelimeter(numberString);
        List<String> numberList = stringParserObj.getListOfNumbers(numberString, delimeter);
        int sum = addNumbers(numberList);

        return sum;

    }

}
