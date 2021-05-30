package university.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
/**
 * �����̲���һ
 * �� UDPSend���Ӧ
 * UDPЭ��������ݣ�
 *           A���������ն�Socket����
 *           B������һ�����ݰ�������������
 *           C������Socket����Ľ��շ�����������
 *           D���������ݰ�������ʾ�ڿ���̨
 *           E���ͷ���Դ
 */
public class UDPReceive {
    public static void main(String[] args) throws IOException {
        //�������ն�Socket����
        //DatagramSocket(int port)ֻ������գ�ֻ��������ݳ���Ķ˿ں�
        DatagramSocket ds = new DatagramSocket(12345);

        //����һ�����ݰ�(��������)
        //DatagramSocket(byte[] buf,int length)
        byte[] bys = new byte[1024];
        //int length = bys.length;
        DatagramPacket dp = new DatagramPacket(bys,bys.length);

        //����Socket����Ľ��ܷ�����������
        //public void receive(DatagramPacket p),����ʽ
        ds.receive(dp);

        //�������ݰ�������ʾ�ڿ���̨
        //��ȡ�Է���IP
        /*
        InetAddress address = dp.getAddress();
        String ip = address.getHostAddress();
        */
        //ʹ����ʽ���
        String ip = dp.getAddress().getHostAddress();


        //public byte[] getData():��ȡ���ݻ�����
        //public int getLength():��ȡ���ݵ�ʵ�ʳ���
        /*
        byte[] bys2 = dp.getData();
        int len = dp.getLength();
        String s  = new String(bys,0,len);
        */
        //��ʽ���
        String s = new String(dp.getData(),0,dp.getLength());

        System.out.println(ip+"���������ݽ�����Ϊ��"+s);

        //�ͷ���Դ
        ds.close();

    }
}
