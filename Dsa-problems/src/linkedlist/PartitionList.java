package linkedlist;

/*
6. Partition List
Medium

Topics
premium lock icon
Companies
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.



Example 1:


Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
Example 2:

Input: head = [2,1], x = 2
Output: [1,2]


* */
public class PartitionList {
    public static ListNode partition(ListNode head, int x) {
        ListNode smallP = new ListNode(0);
        ListNode largeP = new ListNode(0);

        ListNode small = smallP;
        ListNode large = largeP;

        while(head != null) {
            if(head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }

        large.next = null;
        small.next = largeP.next;

        return smallP.next;
    }
}
