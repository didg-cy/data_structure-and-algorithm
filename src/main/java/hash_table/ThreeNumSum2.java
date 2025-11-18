package hash_table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumSum2 {

    static List<int[]> findThreeSum(int[] a, int t) {

        Arrays.sort(a);
        List<int[]> tupleList = new ArrayList<>();
        if (a.length < 3 || a[0] > t) {
            return tupleList;
        }
        for (int i = 0; i < a.length - 2; i++) {

            if (i > 0 && a[i - 1] == a[i]) {
                continue;
            }
            int left = i + 1;
            int right = a.length - 1;
            while (left < right) {
                int sum = a[i] + a[left] + a[right];
                if (sum == t) {
                    int[] tuple = {a[i], a[left], a[right]};
                    tupleList.add(tuple);

                    while (left < right && a[right - 1] == a[right]) {
                        right--;
                    }
                    while (left < right && a[left + 1] == a[left]) {
                        left++;
                    }
                    right--;
                    left++;
                } else if (sum > t) {
                    right--;
                } else {
                        left++;
                }
            }
        }
        return tupleList;
    }

    public static void main(String[] args) {

        int[] a = {-1, 0, 1, 2, -1, -4};

        List<int[]> tupleList = findThreeSum(a, 0);
        for (int[] i : tupleList) {
            System.out.println(Arrays.toString(i));
        }
    }
}
