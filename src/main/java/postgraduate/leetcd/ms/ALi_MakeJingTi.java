package postgraduate.leetcd.ms;

import java.util.Scanner;

/**
 * 输入：
 * 2
 * 3 4
 * 5 3
 * 输出：
 * 37
 */
public class ALi_MakeJingTi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] nums = new int[N][2];
        for (int i = 0;i < N; i++){
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        int res = calc(nums);
        System.out.println(res);
    }
    public static int calc(int[][] num){
        int res = 0;
        for (int[] n:num){
            int tmp = 1;
            int t = 1;
            while(0 < n[1]){
                t = t + n[0] - 2;
                tmp = tmp + t;
                n[1]--;
            }
            res += tmp;
        }
        return res;
    }
}
