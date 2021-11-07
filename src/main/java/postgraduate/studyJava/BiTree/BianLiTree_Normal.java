package postgraduate.studyJava.BiTree;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 */
public class BianLiTree_Normal {
    public static void main(String[] args) throws IOException {
        //Integer[] is = BuildTree_CengXu.InputBuildTree();// 按照层序遍历的数组输入
        Integer[] a = {1,2,3,4,null,5,null,6,7,8,9};
        TreeNode root = BuildTree_CengXu.ATree2(a);// 返回根节点

        //先序遍历
        System.out.print("先序遍历：");
        new BianLiTree_Normal().preOrderTraverse(root);
        //中序遍历
        System.out.print("\n中序遍历：");
        new BianLiTree_Normal().inOrderTraverse(root);
        //后序遍历
        System.out.print("\n后序遍历：");
        new BianLiTree_Normal().postOrderTraverse(root);
    }
    public void preOrderTraverse(TreeNode root){ // 先序遍历
        LinkedList<TreeNode> ll = new LinkedList<>(); // 使用链表充当栈
        TreeNode current = root;

        while(current != null || ll.size() != 0){
            if (current != null){
                System.out.print(current.val + "  ");
                ll.offer(current);
                current = current.left;
            }else {
                current = ll.pollLast().right;
            }
        }
    }
    public void inOrderTraverse(TreeNode root){//中序遍历
        LinkedList<TreeNode> ll = new LinkedList<>();
        TreeNode current = root;

        while(current != null || ll.size() != 0){
            if (current != null){
                ll.offer(current);
                current = current.left;
            }else {
                current = ll.pollLast();
                System.out.print(current.val + "  ");
                current = current.right;
            }
        }
    }
    public void postOrderTraverse(TreeNode root){ // 后序遍历
        LinkedList<TreeNode> ll = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> output = new Stack<TreeNode>(); //构造一个中间栈来存储逆后序遍历的结果
        TreeNode current = root;

        while (current != null || stack.size() > 0) {
            if (current != null) {
                output.push(current);
                stack.push(current);
                current = current.right;
            } else {
                current = stack.pop();
                current = current.left;
            }
        }
        while (output.size() > 0) {
           System.out.print(output.pop().val + "  ");
        }
    }

}
