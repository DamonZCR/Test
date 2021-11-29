package postgraduate.studyJava.testCollection;

import org.junit.Test;
import java.util.*;

public class TestMap {
    @Test
    public void test1(){
        // 遍历Map 实质就是遍历 entrySet() 返回的 Set集合；
        // 方法一：使用 forEach 遍历entrySet()；
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "11");
        map.put(2, "22");
        map.put(3, "33");

        System.out.println("使用forEach遍历 entrySet():");
        for (Map.Entry<Integer, String> entry: map.entrySet()) {
            int one = entry.getKey();
            String two = entry.getValue();
            System.out.println(one + "-----> "+ two);
        }
        // 方法二：使用 Iterator 遍历 entrySet()；
        System.out.println("使用forEach遍历 entrySet():");
        Set ent = map.entrySet();
        Iterator<Map.Entry<Integer, String>> it = ent.iterator();
        while (it.hasNext()){
            Map.Entry<Integer, String> next = it.next();
            int one = next.getKey();
            String two = next.getValue();
            System.out.println(one + "-----> "+ two);
        }
    }

    @Test
    public void test2(){
        // 重复key 值
        // key 值相同，value 值不同会被覆盖掉。
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "11");
        map.put(1, "22");
        map.put(2, "22");
        map.put(3, "33");
        System.out.println(map.size());

        Collection<String> val = map.values();
        Iterator<String> it = val.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }
    @Test
    public void test3(){
        // .getOrDefault() 方法，通过某一个键获取值，若此值不存在 就返回 指定值。
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "11");
        map.put(2, "22");
        map.put(3, "33");

        System.out.println(map.getOrDefault(4,"不存在！"));
    }
    @Test
    public void test4(){
        // 重要！
        // 统计数组中 元素出现的频率。
        String[] words = {"ab", "ac", "bb", "jj", "jj", "ad", "ab"};
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        System.out.println(cnt);
    }
}
