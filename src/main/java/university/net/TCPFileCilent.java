package university.net;

import java.io.*;
import java.net.Socket;

/**
 * 使用TCP协议实现客户端屏幕输入服务器端输出到文本文件
 */
public class TCPFileCilent {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1",23456);

        //封装键盘输入
        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in));
        //封装通道内的数据来自服务器端的反馈
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                s.getOutputStream()));

        String line = null;
        while((line = br.readLine()) != null){
            //当输入over时，结束传输
            if ("over".equals(line)){
                break; }
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        s.close();

    }

}
