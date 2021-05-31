package postgraduate.leetcd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**ID 231
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 *输入：n = 1
 * 输出：true
 * 解释：2^0 = 1
 */
public class Power2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int bin = Integer.parseInt(s);
        if (bin <= 0){
            System.out.println("No");
            return;
        }
        solve(bin);
        solve2(bin);
    }
    // 判断 二进制字符串中 1 的个数，只有存在一个 1 时，才是2 的次方。
    private static void solve(int bin){
        String s1 = Integer.toBinaryString(bin);
        int flag = 0;
        for(int i = 0;i < s1.length();i++){
            char c = s1.charAt(i);
            if (c =='1') {
                flag++;
                if (flag == 2){
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println("Yes");
    }
    // 使用位运算
    /**
     * 若 n=2^x且 x为自然数（即 n 为 2的幂），则一定满足以下条件：
     *     恒有 n & (n - 1) == 0，这是因为：
     *         n二进制最高位为1，其余所有位为 0；
     *         n−1二进制最高位为 0，其余所有位为 1；
     *     一定满足 n > 0。
     * 因此，通过 n > 0 且 n & (n - 1) == 0 即可判定是否满足 n=2^x
     * @param bin
     */
    private static void solve2(int bin){
        boolean res = bin > 0 && (bin & (bin - 1)) == 0;
        System.out.println(res);
    }

}