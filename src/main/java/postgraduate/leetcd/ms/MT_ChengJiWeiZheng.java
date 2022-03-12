package postgraduate.leetcd.ms;

/**乘积为正-美团20220312笔试；
 * 小美现在有一个序列，序列中仅包含1和-1两种数字。
 * 小美现在想要知道，有多少个连续的子序列，序列中的数字乘积为正。
 *
 *输入描述
 * 第一行一个正整数n,表示小美手中的序列长度。
 * 第二行n个空格隔开的数字，每个数字只能是1和-1中的一种。
 * 对于80%的数据保证1<= n <= 500
 * 对于剩余20%的数据保证1<=n<= 5000
 * 输出描述
 * 一行一 个正整数表示有多少连续的子序列满足题目要求。
 * 样例输入：
 * 4
 * 1 1 -1 -1
 * 输出：
 * 6
 * 提示：
 * 共有6个连续子序列满足要求。
 * [1], [1]， [1, 1]，[-1， -1]，[1, -1，-1]，[1，1, -1, -1]
 */
public class MT_ChengJiWeiZheng {

    public static void sonNum(int n, int[] nums){
        int res = 0;
        int len = nums.length;
        int lin2 = 0;

        for (int i = 0; i < len; i++) {
            int lin = nums[i];
            if (lin > 0){
                res++;
            }
            lin2 = 1;
            for (int j = i + 1; j < len; j++) {
                lin2 = lin * nums[j] * lin2;
                if (lin2 > 0){
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
