package StringCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    // private instance to enable singleton behaviour for the class
    private static StringParser stringParserObj = new StringParser();
    // the class has a private constructor so that it cannot be instantiated outside the class
    private StringParser() {}
    //Pattern to find out if custom delimeter is passed in the string
    private Pattern changeDelimeterPattern = Pattern.compile("^[/][/]*[\n]*");
    //Holds the delimeter in use
    private String delimeter = "";
    //Store the number string
    private String numberString = "";
    //get instance method to return the static instance of the class
    public static StringParser getInstance() {
        return stringParserObj;
    }
    // extracts and returns list of numbers based on the delimeter
    public List<String> getListOfNumbers() {
        //get the numberString
        String numberString = getNumberString();
        //populate the regex pattern for Splitting based on the delimeter
        Pattern pattern = Pattern.compile(this.delimeter);
        List<String> numberList = new ArrayList<String>();
        //extract the numbers from the String based on delimeter
        String [] numbers = numberString.split(String.valueOf(pattern));
        //convert the String Array to an ArrayList
        numberList = Arrays.asList(numbers);
        return numberList;
    }
    // extracts and returns the delimeter from the number String
    public void parseDelimeter(String numberString) {
        //set default delimeter
        delimeter = "[,\n]";
        //set default number string
        String numberStringUpdate = numberString;
        //if a change delimeter line is given then change the numberString and Delimeter Properties
        if (isChangeDelimeterPassed(numberString)) {
            //seperate the delimeter and the number string
            Matcher customDelimeterMatcher = Pattern.compile("//(.)\n(.*)").matcher(numberString);
            customDelimeterMatcher.matches();
            //extract the new delimeter symbol
            String delimeterSymbol = customDelimeterMatcher.group(1);
            //add option for New Line "\n" to the regular expression
            delimeter = "[" + delimeterSymbol + "\n]";
            //update the number string
            numberStringUpdate = customDelimeterMatcher.group(2);
        }
        //set the global properties for delimeter and number string
        setNumberString(numberStringUpdate);
        setDelimeter(delimeter);
    }
    //setter for delimeter property
    private void setDelimeter(String delimeter) {
        this.delimeter = delimeter;
    }
    //setter for number string property
    private void setNumberString(String numberString) {
        this.numberString = numberString;
    }
    //getter for delimeter property
    public String getDelimeter() {
        return this.delimeter;
    }
    //getter for number string property
    public String getNumberString() {
        return this.numberString;
    }
    //check if a change delimeter line is provided
    public boolean isChangeDelimeterPassed(String numberString) {
        return changeDelimeterPattern.matcher(numberString).find();
    }
}
