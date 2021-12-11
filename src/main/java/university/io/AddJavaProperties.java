package university.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 属性文件(.properties)是Java程序中的常用文本存储方式，象STRUTS框架就是利用属性文件存储程序中的字符串资源。
 *利用java.io.Properties的load方法读入属性文件虽然方便，但如果属性文件中有中文，在读入之后就会发现出现乱码
 * 现象。发生这个原因是load方法使用字节流读入文本，在读入后需要将字节流编码成为字符串，而它使用的编码是
 * “iso-8859-1”,这个字符集是ASCII码字符集，不支持中文编码，所以这时需要使用显式的转码:
 * new String(value.getBytes("iso-8859-1"),"目标编码集");
 */
public class AddJavaProperties {
    public static void main(String[] args) throws IOException {
        AddJavaProperties aj = new AddJavaProperties();
        System.out.println(aj.LoadProperties());
    }


    public String LoadProperties() throws IOException {
        //读入属性文件的一般方法是：
        FileInputStream ios = new FileInputStream("D:\\IDEA\\Test\\src\\main\\java\\university\\io\\prop.properties");
        Properties prop = new Properties();
        prop.load(ios);
        ios.close();

        String value = prop.getProperty("属性名");
        System.out.println("value:" + value);
        //getBytes()中写入原资源文件的字符集格式。String第二个参数写入转为的字符集格式。如果同为UTF8，可以直接返回value
        String encValue = new String(value.getBytes("UTF8"),"iso-8859-1");
        return encValue;
    }

}