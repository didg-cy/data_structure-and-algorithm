package hash_table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//同一数组的四数之和--双指针法
public class FourNumSum {
    static List<int[]> findFourSum(int[] a, int t) {

        Arrays.sort(a);
        List<int[]> tupleList = new ArrayList<>();
        if (a.length < 4) {
            return tupleList;
        }
        for (int j = 0; j < a.length - 3; j++) {
            if (j > 0 && a[j - 1] == a[j]) {
                continue;
            }
            for (int i = j+1; i < a.length - 2; i++) {
                if (i > 1 && a[i - 1] == a[i]) {
                    continue;
                }
                int left = i + 1;
                int right = a.length - 1;
                while (left < right) {
                    int sum = a[j] + a[i] + a[left] + a[right];
                    if (sum == t) {
                        int[] tuple = {a[j], a[i], a[left], a[right]};
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
        }
        return tupleList;
    }

    public static void main(String[] args) {

        int[] a = {1, 0, -1, 0, -2, 2};

        List<int[]> tupleList = findFourSum(a, 0);
        for (int[] i : tupleList) {
            System.out.println(Arrays.toString(i));
        }
    }
}
