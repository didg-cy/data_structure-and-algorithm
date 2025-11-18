package stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAdjacentDuplicatElements {

    public String removeAdjacentDuplicatElements(String str) {

        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = str.length()-1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.offerFirst(str.charAt(i));
                continue;
            }
            if(stack.peekFirst() == str.charAt(i)){
                stack.pollFirst();
            }else{
                stack.offerFirst(str.charAt(i));
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pollFirst());
        }
        return sb.toString();
    }
}
