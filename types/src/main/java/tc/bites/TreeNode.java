package tc.bites;

import java.util.ArrayDeque;
import java.util.Deque;

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
    @Override
    public String toString() {
        String result = String.format("%d(%s,%s)",
                                      this.val,
                                      this.left == null ? "" : this.left.toString(),
                                      this.right == null ? "" : this.right.toString());
        return result;
    }
    public static TreeNode buildTree(int... values) {
        TreeNode top = null;
        if (values != null && values.length > 0) {
            int L = values.length;
            top = new TreeNode(values[0]);
            Deque<BuildItem> q = new ArrayDeque<>();
            for (q.addLast(new BuildItem(top, 0)); q.size () > 0;) {
                BuildItem cur = q.removeFirst();
                int iLeft = 2 * cur.index + 1;
                int iRight = 2 * cur.index + 2;
                if (iLeft < L && values[iLeft] >= 0) {
                    TreeNode child = new TreeNode(values[iLeft]);
                    cur.node.setLeft(child);
                    q.addLast(new BuildItem(child, iLeft));
                }
                if (iRight < L && values[iRight] >= 0) {
                    TreeNode child = new TreeNode(values[iRight]);
                    cur.node.setRight(child);
                    q.addLast(new BuildItem(child, iRight));
                }
            }
        }
        return top;
    }
    private static class BuildItem {
        public TreeNode node;
        public int index;
        public BuildItem(TreeNode n, int v) {
            this.node = n;
            this.index = v;
        }
    }
}
