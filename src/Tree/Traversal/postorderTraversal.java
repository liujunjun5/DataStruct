package Tree.Traversal;
import Tree.Node;
import Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
public class postorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(new Node(0, root));
        List<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            if (cur.color == 1) {
                ans.add(cur.node.val);
                continue;
            }
            stack.push(new Node(1, cur.node));
            if (cur.node.right != null) {
                stack.push(new Node(0, cur.node.right));
            }
            if (cur.node.left != null) {
                stack.push(new Node(0, cur.node.left));
            }

        }
        return ans;
    }
}
