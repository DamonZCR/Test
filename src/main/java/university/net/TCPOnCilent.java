package university.net;

import java.io.*;
import java.net.Socket;

/**
 * ���߳�ʵ�ֶ���ͻ���ͬʱ�ϴ��ļ�
 */
public class TCPOnCilent {
    public static void main(String[] args) throws IOException {
        // �����ͻ���Socket����
        Socket s = new Socket("127.0.0.1", 23456);


        BufferedReader br = new BufferedReader(new FileReader(
                "D:\\IDEA\\Test\\src\\usefile\\Test.java"));
        // ��װͨ������
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                s.getOutputStream()));

        String line = null;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        // Socket�ṩ��һ����ֹ������֪ͨ�����������ˣ���û�����ݹ�����
        s.shutdownOutput();

        // ���շ���
        BufferedReader brClient = new BufferedReader(new InputStreamReader(
                s.getInputStream()));
        String client = brClient.readLine();
        System.out.println(client);

        // �ͷ���Դ
        br.close();
        s.close();
    }
}
