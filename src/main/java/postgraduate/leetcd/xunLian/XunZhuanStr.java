package postgraduate.leetcd.xunLian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** ID-796. 旋转字符串
 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
 s 的 旋转操作 就是将 s 最左边的字符移动到最右边。
 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。

 示例 1:
 输入: s = "abcde", goal = "cdeab"
 输出: true
 示例 2:
 输入: s = "abcde", goal = "abced"
 输出: false
 */
public class XunZhuanStr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String goal = br.readLine();
        System.out.println(rotateString(s, goal));
    }
    public static boolean rotateString(String s, String goal){
        /**
         * 执行结果：
         * 通过
         * 显示详情
         *
         * 添加备注
         * 执行用时：3 ms, 在所有 Java 提交中击败了7.59% 的用户
         * 内存消耗：41 MB, 在所有 Java 提交中击败了5.04% 的用户
         * 通过测试用例：47 / 47
         * 如果长度不相等或者长度为零返回false，
         * 如果直接相等返回ture;
         * 如果长度为一返回true；
         * 然后将字符串进行分割，每次在末尾添加即可；
         */
        if (s.length() != goal.length() || s.length() == 0)
            return false;
        if (s.equals(goal))
            return true;
        if (s.length() == 1)
            if (s.equals(goal))
                return true;
            else
                return false;
        int len = s.length();
        String[] split = s.split("");
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < len - 1; i++) {
            sb = new StringBuilder(sb.substring(1, len));
            sb.append(split[i]);
            if (sb.toString().equals(goal))
                return true;
        }
        return false;
    }
}
