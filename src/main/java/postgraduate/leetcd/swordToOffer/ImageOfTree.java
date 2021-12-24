package postgraduate.leetcd.swordToOffer;

import java.util.LinkedList;

/**剑指 Offer 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 例如输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 */
public class ImageOfTree {
    /**
     * 执行结果：
     * 通过
     * 添加备注
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：35.7 MB, 在所有 Java 提交中击败了73.46% 的用户
     * 通过测试用例：68 / 68
     *
     * 思想：使用层序遍历树的每一层，对每一层的节点加入到链表中，对链表进行遍历，如果这个
     * 点左或者右节点不为空就就交换，然后把不为空的节点加入到链表中等待遍历。
     */
    private TreeNode mirrorTree(TreeNode root){
        if (root == null)
            return root;
        LinkedList<TreeNode> ceng = new LinkedList<>();
        ceng.offer(root);

        while (!ceng.isEmpty()){
            TreeNode first = ceng.poll();
            if (first.left != null || first.right != null){
                TreeNode lin = first.right;
                first.right = first.left;
                first.left = lin;

                if (first.left != null)
                    ceng.offer(first.left);
                if (first.right != null)
                    ceng.offer(first.right);
            }
        }
        return root;
    }
}
