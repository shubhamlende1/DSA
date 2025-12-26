package stackAndQueue;

import java.util.Stack;

/*
20. Valid Parentheses
Easy
Topics
premium lock icon
Companies
Hint
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

Example 5:

Input: s = "([)]"

Output: false



Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
* */
public class ValidParentheses {

    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i< str.length(); i++) {
            char current = str.charAt(i);
            if(current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else {
                if(stack.isEmpty()) return false;
                else {
                    char top = stack.peek();
                    if((top == '(' && current == ')') || (top == '[' && current == ']') || (top == '{' && current == '}')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String str = "([{}])}";
        System.out.print(isValid(str));
    }
}
