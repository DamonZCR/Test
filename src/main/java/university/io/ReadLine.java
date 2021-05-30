package university.io;

import java.io.*;

/**
 *ʹ���ַ�����Ч�Ķ����������BufferReader��BufferWriter����ʹ�ö�ȡһ��һ������Readline()
 *���ʹ��FileRead�ࡢFileWriter�಻����readLine()������
 *
 * ���У�
 *      new FileReader�ַ��ļ��������ȼ���new InputRStreamReader(new FileInputStream(""))
 *      new FileWriter�ַ��ļ��������ȼ���new OutPutStreamWriter(new FileOutputStream(""))
 */
public class ReadLine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\IDEA\\Test\\src\\usefile\\Copy.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\IDEA\\Test\\src\\usefile\\lineRead.txt"));
            String st = null;
            //readLine()����һ�ο��Զ�һ���ַ�������󷵻�null
        while ((st = br.readLine()) != null){
            bw.write(st);
            bw.newLine();//�س����У�ʹ�ô˷�����д��һ���ַ�����лس�����
            bw.flush();//ֻˢ�»����������ַ��ӻ�����д���ļ���close()ˢ�»�������ر��ļ�
        }
        //�ͷ���Դ
        br.close();
        bw.close();
    }
}
