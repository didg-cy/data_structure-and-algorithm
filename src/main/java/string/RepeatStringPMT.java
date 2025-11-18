package string;

public class RepeatStringPMT {

    public static boolean checkRepeat(String str){

        int[] next = getNext(str);
        int length = str.length();
        int subStrLength = length - next[length-1];
        if(next[length-1] > 0 && (length % subStrLength == 0)){
            return true;
        }else{
            return false;
        }
    }

    public static int[] getNext(String str){

        int length = str.length();
        int[] next = new int[length];
        next[0] = 0;
        int k = 0;
        for(int i = 1; i<length;i++){

            while(k>0 && str.charAt(k) != str.charAt(i)){
                k = next[k-1];
            }

            if(str.charAt(k) == str.charAt(i)){
                k++;
            }
            next[i] = k;
        }
        return next;
    }

    public static void main(String[] args){

        System.out.println(checkRepeat("abac"));
    }
}
