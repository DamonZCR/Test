package postgraduate.leetcd.swordToOffer;

/** 搜索与回溯算法（中等）-剑指 Offer 13. 机器人的运动范围
 * 本题 和 JuZhenZhongRoad.java 为同类型 ----> 搜索与回溯算法
 *
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 *地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 */
public class JiQiRenSport {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }
    public int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        // i >= m || j >= n 如果出界，k < getSum(i) + getSum(j) 如果数位和大于k,visited[i][j] 已经标记访问；
        if(i >= m || j >= n || k < getSum(i) + getSum(j) || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 +
                dfs(i + 1, j, m, n, k, visited) +
                dfs(i, j + 1, m, n, k, visited);
    }
    // 计算数位和，如45计算后得到4+5=9；
    private int getSum(int a) {
        int sum = a % 10;
        int tmp = a / 10;
        while(tmp > 0) {
            sum += tmp % 10;
            tmp /= 10;
        }
        return sum;
    }
}
