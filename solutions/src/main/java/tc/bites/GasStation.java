package tc.bites;

import java.util.Arrays;
import java.util.function.Function;

/**
 * There are N gas stations along a circular route,
 * where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and
 * it costs cost[i] of gas to travel from station i
 * to its next station (i+1).
 * You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the
 * circuit once, otherwise return -1.
 * Note:
 * The solution is guaranteed to be unique.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int result = -1;
        int min_i = 0;
        int min_total = Integer.MAX_VALUE;
        int total = 0;
        for (int i = 0; i < gas.length; ++i) {
            total += gas[i] - cost[i];
            if (total < min_total) {
                min_total = total;
                min_i = i;
            }
        }
        if (total >= 0) {
            result = (min_i + 1) % gas.length;
        }
        return result;
    }
}
