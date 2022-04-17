package postgraduate.leetcd.ms;

import java.util.HashSet;
import java.util.Scanner;

/**20220417-网易游戏-第二题-通过70%
 * 输入描述:
 * 输入第一行为一个正整数T，表示有T组数据。
 * 每组数据的第一行为一个正整数n，表示一共有n个御魂。
 * 接下来有n行，每行三个数据。御魂的位置，御魂提供的暴击概率(整数)，暴击伤害(整数)。1<=PK=6,0<=C<=25,0<=DK=50,
 * P:御魂位置
 * c:暴击概率(百分比数值)D:暴击伤害
 * 数据范围:
 * 对于所有数据，满足1<=T<=10
 * 对于70%的数据，每个位置的御魂数量小于等于10对于100%的数据，每个位置的御魂数量小于等于30
 * 题目会根据通过的case数给分
 * 输出描述:
 * 对于每一组数据，输出最高的暴击伤害加成。如果找不到一个满爆的方案，则输出TAT。
 * 示例1，输入：
 * 2
 * 12
 * 1 12 6
 * 1 14 10
 * 2 22 3
 * 2 3 38
 * 3 24 1
 * 3 3 15
 * 3 11 23
 * 4 13 2
 * 5 19 10
 * 5 17 11
 * 5 16 2
 * 6 20 2
 * 11
 * 1 14 16
 * 1 17 3
 * 2 6 32
 * 3 3 24
 * 4 12 3
 * 4 13 0
 * 5 22 5
 * 5 21 4
 * 6 3 37
 * 6 14 6
 * 6 23 0
 * 输出：
 * 29
 * TAT
 *
 * 说明
 * 样例1中,
 * 1号位御魂选择14暴击概率，10暴击伤害
 * 2号位御魂选择22暴击概率，3暴击伤害
 * 3号位御魂选择24暴击概率，1暴击伤害
 * 4号位御魂选择13暴击概率，2暴击伤害
 * 5号位御魂选择17暴击概率，11暴击伤害
 * 6号位御魂选择20暴击概率，2暴击伤害
 * 样例2中不存在满爆的御魂方案，输出TAT
 */
public class WY_YinYangShi {
    static int[] res;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        res = new int[N];
        for (int i = 0; i < N; i++) {
            int m = Integer.valueOf(in.nextLine());
            int[][] count = new int[m][3];
            for (int l = 0; l < m; l++)
            for (int k = 0; k < 3; k++) {
                count[l][k] = in.nextInt();
            }
            HashSet<Integer> set = new HashSet<>();
            dfs(count, 0, 0, 0, set, i);
            in.nextLine();
        }
        for (int i = 0; i < N; i++) {
            if (res[i] > 0)
                System.out.println(res[i]);
            else
                System.out.println("TAT");
        }
    }
    private static void dfs(int[][] mat, int index, int sum, int score,
                            HashSet<Integer> set, int ii){
        if (set.size() == 6){
            if (sum >= 100){
                res[ii] = Math.max(score, res[ii]);
            }
            return;
        }
        for (int i = index; i < mat.length; i++) {
            if (!set.contains(mat[i][0])){
                set.add(mat[i][0]);
                dfs(mat, i + 1, sum + mat[i][1], score + mat[i][2], set, ii);
                set.remove(mat[i][0]);
            }

        }
    }
}
