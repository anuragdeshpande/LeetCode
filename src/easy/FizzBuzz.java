package easy;

import java.util.ArrayList;
import java.util.List;

/*
    Write a program that outputs the string representation of numbers from 1 to n.
    But for multiples of three it should output “Fizz” instead of the number and for
    the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

    Example:
    n = 15,
    Return:
    [
        "1",
        "2",
        "Fizz",
        "4",
        "Buzz",
        "Fizz",
        "7",
        "8",
        "Fizz",
        "Buzz",
        "11",
        "Fizz",
        "13",
        "14",
        "FizzBuzz"
    ]
 */
public class FizzBuzz {
    public static void main(String[] args) {
        FizzBuzz tester = new FizzBuzz();
        System.out.println(tester.fizzBuzz(15).toString());
    }

    /*
        Algorithm:
        1. for each indexed number
        if i%3 is 0 then add "Fizz"
        if i%5 is 0 then add "Buzz"
        if both then add "FizzBuzz"

        return lst
     */
    private List<String> fizzBuzz(int n) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String result = i+"";
            if(i % 3 == 0){
                result = "Fizz";
            }

            if( i%5 == 0){
                result = "Buzz";
            }

            if (i%3 == 0 && i%5 == 0){
                result = "FizzBuzz";
            }

            list.add(result);
        }

        return list;
    }
}
