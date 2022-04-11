package postgraduate.leetcd.swordToOffer;

import postgraduate.leetcd.xunLian.ListNode;

/** 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * 注意：此题对比原题有改动
 * 示例 1:
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 */
public class DeleteNode {
    public ListNode deleteNode1(ListNode head, int val) {
        ListNode now = head;
        ListNode last = head;
        while (now != null){
            if (now.val == val){
                if (now == head){
                    return now.next;
                }
                last.next = now.next;
                break;
            }
            last = now;
            now = now.next;
        }
        return head;
    }

    public ListNode deleteNode2(ListNode head, int val) {
        ListNode flag = head;
        ListNode next = head;
        if (head != null && head.val == val){
            head = head.next;
            return head;
        }

        while (next != null){
            if (next.val == val){
                flag.next = next.next;
            }
            flag = next;
            next = next.next;
        }
        return head;
    }
}
