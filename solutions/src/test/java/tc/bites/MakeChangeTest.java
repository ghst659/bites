package tc.bites;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

/**
 * Created by tsc on 3/11/17.
 */
public class MakeChangeTest {
    private MakeChange solver = null;
    @BeforeMethod
    public void setUp() { this.solver = new MakeChange(); }
    @AfterMethod
    public void tearDown() {
        this.solver = null;
    }

    @Test(dataProvider="dataProvider")
    public void testProblem(int a, Set<Integer> denominations,  Map<Integer, Integer> expected) {
        Map<Integer,Integer> result = this.solver.change(a, denominations);
        showMemo(this.solver);
        Assert.assertEquals(result, expected, mStr(result));
    }

    protected void showMemo(MakeChange changer) {
        for (Map.Entry<Integer, Map<Integer,Integer>> am: changer.memo.entrySet()) {
            System.out.println(am.getKey());
            System.out.println(mStr(am.getValue()));
        }
    }

    protected String mStr(Map<Integer,Integer> tbl) {
        StringBuffer rBuf = new StringBuffer("{\n");
        for (Map.Entry<Integer,Integer> kv: tbl.entrySet()) {
            rBuf.append(String.format("   %d: %d\n", kv.getKey(), kv.getValue()));
        }
        rBuf.append("}");
        return rBuf.toString();
    }

    @DataProvider(name="dataProvider")
    public Object[][] dataProvider() {
        Object[][] result = new Object[1][];
        List<Object[]> rows = new ArrayList<>();
        int[] denom = { 1, 5, 10, 25, 50, 100, 500, 1000, 2000, 5000, 10000};
        rows.add(dataRow(4, denom, new int[] {4}));
        rows.add(dataRow(13, denom, new int[] {3, 0, 1}));
        rows.add(dataRow(125, denom, new int[] {0,0,0,1,0,1}));
        rows.add(dataRow(1, denom, new int[] {1}));
        rows.add(dataRow( 0, denom, new int[] {}));
        result = rows.toArray(new Object[rows.size()][]);
        return result;
    }

    private Object[] dataRow(int k, int[]denom, int[] expect) {
        Object[] result = new Object[3];
        result[0] = new Integer(k);
        Set<Integer> denominations = new HashSet<>();
        for (int d : denom) {
            denominations.add(d);
        }
        Map<Integer,Integer> expectation = new HashMap<>();
        for (int i = 0; i < expect.length; ++i) {
            int key = denom[i];
            int val = expect[i];
            if (val > 0) {
                expectation.put(key, val);
            }
        }
        result[1] = denominations;
        result[2] = expectation;
        return result;
    }
}
