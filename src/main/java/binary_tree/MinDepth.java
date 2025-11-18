package binary_tree;

import java.util.*;

// 输入输出模式下按层序遍历结果构造 满二叉树
public class MinDepth {
    int minDepth(TreeNode root){
        Deque<TreeNode> queue = new ArrayDeque<>();
        int depth = 0;
        if(root==null) return 0;
        queue.addLast(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for(int i = 0; i<size; i++){
                TreeNode cur = queue.pollFirst();
                if(cur.left != null){
                    queue.addLast(cur.left);
                }
                if(cur.right != null){
                    queue.addLast(cur.right);
                }
                if(cur.left == null && cur.right == null){
                    return depth;
                }
            }
        }
        return depth;
    }
}
