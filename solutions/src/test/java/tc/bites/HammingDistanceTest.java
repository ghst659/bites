package tc.bites;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * Note:
 * 0 ≤ x, y < 231.
 *
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * The above arrows point to positions where the corresponding bits are different.
 */
public class HammingDistanceTest {
    @Test(dataProvider="hamGen")
    public void testHamming(int x, int y, int e) {
        HammingDistance h = new HammingDistance();
        int a = h.hammingDistance(x, y);
        Assert.assertEquals(e, a);
    }
    @DataProvider(name="hamGen")
    public Object[][] hamGen() {
        Object[][] cases = {
            {1, 4, 2},
            {1, 1, 0},
            {1, 2, 2},
            {1, 3, 1},
            {31, 1, 4}
        };
        return cases;
    }
}
