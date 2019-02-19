package easy;

/*
    Given a binary array, find the maximum number of consecutive 1s in this array.

    Example 1:
    Input: [1,1,0,1,1,1]
    Output: 3
    Explanation: The first two digits or the last three digits are consecutive 1s.
        The maximum number of consecutive 1s is 3.

    Note:
    The input array will only contain 0 and 1.
    The length of input array is a positive integer and will not exceed 10,000
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        MaxConsecutiveOnes tester = new MaxConsecutiveOnes();
        System.out.println(tester.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1,1,0,1,1,1}));
    }

    /*
        Algorithm:
            1. For each element in the given array
                1.a if the number is 1 increment counter else reset to 0;
                1.b if counter > maxCount reset maxCount to counter
                PS: because maxCount is set each time, the moment counter resets to 0,
                maxCount will have the last known count of 1's in that sequence
            2. return maxCount

     */
    private int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int counter = 0;
        for (int num : nums) {
            counter = (num == 1) ? counter + 1 : 0;
            maxCount = counter > maxCount ? counter : maxCount;
        }
        return maxCount;
    }
}
