package postgraduate.testFinal;
/*
*final定义的变量和普通变量的区别。
*由于变量b被final修饰，因此会被当做编译器常量，所以在使用到 b的地方会直接将变量b 替换为它的值。
* 而对于变量d的访问却需要在运行时通过链接来进行。（暂时理解为a 和 e 比较时e还是带着c 的地址的）
 */
public class VariableTest {
    public static void main(String[] args) {
        String a = "hello2";
        final String b = "hello";
        String c = "hello";

        String d = b + 2;
        String e = c + 2;
        System.out.println(a == d);//true
        System.out.println(e);//hello2
        System.out.println(a == e);//false
    }
}
