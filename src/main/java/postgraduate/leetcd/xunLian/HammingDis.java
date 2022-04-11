package postgraduate.leetcd.xunLian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**ID461 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数x和y,计算它们之间的汉明距离。
 * 注意:
 * 0≤x,y< 2^31.
 * 示例:
 * 输入:x=1,y=4
 * 输出: 2
 * 解释:
 * 1的二进制为(001)
 * 4的二进制为(100)不同位为2.
 */
public class HammingDis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        System.out.println(solve(x, y));
        System.out.println(solve2(x, y));
    }

    private static int solve(int x, int y) {
        String s1 = Integer.toBinaryString(x);
        String s2 = Integer.toBinaryString(y);
        int res = 0;
        int minlen = 0,dis = 0;
        if (s1.length() < s2.length()) {
            minlen = s1.length();
            dis = s2.length() - minlen;
            for (int j = 0;j < dis;j++){
                if(s2.charAt(j) != '0')
                    res++;
            }
            for(int i = minlen - 1;i >= 0;i--){
                char c = s1.charAt(i);
                char c2 = s2.charAt(i + dis);
                if (c != c2)
                    res++;
            }
        }
        else{
            minlen = s2.length();
            dis = s1.length() - minlen;
            for (int j = 0;j < dis;j++){
                if(s1.charAt(j) != '0')
                    res++;
            }
            for(int i = minlen - 1;i >= 0;i--){
                char c2 = s1.charAt(i + dis);
                char c = s2.charAt(i);
                if (c != c2)
                    res++;
            }
        }
        return res;
    }
    private static int solve2(int x,int y){
        // 将x 和y 进行异或，相同为0，不同为1，然后统计1 的个数。
        // bitCount(int val) 用于统计整数的二进制形式中1 的个数。
        return Integer.bitCount(x ^ y);
    }
}
