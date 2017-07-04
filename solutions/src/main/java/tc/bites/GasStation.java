package tc.bites;

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
}
