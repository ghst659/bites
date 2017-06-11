package tc.bites;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ListNodeTest {
    @Test
    public void testCreation() {
        ListNode head = new ListNode(3);
        Assert.assertEquals(head.val, 3);
        ListNode cadr = new ListNode(4);
        head.next = cadr;
        Assert.assertEquals(head.next.val, 4);
    }
}