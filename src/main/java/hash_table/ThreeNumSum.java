package hash_table;

import java.util.*;

public class ThreeNumSum {

    public List<int[]> getPair(int[] a){

        List<int[]> pairList = new ArrayList<>();
        for(int left = 0;left<a.length-1;left++){
            for(int right= left + 1;right<a.length;right++){
                int[] pair = {a[left], a[right], left, right};
                pairList.add(pair);
            }
        }
        return pairList;
    }

    public Set<List<Integer>> findThreeNum(int[] a, int t){

        Map<Integer,List<int[]>> hashMap = new HashMap<>(); //List<int[]> 避免相同 key 的 value 被覆盖
        List<int[]> pairList = getPair(a);
        Set<List<Integer>> tupleList = new HashSet<>(); //List<Integer> 便于给元组元素排序  hashSet便于给元组去重
        for(int[] arr:pairList) {
            int sum = arr[0] + arr[1];
            hashMap.computeIfAbsent(sum, k -> new ArrayList<>()).add(arr);
        }
        for(int i = 0; i<a.length; i++){
            if(hashMap.containsKey(t-a[i])){
                List<int[]> list = hashMap.get(t-a[i]);
                for(int[] temp:list){
                    int otherIndex2 = temp[2],otherIndex3 = temp[3];
                    if(i != otherIndex2  && i != otherIndex3){  //索引校验，避免同一元素被使用两次
                        List<Integer> tuple = new ArrayList<>();
                        tuple.add(a[i]);
                        tuple.add(temp[0]);
                        tuple.add(temp[1]);
                        tuple.sort(null);
                        tupleList.add(tuple);
                    }
                }
            }
        }

        return tupleList;
    }

    public static void main(String[] args){

        int[] arr = {-1, 0, 1, 2, -1, -4};
        ThreeNumSum e = new ThreeNumSum();
        Set<List<Integer>> tupleList = e.findThreeNum(arr,0);
        for(List<Integer> arr1:tupleList){
            System.out.println(arr1);
        }
    }
}
