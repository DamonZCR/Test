package university.net;

import java.io.*;
import java.net.Socket;

/**
 * ʹ��TCPЭ��ʵ�ֿͻ�����Ļ�����������������ı��ļ�
 */
public class TCPFileCilent {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1",23456);

        //��װ��������
        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in));
        //��װͨ���ڵ��������Է������˵ķ���
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                s.getOutputStream()));

        String line = null;
        while((line = br.readLine()) != null){
            //������overʱ����������
            if ("over".equals(line)){
                break; }
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        s.close();

    }

}
