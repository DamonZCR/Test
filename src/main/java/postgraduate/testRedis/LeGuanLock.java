package postgraduate.testRedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 利用redis实现抢购
 *     1、利用redis的watch功能，监控这个redisKey的状态值
 *     2、获取redisKey的值
 *     3、创建redis事务
 *     4、给这个key的值+1
 *     5、然后去执行这个事务，如果key的值被修改过则回滚，key不+1
 * 用java实现，开20个线程模拟10000个人并发来抢购
 */
public class LeGuanLock {
    public static void main(String[] arg){
        String redisKey = "redisTest";
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        try {
            Jedis jedis = new Jedis("192.168.53.130",6379);
            jedis.set(redisKey,"0");
            jedis.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        for (int i=0;i<10000;i++){
            executorService.execute(()->{
                Jedis jedis1 = new Jedis("192.168.53.130",6379);
                try {
                    jedis1.watch(redisKey);
                    String redisValue = jedis1.get(redisKey);
                    int valInteger = Integer.valueOf(redisValue);
                    String userInfo = UUID.randomUUID().toString();
                    if (valInteger<20){
                        Transaction transaction = jedis1.multi();
                        transaction.incr(redisKey);
                        List list = transaction.exec();
                        if (list != null && list.size() > 0){
                            System.out.println("用户："+userInfo+"，秒杀成功！当前成功人数："+(valInteger+1));
                        }else {
                            System.out.println("用户："+userInfo+"，秒杀失败");
                        }
                    }else {
                        System.out.println("已经有20人秒杀成功，秒杀结束");
                        System.exit(0);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    jedis1.close();
                }
            });
        }
        executorService.shutdown();
    }

}
