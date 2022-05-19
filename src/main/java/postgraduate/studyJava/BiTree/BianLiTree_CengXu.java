package postgraduate.studyJava.BiTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 层序遍历二叉树
 * 一层一层的输出二叉树；
 * 如果使用默认的方式，就是将遍历后的二叉树放进一个二维的List中后，返回这个List；
 * 如果注释掉放进List，而是直接输出，就是以空格隔开输出二叉树的值；
 */
public class BianLiTree_CengXu {
    public static void main(String[] args) {
        Integer[] a = {1,2,3,4,null,5,null,6,7,8,9};
        TreeNode root = BuildTree_CengXu.ATree2(a);// 返回根节点

        //levelOrder(root);//返回层序遍历的结果，以二维的List返回；
        levelOrder2(root);// 打印遍历的结果，成一行；
    }
    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //根节点放入队列中
        queue.offer(root);
        if (root == null) return result;
        //当队列为空时，什么全部节点遍历完毕
        while (!queue.isEmpty()) {
            //这个长度就代表每一层有多少个节点
            int size = queue.size();
            List<Integer> list = new ArrayList<Integer>();// 用来装这一层的节点值
            //注意，这里一定要使用静态size，不能使用queue.size()，因为当你弹出一个节点的时候，queue.size()将发生变化
            for (int i = 0 ; i < size ; i++) {
                TreeNode cur = queue.peek();
                queue.poll();
                list.add(cur.val);
                //System.out.print(cur.val + " ");//这里是直接将数字输出，不需要放进 List；
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            result.add(list);
        }
        return result;
    }
    private static void levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //根节点放入队列中
        queue.offer(root);
        if (root == null) {
            System.out.println("Null: 空树！");
            return;
        }
        //当队列为空时，什么全部节点遍历完毕
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.print(poll.val + " ");
            // 左、右孩子节点不为空时才加入队列；
            if (poll.left != null)
                queue.offer(poll.left);
            if (poll.right != null)
                queue.offer(poll.right);
        }
    }
}
