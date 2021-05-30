package postgraduate.leetcd.lanqiao;

/**
 * x星球的质监局规定了手机必须经过耐摔测试，并且评定出一个耐摔指数来，之后才允许上市流通。
 * X 星球的高塔做耐摔测试。塔的每一层高度都是一样的，与地球上稍有不同的是，他们的第一层不是地面，而是相当于我们的 2楼。
 * 如果手机从第 7层扔下去没摔坏，但第 8层摔坏了，则手机耐摔指 =7。 特别地，如果手机从第 1层扔下去就坏了，则耐摔指数 =0。
 * 如果到了塔的最高层第 n 层扔没摔坏，则耐摔指数=n。为了减少测试次数，从每个厂家抽样 333 部手机参加测试。
 * 某次测试的塔高为 1000层，如果我们总是采用最佳策略，在最坏的运气下最多需要测试多少次才能确定手机的耐摔指数呢？请填写这个最多测试次数。
 */
//3部手机，1000层楼，最坏需要测试几次
//该算法可用递归 + 二分进行优化，这里作为填空题直接暴力递归即可
public class XBallPhone {

    //备忘录，防止重复循环,给一个维度较大的值即可
    private static int[][] memo=new int[3000][3000];

    public static void main(String[] args) {
        System.out.println(dp(3, 1000));
    }
    //m个手机，第n层楼开始丢
    private static int dp(int m,int n) {
        //定义一个较大的值
        int ans = 1000;
        //只有一个手机时，需要测n次
        if(m==1) return n;
        //楼层为0时，不用测试
        if(n==0) return 0;
        //记录过，直接返回
        if((memo[m][n]>=1)) return memo[m][n];
        //遍历楼层数
        for(int i=1;i<=n;i++) {
            //分手机碎和没碎两种情况写状态转移方程
            //min表示“至少”，max表示“最坏”
            ans = Math.min(Math.max(dp(m, n-i), dp(m-1, i-1))+1,ans);
            //表示记录过
            memo[m][n] = ans;
        }
        return ans;
    }
}
