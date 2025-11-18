package written_test;

import java.util.*;

public class NumOfDifferentLIS {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String a = in.nextLine();
            int numTests = Integer.parseInt(a);
            for(int i= 0; i<numTests; i++){
                String b = in.nextLine();
                int n = Integer.parseInt(b);
                String c = in.nextLine();
                String[] parts = c.trim().split("\\s+");
                int[] arr = new int[n];
                for(int j= 0; j<n; j++){
                    arr[j] = Integer.parseInt(parts[j]);
                }
                //求出数组的 LIS
                List<Integer> tails = new ArrayList<>();
                for(int k:arr){
                    if(tails.isEmpty()){
                        tails.add(k);
                    }else{
                        if(k > tails.get(tails.size()-1)){
                            tails.add(k);
                        }else{
                            int index = Collections.binarySearch(tails,k);
                            if(index < 0){
                                index = -index-1;
                                tails.set(index,k);
                            }
                        }
                    }
                }
                int len_LIS = tails.size();
                // 接下来构造 DP 数组来求len_start、len_end
                int[] len_end_DP = new int[n];
                // DP 数组的初始化
                Arrays.fill(len_end_DP,1);
                // 求 len_end_DP 数组
                for(int j= 0; j<n; j++){
                    for(int k= 0; k<j; k++){
                        if(arr[k] < arr[j]){
                            len_end_DP[j] = Math.max(len_end_DP[j],len_end_DP[k]+1);
                        }
                    }
                }
                // 求 len_start_DP 数组
                int[] len_start_DP = new int[n];
                // DP 数组的初始化
                Arrays.fill(len_start_DP,1);
                for(int j= n-1; j>=0; j--){
                    for(int k= n-1; k>j; k--){
                        if(arr[k] > arr[j]){
                            len_start_DP[j] = Math.max(len_start_DP[j], len_start_DP[k]+1);
                        }
                    }
                }
                // 数组的初始化
                List<HashSet<Integer>> group = new ArrayList<>();
                // HashSet 的初始化
                for(int m= 0; m<=len_LIS; m++){
                    group.add(new HashSet<>());
                }
                //筛选组成 LIS 的元素并将 LIS 中相同位置的元素放在一起
                for(int j= 0; j<n; j++){
                    if(len_end_DP[j] + len_start_DP[j] -1 == len_LIS){
                        group.get(len_end_DP[j]).add(arr[j]);
                    }
                }
                Long multi = 1L;
                for(int m= 1; m<=len_LIS; m++){
                    multi *= group.get(m).size();
                }
                System.out.println(multi % 998244353);
            }
        }
    }
}
