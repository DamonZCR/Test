package postgraduate.encry;
//测试运算符
/*
* << 带符号左移 >>带符号右移,左边空出的位以0填充 >>> 无符号右移,注意Java中无<<<这个符号
* 移位操作符可以和＝合并起来，即 <<= 、 >>= 和 >>>=。例如 a >>= 2; 表示将a右移两位后的值重新赋给
*  >>右移操作
*x>>y
*就是x除以2的y此方,取整数
*<<左移操作
*X<<y
*就是x乘以2的y次方
 */
public class TestOperation {

    public static void main(String[] args) {
        System.out.println(2>>1);
        System.out.println(2<<2);
        int a = 4;
        System.out.println(a>>=1);

        byte b;
        char c;
        short d;
        b = 127;
        c = 127;
        d = 127;
        b <<=2;
        System.out.println("b <<=2的结果为"+b);
        System.out.println(c <<=2);
        System.out.println(d <<=2);
    }
}
