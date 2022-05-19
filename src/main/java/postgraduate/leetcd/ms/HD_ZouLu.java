package postgraduate.leetcd.ms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 小李和同事玩贪吃蛇游戏。起始时，蛇位于m*n网格的左上角，现规定，贪吃蛇每次只能向右或者向下挪动一格且不能回退，
 * 猎物在该网格的右下角。请问，此种情况下，有多少种走法可以吃到该猎物?
 */
public class HD_ZouLu {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] split = s.split(",");
        int m = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        System.out.println(dp[m - 1][n - 1]);
    }
}
