package university.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * ��InetAddress�ĳ�Ա������
 * public static InetAddress getByName(String host):��������������IP��ַ���ַ�����ʾ�õ�IP��ַ����
 *
 *���������������û�й��췽����
 * A:��Աȫ���Ǿ�̬��(Math,Arrays,Collections)
 * B:�������ģʽ(Runtime)
 * C:�����о�̬�������ظ���Ķ���(InetAddress)
 * 	  ���磺  class Demo {
 * 			private Demo(){}
 *
 * 			public static Demo getXxx() {
 * 				return new Demo();
 * 			}
 * 		}
 */
public class IPHostName {
    public static void main(String[] args) throws UnknownHostException {
        /*public static InetAddress getByName(String host)
         �ڸ���������host�������ȷ�������� IP ��ַ��
         �����������ǻ����������� IP ��ַ���ı���ʾ��ʽ
         ����ֵ�Ǹ�����������IP��ַ����
         */
        //InetAddress address = InetAddress.getByName("Damon-PC");
        InetAddress address = InetAddress.getByName("127.0.0.1");

        //��ȡ��������IP��ַ
        //public String getHostName()
        String name = address.getHostName();
        //public String getHostAddress()
        String ip = address.getHostAddress();
        System.out.println(name+"��IP��ַΪ"+ip);
    }
}
