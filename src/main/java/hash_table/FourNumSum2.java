package hash_table;

import java.util.*;

//同一个数组的四数之和-哈希表方法
public class FourNumSum2 {


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

    public Set<List<Integer>> findFourNum(int[] a, int t){

        Map<Integer,List<int[]>> hashMap = new HashMap<>(); //List<int[]> 避免相同 key 的 value 被覆盖
        List<int[]> pairList = getPair(a);
        Set<List<Integer>> tupleList = new HashSet<>(); //List<Integer> 便于给元组元素排序  hashSet便于给元组去重
        for(int[] arr:pairList){
            int sum = arr[0] + arr[1];
            int index1 = arr[2],index2 = arr[3];
            if(hashMap.containsKey(t-sum)){
                List<int[]> list = hashMap.get(t-sum);
                for(int[] temp:list){
                    int otherIndex3 = temp[2],otherIndex4 = temp[3];
                    if(index1 != otherIndex3 && index1 != otherIndex4  && index2 != otherIndex3 && index2 != otherIndex4){  //索引校验，避免同一元素被使用两次
                        List<Integer> tuple = new ArrayList<>();
                        tuple.add(arr[0]);
                        tuple.add(arr[1]);
                        tuple.add(temp[0]);
                        tuple.add(temp[1]);
                        tuple.sort(null);
                        tupleList.add(tuple);}
                }
            }
            hashMap.computeIfAbsent(sum, k->new ArrayList<>()).add(arr);    //若 key对应的 value 不存在则新建并返回，若存在则直接返回
        }
        return tupleList;
    }

    public static void main(String[] args){

        int[] arr = {1, 0, -1, 0, -2, 2};
        FourNumSum2 e = new FourNumSum2();
        Set<List<Integer>> tupleList = e.findFourNum(arr,0);
        for(List<Integer> arr1:tupleList){
            System.out.println(arr1);
        }
    }
}
