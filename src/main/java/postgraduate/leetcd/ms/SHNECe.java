package postgraduate.leetcd.ms;

import postgraduate.leetcd.xunLian.ListNode;

public class SHNECe {
    public static void main(String[] args) {

    }
    private static ListNode quchong(ListNode node){

        if (node.next == null){
            return node;
        }
        ListNode node1 = node.next;
        ListNode fre = node;
        //int s = 0;
        while(node1 != null){
            if (fre.val == node1.val){
                fre.next = node1.next;
            }
            fre = node1;
            node1 = node1.next;
        }
        return node;
    }
}
