package postgraduate.leetcd.link;

import postgraduate.leetcd.ListNode;
import java.util.HashSet;

/**
 * 判断两个链表相交
 * 方法一：使用暴力
 * 方法二：使用规律
 */
public class XiangJiao {

    //方法一   暴力方，时间复杂度O(m+n),空间复杂度O(m+n).
    //使用set集合将A链表放到set中，在将B链表放到set中时，如果某个节点放入失败说明已经存在，就返回。
    private ListNode getIntersectionNode1(ListNode headA, ListNode headB){
        /**
         * 执行结果：
         * 通过
         * 显示详情
         * 添加备注
         * 执行用时：8 ms, 在所有 Java 提交中击败了6.10% 的用户
         * 内存消耗：41.5 MB, 在所有 Java 提交中击败了6.85% 的用户
         * 通过测试用例：45 / 45
         */
        if (headA == null || headB == null)
            return null;
        HashSet<ListNode> set = new HashSet();
        ListNode node = headA;

        while (node != null){
            set.add(node);
            node = node.next;
        }
        node = headB;
        while (node != null){
            if (!set.add(node)){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    //方法二   机灵方，时间复杂度O(m+n),空间复杂度O(1).
    //对于相交的第一个结点，可先求出两个链表的长度，然后用长的减去短的得到一个差值K，然后让长的链表先遍历K个结点，然后两个链表再开始比较。
    private ListNode getIntersectionNode2(ListNode headA, ListNode headB){
        if (headA == null || headB == null){
            return null;
        }
        ListNode node1 = headA;
        ListNode node2 = headB;
        int len1 = 0;
        int len2 = 0;
        //计算两个链表的长度。
        while (node1 != null || node2 != null){
            if (node1 != null){
                len1++;
                node1 = node1.next;
            }
            if (node2 != null){
                len2++;
                node2 = node2.next;
            }
        }
        //计算出最长的那个链表多出来的长度值
        int k = 0;
        ListNode node = null;
        if (len1 > len2){
            k = len1 - len2;
            node = headA;
        }else {
            k = len2 - len1;
            node = headB;
        }
        while (k != 0){//遍历到相等长度的位置。
            node = node.next;
            k--;
        }
        // 将相等位置的节点指针交给最长的node1或者node2指针，让它们处于相同长度的位置
        if (len1 > len2){
            node1 = node;
            node2 = headB;
        }else {
            node2 = node;
            node1 = headA;
        }
        // 遍历到交点位置。
        while (node1 != null){
            if (node1 == node2)
                return node1;
            node1 = node1.next;
            node2 = node2.next;
        }
        return null;
    }
}
