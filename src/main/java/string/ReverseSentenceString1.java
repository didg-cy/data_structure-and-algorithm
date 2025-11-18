package string;

import java.util.ArrayList;
import java.util.List;

public class ReverseSentenceString1 {

    //先找空格的索引，再确定单词位置再翻转的解法
    public static String reverseSentenceString1(String str){

        String result = str;
        int lenStr = str.length();
        //存放空格字符的索引
        List<Integer> blankIndex = new ArrayList<>();
        for(int i = 0;i<lenStr;i++){
            if(str.charAt(i) == ' '){
                blankIndex.add(i);
            }
        }
        int lenBlankIndex = blankIndex.size();

        // 若字符串无空格
        if(lenBlankIndex == 0){
            result = reverseStringApi(str,0,lenStr-1);
            return result;
        }

        // 判断首个空格之前是否有元素，有元素则翻转，即使只有单个元素也没关系，反转后也是它自己
        if(blankIndex.get(0) > 0){
            result = reverseStringApi(str,0,blankIndex.get(0)-1);
        }

        //只有一个空格或者最后一个空格之后仍有元素，那么空格之后的元素反转
        if(lenBlankIndex == 1 || lenStr-blankIndex.get(lenBlankIndex-1) > 0){
            result = reverseStringApi(result,blankIndex.get(lenBlankIndex-1)+1,lenStr-1);
        }

        //有两个及以上空格，那么空格之间的元素进行反转
        for(int i =1; i<lenBlankIndex;i++){
            result = reverseStringApi(result,blankIndex.get(i-1)+1,blankIndex.get(i)-1);
        }

        //单词间有多个空格，则仅保留一个空格
        StringBuilder deleteBlankResult = new StringBuilder();
        for(int i = 0;i<result.length();i++){
            if(i > 0 && result.charAt(i-1) == ' ' && result.charAt(i) == ' '){
                continue;
            }
            deleteBlankResult.append(result.charAt(i));
        }
        result = deleteBlankResult.toString();

        return result;
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
        String result = reverseSentenceString1("acx!   bdc   ccs    des");
        System.out.println(result);
    }

}
