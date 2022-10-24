package postgraduate.leetcd.qiuZhao;

import java.util.Scanner;

/**360-20221009第二题
 * 题目描述:
 * -日，小A走在路上时看到路边摆着一面大镜子。他对着这面镜子注视了半,，突然发现自已穿越到了另—个世界!
 * 这个世界很奇怪:他所在的地方可视为一个n行m列的矩阵，每一个位置上都有一个非负整数或者-1。这
 * 时,他的耳边响起了一个很空灵的声音:“如果您想要回到原来的世界，你需要解夫卜面的问题:你需要在
 * 整个矩阵上选择一个正方形区域，使得该区域不包含任何负数，并且该区域内的数字之和最大。
 * 然而这个问题对于小A来说还是太准了，所以他请了你来帮忙解决这个问题。
 *
 * 输入描述
 * 第一行一个正整数T,表示共有T组数据。
 * 对于每组数据,第一行两个正整数n,m,含义见题面，
 * 接下来一个n行m列的整数矩阵aij
 * 1<=n,m<=500,1<=T<=5,aij属于{-1,[0,100]}
 * 输出描述：
 * 对于每组数据,输出一行一个正整数，表示满足条件的最大值。如果该矩阵全为-1,则输出0.
 *
 样例输入：
 1
 4 4
 3 0 5 6
 0 9 -1 4
 -1 8 1 1
 4 -1 5 -1
 样例输出
 12
 提示
 选择左上角的2x2方形,和为3+0+0+9-12.
 */
public class S360_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fre = sc.nextInt();
        for (int i = 0; i < fre; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] juZhen = new int[n][m];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    juZhen[j][k] = sc.nextInt();
                }
            }
            dealMatrix(juZhen, n, m);
        }
    }
    private static void dealMatrix(int[][] matrix, int n, int m){
        int zuiDa = Math.min(m, n);
        int max = 0;
        for (int i = 1; i <= zuiDa; i++) {
            for (int j = 0; j <= n - i; j++) {
                for (int k = 0; k <= m - i; k++) {
                    final int check = findMatrix(matrix, j, k, i);
                    max = check == -1 ? max : Math.max(check, max);
                }
            }
        }
        System.out.println(max);
    }

    private static int findMatrix(int[][] matrix, int j, int k, int i) {
        int sum = 0;
        boolean flag = false;
        loop:
        for (int l = j; l < j + i; l++) {
            for (int m = k; m < k + i; m++) {
                if (matrix[l][m] < 0){
                    flag = true;
                    break loop;
                }
                sum += matrix[l][m];
            }
        }
        return flag ? -1 : sum;
    }
}
