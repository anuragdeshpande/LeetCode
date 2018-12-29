package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Problem:
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Solution:
 *  1. BruteForce: The brute force approach is simple. Loop through each element xx and find if there is another value that equals to target - xtarget−x.
 *  2. Two-pass Hash Table
 *      To improve our run time complexity, we need a more efficient way to check if the complement exists in the array. If the complement exists, we need to look up its index. What is the best way to maintain a mapping of each element in the array to its index? A hash table.
 *      We reduce the look up time from O(n)O(n) to O(1)O(1) by trading space for speed. A hash table is built exactly for this purpose, it supports fast look up in near constant time. I say "near" because if a collision occurred, a look up could degenerate to O(n)O(n) time. But look up in hash table should be amortized O(1)O(1) time as long as the hash function was chosen carefully.
 *      A simple implementation uses two iterations. In the first iteration, we add each element's value and its index to the table. Then, in the second iteration we check if each element's complement (target - nums[i]target−nums[i]) exists in the table. Beware that the complement must not be nums[i]nums[i] itself!
 *  3. One-pass Hash Table
 *      It turns out we can do it in one-pass. While we iterate and inserting elements into the table, we also look back to check if current element's complement already exists in the table. If it exists, we have found a solution and return immediately.
 */
public class TwoSum {

    public static void main(String[] args) {
    }

    /*
        This is one pass hashmap solution to find the answer pair
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) return new int[0];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) return new int[]{i, map.get(diff)};
            map.put(nums[i], i);
        }
        return new int[0];
    }
}

