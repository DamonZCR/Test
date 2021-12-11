package postgraduate.studyJava.studyStr;

import org.apache.commons.io.FileUtils;
import java.io.*;
import java.util.List;

/**
 * handleCharsetGBKToUTF8()方法实现将一个GBK 文件转为 UTF8；
 * handleCharsetUTF8ToGBK()方法实现将一个UTF8 文件转为 GBK；
 */
public class TranJavaFile {
    public static void main(String[] args) throws IOException {
        File src = new File("D://IDEA//Test//src//main//java//university//jFrame//Ready.java");
        File to = new File("D://IDEA//Test//src//main//java//university//jFrame//Ready.java");
        handleCharsetGBKToUTF8(src,to);
    }
    public static void handleCharsetGBKToUTF8(File gbkFile, File utf8File) {
        try {
            List<String> gbkLines =  FileUtils.readLines(gbkFile, "GBK");
            FileUtils.writeLines(utf8File, "UTF-8", gbkLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //utf-8 --> gbk
    public static void handleCharsetUTF8ToGBK(File utf8File, File gbkFile) {
        try {
            List<String> utf8Lines =  FileUtils.readLines(utf8File, "UTF-8");
            FileUtils.writeLines(gbkFile, "GBK", utf8Lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
