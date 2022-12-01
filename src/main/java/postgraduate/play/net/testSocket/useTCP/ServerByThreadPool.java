package postgraduate.play.net.testSocket.useTCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//服务器端，使用线程池实现
public class ServerByThreadPool {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10003);
        System.out.println("ServerSocket 正在运行...");

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        while(true) {
            final Socket socket;
            final SocketAddress socketAddress;
            try {
                // 阻塞并一直等待客户端连接
                socket = serverSocket.accept();
                socketAddress = socket.getRemoteSocketAddress();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }

            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try (
                            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
                            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                    ){
                        // 换行符 \n 标识告诉流已经输出完毕
                        writer.write("已成功连接！\n");
                        // 发送给客户端
                        writer.flush();

                        String line = "";
                        // readLine() IO阻塞
                        while ((line = reader.readLine()) != null) {
                            System.out.println(">>>>>>>>>>");
                            System.out.println("客户端 " + socketAddress +" 说：" + line);
                            System.out.println("为客户端 " +  socketAddress +" 服务的线程：" + Thread.currentThread().getName());
                            System.out.println("<<<<<<<<<<<");

                            // 客户端发送bye，则退出并关闭socket
                            if (line.equals("bye")) {
                                writer.write("bye\n");
                                writer.flush();
                                break;
                            } else {
                                writer.write("已接收！\n");
                                writer.flush();
                            }
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            socket.close();
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                    }
                }
            });
        }

        executorService.shutdown();
        serverSocket.close();
    }
}

