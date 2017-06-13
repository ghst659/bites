package tc.bites;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes
 * of the first two lists.
 */
public class MergeTwoSortedListsTest {
    @Test
    public void testMerge() {
        ListNode l0 = ListNode.makeList(10, 30, 50, 70, 80, 90);
        ListNode l1 = ListNode.makeList(20, 25, 35, 55);
        ListNode e = ListNode.makeList(10, 20, 25, 30, 35, 50, 55, 70, 80, 90);
        MergeTwoSortedLists m = new MergeTwoSortedLists();
        ListNode actual = m.mergeTwoLists(l0, l1);
        Assert.assertEquals(e.toString(), actual.toString());
    }
}
