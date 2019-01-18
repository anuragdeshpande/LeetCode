package easy;
/*
    Given an array nums and a value val,
    remove all instances of that value in-place and return the new length.
    Do not allocate extra space for another array, you must do this by modifying
    the input array in-place with O(1) extra memory.

    The order of elements can be changed. It doesn't matter what you leave beyond the new length.

    Example 1:
    Given nums = [3,2,2,3], val = 3,
    Your function should return length = 2, with the first two elements of nums being 2.
    It doesn't matter what you leave beyond the returned length.

    Example 2:
    Given nums = [0,1,2,2,3,0,4,2], val = 2,
    Your function should return length = 5,
    with the first five elements of nums containing 0, 1, 3, 0, and 4.

    Note that the order of those five elements can be arbitrary.

    It doesn't matter what values are set beyond the returned length.
    Clarification:
    Confused why the returned value is an integer but your answer is an array?
    Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

    Internally you can think of this:

    // nums is passed in by reference. (i.e., without making a copy)
    int len = removeElement(nums, val);

    // any modification to nums in your function would be known by the caller.
    // using the length returned by your function, it prints the first len elements.
    for (int i = 0; i < len; i++) {
        print(nums[i]);
    }
 */


public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement tester = new RemoveElement();
        System.out.println(tester.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
        System.out.println(tester.removeElement(new int[]{0,1,4,0,3,2,2,2}, 2));
        System.out.println(tester.removeElement(new int[]{2}, 2));
        System.out.println(tester.removeElement(new int[]{3}, 2));
        System.out.println(tester.removeElement(new int[]{3,3}, 3));
    }

    // protects the original data in the array
    /*
        Algorithm:
            initiate 2 index pointers. Head and Tail
            1. For Each element compare it with the value
            2. if they are same
                2.a Swap elements with the end element
                2.b decrement tail
                2.c compare the current element again
                   2.c.a if the current element is same as value swap with the tail element
                   2.c.b else increment head
               2.d if head == tail break and return head+1
     */
    private int removeElement(int[] nums, int val) {
        int length = nums.length;
        int head = 0;
        int tail = length-1;

        for (int i = 0; i < length; i++) {
            if(nums[i] == val){
                int temp = nums[i];
                nums[i] = nums[tail];
                nums[tail] = temp;
                tail--;
                if(nums[i] != val){
                    head++;
                } else {
                    i--;
                }
            } else {
                head++;
            }

            if(head > tail){
                return head;
            }
        }

        return head > 0 ? head + 1: head;
    }


    // Does not save the original data of the array. - Leet Code solution
    private int removeElementNonIntegral(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
