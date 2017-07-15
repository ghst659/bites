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
        return n2(gas,cost);
    }
    private int n(int[] gas, int[] cost) {
        int L = gas.length;
        if (L < 2) {
            return 0;
        }
        int[] tank = new int[L];
        tank[0] = gas[0] - cost[0];
        for (int pos = 0; pos < L; ++pos) {
            tank[pos] = (pos == 0 ? 0 : tank[pos-1]) + gas[pos] - cost[pos];
        }
        int minPos = 0;
        int maxTank = tank[0];
        int minTank = tank[0];
        for (int pos = 0; pos < L; ++pos) {
            if (tank[pos] > maxTank) {
                maxTank = pos;
            }
            if (tank[pos] < minTank) {
                minTank = tank[pos];
                minPos = pos;
            }
        }
        int result = (minTank >= 0 ? minPos : -1);
        System.err.println(String.format("%s %s -> %s -> %d",
            Arrays.toString(gas), Arrays.toString(cost),
            Arrays.toString(tank), result));
        return result;
    }
    /**
     * N-squared initial solution.
     */
    private int n2(int[] gas, int[] cost) {
        int L = gas.length;
        if (L < 2) {
            return 0;
        }
        for (int startPos = 0; startPos < L; ++startPos) {
            boolean canComplete = true;
            int tank = 0;
            for (int step = 0; tank >= 0 && step < L; ++step) {
                int pos = (startPos + step) % L;
                tank += (gas[pos] - cost[pos]);
            }
            if (tank >= 0) {
                return startPos;
            }
        }
        return -1;
    }
    private <T, R> R caller(Function<T,R> f, T a) {
        return f.apply(a);
    }
    private void syntax() {
        Integer a = 3;
        Integer b = 5;
        String s = caller((x)->x.toString(), a);
        String t = caller(Integer::toBinaryString, a);
        Integer u = caller(a::compareTo, b);
    }
}
