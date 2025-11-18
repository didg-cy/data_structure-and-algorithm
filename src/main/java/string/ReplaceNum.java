package string;

public class ReplaceNum {

    //这种方法需要进行 char 到 String 的转换，开销更大
//    public static StringBuilder replaceNum(String s){
//
//        int l = s.length();
//        String[] container = new String[l];
//        StringBuilder result = new StringBuilder();
//        for(int i = 0; i<s.length();i++){
//            if(s.charAt(i) >= 48 && s.charAt(i) <= 57){
//                container[i] = "number";
//            }
//            else{
//                container[i] = String.valueOf(s.charAt(i));
//            }
//        }
//        for(String str:container){
//            result.append(str);
//        }
//        return result;
//    }

    public static String replaceNum(String s,String replaceStr){

        int numCount = 0;
        for(int i = 0; i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                numCount++;
            }
        }
        int newSize = s.length() + numCount*5;
        char[] container = new char[newSize];
        int head = 0;
        for(int i = 0; i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                for(int j = 0; j < replaceStr.length(); j++)
                container[head+j] = replaceStr.charAt(j);
                head += replaceStr.length();
            }else{
                container[head] = s.charAt(i);
                head++;
            }
        }
        return new String(container);
    }

    public static void main(String[] args){

        System.out.println(replaceNum("a1b2c3", "number"));
    }

}
