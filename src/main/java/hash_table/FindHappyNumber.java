package hash_table;

import java.util.HashSet;
import java.util.Set;

public class FindHappyNumber {

    //有 String 和 int 转换的开销，仍有优化空间
//    public boolean findHappyNum(int n){
//        Set<Integer> set = new HashSet<>();
//        while(n != 1) {
//            int sum = 0;
//            String intToString = String.valueOf(n);
//            for (int i = 0; i < intToString.length(); i++) {
//                char singleItem = intToString.charAt(i);
//                int stringToInt = Integer.parseInt(String.valueOf(singleItem));
//                int square = stringToInt * stringToInt;
//                sum += square;
//            }
//            n = sum;
//            if (set.contains(n)) {
//                return false;
//            }
//            set.add(n);
//        }
//        return true;
//    }

    public boolean findHappyNum(int n){
        Set<Integer> set = new HashSet<>();
        while(n != 1) {
            int sum = 0;
            while(n > 0) {
                int singleItem = n % 10;
                sum += singleItem * singleItem;
                n /= 10;
            }
            n = sum;
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
        return true;
    }

}
