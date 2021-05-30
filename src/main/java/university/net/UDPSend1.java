package university.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * ����¼�����ݲ�������ն˷���
 */
public class UDPSend1 {
    public static void main(String[] args) throws IOException {
        //�������Ͷ�Socket����
        DatagramSocket ds = new DatagramSocket();

        //��װ����¼������
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String line = null;
        //whileʼ�����ж�ȡ����̨����Ļ���룬�ʵ��п���̨��������Զ����˳�while
        while ((line = br.readLine()) != null)
        //���ݴ��DatagramPacket(byte[] buf,int length,InetAddress address,int port)
        {
            //����886ʱ��ֹ����
            if("886".equals(line)){
                break;
            }
            byte[] bys = line.getBytes();
            DatagramPacket dp = new DatagramPacket(bys,bys.length,
                    InetAddress.getByName("127.0.0.1"),12345);

            //��������
            ds.send(dp);
        }
        //�ͷ���Դ
        ds.close();
    }
}
