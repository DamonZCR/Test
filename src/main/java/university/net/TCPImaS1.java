package university.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ʹ��TCPЭ����������ϴ�ͼƬ���������ͻ��˷���
 *
 */
public class TCPImaS1 {
    public static void main(String[] args) throws IOException {
        //����ServerSocket����
        ServerSocket ss = new ServerSocket(23456);

        //����Socketʱʱ�����ͻ�������
        Socket s = ss.accept();

        //��װͨ��������
        BufferedInputStream bi = new BufferedInputStream(s.getInputStream());
        //������д���ļ�
        BufferedOutputStream bo = new BufferedOutputStream(
                new FileOutputStream("D:\\IDEA\\Test\\src\\usefile\\z09Copy.png"));

        //д����
        byte[] b = new byte[1024];
        int len = 0;
        while((len = bi.read(b)) != -1){
            bo.write(b,0,len);
            bo.flush();
        }
        //���ͻ��˷���
        OutputStream os = s.getOutputStream();
        os.write("���ݴ������".getBytes());

        //�ͷ���Դ
        s.close();
        bo.close();


    }
}
