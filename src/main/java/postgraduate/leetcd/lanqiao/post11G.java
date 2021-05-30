package postgraduate.leetcd.lanqiao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**未完成
 * 2020年春节期间，有一个特殊的日期引起了大家的注意: 2020年2月2日。因为如果将这个日期按"yyymmdd"的格式写成一个8位数是20200202,
 * 恰好是-一个回文数。我们称这样的日期是回文日期。有人表示20200202是“千年一遇” 的特殊日子。对此小明很不认同，因为不到2年之后就是
 * 下一个回文日期: 20211202 即2021年12月2日。也有人表示20200202并不仅仅是一个回文日期，还是一个ABABBABA 型的回文日期。对此小明
 * 也不认同，因为大约100年后就能遇到下一个ABABBABA型的回文日期: 21211212 即2121 年12月12日。算不上“千年一遇"，顶多算“千年两遇"。
 * 给定一个8位数的日期，请你计算该日期之后下一个回文日期和下一个ABABBABA型的回文日期各是哪一天。
 * [输入格式]
 * 输入包含一个八位整数 N,表示日期。
 * [输出格式]
 * 输出两行，每行 1个八位数。第- -行表示下一个回文日期，第二行表示下
 * 一个 ABABBABA 型的回文日期。
 * [样例输入]
 *  20200202
 * [样例输出]
 *  20211202
 *  21211212
 */
public class post11G {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int fornt = Integer.parseInt(s.substring(0,4));
        int behind = Integer.parseInt(s.substring(4));
        String res1 = "", res2 = "";
        List<String> collect = Arrays.stream(s.split("")).distinct().collect(Collectors.toList());
        if (collect.size()> 3) {
            System.out.println("输入有误！");
            return;
        }
        int lin = behind;
        if (fornt > behind)
            lin = fornt;
        int flag = 1;
        while (flag > 0){
            if (lin == 10000){
                fornt++;
                lin = 0;
                // System.out.println("22");
                continue;}
            String s2 = new StringBuilder(String.valueOf(lin)).reverse().toString();
            // System.out.println(s2);
            if (s2.equals(String.valueOf(fornt))){
                res1 = String.valueOf(fornt).concat(String.valueOf(lin));
                flag--;
            }
            lin++;
        }
        res2 = String.valueOf(collect.get(0)) + String.valueOf(collect.get(1)) + String.valueOf(collect.get(0)) + String.valueOf(collect.get(1));
        res2 = res2 + new StringBuilder(res2).reverse().toString();
        String res3 = String.valueOf(collect.get(1)) + String.valueOf(collect.get(0)) + String.valueOf(collect.get(1)) + String.valueOf(collect.get(0));
        res3 = res3 + new StringBuilder(res3).reverse().toString();
        int num2 = Integer.parseInt(res2);
        int num3 = Integer.parseInt(res3);
        Integer integer = Stream.of(num2, num3).filter(x -> x >= Integer.parseInt(s)).distinct().findAny().get();
        System.out.println(res1);
        System.out.println(integer);

    }
}
