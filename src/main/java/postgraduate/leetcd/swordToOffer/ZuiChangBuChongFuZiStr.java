package postgraduate.leetcd.swordToOffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 解题思路：
 *      思路1：思路来自LianXuZiShuZuDeZuiDaHe.java。第i个位置上不重复字符的最大长度使用dp数组来
 *   记录；遍历这个字符串，使用一个HashMap来记录，遍历到的这个字符是否出现过，如果出现了，有两种情况：
 *   1、如abbcef类型，就是第二次出现的b的和前一个b紧挨着，说明dp[2]直接从1开始就行。2、如abefbcd型，
 *   这样，第二个b的dp[4]=3,怎么计算呢？就是上第二个b的位置坐标减去第一个b的位置坐标，然后，清空map，
 *   将他们俩中间的加进map种。
 *
 */
public class ZuiChangBuChongFuZiStr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**执行结果：
     通过
     显示详情
     添加备注
     执行用时：870 ms, 在所有 Java 提交中击败了5.02% 的用户
     内存消耗：41.9 MB, 在所有 Java 提交中击败了5.01% 的用户
     通过测试用例：987 / 987
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s){
        if (s.length() == 0)
            return 0;
        int[] dp = new int[s.length()];
        HashMap<String, Integer> str = new HashMap<>(s.length());
        dp[0] = 1;
        str.put(String.valueOf(s.charAt(0)), 0);
        int res = 1;

        for (int i = 1; i < s.length(); i++) {
            if (Integer.MAX_VALUE == str.getOrDefault(String.valueOf(s.charAt(i)), Integer.MAX_VALUE)){
                str.put(String.valueOf(s.charAt(i)), i);
                dp[i] = dp[i - 1] + 1;
            }else {
                int loca = str.get(String.valueOf(s.charAt(i)));
                dp[i] = i - loca;
                str.clear();
                for (int j = loca + 1; j <= i; j++) {
                    str.put(String.valueOf(s.charAt(j)),  j);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
