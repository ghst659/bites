package tc.bites;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes
 * of the first two lists.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode current = null;
        while (c1 != null || c2 != null) {
            ListNode nextNode = null;
            if (c1 == null) {
                nextNode = c2;
                c2 = c2.next;
            } else if (c2 == null) {
                nextNode = c1;
                c1 = c1.next;
            } else if (c1.val < c2.val) {
                nextNode = c1;
                c1 = c1.next;
            } else {
                nextNode = c2;
                c2 = c2.next;
            }
            if (head == null) {
                head = nextNode;
                current = head;
            } else {
                current.next = nextNode;
                current = current.next;
            }
        }
        return head;
    }
}
