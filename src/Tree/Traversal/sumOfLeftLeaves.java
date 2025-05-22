package Tree.Traversal;

import Tree.TreeNode;

public class sumOfLeftLeaves {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root, false);
        return sum;
    }

    private void dfs(TreeNode node, boolean isLeft) {
        if(node==null) {
            return;
        }
        if(node.left==null && node.right==null && isLeft) {
            sum += node.val;
        }
        dfs(node.left, true);
        dfs(node.right, false);
    }
}
