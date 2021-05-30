package postgraduate.testFinal;
/*
*使用final定义形参后，形参在方法中不可被改变，但是在原实参体中仍可改变。
* 主要是对于基本类型，Java实现的是值传递，只是把值传给了形参。
* 看finalVariable2.java 看到传递不是基本类型可以被更改但不能被重定义。
 */
public class finalVariable {
    public static void main(String[] args) {
        int i = 0;
        changeValue(i);
        i++;
        System.out.println(i);// 1
    }

    private static void changeValue(final int i) {
        //i++;  final定义的参数不可被改变。
        System.out.println(i);// 0
    }
}
