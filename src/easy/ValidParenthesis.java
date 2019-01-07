package easy;

import java.util.Stack;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:
Input: "()"
Output: true

Example 2:
Input: "()[]{}"
Output: true

Example 3:
Input: "(]"
Output: false

Example 4:
Input: "([)]"
Output: false

Example 5:
Input: "{[]}"
Output: true
 */

public class ValidParenthesis {
    public static void main(String[] args) {
        ValidParenthesis tester = new ValidParenthesis();
        System.out.println(tester.isValid(""));
    }

    /*
        I did not have an idea to start with, so read the hints portion to get the idea of stacks and matching pair
        Algorithm:
            1. For Every Open bracket push it on to stack
            2. For Every Close bracket if the top element is the corresponding open bracket, continue
                2.a if the top element is not corresponding open bracket, given expression is invalid, return false
            3. At the end of expression if the stack is empty the expression is valid or else invalid.
     */
    private boolean isValid(String s) {
        String[] split = s.split("");
        Stack<String> tracker = new Stack<>();
        for(String character: split){
            if(character.equals("(") || character.equals("{") || character.equals("[")){
                tracker.push(character);
            }

            if(character.equals(")")){
                if(hasClosingPair(tracker, "(")){
                    tracker.pop();
                } else {
                    return false;
                }
            }

            if(character.equals("}")){
                if(hasClosingPair(tracker, "{")){
                    tracker.pop();
                } else {
                    return false;
                }
            }

            if(character.equals("]")){
                if(hasClosingPair(tracker, "[")){
                    tracker.pop();
                } else {
                    return false;
                }
            }
        }

        return tracker.isEmpty();
    }

    private boolean hasClosingPair(Stack<String> tracker, String character){
        return !tracker.isEmpty() && tracker.peek().equals(character);
    }
}
