package easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
Input: ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Note:
All given inputs are in lowercase letters a-z.
 */

public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix tester = new LongestCommonPrefix();
        System.out.println(tester.longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    /*
        Algorithm I tried to implement:
        1. Find the string with the least length of all (common prefix cannot be longer than that)
        2. loop for this min length
            2.a for each string in the array
                2.a.a compare one character at a time
                2.a.b increment match count variable every time there is a match on the tracking character
                2.a.c if the match count == total strings in array, that character is a common prefix, add to the prefix string builder
            2.b continue until end of min length string is reached or characters dont match - then return the string version of the builder.
     */
    private String longestCommonPrefix(String[] strs) {
        StringBuilder commonPrefix = new StringBuilder();
        int stringsLength = strs.length;
        if(stringsLength > 0){
            int minLength = strs[0].length();
            for(String str: strs){
                int strLength = str.length();
                if(strLength < minLength){
                    minLength = strLength;
                }
            }

            for (int i = 0; i < minLength; i++) {
                int matchCount = 0;
                char trackerChar = ' ';
                for (String str : strs) {
                    char currentChar = str.charAt(i);
                    if (trackerChar == ' ') {
                        trackerChar = currentChar;
                        matchCount++;
                        if (matchCount == stringsLength) {
                            commonPrefix.append(trackerChar);
                        }
                    } else {
                        if (trackerChar == currentChar) {
                            matchCount++;
                            if (matchCount == stringsLength) {
                                commonPrefix.append(trackerChar);
                            }
                        } else {
                            return commonPrefix.toString();
                        }
                    }
                }
            }

        }

        return commonPrefix.toString();
    }
}
