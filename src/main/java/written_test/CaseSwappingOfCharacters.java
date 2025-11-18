package written_test;

import java.util.Scanner;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

public class CaseSwappingOfCharacters {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int x = 1;
        while (in.hasNext()) {
            int length = in.nextInt();
            String s = in.next();
            char[] arr = s.toCharArray();
            for (int i = 1; i < length; i++) {
                int sum = i + x;
                if (sum <= length && isUpperCase(arr[sum - 1])) {
                    arr[sum-1] = Character.toLowerCase(arr[sum-1]);
                    x++;
                    if (isLowerCase(arr[i - 1])) {
                        arr[i-1] = Character.toUpperCase(arr[i-1]);
                    }
                }
            }
            System.out.println(new String(arr));
        }
    }
}
