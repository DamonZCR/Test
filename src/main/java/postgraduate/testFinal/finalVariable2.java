package postgraduate.testFinal;
/*
*用final进行修饰虽不能再让buffer指向其他对象，但对于buffer指向的对象的内容是可以改变的
 */
public class finalVariable2 {
    public static void main(String[] args) {
        int i = 0;
        StringBuffer buffer = new StringBuffer("Hello");

        changeValue(buffer);
        System.out.println(buffer);//输出 Hello World！
    }

    private static void changeValue(final StringBuffer buffer) {
        //buffer已经由final修饰，不能再让其指向其他对象，但是对它的内容是可以更改的。只是更改内容不可重新赋值。
        //这与final定义的变量已经固定是常量有一点类似，就是final定义只能更改内容。
        //buffer  = new StringBuffer("Hi");

        buffer.append(" World!");

    }

}
