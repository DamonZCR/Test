package postgraduate.play.net.testSocket.useTCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
// 客户端，单线程实现；
class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 10003);
        SocketAddress socketAddress = socket.getRemoteSocketAddress();

        try (
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        ){

            System.out.println("服务端 " + socketAddress + " 说 : " + reader.readLine());

            Scanner scanner = new Scanner(System.in);
            while(true) {
                System.out.println(">>>>>>>>>>");
                // 等待用户输入
                String line = scanner.nextLine();

                writer.write(line);
                // 写一个行分隔符，标识告诉流已经输出完毕
                writer.newLine();
                writer.flush();

                String response = reader.readLine();
                System.out.println("服务端 " + socketAddress + " 说 : " + response);
                System.out.println("<<<<<<<<<<<");
                if (response.equals("bye")) {
                    break;
                }
            }
        }finally {
            socket.close();
        }
    }
}

