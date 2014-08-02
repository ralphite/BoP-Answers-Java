// bop 3.10

import java.util.ArrayDeque;

public class TreeUtils {
    public static void levelTraversal(TreeNode root) {
        if (root == null) return;
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            //process with this node
            process(node);
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
        }
    }
    public static void printNodeAtLevel(TreeNode root, int level) {
        if(root == null) return;
        ArrayDeque<TreeNode> q = new ArrayDeque<TreeNode>();
        q.offer(root);
        int l = 0;
        while(!q.isEmpty()) {
            int len = q.size();
            for(int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                if(l == level)
                    process(node);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            l++;
        }
    }
    private static void process(TreeNode node) {
        System.out.println(node.data);
    }
    private static class TreeNode {
        int data;
        TreeNode left, right;
    }
}
