package stackAndQueue;

import java.util.Stack;

public class ReverseStack {


    public static void reverse(Stack<Integer> stack) {
        if(!stack.isEmpty()) {
            int top = stack.pop();
            reverse(stack);
            insertAtBottom(stack,top);
        }
    }

    public static void insertAtBottom(Stack<Integer> stack, int element) {
        if(stack.isEmpty()) {
            stack.add(element);
            return;
        }
        int top = stack.pop();
        insertAtBottom(stack,element);
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);

        reverse(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
