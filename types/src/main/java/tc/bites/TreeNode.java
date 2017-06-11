package tc.bites;

/**
 * Created by tsc on 9/26/16.
 */
public class TreeNode {
    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int val;
    public TreeNode left = null;
    public TreeNode right = null;
    public TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}
