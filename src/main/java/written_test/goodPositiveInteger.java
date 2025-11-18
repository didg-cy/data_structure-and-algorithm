package written_test;

import java.util.Scanner;

public class goodPositiveInteger {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int length = in.nextInt();
            int count = 0;
            for(int i = 1;i<=length;i++){
                int a = in.nextInt();
                boolean flag = true;
                while(flag){
                    int subCount = 0;
                    while(a % 10 == 0){
                        a /= 10;
                        subCount++;
                    }
                    if(a / 10 > 0){
                        int sub = a % 10;
                        if(sub >= 5){
                            count = count + (10-sub);
                            a += (10-sub);
                        }else{
                            count += sub;
                            a -= sub;
                        }
                        count += subCount;
                    }else{
                        flag = false;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
