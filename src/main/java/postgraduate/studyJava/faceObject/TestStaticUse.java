package postgraduate.studyJava.faceObject;

/**
 * 测试static变量修饰的，在类被加载时就已经初始化，然后有一个地方进行更改，那么在这次，
 * 更改下，它都是被更改后的值；
 */
public class TestStaticUse {
    public static void main(String[] args) {
        System.out.println(Person.a);
        Person.a = 11;
        System.out.println(Person.a);
    }
}

class Person {
    static int a = 10;
}
