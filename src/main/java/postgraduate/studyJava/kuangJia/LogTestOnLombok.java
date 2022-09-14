package postgraduate.studyJava.kuangJia;

import lombok.extern.slf4j.Slf4j;
//测试使用Lombok插件和依赖的注解@Slf4j进行日志输出
//
@Slf4j
public class LogTestOnLombok {
    public static void main(String[] args) {
        log.trace("This is a trace msg");
        log.debug("This is a debug msg");
        log.info("This is a info msg");
        log.warn("This is a warn msg");
        log.error("This is a error msg");

        System.out.println("占位符：");
        log.info("Message:{}","日志 测试 !");
    }
}
