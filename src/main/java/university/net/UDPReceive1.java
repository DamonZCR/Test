package university.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 持续接受发送端键盘输入数据
 */
public class UDPReceive1 {
    public static void main(String[] args) throws IOException {
        //创建接收端Socket对象
        DatagramSocket ds = new DatagramSocket(12345);
        System.out.println("已于UDPSend1建立连接，接收数据如下");
        //创建一个数据包(接收容器)
        while (true) {
            byte[] bys = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bys,bys.length);
            ds.receive(dp);
            //解析数据包，并显示在控制台
            //获取对方的IP
            String ip = dp.getAddress().getHostAddress();
            String s = new String(dp.getData(), 0, dp.getLength());
            System.out.println(ip + "发来的数据解析后为：" + s);
        }
        //释放资源
        //ds.close();

    }
}
