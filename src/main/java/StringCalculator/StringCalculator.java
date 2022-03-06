package StringCalculator;

public class StringCalculator {
    public static int addEmbeddedNumbers(String numberList) {
        int sum = 0;
        if( numberList.length() == 0)
            sum = 0;
        else
            sum = Integer.parseInt(String.valueOf(numberList.charAt(0)));
        return sum;
    }
}
