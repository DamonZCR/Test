package postgraduate.studyJava.faceObject.tongMingFunc;
/**类C实现接口A，B，两个接口有同名的默认方法，如果调用该方法发生什么
 * 答：从下面答案可以得到，会正常调用实现类C的方法，正常运行；
 */

public class MainC1 implements InterfaceA, InterfaceB{
    @Override
    public int iAmAFunc() {
        System.out.println("主方法C类，实现两个接口同名的方法！");
        return 0;
    }

    public static void main(String[] args) {
        MainC1 c = new MainC1();
        System.out.println(c.iAmAFunc());
    }
}
