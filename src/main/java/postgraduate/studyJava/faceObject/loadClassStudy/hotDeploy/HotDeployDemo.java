package postgraduate.studyJava.faceObject.loadClassStudy.hotDeploy;

import java.io.File;

public class HotDeployDemo {
    private static final String CLASS_NAME = "postgraduate.studyJava.faceObject.loadClassStudy.hotDeploy.HelloImpl";
    private static final String FILE_NAME = CLASS_NAME.replaceAll("\\.", "/") + ".class";
    private static volatile IHelloService helloService;

    public static IHelloService getHelloService() {
        if (helloService != null) {
            return helloService;
        }
        synchronized (HotDeployDemo.class) {
            if (helloService == null) {
                helloService = createHelloService();
            }
            return helloService;
        }
    }

    private static IHelloService createHelloService() {
        try {
            MyClassLoader cl = new MyClassLoader();
            Class<?> cls = cl.findClass(CLASS_NAME);
            if (cls != null) {
                return (IHelloService) cls.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void client() {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        IHelloService helloService = getHelloService();
                        helloService.sayHello();
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        t.start();
    }

    public static void monitor() {
        Thread t = new Thread() {
            private long lastModified = new File("D:\\IDEA\\Test\\src\\main\\java\\postgraduate\\studyJava\\faceObject\\loadClassStudy\\hotDeploy\\HelloImpl.class").lastModified();

            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(100);
                        long now = new File("D:\\IDEA\\Test\\src\\main\\java\\postgraduate\\studyJava\\faceObject\\loadClassStudy\\hotDeploy\\HelloImpl.class").lastModified();
                        if (now != lastModified) {
                            System.out.println("---Chage---");
                            lastModified = now;
                            reloadHelloService();
                        }
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        t.start();
    }

    public static void reloadHelloService() {
        System.out.println("reloadHelloService方法执行！");
        helloService = createHelloService();
    }

    public static void main(String[] args) {
        monitor();
        client();
    }
}
