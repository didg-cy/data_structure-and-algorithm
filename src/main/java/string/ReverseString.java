package string;

class ReverseString {

    public static char[] reverseString(char[] arr){

        int left = 0;
        int right = arr.length-1;
        while(left < right){
            char temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            left++;
            right--;
        }
        return arr;
    }

    public static void main(String[] args){

//        char[] arr = {'h','e','l','l','o'};
        char[] arr = {'H','e','l','l','O'};
        char[] a = reverseString(arr);
        System.out.println(a);
    }
}
