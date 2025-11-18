package stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {

    Deque<Character> stack;

    public ValidParentheses(){
        stack = new ArrayDeque<>();
    }

    public boolean isValid(String str){
        for(int i = 0;i<str.length();i++) {
            if(stack.isEmpty()){
                stack.offerFirst(str.charAt(i));
                continue;
            }
            if ((str.charAt(i) == ' ' && stack.peekFirst() == ' ') || str.charAt(i) - stack.peekFirst() == 1 || str.charAt(i) - stack.peekFirst() == 2) {
                stack.pollFirst();
            } else {
                stack.offerFirst(str.charAt(i));
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
