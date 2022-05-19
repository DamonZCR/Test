package postgraduate.studyJava.BiTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * ATree() 方法为根据层序遍历结果，建立一颗二叉树后输出。
 * ATree2() 方法为根据层序遍历结果，建立一颗二叉树后输出并返回根节点。
 * InputBuildTree() 根据层序遍历的结果输入数组，返回一个Integer[]数组。
 */
public class BuildTree_CengXu {
    public static void main(String[] args) throws IOException {
        // 以下两个为： 层序遍历建立树
        //new BuildTree_CengXu().ATree();

        Integer[] is = InputBuildTree();
        new BuildTree_CengXu().ATree2(is); //建立树后返回根节点
    }

    private void ATree(){
        // 根据元素个数求出树的深度。
        Integer[] a = {1,2,3,4,null,5,null,6,7,8,9};
        int i = 1;
        TreeNode root = new TreeNode(a[0]);  // 根节点
        TreeNode current = null;
        Integer value = null;

        //层序创建二叉树
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root); // 添加到链表尾部
        while(i < a.length) {
            current = queue.poll();//从链表中移除并获取第一个节点
            // 左节点
            value = a[i++];
            if(value != null) {
                TreeNode left = new TreeNode(value);
                current.left = left;//创建当前节点的左孩子
                queue.offer(left); // 在链表尾部 左孩子入队
            }
            // 右节点
            value = a[i++];
            if(value != null) {
                TreeNode right = new TreeNode(value);
                current.right = right;//创建当前节点的右孩子
                queue.offer(right);// 在链表尾部 右孩子入队
            }
        }
        // 两个方式树形输出二叉树
        PrintTree1.printT(root);
        System.out.println("-----------------------------------------------");
        PrintTree2.printNode(root);
    }
    // 自己尝试层序遍历建立二叉树
    public static TreeNode ATree2(Integer[] a){
        LinkedList<TreeNode> list = new LinkedList<>();
        TreeNode root = new TreeNode(a[0]);//根节点
        list.offer(root);

        int i = 1;
        while(i < a.length){
            TreeNode treeNode = list.poll();
            // 左节点
            Integer val = a[i++];// 获取当前索引位置的值，获取后向后移动一位；
            if(val != null){
                TreeNode left = new TreeNode(val); // 当前值不为空，就加为左节点
                treeNode.left = left;
                list.offer(left);
            }
            // 右节点
            val = a[i++]; //获取下一位值，i++ 代表继续向后移动。为进入下一次while循环做准备
            if(val != null){
                TreeNode right = new TreeNode(val);
                treeNode.right = right;
                list.offer(right);
            }
        }
        // 两个方式树形输出二叉树
        PrintTree1.printT(root);
        System.out.println("-----------------------------------------------");
        PrintTree2.printNode(root);

        return root;
    }
    // 用于建立二叉树的输入，可以输入类似：[1,2,3,null,6,。。。]形式数组。返回Integer类型数组。
    public static Integer[] InputBuildTree() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        // 将输入的数组,类似于形式：[1,2,3,null,6,。。。]分割为单个string数组。
        String[] strvalu = s.substring(1, s.length()-1).split(",");
        // 将输入的每个数组放入整数数组
        Integer[] intvalu = new Integer[strvalu.length];
        for (int i = 0;i < strvalu.length;i++){
            // 判断是否为空节点。
            if(!strvalu[i].equals("null")) {
                //System.out.println(strvalu[i]);
                intvalu[i] = Integer.parseInt(strvalu[i]);
            }else
                intvalu[i] = null;
        }
        return intvalu;
    }
}
