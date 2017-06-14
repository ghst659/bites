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

    @Test(dataProvider="fizzGen")
    public void testProblem(int a, List<String> expected) {
        List<String> result = this.solver.fizzBuzz(a);
        Assert.assertEquals(result, expected, "mismatch");
    }
    @DataProvider(name="fizzGen")
    public Object[][] fizzGen() {
        Object[][] cases = {
            {0, Arrays.asList(new String[]{})},
            {1, Arrays.asList(new String[]{"1"})},
            {2, Arrays.asList(new String[]{"1", "2"})},
            {3, Arrays.asList(new String[]{"1", "2", "Fizz"})},
            {15, Arrays.asList(new String[]{"1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"})}
        };
        return cases;
    }
}
