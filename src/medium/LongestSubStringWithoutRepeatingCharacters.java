package medium;

/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.


Example 3:
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


 Solution:
 Construct String with each character until the repeat character is found, then save the length of the resultant
 String. repeat the process until end of string and return the max length of substring constructed.

 This approach resulted in 86.3% better result than all the submissions.
 */
public class LongestSubStringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubStringWithoutRepeatingCharacters tester = new LongestSubStringWithoutRepeatingCharacters();
        System.out.println(tester.lengthOfLongestSubstring(""));
    }

    private int lengthOfLongestSubstring(String s) {
        StringBuilder nonRepeatString = new StringBuilder();
        int maxNonRepeatLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (!nonRepeatString.toString().contains(Character.toString(current))) {
                nonRepeatString.append(current);
            } else {
                String newString = nonRepeatString.substring(nonRepeatString.indexOf(Character.toString(current))+1);
                nonRepeatString = new StringBuilder(newString);
                nonRepeatString.append(current);
            }

            int newStringLength = nonRepeatString.length();
            maxNonRepeatLength = maxNonRepeatLength < newStringLength ? newStringLength : maxNonRepeatLength;
        }

        return maxNonRepeatLength;
    }
}


