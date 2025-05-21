package Tree;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        TreeNode root = new TreeNode(arr[0]);
        q.offer(root);
        int i = 1;

        while (!q.isEmpty() && i < arr.length) {
            TreeNode cur = q.poll();
            if (i < arr.length && arr[i] != null) {
                cur.left = new TreeNode(arr[i]);
                q.offer(cur.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                cur.right = new TreeNode(arr[i]);
                q.offer(cur.right);
            }
            i++;
        }
        return root;
    }

    public static void displayTree(TreeNode head) {
        if (head == null) {
            return;
        }
        List<Integer> ans = new ArrayList<>();
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(new Node(0, head));
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            if (cur.color == 1) {
                ans.add(cur.node.val);
                continue;
            }
            if (cur.node.right != null) {
                stack.push(new Node(0, cur.node.right));
            }
            stack.push(new Node(1, cur.node));
            if (cur.node.left != null) {
                stack.push(new Node(0, cur.node.left));
            }
        }
        System.out.println(ans);
//        int[] ints = ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9};
        TreeNode treeNode = TreeNode.buildTree(arr);
        TreeNode.displayTree(treeNode);
    }
}

