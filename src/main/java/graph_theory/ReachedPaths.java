package graph_theory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// 邻接矩阵来表示节点的连接关系
/*
public class ReachedPaths {

    static void dfs(List<List<Integer>> paths, LinkedList<Integer> path, List<List<Integer>> am, int current, int target){
        if(path.contains(current)){
            return;
        }
        path.add(current);
        if(current == target){
             paths.add(new ArrayList<>(path));
             path.removeLast();
             return;
         }
         for(int i:am.get(current)){
             dfs(paths, path, am,i,target);
         }
        path.removeLast();  //关键步，回溯
    }

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();
            int m = in.nextInt();
            // 创建一个邻接表，集合的索引 1-n 对应 1-n 个节点，索引对应的格子存放 List，List 里存放与该节点相连的其他节点
            List<List<Integer>> am = new ArrayList<>();
            for(int i = 0; i<=n; i++){
                am.add(new ArrayList<>());
            }
            // 遍历接下来输入的 m 行，将节点间的连接关系加入邻接表
            for(int i = 0; i<m; i++){
                int a = in.nextInt();
                int b = in.nextInt();
                am.get(a).add(b);
            }
            List<List<Integer>> paths = new ArrayList<>();
            LinkedList<Integer> path = new LinkedList<>();
            dfs(paths,path,am, 1,n);

            if(paths.isEmpty()){
                System.out.println(-1);
            }else{
                for(List<Integer> a:paths){
                    StringBuilder sb = new StringBuilder();
                    for(int i:a){
                        sb.append(i+" ");
                    }
                    System.out.println(sb.toString().trim());
                }
            }
        }
    }
}
*/

// 邻接表来表示节点的连接关系
class ReachedPaths2 {

    static void dfs(List<List<Integer>> paths, LinkedList<Integer> path, List<LinkedList<Integer>> am, int current, int target){
        if(path.contains(current)){
            return;
        }
        path.add(current);
        if(current == target){
            paths.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        for(int i:am.get(current)){     // 链表也支持 增强 for 循环
            dfs(paths, path, am,i,target);
        }
        path.removeLast();  //关键步，回溯
    }

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();
            int m = in.nextInt();
            // 创建一个邻接表，集合的索引 1-n 对应 1-n 个节点，索引对应的格子存放 List，List 里存放与该节点相连的其他节点
            List<LinkedList<Integer>> am = new ArrayList<>();
            for(int i = 0; i<=n; i++){
                am.add(new LinkedList<>());     //使用链表来存储与节点连接的其他节点
            }
            // 遍历接下来输入的 m 行，将节点间的连接关系加入邻接表
            for(int i = 0; i<m; i++){
                int a = in.nextInt();
                int b = in.nextInt();
                am.get(a).add(b);       // 加入链表
            }
            List<List<Integer>> paths = new ArrayList<>();
            LinkedList<Integer> path = new LinkedList<>();
            dfs(paths,path,am, 1,n);

            if(paths.isEmpty()){
                System.out.println(-1);
            }else{
                for(List<Integer> a:paths){
                    StringBuilder sb = new StringBuilder();
                    for(int i:a){
                        sb.append(i+" ");
                    }
                    System.out.println(sb.toString().trim());
                }
            }
        }
    }
}
