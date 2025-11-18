package linked_node;

public class RemoveNode {
    public Node removeNode(Node head,int n) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node fast = dummy;
        Node slow = dummy;
        for (int i = 0; i < n; i++){
            fast = fast.next;
        }
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
    }
}
