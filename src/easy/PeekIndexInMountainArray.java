package easy;

public class PeekIndexInMountainArray {

    public static void main(String[] args) {
        PeekIndexInMountainArray tester = new PeekIndexInMountainArray();
        System.out.println(tester.peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(tester.peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
    }

    private int peakIndexInMountainArray(int[] A) {
        int maxElement = 0;
        for (int i = 0; i < A.length; i++) {
            if(maxElement <= A[i]){
                maxElement = A[i];
            } else {
                return i-1;
            }
        }

        return -1;
    }
}
