package university.net;

import java.io.*;
import java.net.Socket;

/**
 * 多线程实现多个客户端同时上传文件
 */
public class TCPOnCilent {
    public static void main(String[] args) throws IOException {
        // 创建客户端Socket对象
        Socket s = new Socket("127.0.0.1", 23456);


        BufferedReader br = new BufferedReader(new FileReader(
                "D:\\IDEA\\Test\\src\\usefile\\Test.java"));
        // 封装通道内流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                s.getOutputStream()));

        String line = null;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        // Socket提供了一个终止，它会通知服务器你别等了，我没有数据过来了
        s.shutdownOutput();

        // 接收反馈
        BufferedReader brClient = new BufferedReader(new InputStreamReader(
                s.getInputStream()));
        String client = brClient.readLine();
        System.out.println(client);

        // 释放资源
        br.close();
        s.close();
    }
}
