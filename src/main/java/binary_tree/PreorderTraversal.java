package binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
//递归法
public class PreorderTraversal {

    List<Integer> list = new ArrayList<>();
    public void preorder(TreeNode root){
        if(root == null){
            return;
        }
        list.add(root.value);
        preorder(root.left);
        preorder(root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root){
        preorder(root);
        return list;
    }
}
 */

//迭代法
public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        stack.offerFirst(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pollFirst();
            list.add(node.val);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return list;
    }
}