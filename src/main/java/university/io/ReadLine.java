package university.io;

import java.io.*;

/**
 *使用字符流高效的读入输出数据BufferReader、BufferWriter，并使用读取一次一行数据Readline()
 *如果使用FileRead类、FileWriter类不带有readLine()方法等
 *
 * 其中：
 *      new FileReader字符文件输入流等价于new InputRStreamReader(new FileInputStream(""))
 *      new FileWriter字符文件输入流等价于new OutPutStreamWriter(new FileOutputStream(""))
 */
public class ReadLine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\IDEA\\Test\\src\\usefile\\Copy.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\IDEA\\Test\\src\\usefile\\lineRead.txt"));
            String st = null;
            //readLine()方法一次可以读一行字符，读完后返回null
        while ((st = br.readLine()) != null){
            bw.write(st);
            bw.newLine();//回车换行，使用此方法在写入一行字符后进行回车换行
            bw.flush();//只刷新缓冲区，是字符从缓冲区写入文件。close()刷新缓冲区后关闭文件
        }
        //释放资源
        br.close();
        bw.close();
    }
}
