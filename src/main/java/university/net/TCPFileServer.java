package university.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ʹ��TCPЭ��ʵ�ֿͻ�����Ļ�����������������ı��ļ�
 *
 */
public class TCPFileServer {
    public static void main(String[] args) throws IOException {
        //����������Socket����
        ServerSocket ss = new ServerSocket(23456);

        //�����ͻ��˵�����
        Socket s = ss.accept();

        //��װͨ���ڵ�����
        BufferedReader br = new BufferedReader(new InputStreamReader(
                s.getInputStream()));
        //��װ�ı��ļ�
        BufferedWriter bw = new BufferedWriter(new FileWriter(
                "D:\\IDEA\\Test\\src\\usefile\\aa.txt"));
        String line = null;
        while ((line = br.readLine()) != null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        s.close();


    }
}
