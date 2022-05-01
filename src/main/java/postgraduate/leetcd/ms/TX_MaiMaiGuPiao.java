package postgraduate.leetcd.ms;

import java.util.Scanner;

/** 20220424-腾讯-第五题
 * 现在有一个长度为n的价格数组a，表示某只股票每天的价格，你每天最多买入或卖出该只股票的1手股票，买入或者卖出没有手续费，
 * 且卖出股票前必须手里已经有股票才能卖出，但是持有的股票数目不受限制，并且初始资金为m元，你在任意时刻都不能进行透支，
 * 所以你的资金必须始终大于等于0。请问你在n天结束之后，拥有最大的总资产是多少?(总资产:股票数目*股票价格+现金)
 * 输入描述:
 * 第一行两个正整数n, m (1<=n<=2000,1<=m<=10^9)。
 * 第二行n个正整数{an)(1<=ai<=10^9)，其中ai表示股票在第i天的售价。
 * 输出描述:
 * 输出n天结束之后，拥有最大的总资产
 * 示例1
 * 输入
 * 6 2
 * 2 3 1 1 1 2
 * 输出
 * 6
 * 说明
 * 第一天买入1手，第二天卖出1手，第三，四，五天都买入1手，持有到最后，总共持有3手股票，股票价格为2，总资产为6
 * 示例2
 * 输入
 * 3 2
 * 1 1 4
 * 输出
 * 8
 * 说明
 * 一种方案是:第一天买入，第二天买入，第三天继续持有，总共持有2手股票，股票价格为4，总资产为8
 * 示例3
 * 输入
 * 4 2
 * 1 1 4 1
 * 输出
 * 5
 * 说明
 * 一种方案是:第一天买入1手股票，第二天买入1手股票，第三天卖出1手股票，第四天持有，总共持有1手股票，价格为1，现金为4，总资产为5
 */
public class TX_MaiMaiGuPiao {
    static int res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int money = sc.nextInt();
        int[] value = new int[num];
        int res = 0;
        //System.out.println(num + money);
        for (int i = 0; i < num; i++) {
            value[i] = sc.nextInt();
        }
        dfs(value, 0, money,0);
        System.out.println(res);
    }
    private static void dfs(int[] a, int index, int m, int count){
        if (index >= a.length){
            res = Math.max(res, count * a[index - 1] + m);
            return;
        }
        if (m >= a[index]){
            dfs(a, index + 1, m - a[index], count + 1);
        }
        if (count > 0){
            dfs(a, index + 1, m + a[index],count - 1);
        }
    }
}
