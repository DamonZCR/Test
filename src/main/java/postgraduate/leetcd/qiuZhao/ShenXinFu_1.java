package postgraduate.leetcd.qiuZhao;

/**深信服-20220914
 * 最小转换步数-力扣原题72；
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例1：
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 */

public class ShenXinFu_1 {
    public static void main(String[] args) {

    }
    public int minDistance(String a, String b){
        int len1 = a.length();
        int len2 = b.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }
        for (int i = 1; i <= len1 ; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
        return dp[len1][len2];
    }
}
