package easy;

import com.sun.source.tree.Tree;

import java.util.*;

/*
    Given a string S, return the "reversed" string where all characters that are not a
    letter stay in the same place, and all letters reverse their positions.

    Example 1:
    Input: "ab-cd"
    Output: "dc-ba"

    Example 2:
    Input: "a-bC-dEf-ghIj"
    Output: "j-Ih-gfE-dCba"

    Example 3:
    Input: "Test1ng-Leet=code-Q!"
    Output: "Qedo1ct-eeLg=ntse-T!"

    Note:
    S.length <= 100
    33 <= S[i].ASCIIcode <= 122
    S doesn't contain \ or "
 */
public class ReverseOnlyLetters {
    public static void main(String[] args) {
        ReverseOnlyLetters tester = new ReverseOnlyLetters();
        System.out.println(tester.reverseOnlyLetters("ab-cd"));
        System.out.println(tester.reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(tester.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }

    /*
        Algorithm:
        1. convert string to character array
        2. for each character
            2.a if letter push to stack
        3. for each character in the string
            if letter pop the stack and add to result string (popping stack will automatically reverse the string)
            else add the character to the result string
     */
    private String reverseOnlyLetters(String S) {
        Stack<Character> letters = new Stack<>();
        for (char c: S.toCharArray())
            if (Character.isLetter(c))
                letters.push(c);

        StringBuilder ans = new StringBuilder();
        for (char c: S.toCharArray()) {
            if (Character.isLetter(c))
                ans.append(letters.pop());
            else
                ans.append(c);
        }

        return ans.toString();
    }
}
