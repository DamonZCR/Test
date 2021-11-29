package postgraduate.testRedis;

import redis.clients.jedis.Jedis;

public class TestRedisPing {
    public static void main(String[] args) {
        // 1、 new Jedis 对象即可.共19种构造方法
        Jedis je = new Jedis("192.168.53.130", 6379);
        // jedis 所有的命令就是我们之前学习的所有指令,只不过换为对象调用。
        System.out.println(je.ping());
    }
}
