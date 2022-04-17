package postgraduate.leetcd.ms;

/**20220414-美的笔试-第二题
 * 题目描述
 * 假设你有一个数组，其中第i个元素是股票在第i天的价格。
 * 你有一次买入和卖出的机会。(只有买入了股票以后才能卖出)。请你设计一个算法来计算可以获得的最大收益。
 * 实例1：
 * 输入：
 * [1,5,2]
 * 输入：
 * 4.00000
 *
 * 解析：
 * 	算法的思想是找到最小的股票价格，然后使用最大的股票价格减去最小的股票价格，但是要保证最小的股票价格在最大的股票价格之前。
 * 	所以，将最大利润设置为0，使用for循环遍历，当当日的股票价格减去最小的股票价格后，大于最大利润，那就保存为最大利润，
 * 	并且还算计算当前股票值是否小于最小的股票价格，如果是，就更新最小股票价格。
 */
public class MD_GuPiaoZuiDaLiRun {
    public static void main(String[] args) {
        System.out.println(maxProfit(new double[]{1,2,3}));
        System.out.println(maxProfit2(new double[]{1,2,3}));
    }

    /**
     *
     * @param prices
     * @return
     */
    public static double maxProfit (double[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        double min = prices[0];
        double maxPri = prices[1] - min;

        for (int i = 2; i < prices.length; i++) {
            if (prices[i - 1] < min){
                min = prices[i - 1];
            }
            double cha = prices[i] - min;
            if (cha > maxPri){
                maxPri = cha;
            }
        }
        return Math.max(maxPri, 0);
    }
    public static double maxProfit2 (double[] prices){
        double res = 0;
        if (prices == null || prices.length < 2)
            return 0;
        int len = prices.length;
        double min = prices[0];
        for (int i = 1; i < len; i++) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}
