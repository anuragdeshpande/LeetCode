package easy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
/*
    Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
    You may return any answer array that satisfies this condition.

    Example 1:
    Input: [3,1,2,4]
    Output: [2,4,3,1]

    The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */
public class SortArrayByParity {

    public static void main(String[] args) {
        SortArrayByParity tester = new SortArrayByParity();
        System.out.println(Arrays.toString(tester.sortArrayByParity(new int[]{3, 1, 2, 4})));
    }

    /*
        Algorithm (Very Efficient): 97.99% efficient solution than others on leet code.
        1. create new array with same length as given.
        2. init two index pointers: Even: 0, Odd: length -1
        3. For each element in the given array
            3.a if even newArray[evenIdx] = element from array (insert at head)
            3.b increment evenIdx - moving forward in the new array
            3.c else newArray[OddIdx] = element from array (insert at tail)
            3.c decrement oddIdx - moving backwards from the end in new array
        4. return new array
     */
    private int[] sortArrayByParityPrimitive(int[] A){
        int arrayLength = A.length;
        int[] sortedArray = new int[arrayLength];
        int indexEven = 0;
        int indexOdd = arrayLength - 1;

        for(int num: A){
            if(num % 2 == 0){
                sortedArray[indexEven] = num;
                indexEven ++;
            } else {
                sortedArray[indexOdd] = num;
                indexOdd --;
            }
        }

        return sortedArray;
    }


    /*
    Algorithm (Not very efficient):
        1. Using Queue so that we can insert numbers at both ends.
        2. for each element in the array
            2.a if the element is even insert at head
            2.b else insert at tail
        3. map each element in the queue to int and return as array
     */
    private int[] sortArrayByParity(int[] A) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for(int num: A){
            if(num%2 == 0){
                dq.addFirst(num);
            } else {
                dq.addLast(num);
            }
        }

        return dq.stream().mapToInt(Integer::intValue).toArray();
    }


}
