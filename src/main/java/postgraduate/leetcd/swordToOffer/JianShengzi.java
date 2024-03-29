package postgraduate.leetcd.swordToOffer;

public class JianShengzi {
    public static void main(String[] args) {
        System.out.println(cuttingRope(5));
        System.out.println(cuttingRope2(5));
    }
    /**
     * 使用数学推导总结的经验完成：
     * 规律1：
     * @param n
     * @return
     */
    public static int cuttingRope(int n){
        if (n <= 3)
            return n - 1;
        int a = n / 3;
        int b = n % 3;
        if (b == 0)
            return (int)Math.pow(3, a);
        if (b == 1)
            return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }

    /** 推荐！
     * 动态规划
     * 这题用动态规划是比较好理解的
     *
     * 1、我们想要求长度为n的绳子剪掉后的最大乘积，可以从前面比n小的绳子转移而来
     * 2、用一个dp数组记录从0到n长度的绳子剪掉后的最大乘积，也就是dp[i]表示长度为i的绳子剪成m段后的最大乘积，初始化dp[2] = 1
     * 3、我们先把绳子剪掉第一段（长度为j），如果只剪掉长度为1，对最后的乘积无任何增益，所以从长度为2开始剪
     * 4、剪了第一段后，剩下(i - j)长度可以剪也可以不剪。如果不剪的话长度乘积即为j * (i - j)；
     *  如果剪的话长度乘积即为j * dp[i - j]。取两者最大值max(j * (i - j), j * dp[i - j])
     * 5、第一段长度j可以取的区间为[2,i)，对所有j不同的情况取最大值，因此最终dp[i]的转移方程为
     *  dp[i] = max(dp[i], max(j * (i - j), j * dp[i - j]))
     * 6、最后返回dp[n]即可。
     * @param n
     * @return
     */
    public static int cuttingRope2(int n){
        int[] dp = new int[n + 1];
        dp[2] = 1;

        for (int i = 3; i < n + 1; i++) {
            for (int j = 2; j < n + 1; j++) {
                // 关键在于：Max中继续使用dp[j],去访问记录过的j的最大值；
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), (i - j) * dp[j]));
            }
        }
        return dp[n];
    }
}
