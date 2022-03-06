package StringCalculator;

public class StringCalculator {
    public static int addEmbeddedNumbers(String numberList) {
        int sum = 0;
        if( numberList.length() == 0)
            sum = 0;
        else if (numberList.length() == 1 ) {
            sum = Integer.parseInt(String.valueOf(numberList.charAt(0)));
        }
        else if ( numberList.length() > 1 )
            for( char currentChar: numberList.toCharArray() )
            {
                 int currentDigit = Integer.parseInt(String.valueOf(currentChar));
                 sum = sum + ( currentDigit  * 10);

            }
        return sum;
    }
}
