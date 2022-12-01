package postgraduate.leetcd.qiuZhao;

import postgraduate.studyJava.BiTree.TreeNode;
//阅文集团笔试2021101
//输出二叉树中，最后一层最左边的节点值；
public class YueWen_1 {
    int hei = 0, res = 0;
    public int findBottomLeftValue (TreeNode root) {
        dfs(root, 1);
        return res;
    }
    public void dfs(TreeNode root, int height){
        if (root != null){
            if (height > hei){
                hei = height;
                //res = root.val;
            }
            //dfs(root.left, height + 1);
            //dfs(root.right, height + 1);
        }
    }
}
