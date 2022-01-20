package postgraduate.studyJava.faceObject.loadClassStudy.peiZhi;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 很多应用使用面向接口的编程，接口具体的实现类可能有很多，适用于不同的场合，具体使用哪个实现类在配置
 * 文件中配置，通过更改配置，不用改变代码，就可以改变程序的行为，在设计模式中，这是一种策略模式。
 *
 * 客户端通过该接口访问其方法，怎么获得IService实例呢?查看配置文件config.properties，根据配置的实现类，自己
 * 加载，使用反射创建实例对象，示例代码为:
 */
public class ConfigurableStrategyDemo {
    public static IService createService() {
        try {
            Properties prop = new Properties();
            String fileName = "D:\\IDEA\\Test\\src\\main\\java\\postgraduate\\studyJava\\faceObject\\loadClassStudy\\peiZhi\\config.properties";
            prop.load(new FileInputStream(fileName));
            String className = prop.getProperty("service");
            Class<?> cls = Class.forName(className);
            return (IService) cls.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        IService service = createService();
        service.action();
    }
}
