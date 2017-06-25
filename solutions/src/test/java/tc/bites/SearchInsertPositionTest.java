package tc.bites;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Given a sorted array and a target value,
 * return the index if the target is found.
 * If not, return the index where it would
 * be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class SearchInsertPositionTest {
    @Test(dataProvider="aryGen")
    public void testInsertion(int[] ary, int value, int expected) {
        SearchInsertPosition solution = new SearchInsertPosition();
        int actual = solution.searchInsert(ary, value);
        Assert.assertEquals(actual, expected);
    }
    @DataProvider(name="aryGen")
    public Object[][] aryGen() {
        Object[][] cases = {
            {new int[]{1,3,5,6}, 5, 2},
            {new int[]{1,3,5,6}, 2, 1},
            {new int[]{1,3,5,6}, 7, 4},
            {new int[]{1,3,4,6}, 0, 0}
        };;
        return cases;
    }
}
