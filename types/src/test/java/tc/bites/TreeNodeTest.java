package tc.bites;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TreeNodeTest {
    @Test(dataProvider="treeGen")
    public void testBuildTree(int[] values, String expected) {
        TreeNode t = TreeNode.buildTree(values);
        String built = t.toString();
        Assert.assertEquals(expected, built);
    }
    @DataProvider(name="treeGen")
    private Object[][] treeGen() {
        Object[][] cases = {
            {new int[]{5}, "5(,)"},
            {new int[]{8,2,9}, "8(2(,),9(,))"},
            {new int[]{7,-1,5}, "7(,5(,))"},
            {new int[]{10,11,12,13,14,15,16}, "10(11(13(,),14(,)),12(15(,),16(,)))"}
        };
        return cases;
    }
}
