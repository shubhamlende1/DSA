package stackAndQueue;

import java.util.Stack;

public class RemoveKDigits {

    public static String removeKDigits(String str, int k) {

        if(str.length() < k || str.length() == k) return "0";

        Stack<Integer> stack = new Stack<>();
        String res = "";
        for(char current : str.toCharArray()) {
            int c = Integer.parseInt(String.valueOf(current));

                if(k > 0 &&  !stack.isEmpty() &&  c < stack.peek()) {
                    stack.pop();
                    k--;
                }
                stack.push(c);
        }
            while (k > 0)
            {
                stack.pop();
                k--;
            }

            while (!stack.isEmpty()) {
                res = stack.pop()+res;
            }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(removeKDigits("1234567",3));
    }
}
