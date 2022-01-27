package postgraduate.leetcd.link;

import postgraduate.leetcd.ListNode;

/**找到环的入环口
 * 剑指 Offer II 022. 链表中环的入口节点
 * 给定一个链表，返回链表开始入环的第一个节点。 从链表的头节点开始沿着 next 指针进入环的
 * 第一个节点为环的入口节点。如果链表无环，则返回 null。
 * 说明：不允许修改给定的链表。
 */
public class DetectCycle {

    private static ListNode detectCycle(ListNode head){
        if (head == null || head.next == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        // 判断是不是环，当判断一个节点的next为空时说明不是环就返回null.
        // 是环就在 两个指针相等处退出循环。
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
            if (fast.next == null){
                return null;
            }else
                fast = fast.next;

            if (fast == slow)
                break;
        }
        if (fast.next == null)//循环结束的条件时next为空说明不是环。
            return null;

        // 一个指针从头开始，另一个从相遇出开始，遇见时说明到达入环点。
        slow = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 添加备注
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了86.57% 的用户
     * 通过测试用例：16 / 16
     */
}
