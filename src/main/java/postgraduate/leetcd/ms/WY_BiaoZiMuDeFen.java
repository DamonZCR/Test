package postgraduate.leetcd.ms;

import java.util.Scanner;
/** 网易-20220327
 * 小红拿到了一个字符串，她可以做任意次以下操作:
 * 标记这个字符串两个位置相邻的字母，并且这两个字母必须满足以下条件才可标记:两个字母
 * 相同或者两个字母在宇母表中相邻。小红可以获得这两个字母的分数。
 * 举个例子，'a和b在字母表相邻，T 和's'在字母表相邻。
 * 我们规定，已经被标记的字母无法被重复标记。
 * 每个字符获得的分数是不同的，'a' 可以获得1分，'b' 可以获得2分，以此类推，'z'可以获得26
 * 小红想知道，自己最多可以获得多少分?
 * 输入描述:
 * 输入一行只包含小写字母的非空字符串s，代表小红拿到的字符串。
 * 1 <= len(s) <= 200000
 * 输出描述:
 * 小红可以获得的最大分数。
 * 输入：
 * abdbb
 * 输出：
 * 7；因为ab相加为1 + 2 = 3；bb相加为2+ 2 = 4；所以3+ 4= 7；
 * 输入：
 * abb
 * 输出；
 * 4
 */
public class WY_BiaoZiMuDeFen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(solve(s));
        solve2(s);
    }
    // 方法一；

    /** 动态规划做法
     * 一个位置的字符可以得到的最多分数，首先要看这个和前面的这个数是不是满足1、相同。2、Ascii码相减为1。
     * 如ab，可以看出从第二个字符开始判断，这个b是否满足上面的条件；
     * 如果为abb,判断到第三个字符时，就要考虑最大值的问题，需要判断取ab还是bb;
     * 如果为abbc,因为abb的最后一个b记录了当前的最大值，所以当轮到c时，需要考虑将abb拆分为ab，让最后一个b和c;     *
     */
    public static int solve(String s){
        if (s.length() <= 1)
            return 0;
        int res = 0;
        int A = 96;
        int len = s.length();
        int[][] dp = new int[2][len];
        dp[0][0] = 0;
        dp[1][0] = 0;

        for (int i = 1; i < len; i++) {
            int value = 0;
            char lchar = s.charAt(i - 1);
            if (dp[1][i - 1] == 0){//前方未被使用
                if (lchar - s.charAt(i) == 0){
                    value = 2 * lchar - 2 * A;
                    dp[0][i] = dp[0][i - 1] + value;
                    dp[1][i] = 1;
                }else if (Math.abs(lchar - s.charAt(i)) == 1){
                    value = lchar + s.charAt(i) - 2 * A;
                    dp[0][i] = dp[0][i - 1] + value;
                    dp[1][i] = 1;
                }else{
                    dp[0][i] = dp[0][i - 1];
                }
            }else {
                if (lchar - s.charAt(i) == 0){//abb
                    value = 2 * lchar - 2 * A;
                    dp[0][i] = Math.max(dp[0][i - 2] + value, dp[0][i - 1]);
                    if (dp[0][i] != dp[0][i - 1])// 说明使用了该位符号
                        dp[1][i] = 1;
                }else if (Math.abs(lchar - s.charAt(i)) == 1){//abbc
                    value = lchar + s.charAt(i) - 2 * A;
                    dp[0][i] = Math.max(dp[0][i - 2] + value, dp[0][i - 1]) ;
                    if (dp[0][i] != dp[0][i - 1])
                        dp[1][i] = 1;
                }else{
                    dp[0][i] = dp[0][i - 1];
                }
            }
            res = Math.max(res, dp[0][i]);
        }
        return res;
    }
    // 方法二
    //方法一的简化版；
    public static void solve2(String str){
        int[] dp = new int[str.length() + 1];
        // 序号i（i为0到str.length - 1）的dp最大值存储在dp[i + 1]的位置';
        // 所以字符串abbc中序号为 1 的字符b，dp值存储在dp[2]中；
        for (int i = 2; i < dp.length; i++) {
            if (Math.abs(str.charAt(i - 1) - str.charAt(i - 2)) <= 1){
                dp[i] = Math.max((dp[i - 2] + str.charAt(i - 1) - 'a' + 1 + str.charAt(i - 2)
                        - 'a' + 1), dp[i - 1]);
            }else
                dp[i] = dp[i - 1];
        }
        System.out.println(dp[str.length()]);
    }
}
