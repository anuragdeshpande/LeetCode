package easy;

import java.util.Arrays;

/*

    Simple Explanation:
    Given an array of 26 corresponding to each letter in english alphabet where each number in the array
    tells us the number of spaces corresponding alphabet will occupy in a line.
    Also given a string of characters

    calculate number of lines needed to print the string considering each letter in the string
    takes up the space according to the given array.

    Detailed Explanation:
    We are to write the letters of a given string S, from left to right into lines.
    Each line has maximum width 100 units, and if writing a letter would cause the width of the line
    to exceed 100 units, it is written on the next line. We are given an array widths, an array where widths[0]
    is the width of 'a', widths[1] is the width of 'b', ..., and widths[25] is the width of 'z'.

    Now answer two questions: how many lines have at least one character from S,
    and what is the width used by the last such line? Return your answer as an integer list of length 2.

    Example :

    Input:
    widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
    S = "abcdefghijklmnopqrstuvwxyz"
    Output: [3, 60]
    Explanation:
    All letters have the same length of 10. To write all 26 letters,
    we need two full lines and one line with 60 units.

    Example :
    Input:
    widths = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
    S = "bbbcccdddaaa"
    Output: [2, 4]
    Explanation:
    All letters except 'a' have the same length of 10, and
    "bbbcccdddaa" will cover 9 * 10 + 2 * 4 = 98 units.
    For the last 'a', it is written on the second line because
    there is only 2 units left in the first line.
    So the answer is 2 lines, plus 4 units in the second line.


    Note:

    The length of S will be in the range [1, 1000].
    S will only contain lowercase letters.
    widths is an array of length 26.
    widths[i] will be in the range of [2, 10].
 */
public class NumberOfLinesToWriteString {
    public static void main(String[] args) {
        NumberOfLinesToWriteString tester = new NumberOfLinesToWriteString();
        System.out.println(Arrays.toString(tester.numberOfLines(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "abcdefghijklmnopqrstuvwxyz")));
        System.out.println(Arrays.toString(tester.numberOfLines(new int[]{4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10}, "bbbcccdddaaa")));
    }

    /*
        Algorithm: 100% faster than all the other submissions
        1. For each character in the given string
            1.a as all letters in the string are lower case, widths[character - 97] will give us the space occupied by
                current character in the string.
            1.b if the space occupied by the current letter <= 100 then it is safe to put it in current line
                increment the wordCount
                else increment line count and initiate word count to current width
            1.c after all letters have been processed, if word count is greater than 0 that means there is a new line
                started but not reached 100 characters yet. so increment the lineCount to compensate for partially filled
                line
     */

    private int[] numberOfLines(int[] widths, String S) {
        int linesCount = 0;
        int wordCount = 0;

        for(char character: S.toCharArray()){
            int index = character - 97;
            int wordLength = widths[index];
            if(wordCount + wordLength <= 100){
                wordCount+=wordLength;
            } else {
                linesCount++;
                wordCount = wordLength;
            }
        }

        if(wordCount > 0){
            linesCount++;
        }
        return new int[]{linesCount, wordCount};
    }
}
