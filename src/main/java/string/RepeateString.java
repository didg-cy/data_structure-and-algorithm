package string;

//暴力解法，时间复杂度 O(n2)
public class RepeateString {

    public static boolean isRepeatString(String a){

        //滑动窗口的右边界
        int right = 0;

        char[] c = a.toCharArray();
        //字符数组的长度
        int n = c.length;
        while(right < n/2){
            // 滑动窗口的长度
            int len = right+1;

            if(n % len != 0){
                right++;
            }else if(isMatched(c,right)){
                return true;
            }else{
                right++;
            }
        }
        return false;
    }

    //每个滑动窗口与同样长度的其他字符区间比较异同
    public static boolean isMatched(char[] c,int right){

        //字符区间的长度
        int lenRange = right + 1;
        //字符数组的长度
        int lenChar = c.length;
        //字符区间的左边界
        int i = lenRange;
        //字符区间的右边界
        int j = right+lenRange;
        while(j<lenChar){
            for(int left = 0,a = i; left <= right && a <= j; left++,a++){
                if(c[left] == c[a]){
                    continue;
                }else{
                    return false;
                }
            }
            i += lenRange;
            j += lenRange;
        }
        return true;
    }

    public static void main(String[] args){

//        System.out.println(getMatchedIndex("hello", "ll"));
//        System.out.println(isRepeatString("abcabcabcabc"));
//        System.out.println(isRepeatString("abab"));
        System.out.println(isRepeatString("abaababaab"));

    }
}
