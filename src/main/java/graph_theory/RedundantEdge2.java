package graph_theory;

import java.util.*;

/**
// 初始复杂版本 O(n^2)
public class RedundantEdge2 {

    private static int[] parent;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            parent = new int[n+1];              // 存放每个节点的父节点
            int redundant = 0;                  // 记录多于 1 个父节点的节点
            int[] redundantParent = new int[2]; // 记录某个节点的多个父节点
            boolean isLoop = false;             // 为了读取完输入数据且不让后面的输入覆盖掉目标值而设置
            int[] loopEdge = new int[2];        // 存放冗余边
            for(int i = 1; i<=n; i++){
                parent[i] = i;
            }
            for(int i = 0; i<n; i++){
                int a = in.nextInt();
                int b = in.nextInt();
                if(parent[b] == b){      // 判断该节点是否有多于一个父节点
                    parent[b] = a;
                }else{
                    redundantParent[0] = parent[b];
                    redundantParent[1] = a;
                    redundant = b;
                }
                if(redundant > 0){      // 入度大于 1 时是否有环
                    for(int j = 0; j<2; j++){
                        parent[redundant] = redundantParent[j];    // 先试一条边是否成环
                        if(!isLoop && findLoop(redundant)){
                            isLoop = true;
                            loopEdge[0] = redundantParent[j];
                            loopEdge[1] = redundant;
                        }
                    }
                }else{// 入度等于 1 时是否有环
                    if(!isLoop && findLoop(b)){
                        isLoop = true;
                        loopEdge[0] = a;
                        loopEdge[1] = b;
                    }
                }
            }
            if(isLoop){
                System.out.println(loopEdge[0]+" "+loopEdge[1]);
            }else if(redundant >0 ){    // 如果无环且存在入度 > 1 的节点
                System.out.println(redundantParent[1]+" "+redundant);
            }
        }
    }
    // 判断是否存在环
    static boolean findLoop(int child) {
        int p = parent[child];
        for (int steps = 0; steps <= parent.length; steps++) {
            if(child == p){
                return true;
            }else{
                p = parent[p];
            }
        }
        return false;
    }
}
*/

// 优化版本 O（n)
public class RedundantEdge2 {

    private static int[] parent;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            parent = new int[n + 1];              // 存放每个节点的父节点
            int redundant = 0;                  // 记录多于 1 个父节点的节点
            int[] redundantParent = new int[2]; // 记录某个节点的多个父节点
            boolean isLoop = false;             // 为了读取完输入数据且不让后面的输入覆盖掉目标值而设置
            List<int[]> inputEdge = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < n; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                inputEdge.add(new int[]{a,b});  // 将边按输入顺序存起来
                if(b == parent[b]){
                    parent[b] = a;
                }else{
                    redundant = b;
                    redundantParent[0] = parent[b];
                    redundantParent[1] = a;
                }
            }
            // 接下来判断是否成环
            // 入度大于 1 的情形对两条边分别判断是否成环
            if(redundant > 0){
                for(int i = 0; i < 2; i++){
                    parent[redundant] = redundantParent[i];
                    int loopNode = findLoop(redundant);
                    if(loopNode > -1){  // 说明成环且入度大于1
                        System.out.println(redundantParent[i]+" "+redundant);
                        isLoop = true;
                    }
                }
                if(!isLoop){
                    System.out.println(redundantParent[1]+" "+redundant);
                }
            }
            // 成环且入度等于 1 的情形
            if(redundant == 0){
                int loopNode = findLoop(1); // 随便找一个节点
                // 记录成环节点
                Set<Integer> set = new HashSet<>();
                for (int steps = 0; steps <= parent.length; steps++) {
                    if (!set.contains(loopNode)) {
                        set.add(loopNode);
                        loopNode = parent[loopNode];
                    } else {
                        break;
                    }
                }
                // 查找输入里最后导致成环的边
                Collections.reverse(inputEdge);
                for(int[] i:inputEdge){
                    if(set.contains(i[0]) && set.contains(i[1])){
                        System.out.println(i[0]+" "+i[1]);
                        break;
                    }
                }
            }
        }
    }
    // 判断是否存在环,存在则返回成环节点，不存在环则返回-1
    static int findLoop(int p) {
        int node = p;
        Set<Integer> set = new HashSet<>(); // 记录回溯路径
        for (int steps = 0; steps <= parent.length; steps++) {
            if(node == parent[node]){       // 避免根节点互指
                return -1;
            }
            if(!set.contains(node)){
                set.add(node);
                node = parent[node];
            }else{
                return node;
            }
        }
        return -1;
    }
}