package postgraduate.play.net.sentClient;

import java.io.*;
import java.net.*;
import java.util.*;


public class ServerThread extends Thread{
    private Socket client;
    private PrintWriter out;
    private  HashMap<String, Socket> clientList = new HashMap<>();

    public ServerThread(Socket socket,HashMap<String, Socket> socketList) throws IOException{
        super();
        client = socket;
        clientList = socketList;

        start();
    }

    @Override
    public void run(){
        Socket socket;
        // getName()是获取的线程原始名称！
        System.out.println("Client: "+getName()+" come in...");
        System.out.println("-------------");

        //每当客户端连接上,就向相应的客户端进行回应
        Iterator<HashMap.Entry<String, Socket>> entries = clientList.entrySet().iterator();
        // 每有一个新的客户端进入就会遍历客户端列表，并向每一个客户端发送他们的ID。
        while (entries.hasNext()){
            HashMap.Entry<String, Socket> entry = entries.next();
            System.out.println("The key:" + entry.getKey());
            if (!String.valueOf(entry.getKey()).equals("")) {
                System.out.println("The value:" + entry.getValue());
                System.out.println("-------------");
                socket = entry.getValue();
                if (socket!=null) {
                    try {
                        out = new PrintWriter(socket.getOutputStream());  //回复client的ID
                        out.println("#testMessage# " + entry.getKey());
                        out.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

