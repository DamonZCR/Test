package postgraduate.leetcd.swordToOffer;

/**
 * 执行结果：
 * 通过
 * 显示详情
 * 添加备注
 * 执行用时：100 ms, 在所有 Java 提交中击败了10.39% 的用户
 * 内存消耗：41.5 MB, 在所有 Java 提交中击败了5.16% 的用户
 * 通过测试用例：200 / 200
 */
public class GuPiaoDeZuiDa {
    public int maxProfit(int[] prices) {
        int res = 0;
        int len = prices.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (prices[i] > prices[j]){
                    break;
                }
                res = Math.max(res, prices[j] - prices[i]);
            }
        }
        return res;
    }
    /**动态规划：思想参照LianXuZiShuZuDeZuiDaHe.java
     *
     * 执行结果：
     * 通过
     * 显示详情
     * 添加备注
     * 执行用时：2 ms, 在所有 Java 提交中击败了30.47% 的用户
     * 内存消耗：41 MB, 在所有 Java 提交中击败了40.22% 的用户
     * 通过测试用例：200 / 200
     */
    public int maxProfit2(int[] prices) {
        if (prices.length == 0)
            return 0;
        int res = 0;
        int len = prices.length;
        // dp是用来记录，当前这一天，产生或者保持的收益最高的值；
        int[] dp = new int[len];
        dp[0] = 0;//第一天的最高利润，就是第一天买第一天卖。所以为0；
        int minD = prices[0];//记录最小的股票价格
        for (int i = 1; i < len; i++) {
            // 当天的股票价格 与 最小股票价格的差值，与 前一天最高的价格。
            dp[i] = Math.max(prices[i] - minD, dp[i - 1]);
            // 判断当前天是不是最低价格；
            minD = Math.min(minD,  prices[i]);
            // 更新结果。
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
