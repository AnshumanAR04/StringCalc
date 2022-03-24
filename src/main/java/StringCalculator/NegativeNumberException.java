package StringCalculator;

public class NegativeNumberException extends RuntimeException{
    public NegativeNumberException (String errorMessage) {
        super(errorMessage);
    }
}
