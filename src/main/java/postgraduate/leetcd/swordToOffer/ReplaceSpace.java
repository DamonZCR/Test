package postgraduate.leetcd.swordToOffer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**剑指 Offer 05. 替换空格
 *请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class ReplaceSpace {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solve1(s));
        System.out.println(solve2(s));
        System.out.println(solve3(s));
    }
    //方法一
    private static String solve1(String s){
        return s.replace(" ", "%20");
    }
    //方法二
    private static String solve2(String s){
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < s.length();i++){
            if (s.charAt(i) != ' '){
                sb.append(s.charAt(i));
            }else
                sb.append("%20");
        }
        return sb.toString();
    }
    //方法三
    private static String solve3(String s){
        String s1 = "";
        for(int i = 0;i < s.length();i++){
            if (s.charAt(i) != ' '){
                s1 += s.charAt(i);
            }else
                s1 += "%20";
        }
        return s1;
    }
}
