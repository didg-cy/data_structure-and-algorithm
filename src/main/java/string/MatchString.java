package string;

public class MatchString {

    public static int getMatchedIndex(String a, String b){

        int lenA = a.length();
        int lenB = b.length();
        int leftIndexOfA = 0;
        int rightIndexOfA = lenB-1;
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();

        while(rightIndexOfA < lenA){

            if(isMatched(A,leftIndexOfA,rightIndexOfA,B)){
                return leftIndexOfA;
            }else{
                leftIndexOfA++;
                rightIndexOfA++;
            }
        }
        return -1;
    }

    public static boolean isMatched(char[] a,int i,int j,char[] b){

        int k = 0;
        while(i <= j){
            if(a[i] == b[k]){
                i++;
                k++;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){

//        System.out.println(getMatchedIndex("hello", "ll"));
        System.out.println(getMatchedIndex("aaaaa", "bba"));
    }
}
