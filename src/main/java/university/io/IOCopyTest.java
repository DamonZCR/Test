package university.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 *复制指定目录下的文本文件
 * 使用字节输入流、字节输出流单个字节复制
 * 注意注意注意：当read()方法读取一个字节之后，再次调用read()方法将自动从下一个字节开始
 */

public class  IOCopyTest {
    public static void main(String[] args) throws IOException {

        //封装需要被复制的文件
        FileInputStream fin = new FileInputStream("D:\\IDEA\\Test\\src\\usefile\\Copy.txt");
        //自动生成复制好的文件
        FileOutputStream fout = new FileOutputStream("D:\\IDEA\\Test\\src\\usefile\\Copy2.txt");
        int sys = 0;
        while((sys = fin.read()) != -1){
            fout.write(sys);
        }

        fin.close();
        fout.close();

    }
}
