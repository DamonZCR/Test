package postgraduate.studyJava.faceObject.loadClassStudy.hotDeploy;

import university.io.BinaryFileUtils;
import java.io.IOException;

/** 实现加载类的功能.指定.class文件就返回此类对象。
 * 
 */
public class MyClassLoader extends ClassLoader{
    private static final String BASE_DIR = "D:\\IDEA\\Test\\src\\main\\java\\";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String fileName = name.replaceAll("\\.", "/");
        System.out.println("go to MyClassLoader.java ! ");
        fileName = BASE_DIR + fileName + ".class";
        try {
            byte[] bytes = BinaryFileUtils.readFileToByteArray(fileName);
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException ex) {
            throw new ClassNotFoundException("failed to load class " + name, ex);
        }
    }
}
