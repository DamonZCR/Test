package postgraduate.leetcd.swordToOffer;

/**剑指 Offer 47. 礼物的最大价值
 *在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * 示例 1:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * 提示：
 *     0 < grid.length <= 200
 *     0 < grid[0].length <= 200
 * 解题思想：使用DP解决，需要考虑，怎么建立dp数组。
 *   建立一个dp数组，计算出到达每一个格可以得到的礼物的最大值，如第一个格，最大值就是它自己，而（1，1）
 * 格的最大值就是9.
 */
public class LiWuDeZuiDaJiaZhi {
    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 添加备注
     * 执行用时：4 ms, 在所有 Java 提交中击败了31.38% 的用户
     * 内存消耗：43.7 MB, 在所有 Java 提交中击败了39.65% 的用户
     * 通过测试用例：61 / 61
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int len = grid.length;
        int kan = grid[0].length;
        int res = 0;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < kan; j++) {
                if (i == 0 || j == 0){//处理临界值
                    if (j == 0){//说明是某一行的首元素
                        if (i == 0)//坐标为（0，0）的元素，就是最大值就是它自己；
                            dp[i][j] = grid[i][j];
                        else
                            // 某一行的首元素（不包括（0.0）的元素），它为上一行 + 自己的值；
                            dp[i][j] = grid[i][j] + dp[i - 1][j];
                    }else {//说明是首行元素，它只能等于左边前一位的最大加上自己；
                        dp[i][j] = dp[i][j - 1] + grid[i][j];
                    }
                }else {
                    dp[i][j] = Math.max(dp[i][j - 1] + grid[i][j], dp[i - 1][j] + grid[i][j]);
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
