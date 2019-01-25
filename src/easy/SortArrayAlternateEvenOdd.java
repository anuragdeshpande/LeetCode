package easy;

import java.util.Arrays;
import java.util.Stack;

/*
    Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
    Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
    You may return any answer array that satisfies this condition.

    Example 1:
    Input: [4,2,5,7]
    Output: [4,5,2,7]

    Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.

    Note:
    2 <= A.length <= 20000
    A.length % 2 == 0
    0 <= A[i] <= 1000
 */

public class SortArrayAlternateEvenOdd {
    public static void main(String[] args) {
        SortArrayAlternateEvenOdd tester = new SortArrayAlternateEvenOdd();
        System.out.println(Arrays.toString(tester.sortArrayByParityII(new int[]{4,2,5,7})));
    }

    /*
        Algorithm: Using sort stacks
        1. Create odd and even stacks to store the numbers by type
        2. for length of new array (equal to original given array)
            2.a if index is even pop even stack else pop odd stack
        3. return the new array
     */
    private int[] sortArrayByParityIIStacks(int[] A) {
        int mainArrayLength = A.length;
        Stack<Integer> evenStack = new Stack<>();
        Stack<Integer> oddStack = new Stack<>();
        int[] finalArray = new int[mainArrayLength];

        for(int number: A){
            if(number % 2 == 0){
                evenStack.push(number);
            } else {
                oddStack.push(number);
            }
        }

        for(int i=0; i<mainArrayLength; i++){
            finalArray[i] = i%2 == 0 ? evenStack.pop() : oddStack.pop();
        }

        return finalArray;
    }

    /*
        Algorithm: 2 Pass
        1. create new array equal to length of original array. create int indices for even and odd init at 0,1 resp.
        2. first pass on original array,
            2.a if number is even
                put it in new array at evenIndex and increment EvenIndex by 2
                else
                put it in new array at oddIndex and increment OddIndex by 2

     */
    private int[] sortArrayByParityII(int[] A) {
        int[] finalArray = new int[A.length];
        int evenindex = 0;
        int oddIndex = 1;
        for(int number: A){
            if(number % 2 == 0){
                finalArray[evenindex] = number;
                evenindex+=2;
            } else {
                finalArray[oddIndex] = number;
                oddIndex += 2;
            }
        }

        return finalArray;
    }


}
