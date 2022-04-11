package postgraduate.leetcd.swordToOffer;

import postgraduate.leetcd.xunLian.ListNode;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]

 */

public class InverseLink {
    public static void main(String[] args) {

    }
    private int[] reversePrint(ListNode head){
        ArrayList<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        Collections.reverse(list);
        int[] data = new int[list.size()];
        for(int i = 0;i < list.size();i++){
            data[i] = list.get(i);
        }
        return data;
    }
}
