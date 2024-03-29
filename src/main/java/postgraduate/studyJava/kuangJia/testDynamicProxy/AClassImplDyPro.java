package postgraduate.studyJava.kuangJia.testDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** 动态代理
 * 使用一个类实现动态代理，本包中的其他四个类是一个主体，这个类是单独的；
 */
public class AClassImplDyPro {
    interface Foo{
        void foo();
    }

    static class Target implements Foo{
        @Override
        public void foo() {
            System.out.println(" target foo");
        }
    }

    /**
     * jdk代理只能针对接口进行代理
     * 内部采用asm技术动态生成字节码（）
     * @param args
     */
    public static void main(String[] args) {

        Target target = new Target();

        ClassLoader classLoader = AClassImplDyPro.class.getClassLoader();
        Foo proxy = (Foo) Proxy.newProxyInstance(classLoader, new Class[]{Foo.class}, new InvocationHandler() {
            //proxy 代理对象自身
            //method 正在执行的方法
            //方法参数
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before");
                Object result = method.invoke(target, args);
                //代理类返回的是目标方法执行的结果
                System.out.println("after");
                return result;
            }
        });
        proxy.foo();
    }
}
