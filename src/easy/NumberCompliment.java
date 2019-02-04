package easy;

/*
    Given a positive integer, output its complement number.
    The complement strategy is to flip the bits of its binary representation.

    Note:
        1. The given integer is guaranteed to fit within the range of a 32-bit signed integer.
        2. You could assume no leading zero bit in the integer’s binary representation.

    Example 1:
    Input: 5
    Output: 2
    Explanation: The binary representation of 5 is 101 (no leading zero bits),
    and its complement is 010. So you need to output 2.

    Example 2:
    Input: 1
    Output: 0
    Explanation: The binary representation of 1 is 1 (no leading zero bits),
    and its complement is 0. So you need to output 0.
 */

public class NumberCompliment {
    public static void main(String[] args) {
        NumberCompliment tester = new NumberCompliment();
        System.out.println(tester.findComplement(5));
        System.out.println(tester.findComplement(1));
    }
    /*
        Algorithm: Using Java Libraries
        1. Convert number to Binary String (Integer.toBinary())
        2. For each character in the string
            2.a compliment (flip) each number and append to StringBuilder
            2.b return the compliment String
        3. return converted integer of the compliment String (Integer.parseInt(String, 2))
     */
    private int findComplement(int num) {
        return Integer.parseInt(binaryCompliment(Integer.toBinaryString(num)), 2);

    }

    private String binaryCompliment(String binaryNumber){
        StringBuilder builder = new StringBuilder();
        for(char character: binaryNumber.toCharArray()){
            builder.append(character == '1' ?'0' : '1');
        }

        return builder.toString();
    }

    /*
        Best solution submission on leetcode
     */
    private int comlumentByBitShift(int num){
        int complement = ~num;
        int n = num;
        int bitMask = 0xffffffff;
        while (n != 0) {
            bitMask = bitMask << 1;
            n = n >> 1;
        }

        return complement ^ bitMask;
    }
}
