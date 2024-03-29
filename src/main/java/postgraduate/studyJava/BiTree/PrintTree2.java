package postgraduate.studyJava.BiTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 打印二叉树的方式一，如下
 *    3
 *   / \
 *  9   20
 *     / \
 *     15 7
 */

public class PrintTree2 {
    public static <T extends Comparable<?>> void printNode(TreeNode root) {
        int maxLevel = PrintTree2.maxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || PrintTree2.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        PrintTree2.printWhitespaces(firstSpaces);

        List<TreeNode> newNodes = new ArrayList<TreeNode>();
        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            PrintTree2.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                PrintTree2.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    PrintTree2.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    PrintTree2.printWhitespaces(1);

                PrintTree2.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    PrintTree2.printWhitespaces(1);

                PrintTree2.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(TreeNode node) {
        if (node == null)
            return 0;

        return Math.max(PrintTree2.maxLevel(node.left), PrintTree2.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }
}
