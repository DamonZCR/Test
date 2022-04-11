package postgraduate.leetcd.xunLian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 题目描述
 * 给你一个非递减的有序整数数组，已知这个数组中恰好有一个整数， 它的出现次数 超过 数组元素总数的25%。
 * 请你找到并返回这个整数。
 * 输入描述:
 * 1,2,2,6,6,6,6,7,10
 * 输出描述:
 * 6
 */
public class Frequency25 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        ArrayList<Integer> list = new ArrayList(s.length);
        HashMap<Integer, Integer> map = new HashMap(s.length);
        HashSet<Integer> set = new HashSet<>();

        Iterator it2 = set.iterator();
        while (it2.hasNext()){
            int next = (Integer)it2.next();
            int j = Collections.frequency(list, next);
            map.put(next, j);
        }
        for (int h = 0;h < map.size();h++){
            double res = (double)map.get(list.get(h)) / s.length;
            if (res > 0.25) {
                System.out.println(list.get(h));
                break;
            }
        }
    }
}
