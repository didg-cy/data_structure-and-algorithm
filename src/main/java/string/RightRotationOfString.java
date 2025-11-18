package string;

public class RightRotationOfString {

    public static String rightRotationOfString(String str, int k){

        StringBuilder sb = new StringBuilder();
        int len = str.length();

        if(len <= k){
            return str;
        }

        for(int i = len-k; i<len; i++){
            sb.append(str.charAt(i));
        }
        for(int i =0; i<len-k; i++){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args){

//        String str = "abcdefg";
        System.out.println(rightRotationOfString("abcdefg",2));
    }
}
