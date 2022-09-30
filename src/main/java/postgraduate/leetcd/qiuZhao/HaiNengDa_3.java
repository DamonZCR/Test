package postgraduate.leetcd.qiuZhao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**海能达-20220926
 *给你两个版本号 version1 和 version2 ，请你比较它们。
 * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。
 * 每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，
 * 以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
 * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。
 * 也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。
 * 例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
 * 返回规则如下：
 * 如果version1>version2返回1，
 * 如果version1<version2 返回 -1，
 * 除此之外返回 0。
 * 示例 1：
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：忽略前导零，"01" 和 "001" 都表示相同的整数 "1"
 */
public class HaiNengDa_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String version1 = br.readLine();
        String version2 = br.readLine();
        if (version1.length() == 0 || version2.length() == 0){
            System.out.println(0);
        }
        int l1 = 0;
        int l2 = 0;
        int n1 = 0;
        int n2 = 0;
        while (l1 < version1.length() || l2 < version2.length()){
            n1 = 0;
            n2 = 0;
            while (l1 < version1.length() && version1.charAt(l1) != '.'){
                n1 = n1 * 10 + (version1.charAt(l1) - '0');
                l1++;
            }
            while (l2 < version2.length() && version2.charAt(l2) != '.'){
                n2 = n2 * 10 + (version2.charAt(l2) - '0');
                l2++;
            }
            if (n1 > n2) {
                System.out.println(1);
                return;
            }
            else if (n1 < n2){
                System.out.println(-1);
                return;
            }
            if (l1 < version1.length() && version1.charAt(l1) == '.')
                ++l1;
            if (l2 < version2.length() && version2.charAt(l2) == '.')
                ++l2;
        }
        System.out.println(0);
    }
}
