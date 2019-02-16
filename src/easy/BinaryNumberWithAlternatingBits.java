package easy;

/*
    Given a positive integer, check whether it has alternating bits: namely,
    if two adjacent bits will always have different values.

    Example 1:
    Input: 5
    Output: True
    Explanation:
        The binary representation of 5 is: 101

    Example 2:
    Input: 7
    Output: False
    Explanation:
        The binary representation of 7 is: 111.

    Example 3:
    Input: 11
    Output: False
    Explanation:
        The binary representation of 11 is: 1011.

    Example 4:
    Input: 10
    Output: True
    Explanation:
        The binary representation of 10 is: 1010.
 */

public class BinaryNumberWithAlternatingBits {
    public static void main(String[] args) {
        BinaryNumberWithAlternatingBits tester = new BinaryNumberWithAlternatingBits();
        System.out.println(tester.hasAlternatingBits(5));
        System.out.println(tester.hasAlternatingBits(7));
        System.out.println(tester.hasAlternatingBits(11));
        System.out.println(tester.hasAlternatingBits(10));
    }

    /*
        Algorithm:
        1. Convert the number to binary representation
        2. For each character in the representation from index 1
            2.a check if the previous character is compliment of the current
            2.b return false if not
            2.c return true if end of loop
     */
    private boolean hasAlternatingBits(int n) {
        String binaryRepresentation = Integer.toBinaryString(n);
        char[] chars = binaryRepresentation.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            char previousNumber = (chars[i] == '0') ? '1' : '0';
            if(chars[i-1] != previousNumber){
                return false;
            }
        }

        return true;
    }
}
