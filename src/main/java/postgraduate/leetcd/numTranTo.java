package postgraduate.leetcd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 现在有一个数字n,你可以通过下面三种变换，使得这个数字变成0，现在想知道最少需要变换几次
 * 第一种变换: n=n-1
 * 第二种变换:若n是偶数，则n=n/2
 * 第三种变换:若n是3的倍数，n= n/3.
 * 输入描述:
 * 输入第一行一个整数 T，代表有 T组测浦数据
 * 接下来 T 行，每一行为一个整数n，代表要变换的数:
 * 1<= T<= 1000,1<=n<=2*10^9
 * 输出描述:
 * 对于每组测试数据，输出一个答案代表最少需要变换的次数
 * 案例：
 * 输入：
 * 1
 * 10
 * 输出：4
 */

class numTranTo{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        while (num-- > 0){
            int t = Integer.parseInt(br.readLine());
            int[] dp = new int[t + 1];
            dp[1] = 1; // n - 1
            dp[2] = 2; // 2的倍数
            dp[3] = 2; // 3的倍数
            for (int i = 4; i <= t; i++){
                dp[i]  = Integer.MAX_VALUE;
                if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
                if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            }
            System.out.println(dp[t]);
        }

    }
}