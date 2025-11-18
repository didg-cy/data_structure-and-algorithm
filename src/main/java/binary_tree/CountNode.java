package binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CountNode {

    static int countNode(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<TreeNode> list = new ArrayList<>();
        if (root == null) return list.size();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.pollFirst();
            list.add(cur);
            if (cur.right != null) {
                queue.addLast(cur.right);
            }
            if (cur.left != null) {
                queue.addLast(cur.left);
            }
        }
        return list.size();
    }
}
