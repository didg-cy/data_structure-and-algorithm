package binary_tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class IsBlanceTree {

    // 层序遍历得到子节点，再计算子节点的深度的解法，有重复遍历，低效
    static boolean isBalanceTree1(TreeNode root) {

        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root == null) return true;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.pollFirst();
            int leftDepth = getTreeHeight(cur.left);
            int rightDepth = getTreeHeight(cur.right);
            if(Math.abs(leftDepth - rightDepth) > 1){
                return false;
            }
            if (cur.right != null) {
                queue.addLast(cur.right);
            }
            if (cur.left != null) {
                queue.addLast(cur.left);
            }
        }
        return true;
    }

    static int getTreeHeight(TreeNode cur){
        Deque<TreeNode> queue = new ArrayDeque<>();
        int depth = 0;
        if(cur==null) return depth;
        queue.addLast(cur);
        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for(int i = 0; i<size; i++){
                cur = queue.pollFirst();
                if(cur.left != null){
                    queue.addLast(cur.left);
                }
                if(cur.right != null){
                    queue.addLast(cur.right);
                }
            }
        }

        return depth;
    }

    // 后序遍历迭代法求高度，无重复遍历
    boolean satisfyFlag = true;
    boolean isBalanceTree2(TreeNode root){
        if(root == null) return true;
        getHeight2(root);
        return satisfyFlag;
    }
    int getHeight2(TreeNode root){
        if(root == null) return 0;
        int leftHeight = getHeight2(root.left);
        int rightHeight = getHeight2(root.right);
        int sub = Math.abs(leftHeight-rightHeight);
        if(sub > 1){
            satisfyFlag = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // 后序遍历迭代法求高度的优化：发现左右子树的高度差大于 1 后就不进行后续的高度计算了，一路返回即可
    boolean isBalanceTree3(TreeNode root){
        if(root == null) return true;
        int height = getHeight3(root);
        if(height == -1){
            return false;
        }else {
            return true;
        }
    }
    int getHeight3(TreeNode root){
        if(root == null) return 0;
        int leftHeight = getHeight3(root.left);
        if(leftHeight == -1) return -1;
        int rightHeight = getHeight3(root.right);
        if(rightHeight == -1) return -1;
        int sub = Math.abs(leftHeight-rightHeight);
        if(sub > 1){
            return -1;
        }else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
