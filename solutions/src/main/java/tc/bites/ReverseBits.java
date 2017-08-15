package tc.bites;

/**
 * Reverse bits of a given 32 bits unsigned integer.
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
}
