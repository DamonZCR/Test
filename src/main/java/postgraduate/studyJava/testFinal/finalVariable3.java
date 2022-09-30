package postgraduate.studyJava.testFinal;
/**
 * 	这里不应该是引用传递，然后对buffer进行了更改吗？为什么不是输出Hello Hi World呢？
 * 因为在buffer  = new StringBuffer("Hi");中就是将buffer指向了一个新的对象，
 * 所以引用穿给形参buffer的地址并没有被用到，拼接的Hi 和 Word，都是在新对象上操作的；
 */
public class finalVariable3 {
    public static void main(String[] args) {
        int i = 0;
        StringBuffer buffer = new StringBuffer("Hello");

        changeValue(buffer);
        System.out.println(buffer);//  Hello
    }

    private static void changeValue(StringBuffer buffer) {
        //注意上面括号里的形参并没有用到，显示灰色。
        buffer  = new StringBuffer("Hi");//此处就是将buffer指向了一个新的对象；
        buffer.append(" World!");
        System.out.println(buffer);//  Hi World!
    }
}
