package string;

public class MatchStringKMP {

    public static int getFirstIndex(String str, String pattern){
        int i = 0;
        int j = 0;
        int n = str.length();
        int m = pattern.length();
        int[] next = getNext(pattern);
        while( i<n ){

            while(j > 0 && str.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if(str.charAt(i) == pattern.charAt(j) ){
                j++;
            }
            i++;
            if(j == m){
                return i-j;
            }
        }
        return -1;
    }

    public static int[] getNext(String pattern){

        int length = pattern.length();
        int[] next = new int[length];
        next[0] = 0;
        int k = 0;
        for(int i = 1; i<length; i++){

            while ( k > 0 && pattern.charAt(k) != pattern.charAt(i)) {

                k = next[k - 1];
            }
            if(pattern.charAt(k) == pattern.charAt(i)){
                k++;
            }

            next[i] = k;
        }
        return next;
    }

    public static void main(String[] args){

        System.out.println(getFirstIndex( "mississippi","issip"));
    }
}
