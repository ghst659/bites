package tc.bites;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Given an array of integers sorted in ascending order,
 * find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class SearchForARangeTest {
    @Test(dataProvider = "rangeData")
    public void testSearchForRange(int[] ary, int val, int[] expected) {
        SearchForARange s = new SearchForARange();
        int[] actual = s.searchRange(ary, val);
        Assert.assertEquals(expected[0], actual[0]);
        Assert.assertEquals(expected[1], actual[1]);
    }
    @DataProvider(name="rangeData")
    public Object[][] rangeData() {
        Object[][] result = {
            {new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4}},
            {new int[]{5, 7, 7, 8, 8, 10}, 9, new int[]{-1, -1}},
            {new int[]{10, 11, 12, 13}, 13, new int[]{3, 3}},
            {new int[]{10, 11, 12, 13}, 10, new int[]{0, 0}},
            {new int[]{10, 11, 12, 13}, 11, new int[]{1, 1}},
            {new int[]{5, 5, 5}, 5, new int[]{0, 2}}
        };
        return result;
    }
    @Test
    public void testHiLo() {
        int[][] nums = {
            {2, 3, 5, 7, 7, 7, 7, 9, 10, 11},
            {7, 7, 7, 7},
            {3, 7, 7},
            {7, 9},
            {7},
            {8},
            {6}
        };
        for (int[] ary : nums) {
            int lo = SearchForARange.loPos(ary, 7);
            int hi = SearchForARange.hiPos(ary, 7);
            System.err.format("%s: lo = %d, hi = %d\n", aryStr(ary), lo, hi);
        }
    }
    private static String aryStr(int[] ary) {
        StringBuffer buf = new StringBuffer("[");
        boolean first = true;
        for (int i: ary) {
            if (! first) {
                buf.append(",");
            }
            buf.append(Integer.toString(i));
            first = false;
        }
        buf.append("]");
        return buf.toString();
    }
}
