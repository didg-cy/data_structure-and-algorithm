package graph_theory;

import java.util.*;

public class RedundantEdge {

    private static int[] parent;

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();
            parent = new int[n+1];
            for(int i = 1; i<=n; i++){
                parent[i] = i;
            }
            for(int i = 0; i<n; i++){
                int a = in.nextInt();
                int b = in.nextInt();
                if(find(a) == find(b)){
                    System.out.println(a+" "+b);
                }else{
                    parent[find(b)] = find(a);
                }
            }
        }
    }

    static int find(int i){
        if(i != parent[i]){
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }
}
