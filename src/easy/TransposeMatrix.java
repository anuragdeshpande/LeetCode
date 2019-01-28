package easy;

import java.util.Arrays;


/*
    Given a matrix A, return the transpose of A.
    The transpose of a matrix is the matrix flipped over it's main diagonal,
    switching the row and column indices of the matrix.

    Example 1:
    Input: [[1,2,3],[4,5,6],[7,8,9]]
    Output: [[1,4,7],[2,5,8],[3,6,9]]

    Example 2:
    Input: [[1,2,3],[4,5,6]]
    Output: [[1,4],[2,5],[3,6]]

    Note:
    1 <= A.length <= 1000
    1 <= A[0].length <= 1000
 */
public class TransposeMatrix {
    public static void main(String[] args) {
        TransposeMatrix tester = new TransposeMatrix();
        System.out.println(Arrays.deepToString(tester.transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
        System.out.println(Arrays.deepToString(tester.transpose(new int[][]{{1, 2, 3}, {4, 5, 6}})));
    }

    /*
        Algorithm: inversion
        1. init new array with inverted row and column count
            #rows in original array = #columns in new array
            #columns in original array = #rows in new array
        2. for each element in row and column of original array becomes
            element in column,row of new array
            (new[column][row] = original[row][column])
     */
    private int[][] transpose(int[][] A) {
        int rows = A.length;
        int columns = A[0].length;

        int[][] transposeMatrix = new int[columns][rows];

        for (int row = 0; row < rows; row++){
            for(int column = 0; column < columns; column++){
                transposeMatrix[column][row] = A[row][column];
            }
        }

        return transposeMatrix;
    }
}
