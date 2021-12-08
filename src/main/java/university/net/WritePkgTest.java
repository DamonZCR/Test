package university.net;

import postgraduate.studyJava.studyStr.FilterChinese;
import postgraduate.studyJava.testJSON.FastJsonTestUse.*;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 发送数据，由D:\goLangzlw\goTest\src\goCode\6_net\demo7\demo7.go进行接受测试。
 */
public class WritePkgTest {
    private FilterChinese fc = new FilterChinese();
    public static void main(String[] args) throws IOException, InterruptedException {
        DataOutputStream dos = null;
        String res = null;
        WritePkgTest wp = new WritePkgTest();
        /*消息格式不支持，说明再SmsMes中直接新建User对象是不合适的。
        // 将Java对象转为Json格式 2
        String s1 = JSON.toJSONString(new SmsMes("-消息内容-", new User(1, "1", "Damon", 1,"11")));
        String s = JSON.toJSONString(new Message("SmsMes", s1));
        System.out.println("客户端发送的消息内容格式为：\n" + s);*/

        /*消息格式支持,服务器可转换为LoginMesType结构体。
        // 将Java对象转为Json格式 2
        String s1 = JSON.toJSONString(new LoginMes(1, "1", "Damon"));
        String s = JSON.toJSONString(new Message("LoginMes", s1));
        System.out.println("客户端发送的消息内容格式为：\n" + s);*/

        //使用封装的方法，复合go服务器的反序列结构。成功。
        MessageUtils utils = new MessageUtils();
        //String s = utils.SmsMess("aA测试信息！", 123);
        String s = utils.RegisMess(11, "fff", "fff", 1, "ff");
        System.out.println("发送的内容为：" + s);


        Socket socket = new Socket("127.0.0.1", 8889);
        try {
            dos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        wp.WritePkg(s, dos);
    }


    public void WritePkg(String mess, DataOutputStream dos) throws InterruptedException {

        try {// 1、首先发送消息的长度
            // 信息过滤（筛选中文汉字和中文字符个数）：fc.chineCharNum(mess)
            dos.write(mess.length() + 2 * fc.chineCharNum(mess));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //需要给服务器端200毫秒的延迟，要不然会报错。
        Thread.sleep(200);

        try {// 2、再发送消息本身
            dos.write(mess.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
