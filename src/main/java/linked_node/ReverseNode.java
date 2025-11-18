package linked_node;

public class ReverseNode {
    public Node reverseNode(Node head){
        Node prev = null;
        Node current = head;
        while(current != null){
            Node post = head.next;
            current.next = prev;
            prev = current;
            current = post;
        }
        return prev;
    }

}
