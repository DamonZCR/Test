package university.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ���߳�ʵ�ֶ���ͻ���ͬʱ�ϴ��ļ�
 */
public class TCPOnServer {
    public static void main(String[] args) throws IOException {
        //����Socket����
        ServerSocket ss = new ServerSocket(23456);
         while (true){
             Socket s = ss.accept();
             new Thread(new UseThread(s)).start();
         }
    }
}
