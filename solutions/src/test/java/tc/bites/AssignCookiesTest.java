package tc.bites;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Assume you are an awesome parent and want to give
 * your children some cookies. But, you should give each
 * child at most one cookie. Each child i has a greed factor gi,
 * which is the minimum size of a cookie that the child will be
 * content with; and each cookie j has a size sj.
 * If sj >= gi, we can assign the cookie j to the child i,
 * and the child i will be content.
 * Your goal is to maximize the number of your content
 * children and output the maximum number.
 * Note:
 * You may assume the greed factor is always positive.
 * You cannot assign more than one cookie to one child.
 * Example 1:
 * Input: [1,2,3], [1,1]
 * Output: 1
 * Explanation: You have 3 children and 2 cookies.
 * The greed factors of 3 children are 1, 2, 3.
 * And even though you have 2 cookies, since their size is both 1,
 * you could only make the child whose greed factor is 1 content.
 * You need to output 1.
 * Example 2:
 * Input: [1,2], [1,2,3]
 * Output: 2
 * Explanation: You have 2 children and 3 cookies.
 * The greed factors of 2 children are 1, 2.
 * You have 3 cookies and their sizes are big enough to gratify all of the children,
 * You need to output 2.
 */
public class AssignCookiesTest {
    @Test(dataProvider="cookieGen")
    public void testAssignCookies(int[] g, int[] s, int expected) {
        AssignCookies sol = new AssignCookies();
        int actual = sol.findContentChildren(g, s);
        Assert.assertEquals(actual, expected, String.format("%s %s", Aux.axStr(g), Aux.axStr(s)));
    }
    @DataProvider(name="cookieGen")
    public Object[][] cookieGen() {
        Object[][] cases = {
            {new int[]{1,2,3}, new int[]{1,1}, 1},
            {new int[]{1,2}, new int[]{1,2,3}, 2},
            {new int[]{1}, new int[]{1}, 1},
            {new int[]{2}, new int[]{1,1,1,1,1,1,1,1,1,1,1}, 0},
            {new int[]{3,3,3,3,3}, new int[]{3,3,3,3,3}, 5},
            {new int[]{3,3,3,3,3}, new int[]{4,4,4,4,4}, 5},
            {new int[]{3,3,3,3,3}, new int[]{2,2,2,2,2}, 0},
            {new int[]{3,3,3,3,3}, new int[]{1,3,3,3,4}, 4},
            {new int[]{3,3,3,3,3}, new int[]{3,3,3}, 3},
            {new int[]{5,5}, new int[]{2,2,2,2,2,2}, 0},
            {new int[]{5,10}, new int[]{7}, 1},
            {new int[]{5, 5}, new int[]{2,3,5,5,5,5,5,5,7,8}, 2}
        };
        return cases;
    }
}
