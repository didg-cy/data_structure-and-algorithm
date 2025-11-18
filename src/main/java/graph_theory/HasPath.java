package graph_theory;

import java.util.Scanner;

public class HasPath {

    static int[] parent;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();
            parent = new int[n+1];
            for(int i = 1; i<=n; i++){
                parent[i] = i;
            }
            int numEdge = in.nextInt();
            for(int i = 0; i<numEdge; i++){
                int a = in.nextInt();
                int rootA = find(a);
                int b = in.nextInt();
                int rootB = find(b);
                if(rootB != rootA){
                    parent[rootB] = rootA;
                }
            }
            int source = in.nextInt();
            int destination = in.nextInt();
            if(find(source) == find(destination)){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }

    static int find(int i) {
        if (i != parent[i]) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }
}
