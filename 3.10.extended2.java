// bop 3.10.extended2

import java.util.ArrayDeque;
import java.util.ArrayList;

public class TreeUtils {
    private static class TreeNode {
        int data;
        TreeNode left, right;
    }
    public static void levelTraversalBottomUp(TreeNode root) {
        if(root == null) return;
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while(!queue.isEmpty()) {
            int len = queue.size();
            stack.push(queue.peek());
            ArrayList<TreeNode> arr = new ArrayList<TreeNode>(len);
            for(int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
                arr.add(node);
            }
            for(int i = 0; i < arr.size() - 1; i++) {
                arr.get(i).right = arr.get(i+1);
            }
            arr.get(arr.size()-1).right = null;
        }
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            while(node != null) {
                process(node);
                node = node.right;
            }
        }
    }
    public static void reverseLevelTraversalBottomUp(TreeNode root) {
        if(root == null) return;
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while(!queue.isEmptyy()) {
            int len = queue.size();
            TreeNode[] arr = new TreeNode[len];
            for(int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if(node.right != null) queue.offer(node.right);
                if(node.left != null) queue.offer(node.left);
                arr[i] = node;
            }
            for(int i = 0; i < len-1; i++) {
                arr[i].left = arr[i+1];
            }
            arr[len-1].left = null;
        }
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            while(node != null) {
                process(node);
                node = node.left;
            }
        }
    }
    private static void process(TreeNode node) {
        System.out.println(node.data);
    }
}
