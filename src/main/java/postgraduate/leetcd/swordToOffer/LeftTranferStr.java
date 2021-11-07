package postgraduate.leetcd.swordToOffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**剑指 Offer 58 - II. 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 *
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 */
public class LeftTranferStr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        // 方法一
        String res = reverseLeftWords(input[0], Integer.parseInt(input[1]));
        // 方法二
        String res2 = reverseLeftWords2(input[0], Integer.parseInt(input[1]));
        System.out.println(res + " " + res2);
    }
    // 方法一
    private static String reverseLeftWords(String s, int n) {
        /**
         * 执行结果：
         * 通过
         * 执行用时：12 ms, 在所有 Java 提交中击败了7.71% 的用户
         * 内存消耗：38 MB, 在所有 Java 提交中击败了84.41% 的用户
         * 通过测试用例：34 / 34
         */
        StringBuffer sb = new StringBuffer(s);
        for(int i = 0;i < n;i++){
            sb.append(s.charAt(i));
            sb.deleteCharAt(0);
        }
        return sb.toString();

    }
    // 方法二
    private static String reverseLeftWords2(String s, int n) {
        /**
         *执行结果：
         * 通过
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
         * 内存消耗：38.2 MB, 在所有 Java 提交中击败了46.15% 的用户
         * 通过测试用例：34 / 34
         */
        StringBuffer sb = new StringBuffer(s);
        sb.append(s.substring(0, n));
        sb.delete(0, n);
        return sb.toString();

    }
}
