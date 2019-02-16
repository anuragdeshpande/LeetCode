package easy;

import java.util.Arrays;
/*
    You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
    Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

    The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2.
    If it does not exist, output -1 for this number.

    Example 1:
    Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
    Output: [-1,3,-1]
    Explanation:
        For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
        For number 1 in the first array, the next greater number for it in the second array is 3.
        For number 2 in the first array, there is no next greater number for it in the second array, so output -1.

    Example 2:
    Input: nums1 = [2,4], nums2 = [1,2,3,4].
    Output: [3,-1]
    Explanation:
        For number 2 in the first array, the next greater number for it in the second array is 3.
        For number 4 in the first array, there is no next greater number for it in the second array, so output -1.

    Note:
    All elements in nums1 and nums2 are unique.
    The length of both nums1 and nums2 would not exceed 1000.
 */
public class NextGreaterElement1 {
    public static void main(String[] args) {
        NextGreaterElement1 tester = new NextGreaterElement1();
        System.out.println(Arrays.toString(tester.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        System.out.println(Arrays.toString(tester.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4})));
    }

    /*
        Algorithm:
        1. result array is always same length as nums1 array
        2. for each element in nums1
            2.a find the index of the same element in nums2
            2.b for each element at and after that index
                2.b.a find element in nums2 that is greater than the current element
                2.b.b return greaterElement if found else -1
            2.c assign the greater found element at index in the result array
            2.d return result array.
     */
    private int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = findGreaterNumberForNumberFromIndex(nums1[i], findIndex(nums1[i], nums2), nums2);
        }

        return result;

    }

    private int findGreaterNumberForNumberFromIndex(int number, int elementIndexInNums2, int[] nums2) {
        for (int index = elementIndexInNums2; index < nums2.length; index++){
            if(nums2[index] > number){
                return nums2[index];
            }
        }

        return -1;
    }

    private int findIndex(int numberToFind, int[] array){
        for (int i = 0; i < array.length; i++) {
            if(array[i] == numberToFind){
                return i;
            }
        }

        return -1;
    }
}
