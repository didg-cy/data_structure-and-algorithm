package string;

//反转字符串里的单词顺序（不要求反转每个单词的组成字符）
public class ReverseSentenceWord {

    //给字符串去除头部、尾部及单词间多余的空额
    public static String removeBlank(String str){

        //标记尾空格的索引
        int tailIndex = str.length()-1;
        while(tailIndex > 0){
            if( str.charAt(tailIndex) == ' '){
                tailIndex--;
            }
            else{
                break;
            }
        }
        //去除首尾之间的多余空格
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char value = str.charAt(i);
            if(i == 0 && value == ' '){
                continue;
            }
            if( i > 0 && str.charAt(i-1) == ' ' && str.charAt(i) == ' '){
                continue;
            }
            if(i > tailIndex){
                break;
            }
            sb.append(value);
        }

        return sb.toString();
    }

    //反转句子
    public static String reverseSentence(String str){

        return reverseStringApi(str, 0, str.length()-1);
    }

    //反转字符串里的每个单词（此双指针法允许开头和中间存在一个及以上空格）
    public static String reverseSingleWord(String str){

        int left = 0;
        int n = str.length();
        String result = str;
        while(left < n) {
            if (str.charAt(left) == ' ') {
                left++;
            }
            int right = left;
            while (right < n) {
                if (str.charAt(right) != ' ') {
                    right++;
                }
                else{
                    break;
                }
            }
            result = reverseStringApi(result, left, right - 1);
            left = right;
        }
        return result;
    }

    //反转字符串
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
//        String result = reverseSingleWord("acx!   bdc   ccs    des");
        String str = "  the   sky   is   blue  ";
//        String str = "the  ";
        System.out.println(
                reverseSingleWord(
                        reverseSentence(
                        removeBlank(str)
                        )
                )
        );
    }
}
