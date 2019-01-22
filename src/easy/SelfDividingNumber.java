package easy;

import java.util.ArrayList;
import java.util.List;

/*
    A self-dividing number is a number that is divisible by every digit it contains.
    For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
    Also, a self-dividing number is not allowed to contain the digit zero.

    Given a lower and upper number bound, output a list of every possible self dividing number,
    including the bounds if possible.

    Example 1:
    Input:
    left = 1, right = 22
    Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]

    Note:
    The boundaries of each input argument are 1 <= left <= right <= 10000.
 */

public class SelfDividingNumber {

    public static void main(String[] args) {
        SelfDividingNumber tester = new SelfDividingNumber();
        System.out.println(tester.selfDividingNumbers(66, 708).toString());
    }


    /*
        Algorithm:
            1. For each given number in that range
                1.a copy the number into another variable
                1.b divisor = copyNumber % 10 (Getting the last number) if not zero - return false if true
                1.c if number % divisor is not zero return false
                1.d else copyNumber = copyNumber/10 (removing last digit)
                1.e if copyNumber = 0 then the number is self dividing. return true
     */
    private List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)) {
                numbers.add(i);
            }
        }

        return numbers;
    }

    private boolean isSelfDividing(int number) {
        int numberCopy = number;
        while (numberCopy > 0) {
            int divisor = numberCopy % 10;
            if (divisor == 0 || number % divisor != 0) {
                return false;
            }

            numberCopy = numberCopy / 10;
        }

        return true;
    }
}
