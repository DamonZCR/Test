package postgraduate.leetcd.qiuZhao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**爱数科技20220913
 * 找到一个整数数组中和为0的子数组，输出满足要求的所有子数组的个数；
 * 如：-3,1,2,-3,4输出2;
 */
public class AiShu_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(",");
        int res = 0;
        int[] num = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            num[i] = Integer.parseInt(line[i]);
        }
        int len = num.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum = num[i];
            if (sum == 0)
                res++;
            for (int j = i + 1; j < len; j++) {
                sum = sum + num[j];
                if (sum == 0)
                    res++;
            }
        }
        System.out.println(res);
    }
}
