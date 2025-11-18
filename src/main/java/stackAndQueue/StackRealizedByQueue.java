package stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackRealizedByQueue {

    Deque<Integer> queue;

    public StackRealizedByQueue(){
        queue = new ArrayDeque<>();
    }

    public void push(int i){
        queue.offerLast(i);
        lastToFist();
    }

    public int top(){
        return queue.getFirst();
    }

    public int pop(){
        return queue.pollFirst();
    }

    public boolean empty(){
        return queue.isEmpty();
    }

    public void lastToFist(){
        int elementSize = queue.size();
        int i = 1;
        while( i<elementSize ){
            queue.addLast(queue.pollFirst());
            i++;
        }
    }

    public static void main(String[] args){
        StackRealizedByQueue stack = new StackRealizedByQueue();
        stack.push(1);
        stack.push(2);

    }
}
