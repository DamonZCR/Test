package postgraduate.leetcd.lanqiao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/** 求一个数的阶乘，使用int来保存结果大约只能获得10分，使用long保存结果最多能获得30分；
 * 详情见图片
 *
 * 只有使用BigInteger和BigDecimal才是最好的选择；
 * 使用Python更容易解决
 */
public class JieCheng {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = new BigInteger(sc.nextLine());

        BigInteger res = new BigInteger("1");
        BigInteger i = new BigInteger("1");
        while (i.compareTo(n) != 1){
            res = res.multiply(i);
            i = i.add(new BigInteger("1"));
        }
        System.out.println(res);
        solve();
    }
    public static void solve(){
        Scanner sc = new Scanner(System.in);
        BigDecimal n = new BigDecimal(sc.nextInt());

        BigDecimal res = new BigDecimal(1);
        BigDecimal i = new BigDecimal(1);
        while (i.compareTo(n) != 1){
            res = res.multiply(i);
            i = i.add(new BigDecimal(1));
        }
        System.out.println(res);
    }
}
