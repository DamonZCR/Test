package postgraduate.leetcd;

/**
 * 寻找环的入口
 */
public class HuanEntr {
    /**方法-1
     * 这个方法是实现了，寻找环的入口，首先，isLoop()方法判断这个链表是不是一个环，然后。
     * 就进入了EntryNodeOfLoop()的if中，然后再使用一次while找到这个快慢指针相等的位置；
     * 然后再进行特殊位置的前进；
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null) return null;
        if (isLoop(pHead)){
            ListNode slow = pHead.next;
            ListNode fast = pHead.next.next;

            while(slow != fast){
                slow = slow.next;
                fast = fast.next.next;
            }
            // 循环结束时候  slow == fast
            slow = pHead;
            // 一个从头开始走 ，一个从相遇地方开始走，走同样的步数
            // 因为 x= z+(n-1)L
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        else  return null;
    }
    public boolean isLoop(ListNode pHead){
        if (pHead.next == null) return false;
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }

    /**
     *给定一个链表，返回链表开始入环的第一个节点。 从链表的头节点开始沿着 next 指针进入环的第一个
     * 节点为环的入口节点。如果链表无环，则返回 null。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     * 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
     * 说明：不允许修改给定的链表。
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        int flag = 1;

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
        if (fast.next == null)
            return null;
        slow = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}

