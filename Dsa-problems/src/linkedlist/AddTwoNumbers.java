package linkedlist;

import org.w3c.dom.Node;

public class AddTwoNumbers {

    public  static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if(l1 != null) {
                sum+=l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                sum +=l2.val;
                l2=l2.next;
            }

            temp.next = new ListNode(sum % 10);
            carry = sum / 10;

            temp = temp.next;
        }

        return dummy.next;
    }

    private static void calculateRemaining(ListNode node, int carry, ListNode temp) {
        while(node != null) {
            int sum = node.val + carry;
            if(sum >= 10) {
                carry = sum/10;
                temp.next = new ListNode(sum % 10);
            } else {
                temp.next = new ListNode(sum);
                carry = 0;
            }
            temp = temp.next;
            node = node.next;
        }
        if(carry > 0) {
            temp.next = new ListNode(carry);
        }
    }

    public static void main(String[] args) {
        // l1 = [9,9,9,9,9,9,9]
        ListNode l1 = build(new int[]{9,9,9,9,9,9,9});

        // l2 = [9,9,9,9]
        ListNode l2 = build(new int[]{9,9,9,9});

        ListNode result = addTwoNumbers(l1, l2);

        while(result != null){
            System.out.print(result.val + " ");
            result = result.next;
        } // expected: 8 9 9 9 0 0 0 1
    }

    // 🔧 Build linked list from array
    static ListNode build(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int num : arr) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }

        return dummy.next;
    }
}
