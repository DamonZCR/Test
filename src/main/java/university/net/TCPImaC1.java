package university.net;

import java.io.*;
import java.net.Socket;

/**
 *ʹ��TCPЭ����������ϴ�ͼƬ���������ͻ��˷���
 *
 */
public class TCPImaC1 {
    public static void main(String[] args) throws IOException {
         //����Socket����
        Socket s = new Socket("127.0.0.1",23456);

        //��װ���͵�����ͨ��
        BufferedOutputStream bo = new BufferedOutputStream(s.getOutputStream());

        //��ȡ��Ҫ���͵�ͼƬ�ļ�
        BufferedInputStream bi = new BufferedInputStream(
                new FileInputStream("D:\\IDEA\\Test\\src\\usefile\\z09.png"));

        byte[] b = new byte[1024];
        int len = 0;
        while ((len = bi.read(b)) != -1){
            bo.write(b,0,len);
            bo.flush();
        }
        //֪ͨ�ͻ������ݴ������
        s.shutdownOutput();

        //���շ���
        InputStream is = s.getInputStream();
        byte[] nb = new byte[1024];
        int leng = 0;
        leng = is.read(nb);
        //ת�����ַ���
        String tip = new String(nb,0,leng);
        System.out.println(tip);

        //�ͷ���Դ
        s.close();
        bi.close();
    }
}
