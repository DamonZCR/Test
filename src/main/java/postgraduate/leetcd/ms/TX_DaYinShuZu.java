package postgraduate.leetcd.ms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/** 20220424-腾讯-第一题
 * 牛牛有n个长度相等由数字组成的字符串，牛牛将他们一行一行排列在一起。牛牛喜欢从上到下读数，
 * 可以将这n个字符串读出了一些数字字符串。牛牛想把这些数字字符串记录下来，并将它们排序。希望
 * 你能帮牛牛将从小到大排序后的数字字符串输出出来，输出的这个数字字符串要去掉前导0。
 * 输入描述:
 * 第一行为n，表示有n个字符串。
 * 接下来有n行，每行有一个字符串str.
 * 1<=n<=9,  1<=str.length<=10^5
 * 输出描述:
 * 输出为一行，表示排序后的数字，每个数字以空格隔开。
 * 示例1输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * 3
 * 0123
 * 1234
 * 2345
 * 输出
 * 12 123 234 345
 * 说明
 * 每一列从上往下读得到的数字为012,123,234,345，去掉前导0之后排序后结果如上。
 * 示例2
 * 输入
 * 4
 * 0000
 * 0101
 * 1011
 * 0111
 * 输出
 * 10 11 101 111
 */
public class TX_DaYinShuZu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(n);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            String[] split = str.split("");
            list.add(new ArrayList<Integer>());
            for (int j = 0; j < str.length(); j++) {
                list.get(i).add(Integer.parseInt(split[j]));
            }
        }
        int len = list.get(0).size();
        for (int i = 0; i < len; i++) {
            String s = "";
            for (int j = 0; j < n; j++) {
                s = s + list.get(j).get(i);
            }
           res.add(Integer.parseInt(s));
        }
        Collections.sort(res);
        for (int i = 0; i < len; i++) {
            System.out.print(res.get(i)+" ");
        }
    }
}
