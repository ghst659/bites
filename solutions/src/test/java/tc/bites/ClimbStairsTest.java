package tc.bites;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 */
public class ClimbStairsTest {
    @Test(dataProvider="genStairs")
    public void testClimbStairs(int n, int expected) {
        ClimbingStairs sut = new ClimbingStairs();
        int actual = sut.climbStairs(n);
        Assert.assertEquals(actual, expected, Integer.toString(n));
    }
    @DataProvider(name="genStairs")
    public Object[][] genStairs() {
        Object[][] cases = {
            {1, 1},
            {2, 2},
            {3, 3},
            {4, 5},
            {5, 8}
        };
        return cases;
    }
}
