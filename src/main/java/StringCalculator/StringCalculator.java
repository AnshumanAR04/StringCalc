package StringCalculator;

import java.util.List;

public class StringCalculator {
    // add numbers present in the list
    public static int addNumbers(List<String> numberList) throws NegativeNumberException {
        int sum = 0;
        String negativNumberString = "";
        for (String number: numberList) {
            //convert the String to Integer
            int num = 0;
            num = Integer.parseInt(number);
            if(num < 0) {
                negativNumberString = negativNumberString + number + " ";
            }
            sum += num;
        }
        if(negativNumberString.length() > 0) {
            sum = 0;
            throw new NegativeNumberException("negatives not allowed " + negativNumberString);
        }
        return sum;
    }
    public static int add(String numberString) throws NegativeNumberException {
        if(numberString.length() == 0)
            return 0;
        //get instance of parser class
        StringParser stringParserObj = StringParser.getInstance();
        //get list of numbers from the number string
        List<String> numberList = stringParserObj.getListOfNumbers(numberString);
        int sum = 0;
        try {
            sum = addNumbers(numberList);
        }
        catch (NegativeNumberException negativeNumberException) {
            //propogate the exception
            throw negativeNumberException;
        }
        return sum;
    }

}
