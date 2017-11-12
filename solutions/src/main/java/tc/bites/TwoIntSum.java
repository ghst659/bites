package tc.bites;

/**
 * Calculate the sum of two integers a and b,
 * but you are not allowed to use the operator + and -.
 * Example:
 * Given a = 1 and b = 2, return 3.
 */
public class TwoIntSum {
    public int getSum(int a, int b) {
        System.err.format("a = %s\n", i2b(a));
        System.err.format("b = %s\n", i2b(b));
        int result = 0;
        boolean b_c = false;
        for (int i = 0; i < 32; ++i) {
            int mask = (1 << i);
            int rbit = 0;
            boolean b_a = (a & mask) != 0;
            boolean b_b = (b & mask) != 0;
            if (b_a && b_b && b_c) {
                rbit = 1;
                b_c = true;
            } else if (b_a && b_b && ! b_c) {
                rbit = 0;
                b_c = true;
            } else if (b_a && ! b_b && b_c) {
                rbit = 0;
                b_c = true;
            } else if (b_a && ! b_b && ! b_c) {
                rbit = 1;
                b_c = false;
            } else if (! b_a && b_b && b_c) {
                rbit = 0;
                b_c =  true;
            } else if (! b_a && b_b && ! b_c) {
                rbit = 1;
                b_c = false;
            } else if (! b_a && ! b_b && b_c) {
                rbit = 1;
                b_c = false;
            } else {
                rbit = 0;
                b_c = false;
            }
            int rshift = (rbit << i);
            result |= rshift;
            System.err.format("%d: %s\n", i, i2b(result));
        }
        return result;
    }
    private static String i2b(int i) {
        return Integer.toBinaryString(i).replace(' ', '0');
    }
}
