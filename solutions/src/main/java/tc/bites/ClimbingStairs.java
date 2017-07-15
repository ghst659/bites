package tc.bites;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        int am2 = 1;
        int am1 = 1;
        switch (n < 0 ? 0 : n) {
            case 0:
                return am2;
            case 1:
                return am1;
            default:
                int ways = 0;
                for (int i = 2; i <= n; ++i) {
                    ways = am1 + am2;
                    am2 = am1;
                    am1 = ways;
                }
                return ways;

        }
    }
}
