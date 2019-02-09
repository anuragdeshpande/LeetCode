package easy;

import java.util.Arrays;

/*
    Given a string S and a character C, return an array of integers
    representing the shortest distance from the character C in the string.

    Example 1:
    Input: S = "loveleetcode", C = 'e'
    Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]

    Note:
    S string length is in [1, 10000].
    C is a single character, and guaranteed to be in string S.
    All letters in S and C are lowercase.


    Simple Explanation: replace every character in the given string with the closest distance to the given
    character in the string.

     *  1. put 0 at all position equals to e, and max at all other position
     *     we will get [max, max, max, 0, max, 0, 0, max, max, max, max, 0]
     *  2. scan from left to right, if i=max, skip, else dist[i+1] = Math.min(dp[i] + 1, dp[i+1]),
     *     we can get [max, max, max, 0, 1, 0, 0, 1, 2, 3, 4, 0]
     *  3. scan from right to left, use dp[i-1] = Math.min(dp[i] + 1, dp[i-1])
     *     we will get[3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 */

public class ShortestDistanceToCharacter {
    public static void main(String[] args) {
        ShortestDistanceToCharacter tester = new ShortestDistanceToCharacter();
        System.out.println(Arrays.toString(tester.shortestToChar("anuragdeshpande", 'e')));
    }

    /*
        Algorithm: 2 Pass algorithm: 97% better than other submissions
        init an array of same length as the string.
        First Pass: right to left
        1. if current letter is the desired character set the place to 0 else to -1
            at the end of this pass, all the indices where the corresponding index in the string is 0 and others is -1
        Second Pass: left to right
        1. for every position if the value is 0 reset distance to 1
            else
                if current value is -1 increment distance and assign the value at current index
                else if current value is greater than 1
                    increment distance
                    if value at index is greater than distance
                    replace current value with the distance

     */
    private int[] shortestToChar(String S, char C) {
        int stringLength = S.length();
        int[] initArray = new int[stringLength];

        // First pass
        int charIndex = -1;
        int distance = 0;
        for (int i = 0; i < stringLength; i++) {
            if (S.charAt(i) == C) {
                initArray[i] = 0;
                charIndex = i;
                distance = 0;
            } else {
                if (charIndex != -1) {
                    initArray[i] = ++distance;
                } else {
                    initArray[i] = -1;
                }
            }
        }

        // second pass
        for (int j = stringLength - 1; j >= 0; j--) {
            if (initArray[j] == 0) {
                distance = 0;
            } else {
                if (initArray[j] == -1) {
                    initArray[j] = ++distance;
                } else {
                    distance += 1;
                    if (distance <= initArray[j]) {
                        initArray[j] = distance;
                    }

                }
            }
        }

        return initArray;
    }
}
