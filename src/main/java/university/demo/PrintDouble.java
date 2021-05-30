package university.demo;

import java.text.DecimalFormat;

/**
 * Created by Damon on 2019/3/15.
 */
public class PrintDouble {
    public static void main(String[] args) {
        double a = 4.22222;
        float b = 4.33f;

        //方法一格式化输出
        DecimalFormat fd = new DecimalFormat("#0.00");
        System.out.println(fd.format(a));

        //方法二格式化输出
        System.out.println(String.format("%.2f",a));
    }

}
