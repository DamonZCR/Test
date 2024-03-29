package postgraduate.leetcd.swordToOffer;

import postgraduate.leetcd.xunLian.ListNode;

/**剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */

public class ReverseLink {
    public ListNode reverseList(ListNode head){
        if (head == null)
            return null;
        ListNode lin = head.next;
        ListNode h2 = head;
        ListNode next = lin;
        head.next = null;
        while (next != null){
            next = lin.next;
            lin.next = h2;
            h2 = lin;
            lin = next;
        }
        return h2;
    }
}
