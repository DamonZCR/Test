package university.net;

import java.io.IOException;
import java.net.*;

/**
 *�����̲���һ
 * ʵ�ֻ��������ݷ��ͣ�����������������Ӧ����ʵ�ֽ��նˡ�����ˣ�
 * UDPЭ�鷢�����ݣ�
 *          A���������Ͷ�Socket����
 *          B:�������ݣ��������ݴ��
 *          C:����Socket����ķ��ͷ����������ݰ�
 *          D���ͷ���Դ��ʵ����IO����
 */
public class UDPSend {
    public static void main(String[] args) throws IOException {
        //�������Ͷ�Socket����
        //DatagramSocket()
        DatagramSocket ds = new DatagramSocket();

        //���ݴ��DatagramPacket(byte[] buf,int length,InetAddress address,int port)
        //��������
        byte[] bys = ("�����̲���Net").getBytes();
    /*
        //����
        int length = bys.length;
        //IP��ַ����
        InetAddress address = InetAddress.getByName("127.0.0.1");
        //�˿�
        int port = 12345;
        //���
        DatagramPacket dp = new DatagramPacket(bys,length,address,port);
    */
        //ʹ���Ż��Ĵ���
        DatagramPacket dp = new DatagramPacket(bys,bys.length,
                InetAddress.getByName("127.0.0.1"),12345);

        //����Socket����ķ��ͷ����������ݰ�
        //public void send(DatagramPacket p)����������ʹ��Datagrampacket��
        ds.send(dp);
        //�ͷ���Դ
        ds.close();
    }
}
