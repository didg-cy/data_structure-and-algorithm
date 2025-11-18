package stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReversePolishNotation {

    public static int getValue(String[] str){
        int temp1;
        int temp2;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0;i<str.length;i++){
            String c = str[i];
            if(c.equals("+")){
                temp1 = stack.pollFirst();
                temp2 = stack.pollFirst();
                int tem = temp1 + temp2;
                stack.offerFirst(tem);
            }else if(c.equals("-")){
                temp1 = stack.pollFirst();
                temp2 = stack.pollFirst();
                int tem = temp2 - temp1;
                stack.offerFirst(tem);
            }else if(c.equals("*")){
                temp1 = stack.pollFirst();
                temp2 = stack.pollFirst();
                int tem = temp1 * temp2;
                stack.offerFirst(tem);
            }else if(c.equals("/")){
                temp1 = stack.pollFirst();
                temp2 = stack.pollFirst();
                int tem = temp2 / temp1;
                stack.offerFirst(tem);
            } else{
                stack.offerFirst(Integer.valueOf(c));
            }
        }
        return stack.pollFirst();
    }

    public static void main(String[] args){

        String[] str = {"4","13","5","/","+"};
        System.out.println(getValue(str));
    }
}
