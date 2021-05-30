package university.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 键盘录入数据不断向接收端发送
 */
public class UDPSend1 {
    public static void main(String[] args) throws IOException {
        //创建发送端Socket对象
        DatagramSocket ds = new DatagramSocket();

        //封装键盘录入数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String line = null;
        //while始终运行读取控制台的屏幕输入，故当有控制台输入必须自定义退出while
        while ((line = br.readLine()) != null)
        //数据打包DatagramPacket(byte[] buf,int length,InetAddress address,int port)
        {
            //发送886时终止程序
            if("886".equals(line)){
                break;
            }
            byte[] bys = line.getBytes();
            DatagramPacket dp = new DatagramPacket(bys,bys.length,
                    InetAddress.getByName("127.0.0.1"),12345);

            //发送数据
            ds.send(dp);
        }
        //释放资源
        ds.close();
    }
}
