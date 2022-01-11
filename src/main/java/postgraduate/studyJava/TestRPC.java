package postgraduate.studyJava;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//1、编写需要被代理的类和接口
interface DemoInterface {
    String hello(String msg);
}

class DemoImpl implements DemoInterface {
    @Override
    public String hello(String msg) {
        System.out.println("msg = " + msg);
        return "hello";
    }
}
//2、编写代理类，需要实现 InvocationHandler 接口，重写 invoke() 方法；
class DemoProxy implements InvocationHandler {

    private DemoInterface service;

    public DemoProxy(DemoInterface service) {
        this.service = service;
    }

    public Object invoke(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("调用方法前...");
        Object returnValue = method.invoke(service, args);
        System.out.println("调用方法后...");
        return returnValue;
    }
}
// 主方法
//3、使用Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
//动态创建代理类对象，通过代理类对象调用业务方法。
public class TestRPC {
    public static void main(String[] args) {
        DemoProxy proxy = new DemoProxy(new DemoImpl());
        DemoInterface service = (DemoInterface) Proxy.newProxyInstance(
                DemoInterface.class.getClassLoader(),
                new Class<?>[]{DemoInterface.class},
                proxy
        );
        System.out.println(service.hello("呀哈喽！"));
    }
}