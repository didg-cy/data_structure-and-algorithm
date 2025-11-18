package binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LevelOrder {

    // 迭代法求解
    static void levelOrder(TreeNode root){
        if(root == null){
            System.out.println(-1);
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        List<List<Integer>> levelList = new ArrayList<>();
        while(!queue.isEmpty()){
            int length = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<length;i++){
                TreeNode node = queue.pollFirst();
                level.add(node.val);
                queue.addLast(node.left);
                queue.addLast(node.right);
            }
            levelList.add(level);
        }
        // 下面都是定义输出的格式
        String str = "[";
        for(List<Integer> list:levelList){
            String s = "[";
            for(int i:list){
                if(i == list.getLast()){
                    s += i+"]";
                    continue;
                }
                s += i + ",";
            }
            if(list == levelList.getLast()){
                str += s + "]";
                continue;
            }
            str += s + ",";
        }
        System.out.println(str);
    }
}
