package postgraduate.leetcd.link;
/**141环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 */

import postgraduate.leetcd.xunLian.ListNode;

import java.util.HashSet;

public class HaveHuan {
    public static void main(String[] args) {

    }
    /**
     * 方法一：使用set集合。
     * 将遍历链表，把节点放入set集合里面，如果set长度不变，则跳出，说明有环。否则set长度+1。
     *
     * HashSet中，add() 方法，如果添加成功就返回true，如果添加失败（值为空或已存在），就返回false。
     * 空间复杂度高。时间复杂度O(n)
     */
    private boolean hasCycle1(ListNode head){
        HashSet<ListNode> set = new HashSet();
        int flag = 0;
        ListNode next = head;

        while(next != null){
            if (!set.add(next)){
                return false;
            }
            next = next.next;
        }
        return true;
    }

    /**
     *方法二：快慢指针
     *
     * 首先创建两个指针1和2（在java里就是两个对象引用），同时指向这个链表的头节点。然后开始一个大循环，在循环体中，让指针1每次向下移动一个节点，
     * 让指针2每次向下移动两个节点，然后比较两个指针指向的节点是否相同。如果相同，则判断出链表有环，如果不同，则继续下一次循环。
     * 例如链表A->B->C->D->B->C->D，两个指针最初都指向节点A，进入第一轮循环，指针1移动到了节点B，指针2移动到了C。第二轮循环，指针1移动到了
     * 节点C，指针2移动到了节点B。第三轮循环，指针1移动到了节点D，指针2移动到了节点D，此时两指针指向同一节点，判断出链表有环。
     *
     * 此方法也可以用一个更生动的例子来形容：在一个环形跑道上，两个运动员在同一地点起跑，一个运动员速度快，一个运动员速度慢。当两人跑了一段时间，
     * 速度快的运动员必然会从速度慢的运动员身后再次追上并超过，原因很简单，因为跑道是环形的。如果没有环慢指针就会因为遍历到空而停止循环。
     */
    private boolean hasCycle2(ListNode head){
        if (head == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null){
            slow = slow.next;
            if (fast.next == null)//此步很容易忽略。
                return false;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }
        return false;
    }
}
