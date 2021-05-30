package university.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 使用TCP协议实现客户端屏幕输入服务器端输出到文本文件
 *
 */
public class TCPFileServer {
    public static void main(String[] args) throws IOException {
        //创建服务器Socket对象
        ServerSocket ss = new ServerSocket(23456);

        //监听客户端的连接
        Socket s = ss.accept();

        //封装通道内的数据
        BufferedReader br = new BufferedReader(new InputStreamReader(
                s.getInputStream()));
        //封装文本文件
        BufferedWriter bw = new BufferedWriter(new FileWriter(
                "D:\\IDEA\\Test\\src\\usefile\\aa.txt"));
        String line = null;
        while ((line = br.readLine()) != null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        s.close();


    }
}
