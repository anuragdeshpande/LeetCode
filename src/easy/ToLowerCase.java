package easy;
/*
Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.

Example 1:

Input: "Hello"
Output: "hello"
Example 2:

Input: "here"
Output: "here"
Example 3:

Input: "LOVELY"
Output: "lovely"
 */
public class ToLowerCase {

    public static void main(String[] args) {
        ToLowerCase tester = new ToLowerCase();
        System.out.println(tester.toLowerCase("HeLlO"));
    }

    // Using utility Methods
    private String toLowerCaseUtility(String str) {
        return str.toLowerCase();
    }

    // Without Using utility Methods
    /*
    Algorithm:
        1. Iterate over each character in the string
        2. If the character is UpperCase
           2.a Add 32 (difference of 'a' - 97 and 'A' - 65) to push the character into lower case.
           2.b Add the result to the string builder
           else
           2.c No Conversion needed, just add the character to the string builder.
       3. Return the builder converted as string.
     */
    private String toLowerCase(String str) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0, len = str.length(); i < len; i++){
            char currentChar = str.charAt(i);
            if((currentChar >= 65 && currentChar <= 90)){
                currentChar += 32;
                builder.append(currentChar);
            } else {
                builder.append(currentChar);
            }
        }

        return builder.toString();
    }
}
