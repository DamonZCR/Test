package postgraduate.studyJava.BiTree;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 遍历二叉树
 * 使用非递归的方式实现；重点
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

        while(current != null || ll.size() != 0){//当前节点不为空，或者栈不空就可以访问；
            if (current != null){// 如果当前节点不为空就访问，并且一直向左子树访问下去；
                System.out.print(current.val + "  ");
                ll.offer(current); // 因为右节点还没有访问，所以加入栈中；
                current = current.left; // 指向左子树；
            }else {//说明当前节点为空，此时就取出栈中没有被访问右子树的备用节点；
                current = ll.pollLast().right;
            }
        }
    }
    public void inOrderTraverse(TreeNode root){//中序遍历
        LinkedList<TreeNode> ll = new LinkedList<>();
        TreeNode current = root;// 指针节点

        while(current != null || ll.size() != 0){//当前节点不为空，或者栈不空就可以访问；
            if (current != null){// 如果当前节点不为空就访问，并且一直向左子树访问下去；
                ll.offer(current);
                current = current.left;//一直向左子树遍历下去
            }else {// 说明当前节点为空，可以理解为左节点为空时；
                current = ll.pollLast();
                System.out.print(current.val + "  ");//访问此节点
                current = current.right;// 访问右节点
            }
        }
    }
    public void postOrderTraverse(TreeNode root){ // 后序遍历
        Stack<TreeNode> stack = new Stack<TreeNode>();// 寄存栈
        Stack<TreeNode> output = new Stack<TreeNode>(); //构造一个中间栈来存储逆后序遍历的结果
        TreeNode current = root;

        while (current != null || stack.size() > 0) {//当前节点不为空，或者待访问的节点栈不为空
            if (current != null) {
                output.push(current);// 加入栈中
                stack.push(current);// 加入栈中
                current = current.right;// 注意：是访问它的右节点；
            } else {
                current = stack.pop();// 从栈中弹出一个进行访问
                current = current.left;// 指向它的左节点；
            }
        }
        while (output.size() > 0) {
           System.out.print(output.pop().val + "  ");
        }
    }
}
