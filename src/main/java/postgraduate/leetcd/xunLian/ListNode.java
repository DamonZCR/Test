package postgraduate.leetcd.xunLian;

/**
 * 定义leetCode中需要经常使用到的链表节点。
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    ListNode(int x) {
        val = x;
        next = null;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next;}
}
