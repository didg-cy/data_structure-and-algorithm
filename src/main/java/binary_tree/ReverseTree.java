package binary_tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseTree {

    // 层序遍历的解法
    TreeNode reverseTree(TreeNode root){
        Deque<TreeNode> queue = new ArrayDeque<>();
        if(root == null) return null;
        queue.addLast(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.pollFirst();
            swap(cur);
            if(cur.left != null){
                queue.addLast(cur.left);
            }
            if(cur.right != null){
                queue.addLast(cur.right);
            }
        }
        return root;
    }

    // 交换其左右子节点的位置
    void swap(TreeNode cur){
        TreeNode temp = cur.left;
        cur.left = cur.right;
        cur.right = temp;
    }
}
