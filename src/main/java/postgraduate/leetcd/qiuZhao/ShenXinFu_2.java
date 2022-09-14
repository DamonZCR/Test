package postgraduate.leetcd.qiuZhao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**深信服-20220914
 * 最小的改变次数
 * 输入n个数，在输入一个数x,使得这n个数按照先后顺序和某一个数比较，的差的绝对值小于x；
 * 那么为了实现这个过程，问这个数最少需要改变几次？
 * 如：4- 9 - 6 -7 - 8
 * 输出：0；
 * 即最少改变0就可以实现，假设这个数为6，那么就可以成立；
 */
public class ShenXinFu_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num1 = br.readLine();
        String[] s1 = num1.split(" ");
        int n = Integer.parseInt(s1[0]);
        int x = Integer.parseInt(s1[1]);
        String[] s2 = br.readLine().split(" ");
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(s2[i]);
        }
        int[] cha = new int[n];
        for (int i = 0; i < n - 1; i++) {
            cha[i] = Math.abs(num[i] - num[i + 1]);
        }
        int lin = 0;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(lin - num[i]) > x){
                if (cha[i] > cha[i + 1]){
                    lin = num[i] + (int)Math.ceil((num[i] + num[i + 1])/2);
                }else {
                    lin = num[i + 1] + (int)Math.ceil((num[i] + num[i + 1])/2);
                }
            }
            if (Math.abs(lin - num[i]) < x)
                continue;
            else
                res++;
        }
        System.out.println(res);
    }
}
