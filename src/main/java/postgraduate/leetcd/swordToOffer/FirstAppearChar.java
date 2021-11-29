package postgraduate.leetcd.swordToOffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * 示例 1:
 * 输入：s = "abaccdeff"
 * 输出：'b'
 *
 * 示例 2:
 * 输入：s = ""
 * 输出：' '
 * 限制：
 * 0 <= s 的长度 <= 50000
 */
public class FirstAppearChar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(firstUniqChar(s));
    }

    private static char firstUniqChar(String s) {
        /**
         * 执行用时：283 ms, 在所有 Java 提交中击败了5.37% 的用户
         * 内存消耗：44.8 MB, 在所有 Java 提交中击败了5.02% 的用户
         * 通过测试用例：104 / 104
         */
        if (s.length() == 0)
            return ' ';
        List<String> chars = Arrays.asList(s.split(""));
        List<String> list = chars.stream().distinct().collect(Collectors.toList());
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            String next = it.next();
            if (Collections.frequency(chars, next) == 1)
                return next.charAt(0);
        }
        return ' ';
    }
}
