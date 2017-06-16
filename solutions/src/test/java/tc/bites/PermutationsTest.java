package tc.bites;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  Given a collection of distinct numbers, return all possible permutations.
 *  For example,
 *  [1,2,3] have the following permutations:
 *  [
 *  [1,2,3],
 *  [1,3,2],
 *  [2,1,3],
 *  [2,3,1],
 *  [3,1,2],
 *  [3,2,1]
 *  ]
 */
public class PermutationsTest {
    @Test(dataProvider="perGen")
    public void testPermute(int[] nums, int[][] expected) {
        Permutations s = new Permutations();
        List<List<Integer>> actual = s.permute(nums);
        Assert.assertEquals(actual.size(), expected.length);
        Set<String> acSet = new HashSet<>();
        Set<String> exSet = new HashSet<>();
        for (int i = 0; i < expected.length; ++i) {
            StringBuffer acBuf = new StringBuffer();
            StringBuffer exBuf = new StringBuffer();
            for (int j = 0; j < expected[i].length; ++j) {
                acBuf.append(Integer.toString(actual.get(i).get(j)));
                acBuf.append(",");
                exBuf.append(Integer.toString(expected[i][j]));
                exBuf.append(",");
            }
            acSet.add(acBuf.toString());
            exSet.add(exBuf.toString());
        }
        Assert.assertEquals(exSet, acSet);
    }
    @DataProvider(name="perGen")
    public Object[][] perGen() {
        Object[][] cases = {
            {
                new int[]{1,2,3},
                new int[][]{
                    new int[]{1,2,3},
                    new int[]{1,3,2},
                    new int[]{2,1,3},
                    new int[]{2,3,1},
                    new int[]{3,1,2},
                    new int[]{3,2,1}
                }
            },
            {
                new int[]{1,2},
                new int[][]{
                    new int[]{1,2},
                    new int[]{2,1}
                }
            },
            {
                new int[]{2},
                new int[][]{
                    new int[]{2}
                }
            },
            {
                new int[]{},
                new int[][]{
                }
            }
        };
        return cases;
    }
}
