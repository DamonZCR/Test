package postgraduate.play.net.testSocket.useUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
//UDP实现服务器端
/**
 * 运行时，先启动SocketServer，再启动SocketClient，会正常打印数据。在先启动SocketServer时，
 * 代码执行到socket.receive(packet)时会一致阻塞在这里，直到启动SocketClient后，SocketServer
 * 会继续执行，并将收到SocketClient的信息打印出来。如果是先启动SocketClient，会立即执行完毕，再执行
 * SocketServer时，依旧会阻塞在receive方法处，直到下一次SocketClient的执行。
 */
public class SocketServer {
    public static void main(String[] args) {
        try {
            // 要接收的报文
            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);

            // 创建socket并指定端口
            DatagramSocket socket = new DatagramSocket(8089);

            // 接收socket客户端发送的数据。如果未收到会一致阻塞
            socket.receive(packet);
            String receiveMsg = new String(packet.getData(),0,packet.getLength());
            System.out.println(packet.getLength());
            System.out.println(receiveMsg);

            // 关闭socket
            socket.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}
