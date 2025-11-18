package string;

public class ReverseString2 {

    public static String reverseString(String s, int k){

        if(s == null || k <= 0){
            return s;
        }

        int length = s.length();
        char[] charArray = s.toCharArray();
        int cycle = length / (2*k);
        int remainder = length % (2*k);

        for (int i = 0; i < cycle; i++) {
            int left = 2*k*i;
            int right = 2*k*i+k-1;
            while (left < right) {
                char temp = charArray[right];
                charArray[right] = charArray[left];
                charArray[left] = temp;
                left++;
                right--;
            }
        }
        if(remainder >0 && remainder < k) {
            int left = 2*k*cycle;
            int right = length-1;
            while (left < right) {
                char temp = charArray[right];
                charArray[right] = charArray[left];
                charArray[left] = temp;
                left++;
                right--;
            }
        }
        else{
            int left = 2*k*cycle;
            int right = 2*k*cycle+k-1;
            while (left < right) {
                char temp = charArray[right];
                charArray[right] = charArray[left];
                charArray[left] = temp;
                left++;
                right--;
            }
            
        }
        String result = new String(charArray);
        return result;
    }

    public static void main(String[] args){

        String result = reverseString("abcdefg",2);
        System.out.println(result);
    }
}
