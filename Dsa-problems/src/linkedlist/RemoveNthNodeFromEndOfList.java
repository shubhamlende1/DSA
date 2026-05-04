package linkedlist;

import static linkedlist.AddTwoNumbers.build;
import static linkedlist.RotateList.print;
import static linkedlist.RotateList.rotateRight;

/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.



Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
**/
public class RemoveNthNodeFromEndOfList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;

        while (temp!= null) {
            temp = temp.next;
            size++;
        }
        if(size == 1)
            return null;
        else if (size == n) {
            return head.next;
        } else {
            temp = head;
            for(int i = 1; i< size - n;i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }

        return head;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
       ListNode dummy = new ListNode(0);
       dummy.next = head;

       ListNode slow = dummy;
       ListNode fast = dummy;

       for(int i = 0 ; i<=n;i++)
           fast = fast.next;

       while (fast != null) {
           fast = fast.next;
           slow = slow.next;
       }

       slow.next = slow.next.next;
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode head1 = build(new int[]{1, 2, 3, 4, 5});
        int k1 = 2;
        print(removeNthFromEnd2(head1, k1)); //
    }
}
