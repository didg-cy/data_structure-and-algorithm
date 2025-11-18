package written_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockTrade {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int m = in.nextInt();
            int k = in.nextInt();
            int n = in.nextInt();
            int[] sale = new int[n];
            for(int i = 0; i < n; i++){
                sale[i] = in.nextInt();
            }
            // 新建两个数组，分别存放持有货物时每天的最大收入和未持有货物时每天的最大收入
            int[] maxIncomeWithStock = new int[n];
            int[] maxIncomeWithoutStock = new int[n];
            maxIncomeWithStock[0] = -sale[0]-k;
            maxIncomeWithoutStock[0] = m;
            for(int i = 1; i < n; i++){
                maxIncomeWithStock[i] = Math.max(maxIncomeWithStock[i-1], -sale[i]-k+maxIncomeWithoutStock[i-1]);
                maxIncomeWithoutStock[i] = Math.max(maxIncomeWithoutStock[i-1]+m, sale[i]-k+maxIncomeWithStock[i-1]);
            }
            System.out.println(Math.max(maxIncomeWithStock[n-1],maxIncomeWithoutStock[n-1]));
        }
    }
}
