package linked_node;

public class LoopNode {
    public int hasLoop(Node head){
        Node fast = head.next;
        Node slow = head;
        int count = 0;
        if(head == null || head.next == null){
            return -1;
        }
        else{
            while(fast != null && fast.next != null){
                //while 条件是为了避免空指针异常
                if(fast == slow){
                    Node index1 = head;
                    Node index2 = fast;
                    while(index1 != index2){
                        index1 = index1.next;
                        index2 = index2.next;
                        count++;
                    }
                    return count;
                }else {
                    fast = fast.next.next;
                    slow = slow.next;
                }
            }
            return -1;
        }
    }
}
