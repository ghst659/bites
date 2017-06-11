package tc.bites;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
        Object[][] result = new Object[][] {
                {new Integer(0), new Integer(0), new Integer(0)},
                {new Integer(0), new Integer(1), new Integer(1)},
                {new Integer(2), new Integer(5), new Integer(7)},
                {new Integer(-1), new Integer(1), new Integer(0)},
                {new Integer(-7), new Integer(4), new Integer(-3)}
        };
        return result;
    }
}
