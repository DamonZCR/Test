package university.io;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 *�ļ��ı���׷�ӡ�����
 * FileOutputStream����һ�ֹ��췽��ʵ���ı�׷��
 */
public class FileWordAdd {
    public static void main(String[] args) throws IOException {
        //��һ�ֹ��췽��д�벿������

        FileOutputStream fin = new FileOutputStream("src/main/resources/Copy2.txt");
        for (int i = 0;i < 10;i++){
            fin.write("hello".getBytes());

            //windowsϵͳ��涨�Ļ��з�Ϊ\r\n
            fin.write("\r\n".getBytes());
        }
        //�ͷ���Դ
        fin.close();
        //�ڶ��ֹ��췽������trueȷ������ı�
        FileOutputStream fin2 = new FileOutputStream("src/main/resources/Copy2.txt",true);
        for (int i = 0;i < 10;i++){
            //.getBytes()���ַ���ת�����ֽ�
            fin2.write("hi".getBytes());
            //windowsϵͳ��涨�Ļ��з�Ϊ\r\n
            fin2.write("\r\n".getBytes());
        }
        //�ͷ���Դ
        fin2.close();
    }
}
