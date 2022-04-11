package postgraduate.leetcd.xunLian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 给你两个整数，n 和 start 。数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）
 * 且 n == nums.length 。请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 * 如：输入：n = 4, start = 3
 * 输出：8
 * 解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8.
 */
public class XORArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int i = xorOperation(a, b);
        System.out.println(i);
    }

    private static int xorOperation(int n, int start) {
        int one = start;
        for(int i = 1;i < n; i++){
            one = one ^ (start + 2 * i);
        }
        return one;
    }
}
