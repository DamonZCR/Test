package university.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
/**
 * 网络编程测试一
 * 与 UDPSend类对应
 * UDP协议接收数据：
 *           A：创建接收端Socket对象
 *           B：创建一个数据包（接收容器）
 *           C：调用Socket对象的接收方法接收数据
 *           D：解析数据包，并显示在控制台
 *           E：释放资源
 */
public class UDPReceive {
    public static void main(String[] args) throws IOException {
        //创建接收端Socket对象
        //DatagramSocket(int port)只负责接收，只需接收数据程序的端口号
        DatagramSocket ds = new DatagramSocket(12345);

        //创建一个数据包(接收容器)
        //DatagramSocket(byte[] buf,int length)
        byte[] bys = new byte[1024];
        //int length = bys.length;
        DatagramPacket dp = new DatagramPacket(bys,bys.length);

        //调用Socket对象的接受方法接收数据
        //public void receive(DatagramPacket p),阻塞式
        ds.receive(dp);

        //解析数据包，并显示在控制台
        //获取对方的IP
        /*
        InetAddress address = dp.getAddress();
        String ip = address.getHostAddress();
        */
        //使用链式编程
        String ip = dp.getAddress().getHostAddress();


        //public byte[] getData():获取数据缓冲区
        //public int getLength():获取数据的实际长度
        /*
        byte[] bys2 = dp.getData();
        int len = dp.getLength();
        String s  = new String(bys,0,len);
        */
        //链式编程
        String s = new String(dp.getData(),0,dp.getLength());

        System.out.println(ip+"发来的数据解析后为："+s);

        //释放资源
        ds.close();

    }
}
