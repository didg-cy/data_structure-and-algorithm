package binary_tree;

import java.util.ArrayList;
import java.util.List;

// 根节点到达叶子节点的所有路径：前序遍历加回溯
public class GetAllRoutes {

    List<List<String>> allRoutes = new ArrayList<>();
    List<String> route = new ArrayList<>();
    List<String> result = new ArrayList<>();

    List<String> getAllRoutes(TreeNode root){
        getRoute(root);
        for(List<String> l:allRoutes){
            String str = String.join("",l);
            result.add(str);
        }
        return result;
    }

    void getRoute(TreeNode root){
        if(root == null) return;
        route.add(String.valueOf(root.val));
        if(root.left == null && root.right == null){
            allRoutes.add(new ArrayList<>(route));
        }
        getRoute(root.left);
        if(root.left != null) route.removeLast();
        getRoute(root.right);
        if(root.right != null) route.removeLast();
    }
}
