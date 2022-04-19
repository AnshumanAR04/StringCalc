package StringCalculator;

import java.util.List;

public class StringCalculator {

    private final StringParser stringParser;
    public StringCalculator(StringParser stringParser) {
        this.stringParser = stringParser;
    }
    // add numbers present in the list
    private int addNumbers(List<String> numberList) throws NegativeNumberException {
        int sum = 0;
        StringBuilder negativNumberString = new StringBuilder();
        for (String number: numberList) {
            //convert the String to Integer
            int num = Integer.parseInt(number);
            if(num < 0) {
                negativNumberString.append(number).append(" ");
            }
            sum += num;
        }
        if(negativNumberString.length() > 0) {
            throw new NegativeNumberException("negatives not allowed " + negativNumberString);
        }
        return sum;
    }
    public int add(String numberString) throws NegativeNumberException {
        if(numberString.length() == 0)
            return 0;
        //get list of numbers from the number string
        stringParser.setNumberString(numberString);
        List<String> numberList = stringParser.getListOfNumbers();
        return addNumbers(numberList);
    }

}
