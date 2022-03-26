package postgraduate.leetcd.swordToOffer;

/** 剑指 Offer 12. 矩阵中的路径.本题 和 JiQiRenSport.java 为同类型 ----> 搜索与回溯算法
 *
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 * [图片见 file/JuZhenZhongRoad.png]
 *
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 */

public class JuZhenZhongRoad {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        // 对每一个字符都作为DFS 的始发点开始遍历，即矩阵的每一个点都发起一个DFS；
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        // 因为是需要向四个方向搜索所以需要判断，坐标小于0.
        // 如果这个点的字符不符合当前 与字符串中的对应的位置的字符，就返回false；
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k])
            return false;
        if(k == word.length - 1)
            return true;
        // 第一个 if 没返回结束，就是因为这个点符合，所以标记这个点已经使用过了；
        board[i][j] = '\0';

        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);

        // 此处将字符数组复原，因为Java的数组是引用传递，基本的数据类型才是值传递。
        board[i][j] = word[k];
        return res;
    }
}
