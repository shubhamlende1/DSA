package stackAndQueue;


import java.util.Stack;

public class InfixPrefixPostfix {

    public static int precedence(char ch)
    {
        if (ch == '^')
            return 3;
        if (ch == '*' || ch == '/')
            return 2;
        if (ch == '+' || ch == '-')
            return 1;
        return -1;
    }

    public static String reverse(String str) {
        StringBuilder res = new StringBuilder();

        for (int i = str.length() - 1; i>=0; i--) {
            char current = str.charAt(i);

            if(current == '(') {
                res.append(")");
            } else if (current == ')') {
                res.append("(");
            } else {
                res.append(current);
            }
        }
        return res.toString();
    }
    public static String infixToPostfix(String str) {

        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i=0 ; i< str.length(); i++) {
            char current = str.charAt(i);

            if(Character.isLetterOrDigit(current)) {
                result.append(current);
            } else if (current == '(') {
                stack.push(current);
            } else if (current == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(current) <= precedence(stack.peek())){
                    result.append(stack.pop());
                }
                stack.push(current);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static String infixToPrefix(String str) {

        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        str = reverse(str);
        for (int i=0 ; i< str.length(); i++) {
            char current = str.charAt(i);

            if(Character.isLetterOrDigit(current)) {
                result.append(current);
            } else if (current == '(') {
                stack.push(current);
            } else if (current == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(current) < precedence(stack.peek())){
                    result.append(stack.pop());
                }
                stack.push(current);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }

    public static String postfixToInfix(String str) {
        Stack<String> stack = new Stack<>();

        for (int i =0 ; i< str.length(); i++) {
            char current = str.charAt(i);
            if(Character.isLetterOrDigit(current)) {
                stack.push(String.valueOf(current));
            } else {
                String res = "("+stack.pop() + current + stack.pop()+")";
                stack.push(res);
            }
        }

        return stack.pop();
    }

    public static String prefixToInfix(String str) {
        Stack<String> stack = new Stack<>();

        for (int i =str.length() -1 ; i >= 0 ; i--) {
            char current = str.charAt(i);
            if(Character.isLetterOrDigit(current)) {
                stack.push(String.valueOf(current));
            } else {
                String res = "("+stack.pop() + current + stack.pop()+")";
                stack.push(res);
            }
        }

        return stack.pop();
    }

    public static String postfixToPrefix(String str) {
        Stack<String> stack = new Stack<>();

        for (int i = 0 ; i < str.length() ; i++) {
            char current = str.charAt(i);
            if(Character.isLetterOrDigit(current)) {
                stack.push(String.valueOf(current));
            } else {
                String first = stack.pop();
                String second = stack.pop();
                String res = current +second +first;
                stack.push(res);
            }
        }

        return stack.pop();
    }

    public static String prefixToPostfix(String str) {
        Stack<String> stack = new Stack<>();

        for (int i =str.length() -1 ; i >= 0 ; i--) {
            char current = str.charAt(i);
            if(Character.isLetterOrDigit(current)) {
                stack.push(String.valueOf(current));
            } else {
                String first = stack.pop();
                String second = stack.pop();
                String res =  first + second +current;
                stack.push(res);
            }
        }

        return stack.pop();
    }
    public static void main(String[] args) {

        System.out.println("Infix: a*(b+c)/d   -- Postfix: "+infixToPostfix("a*(b+c)/d"));
        System.out.println("Infix: a+b*c+d   -- Postfix: "+infixToPostfix("a+b*c+d"));
        System.out.println("Infix: (a+b)*(c+d)   -- Postfix: "+infixToPostfix("(a+b)*(c+d)"));

        System.out.println("-----------------------------------------------------------");
        System.out.println("Infix: a*(b+c)/d   -- Prefix: "+infixToPrefix("a*(b+c)/d"));
        System.out.println("Infix: a+b*c+d   -- Prefix: "+infixToPrefix("a+b*c+d"));
        System.out.println("Infix: (a+b)*(c+d)   -- Prefix: "+infixToPrefix("(a+b)*(c+d)"));

        System.out.println("-----------------------------------------------------------");
        System.out.println("Postfix: abc+*d/   -- Infix: "+postfixToInfix("abc+*d/"));

        System.out.println("-----------------------------------------------------------");
        System.out.println("Prefix: /*a+bcd   -- Infix: "+prefixToInfix("/*a+bcd"));

        System.out.println("-----------------------------------------------------------");
        System.out.println("Postfix: abc+*d/   -- prefix: "+postfixToPrefix("abc+*d/"));

        System.out.println("-----------------------------------------------------------");
        System.out.println("Prefix: /*a+bcd   -- Postfix: "+prefixToPostfix("/*a+bcd"));

    }
}
