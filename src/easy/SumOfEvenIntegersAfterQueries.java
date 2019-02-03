package easy;

import java.util.Arrays;

/*
    We have an array A of integers, and an array queries of queries.
    For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].
    Then, the answer to the i-th query is the sum of the even values of A.

    (Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies the array A.)
    Return the answer to all queries.  Your answer array should have answer[i] as the answer to the i-th query.

    Example 1:
    Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
    Output: [8,6,2,4]

    Explanation:
    At the beginning, the array is [1,2,3,4].
    After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
    After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
    After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
    After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.
 */

public class SumOfEvenIntegersAfterQueries {
    public static void main(String[] args) {
        SumOfEvenIntegersAfterQueries tester = new SumOfEvenIntegersAfterQueries();
        System.out.println(Arrays.toString(tester.sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}})));
    }

    /*
        Algorithm: Direct Translation
        1. extract the logic to calculate the even sum of a given array
        2. For each pair (element) in the queries array
            2.a  element[0] is value to add
            2.b element[1] is the index at which value needs added in Array A
            2.c after adding the value pass the array to the extracted function to calculate sum of even numbers
            2.d save the sum of the even arrays in the result array for each element in queries array
        3. return queries array
     */
    private int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] result = new int[queries.length];
        int index = 0;
        for(int[] element : queries){
            int valToAdd = element[0];
            int indexToAdd = element[1];
            A[indexToAdd] += valToAdd;
            result[index] = sumOfEvens(A);
            index++;
        }

        return result;
    }

    private int sumOfEvens(int[] array){
        int sum = 0;
        for(int element: array){
            if(element % 2 == 0){
                sum+=element;
            }
        }

        return sum;
    }
}
