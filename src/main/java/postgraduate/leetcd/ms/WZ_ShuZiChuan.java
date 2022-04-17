package postgraduate.leetcd.ms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/** 微众-20220411笔试
 * 小明有一个长度为n的仅由0到9组成的字符串。小美想知道这个串里有多少个子串代表的十进制数能被k整除。
 * 字符串a的子串即是那些可被描述为“由a中第i至第j个字符组成的字符串”的串。如字符串‘121’有‘1','2'，'‘1'，'12’,‘21’,‘121’六个子串。。
 * 输入描述
 * 第一行有两个整数n(1<=n<=1000),k(1<=k<=1000)，代表这个数字串的长度和询问的数。
 * 第二行有一个长度为n的数字串。
 * 输出描述
 * 输出一个整数，代表给出的数字串中有多少个子串满足其对应的十进制数能被k整除。如样例中的‘1101' ,012'，‘12',0’都能被3整除。
 * 样例输入
 * 5 3
 * 11012
 * 样例输出
 * 4
 */
public class WZ_ShuZiChuan {
    public static void main(String[] args) throws IOException {
        solve();
    }
    public static void solve() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] str = input.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        String theNum = input.readLine();
        int len = theNum.length();
        BigInteger bi;
        int res = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                String lin = theNum.substring(i, j + 1);
                bi = new BigInteger(lin);
                if (bi.mod(new BigInteger(String.valueOf(k))).equals(BigInteger.ZERO)){
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
