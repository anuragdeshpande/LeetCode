package easy;

import java.util.Arrays;

/*
    Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.
    Return any permutation(Number should not repeat) A of [0, 1, ..., N] such that for all i = 0, ..., N-1:

    If S[i] == "I", then A[i] < A[i+1]
    If S[i] == "D", then A[i] > A[i+1]

    Example 1:
    Input: "IDID"
    Output: [0,4,1,3,2]

    Example 2:
    Input: "III"
    Output: [0,1,2,3]

    Example 3:
    Input: "DDI"
    Output: [3,2,0,1]

    Note:
    1 <= S.length <= 10000
    S only contains characters "I" or "D".
 */

public class DIStringMatch {
    public static void main(String[] args) {
        DIStringMatch tester = new DIStringMatch();
        System.out.println(Arrays.toString(tester.diStringMatch("IDID")));
        System.out.println(Arrays.toString(tester.diStringMatch("III")));
        System.out.println(Arrays.toString(tester.diStringMatch("DDI")));
    }

    private int[] diStringMatch(String S) {
        int max = S.length();
        int[] mapper = new int[max+1];

        int low = 0;
        int high = max;

        for (int i = 0; i < max; ++i) {
            if(S.charAt(i) == 'I'){
                mapper[i] = low++;
            } else {
                mapper[i] = high--;
            }
        }

        mapper[max] = low;
        return mapper;
    }
}
