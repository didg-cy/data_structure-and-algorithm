import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Semaphore;

public class Demo2 {

    static boolean isBalanceTree(TreeNode root) {

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

}
