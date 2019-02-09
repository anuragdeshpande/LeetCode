package easy;

/*
    Given a string, you need to reverse the order of characters in each word within a sentence
    while still preserving whitespace and initial word order.

    Example 1:
    Input: "Let's take LeetCode contest"
    Output: "s'teL ekat edoCteeL tsetnoc"

    Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */

public class ReverseWords3 {
    public static void main(String[] args) {
        ReverseWords3 tester = new ReverseWords3();
        System.out.println(tester.reverseWords("Let's take LeetCode contest"));
    }

    /*
        Algorithm:
        To preserve the spacing and the word order, string needs reversal at the word level
        Init a String Builder for storing the final string
        1. if it is empty string, return given string
        2. split the string at spaces
        3. for each word in the split
            3.a reverse the word using String builder
            3.b append the reverse word to the final string builder
            3.c append space to the string builder.
        4. return the final string builder as string and trim to remove any extra spaces at the end.
     */
    private String reverseWords(String s) {
        if(s.trim().length() == 0) return s;

        StringBuilder finalString = new StringBuilder();
        String[] words = s.split(" ");
        for(String word: words){
            StringBuilder temp = new StringBuilder(word);
            temp.reverse();
            finalString.append(temp).append(" ");
        }

        return finalString.toString().trim();
    }
}
