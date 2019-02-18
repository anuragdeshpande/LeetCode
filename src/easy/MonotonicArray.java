package easy;

/*
    An array is monotonic if it is either monotone increasing or monotone decreasing.

    An array A is monotone increasing if for all i <= j, A[i] <= A[j].
    An array A is monotone decreasing if for all i <= j, A[i] >= A[j].

    Return true if and only if the given array A is monotonic.

    Example 1:
    Input: [1,2,2,3]
    Output: true

    Example 2:
    Input: [6,5,4,4]
    Output: true

    Example 3:
    Input: [1,3,2]
    Output: false

    Example 4:
    Input: [1,2,4,5]
    Output: true

    Example 5:
    Input: [1,1,1]
    Output: true

    Note:
    1 <= A.length <= 50000
    -100000 <= A[i] <= 100000
 */
public class MonotonicArray {
    public static void main(String[] args) {
        MonotonicArray tester = new MonotonicArray();
        System.out.println(tester.isMonotonic(new int[]{1, 2, 2, 3}));
        System.out.println(tester.isMonotonic(new int[]{1, 3, 2}));
        System.out.println(tester.isMonotonic(new int[]{6,5,4,4}));
        System.out.println(tester.isMonotonic(new int[]{1,1,0}));
        System.out.println(tester.isMonotonic(new int[]{1,1,1,1}));
    }

    /*
        Algorithm;
        1. if the array length is 1 then it is already sorted return true
        2. else compare first and last term in the array
            2.a if greater, check if the entire array is increasing or equal
            2.b if lesser, check if the entire array is decreasing or equal.
     */
    private boolean isMonotonic(int[] A) {
        if(A.length == 1) return true;
        return A[0] > A[A.length-1] ? isDecreasing(A) : isIncreasing(A);

    }

    private boolean isIncreasing(int[] a1){
        for (int i = 1; i < a1.length; i++) {
            if(a1[i] < a1[i-1]){
                return false;
            }
        }

        return true;
    }

    private boolean isDecreasing(int[] a1){
        for (int i = 1; i < a1.length; i++) {
            if(a1[i] > a1[i-1]){
                return false;
            }
        }

        return true;
    }


}
