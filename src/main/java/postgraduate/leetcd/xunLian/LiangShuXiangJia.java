package postgraduate.leetcd.xunLian;

/**2. 两数相加
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 */
public class LiangShuXiangJia {
    public static void main(String[] args) {

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 执行结果：
         * 通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：
         * 1 ms
         * , 在所有 Java 提交中击败了
         * 100.00%
         * 的用户
         * 内存消耗：
         * 41.3 MB
         * , 在所有 Java 提交中击败了
         * 49.38%
         * 的用户
         * 通过测试用例：
         * 1568 / 1568
         */
        ListNode first = l1;
        ListNode second = l2;
        int val = 0;
        ListNode head = new ListNode();
        ListNode next = head;
        while (first != null || second != null || val >= 10){
            // 两个节点都不为空时
            if (first != null && second != null){
                if (val >= 10){
                    val = first.val + second.val + 1;
                }else
                    val = first.val + second.val;

                first = first.next;
                second = second.next;
                next.val = val % 10;//一个位的数值最大也就是9，所以对10取模；
                //第二个链表遍历完成，第一个还没结束
            } else if (first != null){
                if (val >= 10)
                    val = first.val + 1;
                else
                    val = first.val;
                next.val = val % 10;
                first = first.next;
                //第一个链表遍历完成，第二个还没结束
            }else if (second != null){
                if (val >= 10)
                    val = second.val + 1;
                else
                    val = second.val;
                next.val = val % 10;
                second = second.next;
            }else {//全部遍历结束，但是有进位；
                next.val = 1;
                return head;
            }

            if (first != null || second != null || val >= 10)
                next.next = new ListNode();
            next = next.next;
        }
        return head;
    }
}
