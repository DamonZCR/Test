package postgraduate.leetcd.qiuZhao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 美的-20220923
 * 输入三个数据为一行，第一个是含有字母和数字的，第二个是一个整数，第三个是一个小数；
 * 第一个中的数字加上后两个数据的和为多少？
 * 如：ab1k3y,2,2.2
 * 结果就是17.2
 */
public class MeiDi_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(",");
        StringBuilder num1 = new StringBuilder();
        for (int i = 0; i < s[0].length(); i++) {
            if (Character.isDigit(s[0].charAt(i))){
                num1.append(s[0].charAt(i));
            }
        }
        double res = Integer.parseInt(num1.toString()) + Integer.parseInt(s[1]) + Double.parseDouble(s[2]);
        System.out.println(res);

    }
}
