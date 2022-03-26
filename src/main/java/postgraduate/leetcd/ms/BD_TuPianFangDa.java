package postgraduate.leetcd.ms;

import java.util.Scanner;

/** 百度-20220322-图片放大
 * 现在我们想将图像放大，而放大图像的最简单的方法是在保持现有像素排列的情况下，平均增加每个像素的数量。
 * 当给定构成个长度为N的单色位图图像的所有像素的信息时，图片的宽度和高度增加K倍时，放大方式如下图所示:
 *
 * 第一行给出正方形单色位图的水平/垂直长度N和用于放大图像的倍数K。在第二行到第N + 1行中，每行给出N个像素的信息。
 * 1<N<10
 * 1<K<10
 * 输出：
 * 2 2
 * 0 1
 * 1 0
 * 输入：
 * 0 0 1 1
 * 0 0 1 1
 * 1 1 0 0
 * 1 1 0 0
 * 输入：
 * 3 3
 * 1 0 1
 * 0 0 0
 * 1 0 1
 * 输出：
 * 1 1 1 0 0 0 1 1 1
 * 1 1 1 0 0 0 1 1 1
 * 1 1 1 0 0 0 1 1 1
 * 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0
 * 1 1 1 0 0 0 1 1 1
 * 1 1 1 0 0 0 1 1 1
 * 1 1 1 0 0 0 1 1 1
 */
public class BD_TuPianFangDa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] input = new int[N][N];
        int[][] output = new int[K*N][K*N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                input[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                madeNums(i * N, j * N, K, output, input[i][j]);
            }
        }
        //打印输出
        for (int i = 0; i < K*N; i++) {
            for (int j = 0; j < K*N; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();//换行
        }
    }
    private static void madeNums(int high, int wide, int k, int[][] output, int value){
        for (int i = high; i < high + k; i++) {
            for (int j = wide; j < wide + k; j++) {
                output[i][j] = value;
            }
        }
    }
}
