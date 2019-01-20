package easy;

import java.util.Arrays;

/*
    Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

    Example 1:
    Input: [-4,-1,0,3,10]
    Output: [0,1,9,16,100]

    Example 2:
    Input: [-7,-3,2,3,11]
    Output: [4,9,9,49,121]

    Note:
    1 <= A.length <= 10000
    -10000 <= A[i] <= 10000
    A is sorted in non-decreasing order.

 */

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        SquaresOfSortedArray tester = new SquaresOfSortedArray();
        System.out.println(Arrays.toString(tester.sortedSquares(new int[]{-7, -3, 2, 3, 11})));
        System.out.println(Arrays.toString(tester.sortedSquares(new int[]{-20})));
    }

    /*
        Algorithm: Very straight forward
            1. Create new array to store the elements
            2. for each element in the given array, square the element and store in new array at same index.
            3. Use Arrays.sort to sort the final array and return.
     */
    private int[] sortedSquares(int[] A) {
        int length = A.length;
        int[] squaredArray = new int[length];
        for (int i = 0; i < length; i++) {
            squaredArray[i] = A[i] * A[i];
        }

        Arrays.sort(squaredArray);

        return squaredArray;
    }
}
