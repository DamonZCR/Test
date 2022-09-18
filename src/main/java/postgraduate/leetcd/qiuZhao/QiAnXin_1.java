package postgraduate.leetcd.qiuZhao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**奇安信-20220915
 * A城市为了促进居民消费，举办了夏季优惠购物节系列活动，商场A和商场B为此分别推出了各自的优惠购物活动
 * 1，5，6
 * 8，3，6
 * 此时可以上A商场卖１和６，然后去B商场卖３最便宜；
 * 通过率　：　０
 */
public class QiAnXin_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(",");
        String[] s2 = br.readLine().split(",");
        int len = s1.length;
        int[] num1 = new int[len];
        int[] num2 = new int[len];
        for (int i = 0; i < len; i++) {
            num1[i] = Integer.parseInt(s1[i]);
            num2[i] = Integer.parseInt(s2[i]);
        }
        int res1 = 0;
        int res2 = 0;
        if (len < 3){
            res1 = num1[0] + num1[1];
        }else {
            int res3 = 0;
            for (int i = 0; i < len; i++) {
                res3 += num1[i];
            }
            res1 = (int)(Math.floor(res3 * 0.6));
        }
        if (len <= 2){
            res2 = num1[0] + num1[1];
        }else {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                if (min > num2[i])
                    min = num2[i];
                res2 += num1[i];
            }
            res2 -= min;
        }
        System.out.println(Math.min(res1, res2));
    }
}
