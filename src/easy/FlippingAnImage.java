package easy;

import java.util.Arrays;
import java.util.Collections;

/*
    Given a binary matrix A, we want to flip the image horizontally,
    then invert it, and return the resulting image.
    To flip an image horizontally means that each row of the image is reversed.
    For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
    To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
    For example, inverting [0, 1, 1] results in [1, 0, 0].

    Example 1:
    Input: [[1,1,0],[1,0,1],[0,0,0]]
    Output: [[1,0,0],[0,1,0],[1,1,1]]
    Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
    Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]

    Example 2:
    Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
    Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
    Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
    Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]

    Notes:
    1 <= A.length = A[0].length <= 20
    0 <= A[i][j] <= 1
 */
public class FlippingAnImage {
    public static void main(String[] args) {
        FlippingAnImage tester = new FlippingAnImage();
        System.out.println(Arrays.deepToString(tester.flipAndInvertImage(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}})));
        System.out.println(Arrays.deepToString(tester.flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}})));
    }

    /*
        Algorithm:
        1. Invert each row in the matrix
        2. Compliment each number in the resultant matrix
        3. return the matrix
     */
    private int[][] flipAndInvertImage(int[][] A) {
        for (int[] row : A) {
            int rowLength = row.length - 1;

            // Horizontal Row Flip  - going only length/2 as swap is complete
            for (int i = 0; i < row.length / 2; i++) {
                int temp = row[i];
                row[i] = row[rowLength - i];
                row[rowLength - i] = temp;
            }

            // inverting each element in the row
            for (int i = 0; i < row.length; i++) {
                row[i] = row[i] == 0 ? 1 : 0;
            }
        }

        return A;
    }
}
