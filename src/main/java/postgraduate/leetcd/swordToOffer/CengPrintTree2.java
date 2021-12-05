package postgraduate.leetcd.swordToOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * 使用一个双层的List用来装返回的结果，用一个列表用来存储每层节点值，再用一个链表装每层的孩子节点，
 * 首先将根节点放入链表中，进入while循环，判断条件是如果链表中节点数量不为零（值不值得遍历这一层），
 * 就一直遍历完这个链表， * 此时这个链表存储的就是一层的节点，于是再一层循环遍历这整个节点链表，while
 * 条件是，开始遍历的时候这个链表的长度，这时候就可以分辨是这一层的节点，因为后期这个链表还要添加节点。
 * 遍历一个节点的时候，记录的链表长度减一，添加节点值，访问子节点。
 *
 */
public class CengPrintTree2 {
    public List<List<Integer>> levelOrder(TreeNode root){
        /**
         * 执行结果：
         * 通过
         * 显示详情
         * 添加备注
         * 执行用时：1 ms, 在所有 Java 提交中击败了94.17% 的用户
         * 内存消耗：38.3 MB, 在所有 Java 提交中击败了91.77% 的用户
         * 通过测试用例：34 / 34
         */
        if (root == null)
            return new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list;
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        // 待遍历的一层节点不为空。
        while (nodes.size() != 0){
            // 装每一层的数字值
            list = new ArrayList<Integer>();
            int length = nodes.size();
            while(length != 0){
                TreeNode next = nodes.pop();
                length--;
                list.add(next.val);
                if (next.left != null)
                    nodes.offer(next.left);
                if (next.right != null)
                    nodes.offer(next.right);
            }
            res.add(list);
        }
        return res;
    }

}
