package postgraduate.leetcd.swordToOffer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**剑指 Offer 32 - I. 从上到下打印二叉树
 *从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 * [3,9,20,15,7]
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class CengPrintTree {
    private int[] levelOrder(TreeNode root){
        /**
         * 执行结果：
         * 通过
         * 显示详情
         *
         * 添加备注
         * 执行用时：1 ms, 在所有 Java 提交中击败了98.48% 的用户
         * 内存消耗：38.6 MB, 在所有 Java 提交中击败了46.58% 的用户
         * 通过测试用例：34 / 34
         * 思想：使用一个num的ArrayList用来存储数字，使用一个链表用来存储层序遍历的节点，
         * 这些节点会被等待着访问左右子节点。如果当前节点不为空，左节点存在就将左节点加入
         * 链表，右节点存在就将右节点加入。
         */
        ArrayList<Integer> num = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        TreeNode cur = root;
        // 当前节点不为空，或者队列不为空继续遍历。
        while(!list.isEmpty() || cur != null){
            if (cur != null){
                num.add(cur.val);
                if (cur.left != null){
                    list.offer(cur.left);
                }
                if (cur.right != null){
                    list.offer(cur.right);
                }
            }
            if (!list.isEmpty())
                cur = list.pop();
            else
                break;
        }

        int[] res = new int[num.size()];
        for (int i = 0;i < num.size();i++){
            res[i] = num.get(i);
            System.out.println(res[i]);
        }
        return res;
    }
}
