package binary_tree;

import java.util.*;

public class SumOfLeftLeaves {


    // 方法一：找出左右叶子节点，然后剔除右叶子节点
    int sumOfLeftLeaves(TreeNode root){
        Set<TreeNode> leaves = new HashSet<>();
        if(root.left == null && root.right == null) return 0;
        getLeaves(root,leaves);
        int result = 0;
        for(TreeNode l:leaves){
            result += l.val;
        }
        return result;
    }

    void getLeaves(TreeNode root,Set<TreeNode> leaves) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leaves.add(root);
        }
        getLeaves(root.left, leaves);
        getLeaves(root.right, leaves);
        if (leaves.contains(root.right)) leaves.remove(root.right);
    }

    // 方法二：某节点的左子节点不为空且该子节点的左右子节点均为空，则该子节点为左叶子节点

}
