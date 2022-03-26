package postgraduate.studyJava.testJVM;

/**
 * 强引用的测试
 * str和str1都存在栈空间中，他们都指向了堆中的对象new StringBuffer ("Hello,Damon");
 * Str1强引用了new StringBuffer ("Hello,Damon");这个对象；
 * 那么虽然str被回收了，但是对象仍存在，因为str1强引用了这个对象new StringBuffer ("Hello,Damon");
 * 所以这个对象不会被回收；
 */
public class StrongReferenceTest {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer ("Hello,Damon");
        StringBuffer str1 = str;

        str = null;
        System.gc();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(str1);
    }
}
