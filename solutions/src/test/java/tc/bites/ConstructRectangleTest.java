package tc.bites;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *  For a web developer, it is very important to know how to design a web page's size.
 *  So, given a specific rectangular web page’s area, your job by now is to design a
 *  rectangular web page, whose length L and width W satisfy the following requirements:
 *  1. The area of the rectangular web page you designed must equal to the given target area.
 *  2. The width W should not be larger than the length L, which means L >= W.
 *  3. The difference between length L and width W should be as small as possible.
 *  You need to output the length L and the width W of the web page you designed in sequence.
 */
public class ConstructRectangleTest {
    @Test(dataProvider = "dataProvider")
    public void testProblem(int a, int[] expected) {
        int[] result = new ConstructRectangle().constructRectangle(a);
        Assert.assertEquals(result, expected, String.format("%d %d %d", a, result[0], result[1]));
    }

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider() {
        Object[][] cases = {
            {4, new int[]{2, 2}},
            {13, new int[]{13, 1}},
            {20, new int[]{5, 4}},
            {121, new int[]{11, 11}},
            {65536, new int[]{256, 256}},
            {131072, new int[]{512, 256}}
        };
        return cases;
    }
}
