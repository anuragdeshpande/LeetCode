package easy;

/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:
Input: 123
Output: 321

Note:
Assume we are dealing with an environment which could only store integers within
the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that
your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger tester = new ReverseInteger();
        System.out.println(tester.reverse(-2147483648));
    }

    private int reverse(int x) {
        long op = 0;
        while(x!=0){
            op = op*10 + x % 10;
            x /= 10;
        }
        if(op> Integer.MAX_VALUE || op<Integer.MIN_VALUE)
            return 0;
        return (int)op;
    }
}
