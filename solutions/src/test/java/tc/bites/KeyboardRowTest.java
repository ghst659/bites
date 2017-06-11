package tc.bites;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by tsc on 3/10/17.
 */
public class KeyboardRowTest {
    private KeyboardRow solution = null;
    @BeforeMethod
    public void setUp() { this.solution = new KeyboardRow(); }
    @AfterMethod
    public void tearDown() {
        this.solution = null;
    }

    public void runSolution(String[] inputs, String[] expectedOutputs) {
        String[] runResult = this.solution.findWords(inputs);
        Assert.assertEquals(runResult.length, expectedOutputs.length);
        for (int i = 0; i < runResult.length; ++i) {
            Assert.assertEquals(runResult[i], expectedOutputs[i]);
        }
    }

    @Test
    public void testExample() {
        String[] inputs = {"Alaska","Hello","Dad", "Peace", "TWERP", "quite"};
        String[] expected = {"Alaska", "Dad", "TWERP", "quite"};
        this.runSolution(inputs, expected);
    }
}
