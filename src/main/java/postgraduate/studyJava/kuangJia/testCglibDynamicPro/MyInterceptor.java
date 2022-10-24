package postgraduate.studyJava.kuangJia.testCglibDynamicPro;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyInterceptor implements MethodInterceptor {
    private Object target;

    public MyInterceptor(Object target) {
        this.target = target;
    }
    /**
     * @param o 代理对象
     * @param method 被代理对象的方法
     * @param objects 方法入参
     * @param methodProxy 代理方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib before");
        // 调用代理类FastClass对象
        Object result =  methodProxy.invokeSuper(o, objects);//直接调用目标类o的方法；对目标类的所有方法增强；
        //Object result = methodProxy.invoke(target, objects);//直接调用目标类target的方法；仅对调用方法增强
        System.out.println("cglib after");
        return result;
    }

}
