package postgraduate.leetcd.qiuZhao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**富途笔试-20220918
 * 第一个输入一个数n，第二行输入n个数以空格隔开，
 * 牛牛有一个长度为n的数组a,牛牛可以对每一个元素执行一次+1或者-1的操作，或者不操作,出现次数最多的那个数的次数是？
 */
public class FuTu_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String[] s1 = br.readLine().split(" ");
        int[] num = new int[n];
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(s1[i]);
            if (map.containsKey(num[i])){
                map.put(num[i], map.get(num[i]) + 1);
                res = Math.max(map.get(num[i]), res);
            }else {
                map.put(num[i], 1);
            }
            res = Math.max(map.get(num[i]), res);
            if (map.containsKey(num[i] - 1)){
                map.put(num[i] - 1,map.get(num[i] - 1) + 1);
                res = Math.max(map.get(num[i] - 1), res);
            }else {
                map.put(num[i] - 1, 1);
            }
            if (map.containsKey(num[i] + 1)){
                map.put(num[i] + 1,map.get(num[i] + 1) + 1);
                res = Math.max(map.get(num[i] + 1), res);
            }else {
                map.put(num[i] + 1, 1);
            }
        }
        System.out.println(res);
    }
}
