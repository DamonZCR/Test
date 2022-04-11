package postgraduate.leetcd.xunLian;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 题目如图所示。
 * 如何使用 LinkedList
 * 案例1：
 * 输入：2,1,4,null,null,3
 * 输出：1,null,2,null,3,null,4
 * 案例2：
 * 输入：5,3,6,2,4,null,8,1,null,null,null,7,9
 * 输出：1,null,2,null,3,null,4,null,5,null,7,null,6,null,8
 * 解法：
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class IncreaseTree {
    public static void main (String[] arg) throws IOException {
        List<TreeNode> treeNodes  = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss =  br.readLine().split(",");
        for (String i :
                ss) {
            if (!i.equals("null")){
                treeNodes.add(new TreeNode(Integer.parseInt(i), null, null));
            }else
                treeNodes.add(new TreeNode(Integer.MIN_VALUE));
        }
        for (int index = 0,loca = 0; loca < ss.length / 2; index++){
            if (loca == ss.length / 2 - 1){
                treeNodes.get(index).left = treeNodes.get(loca * 2 + 1);
                treeNodes.get(index).right = null;
                break;
            }
            if (treeNodes.get(index).val != Integer.MIN_VALUE) {
                // 此节点不为空
                treeNodes.get(index).left = treeNodes.get(loca * 2 + 1);
                treeNodes.get(index).right = treeNodes.get(loca * 2 + 2);
                loca++;
            }
        }
        MidPrint(treeNodes.get(0));
    }
    public static void MidPrint(TreeNode root){
        Stack<TreeNode> stack = new Stack();
        LinkedList<TreeNode> queue = new LinkedList();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()){
            if (p != null){
                stack.push(p);
                p = p.left;
            }
            else {
                p = stack.pop();
                if (p.val != Integer.MIN_VALUE)
                    if (!queue.isEmpty()){
                        TreeNode q = new TreeNode();
                        q.val = p.val;
                        queue.getLast().right = p;
                        queue.getLast().left = null;
                        queue.add(q);
                    }else {
                        TreeNode q = new TreeNode();
                        q.val = p.val;
                        queue.add(q);
                    }
                p = p.right;
            }
        }
        for (int i = 0; i < queue.size(); i++){
            System.out.print(queue.get(i).val);
            if (i != queue.size() - 1) {
                System.out.print(",null,");
            }
        }
    }
}
