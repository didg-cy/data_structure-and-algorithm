package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class HasPathSum {

    // 前序遍历+回溯 找出所有路径并复制路径，然后逐个计算路径总和并比较，时间效率低在复制路径上
    boolean hasPathSum(TreeNode root, int targetSum){
        List<Integer> route = new ArrayList<>();
        List<List<Integer>> routes = new ArrayList<>();
        boolean flag = false;
        getRoute(root,route,routes);
        for(List<Integer> r:routes){
            int sum = 0;
            for(int e:r){
                sum += e;
            }
            if(sum == targetSum){
                flag = true;
                break;
            }
        }
        return flag;
    }

    void getRoute(TreeNode root, List<Integer> route,List<List<Integer>> routes) {
        if (root == null) return;
        route.add(root.val);
        if (root.left == null && root.right == null) {
            routes.add(new ArrayList<>(route));
        }
        getRoute(root.left, route, routes);
        getRoute(root.right, route, routes);
        route.removeLast();
    }

    // 优化时间效率版本：
    boolean hasPathSum2(TreeNode root, int targetSum){
        List<Integer> route = new ArrayList<>();
        return getRoute2(root, targetSum, route) == 1;
    }

    int getRoute2(TreeNode root, int targetSum, List<Integer> route) {
        if (root == null) return 0;
        route.add(root.val);
        if (root.left == null && root.right == null) {
            int result = 0;
            for(int e:route){
                result += e;
            }
            if(result == targetSum){
                route.removeLast();
                return 1;       // 意味着找到目标路径了，因此返回
            }else{
                route.removeLast();
                return 0;       // 意味着需继续寻找其他路径
            }
        }
        int left = getRoute2(root.left, targetSum, route);
        if(left == 1) return 1;
        int right = getRoute2(root.right, targetSum, route);
        if(right == 1) return 1;
        route.removeLast();
        return 0;
    }
}
