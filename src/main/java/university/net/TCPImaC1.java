package university.net;

import java.io.*;
import java.net.Socket;

/**
 *使用TCP协议向服务器上传图片，并给出客户端反馈
 *
 */
public class TCPImaC1 {
    public static void main(String[] args) throws IOException {
         //创建Socket对象
        Socket s = new Socket("127.0.0.1",23456);

        //封装发送的数据通道
        BufferedOutputStream bo = new BufferedOutputStream(s.getOutputStream());

        //读取需要发送的图片文件
        BufferedInputStream bi = new BufferedInputStream(
                new FileInputStream("D:\\IDEA\\Test\\src\\usefile\\z09.png"));

        byte[] b = new byte[1024];
        int len = 0;
        while ((len = bi.read(b)) != -1){
            bo.write(b,0,len);
            bo.flush();
        }
        //通知客户端数据传输完成
        s.shutdownOutput();

        //接收反馈
        InputStream is = s.getInputStream();
        byte[] nb = new byte[1024];
        int leng = 0;
        leng = is.read(nb);
        //转换成字符串
        String tip = new String(nb,0,leng);
        System.out.println(tip);

        //释放资源
        s.close();
        bi.close();
    }
}
