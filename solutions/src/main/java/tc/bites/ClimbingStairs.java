package tc.bites;

import java.util.HashMap;
import java.util.Map;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 */
public class ClimbingStairs {
    private Map<Integer, Integer> cache = new HashMap<>();
    public int climbStairs(int n) {
        if (n == 0) {
            return 1;
        } else if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            int result = 0;
            for (int step = 1; step < 3 && step <= n; ++step) {
                result += climbStairs(n - step);
            }
            cache.put(n, result);
            return result;
        }
    }
}
