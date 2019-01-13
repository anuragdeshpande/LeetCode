package easy;

import java.util.*;
/*
    In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
    Return the element repeated N times.

    Example 1:
    Input: [1,2,3,3]
    Output: 3

    Example 2:
    Input: [2,1,2,5,3,2]
    Output: 2

    Example 3:
    Input: [5,1,5,2,5,3,5,4]
    Output: 5


    Note:

    4 <= A.length <= 10000
    0 <= A[i] < 10000
    A.length is even
 */
public class NRepeatElementIn2NArray {

    public static void main(String[] args) {
        NRepeatElementIn2NArray tester = new NRepeatElementIn2NArray();
        System.out.println(tester.repeatedNTimes(new int[]{1, 2, 3, 3}));
        System.out.println(tester.repeatedNTimes(new int[]{2, 1, 2, 5, 3, 2}));
        System.out.println(tester.repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
    }

    // case where the only repeated number is the desired number that is repeated N times.
    /*
        Algorithm: (Assumption: There is only one number repeated in entire array, and it is repeated N times.)
        1. Maintain a set for the numbers
        2. add each element in the array to the set
        3. if the result is false
            3.a Means there is a repeat element and assumption is made that this is the only element that is repeated
            3.b return the element
            else
            3.c continue
     */
    private int repeatedNTimes1NumOnly(int[] A){
        Set<Integer> seen = new HashSet<>();
        for(int num : A) { if(!seen.add(num)) { return num; } }

        return -1;
    }

    // Case where less than N reps are also considered.
    /*
        Algorithm: (Assumption: Array contains repeat elements, only 1 is repeated N times.)
        1. Maintain HashMap with the number as key and count as value
        2. For each element in the array
            2.a if key exists in map, get the value and increment
            2.b else add the num to the map and init the count to 1
        3. iterate over map
        4. if map-value (count) matches N element found - return
     */
    private int repeatedNTimes(int[] A) {
        int desiredRep = A.length/2;
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for(int num : A){
            if(numMap.containsKey(num)){
                int currentCount = numMap.get(num);
                currentCount++;
                numMap.put(num, currentCount);
            } else {
                numMap.put(num, 1);
            }
        }

        for (Map.Entry<Integer, Integer> next : numMap.entrySet()) {
            if(next.getValue() == desiredRep){
                return  next.getKey();
            }
        }

        return 0;
    }
}
