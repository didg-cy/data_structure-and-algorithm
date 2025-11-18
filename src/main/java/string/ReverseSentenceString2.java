package string;

public class ReverseSentenceString2 {

    //思路2：找帮手（中间变量）来装非空元素，进而找到单词
    public static String reverseSentenceString2(String str){

        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();
        StringBuilder strSingleBlank = new StringBuilder();

        //先去掉单词间的多于一个的空格，而且还要去掉句首句尾的空格，等后面再补充吧，否则会导致 word.length()-1 出现空指针异常
        for(int i =0; i<str.length(); i++){
            if(i>0 && str.charAt(i-1) == ' ' && str.charAt(i) == ' '){
                continue;
            }
            strSingleBlank.append(str.charAt(i));
        }
        //将 str 指向去重后的输入字符串
        str = strSingleBlank.toString();
        //得到每个翻转的单词并汇总
        for(int i=0; i<str.length(); i++){
            char value = str.charAt(i);
            if(value != ' '){
                word.append(value);
            }
            else if(value == ' '){
                result.append(reverseStringApi(word.toString(),0,word.length()-1));
                result.append(' ');
                word.setLength(0);
            }
        }
        if(word.length() > 0){
            result.append(reverseStringApi(word.toString(),0,word.length()-1));
            word.setLength(0);
        }
        return result.toString();
    }

    public static String reverseStringApi(String str, int left, int right){

        char[] arr = str.toCharArray();
        while(left < right){
            char temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            left++;
            right--;
        }
        return new String(arr);
    }

    public static void main(String[] args){

//        String result = reverseSentenceString1("the sky is blue");
        String result = reverseSentenceString2("acx!   bdc   ccs    des");
        System.out.println(result);
    }

}
