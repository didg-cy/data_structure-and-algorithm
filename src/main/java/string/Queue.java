package string;

public class Queue {

    int capacity;
    int[] queue;

    public Queue(int size){
         queue =  new int[size];
         capacity = 0;
    }

    public void push(int i){

        queue[capacity] = i;
        capacity++;
    }

    public void pop(){

        for(int i = 0; i<capacity-1;i++){
            queue[i] = queue[i+1];
        }
        capacity--;
    }

    public int peek(){

        return queue[0];
    }

    public boolean isEmpty(){

        if(capacity == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args){

        Queue queue = new Queue(10);
        queue.push(3);
        queue.push(4);
        System.out.println("移除头部元素前的头部元素" + queue.peek());
        queue.pop();
        System.out.println("移除头部元素后的头部元素" + queue.peek());
        System.out.println("队列是否为空" + queue.isEmpty());
    }

}
