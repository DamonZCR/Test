package university.net;

import org.junit.Test;
import java.io.*;
import java.net.Socket;

/**
 * 测试以go语言的src/goCode/6_net/demo7/demo7.go为服务器，此为客户端进行连接，
 * go的服务器只会发送字节比特，Java需要用byte数组接收，在转为字符。这里测试的就是接收，发送的时候也是。
 * 接收的时候，先用go发送它将要发送的字节长度，Java接收长度后，根据信息长度来将字节数组转为字符串。
 * 首先这个接收长度的实现需要使用一个4字节的byte数组，需要将这个4字节数组转为一个整数。
 * 信息的byte数组需要使用String类的构造函数来转换。
 */
public class ReadPkgTest {
    @Test
    public void ReceivePkg() throws IOException {
        DataInputStream dis = null;
        DataOutputStream dos = null;
        Socket socket = new Socket("127.0.0.1", 8889);
        try {
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] du = new byte[8096];
        byte[] len = new byte[4];
        dis.read(len);
        int a = bytesToIntLowAhead(len, 0);
        System.out.println(a);

        dis.read(du);
        /*//输出读到的每一个字符
        for (int i = 0;i < a;i++)
            System.out.println(du[i])*/;

        // String 的构造方法的一种，指定字符集。
        String res = new String(du, 0, a, "UTF-8");
        System.out.println(res);
    }
    /*×将一个字节数组转换为一个整数，按照低位在后，高位在前的顺序
     * byte数组中取int数值
     */
    public static int bytesToIntLowAhead(byte[] src, int from) {
        return (src[from] & 0xFF)
                | ((src[from + 1] & 0xFF) << 8)
                | ((src[from + 2] & 0xFF) << 16)
                | ((src[from + 3] & 0xFF) << 24);
    }
}
