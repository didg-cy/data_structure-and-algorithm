package binary_tree;

import java.util.ArrayList;
import java.util.List;

// 根节点到达叶子节点的所有路径：前序遍历加回溯
public class GetAllRoutes {

    List<List<String>> allRoutes = new ArrayList<>();
    List<String> route = new ArrayList<>();
    List<String> result = new ArrayList<>();

    // 获取所有路径
    List<String> getAllRoutes(TreeNode root){
        getRoute1(root);
        for(List<String> l:allRoutes){
            String str = String.join("",l);
            result.add(str);
        }
        return result;
    }

    // 版本一：前序遍历+回溯 获取根节点到叶节点的每条路线
    void getRoute1(TreeNode root){
        if(root == null) return;
        route.add(String.valueOf(root.val));
        if(root.left == null && root.right == null){
            allRoutes.add(new ArrayList<>(route));
        }
        getRoute1(root.left);
        if(root.left != null) route.removeLast();
        getRoute1(root.right);
        if(root.right != null) route.removeLast();
    }

    // 版本一的优化
    void getRoute2(TreeNode root){
        if(root == null) return;
        route.add(String.valueOf(root.val));
        if(root.left == null && root.right == null){
            allRoutes.add(new ArrayList<>(route));
        }
        getRoute2(root.left);
        getRoute2(root.right);
        route.removeLast();
    }
}
