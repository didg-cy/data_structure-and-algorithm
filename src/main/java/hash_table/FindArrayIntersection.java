package hash_table;

import java.util.*;

public class FindArrayIntersection {

    // 时间复杂度为 O(n*n)
//    public static List findArrayIntersection(int[] a, int[] b) {
//        List list = new ArrayList();
//
//        for (int i = 0; i < a.length; i++) {
//            int isCross = 0;
//            for (int j = 0; j < b.length; j++) {
//                if (a[i] == b[j]) {
//                    isCross++;
//                    if(isCross == 1){
//                        list.add(a[i]);
//                    }
//                }
//            }
//        }
//        return list;
//    }

    //时间复杂度 O（m+n+k),add()和 contain()一般在哈希函数设计合理的情况下时间复杂度是O（1）
    public  int[] findArrayIntersection(int[] A, int[] B){

        Set<Integer> setA = new HashSet();
        Set<Integer> intersectionSet = new HashSet();
        for(int i = 0; i < A.length; i++){
            setA.add(A[i]);

        }
        for(int i = 0; i < B.length; i++){
            if(setA.contains(B[i])){
                intersectionSet.add(B[i]);
            }
        }

        return intersectionSet.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        //返回的是数组的默认输出
    }


    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] b = { 1,1,1 };
        FindArrayIntersection example = new FindArrayIntersection();
        System.out.println(Arrays.toString(example.findArrayIntersection(a,b)));
        //Arrays.toString,将数组的默认输出（十六进制格式）转换为自然语言
    }
}
