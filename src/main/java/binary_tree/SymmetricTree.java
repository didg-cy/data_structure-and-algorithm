package binary_tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 第一版，使用两个 ArrayDeque 实现
 * 迭代法
public class SymmetricTree {

    Deque<TreeNode> leftTree;
    Deque<TreeNode> rightTree;
    public boolean isSymmetric(TreeNode root){
        leftTree = new ArrayDeque<>();
        rightTree = new ArrayDeque<>();
        if(root == null) return false;
        if(root.left != null && root.right != null && root.left.val == root.right.val){
            leftTree.addLast(root.left);
            rightTree.addLast(root.right);
        }else if(root.left == null && root.right == null){
            return true;
        }else{
            return false;
        }
        while(!leftTree.isEmpty()){
            TreeNode left = leftTree.pollFirst();
            TreeNode right = rightTree.pollFirst();
            boolean flag = isMathchAndAdd(left,right);
            if(!flag){
                return false;
            }
        }
        return true;
    }

    public boolean isMathchAndAdd(TreeNode left, TreeNode right){
        if(left.left != null && right.right == null){
            return false;
        }
        if(left.left == null && right.right != null){
            return false;
        }
        if(left.right != null && right.left == null){
            return false;
        }
        if(left.right == null && right.left != null){
            return false;
        }
        if(left.left != null && right.right != null && left.left.val == right.right.val){
            leftTree.addLast(left.left);
            rightTree.addLast(right.right);
        }else if(left.left != null && right.right != null && left.left.val != right.right.val){
            return false;
        }
        if(left.right != null && right.left != null && left.right.val == right.left.val){
            leftTree.addLast(left.right);
            rightTree.addLast(right.left);
        }else if(left.right != null && right.left != null && left.right.val != right.left.val){
            return false;
        }

        return true;
    }
}
 */
// 优化版-第二版 使用一个 LinkedList 实现
public class SymmetricTree {

    boolean isSymmertic(TreeNode root){
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root.left);
        queue.addLast(root.right);
        while(!queue.isEmpty()){
            TreeNode left =queue.pollFirst();
            TreeNode right = queue.pollFirst();
            if(left == null && right != null){
                return false;
            }
            if(left != null && right == null){
                return false;
            }
            if(left != null && right != null && left.val != right.val){
                return false;
            }
            if(left != null && right != null){
                queue.addLast(left.left);
                queue.addLast(right.right);
                queue.addLast(left.right);
                queue.addLast(right.left);
            }
        }
        return true;
    }
}