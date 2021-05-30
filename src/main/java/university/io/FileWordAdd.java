package university.io;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 *文件文本的追加、换行
 * FileOutputStream的另一种构造方法实现文本追加
 */
public class FileWordAdd {
    public static void main(String[] args) throws IOException {
        //第一种构造方法写入部分数据

        FileOutputStream fin = new FileOutputStream("src/main/resources/Copy2.txt");
        for (int i = 0;i < 10;i++){
            fin.write("hello".getBytes());

            //windows系统里规定的换行符为\r\n
            fin.write("\r\n".getBytes());
        }
        //释放资源
        fin.close();
        //第二种构造方法参数true确定添加文本
        FileOutputStream fin2 = new FileOutputStream("src/main/resources/Copy2.txt",true);
        for (int i = 0;i < 10;i++){
            //.getBytes()是字符串转换成字节
            fin2.write("hi".getBytes());
            //windows系统里规定的换行符为\r\n
            fin2.write("\r\n".getBytes());
        }
        //释放资源
        fin2.close();
    }
}
