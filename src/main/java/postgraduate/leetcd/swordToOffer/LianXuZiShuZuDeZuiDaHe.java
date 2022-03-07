package postgraduate.leetcd.swordToOffer;

/**剑指 Offer 42. 连续子数组的最大和
 * 重！！！！！！！
 *输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 *
 * 示例1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 官方题解视频：https://www.bilibili.com/video/BV1Lq4y1X7oF?from=search&seid=16272962601008832536&spm_id_from=333.337.0.0
 */
public class LianXuZiShuZuDeZuiDaHe {

    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 添加备注
     * 执行用时：1 ms, 在所有 Java 提交中击败了71.10% 的用户
     * 内存消耗：48 MB, 在所有 Java 提交中击败了18.52% 的用户
     * 通过测试用例：202 / 202
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        // 设置返回结果初始值为，首元素；
        int res = nums[0];
        int len = nums.length;
        // 设置dp数组；dp[i]表示的就是从 0到i-1计算出的连续最大值。
        int[] dp = new int[len];
        dp[0] = nums[0];

        // 对于nums中的元素nums[j],如果当前的dp[j-1]加上它以后的和，比nums[j]还小，说明原来的dp[j-1]
        //很可能是一个负数，就取nums[j]作为dp[i],最后将dp[j]与原来的最大值比较取最大；
        for (int j = 1;j < len;j++){
            dp[j] = Math.max(dp[j-1] + nums[j], nums[j]);
            res = Math.max(dp[j], res);
        }
        return res;
    }
}
