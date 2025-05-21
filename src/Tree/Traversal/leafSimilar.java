package Tree.Traversal;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class leafSimilar {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        dfs(root1, l1);
        dfs(root2, l2);
        return l1.equals(l2);
    }

    private void dfs(TreeNode root, List<Integer> l) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            l.add(root.val);
        }
        dfs(root.left, l);
        dfs(root.right, l);
    }
}
