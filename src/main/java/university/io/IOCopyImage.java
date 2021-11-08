package university.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 *使用read（byte[])、write(byte[])数组为单位的方法，复制一张图片
 * 此方法可以复制多种文件
 * read(byte[])方法：
 *      从此输入流中将最多 b.length 个字节的数据读入一个 byte 数组中。在某些输入可用之前，此方法将阻塞。
 *      返回：读入缓冲区的字节总数，如果因为已经到达文件末尾而没有更多的数据，则返回 -1
 */

public class IOCopyImage {
    public static void main(String[] args) throws IOException {

        //封装需要被复制的文件
        FileInputStream fin = new FileInputStream("D:\\IDEA\\Test\\src\\usefile\\z09.png");
        //自动生成复制好的文件
        FileOutputStream fout = new FileOutputStream("D:\\IDEA\\Test\\src\\usefile\\z092.png");

        //创建一个数组大小为1024，每次读取数据文件1024字节，
        byte b[] = new byte[2048];
        int len = 0;

        //read(byte[])每次将从文件中读取到的字节总数赋值给len
        //当最后读取到的数据字节数少于1024时，程序将会剩余多少读多少，并在下面的write(b,0,len)中只输出到属于的len处。
        //进行完上面这一步后，程序再次读取将返回len=-1,终止程序
        while((len = fin.read(b)) != -1){
        //写入数组b中，只从字节0到字节len
            fout.write(b,0,len);
        };
        //释放资源
        fin.close();
        fout.close();

    }
}