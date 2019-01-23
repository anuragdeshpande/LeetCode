package easy;

import java.util.Arrays;

/*
    Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

    Example 1:
    Input: [1,4,3,2]
    Output: 4

    Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
    Note:
    n is a positive integer, which is in the range of [1, 10000].
    All the integers in the array will be in the range of [-10000, 10000].
 */

public class ArrayPairSum {

    public static void main(String[] args) {
        ArrayPairSum tester = new ArrayPairSum();
        System.out.println(tester.arrayPairSum(new int[]{1, 4, 3, 2}));
    }

    /*
        Algorithm:
            1. Sort the array (This took a lot of observation, but when sorted in natural order, the consecutive pairs are direct sequence of pairing)
                1.a initiate a variable to store the incremental total over the array.
            2. For Every 2 items in the array consecutively
                2.a get min of the numbers
                2.b add the result to the total variable
            3. return total.
     */
    private int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int total = 0;
        for (int i = 0; i < nums.length; i = i+2){
            total+=Math.min(nums[i],  nums[i+1]);
        }

        return total;
    }

}
