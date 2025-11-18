package hash_table;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoNumSum {

    public int[] findTwoNum(int[] a, int t){

        //存在元素重复使用的问题
//        Map<Integer, Integer> map = new HashMap<>();
//        int[] res = new int[2];
//        int t1;
//        int t2;
//        for (int i = 0; i < a.length; i++){
//            map.put(a[i],i);
//        }
//        for (int i = 0; i < a.length; i++){
//            t2 = t-a[i];
//            if (map.containsKey(t2)){
//                int t2Index = map.get(t2);
//                int t1Index= i;
//                res[0] = t1Index;
//                res[1] = t2Index;
//            }
//        }
//        return res;

        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < a.length; i++){
            if(map.containsKey(t-a[i])){
                res[0] = map.get(t-a[i]);
                res[1] = i;
                break;
            }
            map.put(a[i],i);

        }
        return res;
    }

    public static void main(String[] args) {
        TwoNumSum twoNumSum = new TwoNumSum();
        System.out.println(Arrays.toString(twoNumSum.findTwoNum(new int[]{1,2,3,4,5,6,7,8,9}, 5)));
    }
}
