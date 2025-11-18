package hash_table;

import java.util.*;
//不同数组的四数之和-哈希表方法
// 返回元组的数量及元组中每个元素所在原数组中的索引
//public class hash_table.FourNumSum {
//
//    List<int[]> list = new ArrayList<>();
//    public List<int[]> findFourNum(int[] a, int[] b, int[] c , int[] d) {
//        Map<Integer, List<int[]>> map = new HashMap<>();
//
//        for (int i = 0; i < c.length; i++) {
//            for (int j = 0; j < d.length; j++) {
//                int[] tuple = new int[4];
//                int sumB = c[i] + d[j];
//                tuple[2] = i;
//                tuple[3] = j;
//                if (map.containsKey(sumB)) {
//                    map.get(sumB).add(tuple);
//                }else{
//                    List<int[]> list1 = new ArrayList<>();
//                    list1.add(tuple);
//                    map.put(sumB,list1);
//                }
//            }
//        }
//        for (int i = 0; i < a.length; i++) {
//            for(int j = 0; j < b.length; j++){
//                int sumA = a[i] + b[j];
//                if(map.containsKey(-sumA)){
//                    List<int[]> tem =  map.get(-sumA);
//                    for(int[] k:tem) {
//                        k[0] = i;
//                        k[1] = j;
//                        list.add(k);
//                    }
//                }
//            }
//        }
//        return list;
//    }
//
//    public static void main(String[] args){
//
//        int[] A ={1,2};
//        int[] B = {-2,-1};
//        int[] C = {-1, 2};
//        int[] D = { 0, 2};
//        hash_table.FourNumSum e = new hash_table.FourNumSum();
//        List<int[]> list = e.findFourNum(A,B,C,D);
//        for(int[] i:list){
//            System.out.println(Arrays.toString(i));
//        }
//
//    }
//}

// 仅返回元组的数量
public class FourNumSum1 {
    int count = 0;
    public int findFourNum(int[] a, int[] b, int[] c , int[] d) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < d.length; j++) {
                int sumB = c[i] + d[j];
                if (map.containsKey(sumB)) {
                    int tem = map.get(sumB)+1;
                    map.put(sumB,tem);
                }else{
                    map.put(sumB,1);
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            for(int j = 0; j < b.length; j++){
                int sumA = a[i] + b[j];
                if(map.containsKey(-sumA)){
                    int tem =  map.get(-sumA);
                    count += tem;
                }
            }
        }

        return count;
    }

    public static void main(String[] args){

        int[] A ={1,2};
        int[] B = {-2,-1};
        int[] C = {-1, 2};
        int[] D = { 0, 2};
        FourNumSum1 e = new FourNumSum1();
        int count = e.findFourNum(A,B,C,D);

        System.out.println(count);

    }
}


