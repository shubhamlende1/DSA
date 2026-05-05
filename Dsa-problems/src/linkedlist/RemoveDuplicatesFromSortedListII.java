package linkedlist;

import org.w3c.dom.ls.LSInput;

import java.util.HashSet;
import java.util.Set;

/*
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.



Example 1:


Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
Example 2:


Input: head = [1,1,1,2,3]
Output: [2,3]

* */
public class RemoveDuplicatesFromSortedListII {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;

       while (head != null ) {
           if(head.next != null && head.val == head.next.val) {
               while (head.next != null && head.val == head.next.val) {
                   head = head.next;
               }
               temp.next = head.next;
           } else {
               temp = temp.next;
           }
           head = head.next;
       }
        temp.next = null;

        return dummy.next;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        // Call your method
        ListNode result = RemoveDuplicatesFromSortedListII.deleteDuplicates(head);

        // Print result
        printList(result);
    }
}
