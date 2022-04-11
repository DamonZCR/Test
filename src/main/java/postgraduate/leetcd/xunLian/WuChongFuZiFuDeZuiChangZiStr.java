package postgraduate.leetcd.xunLian;

import java.util.HashMap;
import java.util.Scanner;

/**ID-3
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class WuChongFuZiFuDeZuiChangZiStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s){
        /**
         * 执行用时：87 ms, 在所有 Java 提交中击败了9.36% 的用户
         * 内存消耗：41.6 MB, 在所有 Java 提交中击败了31.89% 的用户
         * 通过测试用例：987 / 987
         */
        int res = 0;
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int the = 1;
            map.put(s.charAt(i), 1);
            for (int j = i + 1; j < len; j++) {
                if (map.getOrDefault(s.charAt(j), -1) == -1){
                    map.put(s.charAt(j), 1);
                    the++;
                }else {
                    map.clear();
                    break;
                }
            }
            res = Math.max(res, the);
        }
        return res;
    }
}
