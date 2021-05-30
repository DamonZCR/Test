package university.net;

import java.io.IOException;
import java.net.*;

/**
 *网络编程测试一
 * 实现基本的数据发送（在正常的网络编程中应首先实现接收端、服务端）
 * UDP协议发送数据：
 *          A：创建发送端Socket对象
 *          B:创建数据，并把数据打包
 *          C:调用Socket对象的发送方法发送数据包
 *          D：释放资源（实质是IO流）
 */
public class UDPSend {
    public static void main(String[] args) throws IOException {
        //创建发送端Socket对象
        //DatagramSocket()
        DatagramSocket ds = new DatagramSocket();

        //数据打包DatagramPacket(byte[] buf,int length,InetAddress address,int port)
        //创建数据
        byte[] bys = ("网络编程测试Net").getBytes();
    /*
        //长度
        int length = bys.length;
        //IP地址对象
        InetAddress address = InetAddress.getByName("127.0.0.1");
        //端口
        int port = 12345;
        //打包
        DatagramPacket dp = new DatagramPacket(bys,length,address,port);
    */
        //使用优化的代码
        DatagramPacket dp = new DatagramPacket(bys,bys.length,
                InetAddress.getByName("127.0.0.1"),12345);

        //调用Socket对象的发送方法发送数据包
        //public void send(DatagramPacket p)故在上述中使用Datagrampacket类
        ds.send(dp);
        //释放资源
        ds.close();
    }
}
