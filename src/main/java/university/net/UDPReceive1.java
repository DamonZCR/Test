package university.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * �������ܷ��Ͷ˼�����������
 */
public class UDPReceive1 {
    public static void main(String[] args) throws IOException {
        //�������ն�Socket����
        DatagramSocket ds = new DatagramSocket(12345);
        System.out.println("����UDPSend1�������ӣ�������������");
        //����һ�����ݰ�(��������)
        while (true) {
            byte[] bys = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bys,bys.length);
            ds.receive(dp);
            //�������ݰ�������ʾ�ڿ���̨
            //��ȡ�Է���IP
            String ip = dp.getAddress().getHostAddress();
            String s = new String(dp.getData(), 0, dp.getLength());
            System.out.println(ip + "���������ݽ�����Ϊ��" + s);
        }
        //�ͷ���Դ
        //ds.close();

    }
}
