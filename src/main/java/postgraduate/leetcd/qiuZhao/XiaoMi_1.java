package postgraduate.leetcd.qiuZhao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XiaoMi_1 {
    public static void main(String[] args) throws IOException {
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        int len1 = s.length();
        int len2 = t.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }
        for (int i = 1; i < len1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
        System.out.println(dp[len1][len2]);*/
        funcs2();
    }
    public static void funcs2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        int len1 = s.length();
        int len2 = t.length();

        if (len1 * len2 == 0) {
            System.out.println(len1 + len2);
            return;
        }
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1 + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < len2 + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int left_down = dp[i - 1][j - 1];
                if (s.charAt(i - 1) != t.charAt(j - 1)){
                    left_down += 1;
                }
                dp[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        System.out.println(dp[len1][len2]);
    }

}
