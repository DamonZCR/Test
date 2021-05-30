package postgraduate.studyJava;

import java.math.BigDecimal;
import java.text.DecimalFormat;
// 格式化输出。


public class formatNum {
    public static void main(String[] args) {
        // Java 中 除 /  取余 %
        // float 会输出小数点后 6~7位。 double 输出后 15 位。
        System.out.print("Java中 / 是除，但是两个整数直接除会得向下取整，需使用(double)int/int的形式：" + (double) 10/3);
        System.out.println("    如果不加强转，将是一个整数：" + 10/3);


        //方法一
        // DecimalFormat 格式化输出规定位数。
        //若是这种写法DecimalFormat df = new DecimalFormat("0.00000")，不管传入的任何值，均保留 指定位 小数
        DecimalFormat df = new DecimalFormat("0.00000");
        String res = df.format((float) 10/3);
        System.out.println("方法一：使用DecimalFormat输出  " + res);

        // 方法二
        // 使用这种写法若小数点后均为零，则保留一位小数，并且有四舍五入的规则。
        // 若double d=0，输出结果为0.0；若double d=1.999，输出结果为2.0；若double d=1.89，输出结果为1.89；
        BigDecimal bd = new BigDecimal((double) 10/3);
        double d1 = bd.setScale(5,BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("方法二：使用BigDecimal输出  " + d1);

        //方法三
        // 使用 C 语言的输出方式，调用System.out.printf("%.6f\n", (float)10/3);
        // 将println 换为 printf，使用 %.数字f或者 %.数字d 来输出，双引号好以 逗号 ,隔开。
        System.out.printf("方法三：使用C 语言的输出格式规范  %.4f\n", (float)10/3);

        //方法四
        // 使用String 的format函数进行规范String.format("%.2f", data))
        System.out.println(String.format("方法四：使用String.format方法  %.4f", (float)10/3));

        // 拓展
        // 保留小数点后面不为0的两位小数，这种写法不能保证保留一定是保留两位小数，但能保证最后一位数不为0；
        //若double d=2.00，输出结果为2；若double d=41.001，输出结果为41；
        //若double d=41.010，输出结果为41.01；若double d=0，输出结果为0；若double d=0.200，输出结果为0.2
        DecimalFormat ff = new DecimalFormat("#.##");
        System.out.println("规范化取值：" + ff.format((float)10/3));

        // 拓展
        // System.out.println(2.0-1.1);输出不为： 0.9.输出为：0.8999999999
        // Java 中二进制不能准确表示 1/10.就像十进制中不能表示小数 1/3一样。
        System.out.print("2.0-1.1 的结果输出是0.9嘛？");
        System.out.println(2.0-1.1);
    }
}
