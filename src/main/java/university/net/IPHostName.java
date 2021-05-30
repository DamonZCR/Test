package university.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * 看InetAddress的成员方法：
 * public static InetAddress getByName(String host):根据主机名或者IP地址的字符串表示得到IP地址对象
 *
 *下面三种情况的类没有构造方法：
 * A:成员全部是静态的(Math,Arrays,Collections)
 * B:单例设计模式(Runtime)
 * C:类中有静态方法返回该类的对象(InetAddress)
 * 	  比如：  class Demo {
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
         在给定主机名host的情况下确定主机的 IP 地址。
         主机名可以是机器名或者其 IP 地址的文本表示形式
         返回值是给定主机名的IP地址对象
         */
        //InetAddress address = InetAddress.getByName("Damon-PC");
        InetAddress address = InetAddress.getByName("127.0.0.1");

        //获取主机名、IP地址
        //public String getHostName()
        String name = address.getHostName();
        //public String getHostAddress()
        String ip = address.getHostAddress();
        System.out.println(name+"的IP地址为"+ip);
    }
}
