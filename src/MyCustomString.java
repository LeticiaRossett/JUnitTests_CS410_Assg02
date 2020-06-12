//  | Author: Leticia Rossett
//  | Unit test cases to automate testing process in a program developed with agile principles.
//  | June 12th, 2020.

public class MyCustomString implements MyCustomStringInterface {
    private String string;

    @Override
    public String getString() {
        return this.string;
    }

    @Override
    public void setString(String string) {
        this.string = string;
    }

    @Override
    public int countNumbers() {
        String givenString = getString();

        //handles empty string
        if(givenString == null){ return 0; }
        int count = 0;
        boolean number = false;
        for(int i = 0; i<givenString.length(); i++){
            if(Character.isDigit(givenString.charAt(i))){
                if(!number){ //means there's a char that is not a number
                    number = true; //set to true, a number was found
                    count++; //increments count
                }
            }else{
                number = false; //no numbers were found
            }
        }
        return count; //return the amount of numbers found
    }

    @Override
    public  String removeEveryNthCharacter(int n, boolean maintainSpacing) {
        String  givenString = getString();

        //First check if there's any exception.
        if (n > givenString.length()) { throw new IndexOutOfBoundsException(); }
        if (n <= 0) { throw new IllegalArgumentException(); }

        String result = " ";
        StringBuilder modifiedString = new StringBuilder(givenString);

        if(maintainSpacing){ //if maintainSpace is true
            for(int i=n-1; i<givenString.length(); i+=n){
                modifiedString.setCharAt(i, ' '); //replace the char with a white space
            }
            result = modifiedString.toString();
        }else{ //when maintainSpace is false
            if(n == 1){
                result = ""; //if the number is, then every single char in the string will be empty
            }else{
                for(int j=n-1; j<givenString.length(); j+=n-1){
                    if(j<modifiedString.length()){
                        modifiedString.deleteCharAt(j); //delete the char at the position
                    }
                }
                result = modifiedString.toString(); //cast modifiedString to a String
            }
        }
        return result;
    }

    @Override
    public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) {
        String givenString = getString();

        //handle special cases
        if(givenString.equals(null)){ throw new NullPointerException(); }
        if(startPosition > endPosition || endPosition>givenString.length()) { throw new IndexOutOfBoundsException(); }
        if(startPosition <= endPosition && startPosition < 1) { throw new IllegalArgumentException(); }

        String modifiedString = "";
        String numberString = "";

        boolean beforeDigit = false; //boolean to check if previously it was a number
        for(int i=0; i<givenString.length(); i++) {
            if (i >= startPosition - 1 && i < endPosition) {
                if (Character.isDigit(givenString.charAt(i))) {
                    //switch cases for each number to string
                    switch (givenString.charAt(i)) {
                        case '0': numberString = "zero"; break;
                        case '1': numberString = "one"; break;
                        case '2': numberString = "two"; break;
                        case '3': numberString = "three"; break;
                        case '4': numberString = "four"; break;
                        case '5': numberString = "five"; break;
                        case '6': numberString = "six"; break;
                        case '7': numberString = "seven"; break;
                        case '8': numberString = "eight"; break;
                        case '9': numberString = "nine";
                    }
                    if(!beforeDigit){ //when number is not followed by another number
                        modifiedString+=numberString; //add current number to the string
                        beforeDigit = true; //set the boolean to true, means a number was just added
                    } else {
                        modifiedString+= '-'+numberString; //if there was a number before, then add the - to the next number
                        beforeDigit = true;
                    }
                } else { //keep adding the normal characters to the string
                    modifiedString += givenString.charAt(i);
                    beforeDigit = false;
                }
            } else {
                modifiedString += givenString.charAt(i);
            }
        }
        string = modifiedString;
    }
}
