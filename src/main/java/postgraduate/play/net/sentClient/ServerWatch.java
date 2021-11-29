package postgraduate.play.net.sentClient;
import java.io.*;
import java.net.*;
import java.util.HashMap;

public class ServerWatch {
/**
 * 主函数,实现服务器向指定客户端发送消息的功能.
 * 客户端用python书写
 * @author dingding
 *
 */
    private final static int PORT = 30000;
    public static HashMap<String, Socket> socketList = new HashMap<>();
    public static String channelToken;  //socket 令牌
    private static BufferedReader bufferedReader;

    public static void main(String[] args) {
        try {
            ServerSocket server =  new ServerSocket(PORT);
            System.out.println("server is listenning...");
            while(true){//不断循环随时等待新的客户端接入服务器
                Socket clientSocket = server.accept();
                bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                channelToken = bufferedReader.readLine();
                socketList.put(channelToken,clientSocket);   //保存会话ID和socket
                //System.out.println(socketList.get(channelToken));
                //System.out.println(socketList);
                new ServerThread(clientSocket,socketList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}