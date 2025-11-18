package string;

public class ReverseSentenceString3 {

    //思路3：双指针 使用 char[] 原地操作
    public static String reverseSentenceString3(String str){

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
        String result = reverseSentenceString3("acx!   bdc   ccs    des");
        System.out.println(result);
    }
}
