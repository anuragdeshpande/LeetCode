package easy;
/*
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        PalindromeNumber tester = new PalindromeNumber();
        System.out.println(tester.isPalindrome(121));

    }

    private boolean isPalindrome(int x) {
        if(x < 0) return false;

        String strNum = String.valueOf(x);
        String revNum = new StringBuilder(strNum).reverse().toString();

        return strNum.equals(revNum);

    }
}
