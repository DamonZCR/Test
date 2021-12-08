package university.net;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import postgraduate.studyJava.testJSON.FastJsonTestUse.LoginResMes;
import postgraduate.studyJava.testJSON.FastJsonTestUse.Message;

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
        String res = null;
        Socket socket = new Socket("127.0.0.1", 8889);
        try {
            dis = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] du = new byte[8096];
        byte[] len = new byte[4];
        dis.read(len);
        int a = bytesToIntLowAhead(len, 0);
        System.out.println(a);

        int reaLen = dis.read(du);
        /*//输出读到的每一个字符
        for (int i = 0;i < a;i++)
            System.out.println(du[i])*/;
        if (reaLen != a){
            new IOException("数据接收错误！");
            res = "-----错误信息-----";
        }else {
            // 接收到的数据与要发送的大致匹配，可以转换。
            // String 的构造方法的一种，指定字符集。
            res = new String(du, 0, a, "UTF-8");
            System.out.println("接收的内容为：" + res);
            Message mes = JSON.parseObject(res, Message.class);
            System.out.println("接收的消息类型：" + mes.getType());
            System.out.println("接收的消息：" + mes.getData());
            // 转为LoginResMes对象。
            LoginResMes lrm = JSON.parseObject(mes.getData(), LoginResMes.class);
            System.out.println(lrm.getCode());
            System.out.println(lrm.getUserName());
            System.out.println(lrm.getError());
            int[] arr = lrm.getUsersId();//接收数组也可以。
            for (int i : arr)
                System.out.println(i);
        }
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
