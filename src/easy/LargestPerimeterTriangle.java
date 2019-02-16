package easy;

import java.util.Arrays;

/*
    Given an array A of positive lengths, return the largest perimeter of a triangle with non-zero area,
    formed from 3 of these lengths.
    If it is impossible to form any triangle of non-zero area, return 0.

    Example 1:                          Example 2:
    Input: [2,1,2]                      Input: [1,2,1]
    Output: 5                           Output: 0

    Example 3:                          Example 4:
    Input: [3,2,3,4]                    Input: [3,6,2,3]
    Output: 10                          Output: 8
 */

public class LargestPerimeterTriangle {
    public static void main(String[] args) {
        LargestPerimeterTriangle tester = new LargestPerimeterTriangle();
        System.out.println(tester.largestPerimeter(new int[]{2, 1, 2}));
        System.out.println(tester.largestPerimeter(new int[]{1,2,1}));
        System.out.println(tester.largestPerimeter(new int[]{3,2,3,4}));
        System.out.println(tester.largestPerimeter(new int[]{3,6,2,3}));
    }

    /*
        Largest perimeter is formed with the largest sides.
        Main rule for triangle sum of 2 sides is always greater than the 3rd side.

        Algorithm:
        1. Sort the array to put the largest sides at the end
        2. For each set of 3 elements from the end
            2.a if sum of first 2 is greater than the last (element1 + element2 > element3)
            2.b triangle edge found return
        3. return 0 as no triangle could be formed.

     */
    private int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 3; i>=0; --i){
            if(A[i] + A[i+1] > A[i+2]){
                return A[i] + A[i+1] + A[i+2];
            }
        }

        return 0;
    }
}
