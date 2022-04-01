package postgraduate.leetcd.ms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**360-2022-0319寻找子串
 * 英语老师看你老是在英语课上和周国同学交头接耳，所以给你布置了工份额外的家庭作业来惩罚惩罚你:
 * 你有一个字符串s，请你在s的所有子串中，找到出现次数最多的子串，告诉老师它的出现次数。
 * 输入描述：
 * 共一行，一个字符串s，仅由英文小写字母组成，1 <= |s| <= 10000。
 * 输出描述：
 * 一个正整数，表示最大出现次数。
 * 样例输入：
 * aba
 * 样例输出：
 * 2
 * 通过率：64%
 */
public class San60_XunZhaoZiChuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Map<String ,Integer> map = new HashMap<>();
        int lenth = s.length();
        int max =0;

        for (int i = 0; i < lenth; i++) {
            for (int j = i; j < lenth; j++) {
                String temp = s.substring(i, j + 1);
                map.put(temp, map.getOrDefault(temp, 0) + 1);
                max = Math.max(max, map.get(temp));
            }
        }
        System.out.println(max);
    }
}
