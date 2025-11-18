package binary_tree;

import java.util.Deque;
import java.util.LinkedList;

public class MaxDepth {

    // 层序遍历求深度
    public int maxDepth1(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        if(root == null) return 0;
        queue.addLast(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for(int i = 0;i<size;i++){
                TreeNode node = queue.pollFirst();
                if(node.left != null){
                    queue.addLast(node.left);
                }
                if(node.right != null) {
                    queue.addLast(node.right);
                }
            }
        }
        return depth;
    }

    // 前序遍历求深度
    int max;
    public int maxDepth2(TreeNode root) {
        int curDepth = 0;
        depth(root,curDepth);
        return max;
    }

    void depth(TreeNode root,int curDepth){
        if(root == null) return;
        curDepth++;
        max = Math.max(max, curDepth);
        depth(root.left, curDepth);
        depth(root.right, curDepth);
    }

    // 后序遍历求高度
    int maxDepth3(TreeNode root){
        if(root == null) return 0;
        int leftHeight = maxDepth3(root.left);
        int rightHeight = maxDepth3(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
