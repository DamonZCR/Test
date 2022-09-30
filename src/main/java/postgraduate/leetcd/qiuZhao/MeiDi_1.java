package postgraduate.leetcd.qiuZhao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**美的-20220923
 * 输入一个数组，将这个数组排序后输出；
 */
public class MeiDi_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(",");
        int len = s.length;
        int[] nums = new int[s.length];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(nums);
        System.out.print("[");
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]);
            if (i != len - 1)
                System.out.println(",");
        }
        System.out.print("]");
    }
}
