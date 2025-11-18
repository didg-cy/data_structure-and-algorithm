package written_test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

// 自己编造的题目
// 输入输出模式下按层序遍历结果构造 满二叉树
public class ConstructBinaryTree {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            // 构造二叉树数组
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                int a = in.nextInt();
                arr[i] = a;
            }
            // 层序遍历
            Deque<Integer> queue = new ArrayDeque<>();
            queue.addLast(0);
            ArrayList<ArrayList<Integer>> levelList = new ArrayList<>();
            while(queue.peekFirst() < n){
                int length = queue.size();
                ArrayList<Integer> level = new ArrayList<>();
                for(int i=0;i<length;i++){
                    int node = queue.pollFirst();
                    level.add(arr[node]);
                    queue.addLast(node*2+1);
                    queue.addLast(node*2+2);
                }
                levelList.add(level);
            }
            // 下面都是定义输出的格式
            String str = "[";
            for(int i=0;i<levelList.size();i++){
                ArrayList<Integer> list = levelList.get(i);
                String s = "[";
                for(int j=0;j<list.size();j++){
                    if(j == list.size()-1){
                        s += list.get(j) + "]";
                        continue;
                    }
                    s += list.get(j) + ",";
                }
                if(i == levelList.size()-1){
                    str += s + "]";
                    continue;
                }
                str += s + ",";
            }
            System.out.println(str);
        }
    }
}
