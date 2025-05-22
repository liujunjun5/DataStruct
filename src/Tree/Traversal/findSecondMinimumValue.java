package Tree.Traversal;

import Tree.TreeNode;

public class findSecondMinimumValue {
    int rootVal, ans;

    public int findSecondMinimumValue(TreeNode root) {
        ans = -1;
        rootVal = root.val;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (ans != -1 && node.val >= ans) {
            return;
        }
        if (node.val > rootVal) {
            ans = node.val;
        }
        dfs(node.left);
        dfs(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree(new Integer[]{2, 2, 5, null, null, 5, 7});
        System.out.println(new findSecondMinimumValue().findSecondMinimumValue(root));
    }
}
