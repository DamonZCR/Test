package postgraduate.testFinal;

public class finalVariable3 {
    public static void main(String[] args) {
        int i = 0;
        StringBuffer buffer = new StringBuffer("Hello");

        changeValue(buffer);
        System.out.println(buffer);//  Hello
    }

    private static void changeValue(StringBuffer buffer) {
        //注意上面括号里的形参并没有用到，显示灰色。
        buffer  = new StringBuffer("Hi");
        buffer.append(" World!");
        System.out.println(buffer);//  Hi World!
    }
}
