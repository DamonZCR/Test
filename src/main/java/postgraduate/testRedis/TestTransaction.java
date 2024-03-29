package postgraduate.testRedis;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestTransaction {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.53.130", 6379);
        jedis.flushDB();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello","world");
        jsonObject.put("name","Damon");
        // 开启事务
        Transaction multi = jedis.multi();

        String result = jsonObject.toJSONString();
        try {
            multi.set("user1",result);
            multi.set("user2",result);
            //int i = 1/0 ; // 代码抛出异常事务，执行失败！
            multi.exec(); // 执行事务！
        } catch (Exception e) {
            //multi.discard(); // 如果事务中出现异常，就放弃事务
            e.printStackTrace();
        } finally {
            System.out.println(jedis.get("user1"));//null
            System.out.println(jedis.get("user2"));//null
            jedis.close(); // 关闭连接
        }
    }
}
