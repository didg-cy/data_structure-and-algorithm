package written_test;

import java.util.*;

// 时间复杂度 O（n^4),仍需优化
// 逐层遍历村落矩阵，每层的村落集合都大于 0 且总层数大于等于 9，返回此时的海拔高度
// （9 其实是从上往下的层数，但层数的数量作为遍历条件是不合适的，仍然应该用目的地节点来作为判断条件）
/*
public class VillageFloodEscape {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            // 获取村落海拔矩阵（矩阵每个格子的索引即代表一个村落）
            int n = in.nextInt();
            int[][] grid = new int[n][n];
            List<Integer> arr = new ArrayList<>();  // 用于二分查找的海拔数组
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    grid[i][j] = in.nextInt();
                    arr.add(grid[i][j]);
                }
            }

            // 找到逃生时间的区间
            int minT = Math.max(grid[0][0],grid[n-1][n-1]);
            Collections.sort(arr);
            int index = Collections.binarySearch(arr, minT);
            Deque<int[]> queue = new ArrayDeque<>();
            for(int i = index; i<n*n; i++){
                // 广度优先搜索
                List<int[]> checkedVillage = new ArrayList<>();   // 存放已查看过高度的村落
                List<List<int[]>> layerList = new ArrayList<>();     // 存放层序遍历的每层村落，每层数量的相乘即为可达路径数
                queue.addLast(new int[]{0,0});
                while(!queue.isEmpty()){
                    int length = queue.size();
                    List<int[]> layer = new ArrayList<>();  // 存放层序遍历中每层的海拔小于等于 t 的村落
                    for(int k=0; k<length; k++){
                        int[] village = queue.pollFirst();
                        int height = grid[village[0]][village[1]];  // 海拔小于 t 才能继续后面的子节点加入队列
                        if(height > arr.get(i)){
                            checkedVillage.add(village);
                            continue;
                        }
                        // 将满足条件的节点加入该层
                        layer.add(village);
                        checkedVillage.add(village);
                        //将子节点加入队列
                        int[] top = new int[]{village[0]-1,village[1]};
                        int[] down = new int[]{village[0]+1,village[1]};
                        int[] left = new int[]{village[0],village[1]-1};
                        int[] right = new int[]{village[0],village[1]+1};
                        if(village[0]-1 >= 0 && notContain(checkedVillage,top)){
                            queue.addLast(top);
                        }
                        if(village[0]+1 <= n-1 && notContain(checkedVillage,down)){
                            queue.addLast(down);
                        }
                        if(village[1]-1 >= 0 && notContain(checkedVillage,left)){
                            queue.addLast(left);
                        }
                        if(village[1]+1 <= n-1 && notContain(checkedVillage,right)){
                            queue.addLast(right);
                        }
                    }
                    if(!layer.isEmpty()){
                        layerList.add(layer);
                    }else{
                        break;
                    }
                }
                if(layerList.size() >= 2*n-1){
                    System.out.println(arr.get(i));
                    break;
                }
            }
        }
    }

    static boolean notContain(List<int[]> a, int[] b){
        boolean flag = true;
        for(int[] i:a){
             if(Arrays.equals(i,b)){
                 flag = false;
                 break;
             }
        }
        return flag;
    }
}
 */

// 二分查找 + 包含终点的路径的广度优先搜索
public class VillageFloodEscape {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            // 获取村落海拔矩阵（矩阵每个格子的索引即代表一个村落）
            int n = in.nextInt();
            int[][] grid = new int[n][n];
            List<Integer> arr = new ArrayList<>();  // 用于二分查找的海拔数组
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = in.nextInt();
                    arr.add(grid[i][j]);
                }
            }
            Collections.sort(arr);
            int left = Collections.binarySearch(arr,Math.max(grid[0][0],grid[n-1][n-1]));
            // 二分查找结束条件
            int right = arr.get(n*n-1);
            int mid = left + (right-left)/2;
            boolean findInLeftArea = false;         // 标识符，区分向左还是向右查找
            List<Integer> b = new ArrayList<>();    //存放所有符合的二分查找值
            while(left <= right){
                Deque<int[]> queue = new ArrayDeque<>();
                boolean[][] test = new boolean[n][n];   // 标识已搜索节点
                queue.add(new int[]{0,0});
                // 广度优先搜索
                while(!queue.isEmpty()){
                    int length  = queue.size();
                    for(int i = 0; i<length; i++){
                        int[] temp = queue.pollFirst();
                        test[temp[0]][temp[1]] = true;  // 避免重复搜索
                        //查找与当前节点相连节点
                        int row = temp[0];
                        int column = temp[1];
                        if(row-1 >= 0 && grid[row-1][column] <= mid){
                            int[] a = new int[]{temp[0]-1,temp[1]};
                            if(!test[row-1][column]){
                                queue.add(a);
                            }
                        }
                        if(row+1 <= n-1 && grid[row+1][column] <= mid){
                            int[] a = new int[]{temp[0]+1,temp[1]};
                            if(!test[row+1][column]){
                                queue.add(a);
                            }
                        }
                        if(column-1 >= 0 && grid[row][column-1] <= mid){
                            int[] a = new int[]{temp[0],temp[1]-1};
                            if(!test[row][column-1]){
                                queue.add(a);
                            }
                        }
                        if(column+1 <= n-1&& grid[row][column+1] <= mid){
                            int[] a = new int[]{temp[0],temp[1]+1};
                            if(!test[row][column+1]){
                                queue.add(a);
                            }
                        }
                    }
                    // 如果出现终点，则记录当前的可行时间，然后进入下一轮二分查找（左区查找）
                    if(test[n-1][n-1]){
                        findInLeftArea = true;
                        b.add(mid);
                        break;
                    }
                }
                if(findInLeftArea){
                    right = mid -1;
                    mid = left + (right-left)/2;
                }else{
                    left = mid +1;
                    mid = left + (right-left)/2;
                }
            }
            Collections.sort(b);    // 排序后选择最短时间，起始可以不用数组，一个 int 变量即可
            System.out.println(b.get(0));
        }
    }
}
