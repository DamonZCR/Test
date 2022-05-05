package postgraduate.studyJava.kuangJia.testAOP;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * 定义一个日志切面类，LoggerAdvice
 */
@Aspect // 用来描述一个切面类
@Component // 将该类交给 Spring 来管理
public class AspectDemo {
    private Logger logger = (Logger) LoggerFactory.getLogger(AspectDemo.class);

    /**
     * 切点名称为：myPointcut,在返回类型不限的指定包下的所有的类，所有方法，并且参数不限；
     */
    @Pointcut(value = "execution(*com.") // 此处是切面
    public void myPointcut(){

    }

    /** 定义Advice通知，或者收拾增强
     * 注意：ProceedingJointPoint只能用于环绕通知(也就是当为@Around是，下面的这个方法的参数只能是ProceedingJointPoint)，
     * 因为ProceedingJointPoint暴露了proceed方法
     */
    @Around("myPointcut()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable{
        String methodName = pjp.getSignature().getName(); // 获取增强了哪些方法的方法名
        String className = pjp.getTarget().getClass().toString(); // 获取增强了哪些类的类名
        Object[] array = pjp.getArgs(); // 被增强的函数的参数列表
        ObjectMapper m = new ObjectMapper(); // 它的作用就是将上面的参数数据转为字符串


        logger.info("调用前：" + className + ": " + methodName + "args = " + m.writeValueAsString(array));

        Object obj = pjp.proceed();

        logger.info("调用后：" + className + ": " + methodName + "返回 = " + m.writeValueAsString(obj));

        return obj;
    }
}
