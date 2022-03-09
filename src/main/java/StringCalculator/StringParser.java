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
    public List<String> getListOfNumbers(String numberString) {
        //set the numberString
        setNumberString(numberString);
        parseDelimeter();
        numberString = getNumberString();
        //populate the regex pattern for Splitting based on the delimeter
        Pattern pattern = Pattern.compile(this.delimeter);
        List<String> numberList = new ArrayList<String>();
        //extract the numbers from the String based on delimeter
        String [] numbers = numberString.split(String.valueOf(pattern));
        // delete empty strings from the numbers array
         numbers = Arrays.stream(numbers)
                .filter(value ->
                        value != null && value.length() > 0
                )
                .toArray(size -> new String[size]);
        //convert the String Array to an ArrayList
        numberList = Arrays.asList(numbers);
        return numberList;
    }
    // extracts and returns the delimeter from the number String
    public void parseDelimeter() {
        String numberString = getNumberString();
        //set default delimeter
        delimeter = "[,\n]";
        //set default number string
        String numberStringUpdate = numberString;
        String [] splittedRows = numberString.split("\n");
        //if a change delimeter line is given then change the numberString and Delimeter Properties
        if (isChangeDelimeterPassed(splittedRows[0])) {
            //extract new delimeter symbol
            String delimeterSymbol = "";
            try{
                delimeterSymbol = splittedRows[0].substring(2);
            } catch (Exception e) {
                System.out.println("Substring function for extracting delimeter symbol failed");
            }
            //add option for New Line "\n" to the regular expression
            delimeter = "[" + delimeterSymbol + "\n]";
            //strip the first row from the numbserstring
            numberStringUpdate = numberString.substring(splittedRows[0].length());
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
        boolean delimeterChanged = false;
        try {
             delimeterChanged = changeDelimeterPattern.matcher(numberString).find();
         } catch (Exception e) {
             delimeterChanged = false;
             e.printStackTrace();
             System.out.println("The pattern match for new delimeter failed");
         }
        return delimeterChanged;
    }
}
