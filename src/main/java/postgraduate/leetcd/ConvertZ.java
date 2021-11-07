package postgraduate.leetcd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 示例：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 解法：首先访问 行 0 中的所有字符，接着访问 行 1，然后 行 2，依此类推...
 * 对于所有整数 k，
 *     行 0中的字符位于索引 k(2⋅numRows−2)处;
 *     行 numRows−1中的字符位于索引 k(2⋅numRows−2)+numRows−1处;
 *     内部的行 i中的字符位于索引 k(2⋅numRows−2)+i以及 (k+1)(2⋅numRows−2)−i处;
 */
public class ConvertZ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int numRows = Integer.parseInt(br.readLine());
        System.out.println(solve(s, numRows));
    }
    private static String solve(String s, int numRows){
        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            // j 就代表成倍增长的 cycleLen.
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
}
