package tc.bites;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
public class GasStationTest {
    @Test(dataProvider="routeGen")
    public void testRoute(int[] gas, int[] cost, int expected) {
        GasStation sut = new GasStation();
        int actual = sut.canCompleteCircuit(gas, cost);
        Assert.assertEquals(actual, expected, String.format("%s %s", Aux.axStr(gas), Aux.axStr(cost)));
    }
    @DataProvider(name="routeGen")
    public Object[][] routeGen() {
        Object[][] cases = {
            {new int[]{0}, new int[]{1}, 0},
            {new int[]{0}, new int[]{0}, 0},
            {new int[]{1, 1}, new int[]{1, 1}, 0},
            {new int[]{1, 0}, new int[]{1, 1}, -1},
            {new int[]{2, 0}, new int[]{1, 1}, 0},
            {new int[]{2, 0}, new int[]{1, 2}, -1},
            {new int[]{1, 0, 2}, new int[]{1, 1, 1}, 2},
            {new int[]{1, 0, 2, 1}, new int[]{1, 1, 1, 1}, 2},
            {new int[]{1, 1, 0, 2}, new int[]{1, 1, 1, 1}, 3}
        };
        return cases;
    }
}
