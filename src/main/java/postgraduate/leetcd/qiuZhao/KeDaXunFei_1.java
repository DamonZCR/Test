package postgraduate.leetcd.qiuZhao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/** 科大讯飞20221009第一题
 *
 */
public class KeDaXunFei_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int M = Integer.parseInt(s[0]);
        int N = Integer.parseInt(s[1]);
        int[][] a = new int[M][N];
        int[][] b = new int[M][N];
        int[][] res = new int[M][N];
        for (int i = 0; i < M; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                a[i][j] = Integer.parseInt(s1[j]);
            }
        }
        for (int i = 0; i < M; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                b[i][j] = Integer.parseInt(s1[j]);
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(calc(a[i][j], b[i][j]));
                if (j != N - 1)
                    System.out.print(" ");

            }
            if (i != M - 1)
                System.out.println();
        }
    }
    private static int calc(int a, int b){
        int res = 0;
        res = a + 2 * b - 255;

        if (res < 0)
            return 0;
        else if (res > 255)
            return 255;
        else
            return res;
    }
}
