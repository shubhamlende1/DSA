package stackAndQueue;

import java.util.Stack;

/*

* */
public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str: tokens) {
            if(isOperator(str)) {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                stack.push(calculate(num2,num1,str));
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }

    private static int calculate(int num1 , int num2 , String operator) {
       return switch (operator) {
            case "/" -> num1/num2;
            case "*" -> num1*num2;
            case "-" -> num1 - num2;
            case "+" -> num1+num2;
           default -> throw new IllegalArgumentException("Invalid operator");
        };
    }
    private static boolean isOperator(String str) {
        return str.equals("/") || str.equals("*") || str.equals("-") || str.equals("+");
    }
    public static void main(String[] args) {

        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
