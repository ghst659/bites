package tc.bites;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tsc on 3/11/17.
 */
public class ConstructRectangleTest {
    private ConstructRectangle solver = null;
    @BeforeMethod
    public void setUp() { this.solver = new ConstructRectangle(); }
    @AfterMethod
    public void tearDown() {
        this.solver = null;
    }

    @Test(dataProvider="dataProvider")
    public void testProblem(int a, int[] expected) {
        int[] result = this.solver.constructRectangle(a);
        Assert.assertEquals(result, expected, String.format("%d %d %d", a, result[0], result[1]));
    }

    @DataProvider(name="dataProvider")
    public Object[][] dataProvider() {
        Object[][] result = new Object[1][];
        List<Object[]> rows = new ArrayList<>();
        rows.add(dataRow(4, 2,2));
        rows.add(dataRow(13, 13,1));
        rows.add(dataRow(20, 5,4));
        rows.add(dataRow( 121, 11, 11));
        rows.add(dataRow(65536,256,256));
        rows.add(dataRow(131072, 512,256));
        result = rows.toArray(new Object[rows.size()][]);
        return result;
    }

    private Object[] dataRow(int k, int...LW) {
        Object[] result = new Object[2];
        result[0] = new Integer(k);
        result[1] = LW;
        return result;
    }
}
