package postgraduate.studyJava.faceObject.tongMingFunc;

/**类C继承A，实现接口B，都用同名的默认方法，如果调用该方法发生什么
 *如果类C中存在同名的方法就使用C类中的方法，如果没有父类A中的方法；
 */
public class MainC2 extends ImplementA implements InterfaceB{
    public int iAmAFunc(){
        System.out.println("实现类C中运行。");
        return 2;
    }

    public static void main(String[] args) {
        MainC2 c2 = new MainC2();
        System.out.println(c2.iAmAFunc());
    }
}
