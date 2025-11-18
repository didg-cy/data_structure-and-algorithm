package binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
//递归法
public class InorderTraversal {

    List<Integer> list = new ArrayList<>();
    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        list.add(root.value);
        inorder(root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root){
        inorder(root);
        return list;
    }
}
*/

//迭代法
public class InorderTraversal {

    /**
    第一版解法
    public List<Integer> inorderTraversal(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            }

            cur = stack.pollFirst();
            list.add(cur.value);
            cur = cur.right;
        }
        return list;
    }
    */
    // 第二版解法，与后序迭代遍历的思路相同
    public List<Integer> inorderTraversal(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.addFirst(cur);
                cur = cur.left;
            }
            cur = stack.pollFirst();
            list.add(cur.val);
            if(cur.right != null){
                cur = cur.right;
            }else{
                cur = null;
            }
        }
        return list;
    }
}