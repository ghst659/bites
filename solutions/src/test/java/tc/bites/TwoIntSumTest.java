package tc.bites;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/**
 * Calculate the sum of two integers a and b,
 * but you are not allowed to use the operator + and -.
 * Example:
 * Given a = 1 and b = 2, return 3.
 */
public class TwoIntSumTest {
    private TwoIntSum cut = null;
    @BeforeMethod public void setUp() { this.cut = new TwoIntSum(); }
    @AfterMethod public void tearDown() {
        this.cut = null;
    }

    @Test(dataProvider="dataProvider")
    public void testProblem(int a, int b, int expected) {
        int result = this.cut.getSum(a, b);
        Assert.assertEquals(result, expected, "sum mismatch");
    }

    @DataProvider(name="dataProvider")
    public Object[][] dataProvider() {
        Object[][] cases = {
            {0, 0, 0},
            {0, 1, 1},
            {2, 5, 7},
            {-1, 1, 0},
            {-7, 4, -3}
        };
        return cases;
    }
}
