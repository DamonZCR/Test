package postgraduate.leetcd.qiuZhao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**爱数科技-20220913
 * 输出一个字符串中最长的连续子字符串的长度
 * 如：abijkabcdefgiophuioguioaabbccdd输出7;
 */

public class AiShu_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s.length() == 0){
            System.out.println(0);
            return;
        }
        int len = s.length();
        int sum = 1;
        int res = 1;
        for (int i = 0; i < len; i++) {
            char lin = s.charAt(i);
            sum = 1;
            for (int j = i + 1; j < len; j++) {
                if (lin + 1 == s.charAt(j)){
                    sum++;
                    lin = s.charAt(j);
                } else
                    break;
            }
            res = Math.max(res, sum);
        }
        System.out.println(res);
    }
}
