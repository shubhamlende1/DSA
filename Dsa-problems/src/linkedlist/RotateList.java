package linkedlist;

public class RotateList {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int size = 1;

        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            size++;
        }

        // make it circular
        temp.next = head;


        k = k % size;
        int step = size - k ;
        ListNode newTail = head;
        for (int i = 1; i < step ; i++) {
            newTail = newTail.next;
        }


        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
    public static ListNode build(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int num : arr) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }

        return dummy.next;
    }
    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head1 = build(new int[]{1, 2, 3, 4, 5});
        int k1 = 2;
        print(rotateRight(head1, k1)); //
    }
}
