package tc.bites;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by tsc on 9/26/16.
 */
public class ReverseStringTest {
    private ReverseString cut = null;
    @BeforeMethod public void setUp() { this.cut = new ReverseString(); }
    @AfterMethod public void tearDown() {
        this.cut = null;
    }

    @Test(dataProvider="dataProvider")
    public void testProblem(String s, String expected) {
        String r = this.cut.reverseString(s);
        Assert.assertEquals(r, expected, "string reversal test.");
    }

    @DataProvider(name="dataProvider")
    public Object[][] dataProvider() {
        Object[][] result = new Object[][] {
                {"Cedric", "cirdeC"},
                {"", ""},
                {"M", "M"},
                {"0123456789", "9876543210"}
        };
        return result;
    }
}
