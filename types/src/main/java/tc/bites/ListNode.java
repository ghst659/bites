package tc.bites;

/**
 * Created by tsc on 9/26/16.
 */
public class ListNode {
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
}