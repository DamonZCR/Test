package university.acm;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.Scanner;

/**
 * Created by Damon on 2019/3/15.
 * 排列组合计算
 */
public class Number {
    public static void main(String[] args) {
        Scanner innum = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#0.00");
        double a = innum.nextInt();
        double b = innum.nextInt();
        System.out.println(amount(a,b));
    }
    public static double amount(double a,double b) {
        double da=1;
        double xiao=1;
        for(int i=0;i<b;i++) {
            da=da*a;
            a--;
        }
        for(;b>0;b--) {
            xiao=xiao*b;
        }
        return da/xiao;
    }

}
