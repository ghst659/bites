package tc.bites;

public class TwoIntSum {
    public int getSum(int a, int b) {
        int result = 0;
        boolean b_c = false;
        for (int i = 0; i < 64; ++i) {
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
                rbit = 1;
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
        }
        return result;
    }
}
