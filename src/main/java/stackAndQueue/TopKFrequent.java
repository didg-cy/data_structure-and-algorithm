package stackAndQueue;

import java.util.*;

public class TopKFrequent {

    public static int[] topKFrequent(int[] arr, int k){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:arr){
            if(!map.containsKey(i)){
                map.put(i,1);
            } else{
                int count = map.get(i);
                count++;
                map.put(i,count);
            }
        }
        List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(map.entrySet());
        List<Integer> topK = new ArrayList<>();
//        entryList.sort(Comparator.comparing(Map.Entry<Integer, Integer>::getValue).reversed());
        Comparator<Map.Entry<Integer,Integer>> comparator = (e1,e2) -> e1.getValue().
                compareTo(e2.getValue());
        comparator = comparator.reversed();
        Collections.sort(entryList,comparator);
        for(int i =0;i<k;i++){
            topK.add(entryList.get(i).getKey());
        }
        return topK.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
