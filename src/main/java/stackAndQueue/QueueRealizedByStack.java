package stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueRealizedByStack {

    // 首先创建两个栈
    Deque<Integer> stackForInput;
    Deque<Integer> stackForOutput;

    public QueueRealizedByStack() {
        stackForInput = new ArrayDeque<>();
        stackForOutput = new ArrayDeque<>();
    }

    public void push(int e){
        stackForInput.addFirst(e);
    }

    public int peek(){
        if(stackForOutput.isEmpty()){
            if(stackForInput.isEmpty()){
                return -1;
            }
            while(!stackForInput.isEmpty()){
                stackForOutput.addFirst(stackForInput.pollFirst());
            }
            return stackForOutput.getFirst();
        }else{
            return stackForOutput.getFirst();
        }
    }

    public int pop(){
        if(stackForOutput.isEmpty()){
            if(stackForInput.isEmpty()){
                return -1;
            }
            while(!stackForInput.isEmpty()){
                stackForOutput.addFirst(stackForInput.pollFirst());
            }
            return stackForOutput.pollFirst();
        }else{
            return stackForOutput.pollFirst();
        }
    }

    public boolean isEmpty(){
        if(stackForOutput.isEmpty() && stackForInput.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
