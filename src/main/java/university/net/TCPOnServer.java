package university.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 多线程实现多个客户端同时上传文件
 */
public class TCPOnServer {
    public static void main(String[] args) throws IOException {
        //创建Socket对象
        ServerSocket ss = new ServerSocket(23456);
         while (true){
             Socket s = ss.accept();
             new Thread(new UseThread(s)).start();
         }
    }
}
