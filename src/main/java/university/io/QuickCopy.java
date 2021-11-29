package university.io;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

/**
 * 快速复制IO类，apache提供的包中，在实际开发中常用。
 */
public class QuickCopy {
    public static void main(String[] args){
        File image = new File("D:\\IDEA\\Test\\src\\main\\java\\usefile\\Copy.txt");
        File imageCopy = new File("D:\\IDEA\\Test\\src\\main\\java\\usefile\\mnCopy.txt");

        try {
            FileUtils.copyFile(image, imageCopy);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("完成！");
    }
}
