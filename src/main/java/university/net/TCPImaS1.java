package university.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 使用TCP协议向服务器上传图片，并给出客户端反馈
 *
 */
public class TCPImaS1 {
    public static void main(String[] args) throws IOException {
        //创建ServerSocket对象
        ServerSocket ss = new ServerSocket(23456);

        //创建Socket时时监听客户端连接
        Socket s = ss.accept();

        //封装通道数据流
        BufferedInputStream bi = new BufferedInputStream(s.getInputStream());
        //将数据写入文件
        BufferedOutputStream bo = new BufferedOutputStream(
                new FileOutputStream("D:\\IDEA\\Test\\src\\usefile\\z09Copy.png"));

        //写数据
        byte[] b = new byte[1024];
        int len = 0;
        while((len = bi.read(b)) != -1){
            bo.write(b,0,len);
            bo.flush();
        }
        //给客户端反馈
        OutputStream os = s.getOutputStream();
        os.write("数据传输完成".getBytes());

        //释放资源
        s.close();
        bo.close();


    }
}
