package postgraduate.leetcd.qiuZhao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**海能达-20220926
 * 检测给定的一个字符串中DFJEIWFNQLEF0395823048010JDLSFJDLSJFKK，各个字母的频率是多少？
 * 输出从A-Z的各个频率：
 */
public class HaiNengDa_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("");
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            map.put(String.valueOf(Character.toUpperCase((char) (96 + i))), 0);
        }
        for (int i = 0; i < split.length; i++) {
            if (map.containsKey(split[i])){
                map.put(split[i], map.get(split[i]) + 1);
            }
        }
        Set<String> strings = map.keySet();
        Iterator<String> it = strings.iterator();
        while (it.hasNext()){
            String next = it.next();
            System.out.println(next + ":" + map.get(next));
        }
    }
}
