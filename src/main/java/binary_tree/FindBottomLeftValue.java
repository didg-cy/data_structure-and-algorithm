package binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FindBottomLeftValue {

    // 方法一：层序遍历，用数组存储每一层，最后一层的第一个即为所求
    int findBottomLeftValue(TreeNode root){
        List<List<TreeNode>> layers = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            layers.add(new ArrayList<>(queue));
            for(int i = 0; i<len; i++){
                TreeNode cur = queue.pollFirst();
                if(cur.left != null) queue.addLast(cur.left);
                if(cur.right != null) queue.addLast(cur.right);
            }
        }
        List<TreeNode> lastLayer = layers.get(layers.size()-1);
        return lastLayer.get(0).val;
    }

    // 方法一的优化版：无需存储每一层，仅需一个队列和一个指针（指针指向无子节点的节点，随着层序遍历不断更新），
    // 注意，加入队列的顺序是从右往左，这样最后一层的最后一个节点即为所求。
}
