package tc.bites;

/**
 * Created by tsc on 9/26/16.
 */
public class ListNode {
    public static ListNode makeList(int... values) {
        ListNode result = null;
        if (values != null && values.length > 0) {
            result = new ListNode(values[0]);
            ListNode prev = result;
            for (int i = 1; i < values.length; ++i) {
                ListNode current = new ListNode(values[i]);
                prev.setNext(current);
                prev = current;
            }
        }
        return result;
    }

    public int val;
    public ListNode next = null;
    public ListNode(int x) {
        val = x;
        next = null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return Integer.toString(this.val) + (this.next != null ? "," + this.next.toString() : "");
    }
}
