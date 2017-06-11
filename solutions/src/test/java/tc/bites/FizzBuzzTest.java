package tc.bites;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tsc on 3/11/17.
 */
public class FizzBuzzTest {
    private FizzBuzz solver = null;
    @BeforeMethod
    public void setUp() { this.solver = new FizzBuzz(); }
    @AfterMethod
    public void tearDown() {
        this.solver = null;
    }

    @Test(dataProvider="dataProvider")
    public void testProblem(int a, List<String> expected) {
        List<String> result = this.solver.fizzBuzz(a);
        Assert.assertEquals(result, expected, "mismatch");
    }

    @DataProvider(name="dataProvider")
    public Object[][] dataProvider() {
        Object[][] result = new Object[5][];
        result[0] = dataRow(0);
        result[1] = dataRow(1, "1");
        result[2] = dataRow(2, "1", "2");
        result[3] = dataRow(3, "1","2","Fizz");
        result[4] = dataRow(15, "1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz");
        return result;
    }

    private Object[] dataRow(int k, String...words) {
        Object[] result = new Object[2];
        result[0] = new Integer(k);
        result[1] = Arrays.asList(words);
        return result;
    }
}
