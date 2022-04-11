package postgraduate.leetcd.xunLian;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 二进制加法
 * 华为笔试题，给定两个只有“1”和“0” 组成的字符串，进行二进制的加法。
 */
public class AddBinary {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        System.out.println("方法一：" + Solution1(s1, s2));
        System.out.println("方法二：" + Solution2(s1, s2));
    }

    // 方法一：先将 a 和 b 转化成十进制数求和，再转化为二进制数。
    private static String Solution1(String s1, String s2) {
        /**缺点
         * 在 Java 中
         *     如果01字符串超过 33 位，不能转化为 Integer
         *     如果01字符串超过 65 位，不能转化为 Long
         *     如果01字符串超过 500000001位，不能转化为 BigInteger
         */
        return Integer.toBinaryString(
                // .parseInt 以第二个参数指定的基数将字符串参数解析为有符号整数。
                Integer.parseInt(s1, 2) + Integer.parseInt(s2, 2)
        );
    }
    // 方法二：末尾对齐，逐位相加。二进制中「逢二进一」
    public static String Solution2(String a, String b) {
        /**
         * 具体的，我们可以取 n=max{∣a∣, ∣b∣}，循环 n 次，从最低位开始遍历。我们使用一个变量 carry表示上一个位置的进位，
         * 初始值为 0。记当前位置对其的两个位为 ai​ 和 bi​，则每一位的答案为 (carry+ai+bi) mod 2，
         * 下一位的进位为 ⌊(carry+ai+bi)2⌋。重复上述步骤，直到数字 a和 b 的每一位计算完毕。最后如果 carry 的最高位
         * 不为 0，则将最高位添加到计算结果的末尾。注意，为了让各个位置对齐，可以先反转这个代表二进制数字的字符串，
         * 然后低下标对应低位，高下标对应高位。
         */
        StringBuffer ans = new StringBuffer();
        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }


}
