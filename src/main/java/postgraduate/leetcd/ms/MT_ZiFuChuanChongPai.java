package postgraduate.leetcd.ms;

import java.util.*;
import java.util.stream.Collectors;

/**美团-20220326-字符串重排
 * 给你一个只包含小写字符的字符串s，你可以按任意顺序重排这个字符串中的字符，请问重排过后
 * 的字符串中，最多能有多少个acbcca' 子串?
 * 例如，字符串’dacbccab'中含1个acbcca' 子串， 按其他方式重排后最多也只能包含1个acbcca' 子串;
 * 字符串’acbccacccb'中含1个acbcca' 子串，但重排成’acbccacbcca'后包含 了2个acbcca' 子串。
 * 输入：
 * dacbccab
 * 输出：
 * 1
 * 输入：
 * acbccaacccb
 * 输出：
 * 2
 */
public class MT_ZiFuChuanChongPai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(solve(s));
    }
    public static int solve(String s){
        int res = 0;
        String[] master = {"a", "b", "c"};//"acbcca"
        int[] fre = new int[3];
        List<String> list = Arrays.stream(s.split("")).collect(Collectors.toList());
        for (int i = 0; i < 3; i++) {
            fre[i] = Collections.frequency(list, master[i]);
        }
        for (int i = 1; i < s.length(); i++) {
            if (fre[0] >= 2 * i && fre[1] >= i && fre[2] >= 3 * i){
                res++;
            }else if (s.length() >= 11 && fre[0] >= 2 * i - 1 && fre[1] >= i && fre[2] >= 3 * i)
                res++;
            else
                break;
        }
        return res;
    }
}
