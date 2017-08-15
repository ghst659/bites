package tc.bites;

/**
 * Reverse BITS of a given 32 BITS unsigned integer.
 * For example, given input 43261596 (represented in binary
 * as 00000010100101000001111010011100),
 * return 964176192 (represented in binary
 * as 00111001011110000010100101000000).
 * Follow up:
 * If this function is called many times, how would you optimize it?
 */
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        return revBits0(n);
    }
    public int revBits0(int n) {
        int result = 0;
        for (int pos = 0; pos < 32; ++pos) {
            int log2 = 31 - pos;
            int addition = 1 << log2;
            int mask = 1 << pos;
            int bit = n & mask;
            if (bit != 0) {
                result |= addition;
            }
        }
        return result;
    }
    private static class Bit {
        Bit(int mask, int abit) {
            this.mask = mask;
            this.abit = abit;
        }
        int mask = 0;
        int abit = 0;
    }
    private static Bit[] BITS = new Bit[32];
    static {
        for (int i = 0; i < 32; ++i) {
            int k = 31 - i;
            BITS[i] = new Bit(1 << i, 1 << k);
        }
    }
    public int revBits1(int n) {
        int result = 0;
        for (Bit b: BITS) {
            if (0 != (n & b.mask)) {
                result |= b.abit;
            }
        }
        return result;
    }
}
