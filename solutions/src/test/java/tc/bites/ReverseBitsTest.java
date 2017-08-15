package tc.bites;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary
 * as 00000010100101000001111010011100),
 * return 964176192 (represented in binary
 * as 00111001011110000010100101000000).
 * Follow up:
 * If this function is called many times, how would you optimize it?
 */
public class ReverseBitsTest {
    @Test(dataProvider="genInt")
    public void testReverseBits(int n, int want) {
        ReverseBits s = new ReverseBits();
        int act = s.reverseBits(n);
        Assert.assertEquals(act, want);
    }

    @DataProvider(name="genInt")
    public Object[][] genInt() {
        Object[][] cases = {
            {43261596, 964176192},
            {1073741824, 2},
            {536870912, 4},
            {0, 0}
        };
        return cases;
    }

    @Test
    public void testSpeed() {
        ReverseBits s = new ReverseBits();
        int MAXI = 1 << 27;
        int sum = 0;
        long t0 = System.currentTimeMillis();
        for (int i = 0; i < MAXI; ++i) {
            sum |= s.reverseBits(i);
        }
        long t1 = System.currentTimeMillis();
        System.err.format("dt = %d, sum = %d\n", t1 - t0, sum);
    }
}
