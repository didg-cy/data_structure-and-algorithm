package binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


//递归遍历
public class PostorderTraversal {

    //递归法的后序遍历
    List<Integer> list = new ArrayList<>();
    public void postorder1(TreeNode root){
        if(root == null){
            return;
        }
        postorder1(root.left);
        postorder1(root.right);
        list.add(root.val);
    }

    public List<Integer> postorderTraversal1(TreeNode root){
        postorder1(root);
        return list;
    }


    //迭代法的后序遍历
    public List<Integer> postorderTraversal2(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;    // 当前访问过的节点
        TreeNode pre = null;    // 刚刚访问过的节点

        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.offerFirst(cur);
                cur = cur.left;
            }
            cur = stack.peekFirst();
            if(cur.right != null && cur.right != pre){
                cur = cur.right;
            }else{
                cur = stack.pollFirst();
                list.add(cur.val);
                pre = cur;
                cur = null;
            }
        }
        return list;
    }

}
