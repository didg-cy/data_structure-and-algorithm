package linked_node;

public class CrossNode {

    //时间复杂度 O(m*n)
//    public linked_node.Node crossNode(linked_node.Node headA, linked_node.Node headB) {
//        linked_node.Node currentA = headA;
//
//        while (currentA.next != null) {
//            linked_node.Node currentB = headB;
//            while (currentB.next != null) {
//                if(currentA.next == currentB.next) {
//                    return currentA.next;
//                }
//                currentB = currentB.next;
//            }
//            currentA = currentA.next;
//        }
//        return null;
//    }

    //时间复杂度 O(m+n)
    public Node crossNode(Node headA, Node headB) {
        Node PA = headA;
        Node PB = headB;
        boolean hasSwithcA = false;
        boolean hasSwithcB = false;
        while (PA != PB) {

            if (PA == null) {
                if(!hasSwithcA){
                    PA = headB;
                    hasSwithcA = true;
                }else{
                    return null;
                }
            }
            else {
                PA = PA.next;
            }

            if (PB == null) {
                if(!hasSwithcB){
                    PB = headA;
                    hasSwithcB = true;
                }
                else{
                    return null;
                }
            }
            else {
                PB = PB.next;
            }
        }
        return PA;
    }

}


