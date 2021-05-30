package postgraduate.testFinal;
/*
 *final定义的变量和普通变量的区别。
 *这里使用方法来给final变量赋值，但是方法赋值只能在运行期间才能知道返回值的。
*/

public class VariableTest2 {
    public static void main(String[] args) {
        String a = "hello2";
        final String b = getHello();

        String c = b + 2;
        System.out.println(a == c);//false
    }
    public static String getHello(){
        return  "hello";
    }
}
