import java.util.*;

public class Print2DArrayList {

    public static void main(String[] args) {
        List<List<Integer>> levelList = new ArrayList<>();
        List<Integer> arr1 = new ArrayList<>();
        arr1.add(3);
        levelList.add(arr1);
        List<Integer> arr2 = new ArrayList<>();
        arr2.add(9);
        arr2.add(20);
        levelList.add(arr2);
        List<Integer> arr3 = new ArrayList<>();
        arr3.add(15);
        arr3.add(7);
        levelList.add(arr3);


        String str = "[";
        for(List<Integer> list:levelList){
            String s = "[";
            for(int i:list){
                if(i == list.getLast()){
                    s += i+"]";
                    continue;
                }
                s += i + ",";
            }
            if(list == levelList.getLast()){
                str += s + "]";
                continue;
            }
            str += s + ",";
        }
        System.out.println(str);
    }
}
